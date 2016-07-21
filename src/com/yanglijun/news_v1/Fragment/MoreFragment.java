package com.yanglijun.news_v1.Fragment;

import com.yanglijun.news_v1.AboutUsActivity;
import com.yanglijun.news_v1.R;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import shareapk.view.ShareApkMainActivity;

public class MoreFragment extends Fragment{
	private TextView tverweima;
	private TextView tvshareapk;
	private TextView tvaboutus;
	
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.morefragment, null);
		setViews(view);
		setListener();
		return view;
	}
	
	
	private void setListener() {
		tverweima.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent1=new Intent(getActivity(), zxing.activity.QcodeActivity.class);
				startActivity(intent1);
				
			}
		});
		tvshareapk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(), ShareApkMainActivity.class);
				startActivity(intent);
				
			}
		});
		
		tvaboutus.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(getActivity(), AboutUsActivity.class);
				startActivity(intent);
				
			}
		});
		
	}

	private void setViews(View view) {
		tvaboutus=(TextView) view.findViewById(R.id.tv_aboutus);
		tverweima=(TextView) view.findViewById(R.id.tv_erweima);
		tvshareapk=(TextView) view.findViewById(R.id.tv_share_apk);
	}

	
	
}
