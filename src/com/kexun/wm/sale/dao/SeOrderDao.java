package com.kexun.wm.sale.dao;

import java.util.List;

import com.kexun.wm.sale.bean.Carton;
import com.kexun.wm.sale.bean.SeOrder;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.sale.bean.Vehicle;

public interface SeOrderDao {
	public int saveSeOrder(SeOrder seOrder) throws Exception;

	public List<SeOrderEntry> querySeOrderEntry(SeOrder seOrder) throws Exception;

	public int updateSeOrder(SeOrder seOrder) throws Exception;

	public List<SeOrder> querySeOrder(SeOrder seOrder, int pageNo, int pageSize) throws Exception;
	
	public int getSeOrderIdByNo(String fbillNo) throws Exception;

	public SeOrder findSeOrderById(int id) throws Exception;
	
	public SeOrderEntry findSeOrderEntryById(int id) throws Exception;

	public int queryAllRows(SeOrder seOrder) throws Exception;
	
	public int getAllBarcode(SeOrder seOrder) throws Exception;
	
	public int getAllBarcode(SeOrder seOrder, SeOrderEntry seOrderEntry) throws Exception;
	
	public List<Vehicle> queryVehicleByOrderId(int id) throws Exception;
	
	public List<Carton> queryCartonByOrderId(int id) throws Exception;
	
	public int saveVehicle(Vehicle vehicle) throws Exception;

	public int updateVehicle(Vehicle vehicle) throws Exception;
	
	public int deleteSomeVehicle(String ids,int orderID) throws Exception;
	
	public int deleteSomeCarton(String ids,int orderID) throws Exception;
	
	public Vehicle queryRepeatVehicle(String vehicleNo,int finterID) throws Exception;
	
	public int saveCarton(Carton carton) throws Exception;
	
	public Carton queryRepeatCarton(String cartonNo,int vehicleID,int finterID) throws Exception;

}
