package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Media;
import com.lisonglin.daomain.Rooms;

public class MediaDao extends BaseDao<Media>{

	public List<Media> getMedia( Rooms room)  throws SQLException{
		String sql="select m.id,m.facilities " + 
				"from rooms r " + 
				"join facilities f " + 
				"on r.facilities=f.id " + 
				"join room_media rm " + 
				"on f.media=rm.facilitiesid " + 
				"join media m " + 
				"on rm.mediaid=m.id " + 
				"where r.id=?";
		List<Media> media = getAll(sql, room.getId());
		return media;
	}
	
	public List<Media> getMedias() throws SQLException{
		String sql="select m.id,m.facilities from media m";
		List<Media> medias = getAll(sql);
		return medias;
	}
	
	public void addMedia(int facilitiesid,int mediaid) throws SQLException {
		String sql="insert into room_media(id,facilitiesid,mediaid) values(null,?,?)";
		addAll(sql, facilitiesid,mediaid);
	}

	public Object checkMedia(String result) throws SQLException {
		String sql="select facilities from media where facilities=? ";
		Object value = getValue(sql, result);
		return value;
	}

	public boolean addMedia(String result) throws SQLException {
		String sql="insert into media(id,facilities) values(null,?)";
		addAll(sql, result);
		return true;
	}

	public boolean updateMedia(String media, String mediaid) throws SQLException {
		String sql="update media set facilities=? where id=?";
		updateAll(sql, media,mediaid);
		return true;
	}

}
