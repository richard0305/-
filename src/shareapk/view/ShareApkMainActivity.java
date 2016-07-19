package shareapk.view;

import java.io.File;
import java.util.List;

import com.yanglijun.news_v1.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import shareapk.adapter.MyAdapter;
import shareapk.entity.AppInfo;
import shareapk.presenter.IPresenter;
import shareapk.presenter.PresenterImpl;

public class ShareApkMainActivity extends Activity implements IView,OnItemClickListener{
	private ListView lv;
	private MyAdapter adapter;
	private List<AppInfo> data;
	private IPresenter presenter;
	private FrameLayout pbLayout;
	private ProgressBar progressBar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.share_apk_activity_main);
		
		lv = (ListView) findViewById(R.id.listview);
		
		showPregressBar();
		
		presenter = new PresenterImpl(this);
		presenter.getData();
		
		lv.setOnItemClickListener(this);
	}

	/**
	 * 数据显示之前，显示进度条
	 */
	private void showPregressBar() {
		pbLayout = (FrameLayout) findViewById(android.R.id.content);
		FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT,Gravity.CENTER);
		progressBar = new ProgressBar(this);
		progressBar.setLayoutParams(layoutParams);
		progressBar.setVisibility(View.VISIBLE);
		pbLayout.addView(progressBar);
	}
	

	@Override
	public void setData(List<AppInfo> data) {
		this.data = data;
	}

	@Override
	public void showData() {
		adapter = new MyAdapter(this, data);
		lv.setAdapter(adapter);
		//去除进度条
		dismissProgressBar();
	}

	/**
	 * 移除进度条
	 */
	private void dismissProgressBar() {
		if(progressBar!=null && pbLayout!=null){
			pbLayout.removeView(progressBar);
		}
	}

	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		
		//分享文件
		File apkFile = data.get(position).getFile();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(apkFile));
        startActivity(intent);
	}

}
