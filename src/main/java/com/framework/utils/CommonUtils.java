package com.framework.utils;

public class CommonUtils {
	
	public static void waitForSeconds(int seconds) {
		try {
			Thread.sleep(seconds * 1000L);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}

}
