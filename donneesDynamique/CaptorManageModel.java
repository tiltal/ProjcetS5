package donneesDynamique;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class CaptorManageModel extends Observable{
	private Captor selectedCaptor;

	public CaptorManageModel() {
		super();
		//TODO test
		Captor cap = new Captor("lala", "du cul", 1, "du fion", TypeCaptor.AIRCOMPRIME);
		cap.addValue(15);
		cap.addValue(16);
		selectedCaptor = cap; 
	}
	public Captor getSelectedCaptor() {
		return selectedCaptor;
	}

	public void setSelectedCaptor(Captor selectedCaptor) {
		this.selectedCaptor = selectedCaptor;
	}
}
