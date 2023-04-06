package com.prospecta.problem1.dto;


public class EntryDto {

	private String title;
	
	private String description;
	
	public EntryDto() {
		// TODO Auto-generated constructor stub
	}

	public EntryDto(String title, String description) {
		super();
		this.title = title;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
	
