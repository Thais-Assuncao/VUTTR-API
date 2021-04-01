package com.desafiobackend.dto.request;

import java.util.ArrayList;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ToolsRequest {
	
	@NotBlank
	@Size(min = 2, max = 255)
	private String title;
	
	@NotBlank
	private String link;
	
	@NotBlank
	@Size(min = 2)
	private String description;
	
	@NotNull
	private ArrayList<String> tags;
	
}
