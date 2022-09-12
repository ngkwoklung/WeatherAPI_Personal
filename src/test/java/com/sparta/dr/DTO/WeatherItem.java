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

	/**
	 * Obtain Icon ID
	 * @return icon
	 */
	public String getIcon(){
		return icon;
	}

	/**
	 * Get weather description
	 * @return description
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Get main weather
	 * @return main
	 */
	public String getMain(){
		return main;
	}

	/**
	 * Get weather id
	 * @return id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 * Obtain all the information as one string.
	 * @return all values as a string
	 */
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