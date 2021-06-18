package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompetenceDB {
	static Connection connection=null;
	public CompetenceDB() {
		connection = DbConnection.getInstance();
	}
	
	public String getFirst(String name) throws SQLException {
		String res="";
		String sql="Select * from perso where NomPerso= ?";
		PreparedStatement prepare;
		prepare = connection.prepareStatement(sql);
		prepare.setString(1,name);
		ResultSet result=prepare.executeQuery();
		while(result.next()){
			res=result.getString("comp1");
		}
		return res;
	}
	public String getSecond(String name) throws SQLException {
		String res="";
		String sql="Select * from perso where NomPerso= ?";
		PreparedStatement prepare;
		prepare = connection.prepareStatement(sql);
		prepare.setString(1,name);
		ResultSet result=prepare.executeQuery();
		while(result.next()){
			res=result.getString("comp2");
		}
		return res;
	}
	public ArrayList<String> getThird(String name) throws SQLException{
		ArrayList<String> res=new ArrayList<String>();
		String sql="Select * from perso where NomPerso= ?";
		PreparedStatement prepare;
		prepare = connection.prepareStatement(sql);
		prepare.setString(1,name);
		ResultSet result=prepare.executeQuery();
		while(result.next()){
			res.add(result.getString("comp3"));
			res.add(result.getString("comp4"));
		}
		return res;
		
	}
	public ArrayList<String> getFourth(String name) throws SQLException{
		ArrayList<String> res=new ArrayList<String>();
		String sql="Select * from perso where NomPerso= ?";
		PreparedStatement prepare;
		prepare = connection.prepareStatement(sql);
		prepare.setString(1,name);
		ResultSet result=prepare.executeQuery();
		while(result.next()){
			res.add(result.getString("comp5"));
			res.add(result.getString("comp6"));
			res.add(result.getString("comp7"));
		}
		return res;
		
	}
}
