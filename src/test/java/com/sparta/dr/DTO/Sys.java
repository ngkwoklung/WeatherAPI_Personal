package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sys{

	@JsonProperty("country")
	private String country;

	@JsonProperty("sunrise")
	private Integer sunrise;

	@JsonProperty("sunset")
	private Integer sunset;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("type")
	private Integer type;

	/**
	 * Get country code
	 * @return country
	 */
	public String getCountry(){
		return country;
	}

	/**
	 * Get sunrise time in epoch
	 * @return sunrise
	 */
	public Integer getSunrise(){
		return sunrise;
	}

	/**
	 * Get sunset time in epoch
	 * @return sunset
	 */
	public Integer getSunset(){
		return sunset;
	}

	/**
	 * Get sys unique id
	 * @return id
	 */
	public Integer getId(){
		return id;
	}

	/**
	 * Get type from sys value
	 * @return type
	 */
	public Integer getType(){
		return type;
	}

	/**
	 * Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Sys{" + 
			"country = '" + country + '\'' + 
			",sunrise = '" + sunrise + '\'' + 
			",sunset = '" + sunset + '\'' + 
			",id = '" + id + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}