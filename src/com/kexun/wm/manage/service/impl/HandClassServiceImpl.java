package com.kexun.wm.manage.service.impl;

import java.util.List;

import com.kexun.wm.manage.bean.HandClass;
import com.kexun.wm.manage.dao.HandClassDao;
import com.kexun.wm.manage.dao.impl.HandClassDaoImpl;
import com.kexun.wm.manage.service.HandClassService;

public class HandClassServiceImpl implements HandClassService {
	private HandClassDao dao = new HandClassDaoImpl();

	public int saveHandClass(HandClass handClass) throws Exception {
		return dao.saveHandClass(handClass);
	}

	public HandClass getHandClassById(int id) throws Exception {
		return dao.getHandClassById(id);
	}

	public HandClass getHandClassByName(String name) throws Exception {
		return dao.getHandClassByName(name);
	}

	public int deleteHandClass(int id) throws Exception {
		return dao.deleteHandClass(id);
	}

	public int updateHandClass(HandClass handClass) throws Exception {
		return dao.updateHandClass(handClass);
	}

	public List<HandClass> queryHandClass(HandClass handClass, int pageNo, int pageSize)
			throws Exception {
		return dao.queryHandClass(handClass, pageNo, pageSize);
	}

	public List<HandClass> queryHandClassSize(HandClass handClass) throws Exception {
		return dao.queryHandClassSize(handClass);
	}

}
