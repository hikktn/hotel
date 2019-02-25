package com.lisonglin.service.impl;

import java.sql.SQLException;

import com.lisonglin.dao.RoomEasyDao;
import com.lisonglin.service.RoomEasyService;

public class RoomEasyImpl implements RoomEasyService {

	@Override
	public void addEasy(int facilities,int easy) {
		try {
			new RoomEasyDao().addEasy(facilities, easy);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
