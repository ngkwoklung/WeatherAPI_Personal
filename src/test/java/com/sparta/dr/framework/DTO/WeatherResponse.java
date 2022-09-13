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
		public boolean isRainValid(){
		return rain != null;
		}
	    public boolean isRainRangeValid(){
		    if(rain!=null){
			    return rain.getJsonMember1h()>= 0 && rain.getJsonMember1h() <= 320;
		    } return false;
	    }
	    public boolean isVisibilityValid(){
		    return visibility != null;
	    }
		public boolean visibilityIsBetweenValidRange() {
			return visibility >= 0 && visibility <= 10000;
		}
	    public boolean isTimeZoneValid(){
		    return timezone != null;
	    }
		public boolean timezoneIsBetweenValidRange() {
			return timezone >= -43200 && timezone <= 50400;
		}

		public boolean dtIsToday() {
			return LocalDate.ofInstant(Instant.ofEpochSecond(dt), TimeZone.getDefault().toZoneId()).equals(LocalDate.now());
		}
		public boolean isWindValid(){
		    return wind != null;
		}

		public boolean isDegBetween0And360(){
			return getWind().getDeg() >= 0 && getWind().getDeg() <= 360;
		}
		public boolean isCOD200(){
		    return cod == 200;
		}
	    public boolean isSysValid(){
		    return sys != null;
    	}
	    public boolean isIdValid() {
			return id != null;
		}

}