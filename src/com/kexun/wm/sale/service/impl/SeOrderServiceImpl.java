package com.kexun.wm.sale.service.impl;

import java.util.List;

import com.kexun.wm.sale.bean.Carton;
import com.kexun.wm.sale.bean.SeOrder;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.sale.bean.Vehicle;
import com.kexun.wm.sale.dao.SeOrderDao;
import com.kexun.wm.sale.dao.impl.SeOrderDaoImpl;
import com.kexun.wm.sale.service.SeOrderService;

public class SeOrderServiceImpl  implements SeOrderService{
    private SeOrderDao dao=new SeOrderDaoImpl();
	public int saveSeOrder(SeOrder seOrder) throws Exception {
		return dao.saveSeOrder(seOrder);
	}

	public int updateSeOrder(SeOrder seOrder) throws Exception {
		return dao.updateSeOrder(seOrder);
	}

	public List<SeOrder> querySeOrder(SeOrder seOrder, int pageNo,
			int pageSize) throws Exception {
		return dao.querySeOrder(seOrder, pageNo, pageSize);
	}

	public int queryAllRows(SeOrder seOrder) throws Exception {
		return dao.queryAllRows(seOrder);
	}

	public List<SeOrderEntry> querySeOrderEntry(SeOrder seOrder)
			throws Exception {
		return dao.querySeOrderEntry(seOrder);
	}
	
	public int getAllBarcode(SeOrder seOrder) throws Exception{
		return dao.getAllBarcode(seOrder);
	}
	
	public int getAllBarcode(SeOrderEntry seOrderEntry) throws Exception{
		return dao.getAllBarcode(seOrderEntry);
	}
	
	public SeOrderEntry findSeOrderEntryById(int id) throws Exception{
		return dao.findSeOrderEntryById(id);
	}
	
	public SeOrder findSeOrderById(int id) throws Exception{
		return dao.findSeOrderById(id);
	}
	
	public int getSeOrderIdByNo(String fbillNo) throws Exception{
		return dao.getSeOrderIdByNo(fbillNo);
	}
	
	public List<Vehicle> queryVehicleByOrderId(int id) throws Exception{
		return dao.queryVehicleByOrderId(id);
	}
	
	public List<Carton> queryCartonByOrderId(int id) throws Exception{
		return dao.queryCartonByOrderId(id);
	}
	
	public int saveVehicle(Vehicle vehicle) throws Exception{
		return dao.saveVehicle(vehicle);
	}
	
	public int saveCarton(Carton carton) throws Exception{
		return dao.saveCarton(carton);
	}

	public int updateVehicle(Vehicle vehicle) throws Exception{
		return dao.updateVehicle(vehicle);
	}
	
	public int deleteSomeVehicle(String ids,int orderID) throws Exception{
		return dao.deleteSomeVehicle(ids,orderID);
	}
	
	public int deleteSomeCarton(String ids,int orderID) throws Exception{
		return dao.deleteSomeCarton(ids,orderID);
	}
	
	public Vehicle queryRepeatVehicle(String vehicleNo,int finterID) throws Exception{
		return  dao.queryRepeatVehicle(vehicleNo,finterID);
	}
	
	public Carton queryRepeatCarton(String cartonNo,int vehicleID,int finterID) throws Exception{
		return  dao.queryRepeatCarton(cartonNo,vehicleID,finterID);
	}
}
