package com.lisonglin.daomain;

public class Encryption {
	private int id;
	private String img_md5;//图片md5值

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMd5() {
		return img_md5;
	}

	public void setMd5(String md5) {
		this.img_md5 = md5;
	}

	@Override
	public String toString() {
		return "Encryption [id=" + id + ", img_md5=" + img_md5 + "]";
	}

}
