package com.yanglijun.news_v1.entity;

import java.util.Date;

public class News {
	private String title;
	private String source;
	private String article_url;
	private long behot_time;
	private int digg_count;
	private int bury_count;
	private int repin_count;

	public News() {
		super();
	}

	public News(String title, String source, String article_url,
			long behot_time, int digg_count, int bury_count, int repin_count) {
		super();
		this.title = title;
		this.source = source;
		this.article_url = article_url;
		this.behot_time = behot_time;
		this.digg_count = digg_count;
		this.bury_count = bury_count;
		this.repin_count = repin_count;
	}

	public long getBehot_time() {
		return behot_time;
	}

	public void setBehot_time(long behot_time) {
		this.behot_time = behot_time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getArticle_url() {
		return article_url;
	}

	public void setArticle_url(String article_url) {
		this.article_url = article_url;
	}

	



	public int getDigg_count() {
		return digg_count;
	}

	public void setDigg_count(int digg_count) {
		this.digg_count = digg_count;
	}

	public int getBury_count() {
		return bury_count;
	}

	public void setBury_count(int bury_count) {
		this.bury_count = bury_count;
	}

	public int getRepin_count() {
		return repin_count;
	}

	public void setRepin_count(int repin_count) {
		this.repin_count = repin_count;
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", source=" + source + ", article_url="
				+ article_url + ", behot_time=" + behot_time + ", digg_count="
				+ digg_count + ", bury_count=" + bury_count + ", repin_count="
				+ repin_count + "]";
	}

}
