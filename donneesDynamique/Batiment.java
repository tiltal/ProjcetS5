 package donneesDynamique;

import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.Comparator;

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
        this.Captors = new TreeSet<>(new Comparator<Captor>() {

			@Override
			public int compare(Captor cap1, Captor cap2) {
				int etage = cap1.getEtage() - cap2.getEtage();
				if (etage !=0) {
					return etage;
				}
				else {
					int lieu = cap1.getLieu().compareTo(cap2.getLieu());
					if (lieu !=0) {
						return lieu;
					}
					else {
						return cap1.getId().compareTo(cap2.getId());
					}
				}
			}
        	
        }
        		
        		);
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
		return "Batiment " + name ;
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