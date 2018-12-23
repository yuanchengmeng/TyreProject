package com.kexun.wm.sale.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.kexun.wm.sale.bean.SaleAfter;
import com.kexun.wm.sale.dao.SaleAfterDao;
import com.kexun.wm.untils.HibernateUtil;

public class SaleAfterDaoImpl implements SaleAfterDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public int saveSaleAfter(SaleAfter saleAfter) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.save(saleAfter);
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

	public int deleteSaleAfter(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		SaleAfter saleAfter = null;
		try {
			session = sf.openSession();
			saleAfter = findSaleAfterById(id);
			session.delete(saleAfter);
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

	public int updateSaleAfter(SaleAfter saleAfter) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(saleAfter);
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

	public List<SaleAfter> querySaleAfter(SaleAfter saleAfter, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<SaleAfter> saleAfterList1 = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from SaleAfter where 1=1";
			/*if (saleAfter != null) {
				if (!("").equals(saleAfter.getName())) {
					hql = hql + " and name ='" + saleAfter.getName().trim() + "'";
				}
			}*/
			Query q = session.createQuery(hql);
			q.setFirstResult(beginPos);
			q.setMaxResults(pageSize);
			saleAfterList1 = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return saleAfterList1;
	}

	public SaleAfter findSaleAfterById(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		SaleAfter saleAfter = null;
		try {
			session = sf.openSession();
			saleAfter = (SaleAfter) session.get(SaleAfter.class, id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return saleAfter;
	}

	public int queryAllRows(SaleAfter saleAfter) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		int result = 0;
		try {
			session = sf.openSession();
			String hql = "select count(*) from sale_after";
			/*if (saleAfter != null) {
				if (!("").equals(user1.getName())) {
					hql = hql + " where name = '" + user1.getName().trim() + "'";
				}
			}*/
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

	public SaleAfter getSaleAfterByName(String name) throws Exception {
		// TODO Auto-generated method stub
		SaleAfter saleAfter = null;
		Session session=null;
	try{
		session= sf.openSession();
		DetachedCriteria dc = DetachedCriteria.forClass(SaleAfter.class);
		if (name != null) {
			dc.add(Restrictions.eq("name", name));
		}
		Criteria c = dc.getExecutableCriteria(session);
		List<SaleAfter> list = c.list();
		if (list.size() > 0) {
			saleAfter = list.get(0);
		}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally{
		if(session!=null)
			session.close();
	}
		return saleAfter;
	}
}
