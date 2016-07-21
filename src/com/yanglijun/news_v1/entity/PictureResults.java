package com.yanglijun.news_v1.entity;

import java.util.List;

public class PictureResults {
	private boolean error;
	private List<Picture>results;
	
	
	
	
	public PictureResults(boolean error, List<Picture> results) {
		super();
		this.error = error;
		this.results = results;
	}
	public PictureResults() {
		super();
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public List<Picture> getResults() {
		return results;
	}
	public void setResults(List<Picture> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "PictureResults [error=" + error + ", results=" + results + "]";
	}
	
}
