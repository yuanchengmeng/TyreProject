package com.kexun.wm.manage.service.impl;

import java.util.List;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.dao.DeptDao;
import com.kexun.wm.manage.dao.impl.DeptDaoImpl;
import com.kexun.wm.manage.service.DeptService;

public class DeptServiceImpl implements DeptService {
	private DeptDao deptDao = new DeptDaoImpl();

	public int saveDept(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.saveDept(dept);
	}

	public int deleteDept(int id) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.deleteDept(id);
	}

	public int updateDept(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.updateDept(dept);
	}

	public List<Dept> queryDept(Dept dept, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		return deptDao.queryDept(dept, pageNo, pageSize);
	}

	public Dept findDeptById(int id) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.findDeptById(id);
	}

	public int queryAllRows(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.queryAllRows(dept);
	}

	public Dept getDeptByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return deptDao.getDeptByName(name);
	}

}
