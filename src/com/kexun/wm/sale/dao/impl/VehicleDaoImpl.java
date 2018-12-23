/**
 * 
 */
package com.kexun.wm.sale.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.sale.bean.Standard;
import com.kexun.wm.sale.bean.Vehicle;
import com.kexun.wm.sale.dao.VehicleDao;
import com.kexun.wm.untils.HibernateUtil;

/**
 * @author Administrator
 * 
 */
public class VehicleDaoImpl implements VehicleDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();

	public String queryVehicleByNo(String vehicleNo) throws Exception {
		List<Vehicle> vehicleList = null;
 		Session session = null;
 		Standard b=null;
 		String carNos = "";
		try {
			session = sf.openSession();
			String hql = "from Vehicle where vehicleNo like '%" + vehicleNo + "%'";
			Query query = session.createQuery(hql);
			vehicleList = query.list();
			if (vehicleList.size() > 0) {
				carNos = ""+vehicleList.get(0).getId();
				for(int i=1; i<vehicleList.size();i++){
					carNos =carNos + ","+vehicleList.get(i).getId();
				}
 			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return carNos;
	}

}
