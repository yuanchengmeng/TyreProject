package com.kexun.wm.manage.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.bean.Emp;
import com.kexun.wm.manage.dao.EmpDao;
import com.kexun.wm.untils.HibernateUtil;

public class EmpDaoImpl implements EmpDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public int saveEmp(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.save(emp);
			session.flush();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public int deleteEmp(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Emp emp = null;
		try {
			session = sf.openSession();
			deleteUser(id);
			emp = findEmpById(id);
			session.delete(emp);
			session.flush();
			return 1;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}
	public void deleteUser(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
 		try {
			session = sf.openSession();
			String sql = "delete from sys_user where emp_id="+id;
			SQLQuery sqlQuery=session.createSQLQuery(sql);
			sqlQuery.executeUpdate();
			session.flush();
		} catch (Exception e) {
 			e.printStackTrace();
 		} finally {
			if (session != null)
				session.close();
		}
	}
	public int updateEmp(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(emp);
			session.flush();
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<Emp> queryEmp(Emp emp, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<Emp> empList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from Emp where 1=1";
			if (emp != null) {
				if (!("").equals(emp.getEname())) {
					hql = hql + " and ename like '%" + emp.getEname() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			empList = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return empList;
	}

	public Emp findEmpById(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Emp emp = null;
		try {
			session = sf.openSession();
			emp = (Emp) session.get(Emp.class, id);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return emp;
	}

	public int queryAllRows(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		int result = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from emp";
			if (emp != null) {
				if (!("").equals(emp.getEname())) {
					sql = sql + " where ename like '%" + emp.getEname() + "%'";
				}
			}
			SQLQuery query = session.createSQLQuery(sql);
			List list = query.list();
//			BigInteger count = (BigInteger) list.get(0);
//			rows = count.intValue();
			result=(Integer) list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return result;
	}

	public Emp getEmpByName(String name, Dept deptname) throws Exception {
		// TODO Auto-generated method stub
		Emp emp = null;
		Session session=null;
	try{
		session= sf.openSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Emp.class);
		/*
		 * if (name != null) { dc.add(Restrictions.eq("ename", name)); }
		 */if (name != null) {
			dc.add(Restrictions.and(Restrictions.eq("ename", name),
					Restrictions.eq("dept", deptname)));
		}
		/*
		 * if (deptname != null) { dc.add(Restrictions.eq("dept_id", deptname));
		 * }
		 */
		Criteria c = dc.getExecutableCriteria(session);
		List<Emp> list = c.list();
		if (list.size() > 0) {
			emp = list.get(0);
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		if(session!=null)
			session.close();
	}
		return emp;
	}

}
