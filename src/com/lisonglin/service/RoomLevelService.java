package com.lisonglin.service;

import java.util.List;

import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.Rooms;

public interface RoomLevelService {
	//查询一个级别
	public RoomLevel getRoomLevel(Rooms rooms);
	//查询全部级别
	public List<RoomLevel> getRoomLevels();
}
