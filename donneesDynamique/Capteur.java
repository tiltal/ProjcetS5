package donneesDynamique;

public class Capteur {
	
	private String nomCapteur;
	private String typeFluide;
	private int etage;
	private String lieu;
	private String connecte;
	
	/* -------------------classe pour implementer la base de donnees-------------------*/
	
	/**
	 * @param nomCapteur
	 * @param typeFluide
	 * @param seuilMin
	 * @param seuilMax
	 */
	public Capteur(String nomCapteur, String typeFluide, int etage, String lieu, String connecte) {
		super();
		this.nomCapteur = nomCapteur;
		this.typeFluide = typeFluide;
		this.etage = etage;
		this.lieu = lieu;
		this.connecte = connecte;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Capteur) {
			Capteur capteur = (Capteur) obj;
			return nomCapteur.equals(capteur.getNomCapteur());
		}
		return false;
	}
	
	/**
	 * @param nomCapteur the nomCapteur to set
	 */
	public void setNomCapteur(String nomCapteur) {
		this.nomCapteur = nomCapteur;
	}
	/**
	 * @param typeFluide the typeFluide to set
	 */
	public void setTypeFluide(String typeFluide) {
		this.typeFluide = typeFluide;
	}
	
	/**
	 * @param etage the etage to set
	 */
	public void setEtage(int etage) {
		this.etage = etage;
	}

	/**
	 * @param lieu the lieu to set
	 */
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}

	public void setConnecte(String connecte) {
		this.connecte = connecte;
	}
	
	
	
	/**
	 * @return the nomCapteur
	 */
	public String getNomCapteur() {
		return nomCapteur;
	}
	/**
	 * @return the typeFluide
	 */
	public String getTypeFluide() {
		return typeFluide;
	}
	
	/**
	 * @return the etage
	 */
	public int getEtage() {
		return etage;
	}

	/**
	 * @return the lieu
	 */
	public String getLieu() {
		return lieu;
	}

	public String getConnecte() {
		return connecte;
	}


	
}
