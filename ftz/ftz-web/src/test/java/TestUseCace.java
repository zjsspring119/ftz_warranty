import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.PropertyFilter;

import com.ouyeelf.ftz.model.resource.query.WarrantySearchHisQuery;


public class TestUseCace {

	
	
	public void testJsonToJava(){
		String jsonData="";
		JsonConfig config = new JsonConfig();  
		config.setExcludes( new String[]{"warrantyStatus"});
		config.setJavaPropertyFilter(new PropertyFilter() {//设置转化成java时需要忽略的属性
			public boolean apply(Object source, String name, Object value) {
				// TODO Auto-generated method stub
				return source instanceof WarrantySearchHisQuery && "warrantyStatus".equalsIgnoreCase(name);
			}
		 
		});
		config.setRootClass(WarrantySearchHisQuery.class);
		WarrantySearchHisQuery warrantySearchHisQuery=(WarrantySearchHisQuery)JSONObject.toBean(JSONObject.fromObject(jsonData), config );
		
	}
}
