package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Locals;
import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.RoomTitle;
import com.lisonglin.daomain.Rooms;

public class RoomTitleDao extends BaseDao<RoomTitle> {

	public List<RoomTitle> getRoomTitle(Rooms room)  throws SQLException{
		String sql="select rt.id,l.localid,l.localcontent " + 
				"from rooms r " + 
				"join roomtitle rt " + 
				"on r.`describe`=rt.id " + 
				"join locals l " + 
				"on rt.`local`=l.localid " + 
				"join roomlevel rl " + 
				"on rt.`level`=rl.id "
				+ "where r.id=?";
		 List<RoomTitle> rooms = getAll(sql,room.getId());
		 for(RoomTitle roomTitle : rooms) {
			 //查询标签和级别组成标题
			 setRoomTitle(roomTitle);
		 }
		 return rooms;
	}

	private void setRoomTitle(RoomTitle roomTitle)  throws SQLException{
		//查询标签
		LocalsDao localsDao=new LocalsDao();
		Locals local= localsDao.getLocals(roomTitle);
		roomTitle.setLocal(local);
		//查询级别
		RoomLevelDao roomLevelDao=new RoomLevelDao();
		RoomLevel levelTitle = roomLevelDao.getLevelTitle(roomTitle);
		roomTitle.setLevel(levelTitle);
	}
	
	public void addRoomTilte(int id,int level,int local) throws SQLException {
		String sql="insert into roomtitle(id,`level`,`local`) values(?,?,?)";
		addAll(sql, id,level,local);
	}
	
	public int getRoomTitle() throws SQLException {
		String sql="select max(rt.id) " + 
				"from rooms r " + 
				"join roomtitle rt  " + 
				"on r.`describe`=rt.id " + 
				"join locals l " + 
				"on rt.`local`=l.localid " + 
				"join roomlevel rl  " + 
				"on rt.`level`=rl.id";
		return (int) getValue(sql);
	}
	
}
