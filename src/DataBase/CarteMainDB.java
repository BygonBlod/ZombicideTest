package DataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CarteMain;

public class CarteMainDB {
	static Connection connection=null;
	public CarteMainDB() {
		connection = DbConnection.getInstance();
	}
	
	public ArrayList<CarteMain> getCarteMain() throws SQLException{
		ArrayList<CarteMain> res=new ArrayList<CarteMain>();
		String sql="Select * from cartemain";
		PreparedStatement prepare=connection.prepareStatement(sql);
		ResultSet result=prepare.executeQuery();
		int i=0;
		while(result.next()){
			System.out.println(i+" : "+result.getString("nomcartemain")+" : "+result.getInt("distance")+" : "+result.getInt("nbdes")+" : "+result.getInt("scorede")+" : "+result.getInt("degat")+" : "+result.getInt("porte")+" : "+result.getString("text"));
			res.add(new CarteMain(result.getString("nomcartemain"),result.getInt("distance"),result.getInt("nbdes"),result.getInt("scorede"),result.getInt("degat"),result.getInt("porte"),result.getInt("magic"),result.getString("text")));
			i++;
		}
		return res;
	}
	public CarteMain getAleaCarte() throws SQLException {
		CarteMain res=null;
		String sql="SELECT * FROM cartemain ORDER BY RAND() LIMIT 1";
		PreparedStatement prepare;
		prepare = connection.prepareStatement(sql);
		ResultSet result=prepare.executeQuery();
		while(result.next()){
			res=new CarteMain(result.getString("nomcartemain"),result.getInt("distance"),result.getInt("nbdes"),result.getInt("scorede"),result.getInt("degat"),result.getInt("porte"),result.getInt("magic"),result.getString("text"));
		}
		return res;
	}
}
