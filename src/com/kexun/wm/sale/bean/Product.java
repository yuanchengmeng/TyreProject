package com.kexun.wm.sale.bean;


/*
 * 产品表
 */
public class Product {
	/**
	 * 
	 */
	private Integer	FItemID;	//产品内码(主键)
	private Float FLength;//	长度
	private Integer	FMaund;//	重量单位
	private String FModel;//	规格型号
 	private String	FName;//	产品名称
 	private String FHelpCode;//助记符
 	private String	FNumber;//	产品代码
 	private Float FOrderPrice;//	订货单价
 	private Float FPlanPrice;//	计划单价
	private Integer	FSaleAcctID;//	销售科目
	private Float FSalePrice;//	销售单价
	private Integer	FSaleUnitID;//销售计量单位
	private String FShortNumber;//	产品简码
	private Integer	FStoreUnitID;//	库存计量单位
	private Integer	FTypeID;//	产品分类
	private Integer	FUnitGroupID;//	单位组内码
	private Integer	FUnitID;//	单位内码
	private String FBrNo;//	公司代码
	private Integer	FClass;//产品类别
	private Integer	FDepartment;//	部门
	private Integer	FErpClsID;//	产品属性
	private String FFullName;//	全名
	public Integer getFItemID() {
		return FItemID;
	}
	public void setFItemID(Integer fItemID) {
		if(fItemID==null){
			FItemID=0;
		}
		FItemID = fItemID;
	}
	public Float getFLength() {
		return FLength;
	}
	public void setFLength(Float fLength) {
		if(fLength==null){
			FLength=0f;
		}
		FLength = fLength;
	}
	public Integer getFMaund() {
		return FMaund;
	}
	public void setFMaund(Integer fMaund) {
		if(fMaund==null){
			FMaund=0;
		}
		FMaund = fMaund;
	}
	public String getFModel() {
		return FModel;
	}
	public void setFModel(String fModel) {
		if(fModel==null){
			FModel="";
		}
		FModel = fModel;
	}
	public String getFName() {
		return FName;
	}
	public void setFName(String fName) {
		if(fName==null){
			FName="";
		}
		FName = fName;
	}
	public String getFNumber() {
		return FNumber;
	}
	public void setFNumber(String fNumber) {
		if(fNumber==null){
			FNumber="";
		}
		FNumber = fNumber;
	}
	public Float getFOrderPrice() {
		return FOrderPrice;
	}
	public void setFOrderPrice(Float fOrderPrice) {
		if(fOrderPrice==null){
			FOrderPrice=0f;
		}
		FOrderPrice = fOrderPrice;
	}
	public Float getFPlanPrice() {
		return FPlanPrice;
	}
	public void setFPlanPrice(Float fPlanPrice) {
		if(fPlanPrice==null){
			FPlanPrice=0f;
		}
		FPlanPrice = fPlanPrice;
	}
	public Integer getFSaleAcctID() {
		return FSaleAcctID;
	}
	public void setFSaleAcctID(Integer fSaleAcctID) {
		if(fSaleAcctID==null){
			FSaleAcctID=0;
		}
		FSaleAcctID = fSaleAcctID;
	}
	public Float getFSalePrice() {
		return FSalePrice;
	}
	public void setFSalePrice(Float fSalePrice) {
		if(fSalePrice==null){
			FSalePrice=0f;
		}
		FSalePrice = fSalePrice;
	}
	public Integer getFSaleUnitID() {
		return FSaleUnitID;
	}
	public void setFSaleUnitID(Integer fSaleUnitID) {
		if(fSaleUnitID==null){
			FSaleUnitID=0;
		}
		FSaleUnitID = fSaleUnitID;
	}
	public String getFShortNumber() {
		return FShortNumber;
	}
	public void setFShortNumber(String fShortNumber) {
		if(fShortNumber==null){
			FShortNumber="";
		}
		FShortNumber = fShortNumber;
	}
	public Integer getFStoreUnitID() {
		return FStoreUnitID;
	}
	public void setFStoreUnitID(Integer fStoreUnitID) {
		if(fStoreUnitID==null){
			FStoreUnitID=0;
		}
		FStoreUnitID = fStoreUnitID;
	}
	public Integer getFTypeID() {
		return FTypeID;
	}
	public void setFTypeID(Integer fTypeID) {
		if(fTypeID==null){
			FTypeID=0;
		}
		FTypeID = fTypeID;
	}
	public Integer getFUnitGroupID() {
		return FUnitGroupID;
	}
	public void setFUnitGroupID(Integer fUnitGroupID) {
		if(fUnitGroupID==null){
			FUnitGroupID=0;
		}
		FUnitGroupID = fUnitGroupID;
	}
	public Integer getFUnitID() {
		return FUnitID;
	}
	public void setFUnitID(Integer fUnitID) {
		if(fUnitID==null){
			FUnitID=0;
		}
		FUnitID = fUnitID;
	}
	public String getFBrNo() {
		return FBrNo;
	}
	public void setFBrNo(String fBrNo) {
		if(fBrNo==null){
			FBrNo="";
		}
		FBrNo = fBrNo;
	}
	public Integer getFClass() {
		return FClass;
	}
	public void setFClass(Integer fClass) {
		if(fClass==null){
			FClass=0;
		}
		FClass = fClass;
	}
	public Integer getFDepartment() {
		return FDepartment;
	}
	public void setFDepartment(Integer fDepartment) {
		if(fDepartment==null){
			FDepartment=0;
		}
		FDepartment = fDepartment;
	}
	public Integer getFErpClsID() {
		return FErpClsID;
	}
	public void setFErpClsID(Integer fErpClsID) {
		if(fErpClsID==null){
			FErpClsID=0;
		}
		FErpClsID = fErpClsID;
	}
	public String getFFullName() {
		return FFullName;
	}
	public void setFFullName(String fFullName) {
		if(fFullName==null){
			FFullName="";
		}
		FFullName = fFullName;
	}
	public String getFHelpCode() {
		return FHelpCode;
	}
	public void setFHelpCode(String fHelpCode) {
		FHelpCode = fHelpCode;
	}
	
	
}
