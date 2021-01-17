package baseDonnees;

import donneesDynamique.TimedValue;
import donneesDynamique.Captor;

import java.util.Iterator;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

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
		cap.getBatiment() + "', " + cap.getEtage() + ", '" + cap.getLieu() + "', " + cap.getBorneInf() + ", " + cap.getBorneSup() + ")";
				
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
		List<TimedValue> list = tableVal.getVal(bd.getCon()); 
		NavigableSet<TimedValue> values = new TreeSet<>();
		TimedValue val;
		for (Iterator<TimedValue> iter = list.iterator(); iter.hasNext();) {
			val = iter.next();
			if(val.getIdCap().equals(id)) {
				values.add(val);
			}
			
		}
		return values;
	}
	

	
	
	public void changeBornes(float min, float max, String id) {
		tableCap.updateInfo(bd.getCon(), "UPDATE Capteur SET min = '" + min + "' WHERE id = '" + id + "'");
		tableCap.updateInfo(bd.getCon(), "UPDATE Capteur SET max = '" + max + "' WHERE id = '" + id + "'");
	}
}
