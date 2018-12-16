/**
 * 
 */
package com.kexun.wm.sale.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.sale.bean.Standard;
import com.kexun.wm.sale.dao.StandardDao;
import com.kexun.wm.untils.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class StandardDaoImpl implements StandardDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public int saveStandard(Standard standard) throws Exception {
		Session session = null;
		try {
			session = sf.openSession();
			session.save(standard);
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

	public Standard getStandardById(int id) throws Exception {
		// TODO Auto-generated method stub
		Standard standard = null;
		Session session = null;
		try {
			session = sf.openSession();
			standard = (Standard) session.get(Standard.class, id);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return standard;
	}

	public Standard getStandardByCode(Standard standard) throws Exception {
		// TODO Auto-generated method stub
		List<Standard> StandardList = null;
 		Session session = null;
 		Standard b=null;
		try {
			session = sf.openSession();
			String hql = "from Standard where code = '" + standard.getCode() + "'";
			Query query = session.createQuery(hql);
			StandardList = query.list();
			if (StandardList.size() > 0) {
				b = StandardList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}
	public Standard getStandardByName(Standard standard) throws Exception {
		// TODO Auto-generated method stub
		List<Standard> StandardList = null;
 		Session session = null;
 		Standard b=null;
		try {
			session = sf.openSession();
			String hql = "from Standard where name = '" + standard.getName() + "' and speed = '" + standard.getSpeed() + "' and tread = '" + standard.getTread() + "'";
			Query query = session.createQuery(hql);
			StandardList = query.list();
			if (StandardList.size() > 0) {
				b = StandardList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}
	public Standard queryStandardByCode(Standard standard) throws Exception {
		// TODO Auto-generated method stub
		List<Standard> StandardList = null;
 		Session session = null;
 		Standard b=null;
		try {
			session = sf.openSession();
			String hql = "from Standard where code = '" + standard.getCode() + "' and id <> "+standard.getId();
			Query query = session.createQuery(hql);
			StandardList = query.list();
			if (StandardList.size() > 0) {
				b = StandardList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}
	public Standard queryStandardByName(Standard standard) throws Exception {
		// TODO Auto-generated method stub
		List<Standard> StandardList = null;
 		Session session = null;
 		Standard b=null;
		try {
			session = sf.openSession();
			String hql = "from Standard where name = '" + standard.getName() + "' and speed = '" + standard.getSpeed() + "' and tread = '" + standard.getTread() + "' and id <> "+standard.getId();
			Query query = session.createQuery(hql);
			StandardList = query.list();
			if (StandardList.size() > 0) {
				b = StandardList.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return b;
	}
	public int deleteStandard(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Standard standard = null;
		try {
			session = sf.openSession();
			standard = getStandardById(id);
			session.delete(standard);
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
	public int updateStandard(Standard standard) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(standard);
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
	public List<Standard> queryStandard(Standard standard, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<Standard> standardList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from Standard where 1=1";
			if (standard != null) {
				if ((!("").equals(standard.getName()))
						&& (standard.getName() != null)) {
					hql = hql + " and name like '%" + standard.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			standardList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return standardList;
	}
	public List<Standard> queryStandardSize(Standard standard) throws Exception {
		// TODO Auto-generated method stub
		List<Standard> standardList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from Standard where 1=1";
			if (standard != null) {
				if ((!("").equals(standard.getName()))
						&& (standard.getName() != null)) {
					hql = hql + " and name like '%" + standard.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			standardList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return standardList;
	}
}
