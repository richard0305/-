package com.yanglijun.news_v1.activity;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.R.layout;
import com.yanglijun.news_v1.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PictureActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.picture, menu);
		return true;
	}

}
