package com.desafiobackend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.desafiobackend.dto.request.ToolsRequest;
import com.desafiobackend.dto.response.ToolsResponse;
import com.desafiobackend.service.ToolsService;

@RestController
@RequestMapping("/tools")
public class ToolsController {

	@Autowired
	private ToolsService toolsService;
	
	@PostMapping(consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ToolsResponse post(@Valid @RequestBody ToolsRequest toolsRequest) {
		return this.toolsService.create(toolsRequest);
	}
	
	@GetMapping(produces = "application/json")
	public List<ToolsResponse> get(@RequestParam(required = false) String tag) {
		return this.toolsService.getAll(tag);
	}
	
		
	@PutMapping(path = "/{id}", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public ToolsResponse put(@Valid @RequestBody ToolsRequest toolsRequest, @PathVariable Long id) {
		return this.toolsService.update(toolsRequest, id);
	}
	
	@DeleteMapping(path = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		this.toolsService.delete(id);
	}
	
}
