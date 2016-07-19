package com.yanglijun.news_v1.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtils {
	
			public static  String TimeFormat(long time){
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				return sdf.format(time);
	}
}
