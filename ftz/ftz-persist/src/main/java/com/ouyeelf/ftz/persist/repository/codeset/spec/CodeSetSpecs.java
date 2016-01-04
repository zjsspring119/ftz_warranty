package com.ouyeelf.ftz.persist.repository.codeset.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.ouyeelf.ftz.model.domain.codeset.Codeset;



/**
 * 小代码维护查询条件
 * @author     xia.zhilong
 * @version    2012-7-15 上午11:07:56 
 * @revision
 */
public class CodeSetSpecs {

	public static Specification<Codeset> equalCodesetCodeAndlikeCodesetName(
			final Codeset codeset) {

		return new Specification<Codeset>() {
			public Predicate toPredicate(Root<Codeset> root,
					CriteriaQuery<?> query, CriteriaBuilder builder) {

				String likePattern = getLikePattern(codeset.getCodesetName());

				Predicate predicate = builder.and();
				// codesetName  like查询
				if (codeset.getCodesetName()!= null && !"".equals(codeset.getCodesetName())) {
					predicate = builder.and(builder.like(builder.lower(root .< String > get("codesetName")), likePattern));
				}
				
				// codesetCode  equal查询
				if (codeset.getCodesetCode() != null && !"".equals(codeset.getCodesetCode())) {
					predicate = builder.and(predicate,  builder.equal(root .get("codesetCode"), codeset.getCodesetCode()));
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
