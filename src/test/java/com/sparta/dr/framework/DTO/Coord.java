package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Coord{

	@JsonProperty("lon")
	private Double lon;

	@JsonProperty("lat")
	private Double lat;

	/**
	 * Get longitude
	 * @return lon
	 */
	public Double getLon(){
		return lon;
	}

	/**
	 * Get latidute
	 * @return lat
	 */
	public Double getLat(){
		return lat;
	}

	/**
	 * Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Coord{" + 
			"lon = '" + lon + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}

	public boolean lonIsBetweenValidRange() {
		return lon >= -180 && lon <= 180;
	}

	public boolean latIsBetweenValidRange() {
		return lat >= -90 && lat <= 90;
	}
}