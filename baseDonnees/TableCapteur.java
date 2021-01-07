package baseDonnees;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TableCapteur extends Table {
	
	/*L'ensemble des capteurs sous forme de liste*/
	List<Capteur> cap = new ArrayList<>();

	public TableCapteur() {
		super("CREATE TABLE Capteur (id VARCHAR(50), typeFluide VARCHAR(20), nomBatiment VARCHAR(20), etage INTEGER, lieu VARCHAR(20), connecte VARCHAR(1), PRIMARY KEY(id))");
		/*
		 *  il faut penser � faire un updateInfoCap apr�s avoir re�u un message de d�connection d'un capteur 
		 * if on== false {updateInfoCap (..., "UPDATE Capteur SET connecte = 'N' WHERE nomCapteur = 'nom du capteur � modifier'")}
		 * 
		 * */
	}
	
	/*ajout d'un nouveau capteur dans la base de donn�es et mettre � jour la liste de capteurs*/
	public void ajoutCap (Connection con, String query) {
		/*variable permettant de r�cup�rer les informations de la requ�te SQL*/
		ResultSet result = null;
		
		/*ex�cuter la requ�te SQL*/
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			/*Pour chaque ligne de la table de capteurs*/
			while(result.next()) {
				/*cr�er une liste vide de valeurs associ�es*/
				List<Valeur> listeValeurs = new ArrayList<>();
				
				/*affecter les champs correspondant avec les informations donn�es par la requ�te, � la fin la liste de valeurs associ�e*/
				Capteur capteur = new Capteur(result.getString(1),result.getString(2), result.getString(3),result.getInt(4),result.getString(5), result.getString(6), listeValeurs);
				
				/*si ce capteur n'existe pas encore dans la liste des capteurs*/ 
				/*impossible d'avoir deux capteurs de m�me nom dans la table de capteurs, ce la provoquerait une erreur
				 * donc la v�rification d'existance est � faire avant de choisi d'utiliser ajout / update */
				if (!cap.contains(capteur))
					cap.add(capteur);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*Utiliser si le capteur est d�j� enregistr� dans la base*/
	public void updateInfo (Connection con, String infoAModifier) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(infoAModifier);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		/*mettre � jour la liste de capteur*/
		cap.removeAll(cap);
		ajoutCap(con, "SELECT * FROM Capteur");
	}
	


	/*Getter sur la liste des capteurs enregistr�s dans la base*/
	public List<Capteur> getCap() {
		return cap;
	}
	
	

}
