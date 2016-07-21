package com.yanglijun.news_v1.adapter;

import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.entity.Picture;
import com.yanglijun.news_v1.util.UrlFactory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PictureListAdapter extends BaseAdapter {

		private Context context;
		private List<Picture>pictures;
		private LayoutInflater Inflater;
		
	public PictureListAdapter(Context context, List<Picture> pictures) {
			super();
			this.context = context;
			this.pictures = pictures;
			this.Inflater=LayoutInflater.from(context);
		}

	@Override
	public int getCount() {
		return pictures.size();
	}

	@Override
	public Picture getItem(int position) {
		return pictures.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder=null;
		if(convertView==null){
			convertView=Inflater.inflate(R.layout.item_photo_list, null);
			holder=new ViewHolder();
			holder.ivPicture=(ImageView) convertView.findViewById(R.id.imageView1);
			convertView.setTag(holder);
		}else{
			holder=(ViewHolder) convertView.getTag();
		}
		Picture picture=getItem(position);
		
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true).build();
		
		String url=picture.getUrl();
		ImageLoader.getInstance().displayImage(url,holder.ivPicture,options);
		
		
		return convertView;
	}
	class ViewHolder{
		ImageView ivPicture;
	}

}
