package com.ouyeelf.ftz.model.domain.codeset;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 代码集: T_HX_CODESET
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="T_HX_CODESET")
public class Codeset  extends BSBaseDomain{
	//代码集编码 : CODESET_CODE 		
				@Id
				@Column(name="CODESET_CODE")
	private String codesetCode; 
	
	//代码集名称 : CODESET_NAME 		
					@Column(name="CODESET_NAME")
	private String codesetName; 
	
	//代码集英文名称 : CODESET_ENG_NAME 		
					@Column(name="CODESET_ENG_NAME")
	private String codesetEngName; 
	
	//国标码 : GB_CODE 		
					@Column(name="GB_CODE")
	private String gbCode; 
	
	//备注 : REMARK 		
					@Column(name="REMARK")
	private String remark; 
	
	//是否有层级 : HAS_LEVEL 		
					@Column(name="HAS_LEVEL")
	private String hasLevel; 
	
	//创建人 : CREATE_USER_LABEL 		
					@Column(name="CREATE_USER_LABEL")
	private String createUserLabel; 
	
	//修改人 : UPDATE_USER_LABEL 		
					@Column(name="UPDATE_USER_LABEL")
	private String updateUserLabel; 
	
	//删除人 : DELETE_USER_LABEL 		
					@Column(name="DELETE_USER_LABEL")
	private String deleteUserLabel; 
	
	//创建时间 : CREATE_DATE 		
					@Column(name="CREATE_DATE")
	private java.util.Date createDate; 
	
	//修改时间 : UPDATE_DATE 		
					@Column(name="UPDATE_DATE")
	private java.util.Date updateDate; 
	
	//删除时间 : DELETE_DATE 		
					@Column(name="DELETE_DATE")
	private java.util.Date deleteDate; 
	
	//版本号 : RECORD_VERSION 		
					@Column(name="RECORD_VERSION")
	private Integer recordVersion; 
	

	/**
	 * 代码集编码 : CODESET_CODE
	 * 
	 * @return 
	 */
	public String getCodesetCode () {
		return codesetCode;
	}
	
	/**
	 * 代码集编码 : CODESET_CODE
	 * 
	 * @return 
	 */
	public void setCodesetCode (String codesetCode) {
		this.codesetCode = codesetCode;
	}
	/**
	 * 代码集名称 : CODESET_NAME
	 * 
	 * @return 
	 */
	public String getCodesetName () {
		return codesetName;
	}
	
	/**
	 * 代码集名称 : CODESET_NAME
	 * 
	 * @return 
	 */
	public void setCodesetName (String codesetName) {
		this.codesetName = codesetName;
	}
	/**
	 * 代码集英文名称 : CODESET_ENG_NAME
	 * 
	 * @return 
	 */
	public String getCodesetEngName () {
		return codesetEngName;
	}
	
	/**
	 * 代码集英文名称 : CODESET_ENG_NAME
	 * 
	 * @return 
	 */
	public void setCodesetEngName (String codesetEngName) {
		this.codesetEngName = codesetEngName;
	}
	/**
	 * 国标码 : GB_CODE
	 * 
	 * @return 
	 */
	public String getGbCode () {
		return gbCode;
	}
	
	/**
	 * 国标码 : GB_CODE
	 * 
	 * @return 
	 */
	public void setGbCode (String gbCode) {
		this.gbCode = gbCode;
	}
	/**
	 * 备注 : REMARK
	 * 
	 * @return 
	 */
	public String getRemark () {
		return remark;
	}
	
	/**
	 * 备注 : REMARK
	 * 
	 * @return 
	 */
	public void setRemark (String remark) {
		this.remark = remark;
	}
	/**
	 * 是否有层级 : HAS_LEVEL
	 * 
	 * @return 
	 */
	public String getHasLevel () {
		return hasLevel;
	}
	
	/**
	 * 是否有层级 : HAS_LEVEL
	 * 
	 * @return 
	 */
	public void setHasLevel (String hasLevel) {
		this.hasLevel = hasLevel;
	}
	/**
	 * 创建人 : CREATE_USER_LABEL
	 * 
	 * @return 
	 */
	public String getCreateUserLabel () {
		return createUserLabel;
	}
	
	/**
	 * 创建人 : CREATE_USER_LABEL
	 * 
	 * @return 
	 */
	public void setCreateUserLabel (String createUserLabel) {
		this.createUserLabel = createUserLabel;
	}
	/**
	 * 修改人 : UPDATE_USER_LABEL
	 * 
	 * @return 
	 */
	public String getUpdateUserLabel () {
		return updateUserLabel;
	}
	
	/**
	 * 修改人 : UPDATE_USER_LABEL
	 * 
	 * @return 
	 */
	public void setUpdateUserLabel (String updateUserLabel) {
		this.updateUserLabel = updateUserLabel;
	}
	/**
	 * 删除人 : DELETE_USER_LABEL
	 * 
	 * @return 
	 */
	public String getDeleteUserLabel () {
		return deleteUserLabel;
	}
	
	/**
	 * 删除人 : DELETE_USER_LABEL
	 * 
	 * @return 
	 */
	public void setDeleteUserLabel (String deleteUserLabel) {
		this.deleteUserLabel = deleteUserLabel;
	}
	/**
	 * 创建时间 : CREATE_DATE
	 * 
	 * @return 
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}
	
	/**
	 * 创建时间 : CREATE_DATE
	 * 
	 * @return 
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 修改时间 : UPDATE_DATE
	 * 
	 * @return 
	 */
	public java.util.Date getUpdateDate () {
		return updateDate;
	}
	
	/**
	 * 修改时间 : UPDATE_DATE
	 * 
	 * @return 
	 */
	public void setUpdateDate (java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 删除时间 : DELETE_DATE
	 * 
	 * @return 
	 */
	public java.util.Date getDeleteDate () {
		return deleteDate;
	}
	
	/**
	 * 删除时间 : DELETE_DATE
	 * 
	 * @return 
	 */
	public void setDeleteDate (java.util.Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	/**
	 * 版本号 : RECORD_VERSION
	 * 
	 * @return 
	 */
	public Integer getRecordVersion () {
		return recordVersion;
	}
	
	/**
	 * 版本号 : RECORD_VERSION
	 * 
	 * @return 
	 */
	public void setRecordVersion (Integer recordVersion) {
		this.recordVersion = recordVersion;
	}

}
