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
import com.kexun.wm.manage.dao.DeptDao;
import com.kexun.wm.untils.HibernateUtil;

public class DeptDaoImpl implements DeptDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	public int saveDept(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.save(dept);
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

	public int deleteDept(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Dept dept = null;
		try {
			session = sf.openSession();
			deleteEmp(id);
			dept = findDeptById(id);
			session.delete(dept);
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
	
	public void deleteEmp(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<Emp> empList = null;
  		try {
  			empList=queryEmp(id);
  			for(int i=0;i<empList.size();i++){
  				deleteUser(empList.get(i).getId());
  			}
 			
			session = sf.openSession();
			String sql = "delete from emp where dept_id="+id;
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
	public List<Emp> queryEmp(int id) throws Exception {
		// TODO Auto-generated method stub
		List<Emp> empList = null;
		Session session = null;
 		try {
			session = sf.openSession();
			String hql = "from Emp where dept_id="+id;
			Query query = session.createQuery(hql);
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

	public int updateDept(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(dept);
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

	public List<Dept> queryDept(Dept dept, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		 List<Dept> deptList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from Dept where 1=1";
			if (dept != null) {
				if (!("").equals(dept.getDeptname())) {
					hql = hql + " and deptname like '%" + dept.getDeptname() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			deptList = query.list();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return deptList;
	}

	public Dept findDeptById(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Dept dept = null;
		try {
			session = sf.openSession();
			dept = (Dept) session.get(Dept.class, id);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return dept;
	}

	public int queryAllRows(Dept dept) throws Exception {
		// TODO Auto-generated method stub
		int result=0;
		Session session=null;
		try{
			session=sf.openSession();
			String sql="select count(*) from dept";
			if(dept!=null){
				if(!("").equals(dept.getDeptname())){
					sql=sql+" where deptname like '%"+dept.getDeptname()+"%'";
				}
			}
			SQLQuery query=session.createSQLQuery(sql);
			List list = query.list();
//			BigInteger count = (BigInteger) list.get(0);
//			rows = count.intValue();
			result=(Integer) list.get(0);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return result;
	}

	public Dept getDeptByName(String name) throws Exception {
		// TODO Auto-generated method stub
		Dept dept=null;
		Session session=null;
		try{
		session=sf.openSession();
		DetachedCriteria dc = DetachedCriteria.forClass(Dept.class);
	
		if (name != null) {
			dc.add(Restrictions.eq("deptname", name));
		}
		Criteria c = dc.getExecutableCriteria(session);
		List<Dept> list = c.list();
		if (list.size() > 0) {
			dept = list.get(0);
		}
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return dept;
	}

}
