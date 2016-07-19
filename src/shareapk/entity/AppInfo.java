package shareapk.entity;

import java.io.File;

import android.graphics.drawable.Drawable;

public class AppInfo {
	private String name;
	private String time;
	private String size;
	private Drawable image;
	private File file;
	
	public AppInfo() {
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public Drawable getImage() {
		return image;
	}
	public void setImage(Drawable image) {
		this.image = image;
	}
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "AppInfo [name=" + name + ", time=" + time + ", size=" + size
				+ ", image=" + image + ", file=" + file + "]";
	}
	
	
	
	
}
