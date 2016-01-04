package com.ouyeelf.ftz.persist.repository.warranty;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.WarrantyGood;

/**
 * 仓单明细查询
 * @author zhouwei
 *
 */
public interface WarrantyGoodRespository extends Repository<WarrantyGood, String>,JpaSpecificationExecutor<WarrantyGood>{

	public WarrantyGood findOne(String id); 
	public WarrantyGood save(WarrantyGood warrantyGood);
    public List<WarrantyGood> findByWarrantyNo(String warrantyNo);
	public void delete(WarrantyGood warrantyGood2);
	
	//根据品名、存储卡号（仓储物 代码）、材质、规格型号在warrantyGood表中查找
	@Query("from WarrantyGood t where t.warrantyNo=?1 and t.typeName=?2 and t.saveNo=?3 and t.grade=?4 and t.spec=?5 and t.gradeNumXh=?6 and t.memo=?7")
	public List<WarrantyGood> findByCoditions(String warrantyNo,String typeName, String saveNo,
			String grade, String spec, String gradeNumXh,String memo); 
	
	@Query("select count(*) from WarrantyGood wg where exists(select 1 from Warranty w where w.applicationId = ?1 " +
		   "and w.warrantyNo =wg.warrantyNo ) and (wg.redeemFlag ='05'  or wg.redeemFlag is null)")
	public long queryCountPackageNo(String applicationId);
	
	// 若干材质
	@Query("select distinct t.grade from WarrantyGood t where t.warrantyNo = ?1")
	public List<String> findGradeListByWarrantyNo(String warrantyNo);
	
	//若干品名
	@Query("select distinct t.typeName from WarrantyGood t where t.warrantyNo = ?1")
	public List<String> findTypeNameByWarrantyNo(String warrantyNo);
	
	//根据品名、存储卡号（仓储物 代码）、材质、规格型号在warrantyGood表中查找(适用于memo为空的查询)
	@Query("from WarrantyGood t where t.warrantyNo=?1 and t.typeName=?2 and t.saveNo=?3 and t.grade=?4 and t.spec=?5 and t.gradeNumXh=?6 and t.memo is null")
	public List<WarrantyGood> findByCoditionsAndMemoIsNull(String warrantyNo,
			String typeName, String saveNo, String grade, String spec,
			String gradeNumXh);   
	
	//根据品名、存储卡号（仓储物 代码）、材质、规格型号在warrantyGood表中查找(适用于memo为空的查询)
	@Query("from WarrantyGood t where t.warrantyNo in (?1) and t.typeName=?2  and t.grade=?3 and t.spec=?4 and (t.areaP=?5 or t.areaP is null)")
	public List<WarrantyGood> findByNo(List<String> warrantyNo,
			String typeName, String grade, String spec,String areaP); 
	
	@Query("from WarrantyGood m where m.rzWarehouseCode=?1 and (m.area =?2 or m.area is null) and m.location= ?3 and " +
			   "m.warrantyNo=?4 order by m.packNum")
		public List<WarrantyGood> queryByWarehouseCodeAndAreaAndLocation(String rzWarehouseCode,String area, String location,String warrantyNo);
	
	//这时候没有生成库位标签号（labelLocationNo）所以不能用labelLocationNo作为查询条件
		@Query("from WarrantyGood m where m.warrantyNo=?1 and (m.area=?2 or m.area is null) and m.location=?3 order by m.storeDate asc")
		public List<WarrantyGood> queryWarrantyLabels(String mortgageNo,String area,String location);
		// 通过质押物清单号、货物ID来查询
		public WarrantyGood findByWarrantyNoAndGoodId(String warrantyNo, String goodId); 
		
		// 查询质物标签明细(根据库位标签号)
		public List<WarrantyGood> findByLabelLocationNo(String labelLocationNo);	
		
		//根据仓单号、品名、材质、规格、产地在warrantyGood表中查找
		@Query("from WarrantyGood t where t.warrantyNo=?1 and t.typeName=?2 and t.grade=?3 and t.spec=?4 and t.areaP=?5")
		public List<WarrantyGood> findByCodition(String warrantyNo,String typeName,
				String grade, String spec,String areaP); 
		@Query("select sum(g.weightB) from WarrantyGood g where g.goodId=?1 and exists (select 1 from Warranty w " +
				" where w.warrantyNo=g.warrantyNo and w.marketFlag='10' and w.warrantyStatus!='01')")
		public BigDecimal sumWeghtByGoodId(String goodId);
}
