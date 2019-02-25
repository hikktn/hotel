package com.lisonglin.daomain;

public class Broadbands {
	private int id;
	private String broadband;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBroadband() {
		return broadband;
	}
	public void setBroadband(String broadband) {
		this.broadband = broadband;
	}
	@Override
	public String toString() {
		return "Broadbands [id=" + id + ", broadband=" + broadband + "]";
	}
	
	
}
