package com.lisonglin.daomain;

import java.util.List;

public class RoomMedia {
	private int id;
	private int facilitiesid;//设施序号
	private List<Media> media;//媒体科技

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFacilities() {
		return facilitiesid;
	}

	public void setFacilities(int facilities) {
		this.facilitiesid = facilities;
	}

	public int getFacilitiesid() {
		return facilitiesid;
	}

	public void setFacilitiesid(int facilitiesid) {
		this.facilitiesid = facilitiesid;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	@Override
	public String toString() {
		return "RoomMedia [facilities=" + facilitiesid + ", id=" + id + ", media=" + media + "]";
	}

}
