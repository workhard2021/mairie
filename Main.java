package mairies;

import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		Registre r=new Registre();
		Scanner entrer=new Scanner(System.in);
		Citoyen p=new Citoyen();
		boolean valid=true;
		Main.afficherMenu();
		do{
			
			int choix=entrer.nextInt();
			switch(choix) {
			        case 1:
			        	 try {
	                          r.mariage();
	                          System.out.println("Entre votre choix entre 0 et 12\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 2:
			        	 try {
                          r.divorce();
                          System.out.println("Entre votre choix entre 0 et 10\n");
                          
			        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
			        	break;
			        case 3:
			        	 try {
	                          r.naissance();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 4:
			        	 try {
	                          r.etatCivilPersonne();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 5:
			        	 try {
	                          r.afficher();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 6:
			        	 try {
	                          r.afficherMariages();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 7:
			        	 try {
	                          r.afficherDivorces();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        	
			        case 8:
			        	 try {
	                          r.afficherNaissances();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 9:
			        	 try {
	                          r.afficherDeces();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        	
			        case 10:
			        	 try {
	                          r.afficherActeNaissance();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 11:
			        	 try {
	                          r.dece();
	                          System.out.println("Entre votre choix entre 0 et 10\n");
				        	 }catch(ExceptionMairie e) {System.out.println(e.getMessage());}
				        	break;
			        case 12:
			       
	                       r.saisirPersonne();
	                       System.out.println("Entre votre choix entre 0 et 10\n");
				        	
				        	break;
			        	
			        case 0:
			        	valid=false;
			        	System.out.println("exit programme");
			        	break;
			        	
			        default:
			        	System.out.println("Une erreur de choix\n");
			        	System.out.println("Entre votre choix entre 0 et 10\n");
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
				+ "Tapez 11 pour declarer un décè\n"
				+ "Tapez 12 pour saisir une personne \n"
				
				);
	}

}
