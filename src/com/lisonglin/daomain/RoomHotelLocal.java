package com.lisonglin.daomain;

import java.util.List;

public class RoomHotelLocal {
	private int id;
	private int roomLocal;
	private List<HotelLocal> hotelLocal;

	public List<HotelLocal> getHotelLocal() {
		return hotelLocal;
	}

	public void setHotelLocal(List<HotelLocal> hotelLocal) {
		this.hotelLocal = hotelLocal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getRoomLocal() {
		return roomLocal;
	}

	public void setRoomLocal(int roomLocal) {
		this.roomLocal = roomLocal;
	}

	@Override
	public String toString() {
		return "RoomHotelLocal [hotelLocal=" + hotelLocal + ", id=" + id + ", roomLocal=" + roomLocal + "]";
	}

}
