package com.dlh.open.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ViewHolder {

    @NonNull
    private final SparseArray<View> mViews;
    private int mPosition;
    private final View mConvertView;
    private final Context context;

    private ViewHolder(Context context, ViewGroup parent, int layoutId,
                       int position) {
        this.context = context;
        this.mPosition = position;
        this.mViews = new SparseArray<>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    /**
     * 得到一个ViewHolder对象
     *
     * @param context
     * @param convertView
     * @param parent
     * @param layoutId
     * @param position
     * @return
     */
    @NonNull
    public static ViewHolder get(Context context, @Nullable View convertView,
                                 ViewGroup parent, int layoutId, int position) {
        if (convertView == null) {
            return new ViewHolder(context, parent, layoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) convertView.getTag();
            holder.mPosition = position;
            return holder;
        }
    }

    public View getConvertView() {
        return mConvertView;
    }

    /**
     * 通过控件的Id获取对于的控件，如果没有则加入views
     *
     * @param viewId
     * @return
     */
    @NonNull
    @SuppressWarnings("unchecked")
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public int getPosition() {
        return mPosition;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    @NonNull
    public ViewHolder setText(int viewId, String text) {
        TextView view = getView(viewId);
        if (TextUtils.isEmpty(text)) {
            view.setText("");
        } else {
            view.setText(text);
        }

        return this;
    }

    /**
     * 为TextView设置字符串
     *
     * @param viewId
     * @param text
     * @return
     */
    @NonNull
    public ViewHolder setText(int viewId, CharSequence text) {
        TextView view = getView(viewId);
        if (TextUtils.isEmpty(text)) {
            view.setText("");
        } else {
            view.setText(text);
        }
        return this;
    }

    /**
     * 为TextView设置字符串和字符串颜色
     *
     * @param viewId
     * @param text
     * @param colorId
     * @return
     */
    @NonNull
    public ViewHolder setText(int viewId, String text, int colorId) {
        TextView view = getView(viewId);
        if (TextUtils.isEmpty(text)) {
            view.setText("");
        } else {
            view.setText(text);
        }
        view.setTextColor(context.getResources().getColor(colorId));
        return this;
    }

    /**
     * 设置文字颜色
     *
     * @param viewId
     * @param colors
     * @return
     */
    @NonNull
    public ViewHolder setTextColor(int viewId, ColorStateList colors) {
        TextView view = getView(viewId);
        view.setTextColor(colors);
        return this;
    }

    /**
     * 设置文字颜色
     *
     * @param viewId
     * @param
     * @return
     */
    @NonNull
    public ViewHolder setTextColor(int viewId, int colors) {
        TextView view = getView(viewId);
        view.setTextColor(context.getResources().getColor(colors));
        return this;
    }

    /**
     * 设置背景颜色
     *
     * @param viewId
     * @param colors
     * @return
     */
    @NonNull
    public ViewHolder setbackground(int viewId, int colors) {
        View view = getView(viewId);
        view.setBackgroundColor(colors);
        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @param drawableId
     * @return
     */
    @NonNull
    public ViewHolder setImageResource(int viewId, int drawableId) {
        ImageView view = getView(viewId);
        view.setImageResource(drawableId);

        return this;
    }

    /**
     * 为ImageView设置图片
     *
     * @param viewId
     * @return
     */
    @NonNull
    public ViewHolder setImageBitmap(int viewId, Bitmap bm) {
        ImageView view = getView(viewId);
        view.setImageBitmap(bm);
        return this;
    }

    /**
     * 设置 CheckBox 选择状态
     *
     * @param viewId
     * @param bl
     * @return
     */
    @NonNull
    public ViewHolder setChecked(int viewId, boolean bl) {
        CheckBox view = getView(viewId);
        view.setChecked(bl);
        return this;
    }

    /**
     * 设置View是否可见
     *
     * @param viewId
     * @param visibility
     * @return
     */
    @NonNull
    public ViewHolder setVisibility(int viewId, int visibility) {
        View view = getView(viewId);
        view.setVisibility(visibility);
        return this;
    }

    /**
     * 设置进度条当前进度
     *
     * @param viewId
     * @param progress
     * @return
     */
    @NonNull
    public ViewHolder setProgressBarProgress(int viewId, int progress) {
        ProgressBar pb = getView(viewId);
        pb.setProgress(progress);
        return this;
    }


    /***
     * 设置可隐藏信息
     * @param viewLlId 大项 LinearLayout id
     * @param viewId 显示 内容
     * @param text 字符串内容
     * @return
     */
    @NonNull
    public ViewHolder setBeHiddenInfo(int viewLlId, int viewId, String text) {
        LinearLayout ll = getView(viewLlId);
        if (TextUtils.isEmpty(text)) {
            ll.setVisibility(View.GONE);
            setText(viewId, "");
        } else {
            ll.setVisibility(View.VISIBLE);
            setText(viewId, text);
        }
        return this;
    }

    /***
     * 设置可隐藏信息
     * @param viewLlId 大项 LinearLayout id
     * @param viewId 显示 内容
     * @param number 数字串内容
     * @return
     */
    @NonNull
    public ViewHolder setBeHiddenInfo(int viewLlId, int viewId, int number) {
        LinearLayout ll = getView(viewLlId);
        if (number <= 0) {
            ll.setVisibility(View.GONE);
            setText(viewId, "0");
        } else {
            ll.setVisibility(View.VISIBLE);
            setText(viewId, String.valueOf(number));
        }
        return this;
    }

}
