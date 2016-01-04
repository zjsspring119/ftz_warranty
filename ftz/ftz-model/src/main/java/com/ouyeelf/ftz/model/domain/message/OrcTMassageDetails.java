package com.ouyeelf.ftz.model.domain.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * $meta.tableDesc: ORC_T_MASSAGE_DETAILS
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="ORC_T_MASSAGE_DETAILS")
public class OrcTMassageDetails  extends BSBaseDomain{
	// : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//会员代码 : USERCODE 		
					@Column(name="USERCODE")
	private String usercode; 
	
	//会员名称 : USERNAME 		
					@Column(name="USERNAME")
	private String username; 
	
	//手机号 : PHONE 		
					@Column(name="PHONE")
	private String phone; 
	
	//短信文本 : TEXT 		
					@Column(name="TEXT")
	private String text; 
	
	//是否发送成功（1：成功，0失败） : FLAG 		
					@Column(name="FLAG")
	private String flag; 
	
	//二级功能节点（短信发送点:参照orc_t_message_util 表） : FCCODE 		
					@Column(name="FCCODE")
	private String fccode; 
	
	//发送时间 : SENDTIME 		
					@Column(name="SENDTIME")
	private String sendtime; 
	
	//发送次数 : SENDTIMES 		
					@Column(name="SENDTIMES")
	private java.math.BigDecimal sendtimes; 
	

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
	 * 会员代码 : USERCODE
	 * 
	 * @return 
	 */
	public String getUsercode () {
		return usercode;
	}
	
	/**
	 * 会员代码 : USERCODE
	 * 
	 * @return 
	 */
	public void setUsercode (String usercode) {
		this.usercode = usercode;
	}
	/**
	 * 会员名称 : USERNAME
	 * 
	 * @return 
	 */
	public String getUsername () {
		return username;
	}
	
	/**
	 * 会员名称 : USERNAME
	 * 
	 * @return 
	 */
	public void setUsername (String username) {
		this.username = username;
	}
	/**
	 * 手机号 : PHONE
	 * 
	 * @return 
	 */
	public String getPhone () {
		return phone;
	}
	
	/**
	 * 手机号 : PHONE
	 * 
	 * @return 
	 */
	public void setPhone (String phone) {
		this.phone = phone;
	}
	/**
	 * 短信文本 : TEXT
	 * 
	 * @return 
	 */
	public String getText () {
		return text;
	}
	
	/**
	 * 短信文本 : TEXT
	 * 
	 * @return 
	 */
	public void setText (String text) {
		this.text = text;
	}
	/**
	 * 是否发送成功（1：成功，0失败） : FLAG
	 * 
	 * @return 
	 */
	public String getFlag () {
		return flag;
	}
	
	/**
	 * 是否发送成功（1：成功，0失败） : FLAG
	 * 
	 * @return 
	 */
	public void setFlag (String flag) {
		this.flag = flag;
	}
	/**
	 * 二级功能节点（短信发送点:参照orc_t_message_util 表） : FCCODE
	 * 
	 * @return 
	 */
	public String getFccode () {
		return fccode;
	}
	
	/**
	 * 二级功能节点（短信发送点:参照orc_t_message_util 表） : FCCODE
	 * 
	 * @return 
	 */
	public void setFccode (String fccode) {
		this.fccode = fccode;
	}
	/**
	 * 发送时间 : SENDTIME
	 * 
	 * @return 
	 */
	public String getSendtime () {
		return sendtime;
	}
	
	/**
	 * 发送时间 : SENDTIME
	 * 
	 * @return 
	 */
	public void setSendtime (String sendtime) {
		this.sendtime = sendtime;
	}
	/**
	 * 发送次数 : SENDTIMES
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getSendtimes () {
		return sendtimes;
	}
	
	/**
	 * 发送次数 : SENDTIMES
	 * 
	 * @return 
	 */
	public void setSendtimes (java.math.BigDecimal sendtimes) {
		this.sendtimes = sendtimes;
	}

}
