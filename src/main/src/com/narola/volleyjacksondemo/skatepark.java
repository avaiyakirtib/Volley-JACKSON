package com.narola.volleyjacksondemo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
 
public class skatepark {
//	public String time;
//	public long milliseconds_since_epoch;
//	public String date;
	@JsonProperty("id")
     String id;
	 @JsonProperty("name")
     String name;
	 @JsonProperty("country")
     String country;
	 @JsonProperty("province")
     String province;
	 @JsonProperty("town")
     String town;
	 @JsonProperty("longitude")
     String longitude;
	 @JsonProperty("latitude")
     String latitude;
	 @JsonProperty("description")
     String description;
	 @JsonProperty("likes")
     String likes;
      
	/* @JsonProperty("id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	 @JsonProperty("name")

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	 @JsonProperty("country")

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	 @JsonProperty("province")

	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	 @JsonProperty("town")

	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	 @JsonProperty("longitude")

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	 @JsonProperty("latitude")

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	 @JsonProperty("description")

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	 @JsonProperty("likes")

	public String getLikes() {
		return likes;
	}
	public void setLikes(String likes) {
		this.likes = likes;
	}
 */
}
