package com.sparta.dr.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain{

	@JsonProperty("1h")
	private Double jsonMember1h;

	public Double getJsonMember1h(){
		return jsonMember1h;
	}

	@Override
 	public String toString(){
		return 
			"Rain{" + 
			"1h = '" + jsonMember1h + '\'' + 
			"}";
		}
}