package com.dlh.open.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import android.view.View;
import android.widget.TextView;

/**
 * @des: FullViewHolder
 * @time: 2019/11/11
 * @author: YJ
 */
public class FullViewHolder {

    private SparseArray<View> sparseArrayView;
    private View mConvertView;
    private Context context;

    public FullViewHolder(Context context, View view) {
        this.context = context;
        this.mConvertView = view;
        sparseArrayView = new SparseArray<>();
    }

    @NonNull
    public <T extends View> T getView(int viewId) {
        View view = sparseArrayView.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            sparseArrayView.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 设置TextView的值
     *
     * @param viewId
     * @param text
     * @return
     */
    @NonNull
    public FullViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }
}
