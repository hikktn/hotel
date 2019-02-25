package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.RoomLevelDao;
import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.Rooms;
import com.lisonglin.service.RoomLevelService;

public class RoomLevelImpl implements RoomLevelService{

	@Override
	public RoomLevel getRoomLevel(Rooms rooms) {
		try {
			return new RoomLevelDao().getLevel(rooms);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public List<RoomLevel> getRoomLevels() {
		try {
			return new RoomLevelDao().getLevels();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
