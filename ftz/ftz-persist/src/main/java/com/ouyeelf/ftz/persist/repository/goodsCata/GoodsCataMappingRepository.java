package com.ouyeelf.ftz.persist.repository.goodsCata;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.goodsCata.GoodsCataMapping;

public interface GoodsCataMappingRepository extends Repository<GoodsCataMapping, String>, JpaSpecificationExecutor<GoodsCataMapping>{
	
	public List<GoodsCataMapping> findByBasePCode(String basePCode);
	
	public void save(GoodsCataMapping cataMapping);
	
	public GoodsCataMapping findByFtzCatagoryCode(String ftzCatagoryCode);
}
