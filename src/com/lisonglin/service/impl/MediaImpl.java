package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.MediaDao;
import com.lisonglin.daomain.Media;
import com.lisonglin.service.MediaService;

public class MediaImpl implements MediaService {

	@Override
	public List<Media> getMedias() {
		try {
			return new MediaDao().getMedias();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public void addMedias(int facilitiesid, int mediaid) {
		try {
			new MediaDao().addMedia(facilitiesid, mediaid);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public Object checkMedia(String result) {
		try {
			return new MediaDao().checkMedia(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean addMedias(String result) {
		try {
			return new MediaDao().addMedia(result);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public boolean updateMedias(String media, String mediaid) {
		try {
			return new MediaDao().updateMedia(media,mediaid);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
