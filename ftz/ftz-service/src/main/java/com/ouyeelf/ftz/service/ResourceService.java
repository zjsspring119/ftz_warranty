package com.ouyeelf.ftz.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;


public interface ResourceService {
	
	/**
	 * 璧勬簮鏌ヨ
	 * @param resourceQueryBean
	 * @param pageable
	 * @return
	 */
	public Page<WarrantyBean> queryResource(WarrantyQueryBean warrantyQueryBean,Pageable pageable);
	
//	/**
//	 * 璧勬簮鏄庣粏
//	 * @param resDetailQueryBean
//	 * @return
//	 */
//	public Resource resDetail(ResDetailQueryBean resDetailQueryBean);
//	
//	/**
//	 * 璧勬簮鎺ㄨ崘
//	 * @param resRecomQueryBean
//	 * @return
//	 */
//	public Page<Resource> queryResRecom(ResRecomQueryBean resRecomQueryBean,Pageable pageable);
//	
//	/**
//	 * 鏌ヨ鎵�湁绉嶇被
//	 */
//	public List<DlGroup> queryGroupDl();
//	
//	/**
//	 * 涓嶅垎椤佃祫婧愭煡璇�
//	 */
//	public Map<String, Object> queryAllRes(ResourceQueryBean resourceQueryBean);
//	
//	/**
//	 * 鏌ヨ璧勬簮鏁伴噺
//	 */
//	public Integer queryResCount(ResourceQueryBean resourceQueryBean);
//	
//	/**
//	 * 缁熻min鍜宻um
//	 */
//	public Map<String, Double> statResource(ResourceQueryBean resourceQueryBean);
}
