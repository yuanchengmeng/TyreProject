package com.kexun.wm.system.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.kexun.wm.manage.bean.Dept;
import com.kexun.wm.manage.bean.Emp;
import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.K3User;
import com.kexun.wm.system.bean.LoginLog;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.system.bean.SysMenu;
import com.kexun.wm.system.bean.SysRole;
import com.kexun.wm.system.bean.SysUser;
import com.kexun.wm.system.service.LoginLogService;
import com.kexun.wm.system.service.SysRoleService;
import com.kexun.wm.system.service.SysUserService;
import com.kexun.wm.system.service.impl.LoginLogServiceImpl;
import com.kexun.wm.system.service.impl.SysRoleServiceImpl;
import com.kexun.wm.system.service.impl.SysUserServiceImpl;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class SysUserAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String jobNo;
	private String password;
	private String verifyCode;
	private SysUserService sysUserService = new SysUserServiceImpl();
	private LoginLogService loginLogService;
	private String flag;
	private List<Emp> emplist;
	private List<Dept> deptList;
	private SysUser sysUser;
	private SysMenu sysMenu;
	private LoginLog loginLog;
	private PageBean pageBean;
	private String ids;
	private List<SysUser> sysUserList;
	private List<SysRole> sysRoleList;
	private Set<SysMenu> sysMenus;
	private List<SysMenu> sysMenuList;
	private List<SysMenu> parentMenuList;
	private List<K3User> k3UserList;
	private K3User k3User;
	private SysRoleService sysRoleService = new SysRoleServiceImpl();
	private int page = 1;
	private int pageSize = 5;
	private List<PageSize> pageSizeList = null;
	private String userName = "";
	private int totalPage;

	/**
	 * 初始化页面
	 * 
	 * @return
	 * @throws Exception
	 */
	public String initSysUser() throws Exception {
		if ("query".equals(flag)) {
			return "querySysUser";
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			userName = new String(userName.getBytes("ISO-8859-1"), "utf-8");
			sysRoleList = sysRoleService.findSysRoles();
			k3UserList = AllSelectItemUtil.queryK3User();
//			deptList = AllSelectItemUtil.queryDept();
//			emplist = AllSelectItemUtil.queryEmp();
			sysUser = new SysUser();
			return "sysUserForm";
		}
	}

	/**
	 * 添加记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addSysUser() throws Exception {
		if("".equals(sysUser.getJobNo())||"".equals(sysUser.getName())||"".equals(sysUser.getPassword())||sysUser.getSysRole().getId()==0||sysUser.getK3User().getFItemID()==0){
			k3UserList = AllSelectItemUtil.queryK3User();
			ShowMessageUtil.showMessageLess();
			sysRoleList = sysRoleService.findSysRoles();
			return "sysUserForm";
		}
		if(sysUser.getJobNo().length()!=4){
			k3UserList = AllSelectItemUtil.queryK3User();
			ShowMessageUtil.showMessageLength();
			sysRoleList = sysRoleService.findSysRoles();
			return "sysUserForm";
		}
		if(sysUserService .findByJobNo(sysUser.getJobNo())!=null){
			k3UserList = AllSelectItemUtil.queryK3User();
			ShowMessageUtil.showExistSuccess();
			sysRoleList = sysRoleService.findSysRoles();
			return "sysUserForm";
		}
		sysUser.setEmpID(sysUser.getK3User().getFItemID());
		sysUserService.saveSysUser(sysUser);
		HttpServletRequest request = ServletActionContext.getRequest();
		userName = new String(userName.getBytes("ISO-8859-1"), "utf-8");
		return SUCCESS;
	}

	/**
	 * 分页查询
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findSysUser() throws Exception {
		if (page == 0) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		sysUser = new SysUser(userName);
		pageSizeList = AllSelectItemUtil.queryPageSize();
		pageBean = sysUserService.findSysUsers(sysUser, pageSize, page);
		sysUserList = pageBean.getList();
		for(int i=0;i<sysUserList.size();i++){
			sysUserList.get(i).setK3User(AllSelectItemUtil.getK3UserById(sysUserList.get(i).getEmpID()));
		}
		totalPage = pageBean.getTotalPage();
		sysRoleList = sysRoleService.findSysRoles();
		k3UserList = AllSelectItemUtil.queryK3User();
		return SUCCESS;
	}

	/**
	 * 根据ID获取
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSysUserById() throws Exception {
		sysUser = sysUserService.getSysUserById(sysUser.getId());
		sysUser.setK3User(AllSelectItemUtil.getK3UserById(sysUser.getEmpID()));
		if ("modify".equals(flag)) {
			sysRoleList = sysRoleService.findSysRoles();
			k3UserList = AllSelectItemUtil.queryK3User();
			return "sysUserModify";
		} else {
			return "sysUserDetail";
		}
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifySysUser() throws Exception {
		if("".equals(sysUser.getJobNo())||"".equals(sysUser.getName())||"".equals(sysUser.getPassword())||sysUser.getSysRole().getId()==0||sysUser.getK3User().getFItemID()==0){
			sysUser=sysUserService.getSysUserById(sysUser.getId());
			ShowMessageUtil.showMessageLess();
			sysRoleList = sysRoleService.findSysRoles();
			k3UserList = AllSelectItemUtil.queryK3User();
			return "sysUserForm";
		}
		if(sysUser.getJobNo().length()!=4){
			sysUser=sysUserService.getSysUserById(sysUser.getId());
			ShowMessageUtil.showMessageLength();
			sysRoleList = sysRoleService.findSysRoles();
			return "sysUserForm";
		}
		sysUser.setEmpID(sysUser.getK3User().getFItemID());
		sysUserService.updateSysUser(sysUser);
		HttpServletRequest request = ServletActionContext.getRequest();
		if ("1".equals(flag)) {
			return "first";
		}
		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteSysUser() throws Exception {
		String[] s = ids.split(",");
		int[] id = new int[s.length];
		for (int i = 0; i < id.length; i++) {
			id[i] = Integer.parseInt(s[i]);
		}
		sysUserService.deleteSysUser(id);
		return SUCCESS;
	}

	public String getSysUserItem() throws Exception {
		emplist = AllSelectItemUtil.queryEmp();
		return "login";
	}
	public String Login() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		Cookie[] c=request.getCookies();//在cookie取出用户Id
		if(c!=null&&c.length>0){
			for(int i=0;i<c.length;i++){
				if("userId".equals(c[i].getName())){//判断cookie是否有用户id
					sysUser = sysUserService.getSysUserById(Integer.valueOf(c[i].getValue()));
					if(sysUser!=null){
						return "index";//
					}
				}
			}
		}
		return "login";
	}
	public String LoginSysUser() throws Exception {// 用户登录
		sysUserService = new SysUserServiceImpl();
		sysUser = sysUserService.querySysUser(getJobNo(), getPassword());
		HttpServletRequest request = ServletActionContext.getRequest();
		String  vcode= (String) request.getSession().getAttribute("session_vcode");
		
		if (sysUser != null && sysUser.getSysRole() != null) {
			//用户放到session
			request.getSession().setAttribute("u", sysUser);
			request.getSession().setMaxInactiveInterval(2*60*60);
			//用户放到cookie
			Cookie c=new Cookie("userId",String.valueOf(sysUser.getId()));
			c.setMaxAge(60*60);//设置有效期 一小时
			HttpServletResponse response=ServletActionContext.getResponse();
		    response.addCookie(c);//写到客户端
			/* 记录登录信息 */
			loginLogService = new LoginLogServiceImpl();
			loginLog = new LoginLog();
			loginLog.setLuser(sysUser.getJobNo()+sysUser.getName());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			loginLog.setLogintime(df.format(new Date()));
			loginLog.setLoginip(request.getRemoteAddr());
			loginLog.setAddress("电脑端");
			loginLogService.addLoginLog(loginLog);
			return "success";
		} else {
			if ((sysUserService.findByJobNo(getJobNo())== null)) {
				ShowMessageUtil.showErrorJobNo();
			} else {
				if (!(getPassword().equals((sysUserService.findByJobNo(getJobNo()).getPassword())))) {
					ShowMessageUtil.showErrorPwd();

				} else {
					if (sysUser.getSysRole() == null) {
						ShowMessageUtil.showErrorUser();
					}
				}

			}

		}
		return "false";
	}

	public String getSysMenu() throws Exception {
		sysUserService = new SysUserServiceImpl();
		// 代表的是像生胶使用传递卡的选项
		sysMenu = new SysMenu();
		HttpServletRequest request = ServletActionContext.getRequest();
		sysUser = (SysUser) request.getSession().getAttribute("u");
		// 通过sys_role_menu已经知道此时应该显示的菜单了
		sysMenus = sysUser.getSysRole().getSysMenus();
		// 对这些可以显示的菜单进行遍历
		Iterator<SysMenu> ite = sysMenus.iterator();
		sysMenuList = new ArrayList<SysMenu>();
		parentMenuList = new ArrayList<SysMenu>();
		while (ite.hasNext()) {
			// 遍历出来的单个元素
			sysMenu = ite.next();
			sysMenuList.add(sysMenu);
			// sysMenu.getParent_menu_id() == 0说明此菜单是那些像密炼、计划处、系统设置等选项
			if (sysMenu.getParent_menu_id() == 0) {
				parentMenuList.add(sysMenu);
			}
		}
		return "left";
	}

	public String removeSySUserSession() {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.getSession().invalidate();
		return "RemoveSuceess";
	}

	public String querySysUserList() throws Exception {
		sysUserService = new SysUserServiceImpl();
		if ("first".equals(flag)) {
			sysUserList = sysUserService.querySysUserList(sysUser);
		}
		return "querysysUser";
	}

	public String queryUser() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		sysUser = (SysUser) request.getSession().getAttribute("u");
		return "modifyPsw";
	}
	
	public String testDiv() throws Exception {
		 
		return "test1";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}

	public LoginLogService getLoginLogService() {
		return loginLogService;
	}

	public void setLoginLogService(LoginLogService loginLogService) {
		this.loginLogService = loginLogService;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List<Emp> getEmplist() {
		return emplist;
	}

	public void setEmplist(List<Emp> emplist) {
		this.emplist = emplist;
	}

	public List<Dept> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public LoginLog getLoginLog() {
		return loginLog;
	}

	public void setLoginLog(LoginLog loginLog) {
		this.loginLog = loginLog;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public List<SysUser> getSysUserList() {
		return sysUserList;
	}

	public void setSysUserList(List<SysUser> sysUserList) {
		this.sysUserList = sysUserList;
	}

	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}

	public Set<SysMenu> getSysMenus() {
		return sysMenus;
	}

	public void setSysMenus(Set<SysMenu> sysMenus) {
		this.sysMenus = sysMenus;
	}

	public List<SysMenu> getSysMenuList() {
		return sysMenuList;
	}

	public void setSysMenuList(List<SysMenu> sysMenuList) {
		this.sysMenuList = sysMenuList;
	}

	public List<SysMenu> getParentMenuList() {
		return parentMenuList;
	}

	public void setParentMenuList(List<SysMenu> parentMenuList) {
		this.parentMenuList = parentMenuList;
	}

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getJobNo() {
		return jobNo;
	}

	public void setJobNo(String jobNo) {
		this.jobNo = jobNo;
	}

	public List<K3User> getK3UserList() {
		return k3UserList;
	}

	public void setK3UserList(List<K3User> k3UserList) {
		this.k3UserList = k3UserList;
	}

	public K3User getK3User() {
		return k3User;
	}

	public void setK3User(K3User k3User) {
		this.k3User = k3User;
	}

}
