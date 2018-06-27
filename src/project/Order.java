package project;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Order {
	
	private Date date;
	private List<Product> products = new ArrayList<Product>();
	
	public Order(Date date, List<Product> products) {
		super();
		this.date = date;
		this.products = products;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for (Product valueproduct : products) {
		    builder.append(valueproduct);
		}
		String newStringProducts = builder.toString();
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		String newdate = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
		return  newdate + "" + "\n" + newStringProducts;
	} 
	
	
	
	
	
}
