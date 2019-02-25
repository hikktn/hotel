package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.EasyDao;
import com.lisonglin.daomain.Easy;
import com.lisonglin.service.EasyService;

public class EasyImpl implements EasyService {

	@Override
	public List<Easy> getRoomEasies() {
		try {
			return new EasyDao().getRoomEaseis();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addEasy(String easy) {
		try {
			return new EasyDao().addEasy(easy);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public Object checkEasy(String easy) {
		try {
			return new EasyDao().checkEasy(easy);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean updateEasy(String easy, String easyid) {
		try {
			return new EasyDao().updateEasy(easy,easyid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
