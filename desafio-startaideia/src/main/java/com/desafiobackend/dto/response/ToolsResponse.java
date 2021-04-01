package com.desafiobackend.dto.response;

import java.util.List;

import com.desafiobackend.model.Tools;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ToolsResponse {
	
	public ToolsResponse(Tools tools) {
		this.setId(tools.getId());
		this.setTitle(tools.getTitle());
		this.setLink(tools.getLink());
		this.setDescription(tools.getDescription());
		this.setTags(tools.getTags());
		
	}

	private Long id;
		
	private String title;
		
	private String link;
		
	private String description;
	
	private List<String> tags ;
}
