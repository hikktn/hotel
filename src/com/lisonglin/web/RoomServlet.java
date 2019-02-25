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
import com.lisonglin.service.impl.BedImpl;
import com.lisonglin.service.impl.RoomAreaImpl;
import com.lisonglin.service.impl.RoomEasyImpl;
import com.lisonglin.service.impl.RoomHotelLocalImpl;
import com.lisonglin.service.impl.EasyImpl;
import com.lisonglin.service.impl.FacilitatiesImpl;
import com.lisonglin.service.impl.HotelLocalImpl;
import com.lisonglin.service.impl.ImageImpl;
import com.lisonglin.service.impl.LocalsImpl;
import com.lisonglin.service.impl.MediaImpl;
import com.lisonglin.service.impl.RoomLevelImpl;
import com.lisonglin.service.impl.RoomTitleImpl;
import com.lisonglin.service.impl.RoomsImpl;
import com.lisonglin.utils.ProxyUtil;
import com.lisonglin.utils.UploadUtil;

@WebServlet("/room/*")
public class RoomServlet extends BaseServlet{
	
	private static final long serialVersionUID = 1L;

	protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//查询全部房间
		RoomsService rService= (RoomsService) ProxyUtil.getProxy(new RoomsImpl());
		List<Rooms> room = rService.getAllRoom();
		//查询房间级别
		RoomLevelService roomLevelService=(RoomLevelService) ProxyUtil.getProxy(new RoomLevelImpl());
		List<RoomLevel> roomLevels = roomLevelService.getRoomLevels();
		//查询床类型
		BedService bService= (BedService) ProxyUtil.getProxy(new BedImpl());
		List<Bed> beds = bService.getBeds();
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
		req.setAttribute("rooms", room);
		req.setAttribute("roomlevels", roomLevels);
		req.setAttribute("beds", beds);
		req.setAttribute("area", roomArea);
		req.setAttribute("easy", roomEasies);
		req.setAttribute("medias", medias);
		req.setAttribute("hotelLocal", hotelLocal);
		req.setAttribute("locals", locals);
//		req.getRequestDispatcher("/admin/administration.jsp").forward(req, resp);
		req.getRequestDispatcher("/admin/backstage2.jsp").forward(req, resp);
	}
	
	@SuppressWarnings("unlikely-arg-type")
	protected void addRoom(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("utf-8");
//		getAll(req,resp);
//		req.getRequestDispatcher("/admin/add.jsp").forward(req, resp);
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
		String room="",level="",windows="",window="",bed="",area="",imgs="",oldimg="";
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
							try {
								roomEasyService.addEasy(facilite+1, Integer.parseInt(easy));
							} catch (Exception e) {
								throw new RuntimeException("其他异常");
							}
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
							try {
								mediaService.addMedias(facilite+1, Integer.parseInt(medias));
							} catch (Exception e) {
								throw new RuntimeException("其他异常");
							}
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
							try {
								roomHotelLocalService.addRoomHotelLocal(roomHotelLocal+1, Integer.parseInt(hotellocal));
							} catch (Exception e) {
								throw new RuntimeException("其他异常");
							}
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
					try {
						imageService.addIamges(iamges+1,"", imgs, oldimg);
					} catch (Exception e) {
						throw new RuntimeException("其他异常");
					}
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
		try {
			fService.addFacilite(facilite+1, facilite+1);
		} catch (Exception e) {
			throw new RuntimeException("其他异常");
		}
		//查询最大的标题号
		int roomTitle = roomTitleService.getRoomTitle();
		//增加房间标题（roomtitle）
		try {
			roomTitleService.addRoomTitle(Integer.parseInt(local), Integer.parseInt(roomlevel), roomTitle);
		} catch (Exception e1) {
			throw new RuntimeException("其他异常");
		}
		System.out.println(""+String.valueOf(upload.get(0)));
		//增加房间封面
		if(String.valueOf(upload.get(0)).equals("")) {
			System.out.println("imgno");
			return;
		}else {
			System.out.println("imgok");
		}
		try {
			imageService.addImages(iamges+1,newimg+"/"+String.valueOf(upload.get(0)), Integer.parseInt(room), String.valueOf(upload.get(0)));
		} catch (Exception e1) {
			throw new RuntimeException("其他异常");
		}
		//封面
		//图片的绝对路径
		//增加面积
		if(area!=null) {
			try {
//				roomAreaService.addRoomArea(Integer.parseInt(area));
			} catch (Exception e) {
				throw new RuntimeException("其他异常");
			}
		}
		
		//查询增加面积的对应id
		int roomArea = roomAreaService.getRoomAreas();
		System.out.println("window:"+window);
		if(window.equals("0")) {
			windows=window.replace(window, "有窗");
			System.out.println("abc");
		}else if(window.equals("1")) {
			windows=window.replace(window, "无窗");
			System.out.println("def");
		}
		System.out.println(windows+"123");
		int faciliteid = fService.getFaciliteid();
		//增加房间
		try {
			rService.addRoom(Integer.parseInt(room), Integer.parseInt(level),Integer.parseInt(windows), 
				roomArea, Integer.parseInt(bed), Integer.parseInt(price), roomTitle+1, iamges+1, faciliteid, roomHotelLocal+1);
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
	
	protected void getAllJSON(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
