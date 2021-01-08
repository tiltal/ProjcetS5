package donneesDynamique;

import java.time.Clock;

/**
 * 
 */
public class TimedValue implements Comparable<TimedValue> {

    /**
     * Default constructor
     */
    public TimedValue() {
    }
    

    /**
     * 
     */
    private float value;
    
    private String time;


    /**
     * @param valeur
     */
    public TimedValue(float value, String time) {
        this.value= value;
        this.time = time;        
    }
    
    public TimedValue(float value) {
    	this.value = value;
    	this.time = Clock.systemDefaultZone().instant().toString();
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
    public String getTime() {
        // TODO implement here
        return time;
    }

	@Override
	public String toString() {
		return "TimedValue [value=" + value + ", time=" + time + "]";
	}
	
	@Override
	public int compareTo(TimedValue timedValue) {
		return this.time.compareTo(timedValue.getTime());
	}
    

}