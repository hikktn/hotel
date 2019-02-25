package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Facilities;
import com.lisonglin.daomain.RoomEasy;
import com.lisonglin.daomain.RoomMedia;
import com.lisonglin.daomain.Rooms;

public class FacilitiesDao extends BaseDao<Facilities>{

	public Facilities getFacilities(Rooms room)  throws SQLException{
		String sql="select f.id,f.service " + 
				"from rooms r " + 
				"join facilities f " + 
				"on r.facilities=f.id " + 
				"join room_easy re " + 
				"on f.facilitate=re.facilitiesid " + 
				"where r.id=?";
		Facilities facilities = get(sql, room.getId());
		setFacilities(facilities,room);
		return facilities;
	}

	private void setFacilities(Facilities facilite,Rooms room) throws SQLException {
		//查询便利设施
		RoomEasy roomEasy=new RoomEasyDao().getRoomEasy(facilite,room);
		facilite.setRoomEasy(roomEasy);
		//查询媒体科技
		RoomMedia roomMedia=new RoomMediaDao().getRoomMedia(facilite,room);
		facilite.setRoomMedia(roomMedia);
	}

	public int getFacilities() throws SQLException{
		String sql="select max(facilitate) from facilities";
		return (int) getValue(sql);
	}
	
	public int getFacilitiesid() throws SQLException {
		String sql="select max(f.id) " + 
				"from facilities f " + 
				"join room_media rm " + 
				"on f.media=rm.facilitiesid " + 
				"join room_easy re  " + 
				"on f.facilitate=re.facilitiesid " ;
		return (int) getValue(sql);
	}
	
	public void addFacilities(int facilitate,int media) throws SQLException {
		String sql="insert into facilities(id,facilitate,media,service) values(null,?,?,'客房WIFI覆盖免费')";
		addAll(sql, facilitate,media);
	}
	
}
