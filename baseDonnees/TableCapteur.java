package baseDonnees;

import donneesDynamique.Captor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableCapteur extends Table {
	
	/*L'ensemble des capteurs sous forme de liste*/
	List<Captor> cap = new ArrayList<>();

	public TableCapteur() {
		super("CREATE TABLE Capteur (id VARCHAR(50), typeFluide VARCHAR(20), nomBatiment VARCHAR(20), etage INTEGER, lieu VARCHAR(20), min INTEGER, max INTEGER, PRIMARY KEY(id))");
		/*
		 *  il faut penser à faire un updateInfoCap après avoir reçu un message de déconnection d'un capteur 
		 * if on== false {updateInfoCap (..., "UPDATE Capteur SET connecte = 'N' WHERE nomCapteur = 'nom du capteur à modifier'")}
		 * 
		 * */
	}
	
	/*ajout d'un nouveau capteur dans la base de données et mettre à jour la liste de capteurs*/
	public void ajoutCap (Connection con, String query) {
		/*variable permettant de récupérer les informations de la requête SQL*/
		ResultSet result = null;
		
		/*exécuter la requête SQL*/
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*Utiliser si le capteur est déjà enregistré dans la base*/
	public void updateInfo (Connection con, String infoAModifier) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(infoAModifier);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	


	//Obtenir tous les capteurs présents dans la bd/
    public List<Captor> getCap (Connection con) {
        //variable permettant de récupérer les informations de la requête SQL/
        ResultSet result = null;

        //exécuter la requête SQL/
        try {
            Statement stmt = con.createStatement();
            result = stmt.executeQuery("SELECT * FROM Capteur");
        }catch(SQLException e) {
            e.printStackTrace();
        }

        try {
            //Pour chaque ligne de la table de capteurs/
            while(result.next()) {

                //affecter les champs correspondant avec les informations données par la requête, à la fin la liste de valeurs associée/
                Captor capteur = new Captor(result.getString(1),result.getString(3),result.getInt(4),result.getString(5),result.getString(2), result.getInt(6), result.getInt(7));
                cap.add(capteur);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }

        return cap;

    }
	
	

}
