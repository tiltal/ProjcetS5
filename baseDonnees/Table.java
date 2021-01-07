package baseDonnees;
import java.sql.*;

public abstract class Table {

	private String infoTable;
	/**
	 * @param infoTable
	 * @param dropTable
	 */
	public Table(String infoTable) {
		super();
		this.infoTable = infoTable;
	}
	
	
	public void creerTable (Connection con) {
		
		/*ajouter la nouvelle table*/
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(infoTable);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*ajouter une ligne dans une table de la bd*/
	public void ajouterInfo (Connection con, String infoAAjouter) {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate(infoAAjouter);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
}
