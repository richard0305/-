package com.yanglijun.news_v1.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.yanglijun.news_v1.entity.News;
import com.yanglijun.news_v1.util.HttpUtils;
import com.yanglijun.news_v1.util.JsonParse;
import com.yanglijun.news_v1.util.UrlFactory;

public class NewsModel {
	public void findNewsList(final Callback callback) {
		AsyncTask<String, String, List<News>> task = new AsyncTask<String, String, List<News>>() {

			@Override
			protected List<News> doInBackground(String... params) {
				String path = UrlFactory.getNewsListUrl();

				try {
					InputStream is = HttpUtils.get(path);
					List<News> news = JsonParse.parseNewsList(is);

					return news;
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void onPostExecute(List<News> news) {
				callback.onDataListLoaded(news);
			}

		};
		task.execute();
	}

	public interface Callback {
		/**
		 * 当列表加载完毕后 将会调用该方法 在该方法的实现中需要执行列表加载完毕后的业务逻辑
		 * 
		 * @param jokes
		 */
		void onDataListLoaded(List<News> news);
	}

}
