package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.HotelLocal;
import com.lisonglin.daomain.Rooms;

public class HotelLocalDao extends BaseDao<HotelLocal>{

	public List<HotelLocal> getHotelLocal(Rooms room)  throws SQLException{
		String sql="select hl.id,hl.`local` " + 
				"from rooms r " + 
				"join room_hotel_local rhl " + 
				"on r.hotel_local=rhl.room_local " + 
				"join hotel_locals hl " + 
				"on rhl.hotel_local=hl.id " + 
				"where r.id=?";
		List<HotelLocal> hotelLocal = getAll(sql, room.getId());
		return hotelLocal;
	}
	
	public List<HotelLocal> getHotelLocals() throws SQLException{
		String sql="select id,`local` from hotel_locals";
		List<HotelLocal> hotelLocals = getAll(sql);
		return hotelLocals;
	}

	public boolean addHotelLocal(String hotellocal) throws SQLException {
		String sql="insert into hotel_locals(id,`local`) values(null,?)";
		addAll(sql, hotellocal);
		return true;
	}

	public Object checkHotelLocal(String hotellocal) throws SQLException {
		String sql="select `local` from hotel_locals where `local`=?";
		Object value = getValue(sql, hotellocal);
		return value;
	}

	public boolean updateHotelLocal(String hotellocal, String hotellocalid) throws SQLException {
		String sql="update hotel_locals set `local`=? where id=?";
		updateAll(sql, hotellocal,hotellocalid);
		return true;
	}

}
