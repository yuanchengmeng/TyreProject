package com.kexun.wm.store.service.impl;

import java.util.List;

import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.store.bean.SpecMap;
import com.kexun.wm.store.bean.Store;
import com.kexun.wm.store.dao.StoreDao;
import com.kexun.wm.store.dao.impl.StoreDaoImpl;
import com.kexun.wm.store.service.StoreService;

public class StoreServiceImpl implements StoreService {
	private StoreDao storeDao = new StoreDaoImpl();

	public List<Store> queryStore(Store store, int pageNo, int pageSize) throws Exception {
		return storeDao.queryStore(store, pageNo, pageSize);
	}

	public int queryStoreSize(Store store) throws Exception {
		return storeDao.queryStoreSize(store);
	}

	public SeOrderEntry getSeOrderEntryById(int finterID,int productID) throws Exception{
		return storeDao.getSeOrderEntryById(finterID,productID);
	}
 
	public Store getStoreById(int id) throws Exception {
		return storeDao.getStoreById(id);
	}

	public int updateStore(Store store) throws Exception {
		return storeDao.updateStore(store);
	}

	public int deleteStore(int id) throws Exception {
		return storeDao.deleteStore(id);
	}
	
	public Product getProductById(int id) throws Exception{
		return storeDao.getProductById(id);
	}

	public List<Store> queryCollectStore(Store store, int pageNo, int pageSize)
			throws Exception {
		return storeDao.queryCollectStore(store, pageNo, pageSize);
	}

	public int queryCollectStoreSize(Store store) throws Exception {
		return storeDao.queryCollectStoreSize(store);
	}

	public int queryCollectCount(Store store) throws Exception {
		return storeDao.queryCollectCount(store);
	}
	
	public List<Store> queryAllStore(Store store) throws Exception{
		return storeDao.queryAllStore(store);
	}

	public int getFCheckerID(int FInterID) throws Exception{
		return storeDao.getFCheckerID(FInterID);
	}

	public int updateICStockBillEntry(int FInterID, int FItemID)
			throws Exception {
 		return storeDao.updateICStockBillEntry(FInterID, FItemID);
	}
	
    public int getFInterID() throws Exception{
    	return storeDao.getFInterID();
    }
	
	public int getICStockBillEntryCount(int FInterID) throws Exception{
		return storeDao.getICStockBillEntryCount(FInterID);
	}
	
	public int getFQty(int FInterID, int FItemID) throws Exception{
		return storeDao.getFQty(FInterID, FItemID);
	}
	
	public int getDefaultLoc(int ProductID) throws Exception{
		return storeDao.getDefaultLoc(ProductID);
	}

	public int insertICStockBillEntry(int FInterID,int count, int FItemID,int loc) throws Exception{
		return storeDao.insertICStockBillEntry(FInterID, count, FItemID, loc);
	}
	
	public int createFInterID() throws Exception{
		return storeDao.createFInterID();
	}
	
	public String createBillNo() throws Exception{
		return storeDao.createBillNo();
	}
	
	public int insertICStockBill(int FInterID,int k3User, int FBillID,String BillNo) throws Exception{
		return storeDao.insertICStockBill(FInterID, k3User, FBillID, BillNo);
	}
	
	public Product queryProductBySpecMap(SpecMap specMap) throws Exception{
		return storeDao.queryProductBySpecMap(specMap);
	}
	
	public SpecMap querySpecMapByBarcode(String Barcode) throws Exception{
		return storeDao.querySpecMapByBarcode(Barcode);
	}
	
	public Product queryProductByBarCode(String BarCode) throws Exception{
		return storeDao.queryProductByBarCode(BarCode);
	}
}
