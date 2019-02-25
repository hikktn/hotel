package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.WindowDao;
import com.lisonglin.daomain.Rooms;
import com.lisonglin.daomain.Window;
import com.lisonglin.service.WindowService;

public class WindowImpl implements WindowService{

	@Override
	public Window getWindow(Rooms room) {
		try {
			return new WindowDao().getWindow(room);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public List<Window> getWindows() {
		try {
			return new WindowDao().getWindows();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public Object checkWindow(String result) {
		try {
			return new WindowDao().checkWindow(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean addWindow(String result) {
		try {
			return new WindowDao().addWindow(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean updateWindow(String result,String id) {
		try {
			return new WindowDao().updateWindow(result,id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
