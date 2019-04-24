package com.kexun.wm.icStock.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.icStock.bean.ICStockBill;
import com.kexun.wm.icStock.dao.ICStockBillDao;
import com.kexun.wm.system.bean.LoginLog;
import com.kexun.wm.untils.HibernateUtil;
import com.kexun.wm.untils.HibernateUtilK3;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:11:22
 */
public class ICStockBillDaoImpl implements ICStockBillDao {

	private static SessionFactory sfk3 = HibernateUtilK3.getSessionFactory();
	
	public List<ICStockBill> queryOutStock(ICStockBill vo, int offset,
			int length) throws Exception {
		Session session = null;
		List<ICStockBill> list = new ArrayList<ICStockBill>();
		try{
			session = sfk3.openSession();
			String hql = "from ICStockBill where FTranType=2";
 			if(vo!=null && vo.getFBillNo()!=null){
				hql=hql+" and FBillNo like '%"+vo.getFBillNo()+"%'";
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(length);
			list = query.list();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return list;
	}

	public int getOutStockRows(ICStockBill vo) throws Exception {
		Session session = null;
		int rows = 0;
		try{
			session = sfk3.openSession();
			String hql = "select count(*)  from ICStockBill where FTranType=2";
			if(vo!=null && vo.getFBillNo()!=null){
				hql=hql+" and FBillNo like '%"+vo.getFBillNo()+"%'";
			}
			SQLQuery query = session.createSQLQuery(hql);
			rows = (Integer) query.uniqueResult();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return rows;
	}

}
