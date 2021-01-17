package donneesDynamique;

import java.util.Observable;

/**
 * 
 */
@SuppressWarnings("deprecation")
public abstract class AbstractModel extends Observable {
	
	TempReelTableModel tableModel;
	AnalyseModel analyseModel;
	CaptorManageModel captorManageModel;

    /**
     * Default constructor
     */
    public AbstractModel() {
    }


    /**
     * 
     */
    public void addObserver() {
        // TODO implement here
    }

    /**
     * 
     */
    public void notifyObserver() {
        tableModel.fireTableDataChanged();
        analyseModel.notifyObservers();
        captorManageModel.notifyObservers();
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