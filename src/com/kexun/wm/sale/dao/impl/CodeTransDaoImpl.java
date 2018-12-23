package com.kexun.wm.sale.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.sale.bean.CodeTrans;
import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.dao.CodeTransDao;
import com.kexun.wm.untils.HibernateUtil;
import com.kexun.wm.untils.HibernateUtilK3;

public class CodeTransDaoImpl implements CodeTransDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static SessionFactory sfk3 = HibernateUtilK3.getSessionFactory();
	public int saveCodeTrans(CodeTrans codeTrans) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.save(codeTrans);
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

	public List<CodeTrans> queryCodeTrans(CodeTrans codeTrans, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<CodeTrans> codeTransList = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from CodeTrans where 1=1";
			if (codeTrans != null) {
				if (codeTrans.getFlag()>0) {
					hql = hql + " and flag =" + codeTrans.getFlag();
				}
				if (codeTrans.getName()!=null && !("").equals(codeTrans.getName())) {
					hql = hql + " and name ='" + codeTrans.getName().trim() + "'";
				}
				if (codeTrans.getName()!=null && !("").equals(codeTrans.getCode())) {
					hql = hql + " and code ='" + codeTrans.getCode().trim() + "'";
				}
			}
			Query q = session.createQuery(hql);
			q.setFirstResult(beginPos);
			q.setMaxResults(pageSize);
			codeTransList = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return codeTransList;
	}
	
	public List<Product> queryProduct() throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<Product> pList = null;
		try {
			session = sfk3.openSession();
			String hql = "from Product";
			Query q = session.createQuery(hql);
			pList = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return pList;
	}

	public List<CodeTrans> getCodeTransByName(String name,int flag) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<CodeTrans> cList = new ArrayList<CodeTrans>();
		try {
			session = sf.openSession();
			String hql = "from CodeTrans where 1=1";
			if(!"".equals(name)){
				hql= hql + " and name='"+name+"'";
			}
			if(flag>0){
				hql= hql + " and flag="+flag;
			}
			Query q = session.createQuery(hql);
			cList = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return cList;
	}
	
	public int queryAllRows(CodeTrans codeTrans) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		int result = 0;
		try {
			session = sf.openSession();
			String hql = "select count(*) from code_trans where 1=1";
			if (codeTrans != null) {
				if (codeTrans.getFlag()>0) {
					hql = hql + " and flag =" + codeTrans.getFlag();
				}
				if (codeTrans.getName()!=null && !("").equals(codeTrans.getName())) {
					hql = hql + " and name ='" + codeTrans.getName().trim() + "'";
				}
				if (codeTrans.getName()!=null && !("").equals(codeTrans.getCode())) {
					hql = hql + " and code ='" + codeTrans.getCode().trim() + "'";
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
}
