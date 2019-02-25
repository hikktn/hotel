package com.lisonglin.service.impl;

import com.lisonglin.dao.ImagesDao;
import com.lisonglin.service.ImageService;

public class ImageImpl implements ImageService{

	@Override
	public void addImages(int id,String imagepath,int roomid,String oldimg) {
		try {
			new ImagesDao().addIamge(id,imagepath, roomid, oldimg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public void addIamges(int imgesid ,String newimg, String imgpath, String oldimg) {
		try {
			new ImagesDao().addIamges(imgesid,newimg,imgpath,oldimg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public int getIamges() {
		try {
			return new ImagesDao().getIamge();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

	@Override
	public String getIamgesPath(String oldimg) {
		try {
			return new ImagesDao().getIamgePath(oldimg);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}
	
	

}
