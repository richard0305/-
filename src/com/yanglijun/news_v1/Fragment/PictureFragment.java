package com.yanglijun.news_v1.Fragment;

import java.io.Serializable;
import java.util.List;

import com.yanglijun.news_v1.R;
import com.yanglijun.news_v1.activity.PictureListActivity;
import com.yanglijun.news_v1.adapter.RecyclerViewAdapter;
import com.yanglijun.news_v1.adapter.RecyclerViewAdapter.RecyclerViewOnItemClickListener;
import com.yanglijun.news_v1.entity.Picture;
import com.yanglijun.news_v1.model.IModel.AsycnCallBack;
import com.yanglijun.news_v1.model.PictureModel;
import com.yanglijun.news_v1.presenter.IPicturePresenter;
import com.yanglijun.news_v1.presenter.PicturePresenter;
import com.yanglijun.news_v1.view.IPictureView;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class PictureFragment extends Fragment implements IPictureView,Serializable{
	private RecyclerView recyclerview;
//	private SwipeRefreshLayout swipe;
	private List<Picture>pictures;
	private IPicturePresenter presenter;
	private RecyclerViewAdapter adapter;
	private PictureModel model=new PictureModel();
	private SpacesItemDecoration decoration = null;
	private int page=1;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.booksfragment, null);
//		swipe=(SwipeRefreshLayout) view.findViewById(R.id.swipe);
		recyclerview=(RecyclerView) view.findViewById(R.id.recyclerview);
		presenter=new PicturePresenter(this);
		presenter.LoadPicture(page);
		
		// ����item֮��ļ��
		decoration = new SpacesItemDecoration(5);
		recyclerview.addItemDecoration(decoration);
		recyclerview.setItemAnimator(new DefaultItemAnimator());
		setListener();
		
		return view;
	}
	
		
		

	private void setListener() {
//		swipe.setOnRefreshListener(new OnRefreshListener() {
//			
//			@Override
//			public void onRefresh() {
//				presenter.LoadPicture(page++);
//				
//			}
//		});
		
	}




	@SuppressWarnings("deprecation")
	@Override
	public void showData(final List<Picture> pictures) {
		this.pictures=pictures;
		adapter=new RecyclerViewAdapter(pictures, getActivity());
		recyclerview.setAdapter(adapter);
		
		final StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
		recyclerview.setLayoutManager(manager);
		
		adapter.setRecyclerViewOnItemClickListener(new RecyclerViewOnItemClickListener() {
			
			@Override
			public void onItemLongClick(View view, int position) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onItemClick(View view, int position) {
				Picture picture=pictures.get(position);
				String url=picture.getUrl();
				
				Intent intent=new Intent(getActivity(),PictureListActivity.class);
				intent.putExtra("pictures", (Serializable)pictures); 
				startActivity(intent);
				
				
			}
		});
		
		/**
		 * ����ˢ��
		 */
		recyclerview.setOnScrollListener(new RecyclerView.OnScrollListener(){
		    //��������Ƿ����������һ�����������Ƿ����»���
		    boolean isSlidingToLast = false;
		 
		    @Override
		    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//		        StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
		        // ��������ʱ
		        if (newState == RecyclerView.SCROLL_STATE_IDLE) {
		            //��ȡ���һ����ȫ��ʾ��ItemPosition
		            int[] lastVisiblePositions = manager.findLastVisibleItemPositions(new int[manager.getSpanCount()]);
		            int lastVisiblePos = getMaxElem(lastVisiblePositions);
		            int totalItemCount = manager.getItemCount();
		 
		            // �ж��Ƿ�������ײ�
		            if (lastVisiblePos == (totalItemCount -1) && isSlidingToLast) {
		                //���ظ��๦�ܵĴ���
//		            	presenter.LoadPicture(page++);
		            	page++;
		            	model.LoadPicture(page, new AsycnCallBack() {
							
							@Override
							public void onSuccess(Object success) {
								List<Picture>pics=(List<Picture>) success;
								 if (pics.isEmpty()) {// û������
									 Toast.makeText(getActivity(), "�Ѿ�������",Toast.LENGTH_SHORT).show();
									 return;
									 }
								pictures.addAll(pics);
								 adapter.notifyDataSetChanged();
								
							}
							
							@Override
							public void onError(Object error) {
								
							}
						});
		            	
		            }
		        }
		    }
		 
		    @Override
		    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
		        super.onScrolled(recyclerView, dx, dy);
		        //dx�����жϺ��򻬶�����dy�����ж����򻬶�����
		        if(dy > 0){
		            //����0��ʾ���������¹���
		            isSlidingToLast = true;
		        }else{
		            //С�ڵ���0 ��ʾֹͣ�����Ϲ���
		            isSlidingToLast = false;
		        }
		 
		    }
		});
	}

	private int getMaxElem(int[] arr) {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            if (arr[i]>maxVal)
                maxVal = arr[i];
        }
        return maxVal;
}
	
	

	public class SpacesItemDecoration extends RecyclerView.ItemDecoration {

		private int space;

		public SpacesItemDecoration(int space) {
			this.space = space;
		}
		
		// �Զ�����һ��SpacesItemDecoration
		@Override
		public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
			outRect.left = space;
			outRect.right = space;
			outRect.bottom = space;
			if (parent.getChildAdapterPosition(view) == 0) {
				outRect.top = space;
			}
		}
	}
	
	
	
	
}
