package com.kexun.wm.store.bean;

import java.io.Serializable;

/**
 * 规格统计vo
 * @author Administrator
 *
 */
public class StoreStatisVo implements Serializable{
	private long inStoreAmount;//入库数量
	private long outStoreAmount;//出库数量
    private long storeAmount;//库存数量
	public long getInStoreAmount() {
		return inStoreAmount;
	}
	public void setInStoreAmount(long inStoreAmount) {
		this.inStoreAmount = inStoreAmount;
	}
	public long getOutStoreAmount() {
		return outStoreAmount;
	}
	public void setOutStoreAmount(long outStoreAmount) {
		this.outStoreAmount = outStoreAmount;
	}
	public long getStoreAmount() {
		return storeAmount;
	}
	public void setStoreAmount(long storeAmount) {
		this.storeAmount = storeAmount;
	}
    
}
