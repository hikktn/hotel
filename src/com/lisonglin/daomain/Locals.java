package com.lisonglin.daomain;

public class Locals {
	private int localid;
	private String localcontent;

	public int getLocalid() {
		return localid;
	}

	public void setLocalid(int localid) {
		this.localid = localid;
	}

	public String getLocalcontent() {
		return localcontent;
	}

	public void setLocalcontent(String localcontent) {
		this.localcontent = localcontent;
	}

	@Override
	public String toString() {
		return "Locals [localid=" + localid + ", localcontent=" + localcontent + "]";
	}

}
