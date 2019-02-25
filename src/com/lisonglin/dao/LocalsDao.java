package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Locals;
import com.lisonglin.daomain.RoomTitle;

public class LocalsDao extends BaseDao<Locals>{

	public Locals getLocals(RoomTitle roomTitle) throws SQLException {
		String sql="select l.localid,l.localcontent " + 
				"from rooms r " + 
				"join roomtitle rt " + 
				"on r.`describe`=rt.id " + 
				"join locals l " + 
				"on rt.`local`=l.localid " + 
				"where rt.id=?";
		Locals locals = get(sql, roomTitle.getId());
		return locals;
	}
	
	public List<Locals> getLocal() throws SQLException {
		String sql="select l.localid,l.localcontent from locals l";
		List<Locals> locals = getAll(sql);
		return locals;
	}

}
