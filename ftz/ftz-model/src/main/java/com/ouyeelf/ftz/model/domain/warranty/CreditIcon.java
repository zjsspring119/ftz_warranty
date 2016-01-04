package com.ouyeelf.ftz.model.domain.warranty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 公示平台诚信标记图标配置: T_HX_CREDIT_ICON
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="T_HX_CREDIT_ICON")
public class CreditIcon  extends BSBaseDomain{
	// : ID 	
		@Id
		@Column(name="ID")
	private String id; 
	
	//平台类型（0-仓储，1-清算，2-海关，见小代码X011） : PLAT_TYPE 		
		@Column(name="PLAT_TYPE")
	private String platType; 
	
	//对比方式（1-按量按货主，2-按实物，3-按量不按货主，见小代码X012） : COMPARE_TYPE 		
		@Column(name="COMPARE_TYPE")
	private String compareType; 
	
	//诚信标记所对应的图片名 : ICON_NAME 		
		@Column(name="ICON_NAME")
	private String iconName; 
	

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
	 * 平台类型（0-仓储，1-清算，2-海关，见小代码X011） : PLAT_TYPE
	 * 
	 * @return 
	 */
	public String getPlatType () {
		return platType;
	}
	
	/**
	 * 平台类型（0-仓储，1-清算，2-海关，见小代码X011） : PLAT_TYPE
	 * 
	 * @return 
	 */
	public void setPlatType (String platType) {
		this.platType = platType;
	}
	/**
	 * 对比方式（1-按量按货主，2-按实物，3-按量不按货主，见小代码X012） : COMPARE_TYPE
	 * 
	 * @return 
	 */
	public String getCompareType () {
		return compareType;
	}
	
	/**
	 * 对比方式（1-按量按货主，2-按实物，3-按量不按货主，见小代码X012） : COMPARE_TYPE
	 * 
	 * @return 
	 */
	public void setCompareType (String compareType) {
		this.compareType = compareType;
	}
	/**
	 * 诚信标记所对应的图片名 : ICON_NAME
	 * 
	 * @return 
	 */
	public String getIconName () {
		return iconName;
	}
	
	/**
	 * 诚信标记所对应的图片名 : ICON_NAME
	 * 
	 * @return 
	 */
	public void setIconName (String iconName) {
		this.iconName = iconName;
	}

}
