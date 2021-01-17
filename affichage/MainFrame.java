package affichage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


import baseDonnees.Memoire;
import donneesDynamique.AnalyseModel;
import donneesDynamique.Captor;
import donneesDynamique.CaptorManageModel;
import donneesDynamique.TempReelTableModel;
import donneesDynamique.TimedValue;
import donneesDynamique.TypeCaptor;
import donneesDynamique.University;



public class MainFrame extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TODO test captors
	private Captor captorTest1 = new Captor("lala", "bat1", 1, "piece1", TypeCaptor.AIRCOMPRIME);
	private Captor captorTest2 = new Captor("lolo", "bat2", 3, "piece2", TypeCaptor.EAU);
	
	//model
	private University uModel;
	private TempReelTableModel tableModel;
	private AnalyseModel analyseModel;
	private CaptorManageModel captorManageModel;
	
	private JTabbedPane tabbedPane;
	private TempsReel tempsReelPannel;
	private JPanel analyse ;
	private JPanel captorManage;
	
	public MainFrame(University uModel) {
		
		//main frame configuration
		super("Projet S5");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setBounds(100, 100, 800, 800);
		
		//TODO test captors
		captorTest1.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 15, "888"));
		captorTest2.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 16, "777"));
				
		//model init
		this.uModel = uModel;
		
		tableModel = uModel.getTableModel();
		
		analyseModel = uModel.getAnalyseModel();
		
		captorManageModel = uModel.getCaptorManageModel();
		
		//panel itnit
		tempsReelPannel =  new TempsReel(tableModel);
		analyse = new Analyse(analyseModel);
		captorManage = new CaptorManage(captorManageModel);
		
		//tabs configuration
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane);
		tabbedPane.addTab("Temps reel", null, tempsReelPannel );
		tabbedPane.addTab("Analyse", null, analyse);
		tabbedPane.addTab("Capteurs", null, captorManage);
		
		uModel.addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		uModel.setModels();
		
		
		
		
	}



	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					University model = new University("univ");
					MainFrame window = new MainFrame(model);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}