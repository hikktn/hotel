package com.lisonglin.daomain;

public class Floor {
	private int id;
	private String floor;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	@Override
	public String toString() {
		return "Floor [id=" + id + ", floor=" + floor + "]";
	}

}
