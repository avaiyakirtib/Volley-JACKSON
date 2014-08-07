package com.narola.volleyjacksondemo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SkateParkDetails {

	@JsonProperty("skatepark")
	ArrayList<skatepark> skateParkDetails;
	
}
