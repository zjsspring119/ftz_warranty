package warrantyManage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestWarrantyManageRestFul {

	
	private final HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
	private CloseableHttpClient httpClient;

	//private final HttpHost httpHost = new HttpHost("uat.shdongchan.com", 80, "http");
	 private final HttpHost httpHost = new HttpHost("127.0.0.1", 8081, "http");
	//private final HttpHost httpHost = new HttpHost("127.0.0.1", 8090, "http");
    //private final HttpHost httpHost = new HttpHost("10.60.2.179", 8081, "http");
	//private final HttpHost httpHost = new HttpHost("10.60.17.35", 8081, "http");
	private final HttpClientContext context = HttpClientContext.create();

	@Before
	public void before() {
		httpClient = httpClientBuilder.build();
	}

	@After
	public void after() throws IOException {
		httpClient.close();
	}
	
	//查询仓单
	@Test
	public void testQueryWarrantyList()throws Exception{
		JSONObject json =new JSONObject();
		//{"marketFlag":"10","page":"0","warrantyNo":"F892349534186"}
		//{"warrantyNo":"W1404090016","orgSysNo":"D10466","customerName":"上海远军物资有限分公司"}
		//json.put("warrantyNo", "W1404090002");
		//json.put("orgBillNo", "W140513004556");
		//json.put("warrantyStatus", "05");
		//json.put("orgSysNo", "D10466");
		//json.put("customerName", "上海远军物资有限分公司");
		json.put("marketFlag", "10");
		//json.put("createTime", "2015/03/16~2015/03/16");
		json.put("illicitFlag", "0");
		//json.put("pmClassList","7,8");
		//json.put("orgSysName","曹");
		//json.put("favoritesFlag","1");
		//json.put("favoritesCode","D0001");

		
		final HttpPost post = new HttpPost("/ftz-restful/warranty/warrantyList");
		post.addHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(json.toString(),"UTF-8"));
		final CloseableHttpResponse response = httpClient.execute(httpHost,	post, context);
		String result = EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
 	    System.out.println("jsons="+result);
 	    response.getEntity().getContent().close();
		httpClient.close();
	}
	//查询仓单履历
	@Test
	public void testQueryNStoreRecordList()throws Exception{
		JSONObject json =new JSONObject();
		json.put("storeNo", "W140414004286");
		json.put("limit", 10);
		json.put("page", 0);
		final HttpPost post = new HttpPost("/pacific-rc-web/nStoreRecord/nStoreRecordList");
		post.addHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(json.toString(),"UTF-8"));
		final CloseableHttpResponse response = httpClient.execute(httpHost,	post, context);
		String result = EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
 	    System.out.println("jsons="+result);
 	    response.getEntity().getContent().close();
		httpClient.close();

	}
	
	//查询仓单查询历史
	@Test
	public void testQueryWarrantySearchHisList()throws Exception{
		//WarrantySearchHis
		JSONObject json =new JSONObject();
		//json.put("searcher", "U76960");
		//json.put("searchTime", "2014/12/25~2015/02/28");//查询时间
		//json.put("prdCataName", "品种名称");
		//json.put("warehouseName", "U76960");
		//json.put("warrantyStatus", "05");
		//json.put("favoritesFlag", "0");
		//json.put("favoritesCode", "D10003");
		//json.put("password", "05");
		json.put("warrantyNo", "W140513004554");
		
		Map<String,String> map= new HashMap<String,String>();
		map.put("warehouseName", "desc");
		map.put("warrantyStatus", "asc");
		json.put("sortMap", map);
		final HttpPost post = new HttpPost("/pacific-rc-web/warrantySearchHis/warrantySearchHisList");
		post.addHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(json.toString(),"UTF-8"));
		final CloseableHttpResponse response = httpClient.execute(httpHost,	post, context);
		String result = EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
 	    System.out.println("jsons="+result);
 	    response.getEntity().getContent().close();
		httpClient.close();

	}
	@Test
	public void testSynData()throws Exception{
		JSONObject json =new JSONObject();
		json.put("key", "warrantyBean");
		final HttpPost post = new HttpPost("/shdc_service/synData/submit");
		post.addHeader("Content-Type", "application/json");
		post.setEntity(new StringEntity(json.toString(),"UTF-8"));
		final CloseableHttpResponse response = httpClient.execute(httpHost,	post, context);
		String result = EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
 	    System.out.println("jsons="+result);
 	    response.getEntity().getContent().close();
		httpClient.close();

	}
	
	@Test
	public void  testWarranty(){
		String warranty="W1111111";
		String warrantys="W222222,W3333333";
		
		 //Arrays.asList
		List<String> list=Arrays.asList(warranty.split(","));
		List<String> lists=Arrays.asList(warrantys.split(","));
		
		for (String string : list) {
			System.out.println("string:"+string);
		}
		for (String string : lists) {
			System.out.println("string:"+string);
		}
	}
}
