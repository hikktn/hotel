package com.lisonglin.service.impl;

import java.sql.SQLException;

import com.lisonglin.dao.RoomHotelLocalDao;
import com.lisonglin.service.RoomHotelLocalService;

public class RoomHotelLocalImpl implements RoomHotelLocalService {

	@Override
	public int getRoomHotelLocal() {
		try {
			return new RoomHotelLocalDao().getRoomHotelLocal();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public void addRoomHotelLocal(int room_local, int hotel_local) {
		try {
			new RoomHotelLocalDao().addRoomHotelLocal(room_local, hotel_local);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
