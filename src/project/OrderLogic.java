package project;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

import com.google.gson.Gson;



public class OrderLogic {

	private List<Order> orders = new ArrayList<>();
	private CurrencyConversionResponse response;
	
	
	
	public boolean containsDate(String searchDate){
          for (Order order : orders) {
        	  if(order.getDate().toString().trim().contains(searchDate)){
        	   System.out.println(order.getDate());
        	   System.out.println(searchDate);
        	       return true;
        	  }
		}
		return false;
	}

	public void add(Date date, List<Product> products){
		
		if(orders.isEmpty()){
			orders.add(new Order(date, products));
			System.out.println("� ��� ��� ������ ������ ��� ����� � ����� � ��� ������ �����");
			
	    }else if(containsDate(date.toString()) == true){ 
			System.out.println(containsDate(date.toString()));
        	for (int i = 0; i <= orders.size()-1; i++) {
        		System.out.println("������!!!!!");
        		System.out.println(date);
        		System.out.println(orders.get(i).getDate().toString());
				
        		if(date.equals(orders.get(i).getDate())){
        			System.out.println("������");
					System.out.println(orders.get(i).getProducts().addAll(products));	
        		}
			  }
              }else{
            	 
        		System.out.println("������� �� �� ������� ������� Order � ����� Date �� �������� �����!");
        		orders.add(new Order(date, products));
        		
        	 }
	      }
	
	public void showAll(){
		for (Order order: orders) {
			System.out.println(order.toString());
		}	
	 }
	
	public void sortByDate(){
	      Collections.sort(orders, (o1, o2) -> o2.getDate().compareTo(o1.getDate()));
	      System.out.println("�����������!!! ���� ����� �������� �� ������ - 2 ��� �������� ������");
	}
	
	public void removeOrder(Date date){

		if(orders.isEmpty()){
			System.out.println("������ �������");
	    }else{
	    	    for (int i = 0; i <= orders.size()-1; i++) {
	    	    	
	    	    	if(date.equals(orders.get(i).getDate())){
					
	    	    	System.out.println(i+")"+" "+ "��������"+ " " + orders.get(i).getDate());
					System.out.println("��������"+" "+"\n" + orders.remove(i));
	    	    	
	    	    	}else{
					 System.out.println(i+")"+" "+ "�� ��������");
					 
				 }
			   }  
		     }
		   }
	

	public void totalExchangeRates(){
		
		final String PROVIDER_API = "http://data.fixer.io/";
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�'������� �� ����� Fixer.io.... ���� ����� ������ ��� Access Key");
		String accessKey= scanner.next(); //b8b59f276579494af647c81b9a92597f
	    response = getResponse(PROVIDER_API + "api/latest?access_key=" + accessKey);	
		if(response != null) {
				
			containsCurrencyFromRange();			
			
		}else{
			System.out.println("���� ������");
		}
		scanner.close();
		}
	
	public Double containsCurrencyFromRange(){
		double sumPrice = 0;
		
		System.out.println(sizeProducts() + "- �����");
	
		for(int i = 0; i <= sizeProducts(); i++){ 
		Iterator<Entry<String, Double>> iterator = response.getRates().entrySet().iterator();
		   while(iterator.hasNext()){
		    	Entry<String, Double> entry = iterator.next();
		    	System.out.println(entry.getValue()+ " - "+ entry.getKey()); //b8b59f276579494af647c81b9a92597f
		        	
		    	if(orders.get(i).getProducts().get(i).getCurrency().toString().equals(entry.getKey())){ 	
			        
		          double priceInProduct = orders.get(i).getProducts().get(i).getPrice() * entry.getValue().doubleValue();
			   		    
		          List<Double> listDouble = new ArrayList<>();
		          listDouble.add(priceInProduct);
			   		    
		        		System.out.println("�������� � ������ ���1");
			   		    for (Double double1 : listDouble) {
							System.out.println(double1.doubleValue());
						}
				        
			   		    return sumPrice;
			}
          } 
		}
	  
	     return 0.0;
	}
	
	
	public int sizeProducts(){
		
		Iterator<Order> iterator = orders.iterator();
		
		while (iterator.hasNext()) {
			int amountProduct = 0;
			amountProduct = amountProduct + iterator.next().getProducts().size();
			iterator.next();
			return amountProduct;
			
		}
		return 0;
	}
	
	private static CurrencyConversionResponse getResponse(String strUrl) {

		CurrencyConversionResponse response = null;
		
		Gson gson = new Gson();
		StringBuffer sb = new StringBuffer();
		
		if(strUrl == null || strUrl.isEmpty()) {
			System.out.println("Application Error");
			return null;
		}

		URL url;
		try {
			url = new URL(strUrl);

			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();

			InputStream stream = connection.getInputStream();

			int data = stream.read();

			while (data != -1) {

				sb.append((char) data);

				data = stream.read();
			}

			stream.close();

			response = gson.fromJson(sb.toString(), CurrencyConversionResponse.class);

		} catch (MalformedURLException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} catch (IOException e) {

			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return response;
	}

	public void exit(){
		System.out.println("Good Bye =)");
		System.exit(0);
		
	}
	
}
