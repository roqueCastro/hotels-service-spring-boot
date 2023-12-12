package com.example.hotels.model;

import java.util.List;


import lombok.Data;

@Data
public class Room {
	
	private long roomId;
	private long hotelId;
	private String roomName;
	private String roomAvailable;
	private List<Reservation> reservations;

}
