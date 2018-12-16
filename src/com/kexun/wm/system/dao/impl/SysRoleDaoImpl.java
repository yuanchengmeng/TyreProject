package com.kexun.wm.system.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.system.bean.SysRole;
import com.kexun.wm.system.bean.SysUser;
import com.kexun.wm.system.dao.SysRoleDao;
import com.kexun.wm.untils.HibernateUtil;

/**
 * @author Frank
 * @date 2014-9-28 下午2:24:41
 */
public class SysRoleDaoImpl implements SysRoleDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	public List<SysRole> findSysRoles(SysRole sysRole, int pageNo, int pageSize)
			throws Exception {
		Session session = null;
		List<SysRole> sysRoleList = null;
		int beginPos =( pageNo-1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from SysRole where 1=1";
			if (sysRole != null) {
				if (!("").equals(sysRole.getName())) {
					hql = hql + " and name like '%" + sysRole.getName() + "%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			sysRoleList = query.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysRoleList;
	}

	public void saveSysRole(SysRole sysRole) throws Exception {
		Session session = null;
		try {
			session = sf.openSession();
			session.save(sysRole);
			session.flush();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public SysRole getSysRoleById(int id) throws Exception {
		Session session = null;
		SysRole sysRole = null;
		try {
			session = sf.openSession();
			sysRole = (SysRole) session.get(SysRole.class, id);
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysRole;
	}

	public void updateSysRole(SysRole sysRole) throws Exception {
		Session session = null;
		try {
			session = sf.openSession();
			session.update(sysRole);
			session.flush();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteSysRole(int id) throws Exception {
		Session session1 = null;
		Session session2 = null;
		try {
			session1 = sf.openSession();
			session2 = sf.openSession();
			SysRole sysRole = getSysRoleById(id);
			String sql="select * from sys_user where role_id="+id;
			SQLQuery sqlQuery=session1.createSQLQuery(sql);
			sqlQuery.addEntity(SysUser.class);
			List<SysUser> list=sqlQuery.list();
			for(int i=0;i<list.size();i++){
				list.get(i).setSysRole(null);
			}
			session2.delete(sysRole);
			session1.flush();
			session2.flush();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session1 != null)
				session1.close();
			if (session2 != null)
				session2.close();
		}
	}

	public int queryAllRows(SysRole sysRole) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		int result = 0;
		try {
			session = sf.openSession();
			// 获取数据库中所有记录的总条数
			String sql = "select count(*)  from  sys_role";
			if (sysRole != null) {
				if (!("").equals(sysRole.getName())) {
					// " where classes_id="中where前面要加一个空格,要不然就和前面的链接成一个单词了
 					sql = sql + "  where name like '"+ sysRole.getName()+"' ";
				}
			}
			SQLQuery sum = session.createSQLQuery(sql);
			List list = sum.list();
//			BigInteger count = (BigInteger) list.get(0);
			result = (Integer) list.get(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.fillInStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}

	public List<SysRole> findSysRoles() throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<SysRole> sysRoleList = null;
		try {
			session = sf.openSession();
			String hql = "from SysRole ";
			Query query = session.createQuery(hql);
			sysRoleList = query.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysRoleList;
	}

}
