package com.lisonglin.service;

import java.util.List;

import com.lisonglin.daomain.Bed;

public interface BedService {
	
	public List<Bed> getBeds() ;

	public Object checkBed(String bedNum, String bedWidth, String bedBed);

	public boolean addBed(String bedNumStr, String bedWidthStr, String bedNameStr);

	public boolean updateBed(String bedNumStr, String bedWidthStr, String bedNameStr,String bedid);
	
}
