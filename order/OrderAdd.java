package order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import coffee.DbHelper;

public class OrderAdd {
	private Order order;
	
	public OrderAdd(Order order) throws SQLException{
		this.order=order;
		orderAdd();
	}
	
	public void orderAdd() throws SQLException{
		DbHelper dbHelper= new DbHelper();
		Connection connection= null;
		PreparedStatement preparedStatement= null;
		
		try {
			connection= dbHelper.getConnection();
			String sql= "INSERT INTO coffee.order(CUSTOMERID,COFFEID,AMOUNT,TOTALPRICE) VALUES (?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1,order.getCustomerId());
			preparedStatement.setInt(2,order.getCoffeId());
			preparedStatement.setInt(3,order.getAmount());
			preparedStatement.setDouble(4,order.getTotalPrice());
			int result= preparedStatement.executeUpdate();
			
			System.out.println("Sipariş oluşturuldu");
			
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
}
