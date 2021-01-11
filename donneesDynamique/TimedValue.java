package donneesDynamique;

import java.time.Clock;

/**
 * 
 */
public class TimedValue implements Comparable<TimedValue> {

    

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
    	time = time.replace(':','/');
    	time = time.substring(0, time.length()-1);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TimedValue other = (TimedValue) obj;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
	
    

}