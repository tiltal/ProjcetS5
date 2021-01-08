 package donneesDynamique;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Map;

/**
 * 
 */

public class Batiment implements Comparable<Batiment> {

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
        Captors.add(captor);
    }

	@Override
	public String toString() {
		return "Batiment [name=" + name + "]";
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batiment other = (Batiment) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(Batiment bat2) {
		return name.compareTo(bat2.getName());
	}

}