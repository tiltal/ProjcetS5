 package DonnéesDynamique;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Map;

/**
 * 
 */
public class Batiment {

    /**
     * Default constructor
     */


    /**
     * 
     */
    private String name;

    /**
     * 
     */
    //	private int Emin;

    /**
     * 
     */
    //private int Emax;

    private NavigableSet<Captor> Captors;

    /**
     * @param name
     */
    public Batiment(String name) {
        this.Captors = new TreeSet<>();
        this.name = name;
        
    }

    /**
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * @return
     */
    public NavigableSet<Captor> getCaptors() {
        return Captors;
    }

    /**
     * @param captor
     */
    public void addCaptor(Captor captor) {
        // TODO implement here
    }

}