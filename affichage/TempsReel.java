package affichage;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableModel;

import donneesDynamique.TempReelTableModel;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class TempsReel extends JScrollPane implements Observer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTable table;
	private TempReelTableModel model;


	/**
     * Default constructor
     */
    public TempsReel(TempReelTableModel model) {
    	super();
    	this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.model = model;
		
		table = new JTable(model);

    }

    /**
     * 
     */
    public void update() {
    	table.tableChanged(null);;
    }


	public void update(Observable arg0, Object arg1) {
		
	}

}