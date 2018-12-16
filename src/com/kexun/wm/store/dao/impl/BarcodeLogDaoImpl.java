package com.kexun.wm.store.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.store.bean.BarcodeLog;
import com.kexun.wm.store.dao.BarcodeLogDao;
import com.kexun.wm.untils.HibernateUtil;

public class BarcodeLogDaoImpl implements BarcodeLogDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
 
	public List<BarcodeLog> queryBarcodeLog(BarcodeLog barcodeLog, int pageNo, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		List<BarcodeLog> barcodeLogList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from BarcodeLog where 1=1";
			if (barcodeLog != null) {
 			 
				if (barcodeLog.getLogTime1() != null && !"".equals(barcodeLog.getLogTime1()) ) {
					hql = hql + " and logTime >='" + barcodeLog.getLogTime1() + "'";
				}
				if (barcodeLog.getLogTime2() != null && !"".equals(barcodeLog.getLogTime2()) ) {
					hql = hql + " and logTime <='" + barcodeLog.getLogTime2() + "'";
				}
				if (barcodeLog.getOrderNo()!= null && !"".equals(barcodeLog.getOrderNo()) ) {
					hql = hql + " and orderNo ='" + barcodeLog.getOrderNo() + "'";
				} 
				if (barcodeLog.getStore() != null && barcodeLog.getStore().getBarcode() != null && !"".equals(barcodeLog.getStore().getBarcode())) {
					hql = hql + " and store.barcode like '%" + barcodeLog.getStore().getBarcode()
							+ "%'";
				}
				 
			}
			hql = hql + " order by logTime desc";
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			barcodeLogList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return barcodeLogList;
	}

	public int queryBarcodeLogSize(BarcodeLog barcodeLog) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "select count(*) from BarcodeLog where 1=1";
			if (barcodeLog != null) {
				if (barcodeLog.getLogTime1() != null && !"".equals(barcodeLog.getLogTime1()) ) {
					hql = hql + " and logTime >='" + barcodeLog.getLogTime1() + "'";
				}
				if (barcodeLog.getLogTime2() != null && !"".equals(barcodeLog.getLogTime2()) ) {
					hql = hql + " and logTime <='" + barcodeLog.getLogTime2() + "'";
				}
				if (barcodeLog.getOrderNo()!= null && !"".equals(barcodeLog.getOrderNo()) ) {
					hql = hql + " and orderNo ='" + barcodeLog.getOrderNo() + "'";
				} 
				if (barcodeLog.getStore() != null && barcodeLog.getStore().getBarcode() != null && !"".equals(barcodeLog.getStore().getBarcode())) {
					hql = hql + " and store.barcode like '%" + barcodeLog.getStore().getBarcode()
							+ "%'";
				} 
			}
			Query query = session.createQuery(hql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return n;
	}

	 
}
