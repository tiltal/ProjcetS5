package donneesDynamique;

import java.util.Iterator;
import java.util.Observable;
import java.util.TreeSet;

@SuppressWarnings("deprecation")
public class CurveCanvasModel extends Observable{
	private TypeCaptor fluid;
	private TreeSet<TimedValue> listTriee;
	private TimedValue valueMax;
	private TimedValue valueMin;
	
	public CurveCanvasModel(Captor capteur) {
		super();
		listTriee = new TreeSet<TimedValue>(capteur.getValues());
		
		setMinMax();
	}
	
	private void setMinMax() {
		valueMax = new TimedValue(0.0f);
		valueMin = new TimedValue(0.0f);
		
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
	
}
