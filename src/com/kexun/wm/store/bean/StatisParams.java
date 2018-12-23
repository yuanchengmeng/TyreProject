package com.kexun.wm.store.bean;

/**
 * 规格参数
 * @author Administrator
 *
 */
public class StatisParams {
    private String timeStart;//统计开始时间
	private String timeEnd;//统计结束时间
	private String person;//操作员
	
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	
}
