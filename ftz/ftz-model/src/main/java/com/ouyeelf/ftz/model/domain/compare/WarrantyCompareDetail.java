package com.ouyeelf.ftz.model.domain.compare;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 仓单比对明细信息: RZ_WARRANTY_COMPARE_DETAIL
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="RZ_WARRANTY_COMPARE_DETAIL")
public class WarrantyCompareDetail  extends BSBaseDomain{
	// : ID 		
				@Id
				@Column(name="ID")
	private String id; 
	
	//RZ_WARRANTY_COMPARE.id : MAIN_ID 		
					@Column(name="MAIN_ID")
	private String mainId; 
	
	//公示平台仓单号 : WARRANTY_NO 		
					@Column(name="WARRANTY_NO")
	private String warrantyNo; 
	
	//货主代码（交易平台收款方） : CUST_CODE 		
					@Column(name="CUST_CODE")
	private String custCode; 
	
	//货主名称（交易平台收款方） : CUST_NAME 		
					@Column(name="CUST_NAME")
	private String custName; 
	
	//数量 : NUM 		
					@Column(name="NUM")
	private Integer num; 
	
	//重量(交易平台) : WEIGHT 		
					@Column(name="WEIGHT")
	private java.math.BigDecimal weight; 
	
	//数量单位 : UNIT 		
					@Column(name="UNIT")
	private String unit; 
	
	//数量单位 : WEIGHT_UNIT 		
					@Column(name="WEIGHT_UNIT")
	private String weightUnit; 
	
	//比对结果（0-异常，1-正常） : RESULT_FLAG 		
					@Column(name="RESULT_FLAG")
	private String resultFlag; 
	
	//比对错误类型(参见小代码X010) : ERROR_TYPE 		
					@Column(name="ERROR_TYPE")
	private String errorType; 
	
	//比对错误原因 : ERR_MSG 		
					@Column(name="ERR_MSG")
	private String errMsg; 
	
	//交易平台付款方代码 : BUYER_CODE 		
					@Column(name="BUYER_CODE")
	private String buyerCode; 
	
	//交易平台付款方名称 : BUYER_NAME 		
					@Column(name="BUYER_NAME")
	private String buyerName; 
	
	//对方平台收款方代码 : SE_SALER_CODE 		
					@Column(name="SE_SALER_CODE")
	private String seSalerCode; 
	
	//对方平台收款方名称 : SE_SALER_NAME 		
					@Column(name="SE_SALER_NAME")
	private String seSalerName; 
	
	//对方平台付款方代码 : SE_BUYER_CODE 		
					@Column(name="SE_BUYER_CODE")
	private String seBuyerCode; 
	
	//对方平台付款方名称 : SE_BUYER_NAME 		
					@Column(name="SE_BUYER_NAME")
	private String seBuyerName; 
	
	//对方平台重量 : SE_WEIGHT 		
					@Column(name="SE_WEIGHT")
	private java.math.BigDecimal seWeight; 
	

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
	 * RZ_WARRANTY_COMPARE.id : MAIN_ID
	 * 
	 * @return 
	 */
	public String getMainId () {
		return mainId;
	}
	
	/**
	 * RZ_WARRANTY_COMPARE.id : MAIN_ID
	 * 
	 * @return 
	 */
	public void setMainId (String mainId) {
		this.mainId = mainId;
	}
	/**
	 * 公示平台仓单号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public String getWarrantyNo () {
		return warrantyNo;
	}
	
	/**
	 * 公示平台仓单号 : WARRANTY_NO
	 * 
	 * @return 
	 */
	public void setWarrantyNo (String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}
	/**
	 * 货主代码（交易平台收款方） : CUST_CODE
	 * 
	 * @return 
	 */
	public String getCustCode () {
		return custCode;
	}
	
	/**
	 * 货主代码（交易平台收款方） : CUST_CODE
	 * 
	 * @return 
	 */
	public void setCustCode (String custCode) {
		this.custCode = custCode;
	}
	/**
	 * 货主名称（交易平台收款方） : CUST_NAME
	 * 
	 * @return 
	 */
	public String getCustName () {
		return custName;
	}
	
	/**
	 * 货主名称（交易平台收款方） : CUST_NAME
	 * 
	 * @return 
	 */
	public void setCustName (String custName) {
		this.custName = custName;
	}
	/**
	 * 数量 : NUM
	 * 
	 * @return 
	 */
	public Integer getNum () {
		return num;
	}
	
	/**
	 * 数量 : NUM
	 * 
	 * @return 
	 */
	public void setNum (Integer num) {
		this.num = num;
	}
	/**
	 * 重量(交易平台) : WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getWeight () {
		return weight;
	}
	
	/**
	 * 重量(交易平台) : WEIGHT
	 * 
	 * @return 
	 */
	public void setWeight (java.math.BigDecimal weight) {
		this.weight = weight;
	}
	/**
	 * 数量单位 : UNIT
	 * 
	 * @return 
	 */
	public String getUnit () {
		return unit;
	}
	
	/**
	 * 数量单位 : UNIT
	 * 
	 * @return 
	 */
	public void setUnit (String unit) {
		this.unit = unit;
	}
	/**
	 * 数量单位 : WEIGHT_UNIT
	 * 
	 * @return 
	 */
	public String getWeightUnit () {
		return weightUnit;
	}
	
	/**
	 * 数量单位 : WEIGHT_UNIT
	 * 
	 * @return 
	 */
	public void setWeightUnit (String weightUnit) {
		this.weightUnit = weightUnit;
	}
	/**
	 * 比对结果（0-异常，1-正常） : RESULT_FLAG
	 * 
	 * @return 
	 */
	public String getResultFlag () {
		return resultFlag;
	}
	
	/**
	 * 比对结果（0-异常，1-正常） : RESULT_FLAG
	 * 
	 * @return 
	 */
	public void setResultFlag (String resultFlag) {
		this.resultFlag = resultFlag;
	}
	/**
	 * 比对错误类型(参见小代码X010) : ERROR_TYPE
	 * 
	 * @return 
	 */
	public String getErrorType () {
		return errorType;
	}
	
	/**
	 * 比对错误类型(参见小代码X010) : ERROR_TYPE
	 * 
	 * @return 
	 */
	public void setErrorType (String errorType) {
		this.errorType = errorType;
	}
	/**
	 * 比对错误原因 : ERR_MSG
	 * 
	 * @return 
	 */
	public String getErrMsg () {
		return errMsg;
	}
	
	/**
	 * 比对错误原因 : ERR_MSG
	 * 
	 * @return 
	 */
	public void setErrMsg (String errMsg) {
		this.errMsg = errMsg;
	}
	/**
	 * 交易平台付款方代码 : BUYER_CODE
	 * 
	 * @return 
	 */
	public String getBuyerCode () {
		return buyerCode;
	}
	
	/**
	 * 交易平台付款方代码 : BUYER_CODE
	 * 
	 * @return 
	 */
	public void setBuyerCode (String buyerCode) {
		this.buyerCode = buyerCode;
	}
	/**
	 * 交易平台付款方名称 : BUYER_NAME
	 * 
	 * @return 
	 */
	public String getBuyerName () {
		return buyerName;
	}
	
	/**
	 * 交易平台付款方名称 : BUYER_NAME
	 * 
	 * @return 
	 */
	public void setBuyerName (String buyerName) {
		this.buyerName = buyerName;
	}
	/**
	 * 对方平台收款方代码 : SE_SALER_CODE
	 * 
	 * @return 
	 */
	public String getSeSalerCode () {
		return seSalerCode;
	}
	
	/**
	 * 对方平台收款方代码 : SE_SALER_CODE
	 * 
	 * @return 
	 */
	public void setSeSalerCode (String seSalerCode) {
		this.seSalerCode = seSalerCode;
	}
	/**
	 * 对方平台收款方名称 : SE_SALER_NAME
	 * 
	 * @return 
	 */
	public String getSeSalerName () {
		return seSalerName;
	}
	
	/**
	 * 对方平台收款方名称 : SE_SALER_NAME
	 * 
	 * @return 
	 */
	public void setSeSalerName (String seSalerName) {
		this.seSalerName = seSalerName;
	}
	/**
	 * 对方平台付款方代码 : SE_BUYER_CODE
	 * 
	 * @return 
	 */
	public String getSeBuyerCode () {
		return seBuyerCode;
	}
	
	/**
	 * 对方平台付款方代码 : SE_BUYER_CODE
	 * 
	 * @return 
	 */
	public void setSeBuyerCode (String seBuyerCode) {
		this.seBuyerCode = seBuyerCode;
	}
	/**
	 * 对方平台付款方名称 : SE_BUYER_NAME
	 * 
	 * @return 
	 */
	public String getSeBuyerName () {
		return seBuyerName;
	}
	
	/**
	 * 对方平台付款方名称 : SE_BUYER_NAME
	 * 
	 * @return 
	 */
	public void setSeBuyerName (String seBuyerName) {
		this.seBuyerName = seBuyerName;
	}
	/**
	 * 对方平台重量 : SE_WEIGHT
	 * 
	 * @return 
	 */
	public java.math.BigDecimal getSeWeight () {
		return seWeight;
	}
	
	/**
	 * 对方平台重量 : SE_WEIGHT
	 * 
	 * @return 
	 */
	public void setSeWeight (java.math.BigDecimal seWeight) {
		this.seWeight = seWeight;
	}

}
