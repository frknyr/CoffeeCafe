package coffee;

public class Coffee {
	private int coffeeId;
	private String name;
	private double price;
	
	
	public Coffee(String name, double price) {
		this.name = name;
		this.price = price;
	}
	

	public Coffee(int coffeeId, String name, double price) {
		this.coffeeId = coffeeId;
		this.name = name;
		this.price = price;
	}





	public int getCoffeeId() {
		return coffeeId;
	}



	public void setCoffeeId(int coffeeId) {
		this.coffeeId = coffeeId;
	}



	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	
	

}
