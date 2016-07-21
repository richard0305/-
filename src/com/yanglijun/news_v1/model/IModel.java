package com.yanglijun.news_v1.model;

public interface IModel {
	public interface  AsycnCallBack {
		void onSuccess(Object success);
		void onError(Object error);
	}
}
