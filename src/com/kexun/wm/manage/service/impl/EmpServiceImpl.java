package com.kexun.wm.manage.service.impl;

import java.util.List;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.bean.Emp;
import com.kexun.wm.manage.dao.EmpDao;
import com.kexun.wm.manage.dao.impl.EmpDaoImpl;
import com.kexun.wm.manage.service.EmpService;

public class EmpServiceImpl implements EmpService {
	private EmpDao empDao = new EmpDaoImpl();

	public int saveEmp(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return empDao.saveEmp(emp);
	}

	public int deleteEmp(int id) throws Exception {
		// TODO Auto-generated method stub
		return empDao.deleteEmp(id);
	}

	public int updateEmp(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return empDao.updateEmp(emp);
	}

	public List<Emp> queryEmp(Emp emp, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		return empDao.queryEmp(emp, pageNo, pageSize);
	}

	public Emp findEmpById(int id) throws Exception {
		// TODO Auto-generated method stub
		return empDao.findEmpById(id);
	}

	public int queryAllRows(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return empDao.queryAllRows(emp);
	}

	public Emp getEmpByName(String name, Dept deptname) throws Exception {
		// TODO Auto-generated method stub
		return empDao.getEmpByName(name,deptname);
	}

}
