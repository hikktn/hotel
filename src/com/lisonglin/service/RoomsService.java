package com.lisonglin.service;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Rooms;

public interface RoomsService {
	
	public List<Rooms> getAllRoom();
	//查询房间号
	public Object checkRoomId(String id);
	//增加房间
	/**
	 * int id, RoomLevel level, String window, RoomArea area, Bed bed,
			double price, List<RoomTitle> describe, List<Images> images,
			Facilities facilities, RoomHotelLocal roomHotelLocals
	 * @param room
	 */
	public void addRoom(int id,int levelid,int window,int area,int bed,double price,int descibe,int image,int facilities,int hotellocals ) throws Exception;
	public List<Rooms> getLikeRoom(String roomid);
	public boolean deleteRoom(String roomid);
}
