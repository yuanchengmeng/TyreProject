package com.kexun.wm.sale.bean;


/*
 * 客户表
 */
public class Customer {
	/**
	 * 
	 */
	private String	FMobilePhone; //	手机号码
	private String	FName; //	客户名称
	private String	FNumber; //	客户代码
	private String	FPhone; //	电话号码
	private String	FProvince; //	省份
	private Integer	FRegion; //	国别地区
	private Integer	FSaleID; //	
	private String	FShortName; //	客户简称
	private String	FShortNumber; //	客户简码
	private Integer	FStatus; //	状态
	private String	FAddrEn; //	英文地址
	private String	FAddress; //	地址
	private String	FBrNo; //	公司代码
	private String	FCity; //	城市
	private Integer	FClassTypeID; //	单据编码
	private String	FContact; //	联系人
	private String	FCountry; //	国家
	private String	FEmail; //	邮件地址
	private Integer	Femployee; //	专营业务员
	private Integer	FErpClsID; //	产品类别
	private String	FfavorPolicy; //	优惠政策
	private String	FFax; //	传真号
	private Integer	FFlat; //	交易客户
	private String	FHomePage; //	公司主页
	private Integer	FItemID; //	客户内码
	public String getFMobilePhone() {
		return FMobilePhone;
	}
	public void setFMobilePhone(String fMobilePhone) {
		if(fMobilePhone==null){
			FMobilePhone="";
		}
		FMobilePhone = fMobilePhone;
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
	public String getFPhone() {
		return FPhone;
	}
	public void setFPhone(String fPhone) {
		if(fPhone==null){
			FPhone="";
		}
		FPhone = fPhone;
	}
	public String getFProvince() {
		return FProvince;
	}
	public void setFProvince(String fProvince) {
		if(fProvince==null){
			FProvince="";
		}
		FProvince = fProvince;
	}
	public Integer getFRegion() {
		return FRegion;
	}
	public void setFRegion(Integer fRegion) {
		if(fRegion==null){
			FRegion=0;
		}
		FRegion = fRegion;
	}
	public Integer getFSaleID() {
		return FSaleID;
	}
	public void setFSaleID(Integer fSaleID) {
		if(fSaleID==null){
			FSaleID=0;
		}
		FSaleID = fSaleID;
	}
	public String getFShortName() {
		return FShortName;
	}
	public void setFShortName(String fShortName) {
		if(fShortName==null){
			FShortName="";
		}
		FShortName = fShortName;
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
	public Integer getFStatus() {
		return FStatus;
	}
	public void setFStatus(Integer fStatus) {
		if(fStatus==null){
			FStatus=0;
		}
		FStatus = fStatus;
	}
	public String getFAddrEn() {
		return FAddrEn;
	}
	public void setFAddrEn(String fAddrEn) {
		if(fAddrEn==null){
			FAddrEn="";
		}
		FAddrEn = fAddrEn;
	}
	public String getFAddress() {
		return FAddress;
	}
	public void setFAddress(String fAddress) {
		if(fAddress==null){
			FAddress="";
		}
		FAddress = fAddress;
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
	public String getFCity() {
		return FCity;
	}
	public void setFCity(String fCity) {
		if(fCity==null){
			FCity="";
		}
		FCity = fCity;
	}
	public Integer getFClassTypeID() {
		return FClassTypeID;
	}
	public void setFClassTypeID(Integer fClassTypeID) {
		if(fClassTypeID==null){
			FClassTypeID=0;
		}
		FClassTypeID = fClassTypeID;
	}
	public String getFContact() {
		return FContact;
	}
	public void setFContact(String fContact) {
		if(fContact==null){
			FContact="";
		}
		FContact = fContact;
	}
	public String getFCountry() {
		return FCountry;
	}
	public void setFCountry(String fCountry) {
		if(fCountry==null){
			FCountry="";
		}
		FCountry = fCountry;
	}
	public String getFEmail() {
		return FEmail;
	}
	public void setFEmail(String fEmail) {
		if(fEmail==null){
			FEmail="";
		}
		FEmail = fEmail;
	}
	public Integer getFemployee() {
		return Femployee;
	}
	public void setFemployee(Integer femployee) {
		if(femployee==null){
			Femployee=0;
		}
 		Femployee = femployee;
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
	public String getFfavorPolicy() {
		return FfavorPolicy;
	}
	public void setFfavorPolicy(String ffavorPolicy) {
		if(ffavorPolicy==null){
			FfavorPolicy="";
		}
		FfavorPolicy = ffavorPolicy;
	}
	public String getFFax() {
		return FFax;
	}
	public void setFFax(String fFax) {
		if(fFax==null){
			FFax="";
		}
		FFax = fFax;
	}
	public Integer getFFlat() {
		return FFlat;
	}
	public void setFFlat(Integer fFlat) {
		if(fFlat==null){
			FFlat=0;
		}
		FFlat = fFlat;
	}
	public String getFHomePage() {
		return FHomePage;
	}
	public void setFHomePage(String fHomePage) {
		if(fHomePage==null){
			FHomePage="";
		}
		FHomePage = fHomePage;
	}
	public Integer getFItemID() {
		return FItemID;
	}
	public void setFItemID(Integer fItemID) {
		if(fItemID==null){
			FItemID=0;
		}
		FItemID = fItemID;
	}
	
}
