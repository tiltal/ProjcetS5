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
	public CurveCanvas curve1;
	public CurveCanvas curve2;
	public CurveCanvas curve3;
	public JPanel graphZone;
	

	/**
	 * Default constructor
	 */
	public Analyse(AnalyseModel model) {
		super();
		// init model
		this.model = model;
		model.addObserver(this);

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
		graphZone = new JPanel();
		this.add(graphZone, BorderLayout.CENTER);
		graphZone.setLayout(new GridLayout(0, 1));

		curve1 = new CurveCanvas(null);
		curve2 = new CurveCanvas(null);
		curve3 = new CurveCanvas(null);

//		model.getCanvas1().addObserver(curve1);
//		model.getCanvas2().addObserver(curve2);
//		model.getCanvas3().addObserver(curve3);


		

		graphZone.add(curve1);
		graphZone.add(curve2);
		graphZone.add(curve3);
	}

	public void setDateTable() {
		// trick to convert Object[] to String[]
		String[] s = Arrays.asList(model.getDateList().toArray()).toArray(new String[model.getDateList().size()]);
		startDateBox.setModel(new DefaultComboBoxModel<String>(s));
		endDateBox.setModel(new DefaultComboBoxModel<String>(s));
		if (!model.getDateList().isEmpty()) {
			startDateBox.setSelectedItem(model.getDateList().first());
			startDateBox.setSelectedItem(model.getDateList().last());
		}
		
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
		System.out.println("update1");
	}

	public void update(Observable arg0, Object arg1) {
		if (arg1.equals("date")) {
			setDateTable();
		}
		if (arg1.equals("allCanvas")) {
			graphZone.remove(curve1);
			graphZone.remove(curve2);
			graphZone.remove(curve3);
			curve1 = new CurveCanvas(new CurveCanvasModel(model.getCap1(), model.getStartDate(), model.getEndDate()));
			curve2 = new CurveCanvas(new CurveCanvasModel(model.getCap2(), model.getStartDate(), model.getEndDate()));
			curve3 = new CurveCanvas(new CurveCanvasModel(model.getCap3(), model.getStartDate(), model.getEndDate()));
			graphZone.add(curve1);
			graphZone.add(curve2);
			graphZone.add(curve3);
			System.out.println("update2");
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
					cap1.addValue(new TimedValue("2014-12-03T10:16:50.00Z", -1, cap1.getId()));

					cap2.addValue(new TimedValue("2015-13-03T10:16:30.00Z", (float) -0.5, cap1.getId()));
					cap2.addValue(new TimedValue("2015-13-03T10:17:00.00Z", 3, cap1.getId()));

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