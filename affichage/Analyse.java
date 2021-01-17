package affichage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.NavigableSet;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import controle.AnalyseControler;
import controle.CaptorManagerControler;
import donneesDynamique.AnalyseModel;
import donneesDynamique.Batiment;
import donneesDynamique.Captor;
import donneesDynamique.CaptorManageModel;
import donneesDynamique.CurveCanvasModel;
import donneesDynamique.TimedValue;
import donneesDynamique.TypeCaptor;

/**
 * 
 */
@SuppressWarnings("deprecation")
public class Analyse extends JPanel implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AnalyseModel model;
	public JComboBox<String> fluideBox = new JComboBox<>();
	public JComboBox<Captor> capteur1Box = new JComboBox<>();
	public JComboBox<Captor> capteur2Box = new JComboBox<>();
	public JComboBox<Captor> capteur3Box = new JComboBox<>();
	public JComboBox<String> startDateBox = new JComboBox<>();
	public JComboBox<String> endDateBox = new JComboBox<>();

	/**
	 * Default constructor
	 */
	public Analyse(AnalyseModel model) {
		super();
		// init model
		this.model = model;

		this.setLayout(new BorderLayout(0, 0));
		// add Toolbars

		// top toolBar
		JToolBar barFilter = new JToolBar();
		this.add(barFilter, BorderLayout.PAGE_START);

		// trick to convert Object[] to String[]
		String[] s = Arrays.asList(model.getFluidList().toArray()).toArray(new String[model.getFluidList().size()]);
		fluideBox.setEditable(true);
		fluideBox.setModel(new DefaultComboBoxModel<String>(s));
		barFilter.add(fluideBox);

		// trick to convert Object[] to Captor[]
		Captor[] s2 = Arrays.asList(model.getCaptorList().get(model.getFluid()).toArray())
				.toArray(new Captor[model.getCaptorList().get(model.getFluid()).size()]);
		capteur1Box.setEditable(true);
		capteur1Box.setModel(new DefaultComboBoxModel<Captor>(s2));
		barFilter.add(capteur1Box);

		capteur2Box.setEditable(true);
		capteur2Box.setModel(new DefaultComboBoxModel<Captor>(s2));
		barFilter.add(capteur2Box);

		capteur3Box.setEditable(true);
		capteur3Box.setModel(new DefaultComboBoxModel<Captor>(s2));
		barFilter.add(capteur3Box);

		// bottom Toolbar
		JToolBar barTimeFilter = new JToolBar();
		this.add(barTimeFilter, BorderLayout.PAGE_END);

		JLabel startTimeLabel = new JLabel(" Debut : ");
		barTimeFilter.add(startTimeLabel);

		setDateTable();
		barTimeFilter.add(startDateBox);

		JLabel endTimeLabel = new JLabel(" Fin : ");
		barTimeFilter.add(endTimeLabel);

		barTimeFilter.add(endDateBox);

		// graph zone
		JPanel graphZone = new JPanel();
		this.add(graphZone, BorderLayout.CENTER);
		graphZone.setLayout(new GridLayout(0, 1));

		CurveCanvas curve1 = new CurveCanvas(model.getCanvas1());
		CurveCanvas curve2 = new CurveCanvas(model.getCanvas2());
		CurveCanvas curve3 = new CurveCanvas(model.getCanvas3());

//		model.getCanvas1().addObserver(curve1);
//		model.getCanvas2().addObserver(curve2);
//		model.getCanvas3().addObserver(curve3);

		// TODO test
//		Captor cap = new Captor("lala", "lolo", 1, "lili",TypeCaptor.AIRCOMPRIME);
//		cap.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 15, "888"));
//		cap.addValue(new TimedValue("2014-12-03T10:16:30.00Z", 16, "888"));
//		curve1  = new CurveCanvas(new CurveCanvasModel(cap));

		graphZone.add(curve1);
		graphZone.add(curve2);
		graphZone.add(curve3);

	}

	public void setDateTable() {
		// trick to convert Object[] to String[]
		String[] s = Arrays.asList(model.getDateList().toArray()).toArray(new String[model.getDateList().size()]);
		startDateBox.setModel(new DefaultComboBoxModel<String>(s));
		endDateBox.setModel(new DefaultComboBoxModel<String>(s));
	}

	public void setCaptorFilter() {
		Captor[] s2;
    	if(model.getCaptorList().get(model.getFluid()) == null) {
    		s2 = new Captor[] {};
    	}else {
    		s2 = Arrays.asList(model.getCaptorList().get(model.getFluid()).toArray()).toArray(new Captor[model.getCaptorList().get(model.getFluid()).size()]);
		
    	}
		capteur1Box.setModel(new DefaultComboBoxModel<Captor>(s2));
		capteur2Box.setModel(new DefaultComboBoxModel<Captor>(s2));
		capteur3Box.setModel(new DefaultComboBoxModel<Captor>(s2));
		
    }

	/**
	 * 
	 */
	public void update() {
		setCaptorFilter();
		setDateTable();
	}

	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("date")) {
			setDateTable();
		}

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame window = new JFrame("Captor Pannel");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setBounds(0, 0, 800, 800);
					window.setVisible(true);

					Captor cap1 = new Captor("cap1", "bat1", 1, "piece1", TypeCaptor.AIRCOMPRIME);
					Captor cap2 = new Captor("cap2", "bat1", 1, "piece2", TypeCaptor.AIRCOMPRIME);
					Captor cap3 = new Captor("cap3", "bat2", 3, "piece65", TypeCaptor.EAU);
					Captor cap4 = new Captor("cap4", "bat3", 5, "piece455", TypeCaptor.ELECTRICITE);

					cap1.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 15, cap1.getId()));
					cap1.addValue(new TimedValue("2014-12-03T10:16:30.00Z", 18, cap1.getId()));
					cap1.addValue(new TimedValue("2014-13-03T10:16:30.00Z", -1, cap1.getId()));

					cap2.addValue(new TimedValue("2015-13-03T10:16:30.00Z", (float) -0.5, cap1.getId()));
					cap2.addValue(new TimedValue("2015-13-03T10:16:37.00Z", 3, cap1.getId()));

					cap3.addValue(new TimedValue("2014-14-03T10:15:30.00Z", 15, cap1.getId()));
					cap3.addValue(new TimedValue("2014-15-03T10:15:30.00Z", 15, cap1.getId()));

					NavigableSet<Captor> airCaptor = new TreeSet<>();
					airCaptor.add(cap1);
					airCaptor.add(cap2);
					NavigableSet<Captor> eauCaptor = new TreeSet<>();
					eauCaptor.add(cap3);
					NavigableSet<Captor> elecCaptor = new TreeSet<>();
					elecCaptor.add(cap4);
					NavigableSet<Captor> tempCaptor = new TreeSet<>();
					HashMap<TypeCaptor, NavigableSet<Captor>> captorList = new HashMap<>();
					captorList.put(TypeCaptor.AIRCOMPRIME, airCaptor);
					captorList.put(TypeCaptor.EAU, eauCaptor);
					captorList.put(TypeCaptor.ELECTRICITE, elecCaptor);
					captorList.put(TypeCaptor.TEMPERATURE, tempCaptor);

					AnalyseModel model = new AnalyseModel(captorList);
					Analyse vue = new Analyse(model);
					AnalyseControler control = new AnalyseControler(vue);
					window.getContentPane().add(vue, BorderLayout.CENTER);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}