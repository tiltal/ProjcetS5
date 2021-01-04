package donneesDynamique;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Set;
import java.util.TreeSet;

public class TableBatiment extends Table {
	
	Set<BatimentBD> bat = new TreeSet<>();

	public TableBatiment() {
		super("CREATE TABLE Batiment (nomBatiment VARCHAR(50), PRIMARY KEY(nomBatiment))");
	}
	
	public void getInfoBat (Connection con, String query) {
		ResultSet result = null;
		
		try {
			Statement stmt = con.createStatement();
			result = stmt.executeQuery(query);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			
			while(result.next()) {
				BatimentBD batiment = new BatimentBD(result.getString(1));
				bat.add(batiment);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * @return the bat
	 */
	public Set<BatimentBD> getBat() {
		return bat;
	}
	
	
}
