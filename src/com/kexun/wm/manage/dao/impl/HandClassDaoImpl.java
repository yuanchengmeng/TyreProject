/**
 * 
 */
package com.kexun.wm.manage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.manage.bean.HandClass;
import com.kexun.wm.manage.dao.HandClassDao;
import com.kexun.wm.untils.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class HandClassDaoImpl implements HandClassDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public int saveHandClass(HandClass handClass) throws Exception {
		Session session = null;
		try {
			session = sf.openSession();
			session.save(handClass);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public HandClass getHandClassById(int id) throws Exception {
		// TODO Auto-generated method stub
		HandClass handClass = null;
		Session session = null;
		try {
			session = sf.openSession();
			handClass = (HandClass) session.get(HandClass.class, id);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return handClass;
	}

	public HandClass getHandClassByName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<HandClass> handClassList = null;
		HandClass handClass = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from HandClass where name='" + name + "'";
			Query query = session.createQuery(hql);
			handClassList = query.list();
			if (handClassList.size() > 0) {
				handClass = handClassList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return handClass;
	}
	public int deleteHandClass(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		HandClass handClass = null;
		try {
			session = sf.openSession();
			handClass = getHandClassById(id);
			session.delete(handClass);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}
	public int updateHandClass(HandClass handClass) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(handClass);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}
	public List<HandClass> queryHandClass(HandClass handClass, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<HandClass> handClassList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from HandClass where 1=1";
			if (handClass != null) {
				if ((!("").equals(handClass.getName()))
						&& (handClass.getName() != null)) {
					hql = hql + " and name like '%" + handClass.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			handClassList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return handClassList;
	}
	public List<HandClass> queryHandClassSize(HandClass handClass) throws Exception {
		// TODO Auto-generated method stub
		List<HandClass> handClassList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from HandClass where 1=1";
			if (handClass != null) {
				if ((!("").equals(handClass.getName()))
						&& (handClass.getName() != null)) {
					hql = hql + " and name like '%" + handClass.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			handClassList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return handClassList;
	}
}
