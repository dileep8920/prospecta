package com.prospecta.problem1.service;

import java.util.List;

import com.prospecta.problem1.dto.EntryDto;
import com.prospecta.problem1.exception.EntryException;
import com.prospecta.problem1.model.Entry;

public interface EntryService {
	
	public Entry addEntry(Entry entry);
	
	public List<EntryDto> getTitlesAndDesctriptions(String category) throws EntryException;
	
	
}
