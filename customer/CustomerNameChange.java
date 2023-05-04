package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import coffee.DbHelper;

public class CustomerNameChange {
	private int customerId;
	private String newCustomerName;
	
	
	public CustomerNameChange(int customerId, String newCustomerName) throws SQLException{
		this.customerId = customerId;
		this.newCustomerName = newCustomerName;
		nameChange();
	}


	public void nameChange() throws SQLException{
		String sql="UPDATE CUSTOMER SET NAMESURNAME=? WHERE CUSTOMERID=?";
		
		DbHelper dbHelper= new DbHelper();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection= dbHelper.getConnection();
			preparedStatement= connection.prepareStatement(sql);
			preparedStatement.setString(1, newCustomerName);
			preparedStatement.setInt(2, customerId);
			int result= preparedStatement.executeUpdate();
			
			System.out.println("Müşterinin adı güncellendi");
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
		
	}

}
