package com.lisonglin.daomain;

import java.util.Date;

public class SpecialRoom {
	private int id;
	private int roomid;
	private String agio;
	private Date intime;
	private Date outtime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRoomid() {
		return roomid;
	}

	public void setRoomid(int roomid) {
		this.roomid = roomid;
	}

	public String getAgio() {
		return agio;
	}

	public void setAgio(String agio) {
		this.agio = agio;
	}

	public Date getIntime() {
		return intime;
	}

	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public Date getOuttime() {
		return outtime;
	}

	public void setOuttime(Date outtime) {
		this.outtime = outtime;
	}

	@Override
	public String toString() {
		return "SpecialRoom [id=" + id + ", roomid=" + roomid + ", agio=" + agio + ", intime=" + intime + ", outtime="
				+ outtime + "]";
	}

}
