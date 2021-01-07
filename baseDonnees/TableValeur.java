package baseDonnees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableValeur extends Table {
	
	/*liste des valeurs de toutes les tables*/
	List<Valeur> val = new ArrayList<>();
	
	/*A chaque arrivée de nouvelle valeur, il faudra l'ajouter dans une liste de valeurs qui sera associée au capteur*/

	public TableValeur() {
		/*idValeur se remplit tout seul, on n'a pas besoin d'y toucher*/
		super("CREATE TABLE Valeur (idValeur INT PRIMARY KEY AUTO_INCREMENT, date VARCHAR(20), valeur FLOAT, typeFluide VARCHAR(20), nomCapteur VARCHAR(50))");
	}
	
	/*ajouter une nouvelle valeur*/
	public void ajoutVal (Connection con, String query) {
		ResultSet result = null;
		
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(result.next()) {
				Valeur valeur = new Valeur(result.getString(2),result.getFloat(3),result.getString(4),result.getString(5));
				
				val.add(valeur);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	/*retourne la liste de toutes les valeurs*/
	public List<Valeur> getVal() {
		return val;
	}
	
	

}
