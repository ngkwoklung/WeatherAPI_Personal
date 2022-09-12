package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Clouds{

	@JsonProperty("all")
	private Integer all;

	public Integer getAll(){
		return all;
	}

	@Override
 	public String toString(){
		return 
			"Clouds{" + 
			"all = '" + all + '\'' + 
			"}";
		}
}