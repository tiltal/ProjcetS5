package donneesDynamique;

import java.sql.Time;
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
    public Captor(String id, String batiment, int etage, String lieu, TypeCaptor type) {
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
    
    public Captor(String id, String batiment, int etage, String lieu, String type) {
        this.id = id;
        this.batiment = batiment;
        this.etage = etage;
        this.lieu = lieu;
        this.type = findType(type);
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
    private String batiment;

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



    private TypeCaptor findType(String type) {
        TypeCaptor typec;
    	switch(type) {
        case "EAU":
        	typec = TypeCaptor.EAU;
        	break;
        case "ELECTRICITE":
        	typec = TypeCaptor.ELECTRICITE;
        	break;

        case "AIRCOMPRIME":
        	typec = TypeCaptor.AIRCOMPRIME;
        	break;

        default:
        	typec = TypeCaptor.TEMPERATURE;
        	break;
        
        
        }
    	return typec;
    }
    
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
        return new ArrayList<TimedValue>(Arrays.asList(new TimedValue(-5.0f, "2014-12-03T10:15:30.00Z"), new TimedValue(16.0f, "2014-12-03T10:15:35.00Z")));
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
    

    public String getBatiment() {
		return batiment;
	}

	public int getEtage() {
		return etage;
	}

	public String getLieu() {
		return lieu;
	}

	public TypeCaptor getType() {
		return type;
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