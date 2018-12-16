package com.kexun.wm.sale.service.impl;

import java.util.List;

import com.kexun.wm.sale.bean.CodeTrans;
import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.dao.CodeTransDao;
import com.kexun.wm.sale.dao.impl.CodeTransDaoImpl;
import com.kexun.wm.sale.service.CodeTransService;

public class CodeTransServiceImpl implements CodeTransService {
	private CodeTransDao dao = new CodeTransDaoImpl();

	public int saveCodeTrans(CodeTrans codeTrans) throws Exception {
		return dao.saveCodeTrans(codeTrans);
	}

	public List<CodeTrans> queryCodeTrans(CodeTrans codeTrans, int pageNo, int pageSize) throws Exception {
		return dao.queryCodeTrans(codeTrans, pageNo, pageSize);
	}

	public int queryAllRows(CodeTrans codeTrans) throws Exception {
		return dao.queryAllRows(codeTrans);
	}
	
	public List<Product> queryProduct() throws Exception{
		return dao.queryProduct();
	}

	public List<CodeTrans> getCodeTransByName(String name, int flag) throws Exception {
		return dao.getCodeTransByName(name,flag);
	}

}
