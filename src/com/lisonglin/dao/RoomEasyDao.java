package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Easy;
import com.lisonglin.daomain.Facilities;
import com.lisonglin.daomain.RoomEasy;
import com.lisonglin.daomain.Rooms;

public class RoomEasyDao extends BaseDao<RoomEasy>{

	public RoomEasy getRoomEasy(Facilities facilite,Rooms room) throws SQLException {
		String sql="select re.id,re.facilitiesid " + 
				"from rooms r " + 
				"join facilities f " + 
				"on r.facilities=f.id " + 
				"join room_easy re " + 
				"on f.facilitate=re.facilitiesid " + 
				"where r.id=?";
		RoomEasy roomEasies = get(sql, room.getId());
		setEasy(roomEasies,room);
		return roomEasies;
	}

	private void setEasy(RoomEasy roomEasy, Rooms room)  throws SQLException{
		//查询便利设施
		List<Easy> easy=new EasyDao().getEasy(room);
		roomEasy.setEasy(easy);
	}
	
	public void addEasy(int facilities,int easy) throws SQLException {
		String sql="insert into room_easy(id,facilitiesid,easyid) values(null,?,?)";
		addAll(sql, facilities,easy);
	}

}
