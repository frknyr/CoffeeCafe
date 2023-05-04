package order;

import java.sql.SQLException;
import java.util.Iterator;

import coffee.Coffee;
import coffee.CoffeeList;

public class Order {
	private int customerId;
	private int coffeeId;
	private int amount;
	private double totalPrice;
	
	public Order(int customerId, int coffeId, int amount) throws SQLException{
		this.customerId = customerId;
		this.coffeeId = coffeId;
		this.amount = amount;
		setTotalPrice();
	}

	public int getCustomerId() {
		
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getCoffeId() {
		return coffeeId;
	}

	public void setCoffeId(int coffeId) {
		this.coffeeId = coffeId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public double getTotalPrice(){
		return totalPrice;
	}

	public void setTotalPrice() throws SQLException{
		CoffeeList coffeeList= new CoffeeList();
		for(Coffee coffee: coffeeList.coffees) {
			if(coffeeId==coffee.getCoffeeId()) {
				this.totalPrice=getAmount()*coffee.getPrice();
			}
		}
		
	}
	
	
	
	

}
