package com.test.product.scraper.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.product.scraper.model.FinalResult;
import com.test.product.scraper.service.ProductScraperService;

@Component
public class ProductScraperController
{
	@Autowired
	private ProductScraperService scraperService;
	
    public void scrapeWebpageFromUri(final URI inputUri)
    {
    	try
    	{
    		FinalResult jsonObject = scraperService.getJsonModelFromUri(inputUri);
    	
    		ObjectMapper objectMapper = new ObjectMapper();
    		
    		System.out.println(objectMapper.writeValueAsString(jsonObject));
    		
    	}
    	catch (MalformedURLException e)
    	{
    		e.printStackTrace();
    	}
    	catch (IOException e)
    	{
    		e.printStackTrace();
    	}
    }
}
