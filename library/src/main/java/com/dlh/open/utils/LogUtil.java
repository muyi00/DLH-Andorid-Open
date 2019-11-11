package com.dlh.open.utils;

import android.util.Log;

/**
 * @des: 日志工具
 * @time: 2019/11/11
 * @author: YJ
 */
public class LogUtil {

    public static boolean isDebug = false;

    public static void v(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        Log.w(tag, msg);
    }

    public static void w(String tag, String msg, Throwable e) {
        if (!isDebug) {
            return;
        }
        Log.w(tag, msg, e);
    }

    public static void e(String tag, String msg) {
        if (!isDebug) {
            return;
        }
        Log.e(tag, msg);
    }

    public static void e(String tag, String msg, Throwable e) {
        if (!isDebug) {
            return;
        }
        Log.e(tag, msg, e);
    }

}
