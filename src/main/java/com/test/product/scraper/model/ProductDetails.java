package com.test.product.scraper.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonPropertyOrder(value = {ProductDetails.TITLE, ProductDetails.KCAL,
		ProductDetails.UNIT_PRICE, ProductDetails.DESCRIPTION})
public class ProductDetails
{
    protected static final String TITLE = "title";
    protected static final String KCAL = "kcal_per_100g";
    protected static final String UNIT_PRICE = "unit_price";
    protected static final String DESCRIPTION = "description";
	

	@NotNull
	@JsonProperty(TITLE)
	private String title;
	
	@JsonInclude(JsonInclude.Include.NON_NULL) 
	@JsonProperty(KCAL)
	private String kcalPerHundredGrams;
	
	@NotNull
	@JsonProperty(UNIT_PRICE)
	private Double unitPrice;
	
	@NotNull
	@JsonProperty(DESCRIPTION)
	private String description;
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKcalPerHundredGrams() {
		return kcalPerHundredGrams;
	}

	public void setKcalPerHundredGrams(String kcalPerHundredGrams) {
		this.kcalPerHundredGrams = kcalPerHundredGrams;
	}

	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
}
