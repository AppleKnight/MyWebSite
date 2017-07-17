package com.wat.freemaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 类说明
 * @author Wutao
 * @version 2017年7月12日 下午8:35:10
 * @see
 * @since
 */
public class FreemakerTools {
	
	
	public void initBuildStaticPage(String sourceUrl,String targetUrl,String fileName,Map<String, Object> data,HttpServletRequest request) throws IOException{
		Configuration config = new Configuration(Configuration.VERSION_2_3_23);
		Writer out = null;
		//Web应用的上下文和一个基路径作为参数,基路径是Web应用根路径(WEB-INF目录的上级目录)的相对路径
		config.setServletContextForTemplateLoading(request.getSession().getServletContext(), "/");
		//设置字符集
		config.setEncoding(Locale.getDefault(), "UTF-8");
		try {
			Template template = config.getTemplate(sourceUrl);
			template.setEncoding("UTF-8");
			String path = request.getSession().getServletContext().getRealPath("/");
			System.err.println(path+"<========path=========");
			File dir = new  File(path+targetUrl);
			if(!dir.exists()){
				dir.mkdirs();
			}
			File staticpage = new File(path+targetUrl+fileName);
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(staticpage),"UTF-8"));
			template.process(data, out);
		} catch (Exception e) {
			System.err.println("it had been catched some Error!!!!");
			e.printStackTrace();
		}finally{
			out.flush();
			out.close();
		}
		
	}

}
