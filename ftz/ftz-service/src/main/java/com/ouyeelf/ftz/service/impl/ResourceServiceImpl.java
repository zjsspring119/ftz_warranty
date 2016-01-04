package com.ouyeelf.ftz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;
import com.ouyeelf.ftz.persist.dao.ResourceDao;
import com.ouyeelf.ftz.service.ResourceService;

public class ResourceServiceImpl implements ResourceService{
	
	@Autowired
	private ResourceDao resourceDao;
	/**
	 * 资源查询
	 */
	public Page<WarrantyBean> queryResource(WarrantyQueryBean warrantyQueryBean,
			Pageable pageable) {
		Page<WarrantyBean> resources = resourceDao.queryResources(warrantyQueryBean, pageable);
		return resources;
	}
	
//	/**
//	 * 资源明细
//	 */
//	public Resource resDetail(ResDetailQueryBean resDetailQueryBean) {
//		Resource resource = resourceDao.queryResDetail(resDetailQueryBean);
//		return resource;
//	}
//
//	/**
//	 * 资源推荐
//	 */
//	public Page<Resource> queryResRecom(ResRecomQueryBean resRecomQueryBean,Pageable pageable) {
//		return	resourceDao.queryResRecom(resRecomQueryBean,pageable);
//	}
//
//	/**
//	 * 查询所有种类
//	 */
//	public List<DlGroup> queryGroupDl() {
//		List<DlGroup> groupDlList = resourceDao.queryGroupDl();
//		return groupDlList;
//	}
//	
//	/**
//	 * 不分页资源查询
//	 */
//	public Map<String, Object> queryAllRes(ResourceQueryBean resourceQueryBean){
//		return resourceDao.queryAllRes(resourceQueryBean);
//	}
//	
//	/**
//	 * 查询资源数量
//	 */
//	public Integer queryResCount(ResourceQueryBean resourceQueryBean) {
//		return resourceDao.queryResCount(resourceQueryBean);
//	}
//
//	/**
//	 * 统计min和sum
//	 */
//	public Map<String, Double> statResource(ResourceQueryBean resourceQueryBean) {
//		return	resourceDao.statResource(resourceQueryBean);
//	}
}
