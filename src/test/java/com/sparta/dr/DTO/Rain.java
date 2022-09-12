package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain{

	@JsonProperty("1h")
	private Double jsonMember1h;

	/**
	 * Returns rain level in 1h property
	 * @return 1h
	 */
	public Double getJsonMember1h(){
		return jsonMember1h;
	}

	/**
	 * Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Rain{" + 
			"1h = '" + jsonMember1h + '\'' + 
			"}";
		}
}