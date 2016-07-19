package com.yanglijun.news_v1.entity;

public class Joke {

	private String xhid;
	private String author;
	private String Content;
	private String picUrl;

	public Joke() {
		super();
	}

	public Joke(String xhid, String author, String content, String picUrl) {
		super();
		this.xhid = xhid;
		this.author = author;
		Content = content;
		this.picUrl = picUrl;
	}

	public String getXhid() {
		return xhid;
	}

	public void setXhid(String xhid) {
		this.xhid = xhid;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "Joke [xhid=" + xhid + ", author=" + author + ", Content="
				+ Content + ", picUrl=" + picUrl + "]";
	}

}
