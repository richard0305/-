package com.yanglijun.news_v1.weixin;


import java.lang.reflect.InvocationTargetException;

import com.yanglijun.news_v1.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends Activity {
	private WebView webView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		setContentView(R.layout.weixin_webview_activity);
		webView = (WebView) findViewById(R.id.wv);
		WebSettings setting = webView.getSettings();
		setSettings(setting);
		webView.setWebChromeClient(new WebChromeClient());
		webView.setWebViewClient(new WebViewClient());
		
		try {
			setData();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressLint("SetJavaScriptEnabled")
	private void setSettings(WebSettings setting) {
		setting.setJavaScriptEnabled(true);
		setting.setBuiltInZoomControls(true);
		setting.setDisplayZoomControls(false);
		setting.setSupportZoom(true);

		setting.setDomStorageEnabled(true);
		setting.setDatabaseEnabled(true);
		// ȫ����ʾ
		setting.setLoadWithOverviewMode(true);
		setting.setUseWideViewPort(true);
	}

	@SuppressLint("SetJavaScriptEnabled")
	private void setData() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {

		String url = getIntent().getStringExtra("url");
		webView = new WebView(this);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebChromeClient(new WebChromeClient()); 
		webView.getClass().getMethod("onResume").invoke(webView,(Object[])null);
//		  webView.getSettings().setPluginsEnabled(true);
        webView.getSettings().setPluginState(PluginState.ON);
	         
        webView.setVisibility(View.VISIBLE);
        webView.getSettings().setUseWideViewPort(true);
		webView.loadUrl(url);
		setContentView(webView);

	}

	
}
