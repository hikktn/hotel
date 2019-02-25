package com.lisonglin.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.lisonglin.dao.FacilitiesDao;
import com.lisonglin.dao.HotelLocalDao;
import com.lisonglin.dao.ImagesDao;
import com.lisonglin.dao.LocalsDao;
import com.lisonglin.dao.RoomAreaDao;
import com.lisonglin.dao.RoomDao;
import com.lisonglin.dao.RoomEasyDao;
import com.lisonglin.dao.RoomHotelLocalDao;
import com.lisonglin.dao.RoomLevelDao;
import com.lisonglin.dao.RoomMediaDao;
import com.lisonglin.dao.RoomTitleDao;
import com.lisonglin.daomain.Facilities;
import com.lisonglin.daomain.HotelLocal;
import com.lisonglin.daomain.Images;
import com.lisonglin.daomain.Locals;
import com.lisonglin.daomain.RoomArea;
import com.lisonglin.daomain.RoomEasy;
import com.lisonglin.daomain.RoomHotelLocal;
import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.RoomMedia;
import com.lisonglin.daomain.RoomTitle;
import com.lisonglin.daomain.Rooms;
import com.lisonglin.utils.JdbcUtil;

public class testJdbc {
	
	@Test
	public void test() {
		String sql="select l.localid,l.localcontent " + 
				"from rooms r " + 
				"join roomtitle rt " + 
				"on r.`describe`=rt.id " + 
				"join locals l " + 
				"on rt.`local`=l.localid ";
		System.out.println(sql);
	}
	
	@Test
	public void testGetConn() {
		System.out.println(JdbcUtil.getConnection());
	}
	
	@Test
	public void testGetAllRoom() throws SQLException {
		RoomDao rd=new RoomDao();
		List<Rooms> roomsAll = rd.getRoomsAll();
		System.out.println(roomsAll);
	}
	
	@Test
	public void testGetRoomTitle()  throws SQLException{
		RoomTitleDao ld=new RoomTitleDao();
		Rooms r=new Rooms();
		r.setId(101);
		List<RoomTitle> roomTitle = ld.getRoomTitle(r);
		System.out.println(roomTitle);
	}
	
	@Test
	public void testGetLocals()  throws SQLException{
		LocalsDao ld=new LocalsDao();
		RoomTitle rt=new RoomTitle();
		rt.setId(1);
		Locals locals = ld.getLocals(rt);
		System.out.println(locals);
	}
	
	@Test
	public void testGetRoomLevel()  throws SQLException{
		RoomLevelDao rld=new RoomLevelDao();
		Rooms r=new Rooms();
		r.setId(101);
		RoomLevel level = rld.getLevel(r);
		System.out.println(level);
	}
	
	@Test
	public void testGetRoomLevelTitle()  throws SQLException{
		RoomLevelDao rld=new RoomLevelDao();
		RoomTitle roomTitle=new RoomTitle();
		roomTitle.setId(1);
		RoomLevel levelTitle = rld.getLevelTitle(roomTitle);
		System.out.println(levelTitle);
	}
	
	@Test
	public void testGetRoomArea()  throws SQLException{
		RoomAreaDao rad=new RoomAreaDao();
		Rooms room=new Rooms();
		room.setId(101);
		RoomArea roomArea = rad.getRoomArea(room);
		System.out.println(roomArea);
	}
	
	@Test
	public void testGetImages() throws SQLException {
		ImagesDao id=new ImagesDao();
		Rooms room=new Rooms();
		room.setId(102);
		List<Images> images = id.getImages(room);
		System.out.println(images);
	}
	
	
	@Test
	public void textGetFacilities() throws SQLException {
		//RoomMedia [facilities=1, id=4, media=[
//		Media [id=1, facilities=液晶电视机],
//		Media [id=2, facilities=卫星频道], 
//		Media [id=3, facilities=电话], 
//		Media [id=4, facilities=电脑]]
		FacilitiesDao fd=new FacilitiesDao();
		Rooms room=new Rooms();
		room.setId(101);
		Facilities facilities = fd.getFacilities(room);
		System.out.println(facilities);
	}
	
	@Test
	public void testGetRoomEasy() throws SQLException {
		Rooms room=new Rooms();
		room.setId(101);
		RoomEasy roomEasy=new RoomEasyDao().getRoomEasy(null, room);
		System.out.println(roomEasy);
	}
	
	@Test
	public void testGetRoomMedia() throws SQLException {
		Rooms room=new Rooms();
		room.setId(101);
		RoomMedia roomMedia=new RoomMediaDao().getRoomMedia(null,room);
		System.out.println(roomMedia);
	}
	
	@Test
	public void testGetHotelLocal() throws SQLException {
		Rooms room=new Rooms();
		room.setId(102);
		RoomHotelLocal hotelLocals = new RoomHotelLocalDao().getHotelLocal(room);
		List<HotelLocal> hotelLocal=new HotelLocalDao().getHotelLocal(room);
		System.out.println(hotelLocals);
		System.out.println(hotelLocal);
	}
	
	@Test
	public void testGetLevels()  throws SQLException{
		List<RoomLevel> levels = new RoomLevelDao().getLevels();
		System.out.println(levels);
	}
	
}
