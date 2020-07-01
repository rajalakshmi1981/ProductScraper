package com.timetravel.travel.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.timetravel.travel.model.TravelDetail;
import com.timetravel.travel.service.TravelService;

@AutoConfigureMockMvc
@WebMvcTest
@RunWith(SpringRunner.class)
public class TravelControllerTest {

	@MockBean
	TravelService service;
	
	@Autowired
	MockMvc mvc;	

	@Test
	public void TestWithNullRequestBody() throws Exception {
		mvc.perform(post("/travel")).andExpect(status().is4xxClientError());
	}

	@Test
	public void TestWithRequestBody() throws Exception {

		Mockito.doReturn(true).when(this.service).validateAndSaveTravel(ArgumentMatchers.any());
		
		TravelDetail detail = new TravelDetail();
		detail.setPgi("1N2N12H2N");
		detail.setPlace("Leicester");
		detail.setDate("2022-02-02");

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson = ow.writeValueAsString(detail);

		mvc.perform(post("/travel").contentType(MediaType.APPLICATION_JSON_UTF8).content(requestJson))
				.andExpect(status().isOk());
	}
}
