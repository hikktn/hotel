package com.lisonglin.service;

import java.util.List;

import com.lisonglin.daomain.Media;

public interface MediaService {
	public List<Media> getMedias();
	public void addMedias(int facilitiesid,int mediaid) throws Exception;
	public Object checkMedia(String result);
	public boolean addMedias(String result);
	public boolean updateMedias(String media, String mediaid);
}
