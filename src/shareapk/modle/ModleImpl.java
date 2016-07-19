package shareapk.modle;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.yanglijun.news_v1.app.ReadApplication;

import android.annotation.SuppressLint;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import shareapk.entity.AppInfo;

public class ModleImpl implements IModle {

	@SuppressLint("NewApi")
	@Override
	public void findAllApk(final Callback callback) {
		AsyncTask<String, String, List<AppInfo>> task = new AsyncTask<String, String, List<AppInfo>>() {

			@Override
			protected List<AppInfo> doInBackground(String... params) {
				List<AppInfo> data = new ArrayList<AppInfo>();
				PackageManager packageManager = ReadApplication.getreadApplication()
						.getPackageManager();
				List<PackageInfo> pInfos = packageManager
						.getInstalledPackages(0);
				for (int i = 0; i < pInfos.size(); i++) {
					AppInfo appInfo = new AppInfo();
					PackageInfo packageInfo = pInfos.get(i);

					appInfo.setName(getAppName(packageInfo.packageName,
							packageManager));
					appInfo.setTime("毫秒值：" + packageInfo.lastUpdateTime);
					appInfo.setImage(packageInfo.applicationInfo
							.loadIcon(packageManager));

					File apkFile = new File(
							packageInfo.applicationInfo.sourceDir);
					appInfo.setFile(apkFile);

					appInfo.setSize(((float) apkFile.length() / 1024 / 1024)
							+ "MB");

					//如果非系统应用，则添加至data
					if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM)==0) {
						data.add(appInfo);
					}
				}
				return data;
			}

			@Override
			protected void onPostExecute(List<AppInfo> result) {
				callback.onDataLoaded(result);
			}

		};
		task.execute();
	}

	/**
	 * 根据包名，获取应用名
	 * 
	 * @param packageName
	 * @param packageManager
	 * @return
	 */
	protected String getAppName(String packageName,
			PackageManager packageManager) {

		String appName = "";

		try {
			ApplicationInfo applicationInfo = packageManager
					.getApplicationInfo(packageName, 0);

			appName = (String) packageManager
					.getApplicationLabel(applicationInfo);

		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}

		return appName;
	}

}
