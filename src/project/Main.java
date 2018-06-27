package project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	
	
	public static void menu(){
	  System.out.println("////////////////////////////////////");
	  System.out.println("Welcome");
	  System.out.println("Print 1 if you want to add");
	  System.out.println("Print 2 if you want to show all list");
	  System.out.println("Print 3 if you want to show sorted list by date");
	  System.out.println("Print 4 if you want to delete Orders by Date");
	  System.out.println("Print 5 if you want to Total amount from range");
	  System.out.println("Print 6 if you want to EXIT");
	  System.out.println("////////////////////////////////////");
	}

	public static void main(String[] args) throws ParseException {
		
		Scanner scanner = new Scanner(System.in);
		OrderLogic service = new OrderLogic();
		
		while(true){
			
		menu();
		int number = scanner.nextInt();
		switch(number){
		case 1:{
			System.out.println("Enter currency");
			String currency = scanner.next();
			
			System.out.println("Enter data");
			String date = scanner.next();
			
			System.out.println("Enter title");
			String title = scanner.next();
			
			System.out.println("Enter price");
			double price = scanner.nextDouble();
			
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date newdate = (Date) dateformat.parse(date);
			
			List<Product> product = new ArrayList<Product>();
			product.add(new Product(title,price,currency));
			
	        service.add(newdate, product);       
	        break;
		  }
		case 2:{
			 service.showAll();
			 break;
		   }
		case 3:{
		    service.sortByDate();
		    break;
		   }
		case 4:{
			System.out.println("Enter date where you want to remove all products");
			String date = scanner.next();
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			Date newdate = (Date) dateformat.parse(date);
			service.removeOrder(newdate);
			break;
		    }
		case 5:{
			service.totalExchangeRates();
			break;
		}
		case 6:{
			service.exit();
		}
		  }	
        }
	  }
}