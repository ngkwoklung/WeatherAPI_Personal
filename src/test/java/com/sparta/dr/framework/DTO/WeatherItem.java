package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherItem{

	@JsonProperty("icon")
	private String icon;

	@JsonProperty("description")
	private String description;

	@JsonProperty("main")
	private String main;

	@JsonProperty("id")
	private Integer id;

	public WeatherItem(String icon, String description, String main, Integer id) {
		this.icon = icon;
		this.description = description;
		this.main = main;
		this.id = id;
	}

	public WeatherItem() {
	}

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

	/**
	 * Return check whether ID is valid
	 * @return id
	 */
	public boolean idIsValid() {
    if (!mainIsValid()) {
			return false;
		}
		Integer[] arrayToSearch = WeatherDTOUtils.getCorrespondingIdCodeArray(main);
		return Arrays.asList(arrayToSearch).contains(id);
	}

	/**
	 * Return check whether icon is valid
	 * @return icon
	 */
	public boolean iconIsValid(){
		String[] arrayToSearch = WeatherDTOUtils.getIconList();
		return Arrays.asList(arrayToSearch).contains(icon);
	}

	/**
	 * Return check whether main is valid
	 * @return main
	 */
	public boolean mainIsValid(){
		String[] arrayToSearch = WeatherDTOUtils.getWeatherItemsMainList();
		return Arrays.asList(arrayToSearch).contains(main);
	}

	public boolean descriptionIsValid() {
		if (!mainIsValid()) {
			return false;
		}
		String[] arrayToSearch = WeatherDTOUtils.getCorrespondingWeatherDescriptions(main);
		return Arrays.asList(arrayToSearch).contains(description);
	}
}