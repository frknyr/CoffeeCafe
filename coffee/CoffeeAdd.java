package coffee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoffeeAdd {
	private Coffee coffee;
	
	public CoffeeAdd(Coffee coffee) throws SQLException{
		this.coffee=coffee;
		coffeeAdd();
	}

	public void coffeeAdd() throws SQLException{
		DbHelper dbHelper= new DbHelper();
		Connection connection=  null;
		PreparedStatement preparedStatement= null;
		
		try {
			connection= dbHelper.getConnection();
			String sql="INSERT INTO coffee(NAME,PRICE) VALUES (?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, coffee.getName());
			preparedStatement.setDouble(2, coffee.getPrice());
			int result= preparedStatement.executeUpdate();
			
			System.out.println("Kahve eklendi");
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		}finally {
			preparedStatement.close();
			connection.close();
		}
		
	}
	
}
