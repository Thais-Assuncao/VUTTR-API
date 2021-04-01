package com.desafiobackend.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.desafiobackend.dto.request.ToolsRequest;
import com.desafiobackend.dto.response.ToolsResponse;
import com.desafiobackend.service.ToolsService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest(ToolsController.class)
public class ToolsControllerTest {

	@MockBean
	private ToolsService toolsService;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	public void postMethod() throws Exception {
		
		ToolsRequest request = new ToolsRequest();
		request.setDescription("All in one tool to organize teams and ideas. Write, plan, collaborate, and get organized. ");
		request.setLink("https://notion.so");
		request.setTitle("Notion");
		ArrayList<String> tags = new ArrayList<String>();
		tags.add("api");
		tags.add("json");
		tags.add("github");
		request.setTags(tags);
			
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(request);		
		
		ToolsResponse response = new ToolsResponse();
		response.setDescription(request.getDescription());
		response.setLink(request.getLink());
		response.setTitle(request.getTitle());
		response.setTags(request.getTags());
		response.setId(2002L);
		
		when(this.toolsService.create(isA(ToolsRequest.class))).thenReturn(response);

		mvc.perform(post("/tools").contentType(MediaType.APPLICATION_JSON).content(json))
				.andExpect(MockMvcResultMatchers.status().isCreated()).andExpect(jsonPath("$.title", is(request.getTitle())))
				.andExpect(jsonPath("$.id", is(2002)));
	}
	
}
