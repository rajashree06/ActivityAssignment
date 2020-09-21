package com.ibm.msbootcamp.managecurrencyConversionFactor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.msbootcamp.managecurrencyConversionFactor.model.ConversionFactorRequest;
import com.ibm.msbootcamp.managecurrencyConversionFactor.model.ConversionFactorResponse;
import com.ibm.msbootcamp.managecurrencyConversionFactor.model.Currency;
import com.ibm.msbootcamp.managecurrencyConversionFactor.service.CurrConversionFactorService;

@RestController
@RequestMapping(path = "/currencyfactor")
public class ManageConversionFactorController {
	
	@Autowired
	CurrConversionFactorService currConversionFactorService;
	
	@RequestMapping(path = "/addConvFactor", method = RequestMethod.POST)
	public String addConversionFactor(@RequestBody Currency curr ) {
		
		currConversionFactorService.addConversionFactor(curr);
		//ConversionFactorResponse response = new ConversionFactorResponse(200,"Successfully added.");
		//return response;
		
		return "Conversion factor for countryCode " + curr.getCountryCode() + " Successfully added.";
	}	
	
//	@RequestMapping(path = "/updateConvFactor", method = RequestMethod.POST)
//	public ConversionFactorResponse UpdateConversionFactor(@RequestBody CurrencyFactor curr ) {
//		
//		currConversionFactorService.updateConversionFactor(curr);
//		ConversionFactorResponse response = new ConversionFactorResponse(200,"Successfully added.");
//		return response;
//	}	
	@RequestMapping(path = "/updateConvFactor", method = RequestMethod.POST)
	public String UpdateConversionFactor(@RequestBody Currency curr ) {
		
		currConversionFactorService.updateConversionFactor(curr);
	//	ConversionFactorResponse response = new ConversionFactorResponse(200,"Successfully updated.");
	//	return response;
		
		return "Conversion factor for countryCode " + curr.getCountryCode() + " Successfully Updated.";
	}	
	
	@RequestMapping(path = "/conversionFactor")
	public ConversionFactorResponse getConversionFactor(@RequestBody ConversionFactorRequest conversionFactorRequest) {
		//System.out.println("t  mss2  ccccode : " + countryCode);
		System.out.println("11 mss2 conversionFactorRequest  ccccode : " + conversionFactorRequest.getCountryCode());
		
		System.out.println("22ss mss2  conversionFactorRequest ccccode : " + conversionFactorRequest.getCountryCode());
		System.out.println("33  ss mss2  before getconversion convFactor : " + conversionFactorRequest.getConvFactor());
		
		conversionFactorRequest.setConvFactor(currConversionFactorService.getConversionFactor(conversionFactorRequest.getCountryCode()));
		System.out.println("44 ss mss2  before getconversion convFactor : " + conversionFactorRequest.getConvFactor());
		ConversionFactorResponse conversionFactorResponse = new ConversionFactorResponse();
		conversionFactorResponse.setAmount(conversionFactorRequest.getAmount());
		conversionFactorResponse.setCountryCode(conversionFactorRequest.getCountryCode());
		conversionFactorResponse.setConvFactor(conversionFactorRequest.getConvFactor());
		return conversionFactorResponse;
		
		//return "Conversion factor for countryCode " + conversionFactorRequest.getCountryCode() + " is " + conversionFactorRequest.getConvFactor() ;
	}
	
	@RequestMapping(path = "/converttorupee/{countryCode}/{amount}", method = RequestMethod.POST)
	public String convertCurrencyToRupee(@PathVariable("countryCode") String countryCode,@PathVariable("amount") String amount)
	{
		System.out.println("tes ms111  amount" +amount);
		double amount1=Double.parseDouble(amount);
		System.out.println("tes ms111  amount1" +amount1);
		double totalAmount=currConversionFactorService.convertCurrencyToRupee(countryCode, amount1);
		return "converted amount is " +totalAmount;
	}
} 
