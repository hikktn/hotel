package com.lisonglin.daomain;

public class HotelLocal {
	private int id;
	private String local;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@Override
	public String toString() {
		return "HotelLocal [id=" + id + ", local=" + local + "]";
	}

}
