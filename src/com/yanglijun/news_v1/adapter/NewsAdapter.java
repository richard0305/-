package com.yanglijun.news_v1.adapter;

import java.util.List;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.entity.News;
import com.yanglijun.news_v1.util.TimeUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {
	private Context context;
	private List<News> news;
	private LayoutInflater inflater;

	public NewsAdapter(Context context, List<News> news) {
		super();
		this.context = context;
		this.news = news;
		this.inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return news.size();
	}

	@Override
	public News getItem(int position) {

		return news.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.news_item_show, null);
			holder = new ViewHolder();
			holder.tvBehot_time = (TextView) convertView.findViewById(R.id.tv_news_time);
			holder.tvBury_count = (TextView) convertView.findViewById(R.id.tv_show_tag);
			holder.tvDigg_count = (TextView) convertView.findViewById(R.id.tv_show_tag);
			holder.tvRepin_count = (TextView) convertView.findViewById(R.id.tv_show_tag);

			holder.tvSource = (TextView) convertView.findViewById(R.id.tv_news_source);
			holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_news_title);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		News neww = getItem(position);

		holder.tvTitle.setText(neww.getTitle());
		holder.tvSource.setText(neww.getSource());
		long time = neww.getBehot_time();
		holder.tvBehot_time.setText(TimeUtils.TimeFormat(time));
		holder.tvBury_count
				.setText("‘ﬁ" + neww.getDigg_count() + " | ≤»" + neww.getBury_count() + " |  ’≤ÿ" + neww.getRepin_count());

		return convertView;
	}

	class ViewHolder {
		TextView tvTitle;
		TextView tvSource;
		TextView tvArticle_url;
		TextView tvBehot_time;
		TextView tvDigg_count;
		TextView tvBury_count;
		TextView tvRepin_count;
	}

}
