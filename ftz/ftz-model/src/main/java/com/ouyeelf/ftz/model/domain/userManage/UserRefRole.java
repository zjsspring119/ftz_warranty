package com.ouyeelf.ftz.model.domain.userManage;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rel_users_role")
public class UserRefRole {

	@Id
	@Column(name="rel_id")
	private String relId;
	
	@Column(name="user_id")
	private String userId;
	
	@Column(name="role_id")
	private String roleId;
	
	@Column(name="BANK_FLAG")
	private String bankFlag;
	
	public UserRefRole(){}

	public UserRefRole(String relId, String userId, String roleId,String bankFlag) {
		super();
		this.relId = relId;
		this.userId = userId;
		this.roleId = roleId;
		this.bankFlag = bankFlag;
	}

	public String getRelId() {
		return relId;
	}

	public void setRelId(String relId) {
		this.relId = relId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getBankFlag() {
		return bankFlag;
	}

	public void setBankFlag(String bankFlag) {
		this.bankFlag = bankFlag;
	}
	
	
}
