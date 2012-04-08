package com.yeeamte.robotbird;

public class Log {
	public static final String TAG = "TwitterRobot";
	public static final boolean DEBUG = true;

	public static void d(String msg) {
		if (DEBUG)
			android.util.Log.d(TAG, msg);
	}
}
