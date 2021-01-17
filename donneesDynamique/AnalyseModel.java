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
