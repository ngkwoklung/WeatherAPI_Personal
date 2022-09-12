package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind{

	@JsonProperty("deg")
	private Integer deg;

	@JsonProperty("speed")
	private Double speed;

	@JsonProperty("gust")
	private Double gust;

	/**
	 * Get wind degree
	 * @return deg
	 */
	public Integer getDeg(){
		return deg;
	}

	/**
	 * Get wind speed
	 * @return speed
	 */
	public Double getSpeed(){
		return speed;
	}

	/**
	 * Get wind gust
	 * @return gust
	 */
	public Double getGust(){
		return gust;
	}

	/**
	 * Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Wind{" + 
			"deg = '" + deg + '\'' + 
			",speed = '" + speed + '\'' + 
			",gust = '" + gust + '\'' + 
			"}";
		}
}