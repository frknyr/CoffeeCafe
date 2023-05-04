package customer;

public class Customer {
	
	private String nameSurname;
	private String phoneNumber;
	
	
	public Customer(String nameSurname, String phoneNumber) {
		this.nameSurname = nameSurname;
		this.phoneNumber = phoneNumber;
	}


	public String getNameSurname() {
		return nameSurname;
	}


	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}


	public String getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	

}
