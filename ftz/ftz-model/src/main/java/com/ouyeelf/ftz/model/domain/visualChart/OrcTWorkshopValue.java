package com.ouyeelf.ftz.model.domain.visualChart;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * $meta.tableDesc: ORC_T_WORKSHOP_VALUE
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="ORC_T_WORKSHOP_VALUE")
public class OrcTWorkshopValue  extends BSBaseDomain{
	// : ID 
		@Id
		@Column(name="ID")
	private String id; 
	
	// : ROLE_ID 		
		@Column(name="ROLE_ID")
	private String roleId; 
	
	// : LOGIN_MEMBER_CODE 		
		@Column(name="LOGIN_MEMBER_CODE")
	private String loginMemberCode; 
	
	// : SECTION 		
		@Column(name="SECTION")
	private String section; 
	
	// : KEY_NAME 		
		@Column(name="KEY_NAME")
	private String keyName; 
	
	// : KEY_VALUE 		
		@Column(name="KEY_VALUE")
	private String keyValue; 
	
	// : CURRENT_VALUE 		
		@Column(name="CURRENT_VALUE")
	private java.math.BigDecimal currentValue; 
	
	// : OLD_VALUE 		
		@Column(name="OLD_VALUE")
	private java.math.BigDecimal oldValue; 
	
	// : RATIO_VALUE 		
		@Column(name="RATIO_VALUE")
	private java.math.BigDecimal ratioValue; 
	
	// : UPDATE_TIME 		
		@Column(name="UPDATE_TIME")
	private java.util.Date updateTime; 
	

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
	 *  : ROLE_ID
	 * 
	 * @return 
	 */
	public String getRoleId () {
		return roleId;
	}
	
	/**
	 *  : ROLE_ID
	 * 
	 * @return 
	 */
	public void setRoleId (String roleId) {
		this.roleId = roleId;
	}
	/**
	 *  : LOGIN_MEMBER_CODE
	 * 
	 * @return 
	 */
	public String getLoginMemberCode () {
		return loginMemberCode;
	}
	
	/**
	 *  : LOGIN_MEMBER_CODE
	 * 
	 * @return 
	 */
	public void setLoginMemberCode (String loginMemberCode) {
		this.loginMemberCode = loginMemberCode;
	}
	/**
	 *  : SECTION
	 * 
	 * @return 
	 */
	public String getSection () {
		return section;
	}
	
	/**
	 *  : SECTION
	 * 
	 * @return 
	 */
	public void setSection (String section) {
		this.section = section;
	}
	/**
	 *  : KEY_NAME
	 * 
	 * @return 
	 */
	public String getKeyName () {
		return keyName;
	}
	
	/**
	 *  : KEY_NAME
	 * 
	 * @return 
	 */
	public void setKeyName (String keyName) {
		this.keyName = keyName;
	}
	/**
	 *  : KEY_VALUE
	 * 
	 * @return 
	 */
	public String getKeyValue () {
		return keyValue;
	}
	
	/**
	 *  : KEY_VALUE
	 * 
	 * @return 
	 */
	public void setKeyValue (String keyValue) {
		this.keyValue = keyValue;
	}
	/**
	 *  : CURRENT_VALUE
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getCurrentValue () {
		return currentValue;
	}
	
	/**
	 *  : CURRENT_VALUE
	 * 
	 * @return 
	 */
	public void setCurrentValue (java.math.BigDecimal currentValue) {
		this.currentValue = currentValue;
	}
	/**
	 *  : OLD_VALUE
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getOldValue () {
		return oldValue;
	}
	
	/**
	 *  : OLD_VALUE
	 * 
	 * @return 
	 */
	public void setOldValue (java.math.BigDecimal oldValue) {
		this.oldValue = oldValue;
	}
	/**
	 *  : RATIO_VALUE
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getRatioValue () {
		return ratioValue;
	}
	
	/**
	 *  : RATIO_VALUE
	 * 
	 * @return 
	 */
	public void setRatioValue (java.math.BigDecimal ratioValue) {
		this.ratioValue = ratioValue;
	}
	/**
	 *  : UPDATE_TIME
	 * 
	 * @return 
	 */
	public java.util.Date getUpdateTime () {
		return updateTime;
	}
	
	/**
	 *  : UPDATE_TIME
	 * 
	 * @return 
	 */
	public void setUpdateTime (java.util.Date updateTime) {
		this.updateTime = updateTime;
	}

}
