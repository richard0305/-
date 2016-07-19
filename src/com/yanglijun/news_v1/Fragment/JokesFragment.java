package com.yanglijun.news_v1.Fragment;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import android.widget.Toast;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.adapter.JokesAdapter;
import com.yanglijun.news_v1.app.ReadApplication;
import com.yanglijun.news_v1.entity.Joke;
import com.yanglijun.news_v1.model.JokeModel;
import com.yanglijun.news_v1.model.JokeModel.Callback;

public class JokesFragment extends Fragment {
	private ListView lvJoke;
	private JokesAdapter jokesadapter;
	private List<Joke> jokes;
	JokeModel model = new JokeModel();
	private int page = 0;
	Handler handler=new Handler();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.jokesfragment, null);
		setViews(view);
		setListeners();
		model.findJokeList(new Callback() {

			@Override
			public void onJokeListLoaded(List<Joke> jokes) {
				JokesFragment.this.jokes = jokes;
				setAdapter(jokes);
			}
		}, page);

		Log.i("yanglijun", "xiaohua" + jokes);

		return view;
	}

	private void setListeners() {
		lvJoke.setOnScrollListener(new OnScrollListener() {
			private boolean isBottom=false;

			@Override
			public void onScrollStateChanged(AbsListView view, int scrollState) {
				switch (scrollState) {
				case SCROLL_STATE_FLING:

					break;
				case SCROLL_STATE_IDLE:
					if (isBottom) {
						Toast.makeText(getActivity(), "已经到头了！",
								Toast.LENGTH_SHORT).show();
						handler.postDelayed(new  Runnable() {
							public void run() {
								
								model.findJokeList(new Callback() {

									@Override
									public void onJokeListLoaded(List<Joke> js) {
										if (js.isEmpty()) {
											
											return;
										}
										jokes.addAll(js);
										jokesadapter.notifyDataSetChanged();
										
									}
								}, ++page);
							}
						}, 3000);
						
						Toast.makeText(getActivity(), "已经为你加载更多",
								Toast.LENGTH_SHORT).show();

					}
					break;
				case SCROLL_STATE_TOUCH_SCROLL:
					break;
				}

			}

			@Override
			public void onScroll(AbsListView view, int firstVisibleItem,
					int visibleItemCount, int totalItemCount) {

				if (firstVisibleItem + visibleItemCount == totalItemCount) {
					isBottom = true;
				} else {
					isBottom = false;
				}
			}
		});

	}

	protected void setAdapter(List<Joke> jokes) {
		jokesadapter = new JokesAdapter(jokes, getActivity());
		lvJoke.setAdapter(jokesadapter);
	}

	private void setViews(View view) {
		lvJoke = (ListView) view.findViewById(R.id.lv_joke);
	}
}
