package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Bed;
import com.lisonglin.daomain.Rooms;

public class BedDao extends BaseDao<Bed> {
	
	public Bed getBed(Rooms room) throws SQLException {
		String sql="select b.id,b.number,b.width,b.bed " + 
				"from rooms r JOIN " + 
				"bed b " + 
				"on r.bed=b.id " + 
				"where r.id=?";
		Bed bed = get(sql, room.getId());
		return bed;
	}
	
	public List<Bed> getBeds() throws SQLException{
		String sql="select id,number,width,bed from bed ";
		List<Bed> beds = getAll(sql);
		return beds;
	}

	public Object checkBed(String bedNum, String bedWidth, String bedBed) throws SQLException {
		String sql="select count(*) from bed where number=? and width=? and bed=?";
		Object value = getValue(sql, bedNum,bedWidth,bedBed);
		return value;
	}

	public boolean addBed(String bedNunStr, String bedWidthStr, String bedNameStr) throws SQLException {
		String sql="insert into bed(id,number,width,bed) values(null,?,?,?)";
		addAll(sql, bedNunStr,bedWidthStr,bedNameStr);
		return true;
	}

	public boolean updateBed(String bedNumStr, String bedWidthStr, String bedNameStr,String bedid) throws SQLException {
		String sql="update bed set number=?,width=?,bed=? where id=?";
		updateAll(sql, bedNumStr,bedWidthStr,bedNameStr,bedid);
		return true;
	}
	
	
}
