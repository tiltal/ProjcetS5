package donneesDynamique;

public class BatimentBD implements Comparable<BatimentBD>{
	
	private String nomBat;
	
	/**
	 * @param nomBat
	 * @param numEtage
	 * @param nomPiece
	 */
	public BatimentBD(String nomBat) {
		super();
		this.nomBat = nomBat;
	}
	
	public int compareTo(BatimentBD batToCompare) {
		return nomBat.compareTo(batToCompare.nomBat);
	}

	/**
	 * @return the nomBat
	 */
	public String getNomBat() {
		return nomBat;
	}

	/**
	 * @param nomBat the nomBat to set
	 */
	public void setNomBat(String nomBat) {
		this.nomBat = nomBat;
	}
	
	
}
