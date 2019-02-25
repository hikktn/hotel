package com.lisonglin.service.impl;

import java.sql.SQLException;

import com.lisonglin.dao.FacilitiesDao;
import com.lisonglin.service.FacilitiesService;

public class FacilitatiesImpl implements FacilitiesService {

	@Override
	public int getFacilite() {
		try {
			return new FacilitiesDao().getFacilities();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public void addFacilite(int facilitate, int media) {
		try {
			new FacilitiesDao().addFacilities(facilitate, media);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public int getFaciliteid() {
		try {
			return new FacilitiesDao().getFacilitiesid();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
