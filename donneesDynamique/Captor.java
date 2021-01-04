 package donneesDynamique;

import java.util.*;

/**
 * 
 */
public class Captor {

    /**
     * Default constructor
     * @param id 
     * @param batiment 
     * @param etage 
     * @param lieu 
     * @param type
     */
    public Captor(String id, Batiment batiment, int etage, String lieu, TypeCaptor type) {
        // TODO implement here
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
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public float getBorneSup() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @return
     */
    public ArrayList<TimedValue> getValues() {
        // TODO implement here
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
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public boolean getOn() {
        // TODO implement here
        return true;
    }

    /**
     * @param inf 
     * @param max
     */
    public void setBornes(float inf, float max) {
        // TODO implement here
    }

}