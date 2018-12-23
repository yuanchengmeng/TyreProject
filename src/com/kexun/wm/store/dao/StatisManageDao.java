package com.kexun.wm.store.dao;

import java.util.List;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;

public interface StatisManageDao {

	public List<StandardStatisVo> queryStandardStatis(StatisParams params, int pageNo, int pageSize) throws Exception;
	
	 
}
