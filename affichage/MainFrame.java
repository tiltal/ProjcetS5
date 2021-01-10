package affichage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import donneesDynamique.AnalyseModel;
import donneesDynamique.Captor;
import donneesDynamique.TempReelTableModel;
import donneesDynamique.TypeCaptor;



public class MainFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TODO test captors
	Captor captorTest1 = new Captor("lala", "bat1", 1, "piece1", TypeCaptor.AIRCOMPRIME);
	Captor captorTest2 = new Captor("lolo", "bat2", 3, "piece2", TypeCaptor.EAU);
	private JTabbedPane tabbedPane;
	private JScrollPane tempsReelPannel = new TempsReel(new TempReelTableModel(new ArrayList<Captor>((Arrays.asList(captorTest1, captorTest2)))));
	private JPanel analyse = new Analyse(new AnalyseModel());
	private JPanel captorManage = new CaptorManage();
	
	public MainFrame() {
		
		//main frame configuration
		super("Projet S5");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new BorderLayout(0, 0));
		this.setBounds(100, 100, 800, 800);
		
		//tabs configuration
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		this.getContentPane().add(tabbedPane);
		tabbedPane.addTab("Temps reel", null, tempsReelPannel );
		tabbedPane.addTab("Analyse", null, analyse);
		tabbedPane.addTab("Capteurs", null, captorManage);
	}



public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() { 
			try {
				MainFrame window = new MainFrame();
				window.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}