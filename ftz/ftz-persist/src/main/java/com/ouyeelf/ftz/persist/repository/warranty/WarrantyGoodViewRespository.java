package com.ouyeelf.ftz.persist.repository.warranty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.WarrantyGoodView;


	

	/**
	 * 仓单明细查询
	 * 视图中间层查询
	 * @author zhouwei
	 *
	 */
	public interface WarrantyGoodViewRespository extends Repository<WarrantyGoodView, String>,JpaSpecificationExecutor<WarrantyGoodView>{

		//public WarrantyGoodView findOne(String id); 
		//public WarrantyGoodView save(WarrantyGood warrantyGood);
	    //public List<WarrantyGoodView> findByWarrantyNo(String warrantyNo);
		//public void delete(WarrantyGoodView warrantyGood2); 
		@Query("from WarrantyGoodView w where w.warrantyNo=?1")
		public List<WarrantyGoodView> queryByWarrantyNo(String warrantyNo); 
		
		//若干品名
		@Query("select distinct t.typeName from WarrantyGoodView t where t.warrantyNo = ?1")
		public List<String> findTypeNameByWarrantyNo(String warrantyNo);
		//若干规格
		@Query("select distinct t.spec from WarrantyGoodView t where t.warrantyNo = ?1")
		public List<String> findSpecByWarrantyNo(String warrantyNo);
		//若干产地
		@Query("select distinct t.areaP from WarrantyGoodView t where t.warrantyNo = ?1")
		public List<String> findAreaPByWarrantyNo(String warrantyNo);
		//若干产地
		@Query("select distinct t.grade from WarrantyGoodView t where t.warrantyNo = ?1")
		public List<String> findGradeByWarrantyNo(String warrantyNo);
		//若干捆包号
		@Query("select distinct t.packNum from WarrantyGoodView t where t.warrantyNo = ?1")
		public List<String> findPackNumByWarrantyNo(String warrantyNo);
		//总数量
		@Query("select  sum(t.sheetNum) from WarrantyGoodView t where t.warrantyNo = ?1")
		public Long sumSheetNumByWarrantyNo(String warrantyno);
		//总块数
		@Query("select  sum(t.singleSheetNum) from WarrantyGoodView t where t.warrantyNo = ?1")
		public Long sumSingleSheetNumByWarrantyNo(String warrantyno);
		
		//赎货标识
		@Query("select distinct t.redeemFlag from WarrantyGoodView t where t.warrantyNo = ?1")
		public List<String> findRedeemFlagByWarrantyNo(String warrantyNo);

		
	
	}

	


