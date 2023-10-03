package com.example.hotels.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.hotels.dao.IHotelDao;
import com.example.hotels.model.Hotel;
import com.example.hotels.model.HotelRooms;
import com.example.hotels.model.Room;
import com.example.hotels.services.client.RoomsFeingClient;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelDao hotelDao;
	
//	@Autowired
//	private RestTemplate clientRest;
	
	@Autowired
	RoomsFeingClient roomsFeingClient;
	
	@Override
	public List<Hotel> search() {		// TODO Auto-generated method stub
		return (List<Hotel>) hotelDao.findAll();
	}

	@Override
	public HotelRooms searchHotelById(long hotelId) {
		HotelRooms response = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		
		//REST TEMPLATE
//		Map<String, Long> pathVariable = new HashMap<String, Long>();
//		pathVariable.put("id", hotelId);
//		List<Room> rooms = Arrays.asList(clientRest.getForObject("http://localhost:8082/rooms/{id}", Room[].class, pathVariable));
		
		//FEING
		List<Room> rooms = roomsFeingClient.searchByHotelId(hotelId);
		
		response.setHotelId(hotel.get().getHotelId());
		response.setHotelName(hotel.get().getHotelName());
		response.setHotelAddress(hotel.get().getHotelAddress());
		response.setRooms(rooms);
		
		return response;
	}



}
