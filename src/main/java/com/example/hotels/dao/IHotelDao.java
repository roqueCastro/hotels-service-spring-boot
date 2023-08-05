package com.example.hotels.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.hotels.model.Hotel;

public interface IHotelDao extends CrudRepository<Hotel, Long > {

}
