package com.kexun.wm.store.service;

import java.util.List;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;
import com.kexun.wm.store.bean.StoreStatisVo;

public interface StatisManageService {

	List<StandardStatisVo> queryStandardStatis(StatisParams params, int pageNo, int pageSize) throws Exception;
	
	int queryStandardStatisSize(StatisParams params) throws Exception;
	
	List<StandardStatisVo> queryAllStandardStatis(StatisParams params) throws Exception;
	
	/**
	 * 查询库存数量
	 * @param params
	 * @return
	 * @throws Exception
	 */
	StoreStatisVo queryStoreAmount(StatisParams params) throws Exception;
	
	/**
	 * 查询规格统计（入库、出库、库存）
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<StandardStatisVo> queryStoreStatis(StatisParams params, int pageNo, int pageSize) throws Exception;
	
	/**
	 * 查询规格总数量（入库、出库、库存）
	 * @param params
	 * @return
	 * @throws Exception
	 */
	int queryStoreStatisSize(StatisParams params) throws Exception;
	
	/**
	 * 查询所有数据--导出用
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<StandardStatisVo> queryAllStoreStatis(StatisParams params) throws Exception;
}
