package com.lisonglin.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.lisonglin.dao.LocalsDao;
import com.lisonglin.daomain.Locals;
import com.lisonglin.service.LocalsService;

public class LocalsImpl implements LocalsService {

	public List<Locals> getLocals() {
		try {
			return new LocalsDao().getLocal();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("SQL错误");
		}
	}

}
