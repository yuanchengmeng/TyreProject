package com.kexun.wm.system.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.system.bean.LoginLog;
import com.kexun.wm.system.dao.LoginLogDao;
import com.kexun.wm.untils.HibernateUtil;

/** 
 * @author Frank  
 * @date 2015-1-18 下午1:11:22
 */
public class LoginLogDaoImpl implements LoginLogDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	public void addLoginLog(LoginLog loginLog) throws Exception {
		Session session = null;
		try{
			session = sf.openSession();
			session.save(loginLog);
			session.flush();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<LoginLog> queryLoginLog(LoginLog loginLog, int offset,
			int length) throws Exception {
		Session session = null;
		List<LoginLog> loginLogList = null;
		try{
			session = sf.openSession();
			String hql = "from LoginLog where 1=1";
 			if(loginLog!=null){
				if(loginLog.getLuser()!=null){
					hql=hql+" and luser like '%"+loginLog.getLuser()+"%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(length);
			loginLogList = query.list();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return loginLogList;
	}

	public int getAllRowCount(LoginLog loginLog) throws Exception {
		Session session = null;
		int rows = 0;
		try{
			session = sf.openSession();
			String hql = "select count(*)  from loginlog ";
 			if(loginLog!=null){
				if(loginLog.getLuser()!=null){
					hql=hql+"where luser like '%"+loginLog.getLuser()+"%'";				
				}
			}
			SQLQuery query = session.createSQLQuery(hql);
			List list=query.list();
//			BigInteger count = (BigInteger) list.get(0);
			rows = (Integer) list.get(0);
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return rows;
	}

}
