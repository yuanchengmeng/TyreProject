package com.kexun.wm.page;

import java.util.List;

/**
 * @author Frank
 * @date 2014-9-22 上午11:02:08
 */
public class PageBean {

	private List list;// 要返回的某一页的记录列表
	private int allRow;// 总记录数
	private int totalPage;// 总记录数
	private int currentPage;// 当前页
	private int pageSize;// 每页记录数
	private boolean isFirstPage;// 是否为第一页
	private boolean isLastPage;// 是否为最后一页
	private boolean hasPreviousPage;// 是否有前一页
	private boolean hasNextPage;// 是否有下一页

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public int getAllRow() {
		return allRow;
	}

	public void setAllRow(int allRow) {
		this.allRow = allRow;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 以下判断页的信息，只需要getter方法（is方法）即可
	 */

	public boolean isFirstPage() {
		return currentPage == 1;
	}

	public boolean isLastPage() {
		return currentPage == totalPage;
	}

	public boolean isHasPreviousPage() {
		return currentPage != 1;
	}

	public boolean isHasNextPage() {
		return currentPage != totalPage;
	}
	
	/**
	 * 初始化方法
	 */
	public void init() {
		  this.isFirstPage = isFirstPage();
		  this.isLastPage = isLastPage();
		  this.hasPreviousPage = isHasPreviousPage();
		  this.hasNextPage = isHasNextPage();
	}

	/***************************************************************************
	  * 
	  * 计算总页数，静态方法，供外部直接通过类名调用 pageSize 每页记录数 allRow 总记录数
	  * 
	  * @return 总页数
	  */
	 public static int counTotalPage(final int pageSize, final int allRow) {
		  int totalPage = allRow % pageSize == 0 ? allRow / pageSize : allRow
		    / pageSize + 1;
		  return totalPage;
	 }

	 /***************************************************************************
	  * 
	  * 计算当前页开始记录 pageSize 每页记录数 currentPage 当前第几页
	  * 
	  * @return 当前页开始记录号
	  */
	 public static int countOffset(final int pageSize, final int currentPage) {
		  final int offset = pageSize * (currentPage - 1);
		  return offset;
	 }

	 /***************************************************************************
	  * 
	  * 计算当前页，若为0或者请求的URl中没有"?page=",则用1代替 page传入的参数（可能为空，即，则返回1）
	  * 
	  * @return 当前页
	  */
	 public static int countCurrentPage(int page) {
		  final int curPage = (page == 0 ? 1 : page);
		  return curPage;
	 }
	
}
