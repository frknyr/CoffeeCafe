package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import coffee.DbHelper;

public class CustomerList {
	public ArrayList<Customer> customers= new ArrayList<>();
	
	public void customerList() throws SQLException{
		String sql="SELECT * FROM CUSTOMER";
		Customer customer;
		
		DbHelper dbHelper= new DbHelper();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet;
		
		try {
			connection=dbHelper.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				customer= new Customer(resultSet.getString("NAMESURNAME"),
						resultSet.getString("PHONENUMBER"));
				
				customers.add(customer);
			}
		} catch (SQLException exception) {
			dbHelper.showErrorMessage(exception);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}
}
