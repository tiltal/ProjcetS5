package affichage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;

import donneesDynamique.Captor;
import donneesDynamique.CaptorManageModel;
import donneesDynamique.CurveCanvasModel;
import donneesDynamique.TypeCaptor;

public class CaptorManage extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CaptorManageModel model;
	private JTree tree;
	private JPanel captorPanel;
	private JTextField txtName;
	private JTextField txtFluide;
	private JTextField txtBatiment;
	private JTextField txtEtage;
	private JTextField txtPiece;
	private JTextField txtSeuilMin;
	private JTextField txtSeuilMax;
	private JTextField txtConnected;
	
	public CaptorManage() {
		super(new BorderLayout(0,0));
		model = new CaptorManageModel();		
		//setJTree();
		setInfoPanel();
		
	}
	
	public void setJTree() {
		this.add(tree, BorderLayout.WEST);
	}
	
	public void setInfoPanel() {
		captorPanel = new JPanel(new GridLayout(0,2));
		this.add(captorPanel, BorderLayout.CENTER);
				
		txtName = new JTextField(model.getSelectedCaptor().getId());
		txtFluide = new JTextField(model.getSelectedCaptor().getType().toString());
		txtBatiment = new JTextField(model.getSelectedCaptor().getBatiment());
		txtEtage = new JTextField(Integer.toString(model.getSelectedCaptor().getEtage()));
		txtPiece = new JTextField(model.getSelectedCaptor().getLieu());
		txtSeuilMin = new JTextField(Float.toString(model.getSelectedCaptor().getBorneInf()));
		txtSeuilMax = new JTextField(Float.toString(model.getSelectedCaptor().getBorneSup()));
		txtConnected = new JTextField(Boolean.toString(model.getSelectedCaptor().getOn()));
		
		txtName.setEditable(false);
		txtFluide.setEditable(false);
		txtBatiment.setEditable(false);
		txtEtage.setEditable(false);
		txtPiece.setEditable(false);
		txtSeuilMin.setEditable(false);
		txtSeuilMax.setEditable(false);
		txtConnected.setEditable(false);
		
		captorPanel.add(new JLabel("Nom : "));
		captorPanel.add(txtName);
		captorPanel.add(new JLabel("Type fluide : "));
		captorPanel.add(txtFluide);
		captorPanel.add(new JLabel("Batiment : "));
		captorPanel.add(txtBatiment);
		captorPanel.add(new JLabel("Etage : "));
		captorPanel.add(txtEtage);
		captorPanel.add(new JLabel("Piece : "));
		captorPanel.add(txtPiece);
		captorPanel.add(new JLabel("Min : "));
		captorPanel.add(txtSeuilMin);
		captorPanel.add(new JLabel("Max : "));
		captorPanel.add(txtSeuilMax);
		captorPanel.add(new JLabel("Connecté : "));
		captorPanel.add(txtConnected);


	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					JFrame window = new JFrame("Captor Pannel");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setBounds(0, 0, 800, 800);
					window.setVisible(true);

					
					window.getContentPane().add(new CaptorManage(), BorderLayout.CENTER);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

}
