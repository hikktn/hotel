package com.lisonglin.service;

public interface ImageService {
	//增加封面
	public void addImages(int id,String imagepath,int roomid,String oldimg) throws Exception;
	//增加房间样式图片
	public void addIamges(int imgesid,String newimg,String imgpath,String oldimg) throws Exception;
	public int getIamges();
	public String getIamgesPath(String oldimg);
}
