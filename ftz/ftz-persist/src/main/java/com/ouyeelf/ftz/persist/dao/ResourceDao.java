package com.ouyeelf.ftz.persist.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;


public interface ResourceDao {

	/**
	 * 资源查询
	 * 分页，动态查询
	 * @param resourceQueryBean
	 * @param pageable
	 * @return
	 */
	public Page<WarrantyBean> queryResources(WarrantyQueryBean warrantyQueryBean,
			Pageable pageable);
	
//	/**
//	 * 资源明细查询
//	 * @param resSetailQueryBean
//	 * @return
//	 */
//	public Resource queryResDetail(ResDetailQueryBean resSetailQueryBean);
//	
//	/**
//	 * 资源推荐
//	 * @param resRecomQueryBean
//	 * @param pageable
//	 * @return
//	 */
//	public Page<Resource> queryResRecom(ResRecomQueryBean resRecomQueryBean,Pageable pageable);
//	
//	/**
//	 * 查询所有种类
//	 * @return
//	 */
//	public List<DlGroup> queryGroupDl();
//	
//	/**
//	 * 不分页资源查询
//	 */
//	public Map<String, Object> queryAllRes(ResourceQueryBean resourceQueryBean);
//	
//	/**
//	 * 查询资源数量
//	 * @param resourceQueryBean
//	 * @return
//	 */
//	public Integer queryResCount(ResourceQueryBean resourceQueryBean);
//	
//	/**
//	 * 统计min和sum
//	 * @param resourceQueryBean
//	 */
//	public Map<String, Double> statResource(ResourceQueryBean resourceQueryBean);
	
}
