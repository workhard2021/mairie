package mairies;

import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		Registre r=new Registre();
		Scanner entrer=new Scanner(System.in);
		boolean valid=true;
		Main.afficherMenu();
		do{
			
			int choix=entrer.nextInt();
			switch(choix) {
			        case 1:
			        	 try {
	                          r.mariage();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 2:
			        	 try {
                          r.divorce();
			        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
			        	break;
			        case 3:
			        	 try {
	                          r.naissance();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 4:
			        	 try {
	                          r.etatCivilPersonne();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 5:
			        	 try {
	                          r.afficher();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 6:
			        	 try {
	                          r.afficherMariages();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 7:
			        	 try {
	                          r.afficherDivorces();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        	
			        case 8:
			        	 try {
	                          r.afficherNaissances();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 9:
			        	 try {
	                          r.afficherDeces();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        	
			        case 10:
			        	 try {
	                          r.afficherActeNaissance();
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        	
			        case 0:
			        	valid=false;
			        	System.out.println("exit programme");
			        	break;
			        	
			        default:
			        	System.out.println("Une erreur de choix");
			}
			
		}while(valid);
		entrer.close();
		
	}
	
	public static void afficherMenu() {
		System.out.println("Tapez 0 pour quitter le programme \n"
				+ "Tapez 1 pour declarer margiage\n"
				+ "Tapez 2 pour divorce \n"
				+ "Tapez 3 pour declarer naissance \n"
				+ "Tapez 4 pour declarer etatCivil \n"
				+ "Tapez 5 pour declarer afficher tout les citoyen \n"
				+ "Tapez 6 pour afficher la liste du mariage \n"
				+ "Tapez 7 pour afficher la liste de divorce \n"
				+ "Tapez 8 pour afficher la liste de naissance \n"
				+ "Tapez 9 pour afficher la liste de décè \n"
				+ "Tapez 10 pour afficher l'acte de naissance \n"
				
				);
	}

}
