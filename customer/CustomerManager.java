package customer;

import java.sql.SQLException;

public class CustomerManager {
	
	
	public void customerAdd(Customer customer) throws SQLException {
		CustomerAdd customerAdd= new CustomerAdd(customer);
	}
	
	public void customerDelete(int customerId) throws SQLException{
		CustomerDelete customerDelete= new CustomerDelete(customerId);
	}
	
	public void customerNameChange(int customerId, String newCustomerName) throws SQLException{
		CustomerNameChange customerNameChange= new CustomerNameChange(0, newCustomerName);
	}
	
	public void customerPhoneNumberChange(int customerId, String newPhoneNumber) throws SQLException{
		CustomerPhoneNumberChange customerPhoneNumberChange= new CustomerPhoneNumberChange(customerId,newPhoneNumber );
	}
	
	
	
}
