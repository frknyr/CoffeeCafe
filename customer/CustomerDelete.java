package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import coffee.DbHelper;

public class CustomerDelete {
	private int customerId;
	
	public CustomerDelete(int customerId) throws SQLException{
		this.customerId=customerId;
		customerDelete();
	}
	
	public void customerDelete() throws SQLException{
		DbHelper dbHelper= new DbHelper();
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		ResultSet resulSet;
		
		
		
		connection= dbHelper.getConnection();
		String sql= "DELETE FROM CUSTOMER WHERE CUSTOMERID=?";
		preparedStatement=connection.prepareStatement(sql);
		preparedStatement.setInt(1, customerId);
		int result= preparedStatement.executeUpdate();
		
		System.out.println("Müşteri kaydı silindi");
		
		
	}
}
