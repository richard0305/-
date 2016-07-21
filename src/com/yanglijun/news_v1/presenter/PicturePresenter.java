package com.yanglijun.news_v1.presenter;

import java.util.List;

import com.yanglijun.news_v1.entity.Picture;
import com.yanglijun.news_v1.model.IModel.AsycnCallBack;
import com.yanglijun.news_v1.model.IPictureModel;
import com.yanglijun.news_v1.model.PictureModel;
import com.yanglijun.news_v1.view.IPictureView;

public class PicturePresenter implements IPicturePresenter {
	private IPictureView view;
	private IPictureModel model;
	
	public PicturePresenter(IPictureView view) {
		super();
		this.view = view;
		model=new PictureModel();
	}
	
	@Override
	public void LoadPicture(int page) {
		model.LoadPicture(page, new AsycnCallBack() {
			
			@Override
			public void onSuccess(Object success) {
				List<Picture>pictures=(List<Picture>) success;
				view.showData(pictures);
				
			}
			
			@Override
			public void onError(Object error) {
				
			}
		});
		
	}

}
