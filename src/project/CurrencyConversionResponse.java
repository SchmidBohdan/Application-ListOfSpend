package project;

import java.util.Map;
import java.util.TreeMap;

public class CurrencyConversionResponse {

	private Map<String, Double> rates = new TreeMap<String, Double>();

	public Map<String, Double> getRates() {
		return rates;
	}

	public void setRates(Map<String, Double> rates) {
		this.rates = rates;
	}
	
	
}
