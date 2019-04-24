package com.kexun.wm.store.dao;

import java.util.List;

import com.kexun.wm.sale.bean.Product;
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
	
	/**
	 * 查询规格统计（入库、出库、库存）
	 * @param params
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	List<Object[]> queryStoreStatis(StatisParams params, int pageNo, int pageSize) throws Exception;
	
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
	List<Object[]> queryAllStoreStatis(StatisParams params) throws Exception;
	
	/**
	 * 通过名称查询规格
	 * @param params
	 * @return
	 * @throws Exception
	 */
	List<Product> queryProductByName(String productName) throws Exception;
}
