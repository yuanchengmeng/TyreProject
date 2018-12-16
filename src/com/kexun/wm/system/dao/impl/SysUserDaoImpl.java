package com.kexun.wm.system.dao.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.kexun.wm.store.bean.HUser;
import com.kexun.wm.system.bean.SysUser;
import com.kexun.wm.system.dao.SysUserDao;
import com.kexun.wm.untils.HibernateUtil;

public class SysUserDaoImpl implements SysUserDao {
	private static SessionFactory fy = HibernateUtil.getSessionFactory();

	public SysUser querySysUser(String jobNo, String password) throws Exception {
		SysUser user = null;
		Session session=null;
	try{
		session= fy.openSession();
		String hql = "from SysUser where jobNo='"+jobNo+"' and password='"+password+"'";
		Query query = session.createQuery(hql);
		List<SysUser> list = query.list();
		if (list.size()>0) {
			user = list.get(0);
		}
		else{
			HttpServletRequest request = ServletActionContext.getRequest();
			user=(SysUser)request.getSession().getAttribute("u");
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		if(session!=null)
			session.close();
	}
		return user;
	}

	public SysUser findByJobNo(String name) throws Exception {
		Session session = null;
		Transaction tx = null;
		SysUser sysUser = null;
		try {
			session = fy.openSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("from SysUser as s where s.jobNo = '" + name
							+ "'");
			List<SysUser> list = query.list();
			if (list.size() > 0) {
				sysUser = list.get(0);
			} else {
				sysUser = null;
			}
			tx.commit();
			return sysUser;
		} catch (HibernateException hi) {
			hi.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw new Exception("Ѱ�ҿͻ�ʧ�ܣ�", hi);
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public SysUser findByName(String name) throws Exception {
		Session session = null;
		Transaction tx = null;
		SysUser sysUser = null;
		try {
			session = fy.openSession();
			tx = session.beginTransaction();
			Query query = session
					.createQuery("from SysUser as s where s.name = '" + name
							+ "'");
			List<SysUser> list = query.list();
			if (list.size() > 0) {
				sysUser = list.get(0);
			} else {
				sysUser = null;
			}
			tx.commit();
			return sysUser;
		} catch (HibernateException hi) {
			hi.printStackTrace();
			if (tx != null)
				tx.rollback();
			throw new Exception("Ѱ�ҿͻ�ʧ�ܣ�", hi);
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void saveSysUser(SysUser sysUser) throws Exception {
		Session session = null;
		try {
			session = fy.openSession();
			session.save(sysUser);
			session.flush();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<SysUser> findSysUsers(SysUser sysUser, int offset, int length)
			throws Exception {
		Session session = null;
		List<SysUser> sysUserList = null;
		try {
			session = fy.openSession();
			String hql = "from SysUser where 1=1 ";
			if (sysUser != null) {
				if (!("").equals(sysUser.getName())) {
					hql = hql + " and name like '%" + sysUser.getName() + "%'";
				}
			}
           hql=hql+" order by id";
			Query query = session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(length);
			sysUserList = query.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysUserList;
	}

	public SysUser getSysUserById(int id) throws Exception {
		Session session = null;
		SysUser sysUser = null;
		try {
			session = fy.openSession();
			sysUser = (SysUser) session.get(SysUser.class, id);
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysUser;
	}

	public void updateSysUser(SysUser sysUser) throws Exception {
		Session session = null;
		try {
			session = fy.openSession();
			session.update(sysUser);
			session.flush();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteSysUser(int[] id) throws Exception {
		Session session = null;
		SysUser sysUser = null;
		try {
			session = fy.openSession();
			for(int i=0;i<id.length;i++){
				sysUser=getSysUserById(id[i]);
				session.delete(sysUser);
			}
 			session.flush();
 		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public int getAllRowCount(SysUser sysUser) throws Exception {
		Session session = null;
		int rows = 0;
		try {
			session = fy.openSession();
			String hql = "select count(*) from sys_user";
			if (sysUser != null) {
				if (!("").equals(sysUser.getName())) {
					hql = hql + "  where name like '%" + sysUser.getName() + "%'";
				}
			}
			SQLQuery query = session.createSQLQuery(hql);
			List list = query.list();
//			BigInteger count = (BigInteger) list.get(0);
			rows = (Integer) list.get(0);
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return rows;
	}

	public List<SysUser> querySysUserList(SysUser sysUser) throws Exception {
		Session session = null;
		List<SysUser> sysUserList = null;
		try {
			session = fy.openSession();
			String hql = "from SysUser where 1=1 order by id desc";
		    Query q = session.createQuery(hql);
			sysUserList = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysUserList;
	}
}