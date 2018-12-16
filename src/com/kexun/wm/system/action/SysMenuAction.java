package com.kexun.wm.system.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kexun.wm.page.PageBean;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.system.bean.SysMenu;
import com.kexun.wm.system.service.SysMenuService;
import com.kexun.wm.system.service.impl.SysMenuServiceImpl;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Frank
 * @date 2014-9-26 下午3:34:29
 */
public class SysMenuAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysMenu sysMenu;
	private String sysMenuname = "";
	private SysMenuService sysMenuService = new SysMenuServiceImpl();
	private List<SysMenu> sysMenuList = null;
	private List<SysMenu> psysMenuList = null;
	private PageBean pageBean;
	private String ids;
	private String flag;
	private int page = 1;
	private int pageSize = 5;
	private int totalPage;
	private List<PageSize> pageSizeList = null;

 	public String initSysMenu() throws Exception {
		if ("query".equals(flag)) {
			return "querySysMenu";
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			sysMenuname = new String(sysMenuname.getBytes("ISO-8859-1"),
					"utf-8");
			sysMenu = new SysMenu();
			psysMenuList = sysMenuService.findParentMenus();
			return "sysMenuForm";
		}
	}

	/**
	 * 添加
	 * 
	 * @return
	 * @throws Exception
	 */
	public String addSysMenu() throws Exception {
 		sysMenuService.saveSysMenu(sysMenu);
 		return SUCCESS;
	}

	/**
	 * 查找所有记录
	 * 
	 * @return
	 * @throws Exception
	 */
	public String findSysMenu() throws Exception {
		if (page == 0) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		sysMenuname = new String(sysMenuname.getBytes("ISO-8859-1"), "utf-8");
		sysMenu = new SysMenu(sysMenuname);
		pageSizeList = AllSelectItemUtil.queryPageSize();
		pageBean = sysMenuService.findSysMenus(sysMenu, pageSize, page);
		totalPage = pageBean.getTotalPage();
		sysMenuList = pageBean.getList();
		return SUCCESS;
	}

	/**
	 * 根据 ID 获得
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSysMenuById() throws Exception {
		sysMenu = sysMenuService.getSysMenuById(sysMenu.getId());
		HttpServletRequest request = ServletActionContext.getRequest();
		sysMenuname = new String(sysMenuname.getBytes("ISO-8859-1"), "utf-8");
		if ("modify".equals(flag)) {
			psysMenuList = sysMenuService.findParentMenus();
			return "sysMenuModify";
		} else {
			return "sysMenuDtl";
		}
	}

	/**
	 * 修改
	 * 
	 * @return
	 * @throws Exception
	 */
	public String modifySysMenu() throws Exception {
		SysMenu menu = sysMenuService.getSysMenuById(sysMenu.getId());
		sysMenu.setSysRoles(menu.getSysRoles());
		sysMenuService.updateSysMenu(sysMenu);
 		return SUCCESS;
	}

	/**
	 * 删除
	 * 
	 * @return
	 * @throws Exception
	 */
	public String deleteSysMenu() throws Exception {
		String[] s = ids.split(",");
		int[] id = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			id[i] = Integer.parseInt(s[i]);
		}
		sysMenuService.deleteSysMenu(id);
		HttpServletRequest request = ServletActionContext.getRequest();
		sysMenuname = new String(sysMenuname.getBytes("ISO-8859-1"), "utf-8");
 		return SUCCESS;
	}

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	public SysMenuService getSysMenuService() {
		return sysMenuService;
	}

	public void setSysMenuService(SysMenuService sysMenuService) {
		this.sysMenuService = sysMenuService;
	}

	public List<SysMenu> getSysMenuList() {
		return sysMenuList;
	}

	public void setSysMenuList(List<SysMenu> sysMenuList) {
		this.sysMenuList = sysMenuList;
	}

	public List<SysMenu> getPsysMenuList() {
		return psysMenuList;
	}

	public void setPsysMenuList(List<SysMenu> psysMenuList) {
		this.psysMenuList = psysMenuList;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
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

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public String getSysMenuname() {
		return sysMenuname;
	}

	public void setSysMenuname(String sysMenuname) {
		this.sysMenuname = sysMenuname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	// public String getParent_menu_id() {
	// return parent_menu_id;
	// }
	//
	// public void setParent_menu_id(String parent_menu_id) {
	// this.parent_menu_id = parent_menu_id;
	// }
}
