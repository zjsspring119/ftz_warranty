package com.ouyeelf.ftz.persist.repository.warranty;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyGoodsExtSpec;

public interface InterWarrantyExtSpecRespository extends Repository<InterWarrantyGoodsExtSpec, String>,JpaSpecificationExecutor<InterWarrantyGoodsExtSpec>{

	public void save (InterWarrantyGoodsExtSpec goodsExtSpec);
}
