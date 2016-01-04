package com.ouyeelf.ftz.model.domain.warranty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 仓单货物明细扩展描述属性: RZ_WARRANTY_GOOD_EXT
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="RZ_WARRANTY_GOOD_EXT")
public class WarrantyGoodExt  extends BSBaseDomain{
	// : ID 		
		@Id
		@Column(name="ID")
	private String id; 
	
	//外键: RZ_WARRANTY_GOOD.ID : WAG_ID 		
		@Column(name="WAG_ID")
	private String wagId; 
	
	//KEY : KEY_CODE 		
		@Column(name="KEY_CODE")
	private String keyCode; 
	
	//KEY名称 : KEY_NAME 		
		@Column(name="KEY_NAME")
	private String keyName; 
	
	//VALUE内容 : VALUE 		
		@Column(name="VALUE")
	private String value; 
	
	//排序 : SEQ 		
		@Column(name="SEQ")
	private String seq; 
	

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
	 * 外键: RZ_WARRANTY_GOOD.ID : WAG_ID
	 * 
	 * @return 
	 */
	public String getWagId () {
		return wagId;
	}
	
	/**
	 * 外键: RZ_WARRANTY_GOOD.ID : WAG_ID
	 * 
	 * @return 
	 */
	public void setWagId (String wagId) {
		this.wagId = wagId;
	}
	/**
	 * KEY : KEY_CODE
	 * 
	 * @return 
	 */
	public String getKeyCode () {
		return keyCode;
	}
	
	/**
	 * KEY : KEY_CODE
	 * 
	 * @return 
	 */
	public void setKeyCode (String keyCode) {
		this.keyCode = keyCode;
	}
	/**
	 * KEY名称 : KEY_NAME
	 * 
	 * @return 
	 */
	public String getKeyName () {
		return keyName;
	}
	
	/**
	 * KEY名称 : KEY_NAME
	 * 
	 * @return 
	 */
	public void setKeyName (String keyName) {
		this.keyName = keyName;
	}
	/**
	 * VALUE内容 : VALUE
	 * 
	 * @return 
	 */
	public String getValue () {
		return value;
	}
	
	/**
	 * VALUE内容 : VALUE
	 * 
	 * @return 
	 */
	public void setValue (String value) {
		this.value = value;
	}
	/**
	 * 排序 : SEQ
	 * 
	 * @return 
	 */
	public String getSeq () {
		return seq;
	}
	
	/**
	 * 排序 : SEQ
	 * 
	 * @return 
	 */
	public void setSeq (String seq) {
		this.seq = seq;
	}

}
