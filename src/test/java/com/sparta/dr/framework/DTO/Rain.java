package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Rain{

	@JsonProperty("1h")
	private Double jsonMember1h;

	/**
	 * Return rain level in 1h property
	 * @return 1h
	 */
	public Double getJsonMember1h(){
		return jsonMember1h;
	}

	/**
	 * Return Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Rain{" + 
			"1h = '" + jsonMember1h + '\'' + 
			"}";
		}

	/**
	 * Return whether rain is present or not
 	 * @return boolean
	 */
	public boolean isRainNull(){
		return getJsonMember1h() != null;
	}

	/**
	 * Return whether density of rain is positive
	 * @return all
	 */
	public boolean isRainPositive(){
		return getJsonMember1h() >= 0;
	}

	/**
	 * Return whether rain range is valid
	 * @return rain range
	 */
	public boolean isRainRangeValid(){
			return getJsonMember1h()>= 0 && getJsonMember1h() <= 320;
	}
}