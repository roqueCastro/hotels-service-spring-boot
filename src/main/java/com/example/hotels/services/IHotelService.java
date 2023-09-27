package com.example.hotels.services;

import java.util.List;

import com.example.hotels.model.Hotel;
import com.example.hotels.model.HotelRooms;

public interface IHotelService {
	List<Hotel> search();
	HotelRooms searchHotelById(long hotelId);
}
