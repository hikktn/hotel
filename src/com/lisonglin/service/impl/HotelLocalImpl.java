package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.HotelLocalDao;
import com.lisonglin.daomain.HotelLocal;
import com.lisonglin.service.HotelLocalService;

public class HotelLocalImpl implements HotelLocalService {

	@Override
	public List<HotelLocal> getHotelLocal() {
		try {
			return new HotelLocalDao().getHotelLocals();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean addHotelLocal(String hotellocal) {
		try {
			return new HotelLocalDao().addHotelLocal(hotellocal);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public Object checkHotelLocal(String hotellocal) {
		try {
			return new HotelLocalDao().checkHotelLocal(hotellocal);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean updateHotelLocal(String hotellocal, String hotellocalid) {
		try {
			return new HotelLocalDao().updateHotelLocal(hotellocal,hotellocalid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
