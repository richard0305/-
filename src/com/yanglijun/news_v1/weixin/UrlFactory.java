package com.yanglijun.news_v1.weixin;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlFactory {
	
	public static String getNewList(String key){
		try {
			key  = URLEncoder.encode(key,"utf-8");
			String url = "http://apis.baidu.com/txapi/weixin/wxhot?num=50&rand=1&word="+key+"&page=1&src=%E4%BA%BA%E6%B0%91%E6%97%A5%E6%8A%A5";
			return url;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	

}
