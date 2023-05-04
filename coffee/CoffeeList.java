package coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CoffeeList {
	
	public ArrayList<Coffee> coffees= new ArrayList<>();
	
	public CoffeeList() throws SQLException{
		coffeList();
	}
	public void coffeList() throws SQLException{
		Coffee coffee;
		DbHelper dbHelper= new DbHelper();
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet;
		String sql="SELECT * FROM COFFEE";
		
		try {
			connection=dbHelper.getConnection();
			
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				coffee= new Coffee(resultSet.getInt("COFFEEID"),
						resultSet.getString("NAME"),
						resultSet.getDouble("PRİCE"));
				coffees.add(coffee);
			}
			
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
}
