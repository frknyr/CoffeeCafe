package coffee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffeeDelete{
	private int coffeeId;
	
	
	public CoffeeDelete(int coffeeId) throws SQLException{
		this.coffeeId = coffeeId;
		coffeeDelete();
	}


	public void coffeeDelete() throws SQLException{
		DbHelper dbHelper= new DbHelper();
		Connection connection=  null;
		PreparedStatement preparedStatement= null;
		try {
			connection=dbHelper.getConnection();
			String sql= "DELETE FROM COFFEE WHERE COFFEEID=?";
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setInt(1, coffeeId);
			int result= preparedStatement.executeUpdate();
			
			System.out.println("Kahve silindi");
			
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		
		
	}
}
