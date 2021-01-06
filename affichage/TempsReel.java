package affichage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.WindowConstants;
import javax.swing.table.TableModel;

import donneesDynamique.Captor;
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
    	this.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.model = model;
		
		table = new JTable(model);
		this.setViewportView(table);

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