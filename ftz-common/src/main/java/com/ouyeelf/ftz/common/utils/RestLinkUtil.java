package com.ouyeelf.ftz.common.utils;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpHost;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import com.waxberry.log.ILogger;
import com.waxberry.log.LoggerFactory;


/**
 * 
 * @author ETHAN.DU
 * 
 * 共用的restful链接
 */
public class RestLinkUtil {
	protected final ILogger logger = getLogger(this);
	static Map lgsBaols = ReadPropertiesFile.getProperties();
	private final static HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
	private  CloseableHttpClient httpClient;
	private  static HttpHost httpHost = null;
	private final static HttpClientContext context = HttpClientContext.create();
    private static RestLinkUtil restFulLinkUtil = null;
    
    private RestLinkUtil(){
    }
    private RestLinkUtil(String context){
    	logger.info("调用远程服务开始.....");
    	if(context.trim().equals("shdc_service")){
    		httpHost = new HttpHost((String)lgsBaols.get("RESTFUL_HOST_SERVICE"), Integer.valueOf(lgsBaols.get("RESTFUL_HOST_SERVICE_PORT").toString()), "http");
    		logger.info("shdc_service地址:"+(String)lgsBaols.get("RESTFUL_HOST_SERVICE")+":"+lgsBaols.get("RESTFUL_HOST_SERVICE_PORT"));
    	}else if(context.trim().equals("shdc_bss")){
    		httpHost = new HttpHost((String)lgsBaols.get("RESTFUL_HOST_BSS"), Integer.valueOf(lgsBaols.get("RESTFUL_HOST_BSS_PORT").toString()), "http");
    		//logger.info("shdc_bss地址:"+(String)lgsBaols.get("RESTFUL_HOST_BSS")+":"+lgsBaols.get("RESTFUL_HOST_BSS_PORT"));
    		logger.info("shdc_bss地址:"+(String)lgsBaols.get("RESTFUL_HOST_BSS")+":"+lgsBaols.get("RESTFUL_HOST_BSS_PORT"));
    	}else if(context.trim().equals("pacific-rc-web")){
    		httpHost = new HttpHost((String)lgsBaols.get("RESTFUL_HOST_PACIFIC"), Integer.valueOf(lgsBaols.get("RESTFUL_HOST_PACIFIC_PORT").toString()), "http");
    		//httpHost = new HttpHost("127.0.0.1", 8087, "http");
    		//logger.info("shdc_bss地址:"+(String)lgsBaols.get("RESTFUL_HOST_BSS")+":"+lgsBaols.get("RESTFUL_HOST_BSS_PORT"));
    		logger.info("pacific-rc-web地址:"+(String)lgsBaols.get("RESTFUL_HOST_PACIFIC")+":"+lgsBaols.get("RESTFUL_HOST_PACIFIC_PORT"));
    	}
    }
    public ILogger getLogger(Object classObject) {
		return LoggerFactory.getLogger(classObject.getClass());
	}
    public static RestLinkUtil getInstance(String context){
    	System.out.println("RestLinkUtil.class:#######"+context);
		if(null != context && !context.equals("")){
			restFulLinkUtil = new RestLinkUtil(context);
		}
    	return restFulLinkUtil;
    }
    public static RestLinkUtil getInstance(){
    	System.out.println("RestLinkUtil.class:#######"+context);
    	return new RestLinkUtil("shdc_service");
    }

    /**
     * @description 提供共用的restful链接，链接方式为POST
     * @param host 需要链接的应用名
     * @param useAddress 需要映射到的类
     * @param url  映射的方法地址
     * @param params 参数（一般为json格式或者单个字符串）
     * @return 返回可为json格式或者单个字符串
     */
    public String commonLinkPost(String host,String useAddress,String url,String params){
    	String result="1";//设置返回值
		httpClient = httpClientBuilder.build();//初始化httpClient
		try{
			final HttpPost  httpPost = new HttpPost("/"+host+"/"+useAddress+((null == url || url.equals(""))?"":url)+"/"+(null==params?"":URLEncoder.encode(params,"UTF-8")));
			httpPost.addHeader("Content-Type", "application/json");
			final CloseableHttpResponse response = httpClient.execute(httpHost, httpPost,context);
			result =EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
			response.getEntity().getContent().close();
			httpClient.close();
		}catch(Exception ex){
			result = "0";
			ex.printStackTrace();
		}
    	return result;
    }
    
    /**
     * @description 提供共用的restful链接，链接方式为GET
     * @param host 需要链接的应用名
     * @param url  映射的方法地址
     * @param params 参数（一般为json格式或者单个字符串）
     * @return 返回可为json格式或者单个字符串
     */
    public String commonLinkGet(String host,String useAddress,String url,String params)throws Exception{
    	String result="1";//设置返回值
		httpClient = httpClientBuilder.build();//初始化httpClient
		try{
			final HttpGet  httpGet = new HttpGet("/"+host+"/"+useAddress+((null == url || url.equals(""))?"":url)+"/"+(null==params?"":URLEncoder.encode(params,"UTF-8")));
			httpGet.addHeader("Content-Type", "application/json");
			final CloseableHttpResponse response = httpClient.execute(httpHost, httpGet,context);
			result = EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
			response.getEntity().getContent().close();
			httpClient.close();
		}catch(Exception ex){
			ex.printStackTrace();
			return "0";
		}
    	return result;
    }
    
    /**
     * @description 处理大数据传输
     * @param host 需要链接的应用名
     * @param useAddress 需要映射到的类
     * @param url 映射的方法地址
     * @param params 参数（为json格式）
     * @return
     * @throws Exception
     */
    public String bigDataPost(String host,String useAddress,String url,String params)throws Exception{
    	String result="1";//设置返回值
    	PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager();
	    connManager.setMaxTotal(200);//设置最大连接数200
	    connManager.setDefaultMaxPerRoute(20);//设置每个路由默认连接数
	    connManager.setMaxPerRoute(new HttpRoute(httpHost), 50);//每个路由器对每个服务器允许最大5个并发访问
	    CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connManager).build();
		try{
			final HttpPost  httpPost = new HttpPost("/"+host+"/"+useAddress+((null == url || url.equals(""))?"":url));
			httpPost.addHeader("Content-Type", "application/json");
			httpPost.setEntity(new StringEntity(params,"UTF-8"));
			final CloseableHttpResponse response = httpClient.execute(httpHost, httpPost,context);
			logger.info("name:"+Thread.currentThread().getName());
			result = EntityUtils.toString(response.getEntity(),Charset.forName("UTF-8"));
			response.getEntity().getContent().close();
			httpClient.close();
		}catch(Exception ex){
			result = "0";
			ex.printStackTrace();
		}
    	return result;
    }
}
