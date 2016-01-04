package com.ouyeelf.ftz.common.constant;

public interface UrlMappings {
	
	/***************仓单管理**************************/
	public static final String FTZ_WARRANTY_MANAGE_QUERY = "/warrantyManage/pt-cangdanguanli";//仓单管理页面头信息
	public static final String FTZ_VIOLATE_WARRANTY_MANAGE_QUERY = "/warrantyManage/pt-weijin-cangdanguanli";//违禁仓单管理页面头信息
	public static final String FTZ_WARRANTY_MANAGE_LIST = "/warrantyManage/pt-cangdanguanli-list";//仓单管理列表页面
	public static final String FTZ_VIOLATE_WARRANTY_MANAGE_LIST = "/warrantyManage/pt-weijin-cangdanguanli-list";//违禁仓单管理列表页面
	public static final String FTZ_WARRANTY_RESUME = "/warrantyManage/pt-cangdanguanli-lvli";//仓单履历
	public static final String FTZ_WARRANTY_COLLECTION = "/warrantyManage/warrantyCollection";//仓单收藏
	public static final String FTZ_WARRANTY_DETAIL = "/warrantyManage/warrantyDetail";//仓单详情
	public static final String FTZ_WARRANTY_COMMON_DETAIL = "/warrantyManage/warrantyCommonDetail";//仓单公共详情
	public static final String FTZ_VIOLATE_WARRANTY_ALERT = "/warrantyManage/pt-weijincangdan-bj";//违禁仓单信息修改页面
	public static final String FTZ_VIOLATE_WARRANTY_ALERT_SUBMIT = "/warrantyManage/warrantyAlertSubmit";//违禁仓单信息修改提交
	public static final String FTZ_SET_VIOLATE_WARRANTY = "/warrantyManage/setViolateWarranty";//设置违禁仓单
	public static final String FTZ_VIOLATE_WARRANTY_UPLOAD_FILE="/warrantyManage/uploadFile";//上传附件信息
	public static final String FTZ_VIOLATE_WAREHOUSE_DOWNLOAD="/warrantyManage/download";//诚信档案预览时下载附件
	public static final String FTZ_WAREHOUSE_COMPLAINT="/warrantyManage/yiyitousu";//仓单投诉
	public static final String FTZ_SELECT_FAVORITES="/warrantyManage/selectFavorites";//查询是否关注标志
	public static final String FTZ_SELECT_QC="/warrantyManage/selectQc";//查询质检分析
	public static final String FTZ_VIOLATE_LOAD_FILE="/warrantyManage/loadFileInfo";//违禁仓单修改-加载附件信息
	/*************查询历史**********/
	public static final String FTZ_QUERY_HISTORY_SKIP="/warrantyManage/queryHistory";//历史查询跳转
	public static final String FTZ_QUERY_HISTORY="/warrantyManage/queryHis";//历史查询
	public static final String FTZ_QUERY_FAVORITE="/warrantyManage/queryFavorite";//查询是否收藏
	
	
	
	//查询仓单接口
	public static final String QUERY_WARRANTY="/queryWarranty";
	public static final String WARRANTY_LIST="/warrantyList";
	public static final String NSTORERECORD_LIST="/nStoreRecordList";
	public static final String FTZ_WARRANTY_LOG_LIST="/ftzWarrantyLogList";
	public static final String WARRANTYSEARCHHIS_LIST="/warrantySearchHisList";
	
	
	
	
	
	
}

