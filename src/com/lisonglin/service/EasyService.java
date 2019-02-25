package com.lisonglin.service;

import java.util.List;

import com.lisonglin.daomain.Easy;

public interface EasyService {
	public List<Easy> getRoomEasies();

	public boolean addEasy(String easy);

	public Object checkEasy(String media);

	public boolean updateEasy(String easy, String easyid);
}
