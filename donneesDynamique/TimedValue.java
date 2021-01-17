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
    
    private String idCap;


    /**
     * @param valeur
     */
    public TimedValue(String time, float value, String idCap) {
        this.value= value;
    	time = time.replace('/',':');
        this.time = time;      
        this.idCap = idCap;
    }
    
    public TimedValue(float value, String idCap) {
    	this.value = value;
    	this.time = Clock.systemDefaultZone().instant().toString();
    	//time = time.replace(':','/');
    	this.idCap = idCap;
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
        return time;
    }
    
    public String getIdCap() {
    	return idCap;
    }

	@Override
	public String toString() {
		return "TimedValue [value=" + value + ", time=" + time + ", id=" + idCap + "]";
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