package com.yanglijun.news_v1.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.yanglijun.news_v1.entity.Joke;
import com.yanglijun.news_v1.entity.News;

public class JsonParse {

	public static List<Joke> parseJokeList(InputStream is) throws IOException,
			JSONException {
		String jsontext = HttpUtils.isToString(is);
		JSONObject obj = new JSONObject(jsontext);
		JSONArray ary = obj.getJSONArray("detail");
		List<Joke> jokes = new ArrayList<Joke>();
		for (int i = 0; i < ary.length(); i++) {
			JSONObject jobj = ary.getJSONObject(i);
			Joke joke = new Joke();
			joke.setAuthor(jobj.getString("author"));
			joke.setContent(jobj.getString("content"));
			joke.setPicUrl(jobj.getString("picUrl"));
			jokes.add(joke);
		}
		return jokes;
	}

	public static List<News> parseNewsList(InputStream is) throws IOException,
			JSONException {
		String jsontext = HttpUtils.isToString(is);
		JSONObject obj = new JSONObject(jsontext);
		JSONArray ary = obj.getJSONArray("detail");
		List<News> news = new ArrayList<News>();
		for (int i = 0; i < ary.length(); i++) {
			JSONObject nobj = ary.getJSONObject(i);
			News neww=new News();
			neww.setTitle(nobj.getString("title"));
			neww.setSource(nobj.getString("source"));
			neww.setArticle_url(nobj.getString("article_url"));
			neww.setBehot_time(nobj.getLong("behot_time"));
			neww.setBury_count(nobj.getInt("bury_count"));
			neww.setDigg_count(nobj.getInt("digg_count"));
			neww.setRepin_count(nobj.getInt("repin_count"));
			news.add(neww);
		}
		return news;
	}
}
