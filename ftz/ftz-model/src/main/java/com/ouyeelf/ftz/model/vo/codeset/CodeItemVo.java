package com.ouyeelf.ftz.model.vo.codeset;

import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.ouyeelf.ftz.model.vo.BSBaseVo;
/**
 * 代码项
 * 
 * 
 * @author Gen
 */
public class CodeItemVo  extends BSBaseVo{
	//代码项ID : ITEM_ID 		
	    @Size(min = 0, max = 10)
		private String itemId; 
	
	//代码集编码 : CODESET_CODE 		
	    @Size(min = 0, max = 36)
		private String codesetCode; 
	    
	//代码项编码 : ITEM_CODE 	
	    @Size(min = 0, max = 36)
		private String itemCode; 
	
	//上级代码项编码 : PARENT_ITEM_CODE 		
	    @Size(min = 0, max = 36)
		private String parentItemCode; 
	
	//代码项中文名 : ITEM_CHS_CODE 		
	    @Size(min = 0, max = 256)
		private String itemChsCode; 
	
	//代码项英文名 : ITEM_ENG_CODE 		
	    @Size(min = 0, max = 256)
		private String itemEngCode; 
	
	//有效标识 : ITEM_STATUS 		
	    @Size(min = 0, max = 2)
		private String itemStatus; 
	
	//层级 : CODE_LEVEL 		
	    @Size(min = 0, max = 8)
		private Integer codeLevel; 
	
	//是否有子节点 : HAS_CHILDREN 		
	    @Size(min = 0, max = 2)
		private String hasChildren; 
	
	//排序 : DISPLAY_ORDER 		
	    @NumberFormat(style = Style.NUMBER)
		private Integer displayOrder; 
	
	//分类标识 : CATALOGIC_FLAG 		
	    @Size(min = 0, max = 16)
		private String catalogicFlag; 
	
	//备注 : REMARK 		
	    @Size(min = 0, max = 256)
		private String remark; 
	
	//创建人 : CREATE_USER_LABEL 		
	    @Size(min = 0, max = 32)
		private String createUserLabel; 
	
	//修改人 : UPDATE_USER_LABEL 		
	    @Size(min = 0, max = 32)
		private String updateUserLabel; 
	
	//删除人 : DELETE_USER_LABEL 		
	    @Size(min = 0, max = 32)
		private String deleteUserLabel; 
	
	//创建时间 : CREATE_DATE 		
				    	@DateTimeFormat(iso=ISO.DATE_TIME)
	    		private java.util.Date createDate; 
	
	//修改时间 : UPDATE_DATE 		
				    	@DateTimeFormat(iso=ISO.DATE_TIME)
	    		private java.util.Date updateDate; 
	
	//删除时间 : DELETE_DATE 		
				    	@DateTimeFormat(iso=ISO.DATE_TIME)
	    		private java.util.Date deleteDate; 
	
	//版本号 : RECORD_VERSION 		
	    @Size(min = 0, max = 22)
		private Integer recordVersion; 
	

	/**
	 * 代码项ID : ITEM_ID
	 * 
	 * @return 
	 */
	public String getItemId () {
		return itemId;
	}
	
	/**
	 * 代码项ID : ITEM_ID
	 * 
	 * @return 
	 */
	public void setItemId (String itemId) {
		this.itemId = itemId;
	}
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
	 * 代码项编码 : ITEM_CODE
	 * 
	 * @return 
	 */
	public String getItemCode () {
		return itemCode;
	}
	
	/**
	 * 代码项编码 : ITEM_CODE
	 * 
	 * @return 
	 */
	public void setItemCode (String itemCode) {
		this.itemCode = itemCode;
	}
	/**
	 * 上级代码项编码 : PARENT_ITEM_CODE
	 * 
	 * @return 
	 */
	public String getParentItemCode () {
		return parentItemCode;
	}
	
	/**
	 * 上级代码项编码 : PARENT_ITEM_CODE
	 * 
	 * @return 
	 */
	public void setParentItemCode (String parentItemCode) {
		this.parentItemCode = parentItemCode;
	}
	/**
	 * 代码项中文名 : ITEM_CHS_CODE
	 * 
	 * @return 
	 */
	public String getItemChsCode () {
		return itemChsCode;
	}
	
	/**
	 * 代码项中文名 : ITEM_CHS_CODE
	 * 
	 * @return 
	 */
	public void setItemChsCode (String itemChsCode) {
		this.itemChsCode = itemChsCode;
	}
	/**
	 * 代码项英文名 : ITEM_ENG_CODE
	 * 
	 * @return 
	 */
	public String getItemEngCode () {
		return itemEngCode;
	}
	
	/**
	 * 代码项英文名 : ITEM_ENG_CODE
	 * 
	 * @return 
	 */
	public void setItemEngCode (String itemEngCode) {
		this.itemEngCode = itemEngCode;
	}
	/**
	 * 有效标识 : ITEM_STATUS
	 * 
	 * @return 
	 */
	public String getItemStatus () {
		return itemStatus;
	}
	
	/**
	 * 有效标识 : ITEM_STATUS
	 * 
	 * @return 
	 */
	public void setItemStatus (String itemStatus) {
		this.itemStatus = itemStatus;
	}
	/**
	 * 层级 : CODE_LEVEL
	 * 
	 * @return 
	 */
	public Integer getCodeLevel () {
		return codeLevel;
	}
	
	/**
	 * 层级 : CODE_LEVEL
	 * 
	 * @return 
	 */
	public void setCodeLevel (Integer codeLevel) {
		this.codeLevel = codeLevel;
	}
	/**
	 * 是否有子节点 : HAS_CHILDREN
	 * 
	 * @return 
	 */
	public String getHasChildren () {
		return hasChildren;
	}
	
	/**
	 * 是否有子节点 : HAS_CHILDREN
	 * 
	 * @return 
	 */
	public void setHasChildren (String hasChildren) {
		this.hasChildren = hasChildren;
	}
	/**
	 * 排序 : DISPLAY_ORDER
	 * 
	 * @return 
	 */
	public Integer getDisplayOrder () {
		return displayOrder;
	}
	
	/**
	 * 排序 : DISPLAY_ORDER
	 * 
	 * @return 
	 */
	public void setDisplayOrder (Integer displayOrder) {
		this.displayOrder = displayOrder;
	}
	/**
	 * 分类标识 : CATALOGIC_FLAG
	 * 
	 * @return 
	 */
	public String getCatalogicFlag () {
		return catalogicFlag;
	}
	
	/**
	 * 分类标识 : CATALOGIC_FLAG
	 * 
	 * @return 
	 */
	public void setCatalogicFlag (String catalogicFlag) {
		this.catalogicFlag = catalogicFlag;
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
