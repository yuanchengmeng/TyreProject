package com.kexun.wm.manage.service.impl;

import java.util.List;

import com.kexun.wm.manage.bean.Factory;
import com.kexun.wm.manage.dao.FactoryDao;
import com.kexun.wm.manage.dao.impl.FactoryDaoImpl;
import com.kexun.wm.manage.service.FactoryService;

public class FactoryServiceImpl implements FactoryService {
	private FactoryDao dao = new FactoryDaoImpl();

	public int saveFactory(Factory factory) throws Exception {
		return dao.saveFactory(factory);
	}

	public Factory getFactoryById(int id) throws Exception {
		return dao.getFactoryById(id);
	}

	public Factory getFactoryByName(String name) throws Exception {
		return dao.getFactoryByName(name);
	}

	public int deleteFactory(int id) throws Exception {
		return dao.deleteFactory(id);
	}

	public int updateFactory(Factory factory) throws Exception {
		return dao.updateFactory(factory);
	}

	public List<Factory> queryFactory(Factory factory, int pageNo, int pageSize)
			throws Exception {
		return dao.queryFactory(factory, pageNo, pageSize);
	}

	public List<Factory> queryFactorySize(Factory factory) throws Exception {
		return dao.queryFactorySize(factory);
	}

}
