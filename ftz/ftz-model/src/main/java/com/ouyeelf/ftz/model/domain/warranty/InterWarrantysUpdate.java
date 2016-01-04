package com.ouyeelf.ftz.model.domain.warranty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 接口表-仓单状态更新表: INTER_WARRANTYS_UPDATE
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name = "INTER_WARRANTYS_UPDATE")
public class InterWarrantysUpdate extends BSBaseDomain {
	// : ID
	@Id
	@Column(name = "ID")
	private String id;

	// 仓单登记号 : WARRANTY_NO
	@Column(name = "WARRANTY_NO")
	private String warrantyNo;

	// 接收的新仓单状态 : NEW_STATUS
	@Column(name = "NEW_STATUS")
	private String newStatus;

	// 调用的接口名称 : INTERFACE_NAME
	@Column(name = "INTERFACE_NAME")
	private String interfaceName;

	// 返回的状态1成功；0失败 : RETURN_CODE
	@Column(name = "RETURN_CODE")
	private String returnCode;

	// 错误描述（失败时填写） : ERR_MSG_DESC
	@Column(name = "ERR_MSG_DESC")
	private String errMsgDesc;

	// 成交对象代码（锁定和过户时填写） : NEW_CUST_CODE
	@Column(name = "NEW_CUST_CODE")
	private String newCustCode;

	// 成交对象名称（锁定和过户时填写） : NEW_CUST_NAME
	@Column(name = "NEW_CUST_NAME")
	private String newCustName;

	// 原货主代码（锁定和过户时填写） : ORG_CUST_CODE
	@Column(name = "ORG_CUST_CODE")
	private String orgCustCode;

	// 原货主名称（锁定和过户时填写） : ORG_CUST_NAME
	@Column(name = "ORG_CUST_NAME")
	private String orgCustName;

	// 交易单号（锁定时填写） : BUSSINESS_NO
	@Column(name = "BUSSINESS_NO")
	private String bussinessNo;

	// 交易价格（锁定时填写） : BUSSINESS_PRICE
	@Column(name = "BUSSINESS_PRICE")
	private java.math.BigDecimal bussinessPrice;

	// 交易数量（锁定时填写） : BUSSINESS_NUMBER
	@Column(name = "BUSSINESS_NUMBER")
	private java.math.BigDecimal bussinessNumber;

	// 更新时间 : UPDATE_TIME
	@Column(name = "UPDATE_TIME")
	private java.util.Date updateTime;

	// 业务系统别（交易平台代码） : ORG_SYS_NO
	@Column(name = "ORG_SYS_NO")
	private String orgSysNo;

	// 老仓单状态 : OLD_STATUS
	@Column(name = "OLD_STATUS")
	private String oldStatus;
	// 成交时间(YYYY-MM-DD HH:MI:SS) : BUSSINESS_TIME
	@Column(name = "BUSSINESS_TIME")
	private String bussinessTime;

	// 成交对象名称（锁定和过户时填写） : NEW_CUST_NAME
	@Column(name = "NEW_CUST_ENAME")
	private String newCustEName;

	/**
	 * : ID
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * : ID
	 * 
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 仓单登记号 : WARRANTY_NO
	 * 
	 * @return
	 */
	public String getWarrantyNo() {
		return warrantyNo;
	}

	/**
	 * 仓单登记号 : WARRANTY_NO
	 * 
	 * @return
	 */
	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	/**
	 * 接收的新仓单状态 : NEW_STATUS
	 * 
	 * @return
	 */
	public String getNewStatus() {
		return newStatus;
	}

	/**
	 * 接收的新仓单状态 : NEW_STATUS
	 * 
	 * @return
	 */
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}

	/**
	 * 调用的接口名称 : INTERFACE_NAME
	 * 
	 * @return
	 */
	public String getInterfaceName() {
		return interfaceName;
	}

	/**
	 * 调用的接口名称 : INTERFACE_NAME
	 * 
	 * @return
	 */
	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	/**
	 * 返回的状态1成功；0失败 : RETURN_CODE
	 * 
	 * @return
	 */
	public String getReturnCode() {
		return returnCode;
	}

	/**
	 * 返回的状态1成功；0失败 : RETURN_CODE
	 * 
	 * @return
	 */
	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	/**
	 * 错误描述（失败时填写） : ERR_MSG_DESC
	 * 
	 * @return
	 */
	public String getErrMsgDesc() {
		return errMsgDesc;
	}

	/**
	 * 错误描述（失败时填写） : ERR_MSG_DESC
	 * 
	 * @return
	 */
	public void setErrMsgDesc(String errMsgDesc) {
		this.errMsgDesc = errMsgDesc;
	}

	/**
	 * 成交对象代码（锁定和过户时填写） : NEW_CUST_CODE
	 * 
	 * @return
	 */
	public String getNewCustCode() {
		return newCustCode;
	}

	/**
	 * 成交对象代码（锁定和过户时填写） : NEW_CUST_CODE
	 * 
	 * @return
	 */
	public void setNewCustCode(String newCustCode) {
		this.newCustCode = newCustCode;
	}

	/**
	 * 成交对象名称（锁定和过户时填写） : NEW_CUST_NAME
	 * 
	 * @return
	 */
	public String getNewCustName() {
		return newCustName;
	}

	/**
	 * 成交对象名称（锁定和过户时填写） : NEW_CUST_NAME
	 * 
	 * @return
	 */
	public void setNewCustName(String newCustName) {
		this.newCustName = newCustName;
	}

	/**
	 * 原货主代码（锁定和过户时填写） : ORG_CUST_CODE
	 * 
	 * @return
	 */
	public String getOrgCustCode() {
		return orgCustCode;
	}

	/**
	 * 原货主代码（锁定和过户时填写） : ORG_CUST_CODE
	 * 
	 * @return
	 */
	public void setOrgCustCode(String orgCustCode) {
		this.orgCustCode = orgCustCode;
	}

	/**
	 * 原货主名称（锁定和过户时填写） : ORG_CUST_NAME
	 * 
	 * @return
	 */
	public String getOrgCustName() {
		return orgCustName;
	}

	/**
	 * 原货主名称（锁定和过户时填写） : ORG_CUST_NAME
	 * 
	 * @return
	 */
	public void setOrgCustName(String orgCustName) {
		this.orgCustName = orgCustName;
	}

	/**
	 * 交易单号（锁定时填写） : BUSSINESS_NO
	 * 
	 * @return
	 */
	public String getBussinessNo() {
		return bussinessNo;
	}

	/**
	 * 交易单号（锁定时填写） : BUSSINESS_NO
	 * 
	 * @return
	 */
	public void setBussinessNo(String bussinessNo) {
		this.bussinessNo = bussinessNo;
	}

	/**
	 * 交易价格（锁定时填写） : BUSSINESS_PRICE
	 * 
	 * @return
	 */
	public java.math.BigDecimal getBussinessPrice() {
		return bussinessPrice;
	}

	/**
	 * 交易价格（锁定时填写） : BUSSINESS_PRICE
	 * 
	 * @return
	 */
	public void setBussinessPrice(java.math.BigDecimal bussinessPrice) {
		this.bussinessPrice = bussinessPrice;
	}

	/**
	 * 交易数量（锁定时填写） : BUSSINESS_NUMBER
	 * 
	 * @return
	 */
	public java.math.BigDecimal getBussinessNumber() {
		return bussinessNumber;
	}

	/**
	 * 交易数量（锁定时填写） : BUSSINESS_NUMBER
	 * 
	 * @return
	 */
	public void setBussinessNumber(java.math.BigDecimal bussinessNumber) {
		this.bussinessNumber = bussinessNumber;
	}

	/**
	 * 更新时间 : UPDATE_TIME
	 * 
	 * @return
	 */
	public java.util.Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间 : UPDATE_TIME
	 * 
	 * @return
	 */
	public void setUpdateTime(java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 业务系统别（交易平台代码） : ORG_SYS_NO
	 * 
	 * @return
	 */
	public String getOrgSysNo() {
		return orgSysNo;
	}

	/**
	 * 业务系统别（交易平台代码） : ORG_SYS_NO
	 * 
	 * @return
	 */
	public void setOrgSysNo(String orgSysNo) {
		this.orgSysNo = orgSysNo;
	}

	/**
	 * 老仓单状态 : OLD_STATUS
	 * 
	 * @return
	 */
	public String getOldStatus() {
		return oldStatus;
	}

	/**
	 * 老仓单状态 : OLD_STATUS
	 * 
	 * @return
	 */
	public void setOldStatus(String oldStatus) {
		this.oldStatus = oldStatus;
	}

	public String getBussinessTime() {
		return bussinessTime;
	}

	public void setBussinessTime(String bussinessTime) {
		this.bussinessTime = bussinessTime;
	}

	public String getNewCustEName() {
		return newCustEName;
	}

	public void setNewCustEName(String newCustEName) {
		this.newCustEName = newCustEName;
	}

}
