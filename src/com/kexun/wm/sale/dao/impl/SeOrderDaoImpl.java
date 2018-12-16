package com.kexun.wm.sale.dao.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.kexun.wm.sale.bean.Carton;
import com.kexun.wm.sale.bean.SeOrder;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.sale.bean.Vehicle;
import com.kexun.wm.sale.dao.SeOrderDao;
import com.kexun.wm.untils.HibernateUtil;
import com.kexun.wm.untils.HibernateUtilK3;

public class SeOrderDaoImpl implements SeOrderDao {
	private static SessionFactory sf = HibernateUtilK3.getSessionFactory();
	private static SessionFactory fy = HibernateUtil.getSessionFactory();
	public int saveSeOrder(SeOrder seOrder) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.save(seOrder);
			session.flush();
			return 1;
		} catch (HibernateException hi) {
			hi.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
	}

	public int updateSeOrder(SeOrder seOrder) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(seOrder);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null) {
				session.clear();
				session.close();
			}
		}
	}

	public List<SeOrder> querySeOrder(SeOrder seOrder, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<SeOrder> seOrderList1 = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from SeOrder where 1=1";
			if (seOrder != null) {
				if (seOrder.getFbillNo()!=null && !("").equals(seOrder.getFbillNo())) {
					hql = hql + " and fbillNo like '%" + seOrder.getFbillNo().trim() + "%'";
				}
				if (seOrder.getOrderDate1()!=null && !("").equals(seOrder.getOrderDate1())) {
					hql = hql + " and fdate >= '" + seOrder.getOrderDate1().trim() + "'";
				}
				if (seOrder.getOrderDate2()!=null && !("").equals(seOrder.getOrderDate2())) {
					hql = hql + " and fdate <= '" + seOrder.getOrderDate2().trim() + "'";
				}
			}
			hql = hql + " order by fdate desc";
			Query q = session.createQuery(hql);
			q.setFirstResult(beginPos);
			q.setMaxResults(pageSize);
			seOrderList1 = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.clear();
				session.close();
			}
		}
		return seOrderList1;
	}

	public int getSeOrderIdByNo(String fbillNo) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<SeOrder> seOrderList = null;
		int finterid=0;
		try {
			session = sf.openSession();
			String hql = "from SeOrder where fbillNo = '" + fbillNo.trim() + "'";
			Query q = session.createQuery(hql);
			seOrderList = q.list();
			if(seOrderList!=null && seOrderList.size()>0 && seOrderList.get(0)!=null){
				finterid = seOrderList.get(0).getFinterID();
			}
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return finterid;
	}
	
	public SeOrder findSeOrderById(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		SeOrder seOrder = null;
		try {
			session = sf.openSession();
			seOrder = (SeOrder) session.get(SeOrder.class,id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return seOrder;
	}

	public int queryAllRows(SeOrder seOrder) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		int result = 0;
		try {
			session = sf.openSession();
			String hql = "select count(*) from SeOrder where 1=1";
			if (seOrder != null) {
				if (!("").equals(seOrder.getFbillNo())&&seOrder.getFbillNo()!=null) {
					hql = hql + " and fbillNo like '%" + seOrder.getFbillNo().trim() + "%'";
				}
				if (seOrder.getOrderDate1()!=null && !("").equals(seOrder.getOrderDate1())) {
					hql = hql + " and fdate >= '" + seOrder.getOrderDate1().trim() + "'";
				}
				if (seOrder.getOrderDate2()!=null && !("").equals(seOrder.getOrderDate2())) {
					hql = hql + " and fdate <= '" + seOrder.getOrderDate2().trim() + "'";
				}
			}
			Query q = session.createSQLQuery(hql);
			List list = q.list();
			// BigInteger count = (BigInteger) list.get(0);
			result = (Integer) list.get(0);
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
	
	public List<SeOrderEntry> querySeOrderEntry(SeOrder seOrder) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		List<SeOrderEntry> seOrderEntryList = null;
		try {
			session = sf.openSession();
			String hql = "from SeOrderEntry where seOrder.finterID="+seOrder.getFinterID();
			Query q = session.createQuery(hql);
			seOrderEntryList = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return seOrderEntryList;
	}
	
	public int getAllBarcode(SeOrder seOrder) throws Exception {
		Session session = null;
		int result = 0;
		try {
			session = fy.openSession();
			String hql = "select count(*) from hand_store where StoreState='已出库' and OrderID="+seOrder.getFinterID();
 			Query q = session.createSQLQuery(hql);
 			result = (Integer) q.uniqueResult();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
	
	public int getAllBarcode(SeOrderEntry seOrderEntry) throws Exception {
		Session session = null;
		int result = 0;
		try {
			session = fy.openSession();
			String hql = "select count(*) from hand_store where StoreState='已出库' and OrderID="+seOrderEntry.getSeOrder().getFinterID()+" and ProductID="+seOrderEntry.getProduct().getFItemID();
 			Query q = session.createSQLQuery(hql);
 			result = (Integer) q.uniqueResult();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return result;
	}
	
	public SeOrderEntry findSeOrderEntryById(int id) throws Exception{
		Session session = null;
		SeOrderEntry seOrderEntry = null;
		try {
			session = sf.openSession();
			seOrderEntry = (SeOrderEntry) session.get(SeOrderEntry.class,id);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			if(session!=null)
				session.close();
		}
		return seOrderEntry;
	}
	
	public List<Vehicle> queryVehicleByOrderId(int id) throws Exception{
		Session session = null;
		List<Vehicle> vlist = null;
		try {
			session = fy.openSession();
			String hql = "from Vehicle where orderId="+id;
			Query q = session.createQuery(hql);
			vlist = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return vlist;
	}
	
	public List<Carton> queryCartonByOrderId(int id) throws Exception{
		Session session = null;
		List<Carton> clist = null;
		try {
			session = fy.openSession();
			String hql = "from Carton where orderId="+id;
			Query q = session.createQuery(hql);
		    clist = q.list();
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return clist;
	}
	
	public int saveVehicle(Vehicle vehicle) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = fy.openSession();
			session.save(vehicle);
			session.flush();
			return 1;
		} catch (HibernateException hi) {
			hi.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}
	
	public int saveCarton(Carton carton) throws Exception{
		Session session = null;
		try {
			session = fy.openSession();
			session.save(carton);
			session.flush();
			return 1;
		} catch (HibernateException hi) {
			hi.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.close();
		}
	}

	public int updateVehicle(Vehicle vehicle) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = fy.openSession();
			session.update(vehicle);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public int deleteSomeVehicle(String ids,int orderID) throws Exception{
		Session session = null;
		try {
			session = fy.openSession();
			String hql = "delete from Vehicle where id not in (" + ids+"0) and orderID="+orderID;
			Query q = session.createQuery(hql);
			q.executeUpdate();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null) {
			 session.close();
			}
		}
	}
	
	public int deleteSomeCarton(String ids,int orderID) throws Exception{
		Session session = null;
		try {
			session = fy.openSession();
			String hql = "delete from Carton where id not in (" + ids+"0) and orderId="+orderID;
			Query q = session.createQuery(hql);
			q.executeUpdate();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null) {
			 session.close();
			}
		}
	}
	
	public Vehicle queryRepeatVehicle(String vehicleNo,int finterID) throws Exception{
		Session session = null;
		List<Vehicle> vlist = null;
		Vehicle vehicle=null;
		try {
			session = fy.openSession();
			String hql = "from Vehicle where vehicleNo like '%"+vehicleNo+"%' and orderID="+finterID;
			Query q = session.createQuery(hql);
			vlist = q.list();
			if(vlist!=null && vlist.size()>0){
				vehicle=vlist.get(0);
			}
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return vehicle;
	}
	
	public Carton queryRepeatCarton(String cartonNo,int vehicleID,int finterID) throws Exception{
		Session session = null;
		List<Carton> clist = null;
		Carton carton=null;
		try {
			session = fy.openSession();
			String hql = "from Carton where cartonNo like '%"+cartonNo+"%' and vehicle.id="+vehicleID+" and orderId="+finterID;
			Query q = session.createQuery(hql);
			clist = q.list();
			if(clist!=null && clist.size()>0){
				carton=clist.get(0);
			}
		} catch (HibernateException hi) {
			hi.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return carton;
	}
}
