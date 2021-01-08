package projet;

import baseDonnees.BaseDeDonnees;
import baseDonnees.TableCapteur;
import baseDonnees.TableValeur;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*création objet bd, la vraie création est à faire sur wampserver*/
		BaseDeDonnees bdTest = new BaseDeDonnees("test");
		
		/*------------établir la connexion-------------*/
		bdTest.etablirConnexion();
		TableCapteur tableCap = new TableCapteur();
		TableValeur tableVal = new TableValeur();
	
		tableCap.creerTable(bdTest.getCon());
		tableVal.creerTable(bdTest.getCon());
		
		/*test------------------pour vous donner une idée de comment marche la BD, à supprimer -----------------------------*/
		tableCap.ajouterInfo(bdTest.getCon(), "INSERT INTO Capteur VALUES ('capteur1', 'TEMPERATURE', 'U2', 2, 'U2-301')");
		tableCap.ajouterInfo(bdTest.getCon(), "INSERT INTO Capteur VALUES ('capteur2', 'TEMPERATURE', 'A4', 4, 'A4-25')");
		tableCap.ajoutCap(bdTest.getCon(), "SELECT * FROM Capteur");

		tableVal.ajouterInfo(bdTest.getCon(), "INSERT INTO Valeur (date, valeur, typeFluide, nomCapteur) VALUES ('25 decembre', 14.8, 'degree', 'capteur 1')");
		tableVal.ajoutVal(bdTest.getCon(), "SELECT * FROM Valeur");
		
		System.out.println("\nInfo des tables de Capteur : ");
		for(int i=0 ; i<tableCap.getCap().size() ; i++)
			System.out.println("Nom capteur : " + tableCap.getCap().get(i).getId() + ", type de fluide : " + tableCap.getCap().get(i).getType() );
		
		System.out.println("\nInfo des tables de Valeur : ");
		System.out.println("Date d'enregistrement : " + tableVal.getVal().get(0).getDate() + ", Valeur : " + tableVal.getVal().get(0).getValeur() + ", type de fluide : " + tableVal.getVal().get(0).getTypeFluide() + ", capteur associé : " + tableVal.getVal().get(0).getValeur());
		
		System.out.println("\n-----MODIFICATION-----");
		for(int i=0 ; i<tableCap.getCap().size() ; i++)
			System.out.println("Nom capteur : " + tableCap.getCap().get(i).getId() + ", type de fluide : " + tableCap.getCap().get(i).getType() );
		
		bdTest.viderBd();
		
	}


}
