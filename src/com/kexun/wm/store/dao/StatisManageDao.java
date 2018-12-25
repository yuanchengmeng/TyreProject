package com.kexun.wm.store.dao;

import java.util.List;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;

public interface StatisManageDao {

	List<StandardStatisVo> queryStandardStatis(StatisParams params, int pageNo, int pageSize) throws Exception;
	
	int queryStandardStatisSize(StatisParams params) throws Exception;
	
	List<StandardStatisVo> queryAllStandardStatis(StatisParams params) throws Exception;
	
	/**
	 * 查询入库数量
	 * @param params
	 * @return
	 * @throws Exception
	 */
	long queryInStoreAmount(StatisParams params) throws Exception;
	
	/**
	 * 查询出库数量
	 * @param params
	 * @return
	 * @throws Exception
	 */
	long queryOutStoreAmount(StatisParams params) throws Exception;
	
	/**
	 * 查询库存数量
	 * @param params
	 * @return
	 * @throws Exception
	 */
	long queryStoreAmount(StatisParams params) throws Exception;
}
