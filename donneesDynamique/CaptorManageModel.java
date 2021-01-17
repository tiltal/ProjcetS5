package donneesDynamique;

import java.util.NavigableSet;
import java.util.Observable;

@SuppressWarnings("deprecation")
public class CaptorManageModel extends Observable{
	private Captor selectedCaptor = null;
	private NavigableSet<Batiment> batiments;
	
	public CaptorManageModel(NavigableSet<Batiment> batiments) {
		super();
		
		this.batiments = batiments;
		
		//TODO test
//		Captor cap = new Captor("lala", "du cul", 1, "du fion", TypeCaptor.AIRCOMPRIME);
//		cap.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 15, "888"));
//		cap.addValue(new TimedValue("2014-12-03T10:16:30.00Z", 16, "888"));
//		selectedCaptor = cap; 
	}
	
	public Captor getSelectedCaptor() {
		return selectedCaptor;
	}

	public void setSelectedCaptor(Captor selectedCaptor) {
		this.selectedCaptor = selectedCaptor;
	}
	
	public NavigableSet<Batiment> getBatiments() {
		return batiments;
	}
	
	public void setBatiments(NavigableSet<Batiment> batiments) {
		this.batiments = batiments;
	}
}
