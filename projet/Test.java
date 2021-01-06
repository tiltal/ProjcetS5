package projet;

import donneesDynamique.BaseDeDonnees;
import donneesDynamique.BatimentBD;
import donneesDynamique.TableBatiment;
import donneesDynamique.TableCapteur;
import donneesDynamique.TableValeur;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BaseDeDonnees bdTest = new BaseDeDonnees("test");
		
		/*------------établir la connexion-------------*/
		bdTest.etablirConnexion();
		TableBatiment tableBat = new TableBatiment();
		TableCapteur tableCap = new TableCapteur();
		TableValeur tableVal = new TableValeur();
		
		tableBat.creerTable(bdTest.getCon());
		
		/* test*/
		tableBat.ajouterInfo(bdTest.getCon(), "INSERT INTO Batiment VALUES ('U2')");
		tableBat.ajouterInfo(bdTest.getCon(), "INSERT INTO Batiment VALUES ('A4')");
		tableBat.getInfoBat(bdTest.getCon(), "SELECT * FROM Batiment");
		/*fin test*/
		
		tableCap.creerTable(bdTest.getCon());
		
		/*test*/
		tableCap.ajouterInfo(bdTest.getCon(), "INSERT INTO Capteur VALUES ('capteur1', 'TEMPERATURE', 2, 'U2', 'Y')");
		tableCap.ajouterInfo(bdTest.getCon(), "INSERT INTO Capteur VALUES ('capteur2', 'TEMPERATURE', 4, 'A4', 'Y')");
		tableCap.getInfoCap(bdTest.getCon(), "SELECT * FROM Capteur");
		/*fin test*/
		
		tableVal.creerTable(bdTest.getCon());
		/*test*/
		tableVal.ajouterInfo(bdTest.getCon(), "INSERT INTO Valeur VALUES ('25 decembre', 14.8, 'degree', 'capteur 1')");
		tableVal.getInfoVal(bdTest.getCon(), "SELECT * FROM Valeur");
		/*fin test*/
		
		/*test*/
		System.out.println("Nom de la base de données : " + bdTest.getNomBase());
		System.out.println("\nInfo des tables de batiment : ");
		for(BatimentBD batiment : tableBat.getBat())
			System.out.println(batiment.getNomBat());
		
		System.out.println("\nInfo des tables de Capteur : ");
		for(int i=0 ; i<tableCap.getCap().size() ; i++)
			System.out.println("Nom capteur : " + tableCap.getCap().get(i).getNomCapteur() + ", type de fluide : " + tableCap.getCap().get(i).getTypeFluide() + ", connecté ou non : " + tableCap.getCap().get(i).getConnecte());
		
		System.out.println("\nInfo des tables de Valeur : ");
		System.out.println("Date d'enregistrement : " + tableVal.getVal().get(0).getDate() + ", Valeur : " + tableVal.getVal().get(0).getValeur() + ", type de fluide : " + tableVal.getVal().get(0).getTypeFluide() + ", capteur associé : " + tableVal.getVal().get(0).getValeur());
		
		System.out.println("\n-----MODIFICATION-----");
		tableCap.updateInfo(bdTest.getCon(), "UPDATE Capteur SET connecte = 'N' WHERE id = 'capteur2'");
		for(int i=0 ; i<tableCap.getCap().size() ; i++)
			System.out.println("Nom capteur : " + tableCap.getCap().get(i).getNomCapteur() + ", type de fluide : " + tableCap.getCap().get(i).getTypeFluide() + ", connecté ou non : " + tableCap.getCap().get(i).getConnecte());
		/*fin test*/
		
		bdTest.viderBd();
	}


}
