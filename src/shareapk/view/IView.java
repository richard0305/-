package shareapk.view;

import java.util.List;

import shareapk.entity.AppInfo;

public interface IView {
	public void setData(List<AppInfo> data);
	public void showData();
}
