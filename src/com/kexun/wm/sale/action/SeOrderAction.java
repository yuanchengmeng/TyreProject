package com.kexun.wm.sale.action;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.kexun.wm.sale.bean.Carton;
import com.kexun.wm.sale.bean.SeOrder;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.sale.bean.Vehicle;
import com.kexun.wm.sale.service.SeOrderService;
import com.kexun.wm.sale.service.impl.SeOrderServiceImpl;
import com.kexun.wm.system.bean.PageSize;
import com.kexun.wm.untils.AllSelectItemUtil;
import com.kexun.wm.untils.ShowMessageUtil;

public class SeOrderAction {
	static Log log = LogFactory.getLog(SeOrderAction.class);
	private File file;
	private SeOrder seOrder;
	private SeOrder seOrderDetail;
	private Vehicle vehicle;
	private Carton carton;
	private SeOrderService seOrderService = new SeOrderServiceImpl();
	private List<SeOrder> seOrderList;
	private List<Carton> cartonList;
	private List<Vehicle> vehicleList;
	private List<SeOrderEntry> seOrderEntryList;
	private String nameId = "";
	private String flag;
	private String ids;
	private int recordCount;
	private int pageCount = 1;
	private int pageNo = 1;
	private int result1 = 0;
	private int result2 = 0;
	private int pageSize;
	private int id;
	private List<PageSize> pageSizeList;

	public String querySeOrder() throws Exception {
		pageSizeList = AllSelectItemUtil.queryPageSize();
		if (("first").equals(flag)) {
			pageSize = pageSizeList.get(0).getPsize();
		}
		if(!("").equals(nameId)){
			try {
				nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
				seOrder.setFbillNo(nameId);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		recordCount = seOrderService.queryAllRows(seOrder);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		seOrderList = seOrderService.querySeOrder(seOrder, pageNo, pageSize);
		for (int i = 0; i < seOrderList.size(); i++) {
			seOrderEntryList = seOrderService.querySeOrderEntry(seOrderList.get(i));
			float count = 0;
			for (int j = 0; j < seOrderEntryList.size(); j++) {
				count = count + seOrderEntryList.get(j).getFQty();
			}
			seOrderList.get(i).setAllCount(count);

			seOrderList.get(i).setAllBarcode( seOrderService.getAllBarcode(seOrderList.get(i)));
		}
		return "querySeOrder";
	}

	public String lastPage() throws Exception {
		if(!("").equals(nameId)){
			try {
				nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
				seOrder.setFbillNo(nameId);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = seOrderService.queryAllRows(seOrder);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		seOrderList = seOrderService.querySeOrder(seOrder, --pageNo, pageSize);

		for (int i = 0; i < seOrderList.size(); i++) {
			seOrderEntryList = seOrderService.querySeOrderEntry(seOrderList
					.get(i));
			float count = 0;
			float money = 0;
			for (int j = 0; j < seOrderEntryList.size(); j++) {
				count = count + seOrderEntryList.get(j).getFQty();
				money=money+seOrderEntryList.get(j).getFAmount();
			}
			seOrderList.get(i).setAllCount(count);
			seOrderList.get(i).setAllMoney(money);

			seOrderList.get(i).setAllBarcode(
					seOrderService.getAllBarcode(seOrderList.get(i)));
		}
		return "querySeOrder";
	}

	public String nextPage() throws Exception {
		if(!("").equals(nameId)){
			try {
				nameId = new String(nameId.getBytes("ISO-8859-1"), "utf-8");
				seOrder.setFbillNo(nameId);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		pageSizeList = AllSelectItemUtil.queryPageSize();
		recordCount = seOrderService.queryAllRows(seOrder);
		if (pageSize != 0) {
			pageCount = (recordCount + pageSize - 1) / pageSize;
		}
		seOrderList = seOrderService.querySeOrder(seOrder, ++pageNo, pageSize);

		for (int i = 0; i < seOrderList.size(); i++) {
			seOrderEntryList = seOrderService.querySeOrderEntry(seOrderList .get(i));
			float count = 0;
			for (int j = 0; j < seOrderEntryList.size(); j++) {
				count = count + seOrderEntryList.get(j).getFQty();
			}
			seOrderList.get(i).setAllCount(count);

			seOrderList.get(i).setAllBarcode(
					seOrderService.getAllBarcode(seOrderList.get(i)));
		}
		return "querySeOrder";
	}

	public String getSeOrderEntryById() throws Exception {
		seOrder=new SeOrder();
		seOrder.setFinterID(id);
		seOrderEntryList = seOrderService.querySeOrderEntry(seOrder);
		for(int i=0;i<seOrderEntryList.size();i++){
			seOrderEntryList.get(i).setAllBarcode(seOrderService.getAllBarcode(seOrderEntryList.get(i)));
		}
		return "querySeOrderEntry";
 	}
	

	 public String getVehicleForm() throws Exception {
		 seOrderDetail = seOrderService.findSeOrderById(seOrder.getFinterID());
		 vehicleList = seOrderService.queryVehicleByOrderId(seOrder.getFinterID());
		 return "vehicleForm";
	 }
	 
	 public String getCartonForm() throws Exception {
		 seOrderDetail = seOrderService.findSeOrderById(seOrder.getFinterID());
		 cartonList = seOrderService.queryCartonByOrderId(seOrder.getFinterID());
		 vehicleList = seOrderService.queryVehicleByOrderId(seOrder.getFinterID());
		 return "cartonForm";
	 }
	 
	 public String addVehicle() throws Exception {
			String ids = "";
			if (null != vehicleList) {
				for (int i = 0; i < vehicleList.size(); i++) {
					if (vehicleList.get(i) != null) {
						if(vehicleList.get(i).getVehicleNo()!=null && !"".equals(vehicleList.get(i).getVehicleNo())){
							vehicleList.get(i).setOrderId(seOrder.getFinterID());
							if (vehicleList.get(i).getId() == null || vehicleList.get(i).getId() == 0) {//新增车辆
								vehicle=seOrderService.queryRepeatVehicle(vehicleList.get(i).getVehicleNo(),seOrder.getFinterID());
								if(vehicle==null){
									seOrderService.saveVehicle(vehicleList.get(i));
								}
							} else {//修改车辆
								seOrderService.updateVehicle(vehicleList.get(i));
							}
						}
					}
					if (vehicleList.get(i) != null && vehicleList.get(i).getId() != null && vehicleList.get(i).getId() > 0) {
						ids += vehicleList.get(i).getId() + ",";
					}//获得所有最新车辆信息
				}
			}
			seOrderService.deleteSomeVehicle(ids, seOrder.getFinterID());// 删除车辆
			ShowMessageUtil.showActionSuccess();
			seOrderDetail = seOrderService.findSeOrderById(seOrder.getFinterID());
			vehicleList = seOrderService.queryVehicleByOrderId(seOrder.getFinterID());
			return "vehicleForm";
	 }
	 
	 public String addCarton() throws Exception {
			String ids = "";
			if (null != cartonList) {
				for (int i = 0; i < cartonList.size(); i++) {
					//判断车牌号是否为空
					if (cartonList.get(i) != null && cartonList.get(i).getVehicle() != null && cartonList.get(i).getVehicle().getId() != null && cartonList.get(i).getVehicle().getId()>0) {
						//判断箱号是否为空
						if(cartonList.get(i).getCartonNo()!=null && !"".equals(cartonList.get(i).getCartonNo())){
							//判断是否是新增车辆
							if (cartonList.get(i).getId() == null || cartonList.get(i).getId() == 0) {
								cartonList.get(i).setOrderId(seOrder.getFinterID());
								carton=seOrderService.queryRepeatCarton(cartonList.get(i).getCartonNo(),cartonList.get(i).getVehicle().getId(),seOrder.getFinterID());
								//判断箱号是否重复
								if(carton==null){
									seOrderService.saveCarton(cartonList.get(i));
								}
							} 
						}
					}
					if (cartonList.get(i) != null && cartonList.get(i).getId() != null && cartonList.get(i).getId() > 0) {
						//获得所有最新箱号ID
						ids += cartonList.get(i).getId() + ",";
					}
				}
			}
			seOrderService.deleteSomeCarton(ids, seOrder.getFinterID());// 删除车辆
			ShowMessageUtil.showActionSuccess();
			seOrderDetail = seOrderService.findSeOrderById(seOrder.getFinterID());
			cartonList = seOrderService.queryCartonByOrderId(seOrder.getFinterID());
			vehicleList = seOrderService.queryVehicleByOrderId(seOrder.getFinterID());
			return "cartonForm";
	 }

	public static Log getLog() {
		return log;
	}

	public static void setLog(Log log) {
		SeOrderAction.log = log;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public SeOrder getSeOrder() {
		return seOrder;
	}

	public void setSeOrder(SeOrder seOrder) {
		this.seOrder = seOrder;
	}

	public SeOrderService getSeOrderService() {
		return seOrderService;
	}

	public void setSeOrderService(SeOrderService seOrderService) {
		this.seOrderService = seOrderService;
	}

	public List<SeOrder> getSeOrderList() {
		return seOrderList;
	}

	public void setSeOrderList(List<SeOrder> seOrderList) {
		this.seOrderList = seOrderList;
	}

	public String getNameId() {
		return nameId;
	}

	public void setNameId(String nameId) {
		this.nameId = nameId;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getResult1() {
		return result1;
	}

	public void setResult1(int result1) {
		this.result1 = result1;
	}

	public int getResult2() {
		return result2;
	}

	public void setResult2(int result2) {
		this.result2 = result2;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<PageSize> getPageSizeList() {
		return pageSizeList;
	}

	public void setPageSizeList(List<PageSize> pageSizeList) {
		this.pageSizeList = pageSizeList;
	}

	public List<SeOrderEntry> getSeOrderEntryList() {
		return seOrderEntryList;
	}

	public void setSeOrderEntryList(List<SeOrderEntry> seOrderEntryList) {
		this.seOrderEntryList = seOrderEntryList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SeOrder getSeOrderDetail() {
		return seOrderDetail;
	}

	public void setSeOrderDetail(SeOrder seOrderDetail) {
		this.seOrderDetail = seOrderDetail;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public List<Carton> getCartonList() {
		return cartonList;
	}

	public void setCartonList(List<Carton> cartonList) {
		this.cartonList = cartonList;
	}

	public Carton getCarton() {
		return carton;
	}

	public void setCarton(Carton carton) {
		this.carton = carton;
	}

}
