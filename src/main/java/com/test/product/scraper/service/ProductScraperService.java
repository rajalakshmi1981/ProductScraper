package com.test.product.scraper.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import com.test.product.scraper.model.FinalResult;
import com.test.product.scraper.model.ProductDetails;
import com.test.product.scraper.model.Total;

@Service
public class ProductScraperService
{
	private static final String DOMAIN_URL = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/";
	private static final String LINK_SANITISING_PATTERN = "(../)+";
	
	private static final String OBJECT_SELECTOR = "ul.productLister a";
	private static final String OBJECT_HREF_SELECTOR = "href";
	
	public FinalResult getJsonModelFromUri(URI webpageUri) throws MalformedURLException, IOException
	{
		Document webpage = Jsoup.connect(webpageUri.toURL().toString()).get();
		
		Set<String> allScrapedObjectsLinks = webpage.select(OBJECT_SELECTOR).stream()
			.map(elem -> elem.attr(OBJECT_HREF_SELECTOR))
			.map(elem -> DOMAIN_URL + elem.replaceFirst(LINK_SANITISING_PATTERN, ""))
			.filter(elem -> elem.contains("berries-cherries-currants"))
			.collect(Collectors.toSet());
		
		// -- DEBUG
		System.out.println("Found the following links:");
	
		for (String link : allScrapedObjectsLinks)
		{
			System.out.println(link);
		}
	
		// call the method to parse all found links and return the JsonModel object	
		return parseAllScrapedObjectsLinks(allScrapedObjectsLinks);
	}
	
	private FinalResult parseAllScrapedObjectsLinks(final Set<String> allScrapedObjectsLinks) throws IOException
	{
		FinalResult jsonObject = new FinalResult();
		List<ProductDetails> scrapedObjects = new ArrayList<>(allScrapedObjectsLinks.size());
		Double gross = new Double(0);
		Double vat  = new Double(0);
		
		Total totalObject = new Total();
		
		for (String link : allScrapedObjectsLinks)
		{		
			Document productPage = Jsoup.connect(link).get();
			
			ProductDetails scrapedObject = new ProductDetails();
			scrapedObject.setTitle(ProductScraperServiceHelper.getScrapedObjectTitle(link, productPage));
			if(ProductScraperServiceHelper.getScrapedObjectKcal(link, productPage) != null)
				scrapedObject.setKcalPerHundredGrams(ProductScraperServiceHelper.getScrapedObjectKcal(link, productPage));
			scrapedObject.setUnitPrice(ProductScraperServiceHelper.getScrapedObjectUnitPrice(link, productPage));
			scrapedObject.setDescription(ProductScraperServiceHelper.getScrapedObjectDescription(link, productPage));
				
			scrapedObjects.add(scrapedObject);		
			
			if (scrapedObject.getUnitPrice() != null)
			{
				gross += scrapedObject.getUnitPrice();
				vat += (scrapedObject.getUnitPrice() * (.20));
			}
		}
		
		jsonObject.setResults(scrapedObjects);
		
		totalObject.setGross(gross);
		totalObject.setVat(vat);
		
		jsonObject.setTotal(totalObject);
		
		return jsonObject;
	}
}
