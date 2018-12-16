package com.kexun.wm.sale.action;

import java.util.List;

import com.kexun.wm.sale.bean.Brand;
import com.kexun.wm.sale.service.BrandService;
import com.kexun.wm.sale.service.impl.BrandServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;
import com.opensymphony.xwork2.ActionSupport;

public class BrandAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Brand brand;
	private BrandService brandService = new BrandServiceImpl();
	private String flag;
	private String ids;
	private String nameId = "";
	private int pageNo = 1;
	private int pageCount = 1;
	private int recordCount;
	private int pageSize;
	private List<PageSize> pageSizeList;
	private List<Brand> brandList;

	public String getBrandItem() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		return "brandForm";
	}

	public String addBrand() throws Exception {
		if (brandService.getBrandByElse(brand) == null) {
			brand.setCtime(AllSelectItemUtil.getNowTime());
			if(AllSelectItemUtil.getCurrentUser()==null){
				return "501";
			}
			brand.setCuser(AllSelectItemUtil.getCurrentUser().getJobNo()+AllSelectItemUtil.getCurrentUser().getName());
			int result = brandService.saveBrand(brand);
			if (result != 1) {
				ShowMessageUtil.showAddFalse();
				return "false";
			}
		}else{
			ShowMessageUtil.showRepeatMessage();
		}
		brand=new Brand();
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = brandService.queryBrandSize(brand).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
 		brandList = brandService.queryBrand(brand, pageNo,pageSize);
 		return "queryBrand";
	}

	public String getBrandById() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		brand = brandService.getBrandById(brand.getId());
		return "modify";
	}

	public String modifyBrand() throws Exception {
		brand.setCtime(AllSelectItemUtil.getNowTime());
		if(AllSelectItemUtil.getCurrentUser()==null){
			return "501";
		}
		brand.setCuser(AllSelectItemUtil.getCurrentUser().getJobNo()+AllSelectItemUtil.getCurrentUser().getName());
		
		if (brandService.getBrandByElse(brand) == null) {
			int result = brandService.updateBrand(brand);
			if (result != 1) {
				ShowMessageUtil.showModifyFalse();
				return "false";
			}
		}else{
			ShowMessageUtil.showRepeatMessage();
		}
		
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = brandService.queryBrandSize(brand).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		brandList = brandService.queryBrand(brand, pageNo,
				pageSize);
		return "queryBrand";
	}

	public String deleteBrand() throws Exception {
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		String id[] = ids.split(",");
		int result = 0;
		for (int i = 0; i < id.length; i++) {
			result += brandService.deleteBrand(Integer.parseInt(id[i]));
		}
		if (result == id.length) {
			pageSizeList = AllSelectItemUtil.queryPageSize();
			recordCount = brandService.queryBrandSize(brand).size();
			if (pageSize != 0) {
				pageCount = (recordCount + pageSize - 1) / pageSize;
			}
			brandList = brandService.queryBrand(brand, pageNo,
					pageSize);
			return "delete";
		} else {
			ShowMessageUtil.showDeleteFalse();
			return "false";
		}
	}

	public String queryBrand() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		recordCount = brandService.queryBrandSize(brand).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		brandList = brandService.queryBrand(brand, pageNo,
				pageSize);
		return "queryBrand";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = brandService.queryBrandSize(brand).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		brandList = brandService.queryBrand(brand, --pageNo,
				pageSize);
		return "queryBrand";
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = brandService.queryBrandSize(brand).size();
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		brandList = brandService.queryBrand(brand, ++pageNo,
				pageSize);
		return "queryBrand";
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public BrandService getBrandService() {
		return brandService;
	}

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public List<Brand> getBrandList() {
		return brandList;
	}

	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
