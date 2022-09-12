package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}