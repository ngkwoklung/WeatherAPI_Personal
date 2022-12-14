package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.Instant;
import java.time.LocalDate;
import java.util.TimeZone;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	/**
	 * Return whether sunrise is present or not
 	 * @return boolean
	 */
	public boolean sunriseIsNotNull(){
		return getSunrise() != null;
	}

	/**
	 * Return whether sunset is present or not
	 * @return boolean
	 */
	public boolean sunsetIsNotNull(){
		return getSunset() != null;
	}

	/**
	 * Return whether type is present or not
	 * @return boolean
	 */
	public boolean typeIsNotNull(){
		return getType() != null;
	}

	/**
	 * Return whether ID is present or not
	 * @return boolean
	 */
	public boolean idIsNotNull(){
		return getId() != null;
	}

	/**
	 * Return whether country is present or not
	 * @return boolean
	 */
	public boolean countryIsNotNull(){
		return getCountry() != null;
	}

	/**
	 * Return time of sunrise
	 * @return time
	 */
	public boolean sunriseIsToday() {
		return LocalDate.ofInstant(Instant.ofEpochSecond(sunrise), TimeZone.getDefault().toZoneId()).equals(LocalDate.now());
	}

	/**
	 * Return time of sunset
	 * @return time
	 */
	public boolean sunsetIsToday() {
		return LocalDate.ofInstant(Instant.ofEpochSecond(sunset), TimeZone.getDefault().toZoneId()).equals(LocalDate.now());
	}
}