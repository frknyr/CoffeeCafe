package order;

import java.sql.SQLException;

public class OrderManager {
	
	public void orderAdd(int customerId,int coffeId, int amount) throws SQLException{
		OrderAdd orderAdd= new OrderAdd(new Order(customerId, coffeId, amount));
	}

}
