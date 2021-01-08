package baseDonnees;

import donneesDynamique.TimedValue;
import donneesDynamique.Captor;
import java.util.List;

public class Memoire {
	private BaseDeDonnees bd;
	public TableCapteur tableCap;
	TableValeur tableVal;
	
	public Memoire() {
		this.bd = new BaseDeDonnees("test");
		
		bd.etablirConnexion();
		this.tableCap = new TableCapteur();
		this.tableVal = new TableValeur();
		tableCap.creerTable(bd.getCon());
		tableVal.creerTable(bd.getCon());
	}
	
	public void addCap(Captor cap) {
		String s =  "INSERT INTO Capteur VALUES ('" + cap.getId() + "', '" + cap.getType() + "', '" +
		cap.getBatiment() + "', " + cap.getEtage() + ", '" + cap.getLieu() + "')";
				
		tableCap.ajouterInfo(bd.getCon(),s);
		tableCap.ajoutCap(bd.getCon(), "SELECT * FROM Capteur");
	}
	
	public List<Captor> getCap() {
		return tableCap.getCap();	
	}
	
	public void videbd() {
		bd.viderBd();
	}
	public void addValue(TimedValue tval,String id) {
		String s =  "INSERT INTO Valeur (date, valeur, typeFluide, nomCapteur) VALUES ('" + tval.getTime() + "', '" + tval.getValue() + "', '" +
		"EAU" + "', '" + id + "')";
		tableVal.ajouterInfo(bd.getCon(), s);
		tableVal.ajoutVal(bd.getCon(), "SELECT * FROM Valeur");
	}
}
