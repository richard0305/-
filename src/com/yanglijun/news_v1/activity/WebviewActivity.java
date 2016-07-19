package com.yanglijun.news_v1.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.webkit.WebView;

import com.yanglijun.news_v1.R;

public class WebviewActivity extends Activity {
	private WebView webview;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview);
		
		webview=(WebView) findViewById(R.id.webView);
//		Intent intent=getIntent();
		String url=getIntent().getStringExtra("url");
		Log.i("ÐÂÎÅÀàapp", "URL--->>>>>>>>>>>>>>"+url);
		webview.loadUrl(url);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.webview, menu);
		return true;
	}

}
