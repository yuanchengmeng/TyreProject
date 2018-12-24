package com.kexun.wm.untils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.bean.Emp;
import com.kexun.wm.manage.bean.HandClass;
import com.kexun.wm.manage.bean.Job;
import com.kexun.wm.system.bean.K3User;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.system.bean.SysUser;

public class AllSelectItemUtil {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static SessionFactory sfk3 = HibernateUtilK3.getSessionFactory();
	public static List<Emp> queryEmp() throws Exception {
		Session session = null;
		List<Emp> empList = null;
		try {
			session = sf.openSession();
			String sql = "from Emp";
			Query q = session.createQuery(sql);
			empList = q.list();

		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return empList;
	}

	public static List<Emp> queryLeader() throws Exception {
		Session session = null;
		List<Emp> empList = null;
		try {
			session = sf.openSession();
			String sql = "from Emp where dept.deptname='领导层'";
			Query q = session.createQuery(sql);
			empList = q.list();

		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return empList;
	}
	
	public static HandClass getHandClassById(int id) throws Exception {
		 
		HandClass handClass = null;
		Session session = null;
		try {
			session = sf.openSession();
			handClass = (HandClass) session.get(HandClass.class, id);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return handClass;
	}
	
	public static List<HandClass> queryAllHandClass() throws Exception {
		 
		List<HandClass> handClassList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from HandClass";
			Query query = session.createQuery(hql);
			handClassList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return handClassList;
	}

	public static List<PageSize> queryPageSize() throws Exception {
		Session session = null;
		List<PageSize> pageSizeList = null;
		try {
			session = sf.openSession();
			String sql = "from PageSize";
			Query q = session.createQuery(sql);
			pageSizeList = q.list();

		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return pageSizeList;
	}

	public static SysUser getCurrentUser() throws Exception {
 		HttpServletRequest request = ServletActionContext.getRequest();
		SysUser sysUser = (SysUser) request.getSession().getAttribute("u");
 		return sysUser;
 	}

	public static List<Dept> queryDept() {
		Session session = null;
		List<Dept> deptList = null;
		try {
			session = sf.openSession();
			String hql = "from Dept";
			Query query = session.createQuery(hql);
			deptList = query.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return deptList;
	}

	public static List<Emp> queryEmp(int deptId) throws Exception {
		Session session = null;
		List<Emp> empList = null;
		try {
			session = sf.openSession();
			String hql = "from Emp where  dept_id=" + deptId;
			Query query = session.createQuery(hql);
			empList = query.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return empList;
	}

	public static List<Job> queryJob() throws Exception {
		Session session = null;
		List<Job> jobList = null;
		try {
			session = sf.openSession();
			String sql = "from Job";
			Query q = session.createQuery(sql);
			jobList = q.list();

		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return jobList;
	}

	public static String getNowTime() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date rightNow = new Date();
		String result = sdf.format(rightNow);
		return result;
	}
	
	public static String getNowDay() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date rightNow = new Date();
		String result = sdf.format(rightNow)+" 00:00:00";
		return result;
	}
	
	public static String getDayStart() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date rightNow = new Date();
		String result = sdf.format(rightNow);
		return result;
	}
	
	public static String getDayEnd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date rightNow = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rightNow);
		calendar.add(Calendar.DAY_OF_MONTH, +7);
		rightNow = calendar.getTime();
		String result = sdf.format(rightNow);
		return result;
	}
	
	public static String getDateByDay(int day) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date rightNow = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rightNow);
		calendar.set(Calendar. HOUR_OF_DAY, 0);
		calendar.set(Calendar. MINUTE, 0);
		calendar.set(Calendar. SECOND, 0);
		calendar.set(Calendar. MILLISECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, day);
		rightNow = calendar.getTime();
		String result = sdf.format(rightNow);
		return result;
	}

	public static String defaultTime(String f) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		Date rightNow = new Date();
		String result = sdf.format(rightNow);
		return result;
	}

	public static String addDay(String f) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		Date rightNow = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(rightNow);
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		rightNow = calendar.getTime();
		String result = sdf.format(rightNow);
		return result;
	}

	public static String addDay(String f, Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, +1);
		date = calendar.getTime();
		String result = sdf.format(date);
		return result;
	}
	
	public static String formatTime(String f, Date date) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		String result = sdf.format(date);
		return result;
	}

	public static Date defaultTime1(String f) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(f);
		Date time = null;
		time = sdf.parse(sdf.format(new Date()));
		return time;
	}

	public static String formatCode(String str,int code) {
		DecimalFormat df=new DecimalFormat(str);
		return df.format(code);
	}
	
	public static List<K3User> queryK3User() throws Exception {
		Session session = null;
		List<K3User> k3UserList = null;
		try {
			session = sfk3.openSession();
			String sql = "from K3User";
			Query q = session.createQuery(sql);
			k3UserList = q.list();

		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return k3UserList;
	}
	
	public static K3User getK3UserById(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		K3User k3User = null;
		try {
			session = sfk3.openSession();
			k3User = (K3User) session.get(K3User.class, id);
			session.flush();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return k3User;
	}

}
