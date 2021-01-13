package affichage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JComponent;
import javax.swing.JFrame;

import donneesDynamique.Captor;
import donneesDynamique.CurveCanvasModel;
import donneesDynamique.TimedValue;
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
	private float yZeroValue = 0;
	private int xGradOffset = 10;
	private long tRange = 0;
	private int xRange = 0;
	
	
	public CurveCanvas(CurveCanvasModel model) {
		super();
		this.model = model;
		if (model != null) {
			model.addObserver(this);
			
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
			setGraduation(g);
			
			tracePoint(g);
		}
		
		
		
	}
	
	//set axis
	public void setAxis(Graphics g) {
		
		g.setColor(Color.BLACK);
		//Xaxis
		if (model.getValueMin().getValue()>=0) {
			yZero = this.getHeight()-3;
			yZeroValue = model.getValueMin().getValue();
		}
		else if (model.getValueMax().getValue()<=0) {
			yZero = 3;
			yZeroValue = model.getValueMax().getValue();
		}
		else {
			yZero = Math.round(model.getValueMax().getValue()/model.getVRange()*(this.getHeight()-3));
		}
		g.drawLine(3, yZero, this.getWidth(), yZero);
		g.drawLine(this.getWidth()-3, yZero + 3, this.getWidth(), yZero);
		g.drawLine(this.getWidth()-3, yZero -3, this.getWidth(), yZero);
		
		//Yaxis
		g.drawLine(3, 0, 3, this.getHeight());
		g.drawLine(0, 3 ,3, 0);
		g.drawLine(6, 3, 3, 0);
		
	}
	
	public void setGraduation(Graphics g) {
		int maxYGrad = 10;
		int maxXGrad = 15;
		float vIncrem = (float)(model.getVRange())/(float)(maxYGrad);
		int gIncrem = Math.round(this.getHeight()*vIncrem/model.getVRange());
		xRange = this.getWidth() - 2*xGradOffset;
		//Y
		//positiv		
		for (int i = 0; i*vIncrem<=(model.getValueMax().getValue()); i++) {
			traceGradYP((yZero - i*gIncrem), Float.toString(i*vIncrem + yZeroValue), g);
		}
		//negativ
		for(int i = -1;  i*vIncrem>=(model.getValueMin().getValue()); i--) {
			traceGradYN((yZero - i*gIncrem), Float.toString(i*vIncrem), g);
		}
		
		//X
		gIncrem = xRange/maxXGrad;
		Instant startInstant = Instant.parse(model.getValueBegin().getTime());
		tRange = startInstant.until(Instant.parse(model.getValueEnd().getTime()), ChronoUnit.MILLIS);
		long tIncrement = tRange/maxXGrad;
		
		//if time range is under 1 hour
		if (tRange <= 60*60*60) {
			for (int i = 0; i<maxXGrad && startInstant.compareTo(Instant.parse(model.getValueEnd().getTime()))<=0; i++) {
				traceGradX(3+xGradOffset + i*gIncrem, startInstant.plus(tIncrement*i, ChronoUnit.MILLIS).toString().substring(14, 19), g);
			}
		}//else if time range is under 1 day
		else if (tRange <= 60*60*60*24) {
			for (int i = 0; i<maxXGrad && startInstant.compareTo(Instant.parse(model.getValueEnd().getTime()))<=0; i++) {
				traceGradX(3+xGradOffset + i*gIncrem, startInstant.plus(tIncrement*i, ChronoUnit.MILLIS).toString().substring(11, 16), g);
			}
		}//else if time range is under 40 days
		else if (tRange <= 60*60*60*24*40) {
			for (int i = 0; i<maxXGrad && startInstant.compareTo(Instant.parse(model.getValueEnd().getTime()))<=0; i++) {
				traceGradX(3+xGradOffset + i*gIncrem, startInstant.plus(tIncrement*i, ChronoUnit.MILLIS).toString().substring(8, 13).replace('T', ':'), g);
			}
		}//else if time range is under 1 year
		else if (tRange <= 60*60*60*24*365) {
			for (int i = 0; i<maxXGrad && startInstant.compareTo(Instant.parse(model.getValueEnd().getTime()))<=0; i++) {
				traceGradX(3+xGradOffset + i*gIncrem, startInstant.plus(tIncrement*i, ChronoUnit.MILLIS).toString().substring(8, 13), g);
			}
		}
		else {
			for (int i = 0; i<maxXGrad && startInstant.compareTo(Instant.parse(model.getValueEnd().getTime()))<=0; i++) {
				traceGradX(3+xGradOffset + i*gIncrem, startInstant.plus(tIncrement*i, ChronoUnit.MILLIS).toString().substring(7), g);
			}
		}
		
	}
	
	public void traceGradYP(int y, String label, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, y, 6, y);
		g.drawString(label, 5, y+15);
	}
	
	public void traceGradYN(int y, String label, Graphics g) {
		g.setColor(Color.BLACK);
		g.drawLine(0, y, 6, y);
		g.drawString(label, 5, y-3);
	}
	
	public void traceGradX(int x, String label, Graphics g) {
		g.setColor(Color.BLACK);
		if (model.getValueMax().getValue() <= 0) {
			g.drawString(label, x-5, yZero-15);
		}else {
			g.drawString(label, x-5, yZero-6);
		}
		g.drawLine(x, yZero+3, x, yZero-3);
		
	}
	
	public void tracePoint(Graphics g) {
		g.setColor(Color.BLUE);
		int rayon = 8;
		float xRatio =xRange/(float)tRange;
		float yRatio = (float)this.getHeight()/(float)model.getVRange() ;
		Instant startInstant = Instant.parse(model.getValueBegin().getTime());
		
		for(Iterator<TimedValue> it = model.getListTriee().iterator(); it.hasNext();) {
			TimedValue currTV = it.next();
			long timeMilli = startInstant.until(Instant.parse(currTV.getTime()), ChronoUnit.MILLIS);
			if (currTV.compareTo(model.getValueBegin())>=0 && currTV.compareTo(model.getValueEnd())<=0) {
				//g.drawOval(xGradOffset+3+Math.round(timeMilli*xRatio)-2, yZero - Math.round(currTV.getValue()*yRatio), 6, 6);
				g.fillOval(xGradOffset+3+Math.round(timeMilli*xRatio)-rayon/2, yZero - Math.round((currTV.getValue()-yZeroValue)*yRatio)-rayon/2, rayon, rayon);
			}
		}
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		CurveCanvasModel mod = (CurveCanvasModel)arg0;
		this.model = mod;
		this.repaint();
		
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					JFrame window = new JFrame("Curve Tracer");
					window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					window.setBounds(0, 0, 800, 800);
					window.setVisible(true);
					Captor cap = new Captor("lala", null, 1, "name", TypeCaptor.AIRCOMPRIME);
					cap.addValue(new TimedValue("2014-12-03T10:15:30.00Z", 15, "888"));
					cap.addValue(new TimedValue("2014-12-03T10:16:30.00Z", 16, "888"));
					CurveCanvasModel model = new CurveCanvasModel(cap);
					window.getContentPane().add(new CurveCanvas(model), BorderLayout.CENTER);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
}

