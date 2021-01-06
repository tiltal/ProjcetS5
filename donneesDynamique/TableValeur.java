package donneesDynamique;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import baseDonnees.Valeur;

public class TableValeur extends Table {
	
	List<Valeur> val = new ArrayList<>();

	public TableValeur() {
		super("CREATE TABLE Valeur (date VARCHAR(20), valeur FLOAT, typeFluide VARCHAR(20), nomCapteur VARCHAR(50), PRIMARY KEY (date))");
	}
	
	public void getInfoVal (Connection con, String query) {
		ResultSet result = null;
		
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(result.next()) {
				Valeur valeur = new Valeur(result.getString(1),result.getFloat(2),result.getString(3),result.getString(4));
				
				val.add(valeur);
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
		
		val.removeAll(val);
		getInfoVal(con, "SELECT * FROM Capteur");
	}
	

	/**
	 * @return the val
	 */
	public List<Valeur> getVal() {
		return val;
	}
	
	

}
