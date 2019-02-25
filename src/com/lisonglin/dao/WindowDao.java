package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Rooms;
import com.lisonglin.daomain.Window;

public class WindowDao extends BaseDao<Window>{
	public Window getWindow(Rooms room) throws SQLException {
		String sql="select w.id,w.window " + 
				"from rooms r JOIN " + 
				"windows w " + 
				"on r.window=w.id " + 
				"where r.id=?";
		Window window = get(sql, room.getId());
		return window;
	}
	
	public List<Window> getWindows() throws SQLException{
		String sql="select id,window from windows";
		List<Window> window = getAll(sql);
		return window;
	}
	
	public Object checkWindow(String result) throws SQLException {
		String sql="select window from windows where window=?";
		Object value = getValue(sql, result);
		return value;
	}

	public boolean addWindow(String result) throws SQLException {
		String sql="insert into windows(id,window) values(null,?) ";
		addAll(sql, result);
		return true;
	}

	public boolean updateWindow(String result,String id) throws SQLException {
		String sql="update windows set window=? where id=?";
		updateAll(sql,result,id);
		return true;
	}
	
}
