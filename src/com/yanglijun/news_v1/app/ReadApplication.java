package com.yanglijun.news_v1.app;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import android.app.Application;

/**
 * Created by yanglijun 2016-6-25下午4:13:46
 */
public class ReadApplication extends Application {
	private static ReadApplication context;
	private static RequestQueue Queue;
	private static ReadApplication readApplication;

	public static ReadApplication getContext() {
		return context;
	}

	public static RequestQueue getQueue() {
		return Queue;
	}

	public ReadApplication() {
		super();

	}

	public static ReadApplication getreadApplication() {
		return readApplication;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		readApplication = this;

		context = this;
		Queue = Volley.newRequestQueue(context);

		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(this)
				// .memoryCacheExtraOptions(480, 800)
				.threadPoolSize(3).threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory()
				.memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)).memoryCacheSize(2 * 1024 * 1024)
				.discCacheSize(50 * 1024 * 1024).discCacheFileNameGenerator(new Md5FileNameGenerator())
				.tasksProcessingOrder(QueueProcessingType.LIFO).discCacheFileCount(100)
				// 缓存的文件数量
				// 自定义缓存路径
				.defaultDisplayImageOptions(DisplayImageOptions.createSimple())
				.imageDownloader(new BaseImageDownloader(this, 5 * 1000, 30 * 1000)).build();
		ImageLoader.getInstance().init(config);
	}
}
