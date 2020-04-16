package com.test.products.scraper.service;

import static org.junit.Assert.assertEquals;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import com.test.product.scraper.service.ProductScraper;

public class ProductScraperTest {
	
	final String link = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/shop/gb/groceries/berries-cherries-currants/sainsburys-british-strawberries-400g.html";
		
	@Test
	public void TestGetTitleValid() {
		
		Document webPage = null;
		
		try {
			webPage = Jsoup.connect(link).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals("Sainsbury's Strawberries 400g", ProductScraper.getTitle(webPage));		
	}
	
	@Test
	public void TestGetDescriptionValid() {
		
		Document webPage = null;
		
		try {
			webPage = Jsoup.connect(link).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals("by Sainsbury's strawberries", ProductScraper.getDescription(webPage));
		
	}
	
	@Test
	public void TestGetKcalValid() {
		
		Document webPage = null;
		
		try {
			webPage = Jsoup.connect(link).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(null, ProductScraper.getKcal(webPage));
		
	}
	
	@Test
	public void TestGetPriceValid() {
		
		Document webPage = null;
		
		try {
			webPage = Jsoup.connect(link).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		assertEquals(new Double(1.75), ProductScraper.getPrice(webPage));
		
	}
	
	@Test
	public void TestGetTitleNull() {		

		assertEquals(null, ProductScraper.getTitle(null));		
	}
	
	@Test
	public void TestGetDescriptionNull() {
	
		assertEquals(null, ProductScraper.getDescription(null));		
	}
	
	@Test
	public void TestGetKcalNull() {
		
		assertEquals(null, ProductScraper.getKcal(null));		
	}
	
	@Test
	public void TestGetPriceNull() {
		
		assertEquals(null, ProductScraper.getPrice(null));		
	}
	
}
