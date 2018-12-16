package com.kexun.wm.sale.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kexun.wm.sale.bean.CodeTrans;
import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.service.CodeTransService;
import com.kexun.wm.sale.service.impl.CodeTransServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;

public class CodeTransAction {
	static Log log = LogFactory.getLog(CodeTransAction.class);
	private CodeTrans codeTrans=new CodeTrans();
	private CodeTransService codeTransService = new CodeTransServiceImpl();
	private List<CodeTrans> codeTransList = new ArrayList<CodeTrans>();
	private List<CodeTrans> codeTransList1 = new ArrayList<CodeTrans>();
	private List<Product> productList;
//	private String nameId = "";
	private String flag;
	private String ids;
	private int recordCount;
	private int pageCount = 1;
	private int pageNo = 1;
//	private int result1 = 0;
//	private int result2 = 0;
	private int pageSize;
	private List<PageSize> pageSizeList;

	public String queryCodeTrans() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		recordCount = codeTransService.queryAllRows(codeTrans);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		codeTransList = codeTransService.queryCodeTrans(codeTrans, pageNo, pageSize);
		if(codeTrans.getFlag()==1){
			return "queryStandard";
		}
		if(codeTrans.getFlag()==2){
			return "queryBrand";
		}
		return "queryCodeTrans";
	}

	public String lastPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = codeTransService.queryAllRows(codeTrans);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		codeTransList = codeTransService.queryCodeTrans(codeTrans, --pageNo,
				pageSize);
		 
		if(codeTrans.getFlag()==1){
			return "queryStandard";
		}
		if(codeTrans.getFlag()==2){
			return "queryBrand";
		}
		return "queryCodeTrans"; 
	}

	public String nextPage() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = codeTransService.queryAllRows(codeTrans);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		codeTransList = codeTransService.queryCodeTrans(codeTrans, ++pageNo,
				pageSize);
		if(codeTrans.getFlag()==1){
			return "queryStandard";
		}
		if(codeTrans.getFlag()==2){
			return "queryBrand";
		}
		return "queryCodeTrans"; 
	}

	/*
	 * 停用：在金蝶数据库获取规格
	 * public void updateCodeTrans() throws Exception {
		System.out.println("正在更新...");
		productList = codeTransService.queryProduct();
		for(int i=0;i<productList.size();i++){
			if(productList.get(i).getFName()!=null && !"".equals(productList.get(i).getFName())){
				int standardCount=codeTransService.getCodeTransByName(productList.get(i).getFName(),1).size();
				int brandCount=codeTransService.getCodeTransByName(productList.get(i).getFName(),2).size();
				int count1=codeTransService.getCodeTransByName("",1).size();
				int count2=codeTransService.getCodeTransByName("",2).size();
				int proLen=productList.get(i).getFNumber().length();//規格長度
				String str="";
				if( standardCount+brandCount==0 ){
					if(proLen==4 || proLen==14){
						if(proLen==4){//規格
							 str=AllSelectItemUtil.formatCode("000",count1+1);
		 					 codeTrans.setFlag(1);
		 				}
		                if(proLen==14){//品牌
		                	 str=AllSelectItemUtil.formatCode("00",count2+1);
							 codeTrans.setFlag(2);
						}
		                codeTrans.setCtime(AllSelectItemUtil.getNowTime());
		                codeTrans.setCode(str);
		                codeTrans.setName(productList.get(i).getFName());
		                codeTransService.saveCodeTrans(codeTrans);
					}
	 			}
			}
		}
		for(int i=0;i<productList.size();i++){
			 if(productList.get(i).getFFullName()!=null && !"".equals(productList.get(i).getFFullName())){
				 int count=codeTransService.getCodeTransByName(productList.get(i).getFFullName(),3).size();
				 if(count==0){
					 if(productList .get(i).getFFullName().split("_").length==3){
						 codeTransList=codeTransService.getCodeTransByName(productList .get(i).getFFullName().split("_")[0], 1);
						 codeTransList1=codeTransService.getCodeTransByName(productList .get(i).getFFullName().split("_")[2], 2);
						 if(codeTransList.size()>0 && codeTransList1.size()>0){
							 String str1=codeTransList.get(0).getCode();
							 String str2=codeTransList1.get(0).getCode();
							 codeTrans.setFlag(3);
							 codeTrans.setCtime(AllSelectItemUtil.getNowTime());
							 codeTrans.setName(productList.get(i).getFFullName());
						     codeTrans.setCode(str1+str2);
						     codeTransService.saveCodeTrans(codeTrans);
						 }
					 }
				 }
			 }
		}
		System.out.println("更新完毕！！");
	}
*/
	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		CodeTransAction.log = log;
	}

	public CodeTrans getCodeTrans() {
		return codeTrans;
	}

	public void setCodeTrans(CodeTrans codeTrans) {
		this.codeTrans = codeTrans;
	}

	public CodeTransService getCodeTransService() {
		return codeTransService;
	}

	public void setCodeTransService(CodeTransService codeTransService) {
		this.codeTransService = codeTransService;
	}

	public List<CodeTrans> getCodeTransList() {
		return codeTransList;
	}

	public void setCodeTransList(List<CodeTrans> codeTransList) {
		this.codeTransList = codeTransList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
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

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
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

	public List<CodeTrans> getCodeTransList1() {
		return codeTransList1;
	}

	public void setCodeTransList1(List<CodeTrans> codeTransList1) {
		this.codeTransList1 = codeTransList1;
	}
	
}
