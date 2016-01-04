package com.ouyeelf.ftz.model.domain.Announcement;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.ouyeelf.ftz.model.domain.BSBaseDomain;

/**
 * 公告管理: ORC_T_ANNOUNCEMENT
 * 
 * 
 * @author Gen
 */
@Entity
@Table(name="ORC_T_ANNOUNCEMENT")
public class Announcement  extends BSBaseDomain{
	//公告ID : ANNOUNCEMENT_ID 		
				@Id
				@Column(name="ANNOUNCEMENT_ID")
	private String announcementId; 
	
	//公告类型 : ANNOUNCE_TYPE 		
					@Column(name="ANNOUNCE_TYPE")
	private String announceType; 
	
	//公告主题 : TITLE 		
					@Column(name="TITLE")
	private String title; 
	
	//公告内容 : CONTENT 		
					@Column(name="CONTENT")
	private String content; 
	
	//公告附件地址代码 : ANNOUNCE_FILE_CODE 		
					@Column(name="ANNOUNCE_FILE_CODE")
	private String announceFileCode; 
	
	//显示顺序 : DISPLAY_ORDER 		
					@Column(name="DISPLAY_ORDER")
	private String displayOrder; 
	
	//有效标识 : ALIVE_FLAG 		
					@Column(name="ALIVE_FLAG")
	private String aliveFlag; 
	
	//创建人 : CREATE_USER_LABEL 		
					@Column(name="CREATE_USER_LABEL")
	private String createUserLabel; 
	
	//修改人 : UPDATE_USER_LABEL 		
					@Column(name="UPDATE_USER_LABEL")
	private String updateUserLabel; 
	
	//删除人 : DELETE_USER_LABEL 		
					@Column(name="DELETE_USER_LABEL")
	private String deleteUserLabel; 
	
	//创建时间 : CREATE_DATE 		
					@Column(name="CREATE_DATE")
	private java.util.Date createDate; 
	
	//修改时间 : UPDATE_DATE 		
					@Column(name="UPDATE_DATE")
	private java.util.Date updateDate; 
	
	//删除时间 : DELETE_DATE 		
					@Column(name="DELETE_DATE")
	private java.util.Date deleteDate; 
	
	//版本号 : RECORD_VERSION 		
					@Column(name="RECORD_VERSION")
	private Integer recordVersion; 

	//信息来源 : SOURCES 		
					@Column(name="SOURCES")
	private String sources; 		
					
					//市场区分标识（参见X001小代码）
					@Column(name="MARKET_FLAG")
	private String marketFlag; 		
					

	/**
	 * 公告ID : ANNOUNCEMENT_ID
	 * 
	 * @return 
	 */
	public String getAnnouncementId () {
		return announcementId;
	}
	
	/**
	 * 公告ID : ANNOUNCEMENT_ID
	 * 
	 * @return 
	 */
	public void setAnnouncementId (String announcementId) {
		this.announcementId = announcementId;
	}
	/**
	 * 公告类型 : ANNOUNCE_TYPE
	 * 
	 * @return 
	 */
	public String getAnnounceType () {
		return announceType;
	}
	
	/**
	 * 公告类型 : ANNOUNCE_TYPE
	 * 
	 * @return 
	 */
	public void setAnnounceType (String announceType) {
		this.announceType = announceType;
	}
	/**
	 * 公告主题 : TITLE
	 * 
	 * @return 
	 */
	public String getTitle () {
		return title;
	}
	
	/**
	 * 公告主题 : TITLE
	 * 
	 * @return 
	 */
	public void setTitle (String title) {
		this.title = title;
	}
	/**
	 * 公告内容 : CONTENT
	 * 
	 * @return 
	 */
	public String getContent () {
		return content;
	}
	
	/**
	 * 公告内容 : CONTENT
	 * 
	 * @return 
	 */
	public void setContent (String content) {
		this.content = content;
	}
	/**
	 * 公告附件地址代码 : ANNOUNCE_FILE_CODE
	 * 
	 * @return 
	 */
	public String getAnnounceFileCode () {
		return announceFileCode;
	}
	
	/**
	 * 公告附件地址代码 : ANNOUNCE_FILE_CODE
	 * 
	 * @return 
	 */
	public void setAnnounceFileCode (String announceFileCode) {
		this.announceFileCode = announceFileCode;
	}
	/**
	 * 显示顺序 : DISPLAY_ORDER
	 * 
	 * @return 
	 */
	public String getDisplayOrder () {
		return displayOrder;
	}
	
	/**
	 * 显示顺序 : DISPLAY_ORDER
	 * 
	 * @return 
	 */
	public void setDisplayOrder (String displayOrder) {
		this.displayOrder = displayOrder;
	}
	/**
	 * 有效标识 : ALIVE_FLAG
	 * 
	 * @return 
	 */
	public String getAliveFlag () {
		return aliveFlag;
	}
	
	/**
	 * 有效标识 : ALIVE_FLAG
	 * 
	 * @return 
	 */
	public void setAliveFlag (String aliveFlag) {
		this.aliveFlag = aliveFlag;
	}
	/**
	 * 创建人 : CREATE_USER_LABEL
	 * 
	 * @return 
	 */
	public String getCreateUserLabel () {
		return createUserLabel;
	}
	
	/**
	 * 创建人 : CREATE_USER_LABEL
	 * 
	 * @return 
	 */
	public void setCreateUserLabel (String createUserLabel) {
		this.createUserLabel = createUserLabel;
	}
	/**
	 * 修改人 : UPDATE_USER_LABEL
	 * 
	 * @return 
	 */
	public String getUpdateUserLabel () {
		return updateUserLabel;
	}
	
	/**
	 * 修改人 : UPDATE_USER_LABEL
	 * 
	 * @return 
	 */
	public void setUpdateUserLabel (String updateUserLabel) {
		this.updateUserLabel = updateUserLabel;
	}
	/**
	 * 删除人 : DELETE_USER_LABEL
	 * 
	 * @return 
	 */
	public String getDeleteUserLabel () {
		return deleteUserLabel;
	}
	
	/**
	 * 删除人 : DELETE_USER_LABEL
	 * 
	 * @return 
	 */
	public void setDeleteUserLabel (String deleteUserLabel) {
		this.deleteUserLabel = deleteUserLabel;
	}
	/**
	 * 创建时间 : CREATE_DATE
	 * 
	 * @return 
	 */
	public java.util.Date getCreateDate () {
		return createDate;
	}
	
	/**
	 * 创建时间 : CREATE_DATE
	 * 
	 * @return 
	 */
	public void setCreateDate (java.util.Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * 修改时间 : UPDATE_DATE
	 * 
	 * @return 
	 */
	public java.util.Date getUpdateDate () {
		return updateDate;
	}
	
	/**
	 * 修改时间 : UPDATE_DATE
	 * 
	 * @return 
	 */
	public void setUpdateDate (java.util.Date updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * 删除时间 : DELETE_DATE
	 * 
	 * @return 
	 */
	public java.util.Date getDeleteDate () {
		return deleteDate;
	}
	
	/**
	 * 删除时间 : DELETE_DATE
	 * 
	 * @return 
	 */
	public void setDeleteDate (java.util.Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	/**
	 * 版本号 : RECORD_VERSION
	 * 
	 * @return 
	 */
	public Integer getRecordVersion () {
		return recordVersion;
	}
	
	/**
	 * 版本号 : RECORD_VERSION
	 * 
	 * @return 
	 */
	public void setRecordVersion (Integer recordVersion) {
		this.recordVersion = recordVersion;
	}
	/**
	 * 信息来源 : SOURCES
	 * 
	 * @return 
	 */
	public String getSources () {
		return sources;
	}
	
	/**
	 * 信息来源 : SOURCES
	 * 
	 * @return 
	 */
	public void setSources (String sources) {
		this.sources = sources;
	}

	public String getMarketFlag() {
		return marketFlag;
	}

	public void setMarketFlag(String marketFlag) {
		this.marketFlag = marketFlag;
	}
	
	
}
