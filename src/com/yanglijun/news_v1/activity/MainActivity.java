package com.yanglijun.news_v1.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.Fragment.BooksFragment;
import com.yanglijun.news_v1.Fragment.MoreFragment;
import com.yanglijun.news_v1.Fragment.JokesFragment;
import com.yanglijun.news_v1.Fragment.NewsFragment;
import com.yanglijun.news_v1.R.id;
import com.yanglijun.news_v1.R.layout;
import com.yanglijun.news_v1.weixin.WeixinFragment;

public class MainActivity extends FragmentActivity {
	private RadioGroup rgReader;
	private RadioButton rbNews;
	private RadioButton rbMovies;
	private RadioButton rbJokes;
	private RadioButton rbBooks;
	private RadioButton rbCooks;
	private ViewPager viewPager;
	private PagerAdapter pagerAdapter;
	private List<Fragment> fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		setViews();
		setViewPagerAdapter();
		setListeners();
		
	}

	private void setViews() {
		rgReader = (RadioGroup) findViewById(R.id.rg_control);
		rbNews = (RadioButton) findViewById(R.id.news);
		rbMovies = (RadioButton) findViewById(R.id.movies);
		rbJokes = (RadioButton) findViewById(R.id.jokes);
		rbBooks = (RadioButton) findViewById(R.id.books);
		rbCooks = (RadioButton) findViewById(R.id.more);
		viewPager = (ViewPager) findViewById(R.id.viewpage);
	}

	public void doClick(View view) {
		switch (view.getId()) {
		case R.id.iv_weather:
			Intent intent1 = new Intent(this, WeatherActivity.class);
			startActivity(intent1);
			break;

		case R.id.iv_picture:
			Intent intent2 = new Intent(this, PictureActivity.class);
			startActivity(intent2);
			break;
		}
	}

	private void setViewPagerAdapter() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new NewsFragment());
		fragments.add(new WeixinFragment());
		fragments.add(new JokesFragment());
		fragments.add(new BooksFragment());
		fragments.add(new MoreFragment());
		pagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
		viewPager.setAdapter(pagerAdapter);

	}

	private void setListeners() {
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int position) {
				switch (position) {
				case 0:
					rbNews.setChecked(true);
					break;
				case 1:
					rbMovies.setChecked(true);
					break;
				case 2:
					rbJokes.setChecked(true);
					break;
				case 3:
					rbBooks.setChecked(true);
					break;
				case 4:
					rbCooks.setChecked(true);
					break;
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});

		rgReader.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				switch (checkedId) {
				case R.id.news:
					viewPager.setCurrentItem(0);
					break;
				case R.id.movies:
					viewPager.setCurrentItem(1);
					break;
				case R.id.jokes:
					viewPager.setCurrentItem(2);
					break;
				case R.id.books:
					viewPager.setCurrentItem(3);
					break;
				case R.id.more:
					viewPager.setCurrentItem(4);
					break;
				}
			}
		});

	}

	class MyPagerAdapter extends FragmentPagerAdapter {

		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {

			return fragments.get(position);
		}

		@Override
		public int getCount() {
			return fragments.size();
		}

	}


}
