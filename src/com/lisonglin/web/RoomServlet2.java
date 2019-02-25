package com.lisonglin.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lisonglin.daomain.Bed;
import com.lisonglin.daomain.Easy;
import com.lisonglin.daomain.HotelLocal;
import com.lisonglin.daomain.Locals;
import com.lisonglin.daomain.Media;
import com.lisonglin.daomain.RoomArea;
import com.lisonglin.daomain.RoomLevel;
import com.lisonglin.daomain.Rooms;
import com.lisonglin.daomain.Window;
import com.lisonglin.service.BedService;
import com.lisonglin.service.EasyService;
import com.lisonglin.service.FacilitiesService;
import com.lisonglin.service.HotelLocalService;
import com.lisonglin.service.ImageService;
import com.lisonglin.service.LocalsService;
import com.lisonglin.service.MediaService;
import com.lisonglin.service.RoomAreaService;
import com.lisonglin.service.RoomEasyService;
import com.lisonglin.service.RoomHotelLocalService;
import com.lisonglin.service.RoomLevelService;
import com.lisonglin.service.RoomTitleService;
import com.lisonglin.service.RoomsService;
import com.lisonglin.service.WindowService;
import com.lisonglin.service.impl.BedImpl;
import com.lisonglin.service.impl.EasyImpl;
import com.lisonglin.service.impl.FacilitatiesImpl;
import com.lisonglin.service.impl.HotelLocalImpl;
import com.lisonglin.service.impl.ImageImpl;
import com.lisonglin.service.impl.LocalsImpl;
import com.lisonglin.service.impl.MediaImpl;
import com.lisonglin.service.impl.RoomAreaImpl;
import com.lisonglin.service.impl.RoomEasyImpl;
import com.lisonglin.service.impl.RoomHotelLocalImpl;
import com.lisonglin.service.impl.RoomLevelImpl;
import com.lisonglin.service.impl.RoomTitleImpl;
import com.lisonglin.service.impl.RoomsImpl;
import com.lisonglin.service.impl.WindowImpl;
import com.lisonglin.utils.DataUtil;
import com.lisonglin.utils.ProxyUtil;
import com.lisonglin.utils.UploadUtil;

@WebServlet("/rooms/*")
public class RoomServlet2 extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询全部房间
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		List<Rooms> room = rService.getAllRoom();
		req.setAttribute("rooms", room);
		req.getRequestDispatcher("/admin/administration.jsp").forward(req, resp);
	}
	
	protected void getAddRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询房间级别
		RoomLevelService roomLevelService=(RoomLevelService) ProxyUtil.getProxy(new RoomLevelImpl());
		List<RoomLevel> roomLevels = roomLevelService.getRoomLevels();
		//查询床类型
		BedService bService= (BedService) ProxyUtil.getProxy(new BedImpl());
		List<Bed> beds = bService.getBeds();
		//查询窗类型
		WindowService windowService=(WindowService) ProxyUtil.getProxy(new WindowImpl());
		List<Window> windows=windowService.getWindows();
		//查询房间面积
		RoomAreaService roomsService=  (RoomAreaService) ProxyUtil.getProxy(new RoomAreaImpl());
		List<RoomArea> roomArea = roomsService.getRoomArea();
		//查询便利设施
		EasyService roomEasyService=(EasyService) ProxyUtil.getProxy(new EasyImpl());
		List<Easy> roomEasies = roomEasyService.getRoomEasies();
		//查询媒体科技
		MediaService mediaService=(MediaService) ProxyUtil.getProxy(new MediaImpl());
		List<Media> medias = mediaService.getMedias();
		//查询酒店标签
		HotelLocalService hotelLocalService= (HotelLocalService) ProxyUtil.getProxy(new HotelLocalImpl());
		List<HotelLocal> hotelLocal = hotelLocalService.getHotelLocal();
		//查询标题标签
		LocalsService lService=(LocalsService) ProxyUtil.getProxy(new LocalsImpl());
		List<Locals> locals = lService.getLocals();
		req.setAttribute("roomlevels", roomLevels);
		req.setAttribute("beds", beds);
		req.setAttribute("windows", windows);
		req.setAttribute("area", roomArea);
		req.setAttribute("easy", roomEasies);
		req.setAttribute("medias", medias);
		req.setAttribute("hotelLocal", hotelLocal);
		req.setAttribute("locals", locals);
		req.getRequestDispatcher("/admin/add.jsp").forward(req, resp);
	}
	@SuppressWarnings("unlikely-arg-type")
	protected void addRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		//上传文件
		UploadUtil uploadUtil=new UploadUtil();
		List upload =  uploadUtil.upload(req);
		//增加房间（rooms）
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		ImageService imageService=(ImageService) ProxyUtil.getProxy(new ImageImpl());
		RoomTitleService roomTitleService= (RoomTitleService) ProxyUtil.getProxy(new RoomTitleImpl());
		RoomEasyService roomEasyService=(RoomEasyService) ProxyUtil.getProxy(new RoomEasyImpl());
		FacilitiesService fService=(FacilitiesService) ProxyUtil.getProxy(new FacilitatiesImpl());
		MediaService mediaService=(MediaService) ProxyUtil.getProxy(new MediaImpl());
		RoomHotelLocalService roomHotelLocalService=(RoomHotelLocalService) ProxyUtil.getProxy(new RoomHotelLocalImpl());
		RoomAreaService roomAreaService=(RoomAreaService) ProxyUtil.getProxy(new RoomAreaImpl());
		//查询最大的设施号
		int facilite = fService.getFacilite();
		//查询最大的标签号
		int roomHotelLocal = roomHotelLocalService.getRoomHotelLocal();
		//查询最大的照片号
		int iamges = imageService.getIamges();
		String easy = null,medias = null,hotellocal = null,price="",newimg="",local="",roomlevel="";
		String room="",level="",window="",bed="",area="",imgs="",oldimg="";
		//查询增加面积的对应id
		int roomArea = roomAreaService.getRoomAreas();
		int faciliteid = fService.getFaciliteid();
		//查询最大的标题号
		int roomTitle = roomTitleService.getRoomTitle();
		try {
		for(int i=0;i<upload.size();i++) {
			//各类相应的数据
			String rooms= String.valueOf(upload.get(i));
			System.out.println("rooms:"+rooms);
			if(rooms.contains("&")) {
				System.out.println(rooms.contains("&"));
				String[] arr = rooms.split("&");
				//房间号
				room = (arr[0]+"").replaceAll("[^0-9]", "");
				//标题
				local=(arr[1]+"").replaceAll("[^0-9]", "");
				roomlevel=(arr[2]+"").replaceAll("[^0-9]", "");
				//级别
				level=(arr[3]+"").replaceAll("[^0-9]", "");
				//窗
				window=(arr[4]+"").replaceAll("[^0-9]", "");
				//床
				bed=(arr[5]+"").replaceAll("[^0-9]", "");
				//面积
				area=(arr[6]+"").replaceAll("[^0-9]", "");
				for(int j = 0; j < arr.length;j++){
					System.out.println("arr:"+arr[j]);
					//设施(便利设施)
					if(rooms.contains("easy")) {
						if((arr[j]+"").contains("easy")) {
							easy=(arr[j]+"").replaceAll("[^0-9]","");
							System.out.println("easy:"+easy);
							//增加房间设施（room_easy）
							roomEasyService.addEasy(facilite+1, Integer.parseInt(easy));
						}
					}else {
						System.out.println("easyno");
						resp.getWriter().write("no");
						return;
					}
					//媒体科技
					if(rooms.contains("medias")) {
						if((arr[j]+"").contains("easy")) {
							medias=(arr[j]+"").replaceAll("[^0-9]", "");
							System.out.println("medias:"+medias);
							mediaService.addMedias(facilite+1, Integer.parseInt(medias));
						}
					}else {
						System.out.println("no");
						resp.getWriter().write("no");
						return;
					}
					//标签
					if(rooms.contains("hotellocal")) {
						if((arr[j]+"").contains("easy")) {
							//增加酒店房间标签（room_hotel_loc）
							hotellocal=(arr[j]+"").replaceAll("[^0-9]", "");
							System.out.println("hotellocal:"+(roomHotelLocal+1));
							roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, Integer.parseInt(hotellocal));
						}
					}else {
						System.out.println("hotelno");
						resp.getWriter().write("no");
						return;
					}
					//价格
					if((arr[j]+"").contains("price")) {
						price=(arr[j]+"").replaceAll("[^0-9]", "");
					}
				}
				//增加房间
				System.out.println("room:"+room+",level:"+level+",window:"+window+",rooomArea:"+roomArea+",bed:"+bed+",price:"+price+",roomTitle:"+roomTitle+",images:"+iamges+",faciliteid:"+faciliteid+",roomHotellocal:"+roomHotelLocal);
				rService.addRoom(Integer.parseInt(room), Integer.parseInt(level),Integer.parseInt(window) , 
						roomArea+1, Integer.parseInt(bed), Integer.parseInt(price), roomTitle+1, iamges+1, faciliteid, roomHotelLocal+1);
				System.out.println(room+","+local+","+roomlevel+","+level+","+window+","+bed+","+area+","+easy+","+medias+","+hotellocal+","+price);
			}
			imgs =String.valueOf(upload.get(i));
			System.out.println("imgs:"+imgs);
			if(String.valueOf(upload.get(0))!=null) {
				if(imgs.contains("D:\\apache")) {
					//直接截取后面的文件名
					oldimg = imgs.substring(imgs.lastIndexOf("/")+1,imgs.length());
					System.out.println("imgok");
					//增加房间照片（img_md5,preview）
					imageService.addIamges(iamges+1,"", imgs, oldimg);
					newimg=imgs.substring(0,imgs.lastIndexOf("/"));
					System.out.println("room:"+room+"oldimg:"+oldimg);
					//照片
				}
			}else {
				System.out.println("imgno");
				return;
			}
		}
		//最后添加设施关联表
		fService.addFacilite(facilite+1, facilite+1);
		//增加房间标题（roomtitle）
		roomTitleService.addRoomTitle(roomTitle+1,Integer.parseInt(local), Integer.parseInt(roomlevel));
		System.out.println(""+String.valueOf(upload.get(0)));
		//增加房间封面
		if(String.valueOf(upload.get(0)).equals("")) {
			System.out.println("imgno");
			return;
		}else {
			System.out.println("imgok");
		}
		imageService.addImages(iamges+1,newimg+"/"+String.valueOf(upload.get(0)), Integer.parseInt(room), String.valueOf(upload.get(0)));
		//封面
		//图片的绝对路径
		//增加面积
		if(area!=null) {
			roomAreaService.addRoomArea(roomArea+1,Integer.parseInt(area));
		}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("其他异常");
		}
		//重定向
//		resp.sendRedirect("/hotelSystem/room/getAll");
		System.out.println("封面："+upload.get(0));
		System.out.println("upload:"+upload);	
		if(room!=null&&level!=null&&bed!=null) {
			System.out.println("ok");
		}else {
			System.out.println("no");
		}
		//上面执行成功后，返回前台成功
		resp.getWriter().write(room!=null?"ok":"no");
	}
	
	//后台验证房间号
	protected void checkRoomId(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//根据url传过来的参数
		String roomid = req.getParameter("roomid");
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		Object id = rService.checkRoomId(roomid);
		resp.getWriter().write(id==null?"success":"error");
	}
	
	//查询预览图片
	protected void getIamges(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//根据封面id
		String oldimg = req.getParameter("oldimg");
		ImageService imageService=(ImageService) ProxyUtil.getProxy(new ImageImpl());
		String imgpath=imageService.getIamgesPath(oldimg);
		System.out.println("imgpath:"+imgpath);
		req.setAttribute("imgpath", imgpath);
		req.getRequestDispatcher("/admin/img.jsp").forward(req, resp);
	}
	
	//搜索框输入的内容
	protected void checkRoomData(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
		String roomid = req.getParameter("data");
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		if(roomid.equals("")||!DataUtil.isInteger(roomid)) {
			System.out.println("null");
			resp.getWriter().write("null");
		}else {
			resp.getWriter().write("success");
			List<Rooms> likeRoom = rService.getLikeRoom(roomid);
			req.setAttribute("rooms", likeRoom);
			req.getRequestDispatcher("/admin/administration.jsp").forward(req, resp);
		}
		System.out.println("roomid:"+roomid);
	}
	
	//删除选中的房间
	protected void deleteRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		System.out.println("id:"+id);
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		try {
			boolean deleteRoom = rService.deleteRoom(id);
			System.out.println(deleteRoom);
			if(deleteRoom) {
				resp.getWriter().write("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("其他异常");
		}
	}
	
	//查询窗户和床
	protected void bedorwindow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		WindowService windowService=(WindowService) ProxyUtil.getProxy(new WindowImpl());
		List<Window> windows = windowService.getWindows();
		BedService bedService=(BedService) ProxyUtil.getProxy(new BedImpl());
		List<Bed> beds = bedService.getBeds();
		req.setAttribute("windows", windows);
		req.setAttribute("beds", beds);
		req.getRequestDispatcher("/admin/bedorwindow.jsp").forward(req, resp);
	}
	
	//验证窗户和床
	protected void checkbedorwindow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = req.getParameter("result");
		if(result!=null) {
			WindowService windowService=(WindowService) ProxyUtil.getProxy(new WindowImpl());
			Object checkWindow = windowService.checkWindow(result);
			resp.getWriter().write(checkWindow==null?"success":"error");
		}
		String result1=req.getParameter("result1");
		if(result1!=null) {
			String[] arr = result1.split(",");
			String bedNumber=arr[0];
			String bedWidth=arr[1];
			String bedBed=arr[2];
			BedService bedService=(BedService) ProxyUtil.getProxy(new BedImpl());
			Object checkBed=bedService.checkBed(bedNumber,bedWidth,bedBed);
			resp.getWriter().write(checkBed.equals("0")?"success":"error");
		}
	}
	
	//增加窗户和床
	protected void addbedorwindow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String result = req.getParameter("result");
		if(result!=null) {
			WindowService windowService=(WindowService) ProxyUtil.getProxy(new WindowImpl());
			boolean flag= windowService.addWindow(result);
			resp.getWriter().write(flag==true?"success":"error");
		}
		String bedNumStr=req.getParameter("bedNumStr");
		String bedWidthStr=req.getParameter("bedWidthStr");
		String bedNameStr=req.getParameter("bedNameStr");
		if(bedNameStr!=null&&bedNumStr!=null&&bedWidthStr!=null) {
			BedService bedService=(BedService) ProxyUtil.getProxy(new BedImpl());
			boolean flag=bedService.addBed(bedNumStr,bedWidthStr,bedNameStr);
			resp.getWriter().write(flag==true?"success":"error");
		}
	}
	
	//修改窗户和床
	protected void updatebedorwindow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String result = req.getParameter("result");
		if(id!=null&&result!=null) {
			WindowService windowService=(WindowService) ProxyUtil.getProxy(new WindowImpl());
			boolean flag=windowService.updateWindow(result,id);
			resp.getWriter().write(flag==true?"success":"error");
		}
		String bedid = req.getParameter("bedid");
		String bedNumStr=req.getParameter("bedNumStr");
		String bedWidthStr=req.getParameter("bedWidthStr");
		String bedNameStr=req.getParameter("bedNameStr");
		if(bedNameStr!=null&&bedNumStr!=null&&bedWidthStr!=null) {
			BedService bedService=(BedService) ProxyUtil.getProxy(new BedImpl());
			boolean flag=bedService.updateBed(bedNumStr,bedWidthStr,bedNameStr,bedid);
			resp.getWriter().write(flag==true?"success":"error");
		}
	}
	
	//查询设施和标签
	protected void facilitiesorlocal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MediaService mediaService=(MediaService) ProxyUtil.getProxy(new MediaImpl());
		List<Media> medias = mediaService.getMedias();
		EasyService roomEasyService=(EasyService) ProxyUtil.getProxy(new EasyImpl());
		List<Easy> roomEasies = roomEasyService.getRoomEasies();
		HotelLocalService hotelLocalService= (HotelLocalService) ProxyUtil.getProxy(new HotelLocalImpl());
		List<HotelLocal> hotelLocal = hotelLocalService.getHotelLocal();
		req.setAttribute("easy", roomEasies);
		req.setAttribute("medias", medias);
		req.setAttribute("hotelLocal", hotelLocal);
		req.getRequestDispatcher("/admin/facilitiesorlocal.jsp").forward(req, resp);
	}
	
	//增加设施
	protected void addfacilitiesorlocal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hotellocal = req.getParameter("hotellocal");
		if(hotellocal!=null) {
			HotelLocalService hotelLocalService= (HotelLocalService) ProxyUtil.getProxy(new HotelLocalImpl());
			boolean flag= hotelLocalService.addHotelLocal(hotellocal);
			resp.getWriter().write(flag==true?"success":"error");
		}
		String media = req.getParameter("media");
		if(media!=null) {
			MediaService mediaService=(MediaService) ProxyUtil.getProxy(new MediaImpl());
			boolean flag= mediaService.addMedias(media);
			resp.getWriter().write(flag==true?"success":"error");
		}
		String easy = req.getParameter("easy");
		if(easy!=null) {
			EasyService roomEasyService=(EasyService) ProxyUtil.getProxy(new EasyImpl());
			boolean flag= roomEasyService.addEasy(easy);
			resp.getWriter().write(flag==true?"success":"error");
		}
	}
	
	//修改设施
	protected void updatefacilitiesorlocal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hotellocal = req.getParameter("hotellocal");
		String hotellocalid = req.getParameter("hotellocalid");
		if(hotellocal!=null) {
			HotelLocalService hotelLocalService= (HotelLocalService) ProxyUtil.getProxy(new HotelLocalImpl());
			boolean flag= hotelLocalService.updateHotelLocal(hotellocal,hotellocalid);
			resp.getWriter().write(flag==true?"success":"error");
		}
		String media = req.getParameter("media");
		String mediaid = req.getParameter("mediaid");
		if(media!=null) {
			MediaService mediaService=(MediaService) ProxyUtil.getProxy(new MediaImpl());
			boolean flag= mediaService.updateMedias(media,mediaid);
			resp.getWriter().write(flag==true?"success":"error");
		}
		String easy = req.getParameter("easy");
		String easyid = req.getParameter("easyid");
		if(easy!=null) {
			EasyService roomEasyService=(EasyService) ProxyUtil.getProxy(new EasyImpl());
			boolean flag= roomEasyService.updateEasy(easy,easyid);
			resp.getWriter().write(flag==true?"success":"error");
		}
	}
	
	//验证设施
	protected void checkfacilitiesorlocal(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String hotellocal = req.getParameter("hotellocal");
		if(hotellocal!=null) {
			HotelLocalService hotelLocalService= (HotelLocalService) ProxyUtil.getProxy(new HotelLocalImpl());
			Object checkHotelLocal= hotelLocalService.checkHotelLocal(hotellocal);
			resp.getWriter().write(checkHotelLocal==null?"success":"error");
		}
		String media = req.getParameter("media");
		if(media!=null) {
			MediaService mediaService=(MediaService) ProxyUtil.getProxy(new MediaImpl());
			Object checkMedia= mediaService.checkMedia(media);
			resp.getWriter().write(checkMedia==null?"success":"error");
		}
		String easy = req.getParameter("easy");
		if(easy!=null) {
			EasyService roomEasyService=(EasyService) ProxyUtil.getProxy(new EasyImpl());
			Object checkEasy= roomEasyService.checkEasy(easy);
			resp.getWriter().write(checkEasy==null?"success":"error");
		}
	}
	
}
