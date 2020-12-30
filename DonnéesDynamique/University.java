package DonnéesDynamique;


import java.util.NavigableSet;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 * 
 */
public class University extends AbstractModel {



    /**
     * 
     */
    //attributes
    private String Nom;

    private NavigableSet<Batiment> Batiments;
    
    private HashMap<String,Captor> Captors;
    
    private HashMap<TypeCaptor,NavigableSet<Captor>> CaptorFluids;
    
    /**
     * Constructor
     */
    public University(String nom) {
        this.Nom = nom;
        this.Batiments = new TreeSet<>();
        this.Captors = new HashMap<>();
        this.CaptorFluids = new HashMap<>();
    }

    
    
    //getters
    /**
     * @return a copy of Captors
     */
    public HashMap<String,Captor> getAllCaptors() {
        HashMap<String,Captor> copy = new HashMap<String,Captor>(this.Captors);
        return copy;
    }

    /**
     * @return
     */
    public HashMap<TypeCaptor, NavigableSet<Captor>> getAllCaptorsFluid() {
        HashMap<TypeCaptor,NavigableSet<Captor>> copy = new HashMap<TypeCaptor,NavigableSet<Captor>>(this.CaptorFluids);
        return copy;
    }

    /**
     * @return
     */
    public NavigableSet<Batiment> getBatiment() {
        NavigableSet<Batiment> copy = new TreeSet<Batiment>(this.Batiments);
        return copy;
    }
    
    public String getNom() {
    	return this.Nom;
    }
    
    
    /**
     * @param id 
     * @param value
     */
    public void newValue(String id, float value) {
        // TODO implement here
    }

    /**
     * @param id 
     * @param batiment 
     * @param etage 
     * @param lieu 
     * @param type
     */
    public void connexion(String id, String batiment, int etage, String lieu, String type) {
        // TODO implement here
    }

    /**
     * @param id
     */
    public void deconnexion(String id) {
        // TODO implement here
    }

    /**
     * @param id 
     * @param inf 
     * @param sup
     */
    public void changeBornes(String id, float inf, float sup) {
        // TODO implement here
    }


    

}