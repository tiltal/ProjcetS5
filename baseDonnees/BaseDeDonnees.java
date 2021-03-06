package baseDonnees;
import java.sql.*;

public class BaseDeDonnees {
	
	private String nomBase;
	private Connection con = null;

	/**
	 * @param nomBase
	 */
	public BaseDeDonnees(String nomBase) {
		super();
		this.nomBase = nomBase;
	}
	
	
	public void etablirConnexion() {
		/*�tablir la connexion*/
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",
					"root",
					"");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void viderBd() {
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DROP TABLE Valeur");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		try {
			Statement stmt = con.createStatement();
			stmt.executeUpdate("DROP TABLE Capteur");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * @return the con
	 */
	public Connection getCon() {
		return con;
	}


	/**
	 * @return the nomBase
	 */
	public String getNomBase() {
		return nomBase;
	}
	
	
	
}
