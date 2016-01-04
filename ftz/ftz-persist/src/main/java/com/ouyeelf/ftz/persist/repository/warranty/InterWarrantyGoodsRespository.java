package com.ouyeelf.ftz.persist.repository.warranty;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.Repository;

import com.ouyeelf.ftz.model.domain.warranty.InterWarrantyGoods;

public interface InterWarrantyGoodsRespository extends Repository<InterWarrantyGoods, String>,JpaSpecificationExecutor<InterWarrantyGoods>{

	public void save(InterWarrantyGoods goods);
}
