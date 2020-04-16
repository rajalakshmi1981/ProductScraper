package com.test.product.scraper.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { Total.GROSS, Total.VAT })

public class Total {

	protected static final String GROSS = "gross";
	protected static final String VAT = "vat";

	@NotNull
	@JsonProperty(GROSS)
	private Double gross;

	@JsonProperty(VAT)
	private Double vat;

	public Double getGross() {
		return gross;
	}

	public void setGross(Double gross) {
		this.gross = gross;
	}

	public Double getVat() {
		return vat;
	}

	public void setVat(Double vat) {
		this.vat = vat;
	}

}
