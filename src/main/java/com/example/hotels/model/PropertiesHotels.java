package com.example.hotels.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PropertiesHotels {

	private String msg;
	private String buildVersion;
	private Map<String, String> mailDetails;
	
	
}
