 package donneesDynamique;
import java.time.Clock;

/**
 * 
 */
public class TimedValue implements Comparable<TimedValue>{

    /**
     * Default constructor
     */
    public TimedValue() {
    }

    /**
     * 
     */
    private float value;


    /**
     * @param valeur
     */
    public TimedValue(float valeur) {
        value = valeur;
    }

    /**
     * @return
     */
    public float getValue() {
 
        return value;
    }

    /**
     * @return
     */
    public Clock getTime() {
        // TODO implement here
        return null;
    }

	@Override
	public int compareTo(TimedValue arg0) {
		// TODO Auto-generated method stub
		return 1;
	}

}