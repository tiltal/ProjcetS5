package donneesDynamique;

import java.util.Observable;
import java.util.ArrayList;
import java.util.Observer;

/**
 * 
 */
@SuppressWarnings("deprecation")
public abstract class AbstractModel extends Observable {
	
	TempReelTableModel tableModel;
	AnalyseModel analyseModel;
	CaptorManageModel captorManageModel;
	private ArrayList<Observer> lo;

    /**
     * Default constructor
     */
    public AbstractModel() {
    	super();
    	lo = new ArrayList<>();
    }


    /**
     * 
     */
    public void addObserver(Observer obs) {
        lo.add(obs);
    }

    /**
     * 
     */
    public void notifyObserver() {
        tableModel.fireTableDataChanged();
        analyseModel.notifyObservers();
        captorManageModel.notifyObservers();
        for(Observer ob : lo) {
        	ob.update(null, null);
        }
    }

    /**
     * 
     */
    public void removeObserver() {
        // TODO implement here
    }
    
    //Set models when abstract model change
    public  abstract void setModels();


	public TempReelTableModel getTableModel() {
		return tableModel;
	}


	public void setTableModel(TempReelTableModel tableModel) {
		this.tableModel = tableModel;
	}


	public AnalyseModel getAnalyseModel() {
		return analyseModel;
	}


	public void setAnalyseModel(AnalyseModel analyseModel) {
		this.analyseModel = analyseModel;
	}


	public CaptorManageModel getCaptorManageModel() {
		return captorManageModel;
	}


	public void setCaptorManageModel(CaptorManageModel captorManageModel) {
		this.captorManageModel = captorManageModel;
	}

}