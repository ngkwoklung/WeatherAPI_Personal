package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Clouds{

	@JsonProperty("all")
	private Integer all;

	/**
	 * Return Get all property from clouds key
	 * @return all
	 */
	public Integer getAll(){
		return all;
	}

	/**
	 * Return Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Clouds{" + 
			"all = '" + all + '\'' + 
			"}";
		}

	/**
	 * Return whether the clouds are present
 	 * @return (boolean) all
	 */
	public boolean isCloudsNull(){
		return getAll() != null;
	}

	/**
	 * Return clouds level
	 * @return all
	 */
	public boolean isCloudPositive(){
		return getAll() >= 0;
	}
}