package com.ouyeelf.ftz.persist.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Query;

import com.ouyeelf.ftz.model.resource.WarrantyBean;
import com.ouyeelf.ftz.model.resource.query.WarrantyQueryBean;
import com.ouyeelf.ftz.persist.dao.ResourceDao;
import com.ouyeelf.ftz.persist.domain.NpageImpl;
import com.ouyeelf.ftz.persist.repository.ResourceRepository;


public class ResourceDaoImpl implements ResourceDao {

	@Autowired
	private ResourceRepository resourceRepository;
	private final static Logger log=LoggerFactory.getLogger(ResourceDaoImpl.class);
//	@Autowired
//	private GroupDlRepository groupDlRepository;
//	public static final String EMPTY_STRING = "";
//	private static final String DEFAULT_HIT_INDEX_NAME_FULL = "cz_1_qt_1_dj3_1_color_1_ggxs2_1_ggxs1_1_coatStructure_1_coatWeight_1_paintTypeTC_1_apnChinese_1_basicType_1_isImport_1_dl_1_sl2_1_asscustomerId_1";
//	private static final String DEFAULT_HIT_INDEX_NAME = "rkrq_1_zyh_1_dl_1_sl2_1_asscusto";
//	private static final String DEFAULT_RKRQ_HIT_INDEX_NAME = "rkrq_1_";
//	private static final String DEFAULT_ZYH_HIT_INDEX_NAME = "zyh_1_";
//	private static final String COMMA=",";
	/**
	 * 资源查询
	 */
	public Page<WarrantyBean> queryResources(WarrantyQueryBean warrantyQueryBean,
			Pageable pageable) {

		// 根据动态查询条件动态拼总记录数查询query
		Query query = new Query();//makeQuery(warrantyQueryBean);
		long count = resourceRepository.countResources(query);
		query = addPageableQuery(query, pageable, count,
				warrantyQueryBean.getSortName(),
				warrantyQueryBean.getSortValue());
		long startTime = System.currentTimeMillis();
		List<WarrantyBean> list = resourceRepository.findResources(query);
		long endTime = System.currentTimeMillis();
		// 处理顺序
		if (pageable != null) {
			int offset = pageable.getOffset(); // 偏移量
			if (offset > count / 2) {
				list = changeList(list);
			}
		}
		System.out.println(query.toString());
		Page<WarrantyBean> geoPage = new NpageImpl<WarrantyBean>(
				changeToListParent(list), pageable, count, endTime - startTime);
		return geoPage;
	}

//	/**
//	 * 资源查询
//	 */
//	public Map<String, Object> queryAllRes(ResourceQueryBean resourceQueryBean) {
//
//		// 根据动态查询条件动态拼总记录数查询query
//		Query query = makeQuery(resourceQueryBean);
//		// 处理分页及排序
//		query = addAllResQuery(query, resourceQueryBean);
//
//		System.out.println(query.toString());
//		long startTime = System.currentTimeMillis();
//		List<Resource> list=null;
//		try{
//			list = resourceRepository.findResources(query);
//		}catch(Exception e){
//			query.withHint(DEFAULT_HIT_INDEX_NAME);
//			list = resourceRepository.findResources(query);
//			log.error(e.getMessage(),e);
//		}
//		
//		long stopTime = System.currentTimeMillis();
//
//		Integer count = resourceQueryBean.getCount();
//		// 处理顺序
//		if (resourceQueryBean != null && null != count && count > 0) {
//			int offset = resourceQueryBean.getOffset(); // 偏移量
//			if (offset > count / 2) {
//				list = changeList(list);
//			}
//		}
//		// 创建返回对象
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("result", list);
//		map.put("times", stopTime - startTime);
//		return map;
//	}
//
	public static List<WarrantyBean> changeList(List<WarrantyBean> list) {
		List<WarrantyBean> resList = new ArrayList<WarrantyBean>();
		for (int i = list.size() - 1; i >= 0; i--) {
			resList.add(list.get(i));
		}
		return resList;
	}

//	/**
//	 * 查询资源数量
//	 */
//	public Integer queryResCount(ResourceQueryBean resourceQueryBean) {
//
//		// 根据动态查询条件动态拼总记录数查询query
//		Query query = makeQuery(resourceQueryBean);
//		
//		long count = resourceRepository.countResources(query);
//		return new Long(count).intValue();
//	}
//
//	private static Query makeQuery(ResourceQueryBean resourceQueryBean) {
//		Query query = new Query();
//		if (resourceQueryBean == null) {
//			return query;
//		}
//		String sortName = resourceQueryBean.getSortName();
//		
//		Pattern pattern = null;
//		String indexName = DEFAULT_HIT_INDEX_NAME;
//		Resource resource = resourceQueryBean.getResource();
//		if (StringUtils.isNotBlank(resource.getIsImport())) { // 货物状态
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "isImport_1",
//					sortName);
//			query.addCriteria(Criteria.where("isImport").is(
//					resource.getIsImport()));
//		}
//		if (StringUtils.isNotBlank(resource.getBasicType())) { // 彩涂基板类型
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,
//					"basicType_1", sortName);
//			query.addCriteria(Criteria.where("basicType").is(
//					resource.getBasicType()));
//		}
//		if (null != resourceQueryBean.getApnChinese()
//				&& resourceQueryBean.getApnChinese().length != 0) { // 用途分类
//			query.addCriteria(Criteria.where("apnChinese").in(
//					resourceQueryBean.getApnChinese()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,
//					"apnChinese_1", sortName);
//		}
//		if (null != resourceQueryBean.getPaintTypeTC()
//				&& resourceQueryBean.getPaintTypeTC().length != 0) { // 涂料类型
//			query.addCriteria(Criteria.where("paintTypeTC").in(
//					resourceQueryBean.getPaintTypeTC()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,
//					"paintTypeTC_1", sortName);
//		}
//		if (null != resourceQueryBean.getCoatWeight()
//				&& resourceQueryBean.getCoatWeight().length != 0) { // 锌层
//			query.addCriteria(Criteria.where("coatWeight").in(
//					resourceQueryBean.getCoatWeight()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,
//					"coatWeight_1", sortName);
//		}
//		if (null != resourceQueryBean.getCoatStructure()
//				&& resourceQueryBean.getCoatStructure().length != 0) { // 涂层结构
//			query.addCriteria(Criteria.where("coatStructure").in(
//					resourceQueryBean.getCoatStructure()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,
//					"coatStructure_1", sortName);
//		}
//		if (resourceQueryBean.getGgxs1Max() != null
//				&& resourceQueryBean.getGgxs1Min() != null) { // 厚度
//			query.addCriteria(Criteria.where("ggxs1")
//					.lte(resourceQueryBean.getGgxs1Max())
//					.gte(resourceQueryBean.getGgxs1Min()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "ggxs1_1",
//					sortName);
//		} else if (resourceQueryBean.getGgxs1Max() != null) {
//			query.addCriteria(Criteria.where("ggxs1").lte(
//					resourceQueryBean.getGgxs1Max()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "ggxs1_1",
//					sortName);
//		} else if (resourceQueryBean.getGgxs1Min() != null) {
//			query.addCriteria(Criteria.where("ggxs1").gte(
//					resourceQueryBean.getGgxs1Min()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "ggxs1_1",
//					sortName);
//		}
//		if (resourceQueryBean.getGgxs2Max() != null
//				&& resourceQueryBean.getGgxs2Min() != null) { // 宽度
//			query.addCriteria(Criteria.where("ggxs2")
//					.lte(resourceQueryBean.getGgxs2Max())
//					.gte(resourceQueryBean.getGgxs2Min()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "ggxs2_1",
//					sortName);
//		} else if (resourceQueryBean.getGgxs2Max() != null) {
//			query.addCriteria(Criteria.where("ggxs2").lte(
//					resourceQueryBean.getGgxs2Max()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "ggxs2_1",
//					sortName);
//		} else if (resourceQueryBean.getGgxs2Min() != null) {
//			query.addCriteria(Criteria.where("ggxs2").gte(
//					resourceQueryBean.getGgxs2Min()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "ggxs2_1",
//					sortName);
//		}
//		if (StringUtils.isNotBlank(resource.getColor())) { // 颜色
//			query.addCriteria(Criteria.where("color").is(resource.getColor()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "color_1",
//					sortName);
//		}
//		if (resourceQueryBean.getDj3Max() != null
//				&& resourceQueryBean.getDj3Min() != null) { // 单价
//			query.addCriteria(Criteria.where("dj3")
//					.lte(resourceQueryBean.getDj3Max())
//					.gte(resourceQueryBean.getDj3Min()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "dj3_1",
//					sortName);
//		} else if (resourceQueryBean.getDj3Max() != null) {
//			query.addCriteria(Criteria.where("dj3").lte(
//					resourceQueryBean.getDj3Max()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "dj3_1",
//					sortName);
//		} else if (resourceQueryBean.getDj3Min() != null) {
//			query.addCriteria(Criteria.where("dj3").gte(
//					resourceQueryBean.getDj3Min()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "dj3_1",
//					sortName);
//		}
//
//		if (StringUtils.isNotBlank(resource.getQt())) { // 其它
//			String qt = qtConvert(resource.getQt());
//			pattern = Pattern.compile(qt, Pattern.CASE_INSENSITIVE);
//			query.addCriteria(new Criteria("qt").regex(pattern));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "qt_1",
//					sortName);
//		}
//
//		if (null != resourceQueryBean.getCz()
//				&& resourceQueryBean.getCz().length != 0) { // 牌号多选
//			query.addCriteria(Criteria.where("cz")
//					.in(resourceQueryBean.getCz()));
//			indexName = subIndexName(DEFAULT_HIT_INDEX_NAME_FULL, "cz_1",
//					sortName);
//		}
//
//		if (resourceQueryBean.getPz() != null
//				&& resourceQueryBean.getPz().length != 0) { // 品种
//			query.addCriteria(Criteria.where("dl")
//					.in(resourceQueryBean.getPz()));
//		}
//
//		if (resourceQueryBean.getSl2Min() != null
//				&& resourceQueryBean.getSl2Max() != null) { // 单重
//			query.addCriteria(Criteria.where("sl2")
//					.lte(resourceQueryBean.getSl2Max())
//					.gte(resourceQueryBean.getSl2Min()));
//		} else if (resourceQueryBean.getSl2Min() != null) {
//			query.addCriteria(Criteria.where("sl2").gte(
//					resourceQueryBean.getSl2Min()));
//		} else if (resourceQueryBean.getSl2Max() != null) {
//			query.addCriteria(Criteria.where("sl2")
//					.lte(resourceQueryBean.getSl2Max()).gt(0));
//		} else {
//			query.addCriteria(Criteria.where("sl2").gt(0));
//		}
//
//		if (StringUtils.isNotBlank(resource.getAsscustomerId())) { // 已登录
//			// 定向
//			query.addCriteria(Criteria.where("asscustomerId").in(
//					resource.getAsscustomerId(), "none_target"));
//		} else { // 未登录
//			query.addCriteria(Criteria.where("asscustomerId").is("none_target"));
//		}
//		if(indexName.equals(DEFAULT_HIT_INDEX_NAME)){
//			String orderIndexName=getOrderCondition(resourceQueryBean.getSortName());
//			if(!orderIndexName.equals("rkrq")){
//				indexName=subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,"dl",orderIndexName);
//			}
//		}
//		query.withHint(indexName);
//		return query;
//	}
//
	/**
	 * 拼接翻頁條件
	 * 
	 * @param query
	 * @param pageable
	 * @param count
	 */
	private static Query addPageableQuery(Query query, Pageable pageable,
			long count, String sortName, String sortValue) {
		if (pageable != null) {
			int size = pageable.getPageSize(); // 显示数量
			int offset = pageable.getOffset(); // 偏移量
			int mod = (int) (count % size);

			// 处理多个排序
			List<String> orderList = new ArrayList<String>();
			if (StringUtils.isNotBlank(sortName)) {
				String[] names = sortName.split(",");
				for (String s : names) {
					orderList.add(s);
				}
			}
			if (offset > count / 2) {
				int limit;
				if (mod == 0) {// 能整除
					limit = size;
				} else if (count - offset < size) {// 不能整除，但是是最后一页
					limit = mod;
				} else {// 不能整除，且不是最后一页
					limit = size;
				}
				query.limit(limit);
				query.skip((int) (count - offset - limit));
//				if (sortValue.equalsIgnoreCase("desc")) {
//					query.with(new Sort(Direction.ASC, orderList));
//				} else {
//					query.with(new Sort(Direction.DESC, orderList));
//				}
			} else {
				query.skip(pageable.getOffset());
				query.limit(pageable.getPageSize());
				if (sortValue.equalsIgnoreCase("desc")) {
					query.with(new Sort(Direction.DESC, orderList));
				} else {
					query.with(new Sort(Direction.ASC, orderList));
				}
			}
		}
		return query;
	}

	private List<WarrantyBean> changeToListParent(List<WarrantyBean> list) {
		List<WarrantyBean> result = new ArrayList<WarrantyBean>();
		if (list != null) {
			for (WarrantyBean mb : list) {
				result.add(mb);
			}
		}
		return result;
	}

//	/**
//	 * 处理货主
//	 * 
//	 * @return
//	 */
//	private static String hzConvert(String hz[]) {
//		StringBuffer hzBuffer = new StringBuffer();
//		for (int i = 0; i < hz.length; i++) {
//			hzBuffer.append("|");
//			hzBuffer.append(hz[i]);
//		}
//		String str = hzBuffer.deleteCharAt(0).toString();
//		return str;
//	}
//
//	/**
//	 * 处理其它字段
//	 * 
//	 * @return
//	 */
//	private static String qtConvert(String qt) {
//		int index = -1;
//		index = qt.indexOf("*");
//		int index2 = -1;
//		index2 = qt.indexOf("+");
//		String result = "";
//		if (index > -1) {
//			String[] str = qt.split("\\*");
//			for (String s : str) {
//				result += s;
//				result += "\\";
//				result += "*";
//			}
//			result = result.substring(0, result.lastIndexOf("\\"));
//		}
//		if (index2 > -1) {
//			String[] str = qt.split("\\+");
//			for (String s : str) {
//				result += s;
//				result += "\\";
//				result += "+";
//			}
//			result = result.substring(0, result.lastIndexOf("\\"));
//		}
//		if (result == "") {
//			result = qt;
//		}
//		return result;
//	}
//
//	/**
//	 * 资源明细查询
//	 */
//	public Resource queryResDetail(ResDetailQueryBean resDetailQueryBean) {
//		Resource resource = resourceRepository.findResDetail(resDetailQueryBean
//				.getId());
//		return resource;
//	}
//
//	/**
//	 * 资源推荐
//	 */
//	public Page<Resource> queryResRecom(ResRecomQueryBean resRecomQueryBean,
//			Pageable pageable) {
//		Query query = makeRrsRecomQuery(resRecomQueryBean);
//		long count = resourceRepository.countResources(query);
//		query = addPageableQuery(query, pageable, count,
//				resRecomQueryBean.getSortName(),
//				resRecomQueryBean.getSortValue());
//		List<Resource> list = resourceRepository.findResources(query);
//		// 处理顺序
//		if (pageable != null) {
//			int offset = pageable.getOffset(); // 偏移量
//			if (offset > count / 2) {
//				list = changeList(list);
//			}
//		}
//		Page<Resource> geoPage = new NpageImpl<Resource>(
//				changeToListParent(list), pageable, count);
//		return geoPage;
//	}
//
//	/**
//	 * 处理资源推荐查询条件
//	 * 
//	 * @param resRecomQueryBean
//	 * @return
//	 */
//	private static Query makeRrsRecomQuery(ResRecomQueryBean resRecomQueryBean) {
//		Query query = new Query();
//		if (resRecomQueryBean == null) {
//			return query;
//		}
//		if (StringUtils.isNotBlank(resRecomQueryBean.getZyh())) {
//			query.addCriteria(Criteria.where("zyh").is(
//					resRecomQueryBean.getZyh()));
//		}
//		query.addCriteria(Criteria.where("asscustomerId").is("none_target")); // 不定向
//		query.addCriteria(Criteria.where("sl2").gt(0)); // 已挂量大于0
//		query.addCriteria(Criteria.where("flag1").is("0")); // 推荐在库的
//		return query;
//	}
//
//	/**
//	 * 查询所有种类
//	 */
//	public List<DlGroup> queryGroupDl() {
//		return groupDlRepository.findAll();
//	}
//
//	/**
//	 * 拼接翻頁條件(不带count页)
//	 * 
//	 * @param query
//	 * @param pageable
//	 * @param count
//	 */
//
//	private static Query addAllResQuery(Query query,
//			ResourceQueryBean resourceQueryBean) {
//		if (resourceQueryBean != null) {
//			int size = resourceQueryBean.getLimit(); // 显示数量
//			int offset = resourceQueryBean.getOffset(); // 偏移量
//			Integer count = resourceQueryBean.getCount();
//			String sortName = resourceQueryBean.getSortName();
//			String sortValue = resourceQueryBean.getSortValue();
//
//			// 处理多个排序
//			List<String> orderList = new ArrayList<String>();
//			if (StringUtils.isNotBlank(sortName)) {
//				String[] names = sortName.split(",");
//				for (String s : names) {
//					orderList.add(s);
//				}
//			}
//
//			if (null != count && count > 0) {
//				int mod = (int) (count % size);
//				if (offset > count / 2) {
//					int limit;
//					if (mod == 0) {// 能整除
//						limit = size;
//					} else if (count - offset < size) {// 不能整除，但是是最后一页
//						limit = mod;
//					} else {// 不能整除，且不是最后一页
//						limit = size;
//					}
//					query.limit(limit);
//					query.skip((int) (count - offset - limit));
//					if (sortValue.equalsIgnoreCase("desc")) {
//						query.with(new Sort(Direction.ASC, orderList));
//					} else {
//						query.with(new Sort(Direction.DESC, orderList));
//					}
//				} else {
//					query.skip(offset);
//					query.limit(size);
//					if (sortValue.equalsIgnoreCase("desc")) {
//						query.with(new Sort(Direction.DESC, orderList));
//					} else {
//						query.with(new Sort(Direction.ASC, orderList));
//					}
//				}
//			} else {
//				query.skip(offset);
//				query.limit(size);
//				if (sortValue.equalsIgnoreCase("desc")) {
//					query.with(new Sort(Direction.DESC, orderList));
//				} else {
//					query.with(new Sort(Direction.ASC, orderList));
//				}
//			}
//		}
//
//		return query;
//	}
//
//	public static String subIndexName(String str, String separator,
//			String orderField) {
//		orderField=getOrderCondition(orderField);
//		if ((str == null) || (str.length() == 0)) {
//			return str;
//		}
//
//		if (separator == null) {
//			return EMPTY_STRING;
//		}
//
//		int pos = str.indexOf(separator);
//
//		if (pos == -1) {
//			return EMPTY_STRING;
//		}
//
//		orderField = orderField + "_1_";
//		StringBuilder sb = new StringBuilder(separator);
//		sb.append(str.substring(pos + separator.length()));
//
//		int offSet = sb.indexOf(orderField);
//		if (offSet >= 0) {
//			sb.delete(offSet, offSet + orderField.length());
//		}
//
//		if (DEFAULT_RKRQ_HIT_INDEX_NAME.equals(orderField)) {
//			sb.insert(0, DEFAULT_RKRQ_HIT_INDEX_NAME
//					+ DEFAULT_ZYH_HIT_INDEX_NAME);
//		} else {
//			sb.insert(0, DEFAULT_RKRQ_HIT_INDEX_NAME).insert(0, orderField);
//		}
//
//		if (sb.length() < 34) {
//			return sb.toString();
//		} else {
//			return sb.substring(0, 32).toString();
//		}
//	}
//	/***
//	 * 
//	 * @param orderStrArray there must be only two sort fields,and must contain a rkrq field
//	 * <pre>
//	 * If rkrq and zyh,then return rkrq;
//	 * If rkrq and xxx,them return xxx;
//	 * </pre>
//	 * @return orderName
//	 * @author bianys
//	 */
//	@SuppressWarnings("unchecked")
//	public static String getOrderCondition(String orderStrArray){
//		String rkrqkey="rkrq",zyhKey="zyh";
//		String orderName=rkrqkey;
//		List<String> orders=split(orderStrArray,COMMA);
//		if(!(orders.contains(rkrqkey)&&orders.contains(zyhKey))){
//			orders.remove(rkrqkey);
//			orderName=orders.get(0);
//		}
//		return orderName;
//	}
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	public static List split(String str, String delim) {
//		List splitList = null;
//		StringTokenizer st = null;
//
//		if (str == null)
//			return splitList;
//
//		if (delim != null)
//			st = new StringTokenizer(str, delim);
//		else
//			st = new StringTokenizer(str);
//
//		if (st != null && st.hasMoreTokens()) {
//			splitList = new ArrayList();
//
//			while (st.hasMoreTokens())
//				splitList.add(st.nextToken());
//		}
//		return splitList;
//	}
//	public static void main(String[] args) {
//		String indexName=DEFAULT_HIT_INDEX_NAME;
//		if(indexName.equals(DEFAULT_HIT_INDEX_NAME)){
//			String orderIndexName=getOrderCondition("dj3");
//			if(!orderIndexName.equals("rkrq")){
//				subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,"dl","dj3");
//			}
//		}
//		System.out.println(subIndexName(DEFAULT_HIT_INDEX_NAME_FULL,"dl","dj3"));
//	}
//
//	/**
//	 * 统计min和sum
//	 */
//	public Map<String, Double> statResource(ResourceQueryBean resourceQueryBean) {
//
//		if(resourceQueryBean == null){
//			resourceQueryBean = new ResourceQueryBean();
//		}
//		
//		Resource resource = resourceQueryBean.getResource();
//		//查询条件
//		DBObject matchs = new BasicDBObject("asscustomerId", "none_target");
//		matchs.put("sl2", new BasicDBObject("$gt",0));
//		
//		if (StringUtils.isNotBlank(resource.getIsImport())) { // 货物状态
//			matchs.put("isImport", resource.getIsImport());
//		}
//		if (StringUtils.isNotBlank(resource.getBasicType())) { // 彩涂基板类型
//			matchs.put("basicType", resource.getBasicType());
//		}
//		if (null != resourceQueryBean.getApnChinese()
//				&& resourceQueryBean.getApnChinese().length != 0) { // 用途分类
//			matchs.put("apnChinese", new BasicDBObject("$in",resourceQueryBean.getApnChinese()));
//		}
//		if (null != resourceQueryBean.getPaintTypeTC()
//				&& resourceQueryBean.getPaintTypeTC().length != 0) { // 涂料类型
//			matchs.put("paintTypeTC", new BasicDBObject("$in",resourceQueryBean.getPaintTypeTC()));
//		}
//		if (null != resourceQueryBean.getCoatWeight()
//				&& resourceQueryBean.getCoatWeight().length != 0) { // 锌层
//			matchs.put("coatWeight", new BasicDBObject("$in",resourceQueryBean.getCoatWeight()));
//		}
//		if (null != resourceQueryBean.getCoatStructure()
//				&& resourceQueryBean.getCoatStructure().length != 0) { // 涂层结构
//			matchs.put("coatStructure", new BasicDBObject("$in",resourceQueryBean.getCoatStructure()));
//		}
//		if (resourceQueryBean.getGgxs1Max() != null
//				&& resourceQueryBean.getGgxs1Min() != null) { // 厚度
//			matchs.put("ggxs1", new BasicDBObject("$lte",resourceQueryBean.getGgxs1Max())
//			.append("$gte", resourceQueryBean.getGgxs1Min()));
//		} else if (resourceQueryBean.getGgxs1Max() != null) {
//			matchs.put("ggxs1", new BasicDBObject("$lte",resourceQueryBean.getGgxs1Max()));
//		} else if (resourceQueryBean.getGgxs1Min() != null) {
//			matchs.put("ggxs1", new BasicDBObject("$gte", resourceQueryBean.getGgxs1Min()));
//		}
//		if (resourceQueryBean.getGgxs2Max() != null
//				&& resourceQueryBean.getGgxs2Min() != null) { // 宽度
//			matchs.put("ggxs2", new BasicDBObject("$lte",resourceQueryBean.getGgxs2Max())
//			.append("$gte", resourceQueryBean.getGgxs2Min()));
//		} else if (resourceQueryBean.getGgxs2Max() != null) {
//			matchs.put("ggxs2", new BasicDBObject("$lte",resourceQueryBean.getGgxs2Max()));
//		} else if (resourceQueryBean.getGgxs2Min() != null) {
//			matchs.put("ggxs2", new BasicDBObject("$gte",resourceQueryBean.getGgxs2Min()));
//		}
//		if (StringUtils.isNotBlank(resource.getColor())) { // 颜色
//			matchs.put("color", resource.getColor());
//		}
//		if (resourceQueryBean.getDj3Max() != null
//				&& resourceQueryBean.getDj3Min() != null) { // 单价
//			matchs.put("dj3", new BasicDBObject("$lte",resourceQueryBean.getDj3Max())
//			.append("$gte", resourceQueryBean.getDj3Min()));
//		} else if (resourceQueryBean.getDj3Max() != null) {
//			matchs.put("dj3", new BasicDBObject("$lte",resourceQueryBean.getDj3Max()));
//		} else if (resourceQueryBean.getDj3Min() != null) {
//			matchs.put("dj3", new BasicDBObject("$gte",resourceQueryBean.getDj3Min()));
//		}
//
//		if (StringUtils.isNotBlank(resource.getQt())) { // 其它
//			String qt = qtConvert(resource.getQt());
//			matchs.put("qt", new BasicDBObject("$regex",qt));
//		}
//		if (null != resourceQueryBean.getCz()
//				&& resourceQueryBean.getCz().length != 0) { // 牌号多选
//			matchs.put("cz", new BasicDBObject("$in",resourceQueryBean.getCz()));
//		}
//		if (resourceQueryBean.getPz() != null
//				&& resourceQueryBean.getPz().length != 0) { // 品种
//			matchs.put("dl", new BasicDBObject("$in",resourceQueryBean.getPz()));
//		}
//		if (resourceQueryBean.getSl2Min() != null
//				&& resourceQueryBean.getSl2Max() != null) { // 单重
//			matchs.put("sl2", new BasicDBObject("$lte",resourceQueryBean.getSl2Max())
//			.append("$gte", resourceQueryBean.getSl2Min()));
//		} else if (resourceQueryBean.getSl2Min() != null) {
//			matchs.put("sl2", new BasicDBObject("$gte",resourceQueryBean.getSl2Min()));
//		} else if (resourceQueryBean.getSl2Max() != null) {
//			matchs.put("sl2", new BasicDBObject("$lte",resourceQueryBean.getSl2Max())
//			.append("$gt", 0));
//		} else {
//			matchs.put("sl2", new BasicDBObject("$gt",0));
//		}
//		if (StringUtils.isNotBlank(resource.getAsscustomerId())) { // 已登录
//			// 定向
//			BasicDBList dbList=new BasicDBList();  //翻译数组对象
//			dbList.add(resource.getAsscustomerId());
//			dbList.add("none_target");
//			matchs.put("asscustomerId", new BasicDBObject("$in",dbList));
//		} else { // 未登录
//			matchs.put("asscustomerId", "none_target");
//		}
//	    DBObject match = new BasicDBObject("$match", matchs); 
//
//		//分组字段
//		DBObject groupFields = new BasicDBObject( "_id", "$department");
//		groupFields.put("sumSl2", new BasicDBObject( "$sum", "$sl2"));
//		groupFields.put("minDj3", new BasicDBObject( "$min", "$dj3"));
//		DBObject group = new BasicDBObject("$group", groupFields);
//		
//		Map<String, Double> map= resourceRepository.statResource(match, group);
//		return map;		
//	}
}
