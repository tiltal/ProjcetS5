package donneesDynamique;


import java.util.*;

/**
 * 
 */
public class Captor implements Comparable<Captor> {

    /**
     * Default constructor
     * @param id 
     * @param batiment 
     * @param etage 
     * @param lieu 
     * @param type
     */
    public Captor(String id, Batiment batiment, int etage, String lieu, TypeCaptor type) {
        this.id = id;
        this.batiment = batiment;
        this.etage = etage;
        this.lieu = lieu;
        this.type = type;
        this.on = true;
        this.etat = 0;
        switch(this.type) {
        case EAU:
        	this.borneMin = 0;
        	this.borneMax = 10;
        	break;
        case ELECTRICITE:
        	this.borneMin = 10;
        	this.borneMax = 500;
        	break;

        case AIRCOMPRIME:
        	this.borneMin = 17;
        	this.borneMax = 22;
        	break;

        default:

        	this.borneMin = 0;
        	this.borneMax = 5;
        	break;
        
        
        }
    }

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private int etat;

    /**
     * 
     */
    private boolean on;

    /**
     * 
     */
    private Batiment batiment;

    /**
     * 
     */
    private int etage;

    /**
     * 
     */
    private float borneMin;

    /**
     * 
     */
    private float borneMax;

    /**
     * 
     */
    private String lieu;
    
    private TypeCaptor type;



    
    
    public void connexion(){
    	this.on = true;
    }
    
    public void deconnexion(){
    	this.on = false;
    }


    /**
     * @return
     */
    public float getBorneInf() {
        return borneMin;
    }

    /**
     * @return
     */
    public float getBorneSup() {
        return borneMax;
    }

    /**
     * @return
     */
    public ArrayList<TimedValue> getValues() {
        return null;
    }

    /**
     * @return
     */
    public TimedValue getLastValue() {
        // TODO implement here
        return null;
    }

    /**
     * @param valeur
     */
    public void addValue(float valeur) {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getEtat() {
        return this.etat;
    }

    /**
     * @return
     */
    public boolean getOn() {
        return this.on;
    }
    
    public String getId() {
    	return this.id;
    }

    /**
     * @param inf 
     * @param max
     */
    public void setBornes(float inf, float max) {
    	this.borneMin = inf;
    	this.borneMax = max;
    }

	@Override
	public String toString() {
		return "Captor [id=" + id + ", etat=" + etat + ", on=" + on + ", batiment=" + batiment + ", etage=" + etage
				+ ", borneMin=" + borneMin + ", borneMax=" + borneMax + ", lieu=" + lieu + ", type=" + type + "]";
	}

	@Override
	public int compareTo(Captor capt2) {
		return this.id.compareTo(capt2.getId());
	}

}