package baseDonnees;

import java.util.List;

public class Capteur {
	
	private String nomCapteur;
	private String typeFluide;
	private String nomBatiment;
	private int etage;
	private String lieu;
	private String connecte;
	private List<Valeur> valeurs;
	
	/**
	 * @param nomCapteur
	 * @param typeFluide
	 * @param seuilMin
	 * @param seuilMax
	 */
	public Capteur(String nomCapteur, String typeFluide, String nomBatiment, int etage, String lieu, String connecte, List<Valeur> valeurs) {
		super();
		this.nomCapteur = nomCapteur;
		this.typeFluide = typeFluide;
		this.nomBatiment = nomBatiment;
		this.etage = etage;
		this.lieu = lieu;
		this.connecte = connecte;
		this.valeurs = valeurs;
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
	 * @return the valeurs
	 */
	public List<Valeur> getValeurs() {
		return valeurs;
	}

	/**
	 * @param valeurs the valeurs to set
	 */
	public void setValeurs(List<Valeur> valeurs) {
		this.valeurs = valeurs;
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

	/**
	 * @return the nomBatiment
	 */
	public String getNomBatiment() {
		return nomBatiment;
	}

	/**
	 * @param nomBatiment the nomBatiment to set
	 */
	public void setNomBatiment(String nomBatiment) {
		this.nomBatiment = nomBatiment;
	}


	
}
