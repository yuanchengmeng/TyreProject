package com.kexun.wm.manage.service;

import java.util.List;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.bean.Emp;

public interface EmpService {
	public int saveEmp(Emp emp) throws Exception;

	public int deleteEmp(int id) throws Exception;

	public int updateEmp(Emp emp) throws Exception;

	public List<Emp> queryEmp(Emp emp, int pageNo, int pageSize)
			throws Exception;

	public Emp findEmpById(int id) throws Exception;

	public int queryAllRows(Emp emp) throws Exception;

	public Emp getEmpByName(String name, Dept deptname) throws Exception;

}
