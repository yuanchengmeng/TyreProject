package com.kexun.wm.store.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.store.bean.StoreReport;
import com.kexun.wm.store.dao.StoreReportDao;
import com.kexun.wm.untils.HibernateUtil;

public class StoreReportDaoImpl implements StoreReportDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public List<StoreReport> queryInStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception {
 		List<StoreReport> storeReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			String sql = "select t.InClass storeClass,t.ProductID ProductID,count(*) collectCount from hand_store t where t.StoreState='在库' and t.InTime >='" 
			+ storeReport.getTimeStart() + "' and t.InTime <='" + storeReport.getTimeEnd() + "' and t.InClass ='" + storeReport.getStoreClass() + "' GROUP BY t.InClass,t.ProductID";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StoreReport.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			storeReportList=(List<StoreReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeReportList;
	}

	public List<StoreReport> queryOutStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception {
		List<StoreReport> storeReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			String sql = "select t.OutClass storeClass,t.ProductID ProductID,count(*) collectCount from hand_store t where t.StoreState='已出库' and t.OutTime >='" 
			+ storeReport.getTimeStart() + "' and t.OutTime <='" + storeReport.getTimeEnd() + "' and t.OutClass ='" + storeReport.getStoreClass() 
			+ "' GROUP BY t.OutClass,t.ProductID ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StoreReport.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			storeReportList=(List<StoreReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeReportList;
	}

	public List<StoreReport> queryStoreReport(StoreReport storeReport, int pageNo, int pageSize) throws Exception {
		List<StoreReport> storeReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			String sql = "select t.InClass storeClass,t.ProductID ProductID,count(*) collectCount from hand_store t where t.InTime >='" 
			        + storeReport.getTimeStart() + "' and t.InTime <='" + storeReport.getTimeEnd() + "' and t.InClass ='" 
					+ storeReport.getStoreClass() + "' GROUP BY t.InClass,t.ProductID";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StoreReport.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			storeReportList=(List<StoreReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeReportList;
	}

	public int queryInStoreReportSize(StoreReport storeReport) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from (select t.InClass,t.ProductID from hand_store t where t.StoreState='在库' and t.InTime >='" 
			+ storeReport.getTimeStart() + "' and t.InTime <='" + storeReport.getTimeEnd() + "' and t.InClass ='" + storeReport.getStoreClass() 
			+ "' GROUP BY t.InClass,t.ProductID) n";
			Query query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int queryOutStoreReportSize(StoreReport storeReport) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from (select t.OutClass,t.ProductID from hand_store t where t.StoreState='已出库' and t.OutTime >='" 
			        + storeReport.getTimeStart() + "' and t.OutTime <='" + storeReport.getTimeEnd() + "' and t.OutClass ='" 
					+ storeReport.getStoreClass() + "' GROUP BY t.OutClass,t.ProductID) n";
			Query query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int queryStoreReportSize(StoreReport storeReport) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from (select t.InClass,t.ProductID from hand_store t where t.InTime >='" + storeReport.getTimeStart() 
					+ "' and t.InTime <='" + storeReport.getTimeEnd() + "' and t.InClass ='" + storeReport.getStoreClass() 
					+ "' GROUP BY t.InClass,t.ProductID) n";
			Query query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}
 
	public List<StoreReport> queryAllInStoreReport(StoreReport storeReport) throws Exception {
 		List<StoreReport> storeReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select t.InClass storeClass,t.ProductID ProductID,count(*) collectCount from hand_store t where t.StoreState='在库' and t.InTime >='" 
			+ storeReport.getTimeStart() + "' and t.InTime <='" + storeReport.getTimeEnd() + "' and t.InClass ='" + storeReport.getStoreClass() + "' GROUP BY t.InClass,t.ProductID";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StoreReport.class);
			storeReportList=(List<StoreReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeReportList;
	}

	public List<StoreReport> queryAllOutStoreReport(StoreReport storeReport) throws Exception {
		List<StoreReport> storeReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select t.OutClass storeClass,t.ProductID ProductID,count(*) collectCount from hand_store t where t.StoreState='已出库' and t.OutTime >='" 
			+ storeReport.getTimeStart() + "' and t.OutTime <='" + storeReport.getTimeEnd() + "' and t.OutClass ='" + storeReport.getStoreClass() 
			+ "' GROUP BY t.InClass,t.ProductID ";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StoreReport.class);
			storeReportList=(List<StoreReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeReportList;
	}

	public List<StoreReport> queryAllStoreReport(StoreReport storeReport) throws Exception {
		List<StoreReport> storeReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select t.InClass storeClass,t.ProductID ProductID,count(*) collectCount from hand_store t where t.InTime >='" 
			        + storeReport.getTimeStart() + "' and t.InTime <='" + storeReport.getTimeEnd() + "' and t.InClass ='" 
					+ storeReport.getStoreClass() + "' GROUP BY t.InClass,t.ProductID";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StoreReport.class);
			storeReportList=(List<StoreReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeReportList;
	}
}
