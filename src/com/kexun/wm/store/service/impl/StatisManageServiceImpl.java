package com.kexun.wm.store.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.jfree.chart.plot.dial.ArcDialFrame;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;
import com.kexun.wm.store.bean.StoreStatisVo;
import com.kexun.wm.store.dao.StatisManageDao;
import com.kexun.wm.store.dao.impl.StatisManageDaoImpl;
import com.kexun.wm.store.service.StatisManageService;
import com.kexun.wm.store.service.StoreService;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.system.service.SysUserService;
import com.kexun.wm.system.service.impl.SysUserServiceImpl;
import com.kexun.wm.untils.AllSelectItemUtil;

public class StatisManageServiceImpl implements StatisManageService {
	private StatisManageDao statisManageDao = new StatisManageDaoImpl();
	private StoreService storeService = new StoreServiceImpl();
	private SysUserService sysUserService = new SysUserServiceImpl();
	
	public List<StandardStatisVo> queryStandardStatis(StatisParams params, int pageNo, int pageSize) throws Exception{
		
		List<StandardStatisVo> standardList = statisManageDao.queryStandardStatis(params, pageNo, pageSize);
		if(null != standardList && standardList.size()> 0){
			for(StandardStatisVo standard: standardList){
				standard.setProduct(storeService.getProductById(standard.getProductID()));
				standard.setSysUser(sysUserService.findByName(standard.getPerson()));
				if("1".equals(standard.getStoreType())){
					standard.setStoreType("入库");
				}else{
					standard.setStoreType("出库");
				}
			}
		}
    	return standardList;
    }
	
	public int queryStandardStatisSize(StatisParams params) throws Exception{
		return statisManageDao.queryStandardStatisSize(params);
	}
	
	public List<StandardStatisVo> queryAllStandardStatis(StatisParams params) throws Exception{
		List<StandardStatisVo> standardList = statisManageDao.queryAllStandardStatis(params);
		if(null != standardList && standardList.size()> 0){
			for(StandardStatisVo standard: standardList){
				standard.setProduct(storeService.getProductById(standard.getProductID()));
				standard.setSysUser(sysUserService.findByName(standard.getPerson()));
				if("1".equals(standard.getStoreType())){
					standard.setStoreType("入库");
				}else{
					standard.setStoreType("出库");
				}
			}
		}
		return standardList;
	}

	public StoreStatisVo queryStoreAmount(StatisParams params) throws Exception {
		long inStoreAmount = statisManageDao.queryInStoreAmount(params);//入库数量
		long outStoreAmount = statisManageDao.queryOutStoreAmount(params);//出库数量
	    long storeAmount = statisManageDao.queryStoreAmount(params);//库存数量
	    StoreStatisVo vo = new StoreStatisVo();
	    vo.setInStoreAmount(inStoreAmount);
	    vo.setOutStoreAmount(outStoreAmount);
	    vo.setStoreAmount(storeAmount);
		return vo;
	}
	
public List<StandardStatisVo> queryStoreStatis(StatisParams params, int pageNo, int pageSize) throws Exception{
		List<StandardStatisVo> standardList = new ArrayList<StandardStatisVo>();
		List<Object[]> objecyList = statisManageDao.queryStoreStatis(params, pageNo, pageSize);
		if(null != objecyList && objecyList.size()> 0){
			for(Object[] objs: objecyList){
				StandardStatisVo standard = new StandardStatisVo();
				standard.setProduct(storeService.getProductById((Integer)objs[0]));
				standard.setAmount((Integer)objs[1]);
				if(0 == params.getStoreType()){
					standard.setStoreType("库存");
				}else if(1 == params.getStoreType()){
					standard.setStoreType("入库");
				}else if(2 == params.getStoreType()){
					standard.setStoreType("出库");
				}
				standardList.add(standard);
			}
		}
    	return standardList;
    }
	
	public int queryStoreStatisSize(StatisParams params) throws Exception{
		return statisManageDao.queryStoreStatisSize(params);
	}
	
	public List<StandardStatisVo> queryAllStoreStatis(StatisParams params) throws Exception{
		List<StandardStatisVo> standardList = new ArrayList<StandardStatisVo>();
		List<Object[]> objecyList = statisManageDao.queryAllStoreStatis(params);
		if(null != objecyList && objecyList.size()> 0){
			for(Object[] objs: objecyList){
				StandardStatisVo standard = new StandardStatisVo();
				standard.setProduct(storeService.getProductById((Integer)objs[0]));
				standard.setAmount((Integer)objs[1]);
				if(0 == params.getStoreType()){
					standard.setStoreType("库存");
				}else if(1 == params.getStoreType()){
					standard.setStoreType("入库");
				}else if(2 == params.getStoreType()){
					standard.setStoreType("出库");
				}
				standardList.add(standard);
			}
		}
    	return standardList;
	}
}
