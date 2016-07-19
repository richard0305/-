package shareapk.presenter;

import java.util.List;

import shareapk.entity.AppInfo;
import shareapk.modle.Callback;
import shareapk.modle.IModle;
import shareapk.modle.ModleImpl;
import shareapk.view.IView;

public class PresenterImpl implements IPresenter{
	private IModle modle;
	private IView view;
	
	public PresenterImpl(IView view) {
		this.view = view;
		modle = new ModleImpl();
	}


	@Override
	public void getData() {
		modle.findAllApk(new Callback() {
			
			@Override
			public void onDataLoaded(List<AppInfo> data) {
				view.setData(data);
				view.showData();
			}
		});
	}

}
