package com.dlh.open.retrofit.converter;

import android.support.annotation.NonNull;

import com.dlh.open.retrofit.ResponseFormat;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import io.reactivex.annotations.Nullable;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * JSON 或者字符串解析器
 * https://blog.csdn.net/China_Style/article/details/82084504
 *
 * @author: YJ
 * @date: 2019/2/22
 */
public class JsonOrStringConverterFactory extends Converter.Factory {

    private final Converter.Factory jsonFactory = FastJsonConverterFactory.create();
    private final Converter.Factory stringFactory = StringConverterFactory.create();

    public static JsonOrStringConverterFactory create() {
        return new JsonOrStringConverterFactory();
    }

    @Nullable
    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, @NonNull Annotation[] annotations, Retrofit retrofit) {
        for (Annotation annotation : annotations) {
            if (!(annotation instanceof ResponseFormat)) {
                continue;
            }
            String value = ((ResponseFormat) annotation).value();
            if (ResponseFormat.jsonObject.equals(value)) {
                return jsonFactory.responseBodyConverter(type, annotations, retrofit);
            } else if (ResponseFormat.text.equals(value)) {
                return stringFactory.responseBodyConverter(type, annotations, retrofit);
            }
        }

        return null;
    }
}
