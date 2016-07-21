package com.yanglijun.news_v1.activity;

import java.util.ArrayList;
import java.util.List;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.Fragment.JokesFragment;
import com.yanglijun.news_v1.Fragment.MoreFragment;
import com.yanglijun.news_v1.Fragment.PictureFragment;
import com.yanglijun.news_v1.weixin.WeixinFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

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
		
		rbMovies = (RadioButton) findViewById(R.id.movies);
		rbJokes = (RadioButton) findViewById(R.id.jokes);
		rbBooks = (RadioButton) findViewById(R.id.books);
		rbCooks = (RadioButton) findViewById(R.id.more);
		
		viewPager = (ViewPager) findViewById(R.id.viewpage);
	}


	private void setViewPagerAdapter() {
		fragments = new ArrayList<Fragment>();
		fragments.add(new WeixinFragment());
		fragments.add(new JokesFragment());
		fragments.add(new PictureFragment());
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
					rbMovies.setChecked(true);
					break;
				case 1:
					rbJokes.setChecked(true);
					break;
				case 2:
					rbBooks.setChecked(true);
					break;
				case 3:
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
				case R.id.movies:
					viewPager.setCurrentItem(0);
					break;
				case R.id.jokes:
					viewPager.setCurrentItem(1);
					break;
				case R.id.books:
					viewPager.setCurrentItem(2);
					break;
				case R.id.more:
					viewPager.setCurrentItem(3);
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
