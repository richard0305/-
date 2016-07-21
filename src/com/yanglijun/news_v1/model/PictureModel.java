package com.yanglijun.news_v1.model;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;
import com.yanglijun.news_v1.app.ReadApplication;
import com.yanglijun.news_v1.entity.Picture;
import com.yanglijun.news_v1.entity.PictureResults;
import com.yanglijun.news_v1.model.IModel.AsycnCallBack;
import com.yanglijun.news_v1.util.UrlFactory;

import android.util.Log;

public class PictureModel implements IPictureModel {
	private List<Picture>pictures;
	
	

	public PictureModel() {
		super();
	}



	@Override
	public void LoadPicture(int page, final AsycnCallBack back) {
		String url=UrlFactory.getPictureListUrl(page);
		StringRequest request=new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				Gson gson=new Gson();
				PictureResults results=gson.fromJson(response, PictureResults.class);
				pictures=results.getResults();
				
				Log.i("||||||||||||||||||||||||||", "!!!!!!!!!!!!!1=="+pictures);
				
				back.onSuccess(pictures);
				
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				back.onError(error.getMessage());
				
			}
		});
		ReadApplication.getQueue().add(request);
		
	}
	
}
