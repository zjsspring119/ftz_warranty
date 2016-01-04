package com.ouyeelf.ftz.model.domain.warranty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ouyeelf.ftz.model.domain.BSBaseDomain;

@Entity
@Table(name = "v_warranty_good")
public class WarrantyGoodView extends BSBaseDomain {

	@Id
	@Column(name = "ID")
	private String id;

	// 仓单号
	@Column(name = "WARRANTY_NO")
	private String warrantyNo;

	/*
	 * //仓单状态
	 * 
	 * @Column(name="WARRANTY_STATUS") private String warrantyStatus;
	 */

	// 品名
	@Column(name = "TYPE_NAME")
	private String typeName;

	// 钢种、材质
	@Column(name = "GRADE")
	private String grade;

	// 存储卡号
	@Column(name = "SAVE_NO")
	private String saveNo;

	// 规格
	@Column(name = "SPEC")
	private String spec;

	// 产地 : AREA_P
	@Column(name = "AREA_P")
	private String areaP;

	// 型号
	@Column(name = "GRADE_NUM_XH")
	private String gradeNumXh;
	
	//捆包号
	@Column(name = "PACK_NUM")
	private String packNum;

	// 备注
	@Column(name = "MEMO")
	private String memo;

	// 过磅净重
	@Column(name = "WEIGHT_B")
	private String weightB;

	// 抄码净重
	@Column(name = "WEIGHT_C")
	private String weightC;

	// 数量
	@Column(name = "SHEET_NUM")
	private Integer sheetNum;

	// 块数
	@Column(name = "SINGLE_SHEET_NUM")
	private Integer singleSheetNum;

	  //赎货标识
    @Column(name="REDEEM_FLAG")
    private String redeemFlag;	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getWarrantyNo() {
		return warrantyNo;
	}

	public void setWarrantyNo(String warrantyNo) {
		this.warrantyNo = warrantyNo;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getGrade() {
		return grade;
	}

	public String getAreaP() {
		return areaP;
	}

	public void setAreaP(String areaP) {
		this.areaP = areaP;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getSaveNo() {
		return saveNo;
	}

	public void setSaveNo(String saveNo) {
		this.saveNo = saveNo;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getGradeNumXh() {
		return gradeNumXh;
	}

	public void setGradeNumXh(String gradeNumXh) {
		this.gradeNumXh = gradeNumXh;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getWeightB() {
		return weightB;
	}

	public void setWeightB(String weightB) {
		this.weightB = weightB;
	}

	public String getWeightC() {
		return weightC;
	}

	public void setWeightC(String weightC) {
		this.weightC = weightC;
	}

	public Integer getSheetNum() {
		return sheetNum;
	}

	public void setSheetNum(Integer sheetNum) {
		this.sheetNum = sheetNum;
	}

	public Integer getSingleSheetNum() {
		return singleSheetNum;
	}

	public void setSingleSheetNum(Integer singleSheetNum) {
		this.singleSheetNum = singleSheetNum;
	}

	public String getRedeemFlag() {
		return redeemFlag;
	}

	public void setRedeemFlag(String redeemFlag) {
		this.redeemFlag = redeemFlag;
	}

	
}
