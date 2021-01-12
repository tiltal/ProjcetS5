package donneesDynamique;

import java.sql.Time;
import java.util.Iterator;
import java.util.Observable;
import java.util.TreeSet;

import sun.security.provider.certpath.AdjacencyList;

@SuppressWarnings("deprecation")
public class CurveCanvasModel extends Observable{
	private TypeCaptor fluid;
	private TreeSet<TimedValue> listTriee;
	private TimedValue valueMax;
	private TimedValue valueMin;
	private TimedValue valueBegin;
	private TimedValue valueEnd;
	private int vRange;
	
	public CurveCanvasModel(Captor capteur) {
		super();
		listTriee = new TreeSet<TimedValue>(capteur.getValues());
		setBeginEnd(null, null);
		setMinMax();
		vRange = Math.round(Math.abs(getValueMax().getValue()-getValueMin().getValue()));
	}
	
	//search min and max value in listTriee
	public void setMinMax() {
		if (listTriee != null) {
			valueMax = listTriee.first();
			valueMin = listTriee.first();
			
		}else {
			valueMax = new TimedValue(0.0f, "007");
			valueMin = new TimedValue(0.0f, "007");
		}
		
		
		for(Iterator<TimedValue> it = listTriee.iterator(); it.hasNext();) {
			TimedValue v = it.next();
			if (v.getValue() >= valueMax.getValue()) {
				valueMax = v;
			}
			if (v.getValue() < valueMin.getValue()) {
				valueMin = v;
			}
		}
	}
	
	public void setBeginEnd(TimedValue vBeg, TimedValue vEnd) {
		
		if(vBeg != null && listTriee.contains(vBeg)) {
			valueBegin = vBeg;
		}else {
			valueBegin = listTriee.first();
		}
		
		if(vEnd != null && listTriee.contains(vEnd)) {
			valueEnd = vEnd;
		}else {
			valueEnd = listTriee.last();
		}
		
	}

	public TypeCaptor getFluid() {
		return fluid;
	}

	public void setFluid(TypeCaptor fluid) {
		this.fluid = fluid;
	}

	public TreeSet<TimedValue> getListTriee() {
		return listTriee;
	}

	public void setListTriee(TreeSet<TimedValue> listTriee) {
		this.listTriee = listTriee;
	}

	public TimedValue getValueMin() {
		return valueMin;
	}

	public void setValueMin(TimedValue valueMin) {
		this.valueMin = valueMin;
	}

	public TimedValue getValueMax() {
		return valueMax;
	}

	public void setValueMax(TimedValue valueMax) {
		this.valueMax = valueMax;
	}
	
	public TimedValue getValueBegin() {
		return valueBegin;
	}

	public void setValueBegin(TimedValue valueBegin) {
		this.valueBegin = valueBegin;
	}

	public TimedValue getValueEnd() {
		return valueEnd;
	}

	public void setValueEnd(TimedValue valueEnd) {
		this.valueEnd = valueEnd;
	}

	public int getVRange() {
		return vRange;
	}

	public void setVRange(int nbValue) {
		this.vRange = nbValue;
	}

	
}
