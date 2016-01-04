package com.ouyeelf.ftz.model.domain.compare;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 数据比对规则主表: T_HX_COMPARE_DATA
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="T_HX_COMPARE_DATA")
public class CompareData  extends BSBaseDomain{
	// : ID 
		@Id
		@Column(name="ID")
	private String id; 
	
	//仓库代码 : WAREHOUSE_NUM 		
		@Column(name="WAREHOUSE_NUM")
	private String warehouseNum; 
	
	//比对类型（1-按量按货主，2-按实物，3-按量不按货主，见小代码X012） : COMPARE_TYPE 		
		@Column(name="COMPARE_TYPE")
	private String compareType; 
	
	//接口调用方式(0-实时接口，1-文件) : INTERFACE_TYPE 		
		@Column(name="INTERFACE_TYPE")
	private String interfaceType; 
	
	//仓库是否过户（0-不过户，1-过户） : TRANSFER_TYPE 		
		@Column(name="TRANSFER_TYPE")
	private String transferType; 
	
	//仓库名称 : WAREHOUSE_NAME 		
		@Column(name="WAREHOUSE_NAME")
	private String warehouseName; 
	
	//交易平台代码 : ORG_SYS_NO 		
		@Column(name="ORG_SYS_NO")
	private String orgSysNo; 
	
	//交易平台名称 : ORG_SYS_NAME 		
		@Column(name="ORG_SYS_NAME")
	private String orgSysName; 
	
	//仓库系统接口地址（实物比对时使用） : WARE_URL 		
		@Column(name="WARE_URL")
	private String wareUrl; 
	
	//仓库系统接口类（实物比对时使用） : WARE_CLASS 		
		@Column(name="WARE_CLASS")
	private String wareClass; 
	
	//仓库系统接口方法（实物比对时使用） : WARE_METHOD 		
		@Column(name="WARE_METHOD")
	private String wareMethod; 
	
	//UECP发送方标识 : UECP_FORMID 		
		@Column(name="UECP_FORMID")
	private String uecpFormid; 
	
	//UECP接收方标识 : UECP_TOID 		
		@Column(name="UECP_TOID")
	private String uecpToid; 
	
	//UECP项目编号 : UECP_PLAT_CODE 		
		@Column(name="UECP_PLAT_CODE")
	private String uecpPlatCode; 
	

	/**
	 *  : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 *  : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 仓库代码 : WAREHOUSE_NUM
	 * 
	 * @return 
	 */
	public String getWarehouseNum () {
		return warehouseNum;
	}
	
	/**
	 * 仓库代码 : WAREHOUSE_NUM
	 * 
	 * @return 
	 */
	public void setWarehouseNum (String warehouseNum) {
		this.warehouseNum = warehouseNum;
	}
	/**
	 * 比对类型（1-按量按货主，2-按实物，3-按量不按货主，见小代码X012） : COMPARE_TYPE
	 * 
	 * @return 
	 */
	public String getCompareType () {
		return compareType;
	}
	
	/**
	 * 比对类型（1-按量按货主，2-按实物，3-按量不按货主，见小代码X012） : COMPARE_TYPE
	 * 
	 * @return 
	 */
	public void setCompareType (String compareType) {
		this.compareType = compareType;
	}
	/**
	 * 接口调用方式(0-实时接口，1-文件) : INTERFACE_TYPE
	 * 
	 * @return 
	 */
	public String getInterfaceType () {
		return interfaceType;
	}
	
	/**
	 * 接口调用方式(0-实时接口，1-文件) : INTERFACE_TYPE
	 * 
	 * @return 
	 */
	public void setInterfaceType (String interfaceType) {
		this.interfaceType = interfaceType;
	}
	/**
	 * 仓库是否过户（0-不过户，1-过户） : TRANSFER_TYPE
	 * 
	 * @return 
	 */
	public String getTransferType () {
		return transferType;
	}
	
	/**
	 * 仓库是否过户（0-不过户，1-过户） : TRANSFER_TYPE
	 * 
	 * @return 
	 */
	public void setTransferType (String transferType) {
		this.transferType = transferType;
	}
	/**
	 * 仓库名称 : WAREHOUSE_NAME
	 * 
	 * @return 
	 */
	public String getWarehouseName () {
		return warehouseName;
	}
	
	/**
	 * 仓库名称 : WAREHOUSE_NAME
	 * 
	 * @return 
	 */
	public void setWarehouseName (String warehouseName) {
		this.warehouseName = warehouseName;
	}
	/**
	 * 交易平台代码 : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public String getOrgSysNo () {
		return orgSysNo;
	}
	
	/**
	 * 交易平台代码 : ORG_SYS_NO
	 * 
	 * @return 
	 */
	public void setOrgSysNo (String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}
	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return 
	 */
	public String getOrgSysName () {
		return orgSysName;
	}
	
	/**
	 * 交易平台名称 : ORG_SYS_NAME
	 * 
	 * @return 
	 */
	public void setOrgSysName (String orgSysName) {
		this.orgSysName = orgSysName;
	}
	/**
	 * 仓库系统接口地址（实物比对时使用） : WARE_URL
	 * 
	 * @return 
	 */
	public String getWareUrl () {
		return wareUrl;
	}
	
	/**
	 * 仓库系统接口地址（实物比对时使用） : WARE_URL
	 * 
	 * @return 
	 */
	public void setWareUrl (String wareUrl) {
		this.wareUrl = wareUrl;
	}
	/**
	 * 仓库系统接口类（实物比对时使用） : WARE_CLASS
	 * 
	 * @return 
	 */
	public String getWareClass () {
		return wareClass;
	}
	
	/**
	 * 仓库系统接口类（实物比对时使用） : WARE_CLASS
	 * 
	 * @return 
	 */
	public void setWareClass (String wareClass) {
		this.wareClass = wareClass;
	}
	/**
	 * 仓库系统接口方法（实物比对时使用） : WARE_METHOD
	 * 
	 * @return 
	 */
	public String getWareMethod () {
		return wareMethod;
	}
	
	/**
	 * 仓库系统接口方法（实物比对时使用） : WARE_METHOD
	 * 
	 * @return 
	 */
	public void setWareMethod (String wareMethod) {
		this.wareMethod = wareMethod;
	}
	/**
	 * UECP发送方标识 : UECP_FORMID
	 * 
	 * @return 
	 */
	public String getUecpFormid () {
		return uecpFormid;
	}
	
	/**
	 * UECP发送方标识 : UECP_FORMID
	 * 
	 * @return 
	 */
	public void setUecpFormid (String uecpFormid) {
		this.uecpFormid = uecpFormid;
	}
	/**
	 * UECP接收方标识 : UECP_TOID
	 * 
	 * @return 
	 */
	public String getUecpToid () {
		return uecpToid;
	}
	
	/**
	 * UECP接收方标识 : UECP_TOID
	 * 
	 * @return 
	 */
	public void setUecpToid (String uecpToid) {
		this.uecpToid = uecpToid;
	}
	/**
	 * UECP项目编号 : UECP_PLAT_CODE
	 * 
	 * @return 
	 */
	public String getUecpPlatCode () {
		return uecpPlatCode;
	}
	
	/**
	 * UECP项目编号 : UECP_PLAT_CODE
	 * 
	 * @return 
	 */
	public void setUecpPlatCode (String uecpPlatCode) {
		this.uecpPlatCode = uecpPlatCode;
	}

}
