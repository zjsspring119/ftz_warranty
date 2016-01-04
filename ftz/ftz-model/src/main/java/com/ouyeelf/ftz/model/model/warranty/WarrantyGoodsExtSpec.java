package com.ouyeelf.ftz.model.model.warranty;

public class WarrantyGoodsExtSpec {

	private String goodId;//货物唯一标识
	private String specName;//规格属性名称
	private String specCode;//规格属性代码
	private String specDesc;//规格属性描述
	private String iwgId; //INTER_WARRANTY_GOODS表主键id : IWG_ID 		
	public String getGoodId() {
		return goodId;
	}
	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	public String getSpecName() {
		return specName;
	}
	public void setSpecName(String specName) {
		this.specName = specName;
	}
	public String getSpecCode() {
		return specCode;
	}
	public void setSpecCode(String specCode) {
		this.specCode = specCode;
	}
	public String getSpecDesc() {
		return specDesc;
	}
	public void setSpecDesc(String specDesc) {
		this.specDesc = specDesc;
	}
	public String getIwgId() {
		return iwgId;
	}
	public void setIwgId(String iwgId) {
		this.iwgId = iwgId;
	}
	
}
