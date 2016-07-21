package com.yanglijun.news_v1.adapter;


import java.util.List;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.adapter.RecyclerViewAdapter.MyViewHolder;
import com.yanglijun.news_v1.entity.Picture;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {

	private List<Picture> pictures;
	private Context context;
	private LayoutInflater Inflater;
	
	public interface RecyclerViewOnItemClickListener{
		void onItemClick(View view,int position);
		void onItemLongClick(View view,int position);
	}
	
	private RecyclerViewOnItemClickListener mOnItemClickListener;
	
	public void setRecyclerViewOnItemClickListener(RecyclerViewOnItemClickListener listener){
		this.mOnItemClickListener=listener;
	}
	
	public RecyclerViewAdapter(List<Picture> pictures, Context context) {
		super();
		this.pictures = pictures;
		this.context = context;
		this.Inflater = LayoutInflater.from(context);

	}
	
	

	@Override
	public int getItemCount() {
		return pictures.size();
	}

	@Override
	public void onBindViewHolder(final MyViewHolder holder, final int pos) {
		// holder.tv
		Picture picture = pictures.get(pos);
		/**
		 * 显示的图片的各种格式DisplayImageOptions 的设置：
		 */

		DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();

		String url = picture.getUrl();
		ImageLoader.getInstance().displayImage(url, holder.ivShowPhoto, options);

		holder.tvTime.setText(picture.getCreatedAt().split("T", 0)[0]+"");
		Log.i("yanglijun", "-------------------------?//////////////////////////"+url);
		
		if(mOnItemClickListener!=null){
			
		holder.itemView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
					mOnItemClickListener.onItemClick(holder.itemView, pos);
			}
		});
		
		holder.itemView.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				mOnItemClickListener.onItemLongClick(holder.itemView, pos);
				return false;
			}
		});
		
		
		
		
		}
	}

	@Override
	public MyViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
		View view = Inflater.inflate(R.layout.item_photo, arg0, false);
		MyViewHolder holder = new MyViewHolder(view);
		return holder;
	}
 
	class MyViewHolder extends ViewHolder {
		TextView tvTime;
		ImageView ivShowPhoto;

		public MyViewHolder(View itemView) {
			super(itemView);
			tvTime = (TextView) itemView.findViewById(R.id.tv_pic_time);
			ivShowPhoto = (ImageView) itemView.findViewById(R.id.iv_showPhoto);
		}

	}

}

