package com.desafiobackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafiobackend.dto.request.ToolsRequest;
import com.desafiobackend.dto.response.ToolsResponse;
import com.desafiobackend.exception.ToolsDoesNotExistException;
import com.desafiobackend.model.Tools;
import com.desafiobackend.repository.ToolsRepository;

@Service
public class ToolsService {

	@Autowired
	private ToolsRepository toolsRepository;
	
	public ToolsResponse create(ToolsRequest toolsRequest) {
		Tools newTool = new Tools(toolsRequest);
		this.toolsRepository.save(newTool);
		return new ToolsResponse(newTool);
	}
	
	public List<ToolsResponse> getAll(String tag){
		
		if(tag == null) {
			return this.toolsRepository.findAll().stream().map(ToolsResponse::new).collect(Collectors.toList());
		}
		
		return this.toolsRepository.findByTag(tag).stream().map(ToolsResponse::new).collect(Collectors.toList());
	}
	
		
	public ToolsResponse update(ToolsRequest toolsRequest, Long id) {
		Tools tool = this.findById(id);
		tool.fillFromDto(toolsRequest);
		this.toolsRepository.save(tool);
		return new ToolsResponse(tool);
	}

	private Tools findById(Long id) {
		Optional<Tools> toolOptional = this.toolsRepository.findById(id);
		Tools tool = toolOptional.orElseThrow(() -> new ToolsDoesNotExistException());
		return tool;
	}
	
	public void delete(Long id) {
        Optional<Tools> toolOptional = this.toolsRepository.findById(id);
        Tools site = toolOptional.orElseThrow(() -> new ToolsDoesNotExistException());
        this.toolsRepository.delete(site);

    }

	
}
