package donneesDynamique;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class AnalyseModel extends Observable{
	CurveCanvasModel canvas1 = null;
	CurveCanvasModel canvas2 = null;
	CurveCanvasModel canvas3 = null;
	
	public CurveCanvasModel getCanvas1() {
		return canvas1;
	}
	public void setCanvas1(CurveCanvasModel canvas1) {
		this.canvas1 = canvas1;
	}
	public CurveCanvasModel getCanvas2() {
		return canvas2;
	}
	public void setCanvas2(CurveCanvasModel canvas2) {
		this.canvas2 = canvas2;
	}
	public CurveCanvasModel getCanvas3() {
		return canvas3;
	}
	public void setCanvas3(CurveCanvasModel canvas3) {
		this.canvas3 = canvas3;
	}
	
	
	
}
