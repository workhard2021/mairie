package mairies;
import java.util.Scanner;

public class Registre {
    
    Scanner entrer= new Scanner(System.in);
    public Citoyen citoyen;
    public Mairie mairie;
    
   
    public  Registre() {
    	this.mairie=new Mairie(1,"mairie Lyon");
    }
    
	public void afficher()throws ExceptionMairie  {
		
		for(Citoyen p: this.mairie.getCitoyens()) {
			
			  System.out.println(p);
	    }
		
		if(this.mairie.getCitoyens().size()==0){
			throw new ExceptionMairie("Aucun enregistrement");
		}
		
	}
	
	
	public void divorce() throws ExceptionMairie {
		
		 boolean valid=true;
	     System.out.println("Entrer id de la personne reclamant divorce");
		 int id=entrer.nextInt();
		 Citoyen p=this.rechercher(id);
		 Citoyen p2;
		 
		
	     if(p==null) {
	    	  throw new ExceptionMairie("cette personne existe pas");
	     }else{
	    	 
	    	 if(p.getIdConjoint()==0) {
	    		 
	    		  throw new ExceptionMairie("cette personne s'est pas mariée");
	    	 }else {
	    		 

			     System.out.println("Voulez vous changer non d'usage? oui/non");
			     String u=entrer.next();
			     if(u=="oui") {
			    	 
			    	  if(p.getSexe()=="f" || p.getSexe()=="F") {
			    		     
			    		    Citoyen c;
				    	    for(int i=0;i<this.mairie.naissances.size();i++) {
				    	    	     c=this.mairie.naissances.get(i).getCitoyen();
				    	    	     
				    	    	     if(c.getId()==p.getId()) {
				    	    	    	   p.setNomUsage(c.getNom());
				    	    	     }
				    	    }
			    	  }
			    	  	 
			     }
	    		  
	    		  //initialiser idConjoint(e) mari(e);
	    		  p.setEtatCivil("Divorcé");
	    		  p2=this.rechercher(p.getIdConjoint());
	    		  p2.setEtatCivil("Divorcé");
	    		  p2.setIdConjoint(0);
	    		  p.setIdConjoint(0);
	    		  
	    		  
	    		  System.out.println("Entrer la date");
	    		  
	    		  String d=entrer.next();
	    		 
	    		  Date date=new Date(d);
	    		  do {
	    			  if(date.dateValid()){ 
		    			  this.mairie.setDivorces(new Divorce(p,date,this.mairie.getNom()));
					      System.out.println(p);
					      valid=false;
					      
					      for(int i=0;i<this.mairie.mariages.size();i++){
					    	   
					    	    Mariage m=this.mairie.mariages.get(i);
					    	    if(m.getCitoyen1().getId()==p.getId() || m.getCitoyen2().getId()==p.getId()) {
					    		       this.mairie.mariages.remove(i);
					    	    }
					      }
					     
		    		  }else {
		    			  throw new ExceptionMairie("Veuillez respecter le format : jour(xx)/mois(xx)/année(xxxx)");
		    		  }
	    		  }while(valid);
	    		  
	    		  
	    	 }
	    	 
	     }
	     	 
	}
	
	public void mariage() throws ExceptionMairie{
		
	     System.out.println("Entrer id de l'epouse");
		 int idMarie=entrer.nextInt();
		 System.out.println("Entrer id de mari");
		 int idMari=entrer.nextInt();
	
		 Citoyen marie=this.rechercher(idMarie);
		 Citoyen  mari=this.rechercher(idMari);
		 
		 boolean validMarie=true;
		 boolean validMari=true;
		 
			  if(marie==null || mari==null) {
				  
				 if(marie==null) {
					 
					  throw new ExceptionMairie("marié existe pas avec id "+idMarie);
					 
				 }
				 if(mari==null) {
					 
					  throw new ExceptionMairie("marié existe pas avec id "+idMari);
				 } 
				  
			  }else {
				    
				     if(marie.getIdConjoint()==0){
						 validMarie=false;
				     }else {
				     
				        throw new ExceptionMairie("Cette personne est déja mariée  avec id "+idMarie);
				     }
				     
				     if(mari.getIdConjoint()==0){
						 validMari=false;
				     }else {
				    	  throw new ExceptionMairie("Cette personne est déja mariée  avec id "+idMari);
				        
				     }
				     
				     if(validMari==false && validMarie==false){
				    	 
				    	 marie.setEtatCivil("Mariée");
				    	 mari.setEtatCivil("Marié");
				    	 marie.setNomUsage(mari.getNom());
				    	 
				    	 
				    	 marie.setIdConjoint(mari.getId());
				    	 mari.setIdConjoint(marie.getId());
				    	 
				    	 marie.setConjointlistes(mari);
				    	 mari.setConjointlistes(marie);
				    	 
				    	 
				    	 System.out.println("Entre le lieu de mariage");
				    	 String lieu=entrer.next();
				    	 
				    	 System.out.println("Entre la date");
				    	 String date=entrer.next();
				    	 
				    	
				    
				    	 Mariage mariage=new Mariage(mari,marie,new Date(date),lieu,this.mairie.getNom());
				    	 this.mairie.mariages.add(mariage);
				    	 marie.setNomUsage(mari.getNom());
				         
						 System.out.println("Mr "+mari.getNom()+" et Mm "+ marie.getNom()+" sont déclarés marié");  
				    }
			  }
   
	}
	
	public void naissance() throws ExceptionMairie{
	 
	
		boolean idPereValid=true;
		boolean idMereValid=true;
		boolean lieuValid=true;
		
		
		Naissance naissance= new Naissance();
		Citoyen citoyen=new Citoyen();
	    //id Pere ET Mere
			 do{
				  System.out.println("Entrer id  pere");
				  int idPere=entrer.nextInt();
				  if(idPere<0) {
					  
					  throw new ExceptionMairie("Erreur=> veuillez entre un id valide");
					  
				  }else {
					  idPereValid=false;
					  naissance.setIdParent1(idPere);
				   }
				  
		     }while(idPereValid);
			 

			    //id mere
			 do {
				  System.out.println("Entrer id mere ");
				  int idMere=entrer.nextInt();
				  if(idMere<0) {
					  throw new ExceptionMairie("Erreur=> veuillez entre un id valide");
				  }else {
					  idMereValid=false;
					  naissance.setIdParent2(idMere);
				  }
				  
		   }while(idMereValid);
			 
			   //lieu
			 do {
				  System.out.println("Entrer le lieu de naissance ");
				  String lieu=entrer.next();
				  if(lieu.length()>0) {
					  lieuValid=false;
					  naissance.setLieu(lieu);
				  }
				  
		   }while(lieuValid);
			   
		    citoyen=this.saisir(citoyen);
		    naissance.setDate(citoyen.getDate());
		    naissance.setNomMairie(this.mairie.getNom());
		    this.mairie.citoyens.add(citoyen);
		    naissance.setCitoyen(citoyen);
		    this.mairie.naissances.add(naissance);
		     
	}
	
	public void etatCivilPersonne() throws ExceptionMairie{

	     System.out.println("Entrer id d'une personne pour connaitre son etat civil");
		 int id=entrer.nextInt();
		 Personne p=this.rechercher(id);
		 if(p==null) {
			  
               throw new ExceptionMairie("erreur=>Cette personne n'existe pas");
		 }else {
			 System.out.println(p);
		 }
	}
	
	public Citoyen rechercher(int id) {
		
		 
		 for(Citoyen p: this.mairie.getCitoyens()) {
			   
			   if(id==p.getId()){
				   
				   return p;
			    }   
		  }
		 
		 return null;
		
	}
	
	
	public Citoyen saisir(Citoyen p){
			
				
			boolean nomValid=true;
			boolean prenomValid=true;
			boolean dateValid=true;
			boolean sexeValid=true;
			boolean etatCivilValid=true;
			
			do {
				  System.out.print("Entre le nom ");
				  String nom=entrer.next();
				   
				  if(nom.length()<2) {
					  System.out.println("le nom doit etre composé de plus de de caractère");
				  }else {
					  nomValid=false;
					  p.setNom(nom);
			}
				  
	    	 }while(nomValid);
			
			  //prenom de la personne
			 do {
				  System.out.print("Entre le prenom");
				  String prenom=entrer.next();
				 
				  if(prenom.length()<2) {
					  System.out.println("le prenom doit etre composé de plus de 2 caractère");
				  }else {
					  prenomValid=false;
					  p.setPrenom(prenom);
				  }
				  
	  	      }while(prenomValid);
			  		
		     // date de naissance
			 
			 do{
		    	   System.out.print("Entre date de naissance");
				   String date=entrer.next();
				  Date dates=new Date(date);
				  if(!dates.dateValid()) {
					  System.out.print("Veuillez respecter le format : jour(xx)/mois(xx)/année(xxxx)");
				  }else {
					  
					  dateValid=false;
					  p.setDate(dates);
				  }
				  
	  	      }while(dateValid);
			 
			  //entrer sexe
			 
			 do {
				  System.out.println("Entre le sexe");
				  String sexe=entrer.next();
				  
				  if(sexe.length()<1) {
					  System.out.print("Erreur=> veuillez entrer sexe");
				  }else {
					  sexeValid=false;
					  p.setSexe(sexe);
				  }
				  
	  	     }while(sexeValid);
			 
			    //etat civil
			 do {
				  System.out.println("Entre l'etat civil de la personne");
				   String etatCivil=entrer.next();
				  if(etatCivil.length()<0) {
					  System.out.print("Erreur=> etat civil doit etre composé moins 1 caractères");
				  }else {
					  etatCivilValid=false;
					  p.setEtatCivil(etatCivil);
				  }
				  
	  	     }while(etatCivilValid);
			
			 p.setId(this.mairie.getCitoyens().size()+1);
			 return p;
			        
		}
	
       public void afficherDivorces() throws ExceptionMairie {
		
		for(Divorce p: this.mairie.getDivorces()) {
			
			  System.out.println(p);
	    }
		
		if(this.mairie.getDivorces().size()==0){
			
			throw new ExceptionMairie("Aucun enregistrement de divorce");
		}
		
	  }
       
       public void dece() throws ExceptionMairie {
    	   
 
    	      boolean b=true;
    	      boolean c=true;
    	      
    	      Dece d=new Dece();
    	      Citoyen citoyen=new Citoyen();
    	      Citoyen conjoint=new Citoyen();
    	       //date
    	      do{
		    	   System.out.print("Entre date de dece");
		    	   
				   String date=entrer.next();
				  Date dates=new Date(date);
				  if(!dates.dateValid()) {
					  System.out.print("Veuillez respecter le format : jour(xx)/mois(xx)/année(xxxx)");
				  }else {
					  
					  c=false;
					  d.setDate(dates);
				  }
				  
	  	      }while(c);
    	       //id dece
    	      do{
    	    	   System.out.print("Enter id de la personne décédée");
    	    	   int id=entrer.nextInt();
    	    	   if(0<id) {
    	    		    b=false;
    	    		    if(this.rechercher(id)!=null) {
    	    		    	
    	    		    	 d.setCitoyen(this.rechercher(id));
    	    		    	 this.mairie.deces.add(d);
    	    		    	 citoyen.setConjointlistes(this.rechercher(id));
    	    		    	
    	    		    	 for(int i=0;i<citoyen.conjointlistes.size();i++){
    	    		    		   conjoint =citoyen.conjointlistes.get(i);
    	    		    		  
    	    		    		   if(conjoint.getId()==citoyen.getIdConjoint()) {
    	    		    			     if(conjoint.getSexe()=="f" || conjoint.getSexe()=="F") {
    	    		    			    	   this.mairie.citoyens.get(i).setEtatCivil("Veuve");
    	    		    			     }else {
    	    		    			    	  this.mairie.citoyens.get(i).setEtatCivil("Veuve");
    	    		    			     }
    	    		    			     
    	    		    		   }   
    	    		    	 }
    	    		        for(int k =0;k<this.mairie.citoyens.size();k++) {
    	    		        	
    	    		    	            Citoyen temp=this.mairie.citoyens.get(k);
    	    		    	            if(temp.getId()==id){
    	    		    	            	 this.mairie.citoyens.remove(k);	
    	    		    	            }
    	    		        }
    	    		          
    	    		       
    	    		    	 
    	    		    }else {
    	    		    	 throw new ExceptionMairie("cet id existe pas");	
    	    		    }
    	    		    
    	    		    
    	    	   }else {
    	    		   throw new ExceptionMairie("cet id existe pas");
    	    	   }
    	    	  
    	      }while(b);
    	      
       }
       
       public void afficherDeces() throws ExceptionMairie {
   		
   		for(Dece p: this.mairie.getDeces()) {
   			
   			  System.out.println(p);
   	    }
   		
   		if(this.mairie.getDeces().size()==0){
   			
   		  throw new ExceptionMairie("Aucun enregistrement de décè");
   		}
   		
   	  }
       
       
      public void afficherNaissances() throws ExceptionMairie {
      		
      		for(Naissance p: this.mairie.getNaissances()) {
      			
      			  System.out.println(p);
      	    }
      		
      		if(this.mairie.getNaissances().size()==0){
      			
      		  throw new ExceptionMairie("Aucun enregistrement de naissance");
      		}
      		
      }
      
      public void afficherMariages() throws ExceptionMairie {
    		
    		for(Mariage p: this.mairie.getMariages()) {
    			
    			  System.out.println(p);
    	    }
    		
    		if(this.mairie.getMariages().size()==0){
    			  throw new ExceptionMairie("aucun enregistrement de mariage");
    		}		
       }
      
       public void afficherActeNaissance() throws ExceptionMairie {
          int nbrEnfant=0;
         
  	     System.out.println("Entrer id d'une personne pour connaitre son etat civil");
  	     
  		 int id=entrer.nextInt();
  		 Citoyen p=this.rechercher(id);
  		
  		 if(p==null) {
  			      throw new ExceptionMairie("erreur=>Cette personne n'existe pas");
  		 }else {
  			if(!p.getEnfant().isEmpty()) {
  				for(Citoyen e:p.getEnfant()) {
  					 nbrEnfant=nbrEnfant+1;
  				}
  			}  
  		 }
  		 
  		
  		 System.out.println("nom ="+p.getNom()+ "\n prenom ="+p.getPrenom()
  			 +"\n etat civil "+p.getEtatCivil()+" \n date de naissance ="+p.getDate()
  			 +"nombre d'enfant "+nbrEnfant +" pour plus d'info"+p
  			);
  		
    }
     public void saisirPersonne(){
    	
    	    Citoyen c=new Citoyen();
    	    c=this.saisir(c);
    	    this.mairie.citoyens.add(c);
    	
     }
     
 			
}
    