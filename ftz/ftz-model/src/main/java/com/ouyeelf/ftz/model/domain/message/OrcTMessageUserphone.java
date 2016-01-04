package com.ouyeelf.ftz.model.domain.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 会员代码与手机关系表: ORC_T_MESSAGE_USERPHONE
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="ORC_T_MESSAGE_USERPHONE")
public class OrcTMessageUserphone  extends BSBaseDomain{
	//序号 : ID 		
	@Id
		@Column(name="ID")
	private String id; 
	
	//会员代码 : USER_CODE 		
		@Column(name="USER_CODE")
	private String userCode; 
	
	//手机号 : PHONE_NUM 		
		@Column(name="PHONE_NUM")
	private String phoneNum; 
	
	//短信类型代码（orc_t_massage_util.fccode） : FCCODE 		
		@Column(name="FCCODE")
	private String fccode; 
	
	//市场区分标识（参见X001小代码） : MARKET_FLAG 		
		@Column(name="MARKET_FLAG")
	private String marketFlag; 
	
		//会员代码
		@Column(name="CUSTOMERCODE")
	private String customerCode; 
	
		
		//会员名称
		@Column(name="CUSTOMERNAME")
	private String customerName; 
	

	/**
	 * 序号 : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 * 序号 : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 会员代码 : USER_CODE
	 * 
	 * @return 
	 */
	public String getUserCode () {
		return userCode;
	}
	
	/**
	 * 会员代码 : USER_CODE
	 * 
	 * @return 
	 */
	public void setUserCode (String userCode) {
		this.userCode = userCode;
	}
	/**
	 * 手机号 : PHONE_NUM
	 * 
	 * @return 
	 */
	public String getPhoneNum () {
		return phoneNum;
	}
	
	/**
	 * 手机号 : PHONE_NUM
	 * 
	 * @return 
	 */
	public void setPhoneNum (String phoneNum) {
		this.phoneNum = phoneNum;
	}
	/**
	 * 短信类型代码（orc_t_massage_util.fccode） : FCCODE
	 * 
	 * @return 
	 */
	public String getFccode () {
		return fccode;
	}
	
	/**
	 * 短信类型代码（orc_t_massage_util.fccode） : FCCODE
	 * 
	 * @return 
	 */
	public void setFccode (String fccode) {
		this.fccode = fccode;
	}
	/**
	 * 市场区分标识（参见X001小代码） : MARKET_FLAG
	 * 
	 * @return 
	 */
	public String getMarketFlag () {
		return marketFlag;
	}
	
	/**
	 * 市场区分标识（参见X001小代码） : MARKET_FLAG
	 * 
	 * @return 
	 */
	public void setMarketFlag (String marketFlag) {
		this.marketFlag = marketFlag;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	
}
