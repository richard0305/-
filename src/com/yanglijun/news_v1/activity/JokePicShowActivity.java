package com.yanglijun.news_v1.activity;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.util.ZoomImageView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class JokePicShowActivity extends Activity {
	ZoomImageView ivjokeshow;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_joke_pic_show);
		
		ivjokeshow=(ZoomImageView) findViewById(R.id.joke_pic_show);
		
		Intent intent=getIntent();
		String url=intent.getStringExtra("picurl");
		
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true).build();
		
		ImageLoader.getInstance().displayImage(url, ivjokeshow,
				options);
	}
	
	
	
	
	


}
