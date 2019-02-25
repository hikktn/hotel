package com.lisonglin.daomain;

public class Window {
	private int id;
	private String window;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWindow() {
		return window;
	}

	public void setWindow(String window) {
		this.window = window;
	}

	@Override
	public String toString() {
		return "Window [id=" + id + ", window=" + window + "]";
	}

}
