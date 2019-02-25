package com.lisonglin.daomain;

import java.util.List;

public class RoomEasy {
	private int id;
	private int facilitiesid;//设施序号
	private List<Easy> easy;//便利设施

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFacilitiesid() {
		return facilitiesid;
	}

	public void setFacilitiesid(int facilitiesid) {
		this.facilitiesid = facilitiesid;
	}
	
	public List<Easy> getEasy() {
		return easy;
	}

	public void setEasy(List<Easy> easy) {
		this.easy = easy;
	}

	@Override
	public String toString() {
		return "RoomEasy [id=" + id  + ", facilitiesid=" + facilitiesid +", easyid=" + easy+ "]";
	}

}
