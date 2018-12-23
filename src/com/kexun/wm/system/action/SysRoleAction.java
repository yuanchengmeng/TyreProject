package com.kexun.wm.system.action;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.system.bean.SysMenu;
import com.kexun.wm.system.bean.SysRole;
import com.kexun.wm.system.service.SysMenuService;
import com.kexun.wm.system.service.SysRoleService;
import com.kexun.wm.system.service.impl.SysMenuServiceImpl;
import com.kexun.wm.system.service.impl.SysRoleServiceImpl;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Frank
 * @date 2014-9-29 上午9:28:33
 */
public class SysRoleAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private SysRole sysRole;
	private Set<SysMenu> menuList;
	private SysMenu sysMenu;
	private String sysRolename = "";
	private int recordCount;// 总条数
	private int pageCount = 1;// 总页数
	private int pageNo = 1;// 当前页数
	private int pageSize;
	private List<PageSize> pageSizeList;
	private List<SysRole> sysRoleList;
	private SysRoleService sysRoleService = new SysRoleServiceImpl();
	private SysMenuService sysMenuService = new SysMenuServiceImpl();
	private List<SysMenu> sysMenuList;
	private String flag;
	private String ids = "";

	public String initSysRole() throws Exception {
		if ("query".equals(flag)) {
			return "querySysRole";
		} else {
			HttpServletRequest request = ServletActionContext.getRequest();
			sysRolename = new String(sysRolename.getBytes("ISO-8859-1"),
					"utf-8");
			sysMenuList = sysMenuService.findSysMenus();
			return "sysRoleForm";
		}
	}

	public String addSysRole() throws Exception {
		String[] s = ids.split(",");
		menuList = new HashSet<SysMenu>();
		int[] id = new int[s.length];
		for (int i = 0; i < id.length; i++) {
			id[i] = Integer.parseInt(s[i]);
			sysMenu = sysMenuService.getSysMenuById(id[i]);
			menuList.add(sysMenu);
		}
		sysRole.setSysMenus(menuList);
		sysRoleService.saveSysRole(sysRole);
		ShowMessageUtil.showAddSuccess();
 		sysMenuList = sysMenuService.findSysMenus();
		return "sysRole";
	}

	public String findSysRole() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		HttpServletRequest request = ServletActionContext.getRequest();
		sysRole = new SysRole(new String(sysRolename.getBytes("ISO-8859-1"),
				"utf-8"));
		if (pageSize==0) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		sysRoleList = sysRoleService.findSysRoles(sysRole, pageNo, pageSize);
		recordCount = sysRoleService.queryAllRows(sysRole);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		return SUCCESS;
	}

	public String lastPage() throws Exception {
		// 每一页显示的几条记录
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = sysRoleService.queryAllRows(sysRole);

		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		sysRoleList = sysRoleService.findSysRoles(sysRole, --pageNo, pageSize);
		return "querySysRole";
	}

	public String nextPage() throws Exception {
		// 每一页显示的几条记录
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = sysRoleService.queryAllRows(sysRole);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		sysRoleList = sysRoleService.findSysRoles(sysRole, ++pageNo, pageSize);
		return "querySysRole";
	}

	public String getSysRoleById() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		sysRolename = new String(sysRolename.getBytes("ISO-8859-1"), "utf-8");
		sysMenuList = sysMenuService.findSysMenus();
		sysRole = sysRoleService.getSysRoleById(sysRole.getId());
		Iterator<SysMenu> ite = sysRole.getSysMenus().iterator();
		while (ite.hasNext()) {
			ids += ite.next().getId() + ",";
		}
		if ("modify".equals(flag)) {
			return "sysRoleModify";
		} else {
			return "sysMenuDtl";
		}
	}

	public String modifySysMenu() throws Exception {
		String[] s = ids.split(",");
		menuList = new HashSet<SysMenu>();
		int[] id = new int[s.length];
		for (int i = 0; i < id.length; i++) {
			id[i] = Integer.parseInt(s[i]);
			sysMenu = sysMenuService.getSysMenuById(id[i]);
			menuList.add(sysMenu);
		}
		sysRole.setSysMenus(menuList);
		sysRoleService.updateSysRole(sysRole);
		ShowMessageUtil.showModifySuccess();
		sysMenuList = sysMenuService.findSysMenus();
		return "sysRole";
	}

	public String deleteSysRole() throws Exception {
		String[] s = ids.split(",");
		int[] id = new int[s.length];
		for (int i = 0; i < s.length; i++) {
			id[i] = Integer.parseInt(s[i]);
			sysRoleService.deleteSysRole(id[i]);
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		sysRolename = new String(sysRolename.getBytes("ISO-8859-1"), "utf-8");
		ShowMessageUtil.showDeleteSuccess();
		return SUCCESS;
	}

	public SysRole getSysRole() {
		return sysRole;
	}

	public void setSysRole(SysRole sysRole) {
		this.sysRole = sysRole;
	}

	public List<SysRole> getSysRoleList() {
		return sysRoleList;
	}

	public void setSysRoleList(List<SysRole> sysRoleList) {
		this.sysRoleList = sysRoleList;
	}

	public SysRoleService getSysRoleService() {
		return sysRoleService;
	}

	public void setSysRoleService(SysRoleService sysRoleService) {
		this.sysRoleService = sysRoleService;
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

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public Set<SysMenu> getMenuList() {
		return menuList;
	}

	public void setMenuList(Set<SysMenu> menuList) {
		this.menuList = menuList;
	}

	public SysMenu getSysMenu() {
		return sysMenu;
	}

	public void setSysMenu(SysMenu sysMenu) {
		this.sysMenu = sysMenu;
	}

	public String getSysRolename() {
		return sysRolename;
	}

	public void setSysRolename(String sysRolename) {
		this.sysRolename = sysRolename;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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

}
