package com.dlh.open.adapter;

import java.util.List;

/**
 * @des: 完整列表视图的适配器
 * @time: 2019/11/11 
 * @author: YJ
 */
public abstract class FullListViewAdapter<T> {

    private int mItemLayoutId;
    private List<T> mDatas;

    public FullListViewAdapter(List<T> mDatas, int mItemLayoutId) {
        this.mItemLayoutId = mItemLayoutId;
        this.mDatas = mDatas;
    }

    public int getItemLayoutId() {
        return mItemLayoutId;
    }

    public void setItemLayoutId(int mItemLayoutId) {
        this.mItemLayoutId = mItemLayoutId;
    }

    public List<T> getDatas() {
        return mDatas;
    }

    public void setDatas(List<T> mDatas) {
        this.mDatas = mDatas;
    }

    public void onBind(FullViewHolder holder, int i) {
        onBind(holder, mDatas.get(i), i);
    }

    public abstract void onBind(FullViewHolder holder, T t, int pos);

}
