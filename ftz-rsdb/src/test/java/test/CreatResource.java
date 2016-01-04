package test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ouyeelf.ftz.model.mdbean.NStoreRecordBean;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.model.mdbean.WarrantyGoodBean;
import com.ouyeelf.ftz.model.mdbean.WarrantySearchHisBean;

/**
 * 创建测试数据
 * @author Administrator
 *
 */
public class CreatResource {
	
	public static List<WarrantyBean> getResource(int size) throws Exception {
		List<WarrantyBean> resList = new ArrayList<WarrantyBean>();
		for(int i = 1; i <= size; i++){
			resList.add(makeResource(i));
		}
		return resList;
	}
	
	
	
	public static WarrantyBean makeResource(int index) throws Exception{
		WarrantyBean warranty = new WarrantyBean();
		warranty.setCustomerName("支付系统测试会员100"+index);
		warranty.setCustomerCode("U76963");
		warranty.setWarrantyNo("W140513004556"+index);
		
		WarrantyGoodBean warrantyGood=new WarrantyGoodBean();
		warrantyGood.setGoodId("2015-02-02 13:01:45");
		warrantyGood.setBankPrice(new BigDecimal(100.89));
		//warranty.setWarrantyGoodBean(warrantyGood);
		return warranty;
	}
	
	public static List<NStoreRecordBean> getResourceByNStoreRecordBean(int size) throws Exception {
		List<NStoreRecordBean> resList = new ArrayList<NStoreRecordBean>();
		for(int i = 1; i <= size; i++){
			resList.add(makeResourceByNStoreRecordBean(i));
		}
		return resList;
	}
	
	public static NStoreRecordBean makeResourceByNStoreRecordBean(int index) throws Exception{
		NStoreRecordBean nStoreRecordBean = new NStoreRecordBean();
		nStoreRecordBean.setGenerateDate(new Date());
		nStoreRecordBean.setRemark("我就是我");
		nStoreRecordBean.setStatus("状态");
		nStoreRecordBean.setStockPeopleCode("存货人代码");
		nStoreRecordBean.setStockPeopleName("存货人名称");
		nStoreRecordBean.setStoreCode("仓库代码");
		nStoreRecordBean.setStoreName("仓库名称");
		nStoreRecordBean.setStoreNo("仓单号");
		nStoreRecordBean.setZqPeopleCode("质权人代码");
		nStoreRecordBean.setZqPeopleName("质权人名称");
		return nStoreRecordBean;
	}
	
	public static List<WarrantySearchHisBean> getResourceByWarrantySearchHisBean(int size) throws Exception {
		List<WarrantySearchHisBean> resList = new ArrayList<WarrantySearchHisBean>();
		for(int i = 1; i <= size; i++){
			resList.add(makeResourceByWarrantySearchHisBean(i));
		}
		return resList;
	}



	private static WarrantySearchHisBean makeResourceByWarrantySearchHisBean(
			int i) {
		// TODO Auto-generated method stub
		WarrantySearchHisBean warrantySearchHisBean = new WarrantySearchHisBean();
		warrantySearchHisBean.setArea("来源地区");
		warrantySearchHisBean.setIpAddr("");
		warrantySearchHisBean.setKeyWord("");
		warrantySearchHisBean.setOrgSysNo("");
		warrantySearchHisBean.setOrgSysName("");
		warrantySearchHisBean.setPrdCataCode("");
		warrantySearchHisBean.setPrdCataName("");
		warrantySearchHisBean.setPrdCataCode("");
		warrantySearchHisBean.setPrdCataName("");
		warrantySearchHisBean.setSearcher("");
		warrantySearchHisBean.setSearchTime(new Date());
		warrantySearchHisBean.setWarrantyNo("仓单号");
		warrantySearchHisBean.setWarrantyStatus("仓单状态");
		warrantySearchHisBean.setWeight(new BigDecimal(10));
		warrantySearchHisBean.setWeightUnit("重量单位");
		return warrantySearchHisBean;
	}
	

	
}
