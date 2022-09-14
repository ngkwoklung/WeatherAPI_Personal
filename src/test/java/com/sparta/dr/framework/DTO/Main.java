package com.sparta.dr.framework.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Main{

	@JsonProperty("temp")
	private Double temp;

	@JsonProperty("temp_min")
	private Double tempMin;

	@JsonProperty("grnd_level")
	private Integer grndLevel;

	@JsonProperty("humidity")
	private Integer humidity;

	@JsonProperty("pressure")
	private Integer pressure;

	@JsonProperty("sea_level")
	private Integer seaLevel;

	@JsonProperty("feels_like")
	private Double feelsLike;

	@JsonProperty("temp_max")
	private Double tempMax;

	/**
	 * Return Get temperature
	 * @return temp
	 */
	public Double getTemp(){
		return temp;
	}

	/**
	 * Return Get minimum temperature
	 * @return temp_min
	 */
	public Double getTempMin(){
		return tempMin;
	}

	/**
	 * Return Get ground level
	 * @return grnd_level
	 */
	public Integer getGrndLevel(){
		return grndLevel;
	}

	/**
	 * Return Get humidity level
	 * @return humidity
	 */
	public Integer getHumidity(){
		return humidity;
	}

	/**
	 * Return Get pressure level
	 * @return pressure
	 */
	public Integer getPressure(){
		return pressure;
	}

	/**
	 * Return Get sea level
	 * @return sea_level
	 */
	public Integer getSeaLevel(){
		return seaLevel;
	}

	/**
	 * Return Obtain the information about how temperature feels like
	 * @return feels_like
	 */
	public Double getFeelsLike(){
		return feelsLike;
	}

	/**
	 * Return Get maximum temperature
	 * @return temp_max
	 */
	public Double getTempMax(){
		return tempMax;
	}

	/**
	 * Return Obtain all the information as one string.
	 * @return all values as a string
	 */
	@Override
 	public String toString(){
		return 
			"Main{" + 
			"temp = '" + temp + '\'' + 
			",temp_min = '" + tempMin + '\'' + 
			",grnd_level = '" + grndLevel + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			",sea_level = '" + seaLevel + '\'' + 
			",feels_like = '" + feelsLike + '\'' + 
			",temp_max = '" + tempMax + '\'' + 
			"}";
		}
}