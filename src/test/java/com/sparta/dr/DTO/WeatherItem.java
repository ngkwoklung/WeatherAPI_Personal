package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class WeatherItem{

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

	@JsonProperty("main")
	private String main;

	@JsonProperty("id")
	private Integer id;

	public String getIcon(){
		return icon;
	}

	public String getDescription(){
		return description;
	}

	public String getMain(){
		return main;
	}

	public Integer getId(){
		return id;
	}

	@Override
 	public String toString(){
		return 
			"WeatherItem{" + 
			"icon = '" + icon + '\'' + 
			",description = '" + description + '\'' + 
			",main = '" + main + '\'' + 
			",id = '" + id + '\'' + 
			"}";
	}

	public boolean mainStartsWithCapitalLetter() {
		return String.valueOf(main.charAt(0)).equals(String.valueOf(main.charAt(0)).toUpperCase());
	}

	public boolean idIsValidAccordingToMainType() {
		Integer[] arrayToSearch = WeatherDTOUtils.getCorrespondingIdCodeArray(main);
		return Arrays.asList(arrayToSearch).contains(id);
	}
}