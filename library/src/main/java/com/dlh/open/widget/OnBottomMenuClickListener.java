package com.dlh.open.widget;

import android.view.View;

/**
 * @des: 仿苹果底部弹出菜单项点击事件
 * @time: 2019/11/7 13:34
 * @author: YJ
 */
public abstract class OnBottomMenuClickListener implements View.OnClickListener {

    private boolean isManualClose = false;

    /***
     * 菜单点击回调
     */
    public OnBottomMenuClickListener() {

    }

    /***
     * 菜单点击回调
     * @param isManualClose 点击后是否手动关闭
     */
    public OnBottomMenuClickListener(boolean isManualClose) {
        this.isManualClose = isManualClose;
    }

    public boolean isManualClose() {
        return isManualClose;
    }
}
