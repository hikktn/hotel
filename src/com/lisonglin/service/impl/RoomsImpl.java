package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lisonglin.dao.RoomDao;
import com.lisonglin.daomain.Rooms;
import com.lisonglin.service.RoomsService;

public class RoomsImpl implements RoomsService {

	@Override
	public List<Rooms> getAllRoom() {
		try {
			return new RoomDao().getRoomsAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public Object checkRoomId(String id) {
		try {
			return new RoomDao().checkRoomId(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public void addRoom(int id, int levelid, int window, int area, int bed, double price, int descibe, int image,int facilities, int hotellocals) {
		try {
			new RoomDao().addRoom(id, levelid, window, area, bed, price, descibe, image,facilities, hotellocals);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public List<Rooms> getLikeRoom(String roomid) {
		try {
			return new RoomDao().getLikeRoom(roomid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean deleteRoom(String roomid) {
		try {
			new RoomDao().deleteRoom(roomid);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
