package baseDonnees;

public class Valeur {
	
	private String date;
	private float valeur;
	private String typeFluide;
	private String nomCapteur;
	/**
	 * @param date
	 * @param valeur
	 * @param typeFluide
	 * @param nomCapteur
	 */
	public Valeur(String date, float valeur, String typeFluide, String nomCapteur) {
		super();
		this.date = date;
		this.valeur = valeur;
		this.typeFluide = typeFluide;
		this.nomCapteur = nomCapteur;
	}
	
	
	public boolean equals(Object obj) {
		if(obj instanceof Valeur) {
			Valeur valeur = (Valeur) obj;
			return date.equals(valeur.getDate());
		}
		return false;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @return the valeur
	 */
	public float getValeur() {
		return valeur;
	}
	/**
	 * @return the typeFluide
	 */
	public String getTypeFluide() {
		return typeFluide;
	}
	/**
	 * @return the nomCapteur
	 */
	public String getNomCapteur() {
		return nomCapteur;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @param valeur the valeur to set
	 */
	public void setValeur(float valeur) {
		this.valeur = valeur;
	}
	/**
	 * @param typeFluide the typeFluide to set
	 */
	public void setTypeFluide(String typeFluide) {
		this.typeFluide = typeFluide;
	}
	/**
	 * @param nomCapteur the nomCapteur to set
	 */
	public void setNomCapteur(String nomCapteur) {
		this.nomCapteur = nomCapteur;
	}
	
	public String toString() {
		String s =  "Valeur [ " + this.nomCapteur + " le " + this.date + " valeur : " + this.valeur + " ]";
		return s;
	}
	

}
