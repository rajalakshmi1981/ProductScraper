package com.test.products.scraper.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import com.test.product.scraper.model.FinalResult;
import com.test.product.scraper.service.ProductScraperService;

public class ProductScraperServiceTest {
	
	final String GIVEN_URL = "https://jsainsburyplc.github.io/serverside-test/site/"
			+ "www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
	
	@Test
	public void TestGetJSONModelValid() {
		
		ProductScraperService scraperService = new ProductScraperService();
		
		FinalResult result = null;
		try {
			result = scraperService.getJsonModelFromUri(new URI(GIVEN_URL));
		} catch (Exception e) {
			//nothing to process
		}
		
		assertTrue(result.getTotal().getGross() != 0);		
	}
	
	@Test
	public void TestGetJSONModelInValid() {
		
		ProductScraperService scraperService = new ProductScraperService();
		
		FinalResult result = null;
		try {
			result = scraperService.getJsonModelFromUri(new URI("test"));
		} catch (Exception e) {
			
		}
		assertTrue(result == null);		
	}
	
	@Test
	public void TestObjectsInResult() {
		
		ProductScraperService scraperService = new ProductScraperService();
		
		FinalResult result = null;
		try {
			result = scraperService.getJsonModelFromUri(new URI(GIVEN_URL));
		} catch (Exception e) {
			//nothing to process
		}
		
		assertTrue(result.getResults().size() > 0);		
	}
	
	@Test
	public void TestTotalsInResult() {
		
		ProductScraperService scraperService = new ProductScraperService();
		
		FinalResult result = null;
		try {
			result = scraperService.getJsonModelFromUri(new URI(GIVEN_URL));
		} catch (Exception e) {
			//nothing to process
		}
		
		assertTrue(result.getTotal().getGross() > 0);
		assertTrue(result.getTotal().getVat() > 0);	
	}
	
	
}
