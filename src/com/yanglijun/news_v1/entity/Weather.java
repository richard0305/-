package com.yanglijun.news_v1.entity;

public class Weather {
    private String city;
   private String county; 
    private String date;
    private String day_condition;
    private String day_wind; 
    private String day_temperature; 
    private String night_condition; 
    private String night_wind;
    private String night_temperature;
    private long update_time;
	public Weather() {
		super();
	}
	public Weather(String city, String county, String date,
			String day_condition, String day_wind, String day_temperature,
			String night_condition, String night_wind,
			String night_temperature, long update_time) {
		super();
		this.city = city;
		this.county = county;
		this.date = date;
		this.day_condition = day_condition;
		this.day_wind = day_wind;
		this.day_temperature = day_temperature;
		this.night_condition = night_condition;
		this.night_wind = night_wind;
		this.night_temperature = night_temperature;
		this.update_time = update_time;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDay_condition() {
		return day_condition;
	}
	public void setDay_condition(String day_condition) {
		this.day_condition = day_condition;
	}
	public String getDay_wind() {
		return day_wind;
	}
	public void setDay_wind(String day_wind) {
		this.day_wind = day_wind;
	}
	public String getDay_temperature() {
		return day_temperature;
	}
	public void setDay_temperature(String day_temperature) {
		this.day_temperature = day_temperature;
	}
	public String getNight_condition() {
		return night_condition;
	}
	public void setNight_condition(String night_condition) {
		this.night_condition = night_condition;
	}
	public String getNight_wind() {
		return night_wind;
	}
	public void setNight_wind(String night_wind) {
		this.night_wind = night_wind;
	}
	public String getNight_temperature() {
		return night_temperature;
	}
	public void setNight_temperature(String night_temperature) {
		this.night_temperature = night_temperature;
	}
	public long getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "Weather [city=" + city + ", county=" + county + ", date="
				+ date + ", day_condition=" + day_condition + ", day_wind="
				+ day_wind + ", day_temperature=" + day_temperature
				+ ", night_condition=" + night_condition + ", night_wind="
				+ night_wind + ", night_temperature=" + night_temperature
				+ ", update_time=" + update_time + "]";
	}
    
    
    
}
