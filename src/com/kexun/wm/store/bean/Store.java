package com.kexun.wm.store.bean;

import java.util.Date;

import com.kexun.wm.sale.bean.Product;
import com.kexun.wm.sale.bean.SeOrderEntry;
import com.kexun.wm.sale.bean.Vehicle;

public class Store {
	private Integer id;
	private String storeState;// 出入库标识
	private String barcode;// 条形码
	private String boxCode;// 笼框条形码
	private Integer detailId;
	private Integer classId;
	private Integer ProductID;
	private Date inTime;
	private String inTime1;
	private String inTime2;
	private String inMan;// 入库人
	private String inClass;
	private String inDate;
	private Integer orderId;
	private SeOrderEntry seOrderEntry;
	private Product product;
	private Date outTime;
	private String outTime1;
	private String outTime2;
	private String outMan;// 出库人
	private String outClass;
	private String outDate;
	private Vehicle vehicle;
	private int collectCount;// 汇总数
	private String productName;// 查询规格型号
	
	private Integer inCode;//入库单据id
	private Integer inNo;
	private Integer outCode;//出库单据id
	private Integer outNo;
	private String carNo;//车牌号
	private String carIds;//车牌号
	
	private String changeboxMan;
	private String nochangeBoxcode;
	private String changeboxClass;
	private Date changeboxTime;
	private String nofrkBoxcode;
	private String frkMan;
	private String frkClass;
	private Date frkTime;
	private String qxrkMan;
	private String qxrkClass;
	private Date qxrkTime;
	private Date k3Time;
	private String oldrkMan;
	private String oldrkClass;
	private Date oldrkTime;
	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStoreState() {
		return storeState;
	}

	public void setStoreState(String storeState) {
		if (storeState == null) {
			storeState = "";
		}
		this.storeState = storeState;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		if (barcode == null) {
			barcode = "";
		}
		this.barcode = barcode;
	}

	public String getBoxCode() {
		return boxCode;
	}

	public void setBoxCode(String boxCode) {
		if (boxCode == null) {
			boxCode = "";
		}
		this.boxCode = boxCode;
	}

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
	}

	public String getInMan() {
		return inMan;
	}

	public void setInMan(String inMan) {
		if (inMan == null) {
			inMan = "";
		}
		this.inMan = inMan;
	}

	public String getInClass() {
		return inClass;
	}

	public void setInClass(String inClass) {
		if (inClass == null) {
			inClass = "";
		}
		this.inClass = inClass;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		if (inDate == null) {
			inDate = "";
		}
		this.inDate = inDate;
	}

	public SeOrderEntry getSeOrderEntry() {
		return seOrderEntry;
	}

	public void setSeOrderEntry(SeOrderEntry seOrderEntry) {
 		this.seOrderEntry = seOrderEntry;
	}

	public Date getOutTime() {
		return outTime;
	}

	public void setOutTime(Date outTime) {
		// if(outTime==null){
		// outTime="";
		// }
		this.outTime = outTime;
	}

	public String getOutMan() {
		return outMan;
	}

	public void setOutMan(String outMan) {
		if (outMan == null) {
			outMan = "";
		}
		this.outMan = outMan;
	}

	public String getOutClass() {
		return outClass;
	}

	public void setOutClass(String outClass) {
		if (outClass == null) {
			outClass = "";
		}
		this.outClass = outClass;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		if (outDate == null) {
			outDate = "";
		}
		this.outDate = outDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		if (orderId == null) {
			orderId = 0;
		}
		this.orderId = orderId;
	}

	public Integer getDetailId() {
		return detailId;
	}

	public void setDetailId(Integer detailId) {
		if (detailId == null) {
			detailId = 0;
		}
		this.detailId = detailId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getCollectCount() {
		return collectCount;
	}

	public void setCollectCount(int collectCount) {
		this.collectCount = collectCount;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getInCode() {
		return inCode;
	}

	public void setInCode(Integer inCode) {
		this.inCode = inCode;
	}

	public Integer getInNo() {
		return inNo;
	}

	public void setInNo(Integer inNo) {
		this.inNo = inNo;
	}

	public Integer getOutCode() {
		return outCode;
	}

	public void setOutCode(Integer outCode) {
		this.outCode = outCode;
	}

	public Integer getOutNo() {
		return outNo;
	}

	public void setOutNo(Integer outNo) {
		this.outNo = outNo;
	}

	public String getInTime1() {
		return inTime1;
	}

	public void setInTime1(String inTime1) {
		this.inTime1 = inTime1;
	}

	public String getInTime2() {
		return inTime2;
	}

	public void setInTime2(String inTime2) {
		this.inTime2 = inTime2;
	}

	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public String getOutTime1() {
		return outTime1;
	}

	public void setOutTime1(String outTime1) {
		this.outTime1 = outTime1;
	}

	public String getOutTime2() {
		return outTime2;
	}

	public void setOutTime2(String outTime2) {
		this.outTime2 = outTime2;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public String getCarIds() {
		return carIds;
	}

	public void setCarIds(String carIds) {
		this.carIds = carIds;
	}

	public String getChangeboxMan() {
		return changeboxMan;
	}

	public void setChangeboxMan(String changeboxMan) {
		this.changeboxMan = changeboxMan;
	}

	public String getNochangeBoxcode() {
		return nochangeBoxcode;
	}

	public void setNochangeBoxcode(String nochangeBoxcode) {
		this.nochangeBoxcode = nochangeBoxcode;
	}

	public String getChangeboxClass() {
		return changeboxClass;
	}

	public void setChangeboxClass(String changeboxClass) {
		this.changeboxClass = changeboxClass;
	}

	public String getNofrkBoxcode() {
		return nofrkBoxcode;
	}

	public void setNofrkBoxcode(String nofrkBoxcode) {
		this.nofrkBoxcode = nofrkBoxcode;
	}

	public String getFrkMan() {
		return frkMan;
	}

	public void setFrkMan(String frkMan) {
		this.frkMan = frkMan;
	}

	public String getFrkClass() {
		return frkClass;
	}

	public void setFrkClass(String frkClass) {
		this.frkClass = frkClass;
	}

	public String getQxrkMan() {
		return qxrkMan;
	}

	public void setQxrkMan(String qxrkMan) {
		this.qxrkMan = qxrkMan;
	}

	public String getQxrkClass() {
		return qxrkClass;
	}

	public void setQxrkClass(String qxrkClass) {
		this.qxrkClass = qxrkClass;
	}

	public String getOldrkMan() {
		return oldrkMan;
	}

	public void setOldrkMan(String oldrkMan) {
		this.oldrkMan = oldrkMan;
	}

	public String getOldrkClass() {
		return oldrkClass;
	}

	public void setOldrkClass(String oldrkClass) {
		this.oldrkClass = oldrkClass;
	}

	public Date getChangeboxTime() {
		return changeboxTime;
	}

	public void setChangeboxTime(Date changeboxTime) {
		this.changeboxTime = changeboxTime;
	}

	public Date getFrkTime() {
		return frkTime;
	}

	public void setFrkTime(Date frkTime) {
		this.frkTime = frkTime;
	}

	public Date getQxrkTime() {
		return qxrkTime;
	}

	public void setQxrkTime(Date qxrkTime) {
		this.qxrkTime = qxrkTime;
	}

	public Date getK3Time() {
		return k3Time;
	}

	public void setK3Time(Date k3Time) {
		this.k3Time = k3Time;
	}

	public Date getOldrkTime() {
		return oldrkTime;
	}

	public void setOldrkTime(Date oldrkTime) {
		this.oldrkTime = oldrkTime;
	}
}
