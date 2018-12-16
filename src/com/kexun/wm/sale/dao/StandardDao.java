package com.kexun.wm.sale.dao;

import java.util.List;

import com.kexun.wm.sale.bean.Standard;

public interface StandardDao {

	public int saveStandard(Standard standard) throws Exception;

	public Standard getStandardById(int id) throws Exception;

	public Standard getStandardByCode(Standard standard) throws Exception;

	public Standard getStandardByName(Standard standard) throws Exception;

	public Standard queryStandardByCode(Standard standard) throws Exception;

	public Standard queryStandardByName(Standard standard) throws Exception;

	public int deleteStandard(int id) throws Exception;

	public int updateStandard(Standard standard) throws Exception;

	public List<Standard> queryStandard(Standard standard, int pageNo,
			int pageSize) throws Exception;

	public List<Standard> queryStandardSize(Standard standard) throws Exception;
}
