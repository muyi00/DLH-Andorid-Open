package com.dlh.open.retrofit;


import android.support.annotation.NonNull;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @des: 接口返回的数据格式，当前限定取值：{@link #jsonObject}或{@link #text}
 * @author: YJ
 * @time: 2019/11/11 14:22
 */
@Target(METHOD)
@Retention(RUNTIME)
public @interface ResponseFormat {

    /***
     *响应格式: Json Object 对象
     */
    String jsonObject = "JsonObject";

    /***
     *响应格式: 文本字符串
     */
    String text = "Text";

    @NonNull String value() default "";
}
