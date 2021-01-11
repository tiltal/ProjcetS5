package baseDonnees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import donneesDynamique.Captor;

public class TableValeur extends Table {
	
	/*liste des valeurs de toutes les tables*/
	List<Valeur> val = new ArrayList<>();
	
	/*A chaque arriv�e de nouvelle valeur, il faudra l'ajouter dans une liste de valeurs qui sera associ�e au capteur*/

	public TableValeur() {
		/*idValeur se remplit tout seul, on n'a pas besoin d'y toucher*/
		super("CREATE TABLE Valeur (idValeur INT PRIMARY KEY AUTO_INCREMENT, date VARCHAR(40), valeur FLOAT, typeFluide VARCHAR(20), nomCapteur VARCHAR(50))");
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
		
		
	}

	/*retourne la liste de toutes les valeurs*/
	public List<Valeur> getVal(Connection con) {
		//variable permettant de r�cup�rer les informations de la requ�te SQL/
        ResultSet result = null;

        //ex�cuter la requ�te SQL/
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeQuery("SELECT * FROM Valeur");
        }catch(SQLException e) {
            e.printStackTrace();
        }

        try {
            //Pour chaque ligne de la table de capteurs/
            while(result.next()) {

                //affecter les champs correspondant avec les informations donn�es par la requ�te, � la fin la liste de valeurs associ�e/
            	Valeur valeur = new Valeur(result.getString(2),result.getFloat(3),result.getString(4),result.getString(5));
                val.add(valeur);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return val;
	}
	
	

}
