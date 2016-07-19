package shareapk.adapter;

import java.util.List;

import com.yanglijun.news_v1.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import shareapk.entity.AppInfo;

public class MyAdapter extends BaseAdapter {
	private List<AppInfo> data;
	private LayoutInflater inflater;
	
	public MyAdapter(Context context, List<AppInfo> data) {
		super();
		this.data = data;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public AppInfo getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.share_apk_item, null);
			holder = new ViewHolder();
			holder.image=(ImageView) convertView.findViewById(R.id.imageview);
			holder.title=(TextView) convertView.findViewById(R.id.title);
			holder.size=(TextView) convertView.findViewById(R.id.size);
			holder.time=(TextView) convertView.findViewById(R.id.time);
			convertView.setTag(holder);
		}
		
		holder = (ViewHolder) convertView.getTag();
		
		AppInfo app = getItem(position);
		
		holder.image.setImageDrawable(app.getImage());
		holder.title.setText(app.getName());
		holder.size.setText(app.getSize());
		holder.time.setText(app.getTime());
		
		return convertView;
	}
	
	class ViewHolder{
		ImageView image;
		TextView title;
		TextView time;
		TextView size;
	}

}
