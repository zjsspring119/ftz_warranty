package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 自贸区每日基础统计数据: FTZ_WARRANTY_BASIS_COUNT
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_WARRANTY_BASIS_COUNT")
public class FtzWarrantyBasisCount  extends BSBaseDomain{
	//主键ID : ID 		
		@Id
		@Column(name="ID")
	private String id; 
	
	//创建时间（yyyy/mm/dd） : CREATE_DATE 		
		@Column(name="CREATE_DATE")
	private String createDate; 
	
	//数值 : DATA_VALUE 		
		@Column(name="DATA_VALUE")
	private java.math.BigDecimal dataValue; 
	
	//数值类型 : DATA_TYPE 		
		@Column(name="DATA_TYPE")
	private String dataType; 
	
	//数据描述 : DATA_DESC 		
		@Column(name="DATA_DESC")
	private String dataDesc; 
	

	/**
	 * 主键ID : ID
	 * 
	 * @return 
	 */
	public String getId () {
		return id;
	}
	
	/**
	 * 主键ID : ID
	 * 
	 * @return 
	 */
	public void setId (String id) {
		this.id = id;
	}
	/**
	 * 创建时间（yyyy/mm/dd） : CREATE_DATE
	 * 
	 * @return 
	 */
	public String getCreateDate () {
		return createDate;
	}
	
	/**
	 * 创建时间（yyyy/mm/dd） : CREATE_DATE
	 * 
	 * @return 
	 */
	public void setCreateDate (String createDate) {
		this.createDate = createDate;
	}
	/**
	 * 数值 : DATA_VALUE
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getDataValue () {
		return dataValue;
	}
	
	/**
	 * 数值 : DATA_VALUE
	 * 
	 * @return 
	 */
	public void setDataValue (java.math.BigDecimal dataValue) {
		this.dataValue = dataValue;
	}
	/**
	 * 数值类型 : DATA_TYPE
	 * 
	 * @return 
	 */
	public String getDataType () {
		return dataType;
	}
	
	/**
	 * 数值类型 : DATA_TYPE
	 * 
	 * @return 
	 */
	public void setDataType (String dataType) {
		this.dataType = dataType;
	}
	/**
	 * 数据描述 : DATA_DESC
	 * 
	 * @return 
	 */
	public String getDataDesc () {
		return dataDesc;
	}
	
	/**
	 * 数据描述 : DATA_DESC
	 * 
	 * @return 
	 */
	public void setDataDesc (String dataDesc) {
		this.dataDesc = dataDesc;
	}

}
