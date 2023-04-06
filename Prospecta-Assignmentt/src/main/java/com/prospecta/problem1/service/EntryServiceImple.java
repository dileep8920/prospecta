package com.prospecta.problem1.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.problem1.dto.EntryDto;
import com.prospecta.problem1.exception.EntryException;
import com.prospecta.problem1.model.Data;
import com.prospecta.problem1.model.Entry;
import com.prospecta.problem1.repository.EntryRepo;

@Service
public class EntryServiceImple implements EntryService{
	
	@Autowired
	private RestTemplate rTemp;
	
	@Autowired
	private EntryRepo eRepo;

	@Override
	public Entry addEntry(Entry entry) {
	
		Data data = rTemp.getForObject("https://api.publicapis.org/entries", Data.class);
		
		List<Entry> entries = data.getEntries();
		
		
		entries.add(entry);
		
		for(int i=0;i<entries.size();i++) {
			
			eRepo.save(entries.get(i));
			
		}
		
		return entry;
		
	}
	
	@Override
	public List<EntryDto> getTitlesAndDesctriptions(String category) throws EntryException {
		
		Data data = rTemp.getForObject("https://api.publicapis.org/entries", Data.class);
		
		String[] strArr = category.split(" ");
		String myCategory = strArr[0];
		
		// here I am using lambda expression for filtering and maping  
		List<EntryDto> list  = data.getEntries()
								   .stream()
								   .filter(e -> e.getCategory().contains(myCategory))
								   .map(e -> new EntryDto(e.getApi(),e.getDescription()))
								   .collect(Collectors.toList());
		
		return list;
		
	}	
	

}
