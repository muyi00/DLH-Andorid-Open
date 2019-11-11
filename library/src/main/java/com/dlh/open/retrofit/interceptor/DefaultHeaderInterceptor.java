package com.dlh.open.retrofit.interceptor;

import com.dlh.open.retrofit.ServerTimeUtils;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @des: 默认请求头的拦截器
 * @author: YJ
 * @time: 2019/11/11 14:35
 */
public class DefaultHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder requestBuilder = chain.request().newBuilder();
        requestBuilder.addHeader("Content-Type", "application/json;charset=UTF-8");
        requestBuilder.addHeader("Connection", "close");
        Request request = requestBuilder.build();
        Response response = chain.proceed(request);
        ServerTimeUtils.updateDeltaBetweenServerAndClientTime(response.header("Date"));
        return response;
    }
}
