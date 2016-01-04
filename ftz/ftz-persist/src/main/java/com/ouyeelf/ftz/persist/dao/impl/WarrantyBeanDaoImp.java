package com.ouyeelf.ftz.persist.dao.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.ouyeelf.ftz.common.utils.StringUtil;
import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;
import com.ouyeelf.ftz.persist.dao.BaseDao;
import com.ouyeelf.ftz.persist.dao.WarrantyBeanDao;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.persist.repository.CommonResourceRepository;

public class WarrantyBeanDaoImp extends BaseDao implements WarrantyBeanDao {
	
	
	@Autowired
	private CommonResourceRepository<WarrantyBean> commonResourceRepository;
	
    /**
     * 1.拼接查询条件
     * 2.拼接分页参数
     */
	public Page<WarrantyBean> findAll(WarrantyQueryBean warrantyQueryBean,
			Pageable pageable) {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		Query query =makeWarrantyQuery(warrantyQueryBean);

		long count = commonResourceRepository.countResources(query,WarrantyBean.class);
		query=this.addPageableQuery(query, pageable);
		List<WarrantyBean> wrrantyList=commonResourceRepository.findResources(query, WarrantyBean.class);
		long endTime = System.currentTimeMillis();
		Page<WarrantyBean> warrantyPage = new NpageImpl<WarrantyBean>(
				wrrantyList, pageable, count, endTime - startTime);
		
		return warrantyPage;
	}

	
	
	/**
	 * 拼接动态查询条件
	 * @param warrantyQueryBean
	 * @return
	 */
	private static Query makeWarrantyQuery(WarrantyQueryBean warrantyQueryBean) {
		Query query = new Query();
		if (warrantyQueryBean == null) {
			return query;
		}
		List<Criteria> clist=new ArrayList<Criteria>();
		//单个仓单号或多个用逗号分开的仓单号查询
		if(!StringUtil.isEmpty(warrantyQueryBean.getWarrantyNo())){
			List<String> warrnatyList=Arrays.asList(warrantyQueryBean.getWarrantyNo().split(","));
			if(warrnatyList.size()>1){//多个in
				clist.add(Criteria.where("warrantyNo").in(warrnatyList));
			}else{//一个like
				
				if("1".equals(warrantyQueryBean.getPublicFlag())){
					clist.add(Criteria.where("warrantyNo").is(warrantyQueryBean.getWarrantyNo()));
				}else{
					Pattern pattern = Pattern.compile("^" + warrantyQueryBean.getWarrantyNo() + "");
					clist.add(Criteria.where("warrantyNo").regex(pattern));
				}
				//clist.add(Criteria.where("warrantyNo").is(warrantyQueryBean.getWarrantyNo()));
			}
			
		}
		//品种查询，多个品种以逗号分开
		if(!StringUtil.isEmpty(warrantyQueryBean.getPmClassList())){
			List<String> pmClassList=Arrays.asList(warrantyQueryBean.getPmClassList().split(","));
			if(pmClassList.size()>1){//多个in
				clist.add(Criteria.where("warrantyGoodBean.pmClass").in(pmClassList));
			}else{//一个like
				Pattern pattern = Pattern.compile(".*" + warrantyQueryBean.getPmClassList() + ".*$", Pattern.CASE_INSENSITIVE);
				//Pattern pattern = Pattern.compile("^" + warrantyQueryBean.getPmClassList() + "");
				clist.add(Criteria.where("warrantyGoodBean.pmClass").regex(pattern));
			}
			
		}
		//状态查询
		if(!StringUtil.isEmpty(warrantyQueryBean.getWarrantyStatus())){
			clist.add(Criteria.where("warrantyStatus").is(warrantyQueryBean.getWarrantyStatus()));
		}
		
		Criteria orgSysNoCriterias=new Criteria();//交易代码
		Criteria customerNameCriterias=new Criteria();//客户名称
		//交易代码
		if(!StringUtil.isEmpty(warrantyQueryBean.getOrgSysNo())){
			List<String> orgBillNoList=Arrays.asList(warrantyQueryBean.getOrgSysNo().split(","));
			orgSysNoCriterias=Criteria.where("orgSysNo").in(orgBillNoList);
		
		}
		//客户名称
		if(!StringUtil.isEmpty(warrantyQueryBean.getCustomerName())){
			customerNameCriterias=Criteria.where("customerName").is(warrantyQueryBean.getCustomerName());
		}
		if(!StringUtil.isEmpty(warrantyQueryBean.getOrgSysNo()) && !StringUtil.isEmpty(warrantyQueryBean.getCustomerName())){
			clist.add(new Criteria().orOperator(orgSysNoCriterias,customerNameCriterias));
		}else if(!StringUtil.isEmpty(warrantyQueryBean.getOrgSysNo())&&StringUtil.isEmpty(warrantyQueryBean.getCustomerName())){
			clist.add(orgSysNoCriterias);
			
		}else if(StringUtil.isEmpty(warrantyQueryBean.getOrgSysNo()) && !StringUtil.isEmpty(warrantyQueryBean.getCustomerName())){
			clist.add(customerNameCriterias);
		}
		//交易名称
		if(!StringUtil.isEmpty(warrantyQueryBean.getOrgSysName())){
			Pattern pattern = Pattern.compile(".*" + warrantyQueryBean.getOrgSysName() + ".*$", Pattern.CASE_INSENSITIVE);
			//clist.add(Criteria.where("orgSysName").regex(pattern));
			clist.add(Criteria.where("orgSysName").is(warrantyQueryBean.getOrgSysName()));
		}
		//仓库名称
		if(!StringUtil.isEmpty(warrantyQueryBean.getWarehouseName())){
			clist.add(Criteria.where("warehouseName").is(warrantyQueryBean.getWarehouseName()));
		}
		//市场标记
		if(!StringUtil.isEmpty(warrantyQueryBean.getMarketFlag())){
			clist.add(Criteria.where("marketFlag").is(warrantyQueryBean.getMarketFlag()));
		}
		//是否违禁
		if(!StringUtil.isEmpty(warrantyQueryBean.getIllicitFlag())){
			if("1".equals(warrantyQueryBean.getIllicitFlag())){
			  clist.add(Criteria.where("illicitFlag").is(warrantyQueryBean.getIllicitFlag()));
			}else {
			//clist.add(Criteria.where("illicitFlag").ne("1"));	
				clist.add(Criteria.where("illicitFlag").is("0"));	
			}
		}
		//登记时间（创建时间）
		if(!StringUtil.isEmpty(warrantyQueryBean.getCreateTime())){
			String[] time=warrantyQueryBean.getCreateTime().replaceAll("/", "-").split("~");
			clist.add(Criteria.where("createTime").gte(time[0]+" 00:00:00").lte(time[1]+" 23:59:59"));
		}

		//关注标记
		if(!StringUtil.isEmpty(warrantyQueryBean.getFavoritesFlag())){
			if("1".equals(warrantyQueryBean.getFavoritesFlag())){//查询关注
				clist.add(Criteria.where("favorites").is(warrantyQueryBean.getFavoritesCode()));
			}else if("0".equals(warrantyQueryBean.getFavoritesFlag())){// 查询不关注
				clist.add(Criteria.where("favorites").nin(warrantyQueryBean.getFavoritesCode()));
			}
		}
		Criteria[] criterias= new Criteria[clist.size()];
		Criteria	orgBillNoCriteria=new Criteria();//外部系统单据号（or原来的条件查询）
		if(!StringUtil.isEmpty(warrantyQueryBean.getOrgBillNo())){
			List<String> orgBillNoList=Arrays.asList(warrantyQueryBean.getOrgBillNo().split(","));
			if(orgBillNoList.size()>1){//多个in
				orgBillNoCriteria=Criteria.where("orgBillNo").in(orgBillNoList);
			}else{//一个like
				//Pattern pattern = Pattern.compile(".*" + warrantyQueryBean.getOrgBillNo() + ".*$", Pattern.CASE_INSENSITIVE);
				orgBillNoCriteria=Criteria.where("orgBillNo").is(warrantyQueryBean.getOrgBillNo());
			}
			query.addCriteria(new Criteria().orOperator(orgBillNoCriteria,new Criteria().andOperator(clist.toArray(criterias))));
		}else{

			query.addCriteria(new Criteria().andOperator(clist.toArray(criterias)));
		}
		//默认按登记时间逆序
	 
		
		
          query.with(new Sort(Direction.DESC,"createTime"));
		//query.with(new Sort(Direction.DESC,"warrantyNo"));
     
		return query;
	}

}
