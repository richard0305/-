package com.yanglijun.news_v1.adapter;

import java.util.List;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.sax.StartElementListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.Fragment.JokesFragment;
import com.yanglijun.news_v1.activity.JokePicShowActivity;
import com.yanglijun.news_v1.entity.Joke;
import com.yanglijun.news_v1.util.ZoomImageView;

public class JokesAdapter extends BaseAdapter {
	private List<Joke> jokes;
	private Context context;
	private LayoutInflater inflater;
	int position;

	public JokesAdapter(List<Joke> jokes, Context context) {
		super();
		this.jokes = jokes;
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return jokes.size();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.jokes_item_show, null);
			holder = new ViewHolder();
			holder.tvContent = (TextView) convertView
					.findViewById(R.id.tv_jokes_content);
			holder.tvauthor = (TextView) convertView
					.findViewById(R.id.tv_jokes_author);
			holder.ivPic = (ImageView) convertView
					.findViewById(R.id.iv_jokes_pic);
			convertView.setTag(holder);
			holder.ivShare = (ImageView) convertView
					.findViewById(R.id.iv_share);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		Joke joke = getItem(position);
		holder.tvContent.setText(joke.getContent() + "\n");
		holder.tvauthor.setText("作者: " + joke.getAuthor());
		Log.i("yanglijun", "picUri" + joke.getPicUrl());

		// 分享设置监听。

		holder.ivShare.setOnClickListener(new ShareOnClivk());

		/**
		 * 显示的图片的各种格式DisplayImageOptions 的设置：
		 */

		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.cacheInMemory(true).cacheOnDisc(true).build();

		final String picUrl = joke.getPicUrl();// url

		if (picUrl != null) {

			ImageLoader.getInstance().displayImage(picUrl, holder.ivPic,
					options);

		}
		
		holder.ivPic.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent=new Intent(context, JokePicShowActivity.class);
				intent.putExtra("picurl",picUrl);
				context.startActivity(intent);
				
			}
		});
		return convertView;
	}

	@Override
	public Joke getItem(int position) {
		return jokes.get(position);
	}

	@Override
	public long getItemId(int position) {
		return this.position=position;
	}

	class ViewHolder {
		TextView tvauthor;
		TextView tvContent;
		ImageView ivPic;
		ImageView ivShare;
	}

	class ShareOnClivk implements OnClickListener {

		@Override
		public void onClick(View v) {
			shareText(getItem(position).getContent());

		}

	}

	// 分享设置
	public void shareText(String string) {
		Intent intent = new Intent(Intent.ACTION_SEND);
		intent.setType("text/plain");
		intent.putExtra(Intent.EXTRA_TEXT, string);
		context.startActivity(Intent.createChooser(intent, "分享到"));

	}

}
