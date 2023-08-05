package com.example.hotels.controller;

import java.util.List;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotels.config.HotelsServiceConfiguraction;
import com.example.hotels.model.Hotel;
import com.example.hotels.model.PropertiesHotels;
import com.example.hotels.services.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;



@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private HotelsServiceConfiguraction configHotels;
	
	@GetMapping("hotels")
	public List<Hotel> search() {
		return (List<Hotel>) this.service.search();
	}
	
	
	@GetMapping("hotels/read/properties")
	public String getPropertiesHotels() throws JsonProcessingException {
		
		ObjectWriter owj=  new ObjectMapper().writer().withDefaultPrettyPrinter();
		
		PropertiesHotels propHotels = new PropertiesHotels(configHotels.getMsg(), configHotels.getBuildVersion(),
										configHotels.getMailDetails());
		
		String jsonString = owj.writeValueAsString(propHotels);
		
		return jsonString;

	}
}
