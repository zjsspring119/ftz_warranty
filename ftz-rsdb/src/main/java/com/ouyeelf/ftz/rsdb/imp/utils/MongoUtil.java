package com.ouyeelf.ftz.rsdb.imp.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import java.util.concurrent.locks.ReentrantLock;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.ouyeelf.ftz.common.utils.DateUtil;


public class MongoUtil {
    private final static ReentrantLock lock = new ReentrantLock();
    private volatile static DB db;
    public static final String EMPTY_STRING = "";
    public static DB getDB() {
        if (null == db) {
            lock.lock();

            try {
                if (null == db) {
                    init();
                }
            } finally {
                lock.unlock();
            }
        }

        return db;
    }

    private static void init() {
        Properties p;

        try {
            p = ResourcesUtil.getResourceAsProperties("mongo.properties");
            String ips = p.getProperty("db.ips");
            String dbname = p.getProperty("db.dbname");
            String username = p.getProperty("db.username");
            String password = p.getProperty("db.password");
             System.out.println("ips:"+ips);
	          /*String ips = "127.0.0.1:27017";
	           	String dbname = "shdc";
	           	String username = "";
	           	String password = "";*/
	            List<ServerAddress> addressList = new ArrayList<ServerAddress>();

            if ((ips != null) && (ips.length() > 0)) {
                ServerAddress serverAddress = null;
                StringTokenizer st = new StringTokenizer(ips, ",");

                while (st.hasMoreTokens()) {
                    String ipAndPort = st.nextToken();
                    String ip = substring(ipAndPort, ":", 1);
                    String port = substring(ipAndPort, ":", -1);
                    serverAddress = new ServerAddress(ip, Integer.parseInt(port));
                    addressList.add(serverAddress);
                }
            }

            MongoClient mongoClient = new MongoClient(addressList);
            mongoClient.setReadPreference(ReadPreference.primaryPreferred());
            db = mongoClient.getDB(dbname);
            if ((username != null) && !"".equals(username.trim()) &&
                    (password != null) && !"".equals(password.trim())) {
                db.authenticate(username, password.toCharArray());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String substring(String str, String separator, int around) {
        if ((str == null) || (str.length() == 0)) {
            return str;
        }

        if (separator == null) {
            return EMPTY_STRING;
        }

        int pos = str.indexOf(separator);

        if (pos == -1) {
            return EMPTY_STRING;
        }

        if (around == -1) {
            return str.substring(pos + separator.length());
        }

        return str.substring(0, pos);
    }
    
    
	
	/**
	 *  copy pojo到BasicDBObject
	 * @param b
	 * @param pojo
	 * @return
	 */
	public static BasicDBObject append(BasicDBObject b,Object pojo) {
		   Class wc=pojo.getClass();
		   try {
			Method[] mds=wc.getDeclaredMethods();
			   Field[] fields= wc.getDeclaredFields();
			   for (Field field : fields) {
				    String name=field.getName(); 
				    Object value=null;
				    name=name.substring(0, 1).toUpperCase()+name.substring(1);
					field.setAccessible(true);//暴力反射 ，针对private
					value =getter(pojo,name);
					if(null==value){
						value="";
					}else{
						if(BigDecimal.class==field.getType()){
							value=new BigDecimal(value.toString()).divide(new BigDecimal(1), 2, BigDecimal.ROUND_HALF_UP).toString();
						}else if(Integer.class==field.getType()){
							value=value.toString();
						}else if(Date.class==field.getType()){
							value=DateUtil.toDateString((Date)value, DateUtil.DEFAULT_DATETIME_PATTERN);
						}
					}
				   }
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return b;
	}
	
	
	/**
	 * 
	 * @param obj	操作的对象
	 * @param att	操作的属性
	 */
	protected static Object getter(Object obj,String att){
		Object value = null;
		try{
			Method method = obj.getClass().getMethod("get"+att);
			value = method.invoke(obj);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return value;
	}
	
    
}
