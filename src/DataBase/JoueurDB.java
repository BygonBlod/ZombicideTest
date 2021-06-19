package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Joueur;

public class JoueurDB {
	static Connection connection=null;
	public JoueurDB() {
		connection = DbConnection.getInstance();
	}
	
	public Joueur connexion(String n,String p) throws SQLException {
		Joueur res=null;
		String sql="select * from Joueur where Pseudo= ? and pwd= ?";
		PreparedStatement prepare;
		prepare = connection.prepareStatement(sql);
		prepare.setString(1, n);
		prepare.setString(2, p);
		ResultSet result=prepare.executeQuery();
		while(result.next()){
			res=new Joueur(result.getString("Pseudo"));
		}
		return res;
	}

}
