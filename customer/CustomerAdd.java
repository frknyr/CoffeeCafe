package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import coffee.DbHelper;

public class CustomerAdd  {
	
	private Customer customer;
	
	public CustomerAdd(Customer customer) throws SQLException {
		this.customer= customer;
		customerAdd();
	}
	
	public void customerAdd() throws SQLException {
		DbHelper dbHelper= new DbHelper();
		Connection connection= null;
		PreparedStatement preparedStatement=null;
		
		
		connection= dbHelper.getConnection();
		String sql="INSERT INTO CUSTOMER (NAMESURNAME,PHONENUMBER) VALUES (?,?)";
		preparedStatement= connection.prepareStatement(sql);
		preparedStatement.setString(1, customer.getNameSurname());
		preparedStatement.setString(2, customer.getPhoneNumber());
		int result= preparedStatement.executeUpdate();
		
		System.out.println("Yeni müşteri kaydı oluşturuldu");
				
	}
	
}
