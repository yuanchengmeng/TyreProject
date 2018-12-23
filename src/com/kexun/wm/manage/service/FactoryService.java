package com.kexun.wm.manage.service;

import java.util.List;

import com.kexun.wm.manage.bean.Factory;

public interface FactoryService {
	public int saveFactory(Factory factory) throws Exception;

	public Factory getFactoryById(int id) throws Exception;

	public Factory getFactoryByName(String name) throws Exception;

	public int deleteFactory(int id) throws Exception;

	public int updateFactory(Factory factory) throws Exception;

	public List<Factory> queryFactory(Factory factory, int pageNo, int pageSize)
			throws Exception;

	public List<Factory> queryFactorySize(Factory factory) throws Exception;
}
