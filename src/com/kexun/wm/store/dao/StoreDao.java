package com.kexun.wm.store.dao;

import java.util.List;

import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.store.bean.SpecMap;
import com.kexun.wm.store.bean.Store;

public interface StoreDao {
	public int deleteStore(int id) throws Exception;

	// 库存信息
	public List<Store> queryStore(Store store, int pageNo, int pageSize) throws Exception;

	public int queryStoreSize(Store store) throws Exception;
	
	public SeOrderEntry getSeOrderEntryById(int finterID,int productID) throws Exception;

	public Product getProductById(int id) throws Exception;

	public Store getStoreById(int id) throws Exception;

	public int updateStore(Store store) throws Exception;
	
	public List<Store> queryCollectStore(Store store, int pageNo, int pageSize) throws Exception;
	
	public int queryCollectStoreSize(Store store) throws Exception;
	
	public int queryCollectCount(Store store) throws Exception;
	
	public List<Store> queryAllStore(Store store) throws Exception;
	
	public int getFCheckerID(int FInterID) throws Exception;
	
	public int updateICStockBillEntry(int FInterID,int FItemID) throws Exception;

	public int getFInterID() throws Exception;
	
	public int getICStockBillEntryCount(int FInterID) throws Exception;
	
	public int getFQty(int FInterID, int FItemID) throws Exception;
	
	public int getDefaultLoc(int ProductID) throws Exception;

	public int insertICStockBillEntry(int FInterID,int count, int FItemID,int loc) throws Exception;
	
	public int createFInterID() throws Exception;
	
	public String createBillNo() throws Exception;
	
	public int insertICStockBill(int FInterID,int k3User, int FBillID,String BillNo) throws Exception;
	
	public Product queryProductBySpecMap(SpecMap specMap) throws Exception;
	
	public SpecMap querySpecMapByBarcode(String Barcode) throws Exception;
	
	public Product queryProductByBarCode(String BarCode) throws Exception;
}
