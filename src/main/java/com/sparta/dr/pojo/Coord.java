package com.sparta.dr.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coord{

	@JsonProperty("lon")
	private Integer lon;

	@JsonProperty("lat")
	private Integer lat;

	public Integer getLon(){
		return lon;
	}

	public Integer getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"Coord{" + 
			"lon = '" + lon + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}