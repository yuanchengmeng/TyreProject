package com.kexun.wm.manage.service;

import java.util.List;

import com.kexun.wm.manage.bean.Dept;

public interface DeptService {
	public int saveDept(Dept dept) throws Exception;

	public int deleteDept(int id) throws Exception;

	public int updateDept(Dept dept) throws Exception;

	public List<Dept> queryDept(Dept dept, int pageNo, int pageSize)
			throws Exception;

	public Dept findDeptById(int id) throws Exception;

	public int queryAllRows(Dept dept) throws Exception;

	public Dept getDeptByName(String name) throws Exception;
}
