package com.lisonglin.daomain;

import java.util.List;

public class Rooms {
	private int id;// 房间号
	private RoomLevel level;// 级别
	private Window window;// 窗户类型
	private RoomArea area;// 面积
	private Bed bed;// 床类型
	private SpecialRoom specialroom;//特价房
	private Broadbands broadband;// 宽带
	private String numberpeople;// 人数
	private double price;// 价格
	private List<RoomTitle> describe;// 描述
	private List<Images> images;// 封面
	private Facilities facilities;// 设施
	private List<Floor> floor;// 楼层
	private RoomHotelLocal roomHotelLocals;//标签
	
	public RoomHotelLocal getRoomHotelLocals() {
		return roomHotelLocals;
	}

	public void setRoomHotelLocals(RoomHotelLocal roomHotelLocals) {
		this.roomHotelLocals = roomHotelLocals;
	}

	public SpecialRoom getSpecialroom() {
		return specialroom;
	}

	public void setSpecialroom(SpecialRoom specialroom) {
		this.specialroom = specialroom;
	}

	public List<Images> getImages() {
		return images;
	}

	public void setImages(List<Images> images) {
		this.images = images;
	}

	public List<RoomTitle> getDescribe() {
		return describe;
	}

	public void setDescribe(List<RoomTitle> describe) {
		this.describe = describe;
	}

	public Facilities getFacilities() {
		return facilities;
	}

	public void setFacilities(Facilities facilities) {
		this.facilities = facilities;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoomLevel getLevel() {
		return level;
	}

	public void setLevel(RoomLevel level) {
		this.level = level;
	}

	public Window getWindow() {
		return window;
	}

	public void setWindow(Window window) {
		this.window = window;
	}

	public RoomArea getArea() {
		return area;
	}

	public void setArea(RoomArea area) {
		this.area = area;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public Broadbands getBroadband() {
		return broadband;
	}

	public void setBroadband(Broadbands broadband) {
		this.broadband = broadband;
	}

	public String getNumberpeople() {
		return numberpeople;
	}

	public void setNumberpeople(String numberpeople) {
		this.numberpeople = numberpeople;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<Floor> getFloor() {
		return floor;
	}

	public void setFloor(List<Floor> floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Rooms [id=" + id + ", level=" + level + ", window=" + window + ", area=" + area + ", bed=" + bed
				+ ", specialroom=" + specialroom + ", broadband=" + broadband + ", numberpeople=" + numberpeople
				+ ", price=" + price + ", describe=" + describe + ", images=" + images + ", facilities=" + facilities
				+ ", floor=" + floor + ", roomHotelLocals=" + roomHotelLocals + "]";
	}

	public Rooms() {
		super();
	}

	public Rooms(int id, RoomLevel level, Window window, RoomArea area, Bed bed,
			double price, List<RoomTitle> describe, List<Images> images,
			Facilities facilities, RoomHotelLocal roomHotelLocals) {
		this.id = id;
		this.level = level;
		this.window = window;
		this.area = area;
		this.bed = bed;
		this.price = price;
		this.describe = describe;
		this.images = images;
		this.facilities = facilities;
		this.roomHotelLocals = roomHotelLocals;
	}
	
}
