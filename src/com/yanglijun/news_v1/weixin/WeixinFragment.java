package com.yanglijun.news_v1.weixin;

import java.util.List;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.weixin.NewsModel.Callback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class WeixinFragment extends Fragment implements OnClickListener{
	private EditText etEdit;
	private Button btButton;
	private ListView listView;
	private TextView tvTitle;
	private TextView tvTitle2;
	private ImageView ivPic;
	private String text;
	private  LinearLayout weixin_ll;
	private TextView tvTime;
	private NewsModel newsModel;
	private List<NewsList> newsLists;
	private MyAdapter myAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.weixinfragment, null);
		newsModel = new NewsModel();
		initViews(view);
		setListeners();
		
		return view;
	}

	private void initViews(View view) {
		tvTitle2 = (TextView) view.findViewById(R.id.tv_item_title2);
		tvTitle = (TextView)view.findViewById(R.id.tv_item_title);
		etEdit = (EditText) view.findViewById(R.id.et_edit);
		ivPic = (ImageView) view.findViewById(R.id.iv_pic);
		btButton = (Button) view.findViewById(R.id.bt_button);
		listView = (ListView) view.findViewById(R.id.listview);
		tvTime = (TextView) view.findViewById(R.id.tv_item_time);
		weixin_ll=(LinearLayout) view.findViewById(R.id.weixin_ll);
		
	}

	private void setListeners() {
		btButton.setOnClickListener(this);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long Id) {
				Intent i = new Intent(getActivity(), WebActivity.class);
				i.putExtra("url", newsLists.get(position).getUrl());
				startActivity(i);
			}

		});
		
		listView.setOnScrollListener(new OnScrollListener() {
			
			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
					
				
				switch (scrollState) {
				case SCROLL_STATE_FLING:
					weixin_ll.setVisibility(view.GONE);
					break;
				case SCROLL_STATE_IDLE:
					weixin_ll.setVisibility(view.VISIBLE);
					break;
				
				}	
			}
			@Override
			public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
				
			}
			
		});

	}

	@Override
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.bt_button:
			new Thread(
					new Runnable() {
						public void run() {
							try {
								find();
							} catch (Exception e) {
								e.printStackTrace();
							}
							
						}
					}).start();
			
			
			break;
		}
	}

	private void find() {
			String key = etEdit.getText().toString();
			if(key==""){
				Toast.makeText(getActivity(), "Ç×~¹Ø¼ü×ÖÍüÁË°Â£¡",Toast.LENGTH_SHORT).show();
				return;
			}
			newsModel.search(key, new Callback() {

				@Override
				public void onNewsLoaded(List<NewsList> newlist) {
					newsLists = newlist;
					myAdapter = new MyAdapter(getActivity(), newlist);
					listView.setAdapter(myAdapter);
				}
			});
			
	

	}

}

