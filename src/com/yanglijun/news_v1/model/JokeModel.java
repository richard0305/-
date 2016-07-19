package com.yanglijun.news_v1.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.JSONException;

import android.os.AsyncTask;

import com.yanglijun.news_v1.entity.Joke;
import com.yanglijun.news_v1.util.HttpUtils;
import com.yanglijun.news_v1.util.JsonParse;
import com.yanglijun.news_v1.util.UrlFactory;

public class JokeModel {

	public void findJokeList(final Callback callback, final int page) {
		AsyncTask<String, String, List<Joke>>task=new AsyncTask<String, String, List<Joke>>(){

			@Override
			protected List<Joke> doInBackground(String... params) {
				String path = UrlFactory.getJokeListUrl(page);

				try {
					InputStream is = HttpUtils.get(path);
					List<Joke> jokes = JsonParse.parseJokeList(is);
					
					return jokes;
				} catch (IOException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
				return null;
			}
			
			@Override
			protected void onPostExecute(List<Joke>jokes) {
				callback.onJokeListLoaded(jokes);
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
		void onJokeListLoaded(List<Joke> jokes);
	}

}
