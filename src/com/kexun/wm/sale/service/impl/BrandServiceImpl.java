package com.kexun.wm.sale.service.impl;

import java.util.List;

import com.kexun.wm.sale.bean.Brand;
import com.kexun.wm.sale.dao.BrandDao;
import com.kexun.wm.sale.dao.impl.BrandDaoImpl;
import com.kexun.wm.sale.service.BrandService;

public class BrandServiceImpl implements BrandService {
	private BrandDao dao = new BrandDaoImpl();

	public int saveBrand(Brand brand) throws Exception {
		return dao.saveBrand(brand);
	}

	public Brand getBrandById(int id) throws Exception {
		return dao.getBrandById(id);
	}

	public Brand getBrandByElse(Brand brand) throws Exception {
		return dao.getBrandByElse(brand);
	}

	public int deleteBrand(int id) throws Exception {
		return dao.deleteBrand(id);
	}

	public int updateBrand(Brand brand) throws Exception {
		return dao.updateBrand(brand);
	}

	public List<Brand> queryBrand(Brand brand, int pageNo, int pageSize)
			throws Exception {
		return dao.queryBrand(brand, pageNo, pageSize);
	}

	public List<Brand> queryBrandSize(Brand brand) throws Exception {
		return dao.queryBrandSize(brand);
	}

}
