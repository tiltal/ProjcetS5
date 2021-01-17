package donneesDynamique;

import java.lang.reflect.Array;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Observable;
import java.util.TreeSet;

@SuppressWarnings("deprecation")
public class AnalyseModel extends Observable{
	private CurveCanvasModel canvas1 = null;
	private CurveCanvasModel canvas2 = null;
	private CurveCanvasModel canvas3 = null;
	
	private HashMap<TypeCaptor, NavigableSet<Captor>> captorList;
	private ArrayList<String> fluidList = new ArrayList<>();
	private TreeSet<String> dateList = new TreeSet<>();

	
	private TypeCaptor fluid = TypeCaptor.AIRCOMPRIME;
	
	private Captor cap1 = null;
	private Captor cap2 = null;
	private Captor cap3 = null;

	private String startDate;
	private String endDate;
	
	public AnalyseModel(HashMap<TypeCaptor, NavigableSet<Captor>> captorList) {
		super();
		this.captorList = captorList;
		fluidList.add(TypeCaptor.AIRCOMPRIME.toString());
		fluidList.add(TypeCaptor.EAU.toString());
		fluidList.add(TypeCaptor.ELECTRICITE.toString());
		fluidList.add(TypeCaptor.TEMPERATURE.toString());
		
		
		
		setDateList();
	}
	
	public void setTimeInterval(String startDate, String endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	public void setDateList() {
		dateList = new TreeSet<>();
		addDateToList(cap1);
		addDateToList(cap2);
		addDateToList(cap3);
		
	}
	
	private void addDateToList(Captor cap) {
		if (cap != null) {
			for(Iterator<TimedValue> it = cap.getValues().iterator(); it.hasNext();) {
				dateList.add(it.next().getTime());
			}
		}
		
	}
	
	
	public CurveCanvasModel getCanvas1() {
		return canvas1;
	}
	public void setCanvas1(CurveCanvasModel canvas1) {
		this.canvas1 = canvas1;
	}
	public CurveCanvasModel getCanvas2() {
		return canvas2;
	}
	public void setCanvas2(CurveCanvasModel canvas2) {
		this.canvas2 = canvas2;
	}
	public CurveCanvasModel getCanvas3() {
		return canvas3;
	}
	public void setCanvas3(CurveCanvasModel canvas3) {
		this.canvas3 = canvas3;
	}

	public HashMap<TypeCaptor, NavigableSet<Captor>> getCaptorList() {
		return captorList;
	}

	public void setCaptorList(HashMap<TypeCaptor, NavigableSet<Captor>> captorList) {
		this.captorList = captorList;
	}

	public ArrayList<String> getFluidList() {
		return fluidList;
	}

	public void setFluidList(ArrayList<String> fluidList) {
		this.fluidList = fluidList;
	}

	public TreeSet<String> getDateList() {
		return dateList;
	}

	public void setDateList(TreeSet<String> dateList) {
		dateList = dateList;
	}

	public TypeCaptor getFluid() {
		return fluid;
	}

	public void setFluid(TypeCaptor fluid) {
		this.fluid = fluid;
	}

	public Captor getCap1() {
		return cap1;
	}

	public void setCap1(Captor cap1) {
		this.cap1 = cap1;
	}

	public Captor getCap2() {
		return cap2;
	}

	public void setCap2(Captor cap2) {
		this.cap2 = cap2;
	}

	public Captor getCap3() {
		return cap3;
	}

	public void setCap3(Captor cap3) {
		this.cap3 = cap3;
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
	
	
	
}
