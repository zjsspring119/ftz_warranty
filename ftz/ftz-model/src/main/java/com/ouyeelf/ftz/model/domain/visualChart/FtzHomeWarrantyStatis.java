package com.ouyeelf.ftz.model.domain.visualChart;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 自贸区（公示）首页仓单数据统计: FTZ_HOME_WARRANTY_STATIS
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="FTZ_HOME_WARRANTY_STATIS")
public class FtzHomeWarrantyStatis  extends BSBaseDomain{
	//主键ID : ID 	
		@Id
		@Column(name="ID")
	private String id; 
	
	//数据类型 : DATA_TYPE 		
		@Column(name="DATA_TYPE")
	private String dataType; 
	
	//仓单号 : WARRANTY_NO 		
		@Column(name="WARRANTY_NO")
	private String warrantyNo; 
	
	//仓库名称 : WAREHOUSE_NAME 		
		@Column(name="WAREHOUSE_NAME")
	private String warehouseName; 
	
	//数据状态 : DATA_STATUS 		
		@Column(name="DATA_STATUS")
	private String dataStatus; 
	
	//数据类型描述 : TPYE_DESC 		
		@Column(name="TPYE_DESC")
	private String tpyeDesc; 
	

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
	 * 仓单号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public String getWarrantyNo () {
		return warrantyNo;
	}
	
	/**
	 * 仓单号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public void setWarrantyNo (String warrantyNo) {
		this.warrantyNo = warrantyNo;
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
	 * 数据状态 : DATA_STATUS
	 * 
	 * @return 
	 */
	public String getDataStatus () {
		return dataStatus;
	}
	
	/**
	 * 数据状态 : DATA_STATUS
	 * 
	 * @return 
	 */
	public void setDataStatus (String dataStatus) {
		this.dataStatus = dataStatus;
	}
	/**
	 * 数据类型描述 : TPYE_DESC
	 * 
	 * @return 
	 */
	public String getTpyeDesc () {
		return tpyeDesc;
	}
	
	/**
	 * 数据类型描述 : TPYE_DESC
	 * 
	 * @return 
	 */
	public void setTpyeDesc (String tpyeDesc) {
		this.tpyeDesc = tpyeDesc;
	}

}
