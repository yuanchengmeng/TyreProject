package com.kexun.wm.store.service;

import java.util.List;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;

public interface StatisManageService {

	List<StandardStatisVo> queryStandardStatis(StatisParams params, int pageNo, int pageSize) throws Exception;
	
	int queryStandardStatisSize(StatisParams params) throws Exception;
	
	List<StandardStatisVo> queryAllStandardStatis(StatisParams params) throws Exception;
}
