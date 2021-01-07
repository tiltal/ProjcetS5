package affichage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class Analyse extends JPanel implements Observer {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * Default constructor
     */
    public Analyse() {
    	super();
    	this.setLayout(new BorderLayout(0, 0));
    	//add Toolbars
    	
    	//top toolBar
    	JToolBar barFilter = new JToolBar();
    	this.add(barFilter, BorderLayout.PAGE_START);
    	
    	JComboBox<String> fluideBox = new JComboBox<>();
		fluideBox.setEditable(true);
		fluideBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Fluide..."}));
		barFilter.add(fluideBox);
		
		JComboBox<String> capteur1Box = new JComboBox<>();
		capteur1Box.setEditable(true);
		capteur1Box.setModel(new DefaultComboBoxModel<String>(new String[] {"Capteur1..."}));
		barFilter.add(capteur1Box);
		
		JComboBox<String> capteur2Box = new JComboBox<>();
		capteur2Box.setEditable(true);
		capteur2Box.setModel(new DefaultComboBoxModel<String>(new String[] {"Capteur2..."}));
		barFilter.add(capteur2Box);
		
		JComboBox<String> capteur3Box = new JComboBox<>();
		capteur3Box.setEditable(true);
		capteur3Box.setModel(new DefaultComboBoxModel<String>(new String[] {"Capteur3..."}));
		barFilter.add(capteur3Box);
		
		//bottom Toolbar
		JToolBar barTimeFilter= new JToolBar();
		this.add(barTimeFilter, BorderLayout.PAGE_END);
		
		JLabel startTimeLabel = new JLabel(" Debut : ");
		barTimeFilter.add(startTimeLabel);
		
		JComboBox<String> startDateBox = new JComboBox<>();
		startDateBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Date..."}));
		barTimeFilter.add(startDateBox);
		
		JComboBox<String> startHourBox = new JComboBox<>();
		startHourBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Heure..."}));
		barTimeFilter.add(startHourBox);
		
		JLabel endTimeLabel = new JLabel(" Fin : ");
		barTimeFilter.add(endTimeLabel);
		
		JComboBox<String> endDateBox = new JComboBox<>();
		endDateBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Date..."}));
		barTimeFilter.add(endDateBox);
		
		JComboBox<String> endHourBox = new JComboBox<>();
		endHourBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Heure..."}));
		barTimeFilter.add(endHourBox);
		
		//graph zone
		JPanel graphZone = new JPanel();
		this.add(graphZone, BorderLayout.CENTER);
		graphZone.setLayout(new GridLayout(0,1));
		
		CurveCanvas curve1 = new CurveCanvas();
		CurveCanvas curve2 = new CurveCanvas();
		CurveCanvas curve3 = new CurveCanvas();
		
		graphZone.add(curve1);
		graphZone.add(curve2);
		graphZone.add(curve3);
		
    	
    }


    /**
     * 
     */
    public void update() {
        // TODO implement here
    }


	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

}