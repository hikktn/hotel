package com.lisonglin.daomain;

public class Media {
	private int id;
	private String facilities;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	@Override
	public String toString() {
		return "Media [id=" + id + ", facilities=" + facilities + "]";
	}

}
