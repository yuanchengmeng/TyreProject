package com.kexun.wm.store.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.util.List;

import org.apache.commons.lang.xwork.StringUtils;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.connection.ConnectionProvider;
import org.hibernate.engine.SessionFactoryImplementor;

import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.store.bean.SpecMap;
import com.kexun.wm.store.bean.Store;
import com.kexun.wm.store.dao.StoreDao;
import com.kexun.wm.untils.HibernateUtil;
import com.kexun.wm.untils.HibernateUtilK3;

public class StoreDaoImpl implements StoreDao {
	private static SessionFactory sf = HibernateUtil.getSessionFactory();
	private static SessionFactory fy = HibernateUtilK3.getSessionFactory();;

	public List<Product> queryProduct(String ProductName) throws Exception {
		List<Product> productList = null;
		Session session = null;
		try {
			session = fy.openSession();
			String hql = "from Product where FName like '%" + ProductName + "%'";
			Query query = session.createQuery(hql);
			productList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return productList;
	}
	
	public Product queryProductByBarCode(String BarCode) throws Exception {
		Product product = null;
		Session session = null;
		try {
			session = fy.openSession();
			String hql = "from Product where FHelpCode = '" + BarCode.substring(2, 7) + "'";
			Query query = session.createQuery(hql);
			product = (Product)query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return product;
	}
	
	public Product queryProductBySpecMap(SpecMap specMap) throws Exception {
		Product product = null;
		Session session = null;
		try {
			session = fy.openSession();
			String hql = "from Product where FName like '" + specMap.getStandardName() + "%" + specMap.getSpeed() + "%" + specMap.getBrandName() + "'";
			Query query = session.createQuery(hql);
			product = (Product)query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return product;
	}
	
  public SpecMap querySpecMapByBarcode(String Barcode) throws Exception {
	SpecMap specMap = null;
	Session session = null;
	try {
		session = sf.openSession();
		String sql = "select a.name standardName,b.name brandName,a.speed speed from standard a,brand b where a.code='" + Barcode.substring(2, 5) + "' and b.code='" +Barcode.substring(5, 7) +"'";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(SpecMap.class);
		specMap=(SpecMap)query.list().get(0);
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		if (session != null)
			session.clear();
			session.close();
	}
	return specMap;
}

	public List<Store> queryStore(Store store, int pageNo, int pageSize)
			throws Exception {
		// TODO Auto-generated method stub
		List<Store> storeList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String hql = "from Store where 1=1";
			if (store != null) {
				if (store.getStoreState() != null && !"".equals(store.getStoreState())) {
					hql = hql + " and storeState='" + store.getStoreState()
							+ "'";
				}
				if (store.getSeOrderEntry() != null && store.getSeOrderEntry().getSeOrder() != null && store.getSeOrderEntry().getSeOrder().getFbillNo() != null && !"".equals(store.getSeOrderEntry().getSeOrder().getFbillNo())) {
					//先查询订单ID，
					hql = hql + " and orderId=" + store.getOrderId();
				}
				if (store.getInMan() != null && !"".equals(store.getInMan())) {
					hql = hql + " and inMan like '%" + store.getInMan() + "%'";
				}
				if (store.getOutMan() != null && !"".equals(store.getOutMan())) {
					hql = hql + " and outMan like '%" + store.getOutMan() + "%'";
				}
				if (store.getOutTime1() != null && !"".equals(store.getOutTime1()) ) {
					hql = hql + " and outTime >='" + store.getOutTime1() + "'";
				}
				if (store.getOutTime2() != null && !"".equals(store.getOutTime2()) ) {
					hql = hql + " and outTime <='" + store.getOutTime2() + "'";
				}
				if (store.getInTime1() != null && !"".equals(store.getInTime1()) ) {
					hql = hql + " and inTime >='" + store.getInTime1() + "'";
				}
				if (store.getInTime2() != null && !"".equals(store.getInTime2()) ) {
					hql = hql + " and inTime <='" + store.getInTime2() + "'";
				}
				if (store.getInClass() != null && !"".equals(store.getInClass()) ) {
					hql = hql + " and inClass ='" + store.getInClass() + "'";
				} 
				if (store.getBarcode() != null && !"".equals(store.getBarcode())) {
					hql = hql + " and barcode like '%" + store.getBarcode()
							+ "%'";
				}
				if (store.getBoxCode() != null && !"".equals(store.getBoxCode())) {
					hql = hql + " and boxCode like '%" + store.getBoxCode()
							+ "%'";
				}
				if (store.getDetailId() != null && !"".equals(store.getDetailId())) {
					hql = hql + " and detailId=" + store.getDetailId();
				}
				if (store.getOrderId() != null && !"".equals(store.getOrderId())) {
					hql = hql + " and orderId=" + store.getOrderId();
				}
				if (store.getProductID() != null && !"".equals(store.getProductID())) {
					hql = hql + " and productID=" + store.getProductID();
				}
				if (StringUtils.isNotBlank(store.getCarNo())) {
					hql = hql + " and vehicleID in (" + store.getCarIds() + ")";
				}
				if (store.getProductName() != null && !"".equals(store.getProductName())) {
					List<Product> productList = queryProduct(store.getProductName());
					if (productList.size() > 0) {
						String str = productList.get(0).getFItemID().toString();
						for (int i = 1; i < productList.size(); i++) {
							str = str
									+ ","
									+ productList.get(i).getFItemID()
											.toString();
						}
						hql = hql + " and productID in (" + str + ")";
					}else {
						hql = hql + " and 1<>1";
					}
				}
			}
			hql = hql + " order by inTime desc";
			Query query = session.createQuery(hql);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			storeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeList;
	}

	public int queryStoreSize(Store store) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "select count(*) from Store where 1=1";
			if (store != null) {
				if (store.getStoreState() != null && !"".equals(store.getStoreState())) {
					hql = hql + " and storeState='" + store.getStoreState()
							+ "'";
				}
				if (store.getSeOrderEntry() != null && store.getSeOrderEntry().getSeOrder() != null && store.getSeOrderEntry().getSeOrder().getFbillNo() != null && !"".equals(store.getSeOrderEntry().getSeOrder().getFbillNo())) {
					//先查询订单ID，
					hql = hql + " and orderId=" + store.getOrderId();
				}
				if (store.getInMan() != null && !"".equals(store.getInMan())) {
					hql = hql + " and inMan like '%" + store.getInMan() + "%'";
				}
				if (store.getOutMan() != null && !"".equals(store.getOutMan())) {
					hql = hql + " and outMan like '%" + store.getOutMan() + "%'";
				}
				if (store.getOutTime1() != null && !"".equals(store.getOutTime1()) ) {
					hql = hql + " and outTime >='" + store.getOutTime1() + "'";
				}
				if (store.getOutTime2() != null && !"".equals(store.getOutTime2()) ) {
					hql = hql + " and outTime <='" + store.getOutTime2() + "'";
				}
				if (store.getInTime1() != null && !"".equals(store.getInTime1()) ) {
					hql = hql + " and inTime >='" + store.getInTime1() + "'";
				}
				if (store.getInTime2() != null && !"".equals(store.getInTime2()) ) {
					hql = hql + " and inTime <='" + store.getInTime2() + "'";
				}
				if (store.getInClass() != null && !"".equals(store.getInClass()) ) {
					hql = hql + " and inClass ='" + store.getInClass() + "'";
				}
				if (store.getBarcode() != null && !"".equals(store.getBarcode())) {
					hql = hql + " and barcode like '%" + store.getBarcode()
							+ "%'";
				}
				if (store.getBoxCode() != null && !"".equals(store.getBoxCode())) {
					hql = hql + " and boxCode like '%" + store.getBoxCode()
							+ "%'";
				}
				if (store.getDetailId() != null && !"".equals(store.getDetailId())) {
					hql = hql + " and detailId=" + store.getDetailId();
				}
				if (store.getOrderId() != null && !"".equals(store.getOrderId())) {
					hql = hql + " and orderId=" + store.getOrderId();
				}
				if (store.getProductID() != null && !"".equals(store.getProductID())) {
					hql = hql + " and productID=" + store.getProductID();
				}
				if (StringUtils.isNotBlank(store.getCarNo())) {
					hql = hql + " and vehicleID in (" + store.getCarIds() + ")";
				}
				if (store.getProductName() != null && !"".equals(store.getProductName())) {
					List<Product> productList = queryProduct(store
							.getProductName());
					if (productList.size() > 0) {
						String str = productList.get(0).getFItemID().toString();
						for (int i = 1; i < productList.size(); i++) {
							str = str
									+ ","
									+ productList.get(i).getFItemID()
											.toString();
						}
						hql = hql + " and productID in (" + str + ")";
					}
				}
			}
			Query query = session.createQuery(hql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public SeOrderEntry getSeOrderEntryById(int finterID,int productID) throws Exception {
		Session session = null;
		SeOrderEntry seOrderEntry = null;
		try {
			session = fy.openSession();
//			seOrderEntry = (SeOrderEntry) session.get(SeOrderEntry.class, id);
//			session.flush();
			String hql = "from SeOrderEntry where seOrder.finterID = " + finterID + " and product.FItemID="+productID;
			Query query = session.createQuery(hql);
			seOrderEntry = (SeOrderEntry)query.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		
		return seOrderEntry;
	}

	public Product getProductById(int id) throws Exception {
		Session session = null;
		Product product = null;
		try {
			session = fy.openSession();
			product = (Product) session.get(Product.class, id);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return product;
	}

	public Store getStoreById(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Store storeIn = null;
		try {
			session = sf.openSession();
			storeIn = (Store) session.get(Store.class, id);
			session.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeIn;
	}

	public int deleteStore(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		Store store = null;
		try {
			session = sf.openSession();
			store = getStoreById(id);
			session.delete(store);
			session.flush();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
	}

	public int updateStore(Store store) throws Exception {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sf.openSession();
			session.update(store);
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

	public List<Store> queryCollectStore(Store store, int pageNo, int pageSize)
			throws Exception {
		List<Store> storeList = null;
		Session session = null;
		int beginPos = (pageNo - 1) * pageSize;
		try {
			session = sf.openSession();
			String sql = "select * from hand_store where id in (select max(id) from hand_store where 1=1";
			if (store != null) {
				if (!"".equals(store.getStoreState())
						&& store.getStoreState() != null) {
					sql = sql + " and storeState='" + store.getStoreState()
							+ "'";
				}
				if (!"".equals(store.getOutDate())
						&& store.getOutDate() != null) {
					sql = sql + " and outDate='" + store.getOutDate() + "'";
				}
				if (!"".equals(store.getInDate()) && store.getInDate() != null) {
					sql = sql + " and inDate='" + store.getInDate() + "'";
				}
			}
			sql = sql + " group by ProductID )";
			Query query = session.createSQLQuery(sql).addEntity(Store.class);
			query.setFirstResult(beginPos);
			query.setMaxResults(pageSize);
			storeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeList;
	}

	public int queryCollectStoreSize(Store store) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from hand_store where id in (select max(id) from hand_store where 1=1";
			if (store != null) {
				if (!"".equals(store.getStoreState())
						&& store.getStoreState() != null) {
					sql = sql + " and storeState='" + store.getStoreState()
							+ "'";
				}
				if (!"".equals(store.getOutDate())
						&& store.getOutDate() != null) {
					sql = sql + " and outDate='" + store.getOutDate() + "'";
				}
				if (!"".equals(store.getInDate()) && store.getInDate() != null) {
					sql = sql + " and inDate='" + store.getInDate() + "'";
				}
			}
			sql = sql + " group by ProductID )";
			Query query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int queryCollectCount(Store store) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = sf.openSession();
			String sql = "select count(*) from hand_store where storeState='"
					+ store.getStoreState() + "' and ProductID="
					+ store.getProduct().getFItemID();
			Query query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public List<Store> queryAllStore(Store store) throws Exception {
		List<Store> storeList = null;
		Session session = null;
		try {
			session = sf.openSession();
			String hql = "from Store where 1=1";
			if (store != null) {
				if (store.getStoreState() != null && !"".equals(store.getStoreState())) {
					hql = hql + " and StoreState='" + store.getStoreState()
							+ "'";
				}
				if (store.getSeOrderEntry() != null && store.getSeOrderEntry().getSeOrder() != null && store.getSeOrderEntry().getSeOrder().getFbillNo() != null && !"".equals(store.getSeOrderEntry().getSeOrder().getFbillNo())) {
					//先查询订单ID，
					hql = hql + " and orderId=" + store.getOrderId();
				}
				if (store.getInTime1() != null && !"".equals(store.getInTime1()) ) {
					hql = hql + " and InTime >='" + store.getInTime1() + "'";
				}
				if (store.getInTime2() != null && !"".equals(store.getInTime2()) ) {
					hql = hql + " and InTime <='" + store.getInTime2() + "'";
				}
				if (store.getOutTime1() != null && !"".equals(store.getOutTime1()) ) {
					hql = hql + " and outTime >='" + store.getOutTime1() + "'";
				}
				if (store.getOutTime2() != null && !"".equals(store.getOutTime2()) ) {
					hql = hql + " and outTime <='" + store.getOutTime2() + "'";
				}
				if (store.getInClass() != null && !"".equals(store.getInClass()) ) {
					hql = hql + " and inClass ='" + store.getInClass() + "'";
				}
				if (store.getBarcode() != null && !"".equals(store.getBarcode())) {
					hql = hql + " and barcode like '%" + store.getBarcode()
							+ "%'";
				}
				if (store.getBoxCode() != null && !"".equals(store.getBoxCode())) {
					hql = hql + " and boxCode like '%" + store.getBoxCode()
							+ "%'";
				}
				if (store.getDetailId() != null && !"".equals(store.getDetailId())) {
					hql = hql + " and DetailID=" + store.getDetailId();
				}
				if (store.getOrderId() != null && !"".equals(store.getOrderId())) {
					hql = hql + " and OrderID=" + store.getOrderId();
				}
				if (store.getProductID() != null && !"".equals(store.getProductID())) {
					hql = hql + " and ProductID=" + store.getProductID();
				}
				if (store.getProductName() != null && !"".equals(store.getProductName())) {
					List<Product> productList = queryProduct(store
							.getProductName());
					if (productList.size() > 0) {
						String str = productList.get(0).getFItemID().toString();
						for (int i = 1; i < productList.size(); i++) {
							str = str
									+ ","
									+ productList.get(i).getFItemID()
											.toString();
						}
						hql = hql + " and ProductID in (" + str + ")";
					}
				}
			}
			
//            String sql ="select top "+pageSize+" * from hand_store where 1=1 and id not in(select top "+currentSize+" id from hand_store where 1=1 "+hql+" order by id) "+hql+" order by id";
//			SQLQuery query = session.createSQLQuery(hql);s
//			storeList = query.addEntity(Store.class).list();
			Query query = session.createQuery(hql);
			storeList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return storeList;
	}

	public int getFCheckerID(int FInterID) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "select FCheckerID from ICStockBill where FInterID ="
					+ FInterID;
			Query query = session.createSQLQuery(sql);
			if (query.uniqueResult() != null) {
				n = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int updateICStockBillEntry(int FInterID, int FItemID)
			throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "update ICStockBillEntry set FQty=FQty-1,FAuxQty=FAuxQty-1 where FInterID = "
					+ FInterID + " and FItemID=" + FItemID;
			Query query = session.createSQLQuery(sql);
			n = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int getFInterID() throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "select FInterID from ICStockBill where FTranType=2 and FROB=-1 and FDate >=convert(datetime,convert(varchar(10),getdate(),120)) and FDate < convert(datetime,convert(varchar(11),dateadd(day,1,getdate()),120))";
			Query query = session.createSQLQuery(sql);
			if (query.uniqueResult() != null) {
				n = ((Number) query.uniqueResult()).intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int getICStockBillEntryCount(int FInterID) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "select count(*) from ICStockBillEntry where FInterID ="
					+ FInterID;
			Query query = session.createSQLQuery(sql);
			n = ((Number) query.uniqueResult()).intValue();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int getFQty(int FInterID, int FItemID) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "select FQty from ICStockBillEntry where FInterID = "
					+ FInterID + " and FItemID=" + FItemID;
			Query query = session.createSQLQuery(sql);
			if (query.uniqueResult() != null) {
				n = ((Number) query.uniqueResult()).intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int getDefaultLoc(int ProductID) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "select fdefaultloc from t_icitem where FItemID="
					+ ProductID;
			Query query = session.createSQLQuery(sql);
			if (query.uniqueResult() != null) {
				n = ((Number) query.uniqueResult()).intValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int insertICStockBillEntry(int FInterID, int count, int FItemID,
			int loc) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "insert into ICStockBillEntry (FBrNo,FInterID,FEntryID,FItemID,FQty,FAuxQty,FBatchNo,FContractBillNo,FICMOBillNo,FOrderBillNo,FMTONo,FClientOrderNo,FItemSize,FItemSuite,FPositionNo,FSEOutBillNo,FConfirmMemEntry,FReturnNoticeBillNO,FNote,FUnitID,FDCSPID,FSnListID,FChkPassItem,FDCStockID) values ('0',"
					+ FInterID
					+ ","
					+ (count + 1)
					+ ","
					+ FItemID
					+ ",-1,-1,'','','','','','','','','','','','','',258,0,0,1058,"
					+ loc + ")";
			Query query = session.createSQLQuery(sql);
			n = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int insertICStockBill(int FInterID, int k3User, int FBillID,
			String BillNo) throws Exception {
		int n = 0;
		Session session = null;
		try {
			session = fy.openSession();
			String sql = "insert into ICStockBill (FBrNo,FTranType,FDate,FBillNo,FExplanation,FFetchAdd,FPOSName,FConfirmMem,FYearPeriod,FInterID,FDCStockID,FFManagerID,FSManagerID,FBillerID,FVchInterID,FUpStockWhenSave,FManageType,FROB) values "
					+ "('0',"
					+ FBillID
					+ ",convert(datetime,convert(varchar(20),getdate(),120)),'"
					+ BillNo
					+ "','','','','','',"
					+ FInterID
					+ ",0,"
					+ k3User
					+ "," + k3User + ",16394 ,0,1,0,-1)";
			Query query = session.createSQLQuery(sql);
			n = query.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.clear();
				session.close();
		}
		return n;
	}

	public int createFInterID() throws Exception {
		int n = 0;
		if (fy instanceof SessionFactoryImplementor) {
			ConnectionProvider cp = ((SessionFactoryImplementor) fy).getConnectionProvider();
			CallableStatement st = cp.getConnection().prepareCall("{Call GetICMaxNum(?,?,?,?)}");
			try {
				st.setString(1, "ICStockBill");
				st.registerOutParameter(2, java.sql.Types.INTEGER);
				st.setInt(3, 1);
				st.setInt(4, 16394);
				st.execute();
 				n = st.getInt(2);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				st.close();
 				cp.close();
			}
		}
		return n;
	}

	public String createBillNo() throws Exception {
		String n = "";
		if (fy instanceof SessionFactoryImplementor) {
			ConnectionProvider cp = ((SessionFactoryImplementor) fy).getConnectionProvider();
			Connection conn= cp.getConnection();
			CallableStatement st = conn.prepareCall("{Call p_BM_GetBillNo(?,?)}");
			try {
				st.setInt(1,2);
				st.registerOutParameter(2, java.sql.Types.VARCHAR);
				st.execute();
				n = st.getString(2);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				st.close();
				cp.close();
			}
		}
		return n;
	}
}
