package donneesDynamique;

import baseDonnees.Memoire;
import java.util.List;
import java.util.NavigableSet;
import java.util.HashMap;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Iterator;

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
    
    private Memoire memoire;
    /**
     * Constructor
     */
    public University(String nom) {
    	this.memoire =  new Memoire();
        this.Nom = nom;
        this.Batiments = new TreeSet<>();
        this.Captors = new HashMap<>();
        this.CaptorFluids = new HashMap<>();
        Instancing();
    }
    
    private void Instancing() {
    	CaptorFluids.put(TypeCaptor.EAU, new TreeSet<Captor>());
    	CaptorFluids.put(TypeCaptor.AIRCOMPRIME, new TreeSet<Captor>());
    	CaptorFluids.put(TypeCaptor.ELECTRICITE, new TreeSet<Captor>());
    	CaptorFluids.put(TypeCaptor.TEMPERATURE, new TreeSet<Captor>());
    	List<Captor> caps = memoire.getCap();
    	Captor captor;
    	Batiment bat;
    	for (Iterator<Captor> iter = caps.iterator(); iter.hasNext();) {
    		captor = iter.next();
    		if (!this.Batiments.contains(new Batiment(captor.getBatiment()))){
    			bat = new Batiment(captor.getBatiment());
    			bat.addCaptor(captor);
    			Batiments.add(bat);
    		}
    		else {
    			this.Batiments.headSet(new Batiment(captor.getBatiment()), true).first().addCaptor(captor);
    		}
    		this.Captors.put(captor.getId(), captor);
    		this.CaptorFluids.get(captor.getType()).add(captor);
    		
    	}
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
     * @return a copy of CaptorsFluids
     */
    public HashMap<TypeCaptor, NavigableSet<Captor>> getAllCaptorsFluid() {
        HashMap<TypeCaptor,NavigableSet<Captor>> copy = new HashMap<TypeCaptor,NavigableSet<Captor>>(this.CaptorFluids);
        return copy;
    }

    /**
     * @return a copy of Batiments
     */
    public NavigableSet<Batiment> getBatiment() {
        NavigableSet<Batiment> copy = new TreeSet<Batiment>(this.Batiments);
        return copy;
    }
    
    /**
     * @return Nom
     */
    public String getNom() {
    	return this.Nom;
    }
    
    
    
    //methods
    /**
     * @param id 
     * @param value
     */
    public void newValue(String id, float value) {
        TimedValue tval= new TimedValue(value, id);
        Captors.get(id).addValue(tval);
        memoire.addValue(tval, id);
    }

    /**
     * @param id 
     * @param batiment 
     * @param etage 
     * @param lieu 
     * @param type
     */
    public void connection(String id, String batiment, int etage, String lieu, String type) {
    	if(! Captors.containsKey(id)) {
    		newCaptor(id, batiment, etage, lieu, type);
    	}
    	Captors.get(id).connexion();
    }
    
    private void newCaptor(String id, String batiment, int etage, String lieu, String type) {
    	String s;
    	Batiment bat = null;
        Captor capt;
        TypeCaptor typec = findType(type);
        boolean  get = false;
    	for(Iterator<Batiment> iter = Batiments.iterator(); iter.hasNext() && get == false;) {
        	bat = iter.next();
        	if(bat.getName() == batiment) {
        		get = true;
        	}
        }
    	if(get == false){
    		bat = new Batiment(batiment);
    		this.Batiments.add(bat);
    		capt = new Captor(id, bat.toString(),etage,lieu,typec);
    	}
    	else{
    		capt = new Captor(id,bat.toString(),etage,lieu,typec);
    	}
    	
    	bat.addCaptor(capt);
    	Captors.put(id, capt);
    	CaptorFluids.get(typec).add(capt);
    	
    	memoire.addCap(capt);
    }
    
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

    /**
     * @param id
     */
    public void disconnection(String id) {
        Captors.get(id).deconnexion();
    }

    /**
     * @param id 
     * @param inf 
     * @param sup
     */
    public void changeBornes(String id, float inf, float sup) {
        this.Captors.get(id).setBornes(inf, sup);
        memoire.changeBornes(inf, sup,id);
    }

	@Override
	public String toString() {
		return "University [Nom=" + Nom + ", Batiments=" + Batiments + ", Captors=" + Captors +"]";
	}
	
	
   

}