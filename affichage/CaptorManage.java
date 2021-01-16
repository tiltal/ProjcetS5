package affichage;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import controle.CaptorManagerControler;
import donneesDynamique.Batiment;
import donneesDynamique.Captor;
import donneesDynamique.CaptorManageModel;
import donneesDynamique.CurveCanvasModel;
import donneesDynamique.TypeCaptor;

public class CaptorManage extends JPanel implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private CaptorManageModel model;
	private JTree tree;
	private DefaultTreeModel treeModel;
	private JPanel captorPanel;
	private JTextField txtName = null;
	private JTextField txtFluide = null;
	private JTextField txtBatiment = null;
	private JTextField txtEtage = null;
	private JTextField txtPiece = null;
	private JTextField txtSeuilMin = null;
	private JTextField txtSeuilMax = null;
	private JTextField txtConnected = null;
	
	public CaptorManage(CaptorManageModel model) {
		super(new BorderLayout(0,0));
		this.model = model;
		this.model.addObserver(this);
		
		setJTree();
		tree = new JTree(treeModel);
		this.add(tree, BorderLayout.WEST);
		
		setInfoPanel();
		
	}
	
	public void setJTree() {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Université");
		
		//add batiments
		for (Iterator<Batiment> itb = model.getBatiments().iterator(); itb.hasNext(); ) {
			Batiment bat = itb.next();
			DefaultMutableTreeNode batNode = new DefaultMutableTreeNode(bat);
			
			//sort captors by level
			TreeSet<Captor> capTriee = new TreeSet<>(new Comparator<Captor>() {

				@Override
				public int compare(Captor arg0, Captor arg1) {
					int i = ((Integer)arg0.getEtage()).compareTo((Integer)arg1.getEtage());
					if (i == 0) {
						return arg0.compareTo(arg1);
					}
					return i;
				}
			});
			for (Iterator<Captor> it = bat.getCaptors().iterator(); it.hasNext();) {
				capTriee.add(it.next());
			}
			
			//add level
			DefaultMutableTreeNode levelNode = null;
			for (Iterator<Captor> itc = capTriee.iterator(); itc.hasNext();) {
				Captor cap = itc.next();
				if (levelNode == null) {
					levelNode = new DefaultMutableTreeNode(cap.getEtage());
				}else if(cap.getEtage() != (int)levelNode.getUserObject()) {
					if (levelNode != null) {
						batNode.add(levelNode);
					}
					levelNode = new DefaultMutableTreeNode(cap.getEtage());
				}
				//add captors
				DefaultMutableTreeNode capNode = new DefaultMutableTreeNode(cap);
				levelNode.add(capNode);
			}
			if (levelNode != null) {
				batNode.add(levelNode);
			}
			if (batNode != null) {
				root.add(batNode);
			}
			
		}
		
		if(treeModel == null) {
			treeModel = new DefaultTreeModel(root);
		}else {
			treeModel.setRoot(root);
			treeModel.reload();
		}
		
		
	}
	
	public void setInfoPanel() {
		captorPanel = new JPanel(new GridLayout(0,2));
		this.add(captorPanel, BorderLayout.CENTER);		
		
		writeCaptorInfo();
		
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
	
	public void writeCaptorInfo() {
		
		if (model.getSelectedCaptor() != null) {
			
			txtName.setText(model.getSelectedCaptor().getId());
			txtFluide.setText(model.getSelectedCaptor().getType().toString());
			txtBatiment.setText(model.getSelectedCaptor().getBatiment());
			txtEtage.setText(Integer.toString(model.getSelectedCaptor().getEtage()));
			txtPiece.setText(model.getSelectedCaptor().getLieu());
			txtSeuilMin.setText(Float.toString(model.getSelectedCaptor().getBorneInf()));
			txtSeuilMax.setText(Float.toString(model.getSelectedCaptor().getBorneSup()));
			txtConnected.setText(Boolean.toString(model.getSelectedCaptor().getOn()));
		
		}else{
			txtName = new JTextField("");
			txtFluide = new JTextField("");
			txtBatiment = new JTextField("");
			txtEtage = new JTextField("");
			txtPiece = new JTextField("");
			txtSeuilMin = new JTextField("");
			txtSeuilMax = new JTextField("");
			txtConnected = new JTextField("");
			
			txtName.setEditable(false);
			txtFluide.setEditable(false);
			txtBatiment.setEditable(false);
			txtEtage.setEditable(false);
			txtPiece.setEditable(false);
			txtSeuilMin.setEditable(false);
			txtSeuilMax.setEditable(false);
			txtConnected.setEditable(false);
		
		}
		
	}
	


	@Override
	public void update(Observable arg0, Object arg1) {
		writeCaptorInfo();
		setJTree();
		System.out.println("update");
		
	}
	
	public JTree getTree() {
		return tree;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					JFrame window = new JFrame("Captor Pannel");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setBounds(0, 0, 800, 800);
					window.setVisible(true);
					
					Batiment bat1 = new Batiment("bat1");
					Batiment bat2 = new Batiment("bat2");
					Batiment bat3 = new Batiment("bat3");
					
					Captor cap1 = new Captor("cap1", "bat1", 1, "piece1", TypeCaptor.AIRCOMPRIME);
					Captor cap2 = new Captor("cap2", "bat1", 1, "piece2", TypeCaptor.AIRCOMPRIME);
					Captor cap3 = new Captor("cap3", "bat2", 3, "piece65", TypeCaptor.EAU);
					bat1.addCaptor(cap1);
					bat1.addCaptor(cap2);
					bat2.addCaptor(cap3);
					NavigableSet<Batiment> batiments = new TreeSet<>();
					batiments.add(bat1);
					batiments.add(bat2);
					batiments.add(bat3);
					
					CaptorManageModel model = new CaptorManageModel(batiments);
					CaptorManage manage = new CaptorManage(model);
					CaptorManagerControler control = new CaptorManagerControler(manage);
					window.getContentPane().add(manage, BorderLayout.CENTER);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CaptorManageModel getModel() {
		return model;
	}
	

}
