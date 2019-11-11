package com.dlh.open.retrofit.converter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * FastJsonRequestBodyConverter
 *
 * @author: YJ
 * @date: 2019/2/22
 */
public class FastJsonRequestBodyConverter<T> implements Converter<T, RequestBody> {
    @Nullable
    private static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=UTF-8");

    @NonNull
    @Override
    public RequestBody convert(T value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, JSON.toJSONBytes(value));
    }
}
