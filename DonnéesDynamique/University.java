package DonnéesDynamique;

import java.util.*;

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




    /**
     * @param nom
     */
    public void University(String nom) {
        // TODO implement here
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
    public Map<String,Captor> getAllCaptors() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Map<TypeCaptor, ArrayList<Captor>> getAllCaptorsFluid() {
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