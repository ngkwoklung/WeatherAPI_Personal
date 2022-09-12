package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds{

	@JsonProperty("all")
	private Integer all;

	/**
	 * Get all property from clouds key
	 * @return all
	 */
	public Integer getAll(){
		return all;
	}

	/**
	 * Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Clouds{" + 
			"all = '" + all + '\'' + 
			"}";
		}
}