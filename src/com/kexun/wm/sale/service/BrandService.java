package com.kexun.wm.sale.service;

import java.util.List;

import com.kexun.wm.sale.bean.Brand;

public interface BrandService {
	public int saveBrand(Brand brand) throws Exception;

	public Brand getBrandById(int id) throws Exception;

	public Brand getBrandByElse(Brand brand) throws Exception;

	public int deleteBrand(int id) throws Exception;

	public int updateBrand(Brand brand) throws Exception;

	public List<Brand> queryBrand(Brand brand, int pageNo, int pageSize)
			throws Exception;

	public List<Brand> queryBrandSize(Brand brand) throws Exception;
}
