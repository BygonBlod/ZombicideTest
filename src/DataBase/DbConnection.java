package DataBase;

import java.sql.*;

/**
 * classe qui permet de se connecter � la base de donn�es
 * @author Antonin
 *
 */
public class DbConnection {

	/**
	 * JDBC driver
	 */
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	/**
	 * chemin du nom de la base de donn�es
	 */
	static final String DB_URL = "jdbc:mysql://localhost/zombicide";

	/**
	 * nom utilisateur
	 */
	static final String USER = "root";

	/**
	 * mot de passe 
	 */
	static final String PASS = "root";

	/**
	 * connection � la base de donn�e
	 */
	private static Connection connection; 

	/**
	 * retourne la connection � la base de donn�es
	 * 
	 * @return
	 */
	public static Connection getInstance()
	{
		if (null == connection) {
			try {
				Class.forName(JDBC_DRIVER);
				connection = DriverManager.getConnection(DB_URL+ "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC",USER,PASS);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

	/**
	 * Cferme la connectio � la base de don�es
	 */
	public static void close()
	{
		try{
			if(connection != null) {
				connection.close();
				connection = null;
			}
		} catch(SQLException se){
			se.printStackTrace();
		}	
	}
	
	
}
