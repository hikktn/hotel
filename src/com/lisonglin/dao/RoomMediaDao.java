package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Facilities;
import com.lisonglin.daomain.Media;
import com.lisonglin.daomain.RoomMedia;
import com.lisonglin.daomain.Rooms;

public class RoomMediaDao extends BaseDao<RoomMedia>{

	public RoomMedia getRoomMedia(Facilities facilite, Rooms room)  throws SQLException{
		String sql="select rm.id,rm.facilitiesid " + 
				"from rooms r " + 
				"join facilities f " + 
				"on r.facilities=f.id " + 
				"join room_media rm " + 
				"on f.media=rm.facilitiesid " + 
				"where r.id=?";
		RoomMedia roomMedias = get(sql, room.getId());
		setRoomMedia(roomMedias,room);
		return roomMedias;
	}

	private void setRoomMedia(RoomMedia roomMedia, Rooms room) throws SQLException {
		//查询媒体科技
		List<Media> medias=new MediaDao().getMedia(room);
		roomMedia.setMedia(medias);
	}

}
