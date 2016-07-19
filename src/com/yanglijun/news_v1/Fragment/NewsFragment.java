package com.yanglijun.news_v1.Fragment;

import java.util.List;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.activity.WebviewActivity;
import com.yanglijun.news_v1.adapter.NewsAdapter;
import com.yanglijun.news_v1.entity.News;
import com.yanglijun.news_v1.model.NewsModel;
import com.yanglijun.news_v1.model.NewsModel.Callback;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NewsFragment extends Fragment {
	private List<News> news;
	private ListView lvNews;
	private NewsAdapter newsadapter;
	private NewsModel model = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.newsfragment, null);
		model = new NewsModel();
		setViews(view);
		setlistener();
		model.findNewsList(new Callback() {

			@Override
			public void onDataListLoaded(List<News> news) {
				NewsFragment.this.news = news;
				setAdapter(news);
			}
		});

		return view;

	}

	private void setViews(View view) {
		lvNews = (ListView) view.findViewById(R.id.lv_news_item);
	}

	private void setlistener() {
	lvNews.setOnItemClickListener(new OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
			News newss=news.get(position);
			String url=newss.getArticle_url();
			Intent intent=new Intent(getActivity(), WebviewActivity.class);
			intent.putExtra("url", url);
			startActivity(intent);
		}
	});

	}

	protected void setAdapter(List<News> news) {
		newsadapter = new NewsAdapter(getActivity(), news);
		lvNews.setAdapter(newsadapter);
	}


}
