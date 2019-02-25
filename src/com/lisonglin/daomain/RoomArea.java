package com.lisonglin.daomain;

public class RoomArea {
	private int id;
	private String area;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public RoomArea(int id) {
		super();
		this.id = id;
	}

	@Override
	public String toString() {
		return "RoomArea [id=" + id + ", area=" + area + "]";
	}

	public RoomArea() {
		super();
	}

}
