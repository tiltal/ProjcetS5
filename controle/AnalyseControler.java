package controle;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import affichage.Analyse;
import donneesDynamique.TypeCaptor;
import donneesDynamique.Captor;
import donneesDynamique.CurveCanvasModel;

public class AnalyseControler implements ActionListener {

	Analyse vue;

	public AnalyseControler(Analyse vue) {
		this.vue = vue;
		this.vue.fluideBox.addActionListener(this);
		this.vue.capteur1Box.addActionListener(this);
		this.vue.capteur2Box.addActionListener(this);
		this.vue.capteur3Box.addActionListener(this);
		this.vue.startDateBox.addActionListener(this);
		this.vue.endDateBox.addActionListener(this);

		setAllCap();
		


	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == vue.fluideBox) {
			vue.model.setFluid(findType((String) vue.fluideBox.getSelectedItem()));
			setAllCap();
			setAllCanvas();
			vue.update();
		} else if (arg0.getSource() == vue.capteur1Box) {
			vue.model.setCap1((Captor) vue.capteur1Box.getSelectedItem());
			vue.model.setDateList();
			vue.model.setCanvas1(new CurveCanvasModel(vue.model.getCap1(), vue.model.getStartDate(), vue.model.getEndDate()));
			vue.model.getCanvas1().notifyObservers();
			vue.update( null, "date");
			

		} else if (arg0.getSource() == vue.capteur2Box) {
			vue.model.setCap2((Captor) vue.capteur2Box.getSelectedItem());
			vue.model.setDateList();
			vue.model.setCanvas2(new CurveCanvasModel(vue.model.getCap2(), vue.model.getStartDate(), vue.model.getEndDate()));
			vue.model.getCanvas2().notifyObservers();
			vue.update(null, "date");

		} else if (arg0.getSource() == vue.capteur3Box) {
			vue.model.setCap3((Captor) vue.capteur3Box.getSelectedItem());
			vue.model.setDateList();
			vue.model.setCanvas3(new CurveCanvasModel(vue.model.getCap3(), vue.model.getStartDate(), vue.model.getEndDate()));
			vue.model.getCanvas3().notifyObservers();
			vue.update(null, "date");

		} else if (arg0.getSource() == vue.startDateBox) {
			vue.model.setStartDate((String)vue.startDateBox.getSelectedItem());
			setAllCanvas();

		} else if (arg0.getSource() == vue.endDateBox) {
			vue.model.setEndDate((String) vue.endDateBox.getSelectedItem());
			setAllCanvas();

		}

	}
	
	public void setAllCanvas() {
		if(vue.model.getDateList() != null) {
			vue.model.setTimeInterval(vue.model.getDateList().first(), vue.model.getDateList().last());
			vue.model.setCanvas1(new CurveCanvasModel(vue.model.getCap1(), vue.model.getStartDate(), vue.model.getEndDate()));
			vue.model.setCanvas2(new CurveCanvasModel(vue.model.getCap2(), vue.model.getStartDate(), vue.model.getEndDate()));
			vue.model.setCanvas3(new CurveCanvasModel(vue.model.getCap3(), vue.model.getStartDate(), vue.model.getEndDate()));
			vue.model.getCanvas1().addObserver(vue.curve1);
			vue.model.getCanvas2().addObserver(vue.curve2);
			vue.model.getCanvas3().addObserver(vue.curve3);
			vue.update(null, "allCanvas");
			vue.model.getCanvas1().notifyObservers();
			vue.model.getCanvas2().notifyObservers();
			vue.model.getCanvas3().notifyObservers();
		}
	}
	
	private void setAllCap() {
		if (vue.model.getCaptorList().get(vue.model.getFluid()).isEmpty()){
			vue.model.setCap1(null);
			vue.model.setCap2(null);
			vue.model.setCap3(null);
		}else
		{
			vue.model.setCap1(vue.model.getCaptorList().get(vue.model.getFluid()).first());
			vue.model.setCap2(vue.model.getCaptorList().get(vue.model.getFluid()).first());
			vue.model.setCap3(vue.model.getCaptorList().get(vue.model.getFluid()).first());
		}
		
		vue.capteur1Box.setSelectedItem(vue.model.getCap1());
		vue.capteur2Box.setSelectedItem(vue.model.getCap2());
		vue.capteur3Box.setSelectedItem(vue.model.getCap3());
		vue.model.setDateList();
		setAllCanvas();
		vue.update( null, "date");
	}
	


	private TypeCaptor findType(String type) {
		TypeCaptor typec;
		switch (type) {
		case "EAU":
			typec = TypeCaptor.EAU;
			break;
		case "ELECTRICITE":
			typec = TypeCaptor.ELECTRICITE;
			break;

		case "AIRCOMPRIME":
			typec = TypeCaptor.AIRCOMPRIME;
			break;

		default:
			typec = TypeCaptor.TEMPERATURE;
			break;

		}
		return typec;
	}

}
