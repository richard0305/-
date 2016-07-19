package com.yanglijun.news_v1.util;

public class UrlFactory {

	
	public static String getJokeListUrl(int page){
		
		String path="http://api.1-blog.com/biz/bizserver/xiaohua/list.do?page="+page;
		return path;
		
		
		
		
		
	}
	
	public static String getNewsListUrl(){
		String newspath="http://api.1-blog.com/biz/bizserver/news/list.do";
		return newspath;
	}
}
