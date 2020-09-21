package com.ibm.msbootcamp.managecurrencyConversionFactor.model;

public class ConversionFactorRequest {
	
	String countryCode;
	double convFactor;
	double amount;
	
	public ConversionFactorRequest(String countryCode, double convFactor,double amount) {
		super();
		this.countryCode = countryCode;
		this.convFactor = convFactor;
		this.amount =amount;
	}
	public ConversionFactorRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}	
	public double getConvFactor() {
		return convFactor;
	}
	public void setConvFactor(double convFactor) {
		this.convFactor = convFactor;
	}
	
	

}
