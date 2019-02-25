package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.RoomAreaDao;
import com.lisonglin.daomain.RoomArea;
import com.lisonglin.service.RoomAreaService;

public class RoomAreaImpl implements RoomAreaService {

	@Override
	public List<RoomArea> getRoomArea() {
		try {
			return new RoomAreaDao().getRoomArea();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public void addRoomArea(int id,int area) {
		try {
			new RoomAreaDao().addRoomArea(id,area);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public int getRoomAreas() {
		try {
			return new RoomAreaDao().getRoomAreas();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
