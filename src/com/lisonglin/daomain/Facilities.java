package com.lisonglin.daomain;

import java.util.List;

public class Facilities {
	private int id;
	private RoomEasy roomEasy;//关联便利设施
	private RoomMedia roomMedia;//关联媒体科技
	private String service;//客房设施和服务

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public RoomEasy getRoomEasy() {
		return roomEasy;
	}

	public void setRoomEasy(RoomEasy roomEasy) {
		this.roomEasy = roomEasy;
	}

	public RoomMedia getRoomMedia() {
		return roomMedia;
	}

	public void setRoomMedia(RoomMedia roomMedia) {
		this.roomMedia = roomMedia;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Facilities [id=" + id + ", roomEasy=" + roomEasy + ", roomMedia=" + roomMedia + ", service=" + service
				+ "]";
	}
	
}
