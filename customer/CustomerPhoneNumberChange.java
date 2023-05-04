package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import coffee.DbHelper;

public class CustomerPhoneNumberChange {
	private String newPhoneNumber;
	private int customerId;
	
	
	public CustomerPhoneNumberChange(int customerId,String newPhoneNumber ) throws SQLException{
		this.newPhoneNumber = newPhoneNumber;
		this.customerId = customerId;
		phoneNumberChange();
	}


	public void phoneNumberChange() throws SQLException{
		
		DbHelper dbHelper= new DbHelper();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		try {
			connection= dbHelper.getConnection();
			String sql="UPDATE CUSTOMER SET PHONENUMBER=? WHERE CUSTOMERID=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, newPhoneNumber);
			preparedStatement.setInt(2, customerId);
			int result= preparedStatement.executeUpdate();
			
			System.out.println("Müşterinin telefon numarası güncellendi");
			
			
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
}
