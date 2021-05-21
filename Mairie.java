package mairies;

import java.util.ArrayList;
import java.util.List;

public class Mairie implements InterfaceAffichage{
     
	private int id;
	private String nom;
	public List<Citoyen> citoyens=new ArrayList<Citoyen>();
	public List<Dece> deces=new ArrayList<Dece>();
	public List<Divorce> divorces=new ArrayList<Divorce>();
	public List<Mariage> mariages=new ArrayList<Mariage>();
	public List<Naissance> naissances=new ArrayList<Naissance>();
   {
		Citoyen v=new Citoyen(2,"ssssr","sdsldl",new Date("11/11/2222"),"m","celiaa","neant");
		Citoyen c=new Citoyen(1,"camaar","sdsldl",new Date("11/11/2222"),"m","celiaa","neant");
	    citoyens.add(c);
	 	citoyens.add(v);
	}
	public Mairie(int id,String nom,Citoyen citoyen){
		this.nom = nom;
		this.id = id;
		this.citoyens.add(citoyen);
	}
	
    public Mairie() {
		
	}
	public Mairie(int id,String nom) {
		 this.id=id;
		 this.nom=nom;
	}
	
	public void afficher() {
		System.out.println("nom mairie "+nom+" id mairie"+ id);
	}
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Citoyen> getCitoyens() {
		return citoyens;
	}

	public void setCitoyens(Citoyen citoyen) {
		this.citoyens.add(citoyen);
	}

	public List<Dece> getDeces() {
		return deces;
	}

	public void setDeces(Dece dece) {
		this.deces.add(dece);
	}

	public List<Divorce> getDivorces() {
		return divorces;
	}

	public void setDivorces(Divorce divorce) {
		this.divorces.add(divorce);
	}

	public List<Mariage> getMariages() {
		return mariages;
	}

	public void setMariages(Mariage mariage) {
		this.mariages.add(mariage);
	}

	public List<Naissance> getNaissances() {
		return naissances;
	}

	public void setNaissances(Naissance naissance) {
		this.naissances.add(naissance);
	}
	
	
}
