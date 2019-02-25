package com.lisonglin.service.impl;

import java.sql.SQLException;

import com.lisonglin.dao.RoomTitleDao;
import com.lisonglin.service.RoomTitleService;

public class RoomTitleImpl implements RoomTitleService {

	@Override
	public void addRoomTitle(int id,int level, int local) {
		try {
			new RoomTitleDao().addRoomTilte(id,level, local);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public int getRoomTitle() {
		try {
			return new RoomTitleDao().getRoomTitle();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}
	

}
