package com.ouyeelf.ftz.model.resource.query;



/**
 * 仓单履历表
 * 
 * 
 * @author Gen
 */
public class NStoreRecordQueryBean extends BeseQueryVo {
	// 仓单号 : STORE_NO
	private String storeNo;

	// 存货人代码 : STOCK_PEOPLE_CODE
	private String stockPeopleCode;

	// 质权人代码 : ZQ_PEOPLE_CODE
	private String zqPeopleCode;

	// 仓库代码 : STORE_CODE
	private String storeCode;

	// 生成日期 : GENERATE_DATE
	private String generateDate;

	// 存货人名称 : STOCK_PEOPLE_NAME
	private String stockPeopleName;

	// 质权人名称 : ZQ_PEOPLE_NAME
	private String zqPeopleName;

	// 仓库名称 : STORE_NAME
	private String storeName;

	// : ID
	private String id;

	// 状态（05:已生成 51:已质押 60:已解押） : STATUS
	private String status;

	// 描述 : REMARK
	private String remark;

	/**
	 * 仓单号 : STORE_NO
	 * 
	 * @return
	 */
	public String getStoreNo() {
		return storeNo;
	}

	/**
	 * 仓单号 : STORE_NO
	 * 
	 * @return
	 */
	public void setStoreNo(String storeNo) {
		this.storeNo = storeNo;
	}

	/**
	 * 存货人代码 : STOCK_PEOPLE_CODE
	 * 
	 * @return
	 */
	public String getStockPeopleCode() {
		return stockPeopleCode;
	}

	/**
	 * 存货人代码 : STOCK_PEOPLE_CODE
	 * 
	 * @return
	 */
	public void setStockPeopleCode(String stockPeopleCode) {
		this.stockPeopleCode = stockPeopleCode;
	}

	/**
	 * 质权人代码 : ZQ_PEOPLE_CODE
	 * 
	 * @return
	 */
	public String getZqPeopleCode() {
		return zqPeopleCode;
	}

	/**
	 * 质权人代码 : ZQ_PEOPLE_CODE
	 * 
	 * @return
	 */
	public void setZqPeopleCode(String zqPeopleCode) {
		this.zqPeopleCode = zqPeopleCode;
	}

	/**
	 * 仓库代码 : STORE_CODE
	 * 
	 * @return
	 */
	public String getStoreCode() {
		return storeCode;
	}

	/**
	 * 仓库代码 : STORE_CODE
	 * 
	 * @return
	 */
	public void setStoreCode(String storeCode) {
		this.storeCode = storeCode;
	}

	/**
	 * 生成日期 : GENERATE_DATE
	 * 
	 * @return
	 */
	public String getGenerateDate() {
		return generateDate;
	}

	/**
	 * 生成日期 : GENERATE_DATE
	 * 
	 * @return
	 */
	public void setGenerateDate(String generateDate) {
		this.generateDate = generateDate;
	}

	/**
	 * 存货人名称 : STOCK_PEOPLE_NAME
	 * 
	 * @return
	 */
	public String getStockPeopleName() {
		return stockPeopleName;
	}

	/**
	 * 存货人名称 : STOCK_PEOPLE_NAME
	 * 
	 * @return
	 */
	public void setStockPeopleName(String stockPeopleName) {
		this.stockPeopleName = stockPeopleName;
	}

	/**
	 * 质权人名称 : ZQ_PEOPLE_NAME
	 * 
	 * @return
	 */
	public String getZqPeopleName() {
		return zqPeopleName;
	}

	/**
	 * 质权人名称 : ZQ_PEOPLE_NAME
	 * 
	 * @return
	 */
	public void setZqPeopleName(String zqPeopleName) {
		this.zqPeopleName = zqPeopleName;
	}

	/**
	 * 仓库名称 : STORE_NAME
	 * 
	 * @return
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * 仓库名称 : STORE_NAME
	 * 
	 * @return
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	/**
	 * : ID
	 * 
	 * @return
	 */
	public String getId() {
		return id;
	}

	/**
	 * : ID
	 * 
	 * @return
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 状态（05:已生成 51:已质押 60:已解押） : STATUS
	 * 
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 状态（05:已生成 51:已质押 60:已解押） : STATUS
	 * 
	 * @return
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 描述 : REMARK
	 * 
	 * @return
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 描述 : REMARK
	 * 
	 * @return
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
