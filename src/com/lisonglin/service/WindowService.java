package com.lisonglin.service;

import java.util.List;

import com.lisonglin.daomain.Rooms;
import com.lisonglin.daomain.Window;

public interface WindowService {
	public Window getWindow(Rooms room);
	public List<Window> getWindows();
	public Object checkWindow(String result);
	public boolean addWindow(String result);
	public boolean updateWindow(String result,String id);
}
