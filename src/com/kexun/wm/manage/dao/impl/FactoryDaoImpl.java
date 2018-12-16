/**
 * 
 */
package com.kexun.wm.manage.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.manage.bean.Factory;
import com.kexun.wm.manage.dao.FactoryDao;
import com.kexun.wm.untils.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class FactoryDaoImpl implements FactoryDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public int saveFactory(Factory factory) throws Exception {
		Session session = null;
		try {
			session = sf.openSession();
			session.save(factory);
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

	public Factory getFactoryById(int id) throws Exception {
		// TODO Auto-generated method stub
		Factory factory = null;
		Session session = null;
		try {
			session = sf.openSession();
			factory = (Factory) session.get(Factory.class, id);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return factory;
	}

	public Factory getFactoryByName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Factory> factoryList = null;
		Factory factory = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from Factory where name='" + name + "'";
			Query query = session.createQuery(hql);
			factoryList = query.list();
			if (factoryList.size() > 0) {
				factory = factoryList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return factory;
	}
	public int deleteFactory(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Factory factory = null;
		try {
			session = sf.openSession();
			factory = getFactoryById(id);
			session.delete(factory);
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
	public int updateFactory(Factory factory) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(factory);
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
	public List<Factory> queryFactory(Factory factory, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<Factory> factoryList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from Factory where 1=1";
			if (factory != null) {
				if ((!("").equals(factory.getName()))
						&& (factory.getName() != null)) {
					hql = hql + " and name like '%" + factory.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			factoryList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return factoryList;
	}
	public List<Factory> queryFactorySize(Factory factory) throws Exception {
		// TODO Auto-generated method stub
		List<Factory> factoryList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from Factory where 1=1";
			if (factory != null) {
				if ((!("").equals(factory.getName()))
						&& (factory.getName() != null)) {
					hql = hql + " and name like '%" +factory.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			factoryList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return factoryList;
	}
}
