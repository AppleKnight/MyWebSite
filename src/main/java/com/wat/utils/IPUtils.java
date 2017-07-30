package com.wat.utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import com.google.gson.Gson;
import com.wat.domain.IPParseResult;

/**
 * 类说明
 * 
 * @author Wutao
 * @version 2017年7月26日 下午5:41:24
 * @see
 * @since
 */
public class IPUtils {
	public static void main(String[] args) {
		/*String host = "https://dm-81.data.aliyun.com";
		String path = "/rest/160601/ip/getIpInfo.json";*/
		String host="http://api.map.baidu.com/location/ip";
		String path = "";
		String method = "GET";
		String appcode = "0bcc6cfef7f94e578112b202c7cb09cb";
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
		// headers.put("Authorization", "APPCODE " + appcode);
		Map<String, String> querys = new HashMap<String, String>();
		//querys.put("ip", "36.149.2.106");
		querys.put("ak", "Bk0aLzSaZVVYhdGrT6ZURX3021xNIffW");
		querys.put("ip", "");
		querys.put("coor", "bd09ll");

		try {
			HttpResponse response = HttpUtils.doGet(host, path, method,
					headers, querys);
			System.err.println(response.toString());
			// 获取response的body
			System.err.println(EntityUtils.toString(response.getEntity()));

			/*String result = EntityUtils.toString(response.getEntity());
			 Gson gson = new Gson();
			 IPParseResult iPParseResult = gson.fromJson(result,IPParseResult.class);
			 System.err.println(iPParseResult.getCode());
			 System.err.println(iPParseResult.getData());*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
