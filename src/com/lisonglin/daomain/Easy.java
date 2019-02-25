package com.lisonglin.daomain;

public class Easy {
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
		return "Easy [id=" + id + ", facilities=" + facilities + "]";
	}

}
