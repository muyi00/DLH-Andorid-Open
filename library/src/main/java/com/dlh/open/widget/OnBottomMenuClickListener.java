package com.dlh.open.widget;

import android.view.View;

/**
 * @des: 仿苹果底部弹出菜单项点击事件
 * @time: 2019/11/7 13:34
 * @author: YJ
 */
public abstract class OnBottomMenuClickListener implements View.OnClickListener {

    private boolean isManualClose = false;

    public OnBottomMenuClickListener() {

    }

    public OnBottomMenuClickListener(boolean isManualClose) {
        this.isManualClose = isManualClose;
    }

    public boolean isManualClose() {
        return isManualClose;
    }
}
