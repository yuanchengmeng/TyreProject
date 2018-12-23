package com.kexun.wm.sale.service.impl;

import com.kexun.wm.sale.dao.VehicleDao;
import com.kexun.wm.sale.dao.impl.VehicleDaoImpl;
import com.kexun.wm.sale.service.VehicleService;

public class VehicleServiceImpl implements VehicleService {
	private VehicleDao dao = new VehicleDaoImpl();

	public String queryVehicleByNo(String vehicleNo) throws Exception {
		// TODO Auto-generated method stub
		return dao.queryVehicleByNo(vehicleNo);
	}
	 
}
