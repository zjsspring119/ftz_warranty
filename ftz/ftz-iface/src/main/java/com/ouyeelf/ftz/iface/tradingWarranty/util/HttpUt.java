package com.ouyeelf.ftz.iface.tradingWarranty.util;

import java.util.Map;

import net.sf.json.JSONObject;

import com.easterpay.base.util.SignUtil;
import com.ouyeelf.ftz.common.utils.ReadPropertiesFile;

/**
 * HttpUt 验签工具类
 */
public class HttpUt {
	/**
	 * 验签  true:成功    false：失败
	 */
	public static boolean checkSign(String json) {
		JSONObject object = JSONObject.fromObject(json);
		String signature = object.getString("signature");
		String serialNumber=object.getString("serialNumber");
		JSONObject jsonObject=new JSONObject();
		jsonObject.accumulate("serialNumber", serialNumber);
		jsonObject.accumulate("signature", signature);
		Map shdcSys = ReadPropertiesFile.getProperties();
		String path = (String) shdcSys.get("IFACE_INTERFACE_PATH");
		String pwd = shdcSys.get("IFACE_INTERFACE_PASSWORD").toString().trim();
		boolean result = SignUtil.verifySignedDataDetached(path,pwd,signature,jsonObject.toString());
		System.out.println("【##验签结果:##】"+result);
		return result;
	}
	
	/**
	 * 加密
	 */
	public static String setPwd(String data) {
		Map shdcSys = ReadPropertiesFile.getProperties();
		String path = (String) shdcSys.get("IFACE_INTERFACE_PATH");
		String pwd = shdcSys.get("IFACE_INTERFACE_PASSWORD").toString().trim();
		JSONObject json = JSONObject.fromObject(data);
		String signature = SignUtil.signDataDetached(path, pwd, data);
		json.put("signature", signature);
		System.out.println("【##密钥:##】"+signature);
		System.out.println("【##json:##】"+json.toString());
		return json.toString();
	}

	public static void main(String[] args) {
		String json="{\"test\":\"test\",\"signature\":\"MIIDsgYJKoZIhvcNAQcCoIIDozCCA58CAQExCzAJBgUrDgMCGgUAMAsGCSqGSIb3DQEHAaCCAnAwggJsMIIB1aADAgECAgQbtl1qMA0GCSqGSIb3DQEBBQUAMFAxCzAJBgNVBAYTAkNOMSEwHwYDVQQKHhhbnZSilsZW4o0iUqFnCZZQjSNO+1FsU/gxDTALBgNVBAsTBEJTRkMxDzANBgNVBAMTBmJzZmNjYTAeFw0xMzA5MTgwNTQzMDZaFw0xNTA5MTgwNTQzMDZaMCwxCzAJBgNVBAYTAkNOMR0wGwYDVQQDHhSDA4++V84AIFudTtiQGgAgi8FOZjCBnzANBgkqhkiG9w0BAQEFAAOBjQAwgYkCgYEAuMGSVk23FEnk46JFQwi+ja7xZ8BS5tuWpOp4e4d4RPYyP2KXXeQ3wTkfA/UwZOCKYMuJTEU3QRtkQ0aUSxCeBgUoVA5K7BltqGkU+zPxyk5lW+3XE9xKhsK/jtJ85P5mQjfE95ZQD1Hg8MDGuukga2btn70h2x8cyFPKGmitm1ECAwEAAaN3MHUwHQYDVR0OBBYEFHqRqX9WF1GoV1Lz6GkPonUxNxYeMA4GA1UdDwEB/wQEAwIFoDAMBgNVHRMBAf8EAjAAMB8GA1UdIwQYMBaAFFSh8cJ+0m1qOck5Uyaor6BPO7GaMBUGCWCBHAGN2EYBAgQIEwYxNDQyMDIwDQYJKoZIhvcNAQEFBQADgYEAhhLfSCIIIJwBa8d/LCh8fBN645jpIILf9aBbOfIWZG7GxWmzCbB0QMjMLUeEk2PkEPAGeOkX4LYCQVDrwCwTbS0qLjqj6gn3vUCgnBq/6+LUOaceRfSYh7IyPwpKh8aFNwLW0rqQoPbkgKOnfWj+flsXypHXrdf3n6tvsGA457MxggEKMIIBBgIBATBkMFwxCzAJBgNVBAYTAkNOMS0wKwYDVQQKDCTlrp3pkqLpm4blm6LotKLliqHmnInpmZDotKPku7vlhazlj7gxDTALBgNVBAsTBEJTRkMxDzANBgNVBAMTBmJzZmNjYQIEG7ZdajAJBgUrDgMCGgUAMA0GCSqGSIb3DQEBAQUABIGAiml4KweT/HojUZ+GZa0C/oABJ54px7saoetf3kETXJsb+zlBw4mLxr68uZ0FRGXo86VQqp2u432pXFekRjjjOJfrWrDjToymTKxTqnyINtR/9/SohhCi6KilfHvt6c3b+qD1pJ8ViJt770RpCsQt763yFxgn08Y9Jv86/8khPg4=\"}";
		HttpUt.checkSign(json);
	}
}
