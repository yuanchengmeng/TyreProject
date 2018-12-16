package com.kexun.wm.sale.dao;

import java.util.List;

import com.kexun.wm.sale.bean.Brand;

public interface BrandDao {

	public int saveBrand(Brand brand) throws Exception;

	public Brand getBrandById(int id) throws Exception;

	public Brand getBrandByElse(Brand brand) throws Exception;

	public int deleteBrand(int id) throws Exception;

	public int updateBrand(Brand brand) throws Exception;

	public List<Brand> queryBrand(Brand brand, int pageNo, int pageSize)
			throws Exception;

	public List<Brand> queryBrandSize(Brand brand) throws Exception;
}
