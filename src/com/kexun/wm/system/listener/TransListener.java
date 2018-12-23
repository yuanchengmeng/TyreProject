package com.kexun.wm.system.listener;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TransListener implements ServletContextListener {
	
	private Timer timer = null; 
	 
	public void contextInitialized(ServletContextEvent event) {
		// 在这里初始化监听器，在tomcat启动的时候监听器启动，可以在这里实现定时器功能
		timer = new Timer();
		TransTimer transTimer =new TransTimer();
  		// 调用reportTimer，0表示任务无延迟，5*1000表示每隔5秒执行任务，60*60*1000表示一个小时，24*60*60*1000表示一天。
		timer.schedule(transTimer, 0, 24 * 60 * 60 * 1000); // 每天执行一次reportTimer类
  	}

	public void contextDestroyed(ServletContextEvent event) {// 在这里关闭监听器，所以在这里销毁定时器。
		timer.cancel();
  	}
 }
