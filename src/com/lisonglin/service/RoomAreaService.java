package com.lisonglin.service;

import java.util.List;

import com.lisonglin.daomain.RoomArea;

public interface RoomAreaService {
	
	public List<RoomArea> getRoomArea();
	
	public void addRoomArea(int id,int area) throws Exception;
	
	public int getRoomAreas();
	
}
