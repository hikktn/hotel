package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Easy;
import com.lisonglin.daomain.Rooms;

public class EasyDao extends BaseDao<Easy>{

	public List<Easy> getEasy(Rooms room) throws SQLException {
		String sql="select e.id,e.facilities " + 
				"from rooms r " + 
				"join facilities f " + 
				"on r.facilities=f.id " + 
				"join room_easy re " + 
				"on f.facilitate=re.facilitiesid " + 
				"join easy e " + 
				"on re.easyid=e.id " + 
				"where r.id=?";
		List<Easy> easy = getAll(sql, room.getId());
		return easy;
	}
	
	public List<Easy> getRoomEaseis() throws SQLException{
		String sql="select id,facilities from easy";
		List<Easy> roomEasies =getAll(sql);
		return roomEasies;
	}

	public boolean addEasy(String easy) throws SQLException {
		String sql="insert into easy(id,facilities) values(null,?)";
		addAll(sql, easy);
		return true;
	}

	public Object checkEasy(String easy) throws SQLException {
		String sql="select facilities from easy where facilities=?";
		Object value = getValue(sql, easy);
		return value;
	}

	public boolean updateEasy(String easy, String easyid) throws SQLException {
		String sql="update easy set facilities=? where id=?";
		updateAll(sql, easy,easyid);
		return true;
	}

}
