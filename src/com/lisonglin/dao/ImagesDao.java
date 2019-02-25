package com.lisonglin.dao;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.daomain.Images;
import com.lisonglin.daomain.Rooms;

public class ImagesDao extends BaseDao<Images>{

	public List<Images> getImages(Rooms room)  throws SQLException{
		String sql="select i.id,i.imagepath,i.roomid,i.publics,i.oldimg  " + 
				"from rooms r " + 
				"join images i " + 
				"on r.images=i.id and r.id=i.roomid " + 
				"where r.id=?";
		List<Images> images = getAll(sql,room.getId());
		return images;
	}

	//在需要判断时查询图片md5值
	public Images getImagesMd5(Rooms room) throws SQLException{
		String sql="select e.id,e.img_md5 " + 
				"from rooms r " + 
				"join images i " + 
				"on r.images=i.id " + 
				"join encryption e " + 
				"on i.id=e.id " + 
				"where i.id=? ";
		Images images = get(sql, room.getImages());
		return images;
	}
	
	public void addIamge(int id, String imagepath,int roomid,String oldimg) throws SQLException {
		String sql="insert into images(id,imagepath,roomid,publics,oldimg) values(?,?,?,'是',?)";
		addAll(sql, id,imagepath,roomid,oldimg);
	}

	public void addIamges(int imgesid,String newimg, String imgpath, String oldimg) throws SQLException {
		String sql="insert into preview(id,imgesid,newimg,imgpath,oldimg) VALUES(null,?,?,?,?)";
		addAll(sql, imgesid,newimg,imgpath,oldimg);
	}
	
	public int getIamge() throws SQLException {
		String sql="select max(r.images) " + 
				"from rooms r " + 
				"join images i " + 
				"on r.images=i.id";
		return (int) getValue(sql);
	}

	public String getIamgePath(String oldimg) throws SQLException {
		String sql="select i.oldimg from images i where i.id=?"; 
		return String.valueOf(getValue(sql, oldimg));
	}
	
}
