package com.example.hotels.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotels.dao.IHotelDao;
import com.example.hotels.model.Hotel;

@Service
public class HotelServiceImpl implements IHotelService {

	@Autowired
	private IHotelDao hotelDao;
	
	@Override
	public List<Hotel> search() {		// TODO Auto-generated method stub
		return (List<Hotel>) hotelDao.findAll();
	}

}
