package com.kexun.wm.untils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	/**
	 */
	private static final SessionFactory sessionFactory;
	
	static{
		try {
			//Create the SessionFactory from hibernate.cfg.xml
			sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		} catch (Throwable ex) {
			// Make sure you log the exception, as it might be swallowed
			throw new ExceptionInInitializerError(ex);
		}
	}
	/**
	 * @return sessionFactory
	 */
	public static SessionFactory getSessionFactory(){
			return sessionFactory;
	}
	
	public static Session getCurrentSession(){
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}
//	//k3数据库配置文件
//	public static SessionFactory getSessionFactoryK3(){
//		SessionFactory factory = new Configuration().configure("hibernateK3.cfg.xml").buildSessionFactory();
// 		return factory;
//    }
}
