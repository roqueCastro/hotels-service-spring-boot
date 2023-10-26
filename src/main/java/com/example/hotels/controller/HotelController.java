package com.example.hotels.controller;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotels.config.HotelsServiceConfiguraction;
import com.example.hotels.model.Hotel;
import com.example.hotels.model.HotelRooms;
import com.example.hotels.model.PropertiesHotels;
import com.example.hotels.services.IHotelService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;



@RestController
public class HotelController {
	
	private static final Logger logger = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	private IHotelService service;
	
	@Autowired
	private HotelsServiceConfiguraction configHotels;
	
	@GetMapping("hotels")
	public List<Hotel> search() {
		logger.info("Inicio de método search()");
		return (List<Hotel>) this.service.search();
	}
	
	
	
	@GetMapping("hotels/{hotelId}")
	//@CircuitBreaker(name="searchHotelByIdSupportCB", fallbackMethod = "searchHotelByIdAlternative")
	@Retry(name="searchHotelByIdSupportRetry", fallbackMethod = "searchHotelByIdAlternative")
	public HotelRooms searchHotelById(@PathVariable long hotelId) {
		logger.info("Inicio de método searchHotelById()");
		return  this.service.searchHotelById(hotelId);
	}
	
	
	@GetMapping("hotels-one/{hotelId}")
	public HotelRooms searchHotelByIdAlternative(@PathVariable long hotelId, Throwable thr) {
		logger.info("Inicio de método searchHotelByIdAlternative");
		return  this.service.searchHotelByIdWithOutRooms(hotelId);
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
