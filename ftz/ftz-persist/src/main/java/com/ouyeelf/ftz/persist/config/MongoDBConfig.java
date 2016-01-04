package com.ouyeelf.ftz.persist.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.ReadPreference;
import com.mongodb.ServerAddress;
import com.mongodb.WriteConcern;
import com.waxberry.common.util.ResourcesUtil;

@Configuration
public class MongoDBConfig {
/**mongo db**/
	
	
	
	public @Bean
	MongoDbFactory mongoDbFactory() throws Exception {
		 Properties p = null;
		try{
			p = ResourcesUtil.getResourceAsProperties("lgs_ftz.properties");
		}catch(Exception e){
			throw e;
		}
		 String ips = p.getProperty("db.ips");

		 String dbname = p.getProperty("db.dbname");
		 String username = p.getProperty("db.username");
		 String password = p.getProperty("db.password");
		 System.out.println("ips:"+ips);
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
		 
		 
		 Mongo mongo=new Mongo( addressList );
		 mongo.setReadPreference(ReadPreference.secondaryPreferred());
		 
		 //config
		 mongo.setWriteConcern(WriteConcern.SAFE);
		 MongoOptions options = mongo.getMongoOptions();  
		 options.autoConnectRetry = true; 
		 options.threadsAllowedToBlockForConnectionMultiplier = 10000;  
		 
		 //db factory
		 SimpleMongoDbFactory mongoDbFactory = null;
		 if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)){ 
			 mongoDbFactory = new SimpleMongoDbFactory(mongo,dbname,new UserCredentials(username, password));
		 }else{
			 mongoDbFactory = new SimpleMongoDbFactory(mongo,dbname);
		 }
		 return mongoDbFactory;
	}
	
	public @Bean
	MongoTemplate mongoTemplate() throws Exception {
		MongoTemplate mongoTemplate = new MongoTemplate(mongoDbFactory());
		return mongoTemplate;
	}
	
	public static final String EMPTY_STRING = "";
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
}
