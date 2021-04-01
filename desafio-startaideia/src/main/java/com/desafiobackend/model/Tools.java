package com.desafiobackend.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.desafiobackend.dto.request.ToolsRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of = { "id" })
@NoArgsConstructor
@Entity
public class Tools {
	
	public Tools (ToolsRequest toolsRequest) {
		this.fillFromDto(toolsRequest);
	}
		
	public void fillFromDto (ToolsRequest toolsRequest) {
		this.setTitle(toolsRequest.getTitle());
		this.setLink(toolsRequest.getLink());
		this.setDescription(toolsRequest.getDescription());
		this.setTags(toolsRequest.getTags());
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String link;
	
	@Column(nullable = false)
	private String description;
	
	@ElementCollection
	private List<String> tags = new ArrayList<>();
}
