package com.ouyeelf.ftz.model.vo;



public class BSBaseVo {
	private String sysRoleType; //角色类型
	
	private String sysCompanyNo;//当前登录人所属组织代码 

	public String getSysRoleType() {
		return sysRoleType;
	}

	public void setSysRoleType(String sysRoleType) {
		this.sysRoleType = sysRoleType;
	}

	public String getSysCompanyNo() {
		return sysCompanyNo;
	}

	public void setSysCompanyNo(String sysCompanyNo) {
		this.sysCompanyNo = sysCompanyNo;
	}

  
}
