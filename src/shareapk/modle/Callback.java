package shareapk.modle;

import java.util.List;

import shareapk.entity.AppInfo;

public interface Callback {
	public void onDataLoaded(List<AppInfo> data);
}
