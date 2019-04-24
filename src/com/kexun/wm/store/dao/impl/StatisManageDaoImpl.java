package com.kexun.wm.store.dao.impl;

import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.bean.SeOrder;
import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;
import com.kexun.wm.store.dao.StatisManageDao;
import com.kexun.wm.untils.HibernateUtil;
import com.kexun.wm.untils.HibernateUtilK3;

public class StatisManageDaoImpl implements StatisManageDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static SessionFactory kf = HibernateUtilK3.getSessionFactory();
	public List<StandardStatisVo> queryStandardStatis(StatisParams params, int pageNo, int pageSize) throws Exception {
 		List<StandardStatisVo> standardList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			
			String sql = "select 1 storeType,t1.InClass classes,t1.InMan person,t1.ProductID productID,COUNT(1) amount from hand_store t1 where t1.StoreState in ('已出库','在库') ";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.InTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.InTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t1.InMan like '%"+params.getPerson()+"%'";
			}		
			 
			sql += "group by t1.InClass,t1.InMan,t1.ProductID union all select 2 storeType,t2.OutClass classes,t2.OutMan person,t2.ProductID,COUNT(1) amount from hand_store t2 where t2.StoreState ='已出库' ";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t2.OutTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t2.OutTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t2.OutMan like '%"+params.getPerson()+"%'";
			}
			
			sql += "group by t2.OutClass,t2.OutMan,t2.ProductID";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StandardStatisVo.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			standardList=(List<StandardStatisVo>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return standardList;
	}
	 
	
	public int queryStandardStatisSize(StatisParams params) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(1) from (select 1 storeType,t1.InClass classes,t1.InMan person,t1.ProductID productID,COUNT(1) amount from hand_store t1 where t1.StoreState in ('已出库','在库') ";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.InTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.InTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t1.InMan like '%"+params.getPerson()+"%'";
			}		
			 
			sql += "group by t1.InClass,t1.InMan,t1.ProductID union all select 2 storeType,t2.OutClass classes,t2.OutMan person,t2.ProductID,COUNT(1) amount from hand_store t2 where t2.StoreState ='已出库' ";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t2.OutTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t2.OutTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t2.OutMan like '%"+params.getPerson()+"%'";
			}
			
			sql += "group by t2.OutClass,t2.OutMan,t2.ProductID) a";
			
			SQLQuery query = session.createSQLQuery(sql);
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
	
	public List<StandardStatisVo> queryAllStandardStatis(StatisParams params) throws Exception {
 		List<StandardStatisVo> standardList = null;
		Session session = null;
		try {
			session = sf.openSession();
			
			String sql = "select 1 storeType,t1.InClass classes,t1.InMan person,t1.ProductID productID,COUNT(1) amount from hand_store t1 where t1.StoreState in ('已出库','在库') ";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.InTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.InTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t1.InMan like '%"+params.getPerson()+"%'";
			}		
			 
			sql += "group by t1.InClass,t1.InMan,t1.ProductID union all select 2 storeType,t2.OutClass classes,t2.OutMan person,t2.ProductID,COUNT(1) amount from hand_store t2 where t2.StoreState ='已出库' ";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t2.OutTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t2.OutTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t2.OutMan like '%"+params.getPerson()+"%'";
			}
			
			sql += "group by t2.OutClass,t2.OutMan,t2.ProductID";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(StandardStatisVo.class);
			standardList=(List<StandardStatisVo>)query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return standardList;
	}

	public long queryInStoreAmount(StatisParams params) throws Exception {
		long n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select COUNT(1) from hand_store t1 where t1.StoreState in('在库','已出库')";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.InTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.InTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t1.InMan like '%"+params.getPerson()+"%'";
			}
			SQLQuery query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).longValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}


	public long queryOutStoreAmount(StatisParams params) throws Exception {
		long n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select COUNT(1) from hand_store t1 where t1.StoreState = '已出库'";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.OutTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.OutTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getPerson())) {
				sql += " and t1.OutMan like '%"+params.getPerson()+"%'";
			}
			SQLQuery query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).longValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}


	public long queryStoreAmount(StatisParams params) throws Exception {
		long n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select COUNT(1) from hand_store t1 where t1.StoreState = '在库'";
			SQLQuery query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).longValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}
	
	public List<Object[]> queryStoreStatis(StatisParams params, int pageNo, int pageSize) throws Exception {
 		List<Object[]> standardList = null;
		Session session = null;
		try {
			session = sf.openSession();
			int beginPos = (pageNo - 1) * pageSize;
			
			String sql = "select t1.ProductID productID,COUNT(1) amount from hand_store t1 where 1=1";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.InTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.InTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getProductIds())) {
				sql += " and t1.ProductID in ("+params.getProductIds()+")";
			}	
			if(null !=params && params.getStoreType() == 0){
				sql += " and t1.StoreState ='在库'";
			}else if(null !=params && params.getStoreType() == 1){
				sql += " and t1.StoreState in ('在库','已出库')";
			}else if(null !=params && params.getStoreType() == 2){
				sql += " and t1.StoreState ='已出库'";
			}
			
			sql += " group by t1.ProductID";
			System.out.println("sql:"+sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			standardList=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return standardList;
	}
	 
	
	public int queryStoreStatisSize(StatisParams params) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(1) from (select t1.ProductID productID,COUNT(1) amount from hand_store t1 where 1=1";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.InTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.InTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getProductIds())) {
				sql += " and t1.ProductID in ("+params.getProductIds()+")";
			}	
			if(null !=params && params.getStoreType() == 0){
				sql += " and t1.StoreState ='在库'";
			}else if(null !=params && params.getStoreType() == 1){
				sql += " and t1.StoreState in ('在库','已出库')";
			}else if(null !=params && params.getStoreType() == 2){
				sql += " and t1.StoreState ='已出库'";
			}
			sql += " group by t1.ProductID) a";
			System.out.println("sql:"+sql);
			SQLQuery query = session.createSQLQuery(sql);
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
	
	public List<Object[]> queryAllStoreStatis(StatisParams params) throws Exception {
 		List<Object[]> standardList = null;
		Session session = null;
		try {
			session = sf.openSession();
			
			String sql = "select t1.ProductID productID,COUNT(1) amount from hand_store t1 where 1=1";
			
			if (null != params && StringUtils.isNotBlank(params.getTimeStart())) {
				sql += " and t1.InTime >'"+params.getTimeStart()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getTimeEnd())) {
				sql += " and t1.InTime <'"+params.getTimeEnd()+"'";
			}		
			if (null != params && StringUtils.isNotBlank(params.getProductIds())) {
				sql += " and t1.ProductID in ("+params.getProductIds()+")";
			}		
			if(null !=params && params.getStoreType() == 0){
				sql += " and t1.StoreState ='在库'";
			}else if(null !=params && params.getStoreType() == 1){
				sql += " and t1.StoreState in ('在库','已出库')";
			}else if(null !=params && params.getStoreType() == 2){
				sql += " and t1.StoreState ='已出库'";
			}
			sql += "group by t1.ProductID";
			System.out.println("sql:"+sql);
			SQLQuery query = session.createSQLQuery(sql);
			standardList=query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return standardList;
	}
	
	/**
	 * 通过名称查询规格
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Product> queryProductByName(String productName) throws Exception{
		Session session = null;
		List<Product> productList = null;
		try {
			session = kf.openSession();
			String hql = "from Product where FName like '%"+productName+"%'";
			Query q = session.createQuery(hql);
			productList = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
				session.close();
			}
		}
		return productList;
	}
}
