package com.kexun.wm.system.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.kexun.wm.system.bean.SysUser;

 
public class SysUserLoginFilter implements Filter {
	/**
	 * 
	 */

	 public FilterConfig config;
	    
	    public void destroy() {
	        this.config = null;
	    }
	    
	    public static boolean isContains(String container, String[] regx) {
	        boolean result = false;
	        for (int i = 0; i < regx.length; i++) {
	            if (container.indexOf(regx[i]) != -1) {
	                return true;
	            }
	        }
	        return result;
	    }

	   
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	        HttpServletRequest hrequest = (HttpServletRequest)request;
	        HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
	        
	        String logonStrings = config.getInitParameter("logonStrings");        // 登录登陆页面
	        String includeStrings = config.getInitParameter("includeStrings");    // 过滤资源后缀参数
	        String redirectPath = hrequest.getContextPath() + config.getInitParameter("redirectPath");// 没有登陆转向页面
 	        String[] logonList = logonStrings.split(";");
	        String[] includeList = includeStrings.split(";");
	        
	        if (!this.isContains(hrequest.getRequestURI(), includeList)||this.isContains(hrequest.getRequestURI(), logonList)) {// 只对指定过滤参数后缀进行过滤
	        	
	        	chain.doFilter(request, response);
	            
	        }else{
	        	String username=hrequest.getParameter("name");//判断用户是否登录
	        	SysUser sysUser=(SysUser) hrequest.getSession().getAttribute("u");
	  	        if (username == null&&sysUser==null) {
	  	            wrapper.sendRedirect(redirectPath);
	  	             
	  	        }else {
	  	            chain.doFilter(request, response);
	  	            
	  	        }
	        }
	    }

	    public void init(FilterConfig filterConfig) throws ServletException {
	        config = filterConfig;
	    }

}
