package coffee;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffeeNameChange {
	private String coffeeName;
	private Integer coffeeId;
	
	public CoffeeNameChange(Integer coffeeId,String coffeeName) throws SQLException{
		this.coffeeName = coffeeName;
		this.coffeeId = coffeeId;
		coffeeNameChange();
	}

	public void coffeeNameChange() throws SQLException{
		DbHelper dbHelper= new DbHelper();
		Connection connection=  null;
		PreparedStatement preparedStatement= null;
		try {
			connection= dbHelper.getConnection();
			String sql="UPDATE COFFEE SET NAME=? WHERE COFFEEID=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, coffeeName);
			preparedStatement.setInt(2, coffeeId);
			int result= preparedStatement.executeUpdate();
			
			System.out.println("Kahve adı değiştirildi");
			
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
}
