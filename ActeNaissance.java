package mairies;

public class ActeNaissance {

	private Citoyen citoyen;
	private Dece dece;
	private Mariage mariage;
	private Divorce divorce;
	private Naissance naissance;
	
	public ActeNaissance() {}
	public ActeNaissance(Citoyen citoyen, Dece dece, Mariage mariage, Divorce divorce,Naissance naissance) {
		
		this.citoyen = citoyen;
		this.dece = dece;
		this.mariage = mariage;
		this.divorce = divorce;
		this.naissance=naissance;
	}


	public Citoyen getCitoyen() {
		return citoyen;
	}


	public void setCitoyen(Citoyen citoyen) {
		this.citoyen = citoyen;
	}


	public Dece getDece() {
		return dece;
	}


	public void setDece(Dece dece) {
		this.dece = dece;
	}


	public Mariage getMariage() {
		return mariage;
	}


	public void setMariage(Mariage mariage) {
		this.mariage = mariage;
	}


	public Divorce getDivorce() {
		return divorce;
	}


	public void setDivorce(Divorce divorce) {
		this.divorce = divorce;
	}

	public Naissance getNaissance() {
		return naissance;
	}

	public void setNaissance(Naissance naissance) {
		this.naissance = naissance;
	}

	@Override
	public String toString() {
		return "ActeNaissance [citoyen=" + citoyen + ", dece=" + dece + ", mariage=" + mariage + ", divorce=" + divorce
				+ ", naissance=" + naissance + "]";
	}


	
	
}
