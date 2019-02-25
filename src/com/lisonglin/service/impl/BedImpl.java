package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.BedDao;
import com.lisonglin.daomain.Bed;
import com.lisonglin.service.BedService;

public class BedImpl implements BedService {

	@Override
	public List<Bed> getBeds() {
		try {
			return new BedDao().getBeds();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addBed(String bedNunStr, String bedWidthStr, String bedNameStr) {
		try {
			return new BedDao().addBed(bedNunStr,bedWidthStr,bedNameStr);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean updateBed(String bedNumStr, String bedWidthStr, String bedNameStr,String bedid) {
		try {
			return new BedDao().updateBed(bedNumStr,bedWidthStr,bedNameStr,bedid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public Object checkBed(String bedNum, String bedWidth, String bedBed) {
		try {
			return new BedDao().checkBed(bedNum,bedWidth,bedBed);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
