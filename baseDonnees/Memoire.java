package baseDonnees;

import donneesDynamique.TimedValue;
import donneesDynamique.Captor;
import java.util.List;
import java.util.NavigableSet;

public class Memoire {
	private BaseDeDonnees bd;
	public TableCapteur tableCap;
	TableValeur tableVal;
	
	public Memoire() {
		this.bd = new BaseDeDonnees("test");
		
		bd.etablirConnexion();
		this.tableCap = new TableCapteur();
		this.tableVal = new TableValeur();
	}
	
	public void addCap(Captor cap) {
		String s =  "INSERT INTO Capteur VALUES ('" + cap.getId() + "', '" + cap.getType() + "', '" +
		cap.getBatiment() + "', " + cap.getEtage() + ", '" + cap.getLieu() + "')";
				
		tableCap.ajouterInfo(bd.getCon(),s);
	}
	
	public List<Captor> getCap() {
		return tableCap.getCap(bd.getCon());	
	}
	
	public void videbd() {
		bd.viderBd();
		tableCap.creerTable(bd.getCon());
		tableVal.creerTable(bd.getCon());
	}
	
	public void addValue(TimedValue tval,String id) {
		String s =  "INSERT INTO Valeur (date, valeur, typeFluide, nomCapteur) VALUES ('" + tval.getTime() + "', '" + tval.getValue() + "', '" +
		"EAU" + "', '" + id + "')";
		tableVal.ajouterInfo(bd.getCon(), s);
	}
	
	public NavigableSet<TimedValue> getValue(String id){
		//TO DO
		return null;
	}
	

	
	
	public void changeBornes(float min, float max) {
		//TO DO
	}
}
