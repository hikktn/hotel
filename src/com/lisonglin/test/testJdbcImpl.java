package com.lisonglin.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.lisonglin.dao.FacilitiesDao;
import com.lisonglin.daomain.Easy;
import com.lisonglin.daomain.Facilities;
import com.lisonglin.daomain.Locals;
import com.lisonglin.daomain.Media;
import com.lisonglin.daomain.RoomArea;
import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.Rooms;
import com.lisonglin.daomain.Window;
import com.lisonglin.service.BedService;
import com.lisonglin.service.EasyService;
import com.lisonglin.service.ImageService;
import com.lisonglin.service.LocalsService;
import com.lisonglin.service.MediaService;
import com.lisonglin.service.RoomAreaService;
import com.lisonglin.service.RoomHotelLocalService;
import com.lisonglin.service.RoomLevelService;
import com.lisonglin.service.RoomsService;
import com.lisonglin.service.WindowService;
import com.lisonglin.service.impl.BedImpl;
import com.lisonglin.service.impl.EasyImpl;
import com.lisonglin.service.impl.ImageImpl;
import com.lisonglin.service.impl.LocalsImpl;
import com.lisonglin.service.impl.MediaImpl;
import com.lisonglin.service.impl.RoomAreaImpl;
import com.lisonglin.service.impl.RoomHotelLocalImpl;
import com.lisonglin.service.impl.RoomLevelImpl;
import com.lisonglin.service.impl.RoomsImpl;
import com.lisonglin.service.impl.WindowImpl;
import com.lisonglin.utils.ProxyUtil;

public class testJdbcImpl {
	
	@Test
	public void testCheckBed() {
		BedService bedService=(BedService) ProxyUtil.getProxy(new BedImpl());
		Object checkBed=bedService.checkBed("2","1.8","单人床");
		System.out.println(checkBed);
	}
	
	@Test
	public void testUpdate() {
		WindowService windowService=(WindowService) ProxyUtil.getProxy(new WindowImpl());
		boolean updateWindow = windowService.updateWindow("部分有窗","1");
		System.out.println(updateWindow);
	}
	
	@Test
	public void testGetRoomLevel() {
		RoomLevelService roomLevelService=(RoomLevelService) ProxyUtil.getProxy(new RoomLevelImpl());
		Rooms rooms=new Rooms();
		rooms.setId(102);
		RoomLevel roomLevel = roomLevelService.getRoomLevel(rooms);
		System.out.println(roomLevel);
	}
	
	@Test
	public void testGetRoomEasy() {
		RoomAreaService roomsService=  (RoomAreaService) ProxyUtil.getProxy(new RoomAreaImpl());
		List<RoomArea> roomArea = roomsService.getRoomArea();
		System.out.println(roomArea);
	}
	
	@Test
	public void testGetFacilities() {
		EasyService roomEasyService=(EasyService) ProxyUtil.getProxy(new EasyImpl());
		List<Easy> roomEasies = roomEasyService.getRoomEasies();
		MediaService mediaService=(MediaService) ProxyUtil.getProxy(new MediaImpl());
		List<Media> medias = mediaService.getMedias();
		System.out.println(roomEasies);
		System.out.println(medias);
	}
	
	@Test
	public void testGetWindow() {
		WindowService windowService=(WindowService) ProxyUtil.getProxy(new WindowImpl());
		Rooms room=new Rooms();
		room.setId(102);
		Window window = windowService.getWindow(room);
		System.out.println(window);
	}
	
	@Test
	public void testGetRoom() {
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		List<Rooms> room = rService.getAllRoom();
		System.out.println(room);
	}
	
	@Test
	public void testGetLocal() {
		LocalsService lService=(LocalsService) ProxyUtil.getProxy(new LocalsImpl());
		List<Locals> locals = lService.getLocals();
		System.out.println(locals);
	}
	
	@Test
	public void testAddRoom() throws Exception {
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		rService.addRoom(123232, 1, 1, 2, 3, 125, 4, 1, 1, 1);
		System.out.println("1123");
		//房间标题（roomtitle）
		//房间照片（img_md5,preview）
		//房间设施（room_easy）
		//酒店房间标签（room_hotel_loc）
	}
	
	@Test
	public void testAddRoomsHotelLocal() throws NumberFormatException, Exception {
		RoomHotelLocalService roomHotelLocalService=(RoomHotelLocalService) ProxyUtil.getProxy(new RoomHotelLocalImpl());
		int roomHotelLocal = roomHotelLocalService.getRoomHotelLocal();
		roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, Integer.parseInt("1"));
		roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, Integer.parseInt("2"));
		roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, Integer.parseInt("3"));
		roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, Integer.parseInt("4"));
		roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, Integer.parseInt("5"));
	}
	
	@Test
	public void testAddRooms() {
		ImageService imageService=(ImageService) ProxyUtil.getProxy(new ImageImpl());
		try {
			imageService.addImages(0, "/2.jpg", 105, "1.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetHotelLocal() throws SQLException {
		Rooms room=new Rooms();
		room.setId(101);
		Facilities facilities=new FacilitiesDao().getFacilities(room);
		System.out.println(facilities);
	}
	
	@Test
	public void testAddRoomArea() {
		RoomAreaService roomAreaService=(RoomAreaService) ProxyUtil.getProxy(new RoomAreaImpl());
//		roomAreaService.addRoomArea(12);
		int roomArea = roomAreaService.getRoomAreas();
		System.out.println(roomArea);
	}
	
	@Test
	public void testAddRoomsLocal() throws Exception {
		RoomHotelLocalService roomHotelLocalService=(RoomHotelLocalService) ProxyUtil.getProxy(new RoomHotelLocalImpl());
		int roomHotelLocal = roomHotelLocalService.getRoomHotelLocal();
		roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, 1);
		System.out.println(roomHotelLocal);
	}
	
	@Test
	public void testAddRoomWindow() {
		String window="1";
		if(window=="0") {
			window=window.replace(window, "有窗");
		}else if(window=="1") {
			window=window.replace(window, "无窗");
		}
		System.out.println(window);
	}
	
	@Test
	public void testGetAllRoom() {
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		List<Rooms> room = rService.getAllRoom();
		System.out.println(room);
	}
	
	@Test
	public void testGetLikeRoom() {
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		List<Rooms> likeRoom = rService.getLikeRoom("12334");
		System.out.println(likeRoom);
	}
	
	@Test
	public void testGetRoomAreaid() {
		RoomAreaService roomAreaService=(RoomAreaService) ProxyUtil.getProxy(new RoomAreaImpl());
		int roomArea = roomAreaService.getRoomAreas();
		System.out.println(roomArea);
	}
	
	@Test
	public void testGetRoomid() {
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		Object id = rService.checkRoomId("102");
		System.out.println(id);
	}
	
	@Test
	public void testsql() {
		String sql="select f.id,f.service " + 
				"from rooms r " + 
				"join facilities f " + 
				"on r.facilities=f.id " + 
				"join room_easy re " + 
				"on f.facilitate=re.facilitiesid " + 
				"where r.id=?";
		System.out.println(sql);
	}
}
