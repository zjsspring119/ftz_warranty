package com.ouyeelf.ftz.service.mongdb;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ouyeelf.ftz.common.constant.Operation;
import com.ouyeelf.ftz.common.utils.DateUtil;
import com.ouyeelf.ftz.model.domain.warranty.FtzWarrantyLog;
import com.ouyeelf.ftz.model.domain.warranty.WarrantyGood;
import com.ouyeelf.ftz.model.domain.warranty.WarrantySearchHis;
import com.ouyeelf.ftz.model.mdbean.FtzWarrantyLogBean;
import com.ouyeelf.ftz.model.mdbean.WarrantyBean;
import com.ouyeelf.ftz.model.mdbean.WarrantyGoodBean;
import com.ouyeelf.ftz.model.mdbean.WarrantySearchHisBean;
import com.ouyeelf.ftz.persist.dao.warranty.WarrantyGoodDao;
import com.ouyeelf.ftz.rsdb.imp.buffer.IByteBufferFactory;
import com.ouyeelf.ftz.rsdb.imp.buffer.INByteBuffer;
import com.ouyeelf.ftz.rsdb.imp.callback.ICallback;
import com.ouyeelf.ftz.rsdb.imp.main.ImpMain;
import com.ouyeelf.ftz.service.callback.CallbackImpl;
import com.ouyeelf.ftz.service.warranty.WarrantyCommonService;

/**
 * **************************************************
 *@Copyrigth(c) by baosight Co., Ltd
 *@Create Date 2015-3-6 
 *@author zjs
 *@File Name：
 *@Last version：1.0
 *@Function:mongodb同步接口 
 *@Change Log: 批量数据同步待改进
 **************************************************
 */
@Service("synDataService")
public class MongoSynDataService {
	private static Log log =LogFactory.getLog(MongoSynDataService.class);
	
	private static int BATCH=100;
	
	@Autowired
	private WarrantyCommonService warrantyCommonService;
	
	@Autowired
	private WarrantyGoodDao warrantyGoodDao;

	/**
	 * 仓单同步
	 * @param warrantyBeanList 可变参数
	 * @param operation 同步类型  INSERT,UPDATE,REMOVE
	 * 批量数据按每100条分组插入
	 */
	@Transactional
	public  void  synWarranty(Operation operation,WarrantyBean ...warrantyBeanList){
		try {
			int length=warrantyBeanList.length;
			CallbackImpl cb = new CallbackImpl();
			if(length>0){
				int size=0;
				if(length%BATCH==0){
					size=length/BATCH;
				}else{
					size=length/BATCH+1;
				}
				for(int i=0;i<size;i++){
					INByteBuffer<WarrantyBean> bb = IByteBufferFactory.createNResourceByteBuffer(5*1024*1024);
					List<String> warrantyNoList=new ArrayList<String>();
					for(int j=i*BATCH;j<BATCH*(i+1)&&j<length;j++){
						WarrantyBean warrantyBean=warrantyBeanList[j];
						if(null==warrantyBean.getWarrantyGoodBean()|| warrantyBean.getWarrantyGoodBean().size()==0){
							 List<WarrantyGoodBean> warrantyGoodBeanList=new ArrayList<WarrantyGoodBean>();
							 List<WarrantyGood> list=warrantyGoodDao.findByWarrantyNo(warrantyBean.getWarrantyNo());
							 if(null!=list&&list.size()>0){
									for (WarrantyGood warrantyGood : list) {
										WarrantyGoodBean warrantyGoodBean=new WarrantyGoodBean();
										BeanUtils.copyProperties(warrantyGood, warrantyGoodBean);
										warrantyGoodBeanList.add(warrantyGoodBean);
									}
								    warrantyBean.setWarrantyGoodBean(warrantyGoodBeanList);
						     }
						}
						bb.put(warrantyBean);
						warrantyNoList.add(warrantyBean.getWarrantyNo());
					}
					warrantyCommonService.updateIsSynchronize("0", warrantyNoList);
					String batch = DateUtil.nowDate("yyyyMMddhhmmss");
					log.info("push buffer start");
					ImpMain.synchro(bb, operation, cb, batch,"warrantyBean");
					log.info("push buffer end");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 同步仓单履历
	 * @param nStoreRecordList
	 * @param operation 同步类型  INSERT,UPDATE,REMOVE
	 */
	public  void synFtzWarrantyLogBean(Operation operation,FtzWarrantyLog ...ftzWarrantyLogList){
		try {
			
			int length=ftzWarrantyLogList.length;
			CallbackImpl cb = new CallbackImpl();
			if(length>0){
				int size=0;
				if(length%BATCH==0){
					size=length/BATCH;
				}else{
					size=length/BATCH+1;
				}
				for(int i=0;i<size;i++){
					INByteBuffer<FtzWarrantyLogBean> bb = IByteBufferFactory.createNResourceByteBuffer(5*1024*1024);
					List<String> idList=new ArrayList<String>();
					for(int j=i*BATCH;j<BATCH*(i+1)&&j<length;j++){
						FtzWarrantyLogBean ftzWarrantyLogBean=new FtzWarrantyLogBean();
						BeanUtils.copyProperties(ftzWarrantyLogList[j], ftzWarrantyLogBean);
						bb.put(ftzWarrantyLogBean);
						idList.add(ftzWarrantyLogList[j].getId());
					}
					warrantyCommonService.updateIsSynchronizeByFtzWarrantyLog("0", idList);
					String batch = DateUtil.nowDate("yyyyMMddhhmmss");
					log.info("push buffer start");
					ImpMain.synchro(bb, operation, cb, batch,"ftzWarrantyLogBean");
					log.info("push buffer end");
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
			
			
	
  /**
  * 同步仓单查询历史
  * @param warrantySearchHisList
  */
  public void synWarrantySearchHisBean(WarrantySearchHis ...warrantySearchHisList){
	  try {
		    INByteBuffer<WarrantySearchHisBean> bb = IByteBufferFactory.createNResourceByteBuffer(5*1024*1024);
		    List<String> idList=new ArrayList<String>();
			if(warrantySearchHisList.length>0){
			    for (WarrantySearchHis warrantySearchHis : warrantySearchHisList) {
					WarrantySearchHisBean warrantySearchHisBean=new WarrantySearchHisBean();
					BeanUtils.copyProperties(warrantySearchHis, warrantySearchHisBean);
					bb.put(warrantySearchHisBean);
					idList.add(warrantySearchHis.getId());
				}
				warrantyCommonService.updateIsSynchronizeByWarrantySearchHis("0", idList);
				ICallback cb = new CallbackImpl();
				String batch = DateUtil.nowDate("yyyyMMddhhmmss");
				log.info("push buffer start");
				ImpMain.synchro(bb, Operation.INSERT, cb, batch,"warrantySearchHisBean");
				log.info("push buffer end");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
  
}
