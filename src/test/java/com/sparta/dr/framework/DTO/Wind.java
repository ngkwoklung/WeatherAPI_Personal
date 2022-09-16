package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Wind {

	@JsonProperty("deg")
	private Integer deg;

	@JsonProperty("speed")
	private Double speed;

	@JsonProperty("gust")
	private Double gust;

	/**
	 * Get wind degree
	 *
	 * @return deg
	 */
	public Integer getDeg() {
		return deg;
	}

	/**
	 * Get wind speed
	 *
	 * @return speed
	 */
	public Double getSpeed() {
		return speed;
	}

	/**
	 * Get wind gust
	 *
	 * @return gust
	 */
	public Double getGust() {
		return gust;
	}

	/**
	 * Obtain all the information as one string.
	 *
	 * @return all values as a string
	 */
	@Override
	public String toString() {
		return
				"Wind{" +
						"deg = '" + deg + '\'' +
						",speed = '" + speed + '\'' +
						",gust = '" + gust + '\'' +
						"}";
	}

	/**
	 * Return whether deg is in valid range
	 * @return deg
	 */
	public boolean isDegBetween0And360() {
		return getDeg() >= 0 && getDeg() <= 360;
	}

	/**
	 * Return whether speed is present or not
	 * @return boolean
	 */
	public boolean isSpeedNotNull(){
		return getSpeed() != null;
	}

	/**
	 * Return whether speed is more than 0
	 * @return boolean
	 */
	public boolean isSpeedValid(){
		return getSpeed() >= 0;
	}

	/**
	 * Return whether gusts is not null
	 * @return boolean
	 */
	public boolean isGustNotNull(){
		return getGust() != null;
	}

	/**
	 * Return whether gust is more than 0
	 * @return boolean
	 */
	public boolean isGustValid(){
		return getGust() >= 0;
	}
}