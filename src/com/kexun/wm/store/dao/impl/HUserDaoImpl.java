package com.kexun.wm.store.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.kexun.wm.store.bean.HUser;
import com.kexun.wm.store.dao.HUserDao;
import com.kexun.wm.untils.HibernateUtil;

public class HUserDaoImpl implements HUserDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public int saveHUser(HUser user1) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.save(user1);
			session.flush();
			return 1;
		} catch (HibernateException hi) {
			hi.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public int deleteHUser(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		HUser user1 = null;
		try {
			session = sf.openSession();
			user1 = findHUserById(id);
			session.delete(user1);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public int updateHUser(HUser user1) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(user1);
			session.flush();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public List<HUser> queryHUser(HUser user1, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<HUser> user1List1 = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from HUser where 1=1";
			if (user1 != null) {
				if (!("").equals(user1.getName())) {
					hql = hql + " and name ='" + user1.getName().trim() + "'";
				}
			}
			Query q = session.createQuery(hql);
			q.setFirstResult(beginPos);
			q.setMaxResults(pageSize);
			user1List1 = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return user1List1;
	}

	public HUser findHUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		HUser user1 = null;
		try {
			session = sf.openSession();
			user1 = (HUser) session.get(HUser.class, id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return user1;
	}

	public int queryAllRows(HUser user1) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		int result = 0;
		try {
			session = sf.openSession();
			String hql = "select count(*) from hand_user";
			if (user1 != null) {
				if (!("").equals(user1.getName())) {
					hql = hql + " where name = '" + user1.getName().trim() + "'";
				}
			}
			Query q = session.createSQLQuery(hql);
			List list = q.list();
			// BigInteger count = (BigInteger) list.get(0);
			result = (Integer) list.get(0);
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}

	public HUser getHUserByName(String name) throws Exception {
		// TODO Auto-generated method stub
		HUser user1 = null;
		Session session=null;
	try{
		session= sf.openSession();
		DetachedCriteria dc = DetachedCriteria.forClass(HUser.class);
		if (name != null) {
			dc.add(Restrictions.eq("name", name));
		}
		Criteria c = dc.getExecutableCriteria(session);
		List<HUser> list = c.list();
		if (list.size() > 0) {
			user1 = list.get(0);
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		if(session!=null)
			session.close();
	}
		return user1;
	}
}
