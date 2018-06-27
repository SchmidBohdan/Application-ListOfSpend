package project;

public class Product {

	 private String title;
     private double price;
     private String currency;
	
     public Product(String title, double price, String currency) {
		super();
		this.title = title;
		this.price = price;
		this.currency = currency;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Override
	public String toString() {
		
		return title + " " + price + " " + currency + "\n";
	}
     
     
     
     
     
}
