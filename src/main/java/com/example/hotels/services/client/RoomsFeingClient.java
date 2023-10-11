package com.example.hotels.services.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.hotels.model.Room;

@FeignClient("rooms")
public interface RoomsFeingClient {
	@RequestMapping(method = RequestMethod.GET, value = "rooms/{id}", consumes = "application/json")
	public List<Room> searchByHotelId(@PathVariable long id);
}
