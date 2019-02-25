package com.lisonglin.daomain;

public class Images {
	private int id;//序号
	private String imagepath;//图片路径
	private int roomid;//房间号
	private String publics;//是否公用
	private String oldimg;//图片原名
	
	public String getOldimg() {
		return oldimg;
	}

	public void setOldimg(String oldimg) {
		this.oldimg = oldimg;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public String getPublics() {
		return publics;
	}

	public void setPublics(String publics) {
		this.publics = publics;
	}

	@Override
	public String toString() {
		return "Images [id=" + id + ", imagepath=" + imagepath + ", roomid=" + roomid + ", publics=" + publics
				+ ", oldimg=" + oldimg + "]";
	}

}
