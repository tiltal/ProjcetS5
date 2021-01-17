package donneesDynamique;

import java.time.Instant;
import java.util.Iterator;
import java.util.Observable;
import java.util.TreeSet;

@SuppressWarnings("deprecation")
public class CurveCanvasModel extends Observable {
	private TypeCaptor fluid;
	public Captor cap;
	private TreeSet<TimedValue> listTriee;
	private TimedValue valueMax;
	private TimedValue valueMin;
	private TimedValue valueBegin;
	private TimedValue valueEnd;
	private String startDate;
	private String endDate;
	private int vRange;

	public CurveCanvasModel(Captor capteur, String startDate, String endDate) {
		super();
		cap = capteur;
		listTriee = new TreeSet<TimedValue>(capteur.getValues());
		this.startDate = startDate;
		this.endDate = endDate;
		setBeginEnd(searchByTime(startDate), searchByTime(endDate));
		setMinMax();
		vRange = Math.round(Math.abs(getValueMax().getValue() - getValueMin().getValue()));
	}

	public TimedValue searchByTime(String time) {
		TimedValue v = null;
		for (Iterator<TimedValue> it = listTriee.iterator(); it.hasNext() && v == null;) {
			TimedValue currentValue = it.next();
			if (currentValue.getTime().equals(time)) {
				v = currentValue;
			}
		}
		return v;
	}

	// search min and max value in listTriee
	public void setMinMax() {
		if (listTriee != null) {
			valueMax = listTriee.first();
			valueMin = listTriee.first();

		} else {
			valueMax = new TimedValue(0.0f, "007");
			valueMin = new TimedValue(0.0f, "007");
		}

		for (Iterator<TimedValue> it = listTriee.iterator(); it.hasNext();) {
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
		if (listTriee.isEmpty()) {
			valueBegin = null;
			valueEnd = null;
		} else {
			if (vBeg != null && listTriee.contains(vBeg)) {
				valueBegin = vBeg;
			} else {
				valueBegin = listTriee.first();
			}

			if (vEnd != null && listTriee.contains(vEnd)) {
				valueEnd = vEnd;
			} else {
				valueEnd = listTriee.last();
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getvRange() {
		return vRange;
	}

	public void setvRange(int vRange) {
		this.vRange = vRange;
	}

}
