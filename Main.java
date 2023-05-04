

import java.sql.SQLException;
import coffee.*;
import coffee.CoffeeList;
import customer.Customer;
import customer.CustomerManager;
import order.OrderAdd;
import order.OrderManager;

public class Main {

	public static void main(String[] args) throws SQLException{
		
		
		
		
		OrderManager orderManager= new OrderManager();
		CustomerManager customerManager= new CustomerManager();
		
		orderManager.orderAdd(1,1,2);
		
		/* Customer Add
		customerManager.customerAdd(new Customer(customerName.toUpperCase(), phoneNumber));
		/**/
		
		/* Customer Delete
		customerManager.customerDelete(customerId);
		*/
		
		/* Customer Name Change
		customerManager.customerNameChange(customerId,newName);
		*/
		
		/* Customer Phone Number Change
		customerManager.customerPhoneNumberChange(customerId,newPhoneNumber);
		*/
		
	}
}
	
