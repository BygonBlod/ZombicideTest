package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersoDB {
	static Connection connection=null;
	public PersoDB() {
		connection = DbConnection.getInstance();
	}
	
	public String ranomPerso() throws SQLException {
		String res="";
		String sql="SELECT * FROM perso ORDER BY RAND() LIMIT 1";
		PreparedStatement prepare;
		prepare = connection.prepareStatement(sql);
		ResultSet result=prepare.executeQuery();
		while(result.next()){
			res=result.getString("NomPerso");
		}
		return res;
	}
}
