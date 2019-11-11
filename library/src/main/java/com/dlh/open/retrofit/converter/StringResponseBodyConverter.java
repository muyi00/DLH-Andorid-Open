package com.dlh.open.retrofit.converter;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * StringResponseBodyConverter
 *
 * @author: YJ
 * @date: 2019/2/22
 */
public class StringResponseBodyConverter implements Converter<ResponseBody, String> {
    @NonNull
    @Override
    public String convert(@NonNull ResponseBody value) throws IOException {
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(value.byteStream(), "UTF-8"));
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = r.readLine()) != null) {
                total.append(line);
            }
            return total.toString();
        } finally {
            value.close();
        }
    }
}
