package donneesDynamique;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableCapteur extends Table {
	List<Capteur> cap = new ArrayList<>();

	public TableCapteur() {
		super("CREATE TABLE Capteur (id VARCHAR(50), typeFluide VARCHAR(20), etage INTEGER, lieu VARCHAR(20), connecte VARCHAR(1), PRIMARY KEY(id))");
		/*
		 *  il faut penser à faire un updateInfoCap après avoir reçu un message de déconnection d'un capteur 
		 * if on== false {updateInfoCap (..., "UPDATE Capteur SET connecte = 'N' WHERE nomCapteur = 'nom du capteur à modifier'")}
		 * 
		 * */
	}
	
	public void getInfoCap (Connection con, String query) {
		ResultSet result = null;
		
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(result.next()) {
				Capteur capteur = new Capteur(result.getString(1),result.getString(2),result.getInt(3),result.getString(4), result.getString(5));
				if (!cap.contains(capteur))
					cap.add(capteur);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateInfo (Connection con, String infoAModifier) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(infoAModifier);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		cap.removeAll(cap);
		getInfoCap(con, "SELECT * FROM Capteur");
	}
	

	/**
	 * @return the cap
	 */
	public List<Capteur> getCap() {
		return cap;
	}
	
	

}
