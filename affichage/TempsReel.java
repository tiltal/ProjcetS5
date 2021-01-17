package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;

import donneesDynamique.Captor;
import donneesDynamique.TempReelTableModel;
import donneesDynamique.TimedValue;
import donneesDynamique.TypeCaptor;

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
		RenduTableau rTab = new RenduTableau();
		for (int i = 0; i < model.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(rTab);
		}
		this.setViewportView(table);


    }
    
	public class RenduTableau extends DefaultTableCellRenderer{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private float bornInf;
		private float bornSupp;
		Captor cap;
		
		
		public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
				int arg5) {
			
			setText(String.valueOf(arg1));
			cap = ((TempReelTableModel)arg0.getModel()).getCaptorAt(arg4);
			bornInf = cap.getBorneInf();
			bornSupp = cap.getBorneSup();
			float valeur = (float)arg0.getValueAt(arg4, 4);
			if (valeur > bornSupp || valeur < bornInf) {
				setForeground(Color.red);	
			}else {
				setForeground(Color.BLUE);
			}
			
			return this;
		}

		
	}

 

	public void update(Observable arg0, Object arg1) {
//		ArrayList<Captor> captorList = (ArrayList<Captor>)arg1;
//		model.setCaptoList(captorList);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					Captor captorTest1 = new Captor("lala", "bat1", 1, "piece1", TypeCaptor.AIRCOMPRIME);
					Captor captorTest2 = new Captor("lolo", "bat2", 3, "piece2", TypeCaptor.EAU);
					captorTest1.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 18, "888"));
					captorTest2.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 16, "777"));
					TempsReel tp =  new TempsReel(new TempReelTableModel(new ArrayList<Captor>((Arrays.asList(captorTest1, captorTest2)))));
					JFrame window = new JFrame("Temps reel Panel");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.add(tp, BorderLayout.CENTER);
					window.setBounds(0, 0, 800, 800);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}