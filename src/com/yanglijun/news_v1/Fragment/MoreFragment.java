package com.yanglijun.news_v1.Fragment;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.activity.PictureActivity;
import com.yanglijun.news_v1.activity.WeatherActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MoreFragment extends Fragment{
	private ImageView ivWeather;
	private ImageView ivPicture;
	private ImageView iverweima;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.morefragment, null);
		setViews(view);
		setListener();
		return view;
	}
	
	
	private void setListener() {
		iverweima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent1=new Intent(getActivity(), zxing.activity.QcodeActivity.class);
				startActivity(intent1);
				
			}
		});
		
	}


	private void setViews(View view) {
		ivPicture=(ImageView) view.findViewById(R.id.iv_picture);
		ivWeather=(ImageView) view.findViewById(R.id.iv_weather);
		iverweima=(ImageView) view.findViewById(R.id.iv_erweima);
	}


	public void doClick(View view){
		switch(view.getId()){
		case R.id.iv_weather:
			Intent intent3=new Intent(getActivity(),WeatherActivity.class);
			startActivity(intent3);
			break;
			
		case R.id.iv_picture:
			Intent intent2=new Intent(getActivity(),PictureActivity.class);
			startActivity(intent2);
			break;
		case R.id.iv_erweima:
			Log.i("yanglijun1212121", "wodianjile zhge ");
			
			break;
		}
	}
	
	
}
