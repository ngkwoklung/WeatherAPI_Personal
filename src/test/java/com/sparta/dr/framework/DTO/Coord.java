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

	/**
	 * Returns a boolean statement if longitude is null or not
	 * @return (boolean) lon
	 */
	public boolean lonIsNotNull(){
		return getLon() != null;
	}

	/**
	 * Returns a boolean statement if latitude is null or not
	 * @return (boolean) lat
	 */
	public boolean latIsNotNull(){
		return getLat() != null;
	}

	/**
	 * Returns check whether longitude is in valid range
	 * @return lon
	 */
	public boolean lonIsBetweenValidRange() {
		return lon >= -180 && lon <= 180;
	}

	/**
	 * Returns check whether latitude is in valid range
	 * @return lat
	 */
	public boolean latIsBetweenValidRange() {
		return lat >= -90 && lat <= 90;
	}
}