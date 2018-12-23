package com.kexun.wm.store.service.impl;

import java.util.List;

import com.kexun.wm.store.bean.StandardStatisVo;
import com.kexun.wm.store.bean.StatisParams;
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
}
