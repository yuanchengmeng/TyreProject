package com.kexun.wm.sale.service.impl;

import java.util.List;

import com.kexun.wm.sale.bean.Standard;
import com.kexun.wm.sale.dao.StandardDao;
import com.kexun.wm.sale.dao.impl.StandardDaoImpl;
import com.kexun.wm.sale.service.StandardService;

public class StandardServiceImpl implements StandardService {
	private StandardDao dao = new StandardDaoImpl();

	public int saveStandard(Standard standard) throws Exception {
		return dao.saveStandard(standard);
	}

	public Standard getStandardById(int id) throws Exception {
		return dao.getStandardById(id);
	}

	public Standard getStandardByCode(Standard standard) throws Exception {
		return dao.getStandardByCode(standard);
	}
	
	public Standard getStandardByName(Standard standard) throws Exception {
		return dao.getStandardByName(standard);
	}

	public int deleteStandard(int id) throws Exception {
		return dao.deleteStandard(id);
	}

	public int updateStandard(Standard standard) throws Exception {
		return dao.updateStandard(standard);
	}

	public List<Standard> queryStandard(Standard standard, int pageNo, int pageSize)
			throws Exception {
		return dao.queryStandard(standard, pageNo, pageSize);
	}

	public List<Standard> queryStandardSize(Standard standard) throws Exception {
		return dao.queryStandardSize(standard);
	}
	
	public Standard queryStandardByCode(Standard standard) throws Exception{
		return dao.queryStandardByCode(standard);
	}

	public Standard queryStandardByName(Standard standard) throws Exception{
		return dao.queryStandardByName(standard);
	}
}
