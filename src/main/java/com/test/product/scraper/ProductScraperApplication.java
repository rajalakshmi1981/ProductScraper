package com.test.product.scraper;

import java.io.IOException;
import java.net.URI;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.util.UriComponentsBuilder;

import com.test.product.scraper.controllers.ProductScraperController;

@SpringBootApplication
public class ProductScraperApplication implements CommandLineRunner {
	// Default URL link
	private static final String GIVEN_URL = "https://jsainsburyplc.github.io/serverside-test/site/"
			+ "www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";

	@Autowired
	private ProductScraperController scraperController;

	public static void main(String[] args) {
		SpringApplication.run(ProductScraperApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			scrape(args);
		} catch (Exception e) {
			System.out.println("Error ocuurred in running the App: " + e.getMessage());

		}
	}

	private void scrape(final String[] args) throws IOException {
		if (args.length > 0) {
			for (String arg : args) {
				if (isValidUri(arg)) {					
					scraperController.scrapeWebpageFromUri(buildURI(arg));
				}
			}
		} else {
			System.out.println("No URI provided and hence using default URI \n" + GIVEN_URL);
			scraperController.scrapeWebpageFromUri(buildURI(GIVEN_URL));
		}
	}

	private boolean isValidUri(String input) {
		return new UrlValidator().isValid(input);
	}

	private URI buildURI(String input) {
		return UriComponentsBuilder.fromHttpUrl(input).build().toUri();
	}
}
