package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;

import donneesDynamique.Captor;
import donneesDynamique.CurveCanvasModel;
import donneesDynamique.TypeCaptor;


@SuppressWarnings("deprecation")
public class CurveCanvas extends JComponent implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//model
	private CurveCanvasModel model;
	private int yZero = 0;
	int nbValue;
	
	
	public CurveCanvas(CurveCanvasModel model) {
		super();
		this.model = model;
		if (model != null) {
			model.addObserver(this);
			nbValue = Math.round(Math.abs(model.getValueMax().getValue()-model.getValueMin().getValue()));
		}
		
	}
	
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//if there is no model
		if (model == null) {
			//background
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());
			
		}else {
			//background
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, getWidth(), getHeight());
			
			//addapt graph to values
			setAxis(g);
		}
		
		
		
	}
	
	//set axis
	public void setAxis(Graphics g) {
		
		g.setColor(Color.BLACK);
		//Xaxis
		if (model.getValueMin().getValue()>=0) {
			yZero = this.getHeight()-3;
		}
		else if (model.getValueMax().getValue()<=0) {
			yZero = 3;
		}
		else {
			yZero = Math.round(model.getValueMax().getValue()/nbValue*(this.getHeight()-3));
		}
		g.drawLine(3, yZero, this.getWidth(), yZero);
		g.drawLine(this.getWidth()-3, yZero + 3, this.getWidth(), yZero);
		g.drawLine(this.getWidth()-3, yZero -3, this.getWidth(), yZero);
		
		//Yaxis
		g.drawLine(3, 0, 3, this.getHeight());
		g.drawLine(0, 3 ,3, 0);
		g.drawLine(6, 3, 3, 0);
		
	}
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					JFrame window = new JFrame("Curve Tracer");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setBounds(0, 0, 800, 800);
					Captor cap = new Captor("lala", null, 1, "name", TypeCaptor.AIRCOMPRIME);
					cap.addValue(15);
					cap.addValue(16);
					
					window.getContentPane().add(new CurveCanvas(new CurveCanvasModel(cap)), BorderLayout.CENTER);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
}

