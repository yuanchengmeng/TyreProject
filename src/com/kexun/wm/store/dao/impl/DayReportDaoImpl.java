package com.kexun.wm.store.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.store.bean.DayReport;
import com.kexun.wm.store.dao.DayReportDao;
import com.kexun.wm.untils.HibernateUtil;

public class DayReportDaoImpl implements DayReportDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public List<DayReport> queryInDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception {
 		List<DayReport> dayReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			String sql = "SELECT indate as reportDay, count(*) sum0, sum (case when InClass = '甲班' then 1 else 0 end) sum1, sum (case when InClass = '乙班' then 1 else 0 end) sum2, sum (case when InClass = '丙班' then 1 else 0 end) sum3, sum (case when InClass = '出库组' then 1 else 0 end) sum4, sum (case when InClass = '保管组' then 1 else 0 end) sum5 " +
					"FROM hand_store WHERE StoreState = '在库' AND " +
					"InDate >= '"+dayReport.getTimeStart()+"' AND InDate <= '"+dayReport.getTimeEnd()+"' GROUP BY indate ORDER BY indate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(DayReport.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			dayReportList=(List<DayReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return dayReportList;
	}

	public List<DayReport> queryOutDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception {
		List<DayReport> dayReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			String sql = "SELECT outdate as reportDay, count(*) sum0, sum (case when OutClass = '甲班' then 1 else 0 end) sum1, sum (case when OutClass = '乙班' then 1 else 0 end) sum2, sum (case when OutClass = '丙班' then 1 else 0 end) sum3, sum (case when OutClass = '出库组' then 1 else 0 end) sum4, sum (case when OutClass = '保管组' then 1 else 0 end) sum5 " +
					"FROM hand_store WHERE StoreState = '已出库' AND " +
					"OutDate >= '"+dayReport.getTimeStart()+"' AND OutDate <= '"+dayReport.getTimeEnd()+"' GROUP BY indate ORDER BY OutDate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(DayReport.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			dayReportList=(List<DayReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return dayReportList;
	}

	public List<DayReport> queryDayReport(DayReport dayReport, int pageNo, int pageSize) throws Exception {
		List<DayReport> dayReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			String sql = "SELECT indate as reportDay, count(*) sum0, sum (case when InClass = '甲班' then 1 else 0 end) sum1, sum (case when InClass = '乙班' then 1 else 0 end) sum2, sum (case when InClass = '丙班' then 1 else 0 end) sum3, sum (case when InClass = '出库组' then 1 else 0 end) sum4, sum (case when InClass = '保管组' then 1 else 0 end) sum5 " +
					"FROM hand_store WHERE InDate >= '"+dayReport.getTimeStart()+"' AND InDate <= '"+dayReport.getTimeEnd()+"' GROUP BY indate ORDER BY indate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(DayReport.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			dayReportList=(List<DayReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return dayReportList;
	}

	public int queryInDayReportSize(DayReport dayReport) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from (SELECT DISTINCT indate FROM hand_store WHERE StoreState = '在库' AND " +
					"InDate >= '"+dayReport.getTimeStart()+"' AND InDate <= '"+dayReport.getTimeEnd()+"')n";
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

	public int queryOutDayReportSize(DayReport dayReport) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from (SELECT DISTINCT outdate FROM hand_store WHERE StoreState = '已出库' AND " +
					"outdate >= '"+dayReport.getTimeStart()+"' AND outdate <= '"+dayReport.getTimeEnd()+"')n";
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

	public int queryDayReportSize(DayReport dayReport) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from (SELECT DISTINCT indate FROM hand_store WHERE InDate >= '"+dayReport.getTimeStart()+"' AND InDate <= '"+dayReport.getTimeEnd()+"')n";
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
 
	public List<DayReport> queryAllInDayReport(DayReport dayReport) throws Exception {
 		List<DayReport> dayReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "SELECT indate as reportDay, count(*) sum0, sum (case when InClass = '甲班' then 1 else 0 end) sum1, sum (case when InClass = '乙班' then 1 else 0 end) sum2, sum (case when InClass = '丙班' then 1 else 0 end) sum3, sum (case when InClass = '出库组' then 1 else 0 end) sum4, sum (case when InClass = '保管组' then 1 else 0 end) sum5 " +
					"FROM hand_store WHERE StoreState = '在库' AND " +
					"InDate >= '"+dayReport.getTimeStart()+"' AND InDate <= '"+dayReport.getTimeEnd()+"' GROUP BY indate ORDER BY indate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(DayReport.class);
			dayReportList=(List<DayReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return dayReportList;
	}

	public List<DayReport> queryAllOutDayReport(DayReport dayReport) throws Exception {
		List<DayReport> dayReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "SELECT outdate as reportDay, count(*) sum0, sum (case when outClass = '甲班' then 1 else 0 end) sum1, sum (case when outClass = '乙班' then 1 else 0 end) sum2, sum (case when outClass = '丙班' then 1 else 0 end) sum3, sum (case when outClass = '出库组' then 1 else 0 end) sum4, sum (case when outClass = '保管组' then 1 else 0 end) sum5 " +
					"FROM hand_store WHERE StoreState = '已出库' AND " +
					"outdate >= '"+dayReport.getTimeStart()+"' AND outdate <= '"+dayReport.getTimeEnd()+"' GROUP BY outdate ORDER BY outdate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(DayReport.class);
			dayReportList=(List<DayReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return dayReportList;
	}

	public List<DayReport> queryAllDayReport(DayReport dayReport) throws Exception {
		List<DayReport> dayReportList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "SELECT indate as reportDay, count(*) sum0, sum (case when InClass = '甲班' then 1 else 0 end) sum1, sum (case when InClass = '乙班' then 1 else 0 end) sum2, sum (case when InClass = '丙班' then 1 else 0 end) sum3, sum (case when InClass = '出库组' then 1 else 0 end) sum4, sum (case when InClass = '保管组' then 1 else 0 end) sum5 " +
					"FROM hand_store WHERE InDate >= '"+dayReport.getTimeStart()+"' AND InDate <= '"+dayReport.getTimeEnd()+"' GROUP BY indate ORDER BY indate DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(DayReport.class);
			dayReportList=(List<DayReport>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return dayReportList;
	}
}
