package com.ouyeelf.ftz.persist.dao.goodsCata;

import java.util.List;

import com.ouyeelf.ftz.model.domain.goodsCata.GoodsCataMapping;

public interface GoodsCataMappingDao {
	public List<GoodsCataMapping> findByBasePCode(String basePCode);
	public void save(GoodsCataMapping cataMapping);
	public GoodsCataMapping findByFtzCatagoryCode(String ftzCatagoryCode);

}
