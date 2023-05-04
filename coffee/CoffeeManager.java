package coffee;

import java.sql.SQLException;

public class CoffeeManager {
	
	
	public void coffeeAdd(String coffeeName, double price) throws SQLException{
		CoffeeAdd coffeeAdd= new CoffeeAdd(new Coffee(coffeeName, price));
	}
	
	public void coffeeDelete(Integer coffeeId) throws SQLException{
		CoffeeDelete coffeeDelete= new CoffeeDelete(coffeeId);
	}
	
	public void coffeeNameChange(Integer coffeId,String coffeeName) throws SQLException{
		CoffeeNameChange coffeeNameChange= new CoffeeNameChange(coffeId, coffeeName);
	}
}
