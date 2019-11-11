package com.dlh.open.retrofit;

import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * @des: 服务器时间工具类
 * @time: 2019/11/11
 * @author: YJ
 */
public class ServerTimeUtils {
    /**
     * 服务器时间和客户端时间的差值
     */
    private static long deltaBetweenServerAndClientTime;

    /**
     * 获取服务器时间
     */
    public static Date getServerTime() {
        return new Date(System.currentTimeMillis() + deltaBetweenServerAndClientTime);
    }

    /**
     * 更新服务器时间和本地时间的差值
     */
    public static void updateDeltaBetweenServerAndClientTime(@Nullable String strServerDate) {
        try {
            if ((strServerDate != null) && !strServerDate.equals("")) {
                final SimpleDateFormat sdf = new SimpleDateFormat(
                        "EEE, d MMM yyyy HH:mm:ss z", Locale.ENGLISH);
                TimeZone.setDefault(TimeZone.getTimeZone("GMT+8"));
                Date serverDateUAT = sdf.parse(strServerDate);
                //服务器时间与本地时间差值，毫秒
                deltaBetweenServerAndClientTime = serverDateUAT.getTime() + 8 * 60 * 60 * 1000 - System.currentTimeMillis();
            }
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
    }
}
