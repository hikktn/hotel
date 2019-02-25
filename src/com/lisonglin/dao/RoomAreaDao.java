package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.RoomArea;
import com.lisonglin.daomain.Rooms;

public class RoomAreaDao extends BaseDao<RoomArea> {
	
	public RoomArea getRoomArea(Rooms room) throws SQLException {
		String sql="select ra.id,ra.area " + 
				"from rooms r JOIN " + 
				"roomarea ra " + 
				"on r.area=ra.id " + 
				"where r.id=?";
		RoomArea roomArea = get(sql, room.getId());
		return roomArea;
	}
	
	public List<RoomArea> getRoomArea() throws SQLException{
		String sql="select id,area from roomarea";
		List<RoomArea> roomAreas = getAll(sql);
		return roomAreas;
	}
	
	public void addRoomArea(int id,int area) throws SQLException {
		String sql="insert into roomarea(id,area) values(?,?)";
		addAll(sql, id,area);		
	}
	
	public int getRoomAreas() throws SQLException {
		String sql="select max(area) from rooms";
		return (int) getValue(sql);
	}
}
