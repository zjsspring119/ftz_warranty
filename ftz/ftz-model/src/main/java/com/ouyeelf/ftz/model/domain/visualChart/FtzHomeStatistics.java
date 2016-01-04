package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 自贸区统计数据: FTZ_HOME_STATISTICS
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_HOME_STATISTICS")
public class FtzHomeStatistics  extends BSBaseDomain{
	//主键ID : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//数据类型 : DATA_TYPE 		
					@Column(name="DATA_TYPE")
	private String dataType; 
	
	//数据值 : DATA_VALUE 		
					@Column(name="DATA_VALUE")
	private java.math.BigDecimal dataValue; 
	
	//类型描述 : TYPE_DESC 		
					@Column(name="TYPE_DESC")
	private String typeDesc; 
	
	//备注 : REMARK 		
					@Column(name="REMARK")
	private String remark; 
	

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
	 * 数据类型 : DATA_TYPE
	 * 
	 * @return 
	 */
	public String getDataType () {
		return dataType;
	}
	
	/**
	 * 数据类型 : DATA_TYPE
	 * 
	 * @return 
	 */
	public void setDataType (String dataType) {
		this.dataType = dataType;
	}
	/**
	 * 数据值 : DATA_VALUE
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getDataValue () {
		return dataValue;
	}
	
	/**
	 * 数据值 : DATA_VALUE
	 * 
	 * @return 
	 */
	public void setDataValue (java.math.BigDecimal dataValue) {
		this.dataValue = dataValue;
	}
	/**
	 * 类型描述 : TYPE_DESC
	 * 
	 * @return 
	 */
	public String getTypeDesc () {
		return typeDesc;
	}
	
	/**
	 * 类型描述 : TYPE_DESC
	 * 
	 * @return 
	 */
	public void setTypeDesc (String typeDesc) {
		this.typeDesc = typeDesc;
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

}
