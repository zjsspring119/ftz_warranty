package com.ouyeelf.ftz.model.vo.codeset;

import java.util.List;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.ouyeelf.ftz.model.vo.BSBaseVo;

/**
 * 代码集
 * 
 * 
 * @author Gen
 */
public class CodesetVo extends BSBaseVo {
	// 代码集编码 : CODESET_CODE
	@NotEmpty
	@Size(min = 0, max = 36)
	private String codesetCode;
	
	// 代码集名称 : CODESET_NAME
	@Size(min = 0, max = 64)
	private String codesetName;

	// 代码集英文名称 : CODESET_ENG_NAME
	@Size(min = 0, max = 64)
	private String codesetEngName;

	// 国标码 : GB_CODE
	@Size(min = 0, max = 32)
	private String gbCode;

	// 备注 : REMARK
	@Size(min = 0, max = 256)
	private String remark;

	// 是否有层级 : HAS_LEVEL
	@Size(min = 0, max = 2)
	private String hasLevel;

	// 创建人 : CREATE_USER_LABEL
	@Size(min = 0, max = 32)
	private String createUserLabel;

	// 修改人 : UPDATE_USER_LABEL
	@Size(min = 0, max = 32)
	private String updateUserLabel;

	// 删除人 : DELETE_USER_LABEL
	@Size(min = 0, max = 32)
	private String deleteUserLabel;

	// 创建时间 : CREATE_DATE
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private java.util.Date createDate;

	// 修改时间 : UPDATE_DATE
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private java.util.Date updateDate;

	// 删除时间 : DELETE_DATE
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private java.util.Date deleteDate;

	// 版本号 : RECORD_VERSION
	private Integer recordVersion;

	private List<CodeItemVo> codeItems;
	
	@NumberFormat(style = Style.NUMBER)	
	private Integer codeItemSize;

	/**
	 * 代码集编码 : CODESET_CODE
	 * 
	 * @return
	 */
	public String getCodesetCode() {
		return codesetCode;
	}

	/**
	 * 代码集编码 : CODESET_CODE
	 * 
	 * @return
	 */
	public void setCodesetCode(String codesetCode) {
		this.codesetCode = codesetCode;
	}

	/**
	 * 代码集名称 : CODESET_NAME
	 * 
	 * @return
	 */
	public String getCodesetName() {
		return codesetName;
	}

	/**
	 * 代码集名称 : CODESET_NAME
	 * 
	 * @return
	 */
	public void setCodesetName(String codesetName) {
		this.codesetName = codesetName;
	}

	/**
	 * 代码集英文名称 : CODESET_ENG_NAME
	 * 
	 * @return
	 */
	public String getCodesetEngName() {
		return codesetEngName;
	}

	/**
	 * 代码集英文名称 : CODESET_ENG_NAME
	 * 
	 * @return
	 */
	public void setCodesetEngName(String codesetEngName) {
		this.codesetEngName = codesetEngName;
	}

	/**
	 * 国标码 : GB_CODE
	 * 
	 * @return
	 */
	public String getGbCode() {
		return gbCode;
	}

	/**
	 * 国标码 : GB_CODE
	 * 
	 * @return
	 */
	public void setGbCode(String gbCode) {
		this.gbCode = gbCode;
	}

	/**
	 * 备注 : REMARK
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注 : REMARK
	 * 
	 * @return
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 是否有层级 : HAS_LEVEL
	 * 
	 * @return
	 */
	public String getHasLevel() {
		return hasLevel;
	}

	/**
	 * 是否有层级 : HAS_LEVEL
	 * 
	 * @return
	 */
	public void setHasLevel(String hasLevel) {
		this.hasLevel = hasLevel;
	}

	/**
	 * 创建人 : CREATE_USER_LABEL
	 * 
	 * @return
	 */
	public String getCreateUserLabel() {
		return createUserLabel;
	}

	/**
	 * 创建人 : CREATE_USER_LABEL
	 * 
	 * @return
	 */
	public void setCreateUserLabel(String createUserLabel) {
		this.createUserLabel = createUserLabel;
	}

	/**
	 * 修改人 : UPDATE_USER_LABEL
	 * 
	 * @return
	 */
	public String getUpdateUserLabel() {
		return updateUserLabel;
	}

	/**
	 * 修改人 : UPDATE_USER_LABEL
	 * 
	 * @return
	 */
	public void setUpdateUserLabel(String updateUserLabel) {
		this.updateUserLabel = updateUserLabel;
	}

	/**
	 * 删除人 : DELETE_USER_LABEL
	 * 
	 * @return
	 */
	public String getDeleteUserLabel() {
		return deleteUserLabel;
	}

	/**
	 * 删除人 : DELETE_USER_LABEL
	 * 
	 * @return
	 */
	public void setDeleteUserLabel(String deleteUserLabel) {
		this.deleteUserLabel = deleteUserLabel;
	}

	/**
	 * 创建时间 : CREATE_DATE
	 * 
	 * @return
	 */
	public java.util.Date getCreateDate() {
		return createDate;
	}

	/**
	 * 创建时间 : CREATE_DATE
	 * 
	 * @return
	 */
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 修改时间 : UPDATE_DATE
	 * 
	 * @return
	 */
	public java.util.Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * 修改时间 : UPDATE_DATE
	 * 
	 * @return
	 */
	public void setUpdateDate(java.util.Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * 删除时间 : DELETE_DATE
	 * 
	 * @return
	 */
	public java.util.Date getDeleteDate() {
		return deleteDate;
	}

	/**
	 * 删除时间 : DELETE_DATE
	 * 
	 * @return
	 */
	public void setDeleteDate(java.util.Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	/**
	 * 版本号 : RECORD_VERSION
	 * 
	 * @return
	 */
	public Integer getRecordVersion() {
		return recordVersion;
	}

	/**
	 * 版本号 : RECORD_VERSION
	 * 
	 * @return
	 */
	public void setRecordVersion(Integer recordVersion) {
		this.recordVersion = recordVersion;
	}

	public Integer getCodeItemSize() {
		return codeItemSize;
	}

	public void setCodeItemSize(Integer codeItemSize) {
		this.codeItemSize = codeItemSize;
	}

	public List<CodeItemVo> getCodeItems() {
		return codeItems;
	}

	public void setCodeItems(List<CodeItemVo> codeItems) {
		this.codeItems = codeItems;
	}

}
