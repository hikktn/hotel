package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.HotelLocal;
import com.lisonglin.daomain.RoomHotelLocal;
import com.lisonglin.daomain.Rooms;

public class RoomHotelLocalDao extends BaseDao<RoomHotelLocal>{

	public RoomHotelLocal getHotelLocal(Rooms room)  throws SQLException{
		String sql="select r.hotel_local,rhl.id,rhl.room_local roomLocal " + 
				"from rooms r " + 
				"join room_hotel_local rhl " + 
				"on r.hotel_local=rhl.room_local " + 
				"where r.id=?";
		RoomHotelLocal hotelLocals = get(sql, room.getId());
		setRoomHotelLocal(hotelLocals,room);
		return hotelLocals;
	}

	private void setRoomHotelLocal(RoomHotelLocal roomHotelLocal, Rooms room) throws SQLException {
		//查询标签
		List<HotelLocal> hotelLocal=new HotelLocalDao().getHotelLocal(room);
		roomHotelLocal.setHotelLocal(hotelLocal);
	}
	
	public int getRoomHotelLocal() throws SQLException{
		String sql="select max(rhl.room_local) " + 
				"from rooms r " + 
				"join room_hotel_local rhl " + 
				"on r.hotel_local=rhl.room_local " + 
				"join hotel_locals hl " + 
				"on rhl.hotel_local=hl.id";
		return (int) getValue(sql);
	}
	
	public void addRoomHotelLocal(int room_local,int hotel_local) throws SQLException {
		String sql="insert into room_hotel_local(id,room_local,hotel_local) values(null,?,?)";
		addAll(sql, room_local,hotel_local);
	}

}
