package com.dlh.open.retrofit.interceptor;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;


import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @des: Cookies保存的拦截器
 * @time: 2019/11/11 14:40
 * @author: YJ
 */
public class CookiesSaveInterceptor implements Interceptor {
    private static final String TAG = "Cookies";

    private static final String COOKIE_PREF = "cookies_prefs";
    private Context mContext;

    public CookiesSaveInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        //set-cookie可能为多个
        if (!response.headers("set-cookie").isEmpty()) {
            List<String> cookies = response.headers("set-cookie");
            String cookie = encodeCookie(cookies);
            Log.d(TAG, "SaveCookies:" + cookie);
            saveCookie(request.url().toString(), request.url().host(), cookie);
        }

        return response;
    }

    /**
     * 整合cookie为唯一字符串
     *
     * @param cookies
     * @return
     */
    private String encodeCookie(List<String> cookies) {
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (String cookie : cookies) {
            String[] arr = cookie.split(";");
            for (String s : arr) {
                if (set.contains(s)) {
                    continue;
                }
                set.add(s);

            }
        }

        Iterator<String> ite = set.iterator();
        while (ite.hasNext()) {
            String cookie = ite.next();
            sb.append(cookie).append(";");
        }

        int last = sb.lastIndexOf(";");
        if (sb.length() - 1 == last) {
            sb.deleteCharAt(last);
        }

        return sb.toString();
    }


    /***
     *  保存cookie到本地，这里我们分别为该url和host设置相同的cookie，其中host可选
     *  这样能使得该cookie的应用范围更广
     * @param url
     * @param domain
     * @param cookies
     */
    private void saveCookie(String url, String domain, String cookies) {
        SharedPreferences sp = mContext.getSharedPreferences(COOKIE_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        if (TextUtils.isEmpty(url)) {
            throw new NullPointerException("url is null.");
        } else {
            editor.putString(url, cookies);
        }

        if (!TextUtils.isEmpty(domain)) {
            editor.putString(domain, cookies);
        }

        editor.apply();

    }
}