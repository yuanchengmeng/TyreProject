package com.kexun.wm.system.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.system.bean.SysMenu;
import com.kexun.wm.system.dao.SysMenuDao;
import com.kexun.wm.untils.HibernateUtil;

/** 
 * @author Frank  
 * @date 2014-9-26 下午2:06:27
 */
public class SysMenuDaoImpl implements SysMenuDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	public void saveSysMenu(SysMenu sysMenu) throws Exception {
		Session session = null;
		try{
			session = sf.openSession();
			session.save(sysMenu);
			session.flush();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public List<SysMenu> findSysMenus(SysMenu sysMenu,int offset, int length) throws Exception {
		Session session = null;
		List<SysMenu> sysMenuList = null;
		try{
			session = sf.openSession();
			String hql = "from SysMenu where 1=1";
			if(sysMenu!=null){
				if(!("").equals(sysMenu.getName())){
					hql=hql+" and name like '%"+sysMenu.getName()+"%'";
				}
			}
			Query query = session.createQuery(hql);
			query.setFirstResult(offset);
			query.setMaxResults(length);
			sysMenuList = query.list();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysMenuList;
	}

	public SysMenu getSysMenuById(int id) throws Exception {
		Session session = null;
		SysMenu sysMenu = null;
		try{
			session = sf.openSession();
			sysMenu = (SysMenu)session.get(SysMenu.class, id);
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysMenu;
	}

	public void updateSysMenu(SysMenu sysMenu) throws Exception {
		Session session = null;
		try{
			session = sf.openSession();
			session.update(sysMenu);
			session.flush();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public void deleteSysMenu(int[] id) throws Exception {
		Session session = null;
		String sql1 = "";
		String sql2 = "";
		for(int i=0;i<id.length;i++){		    
			if(i == 0){
				sql1 = "id=" + id[i];
				sql2 = "menu_id=" + id[i];
				
			}else{
				sql1 = sql1 + " or id=" + id[i];
				sql2 = sql2 + " or menu_id=" + id[i];
			}
		}
		try {
			session = sf.openSession();
			SQLQuery query2 = session.createSQLQuery("delete from sys_role_menu where " + sql2);
			SQLQuery query1 = session.createSQLQuery("delete from sys_menu where " + sql1);	
			query1.executeUpdate();
			query2.executeUpdate();
			session.flush();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
	}

	public int getAllRowCount(SysMenu sysMenu) throws Exception {
		Session session = null;
		int rows = 0;
		try{
			session = sf.openSession();
			String hql = "select count(*)  from sys_menu";
			if(sysMenu!=null){
				if(!("").equals(sysMenu.getName())){
					hql=hql+" where name like '"+sysMenu.getName()+"'";
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

	public List<SysMenu> findSysMenus() throws Exception {
		Session session = null;
		List<SysMenu> sysMenuList = null;
		try{
			session = sf.openSession();
			String hql = "from SysMenu";
			Query query = session.createQuery(hql);
			sysMenuList = query.list();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return sysMenuList;
	}

	public List<SysMenu> findParentMenus() throws Exception {
		Session session = null;
		List<SysMenu> psysMenuList = null;
		try{
			session = sf.openSession();
			String hql = "from SysMenu as a where a.parent_menu_id=0";
			Query query = session.createQuery(hql);
			psysMenuList = query.list();
		}catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return psysMenuList;
	}
}
