package com.ouyeelf.ftz.persist.repository.codeset.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ouyeelf.ftz.model.domain.codeset.CodeItem;



/**
 * 小代码维护查询条件
 * @author     xia.zhilong
 * @version    2012-7-15 上午11:07:56 
 * @revision
 */
public class CodeItemSpecs {

	public static Specification<CodeItem> equalCodeItemAndlikeItemChsCode(
			final CodeItem codeItem) {

		return new Specification<CodeItem>() {
			
			public Predicate toPredicate(Root<CodeItem> root,
					CriteriaQuery<?> query, CriteriaBuilder builder) {

				

				Predicate predicate = builder.and();
				
				// itemChsCode     like查询
				if (codeItem.getItemChsCode() != null && !"".equals(codeItem.getItemChsCode())) {
					String likePattern = getLikePattern(codeItem.getItemChsCode().trim());
					predicate = builder.and(builder.like(builder.lower(root .< String > get("itemChsCode")), likePattern));
				}
				
				// itemCode     equal查询
				if (codeItem.getItemCode() != null && !"".equals(codeItem.getItemCode())) {
					predicate = builder.and(predicate,  builder.equal(root .get("itemCode"), codeItem.getItemCode()));
				}
				
				// codesetCode     equal  必须条件
				if (codeItem.getCodesetCode() != null && !"".equals(codeItem.getCodesetCode())) {
					predicate = builder.and(predicate,  builder.equal(root .get("codesetCode"), codeItem.getCodesetCode()));
				}
				return predicate;
			}

			private String getLikePattern(final String searchTerm) {
				StringBuilder pattern = new StringBuilder();
				if(searchTerm!=null){
					pattern.append("%");
					pattern.append(searchTerm.toLowerCase());
				}
				pattern.append("%");
				return pattern.toString();
			}
		};
	}
}
