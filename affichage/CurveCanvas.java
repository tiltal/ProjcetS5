package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;


public class CurveCanvas extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		
		//background
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					JFrame window = new JFrame("Curve Tracer");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setBounds(0, 0, 800, 800);
					window.getContentPane().add(new CurveCanvas(), BorderLayout.CENTER);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}

