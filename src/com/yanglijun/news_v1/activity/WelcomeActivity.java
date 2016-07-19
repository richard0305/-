package com.yanglijun.news_v1.activity;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

public class WelcomeActivity extends Activity {
	private AlphaAnimation startAnima;
	View view;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		view = View.inflate(this, R.layout.activity_welcome, null);
		setContentView(view);
		initData();
	}

	private void initData() {
		startAnima = new AlphaAnimation(0.3f, 1.0f);
		startAnima.setDuration(3000);
		view.startAnimation(startAnima);
		startAnima.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onAnimationEnd(Animation animation) {
				returnToMain();

			}
		});

	}

	protected void returnToMain() {
		startActivity(new Intent(this, MainActivity.class));
		finish();

	}

}
