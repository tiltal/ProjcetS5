package projet;

import baseDonnees.BaseDeDonnees;
import baseDonnees.TableCapteur;
import baseDonnees.TableValeur;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*cr�ation objet bd, la vraie cr�ation est � faire sur wampserver*/
		BaseDeDonnees bdTest = new BaseDeDonnees("test");
		
		/*------------�tablir la connexion-------------*/
		bdTest.etablirConnexion();
		TableCapteur tableCap = new TableCapteur();
		TableValeur tableVal = new TableValeur();
	
		tableCap.creerTable(bdTest.getCon());
		tableVal.creerTable(bdTest.getCon());
		
		/*test------------------pour vous donner une id�e de comment marche la BD, � supprimer -----------------------------*/
		tableCap.ajouterInfo(bdTest.getCon(), "INSERT INTO Capteur VALUES ('capteur1', 'EAU', 'U1', 0, 'toilettes')");
		tableCap.ajouterInfo(bdTest.getCon(), "INSERT INTO Capteur VALUES ('capteur2', 'TEMPERATURE', 'A4', 4, 'A4-25')");
		tableCap.ajoutCap(bdTest.getCon(), "SELECT * FROM Capteur");
		tableCap.ajoutCap(bdTest.getCon(), "SELECT * FROM Capteur");


		tableVal.ajouterInfo(bdTest.getCon(), "INSERT INTO Valeur (date, valeur, typeFluide, nomCapteur) VALUES ('25 decembre', 14.8, 'degree', 'capteur 1')");
		tableVal.ajoutVal(bdTest.getCon(), "SELECT * FROM Valeur");
		
		System.out.println("\nInfo des tables de Capteur : ");
		for(int i=0 ; i<tableCap.getCap(bdTest.getCon()).size() ; i++)
			System.out.println("Nom capteur : " + tableCap.getCap(bdTest.getCon()).get(i).getId() + ", type de fluide : " + tableCap.getCap(bdTest.getCon()).get(i).getType() );
		
		System.out.println("\nInfo des tables de Valeur : ");
		//System.out.println("Date d'enregistrement : " + tableVal.getVal(bdTest.getCon()).get(0).getDate() + ", Valeur : " + tableVal.getVal(bdTest.getCon()).get(0).getValeur() + ", type de fluide : " + tableVal.getVal(bdTest.getCon()).get(0).getTypeFluide() + ", capteur associ� : " + tableVal.getVal(bdTest.getCon()).get(0).getValeur());
		System.out.println(tableVal.getVal(bdTest.getCon()));
		System.out.println("\n-----MODIFICATION-----");
		for(int i=0 ; i<tableCap.getCap(bdTest.getCon()).size() ; i++)
			System.out.println("Nom capteur : " + tableCap.getCap(bdTest.getCon()).get(i).getId() + ", type de fluide : " + tableCap.getCap(bdTest.getCon()).get(i).getType() );
		
		//bdTest.viderBd();
		
	}


}
