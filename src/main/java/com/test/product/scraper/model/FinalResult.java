package com.test.product.scraper.model;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder(value = { FinalResult.RESULTS, FinalResult.TOTAL })
public class FinalResult
{
	protected static final String RESULTS = "results";
    protected static final String TOTAL = "total";
    
    @NotNull
    @NotEmpty
    @JsonProperty(RESULTS)
    private List<ProductDetails> results;

    /** The total. */
    @NotNull
    @NotEmpty
    @JsonProperty(TOTAL)
    private Total total;

	public List<ProductDetails> getResults() {
		return results;
	}

	public void setResults(List<ProductDetails> results) {
		this.results = results;
	}

	public Total getTotal() {
		return total;
	}

	public void setTotal(Total total) {
		this.total = total;
	}
}
