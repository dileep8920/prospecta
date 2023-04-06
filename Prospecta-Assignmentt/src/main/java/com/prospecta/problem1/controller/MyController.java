package com.prospecta.problem1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.problem1.dto.EntryDto;
import com.prospecta.problem1.exception.EntryException;
import com.prospecta.problem1.model.Entry;
import com.prospecta.problem1.service.EntryService;

@RestController
public class MyController {

	@Autowired
	private EntryService eService;
	
	
	@PostMapping("/addentry")
	public ResponseEntity<Entry> addEntry(@RequestBody Entry entry) {
		
		Entry savedObj = eService.addEntry(entry);
		
		return new ResponseEntity<Entry>(savedObj,HttpStatus.CREATED);
	}
	
	
	
	
	@GetMapping("/entry/{category}")
	public ResponseEntity<List<EntryDto>> getTitlesAndDescriptionsHandler(@PathVariable("category") String category) throws EntryException{
		
		
		List<EntryDto> entryDtos = eService.getTitlesAndDesctriptions(category);
		
		
		return new ResponseEntity<List<EntryDto>>(entryDtos,HttpStatus.OK);
	}
	
	

	
	
	
	
	
	
}
