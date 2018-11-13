package org.huangqsh.photo.utils;

public class PageThreadlocal {
	
	private static ThreadLocal<PageParam> pageThread = new ThreadLocal<>();
	
	public static void setThread(PageParam param) {
		pageThread.set(param);
	}
	
	public static PageParam getThread() {
		return pageThread.get();
	}
	
	public static void removeThread() {
		pageThread.remove();
	}
}
