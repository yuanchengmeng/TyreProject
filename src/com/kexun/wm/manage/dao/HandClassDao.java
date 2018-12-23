package com.kexun.wm.manage.dao;

import java.util.List;

import com.kexun.wm.manage.bean.HandClass;

public interface HandClassDao {

	public int saveHandClass(HandClass handClass) throws Exception;

	public HandClass getHandClassById(int id) throws Exception;

	public HandClass getHandClassByName(String name) throws Exception;

	public int deleteHandClass(int id) throws Exception;

	public int updateHandClass(HandClass handClass) throws Exception;

	public List<HandClass> queryHandClass(HandClass handClass, int pageNo, int pageSize)
			throws Exception;

	public List<HandClass> queryHandClassSize(HandClass handClass) throws Exception;
}
