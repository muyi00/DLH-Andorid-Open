package com.dlh.open.widget;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;


import com.dlh.open.adapter.FullListViewAdapter;
import com.dlh.open.adapter.FullViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * @des: 完整的列表视图，LinearLayout内动态添加项
 * @time: 2019/11/11
 * @author: YJ
 */
public class FullListView extends LinearLayout {

    private LayoutInflater mInflater;
    private List<FullViewHolder> mVHCahces;
    private FullListViewAdapter mAdapter;

    public FullListView(Context context) {
        this(context, null);
    }

    public FullListView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FullListView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mInflater = LayoutInflater.from(context);
        mVHCahces = new ArrayList<>();
    }

    public void setAdapter(FullListViewAdapter mAdapter) {
        this.mAdapter = mAdapter;
        updateUI();
    }

    /***
     * 更新UI
     */
    public void updateUI() {
        if (mAdapter != null) {
            if (mAdapter.getDatas() != null && !mAdapter.getDatas().isEmpty()) {
                if (mAdapter.getDatas().size() > getChildCount()) {
                    //数据源大于现有子View不清空
                } else if (mAdapter.getDatas().size() < getChildCount()) {
                    //数据源小于现有子View，删除后面多的
                    removeViews(mAdapter.getDatas().size(), getChildCount() - mAdapter.getDatas().size());
                    while (mVHCahces.size() > mAdapter.getDatas().size()) {
                        mVHCahces.remove(mVHCahces.size() - 1);
                    }
                }
                for (int i = 0; i < mAdapter.getDatas().size(); i++) {
                    FullViewHolder holder;
                    if (mVHCahces.size() - 1 >= i) {
                        //说明有缓存，不用inflate，否则inflate
                        holder = mVHCahces.get(i);
                    } else {
                        holder = new FullViewHolder(getContext(), mInflater.inflate(mAdapter.getItemLayoutId(), this, false));
                        //inflate 出来后 add进来缓存
                        mVHCahces.add(holder);
                    }
                    mAdapter.onBind(holder, i);

                    if (holder.getConvertView().getParent() == null) {
                        //如果View没有父控件 添加
                        this.addView(holder.getConvertView());
                    }
                }
            } else {
                removeAllViews();//数据源没数据 清空视图
            }
        } else {
            removeAllViews();//适配器为空 清空视图
        }
    }

}
