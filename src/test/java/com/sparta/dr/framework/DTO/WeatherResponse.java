package com.sparta.dr.framework.DTO;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherResponse {

	@JsonProperty("rain")
	private Rain rain;

	@JsonProperty("visibility")
	private Integer visibility;

	@JsonProperty("timezone")
	private Integer timezone;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("clouds")
	private Clouds clouds;

	@JsonProperty("sys")
	private Sys sys;

	@JsonProperty("dt")
	private Integer dt;

	@JsonProperty("coord")
	private Coord coord;

	@JsonProperty("weather")
	private List<WeatherItem> weather;

	@JsonProperty("name")
	private String name;

	@JsonProperty("cod")
	private Integer cod;

	@JsonProperty("id")
	private Integer id;

	@JsonProperty("base")
	private String base;

	@JsonProperty("wind")
	private Wind wind;

	@JsonProperty("snow")
	private Snow snow;

	public Rain getRain(){
		return rain;
	}

	public Integer getVisibility(){
		return visibility;
	}

	public Integer getTimezone(){
		return timezone;
	}

	public Main getMain(){
		return main;
	}

	public Clouds getClouds(){
		return clouds;
	}

	public Sys getSys(){
		return sys;
	}

	public Integer getDt(){
		return dt;
	}

	public Coord getCoord(){
		return coord;
	}

	public List<WeatherItem> getWeather(){
		return weather;
	}

	public String getName(){
		return name;
	}

	public Integer getCod(){
		return cod;
	}

	public Integer getId(){
		return id;
	}

	public String getBase(){
		return base;
	}

	public Wind getWind(){
		return wind;
	}

	public Snow getSnow(){ return snow;}

	@Override
 	public String toString(){
		return 
			"WeatherResponseDTO{" + 
			"rain = '" + rain + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",timezone = '" + timezone + '\'' + 
			",main = '" + main + '\'' + 
			",clouds = '" + clouds + '\'' + 
			",sys = '" + sys + '\'' + 
			",dt = '" + dt + '\'' + 
			",coord = '" + coord + '\'' + 
			",weather = '" + weather + '\'' + 
			",name = '" + name + '\'' + 
			",cod = '" + cod + '\'' + 
			",id = '" + id + '\'' + 
			",base = '" + base + '\'' + 
			",wind = '" + wind + '\'' + 
			"}";
		}

	/**
	 * Return whether rain is valid or not
	 * @return boolean
	 */
	public boolean isRainValid(){
		return rain != null;
	}

	/**
	 * Return whether visibility is present or not
	 * @return boolean (visibility)
	 */
	    public boolean isVisibilityValid(){
		    return visibility != null;
	    }
	/**
	 * Return check whether visibility is in valid range
	 * @return visibility
	 */
		public boolean visibilityIsBetweenValidRange() {
			return visibility >= 0 && visibility <= 10000;
		}

	/**
	 * Return check whether time zone is present or not
	 * @return boolean
	 */
	    public boolean isTimeZoneValid(){
		    return timezone != null;
	    }

	/**
	 * Return check whether timezone is in valid range
	 * @return timezone
	 */
		public boolean timezoneIsBetweenValidRange() {
			return timezone >= -43200 && timezone <= 50400;
		}

	/**
	 * Return check whether date is today
	 * @return boolean
	 */
		public boolean dtIsToday() {
			return LocalDate.ofInstant(Instant.ofEpochSecond(dt), TimeZone.getDefault().toZoneId()).equals(LocalDate.now());
		}

	/**
	 * Return check whether wind is present or not
	 * @return boolean
	 */
		public boolean isWindValid(){
		    return wind != null;
		}

	/**
	 * Return whether cod is 200
	 * @return cod
	 */

		public boolean isCOD200(){
		    return cod == 200;
		}

	/**
	 * Return whether sys is present or not
	 * @return boolean
	 */
	    public boolean isSysValid(){
		    return sys != null;
    	}

	/**
	 * Return whether ID is present or not
	 * @return boolean
	 */
	    public boolean isIdValid() {
			return id != null;
		}

	/**
	 * Return check whether wind is present or not
	 * @return boolean
	 */
	public boolean areIdsInWeatherItemValid() {
		for( WeatherItem item: weather){
			if (!item.idIsValid()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return check whether icons in weather items are valid
	 * @return boolean
	 */
	public boolean areIconsInWeatherItemValid() {
		for( WeatherItem item: weather){
			if (!item.iconIsValid()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return check mains in weather item is present or not
	 * @return boolean
	 */
	public boolean areMainsInWeatherItemValid() {
		for( WeatherItem item: weather){
			if (!item.mainIsValid()) {
				return false;
			}
		}
		return true;
	}

	public boolean areDescriptionsInWeatherItemValid() {
		for( WeatherItem item: weather){
			if (!item.descriptionIsValid()) {
				return false;
			}
		}
		return true;
	}
}