package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Bed;
import com.lisonglin.daomain.Broadbands;
import com.lisonglin.daomain.Facilities;
import com.lisonglin.daomain.Floor;
import com.lisonglin.daomain.Images;
import com.lisonglin.daomain.RoomArea;
import com.lisonglin.daomain.RoomHotelLocal;
import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.RoomTitle;
import com.lisonglin.daomain.Rooms;
import com.lisonglin.daomain.SpecialRoom;
import com.lisonglin.daomain.Window;

public class RoomDao extends BaseDao<Rooms> {

	public List<Rooms> getRoomsAll() throws SQLException{
		String sql = "select id,price from rooms";
		List<Rooms> rooms = getAll(sql);
		for (Rooms room : rooms) {
			setAllAttribute(room);
		}
		return rooms;
	}

	private void setAllAttribute(Rooms room) throws SQLException {
		// 查询级别
		RoomLevel level = new RoomLevelDao().getLevel(room);
		room.setLevel(level);
		//查询面积
		RoomArea roomArea = new RoomAreaDao().getRoomArea(room);
		room.setArea(roomArea);
		//查询床
		Bed bed = new BedDao().getBed(room);
		room.setBed(bed);
		//查询窗
		Window window = new WindowDao().getWindow(room);
		room.setWindow(window);
		//查询标题
		List<RoomTitle> roomTitle = new RoomTitleDao().getRoomTitle(room);
		room.setDescribe(roomTitle);
		//查询封面
		List<Images> images=new ImagesDao().getImages(room);
		room.setImages(images);
		//查询设施
		Facilities facilities=new FacilitiesDao().getFacilities(room);
		room.setFacilities(facilities);
		//查询标签
		RoomHotelLocal hotelLocals=new RoomHotelLocalDao().getHotelLocal(room);
		room.setRoomHotelLocals(hotelLocals);
	}
	
	//查询room的id
	public Object checkRoomId(String id) throws SQLException {
		String sql="select id from rooms where id=?";
		Object roomid =getValue(sql,id);
		return roomid;
	}

	public void addRoom(int id, int levelid, int window, int area, int bed, double price, int descibe, int image,
			int facilities, int hotellocals) throws SQLException {
		String sql="insert into rooms(id,`level`,window,area,bed,price,`describe`,images,facilities,hotel_local) values(?,?,?,?,?,?,?,?,?,?)";
		addAll(sql, id,levelid,window,area,bed,price,descibe,image,facilities,hotellocals);
	}
	
	public List<Rooms> getLikeRoom(String roomid) throws SQLException {
		String sql="select distinct r.id,r.price " + 
				"from rooms r join roomlevel rl  " + 
				"on r.`level`=rl.id join bed b on r.bed=b.id join windows w on r.window=w.id " + 
				"join roomarea rm on r.area=rm.id   " + 
				"join roomtitle rt on r.`describe`=rt.id " + 
				"join locals l on rt.`local`=l.localid and rt.`level`=rl.id  " + 
				"left join images i on r.images=i.id left join preview p on i.id=p.imgesid left join facilities f on  " + 
				"r.facilities=f.id left join room_easy re on f.facilitate=re.easyid  " + 
				"left join easy e on re.easyid=e.id left join room_media rmd on f.media=rmd.facilitiesid  " + 
				"left join media m on rmd.mediaid=m.id left join room_hotel_local rhl on r.hotel_local=rhl.room_local  " + 
				"left join hotel_locals hl on rhl.hotel_local=hl.id where r.id like  CONCAT('%', ?, '%') ";
		List<Rooms> rooms = getAll(sql, roomid);
		for (Rooms room : rooms) {
			setAllAttribute(room);
		}
		return rooms;
	}
	
	//多表删除
	public void deleteRoom(String roomid) throws SQLException {
		String sql="delete rooms,roomarea,roomtitle,images,preview,facilities,room_easy,room_media,room_hotel_local  " + 
				"from rooms join roomlevel on rooms.`level`=roomlevel.id  " + 
				"join bed  on rooms.bed=bed.id join roomarea on rooms.area=roomarea.id " + 
				"join roomtitle on rooms.`describe`=roomtitle.id join locals on  roomtitle.`local`=locals.localid and roomtitle.`level`=roomlevel.id    " + 
				"left join images on rooms.images=images.id left join preview on  images.id=preview.imgesid left join facilities  " + 
				"on  rooms.facilities=facilities.id  left join room_easy on facilities.facilitate=room_easy.easyid  left join easy   " + 
				"on room_easy.easyid=easy.id left join room_media  on facilities.media=room_media.facilitiesid  left join media " + 
				"on room_media.mediaid=media.id left join room_hotel_local  on rooms.hotel_local=room_hotel_local.room_local  left join hotel_locals   " + 
				"on room_hotel_local.hotel_local=hotel_locals.id where rooms.id=?";
		deteleAll(sql, roomid);
	}
	
}
