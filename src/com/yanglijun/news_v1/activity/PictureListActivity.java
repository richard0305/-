package com.yanglijun.news_v1.activity;

import java.util.List;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.adapter.PictureListAdapter;
import com.yanglijun.news_v1.entity.Picture;
import com.yanglijun.news_v1.presenter.IPicturePresenter;
import com.yanglijun.news_v1.presenter.PicturePresenter;
import com.yanglijun.news_v1.view.IPictureView;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PictureListActivity extends Activity {
	private List<Picture>datas;
	private PictureListAdapter adapter;
//	private ListView lvPicture;
	private Gallery gallery;
	private TextView tvTitle;
	private ImageView ivShare,ivReturn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_picture_list);
		initView();
		setListener();
		
		datas=(List<Picture>) getIntent().getSerializableExtra("pictures");
		adapter=new PictureListAdapter(PictureListActivity.this, datas);
//		lvPicture.setAdapter(adapter);
		gallery.setAdapter(adapter);
		
	}


	private void setListener() {
		ivReturn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				PictureListActivity.this.finish();
				
			}
		});
		
		
		
		
		//长按显示菜单，保存图片
		gallery.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				Picture picture=datas.get(position);
				AlertDialog.Builder builder=new AlertDialog.Builder(PictureListActivity.this);
				builder.setItems(new String[]{getResources().getString(R.string.save_picture)},new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						gallery.setDrawingCacheEnabled(true);
						Toast.makeText(PictureListActivity.this, "你想的真美~",Toast.LENGTH_SHORT ).show();
					}
				}) ;
				builder.show();
				return true;
			}
		});
		
		
		
	}


		
		


	private void initView() {
//		lvPicture=(ListView) findViewById(R.id.iv_showPic);
		gallery=(Gallery) findViewById(R.id.iv_showPic);
		tvTitle=(TextView) findViewById(R.id.tv_title);
		ivReturn=(ImageView) findViewById(R.id.iv_return);
	}




}
