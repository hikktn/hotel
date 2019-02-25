package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.RoomTitle;
import com.lisonglin.daomain.Rooms;

public class RoomLevelDao extends BaseDao<RoomLevel> {
	
	public RoomLevel getLevel(Rooms room) throws SQLException{
		String sql="select rl.id,rl.`level` " + 
				"from rooms r " + 
				"join roomtitle rt " + 
				"on r.`describe`=rt.id " + 
				"join roomlevel rl " + 
				"on rt.`level`=rl.id " + 
				"where r.id=? ";
		RoomLevel roomLevel=get(sql, room.getId());
		return roomLevel;
	}
	
	public RoomLevel getLevelTitle(RoomTitle roomTitle)  throws SQLException{
		String sql="select rl.id,rl.`level` " + 
				"from rooms r " + 
				"join roomtitle rt " + 
				"on r.`describe`=rt.id " + 
				"join roomlevel rl " + 
				"on rt.`level`=rl.id " + 
				"where rt.id=? ";
		RoomLevel roomLevel = get(sql, roomTitle.getId());
		return roomLevel;
	}
	
	//查询全部的级别
	public List<RoomLevel> getLevels() throws SQLException{
		String sql="select rl.id,rl.`level` " + 
				"from roomlevel rl  ";
		List<RoomLevel> roomLevels = getAll(sql);
		return roomLevels;
	}
	
}
