package coffee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffePriceChange{
	private int coffeeId;
	private double coffeePrice;
	
	public void coffeePriceChange() throws SQLException{
		DbHelper dbHelper= new DbHelper();
		Connection connection=  null;
		PreparedStatement preparedStatement= null;
		try {
			connection= dbHelper.getConnection();
			String sql= "UPDATE COFFEE SET PRICE=? WHERE COFFEEID=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setDouble(1, coffeePrice);
			preparedStatement.setInt(2, coffeeId);
			int result= preparedStatement.executeUpdate();
			
			System.out.println("Kahve fiyatı değiştirildi");
			
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}

}
