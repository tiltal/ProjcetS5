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
     * Default constructor
     */
    public University() {
    }

    /**
     * 
     */
    private String Nom;

    private NavigableSet<Batiment> Batiments;
    
    private HashMap<String,Captor> Captors;
    
    private HashMap<TypeCaptor,NavigableSet<Captor>> CaptorFluids;
    

    /**
     * @param nom
     */
    public void University(String nom) {
        this.Nom = nom;
        this.Batiments = new TreeSet<>();
        this.Captors = new HashMap<>();
        this.CaptorFluids = new HashMap<>();
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

    /**
     * @return
     */
    public HashMap<String,Captor> getAllCaptors() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public HashMap<TypeCaptor, ArrayList<Captor>> getAllCaptorsFluid() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public ArrayList<Batiment> getBatiment() {
        // TODO implement here
        return null;
    }

}