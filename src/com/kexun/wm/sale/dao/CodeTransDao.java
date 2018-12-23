package com.kexun.wm.sale.dao;

import java.util.List;

import com.kexun.wm.sale.bean.CodeTrans;
import com.kexun.wm.sale.bean.Product;

public interface CodeTransDao {
	public int saveCodeTrans(CodeTrans codeTrans) throws Exception;

	public List<CodeTrans> queryCodeTrans(CodeTrans codeTrans, int pageNo, int pageSize)throws Exception;

	public int queryAllRows(CodeTrans codeTrans) throws Exception;
	
	public List<CodeTrans> getCodeTransByName(String name,int flag) throws Exception;
	
	public List<Product> queryProduct() throws Exception;
	
}
