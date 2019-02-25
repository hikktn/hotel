package com.lisonglin.service;

import java.util.List;

import com.lisonglin.daomain.HotelLocal;

public interface HotelLocalService {
	public List<HotelLocal> getHotelLocal();

	public boolean addHotelLocal(String hotellocal);

	public Object checkHotelLocal(String hotellocal);

	public boolean updateHotelLocal(String hotellocal, String hotellocalid);
}
