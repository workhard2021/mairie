package mairies;

public class Dece extends Evenement {
	
	private Citoyen citoyen;
	
	public void afficher() {
		System.out.println(this.toString());
	}

	public Dece(Citoyen citoyen,Date date,String lieu,String nomMairie) {
		this.citoyen = citoyen;
		this.setDate(date);
		this.setLieu(lieu);
		this.setNomMairie(nomMairie);
	}
	
	public Dece() {}

	@Override
	public String toString() {
	  	String event=super.toString();
		return "Dece [citoyen=" + citoyen + "] " +event;
	}

	public Citoyen getCitoyen() {
		return citoyen;
	}

	public void setCitoyen(Citoyen citoyen) {
		
		this.citoyen = citoyen;
	}
	
}
