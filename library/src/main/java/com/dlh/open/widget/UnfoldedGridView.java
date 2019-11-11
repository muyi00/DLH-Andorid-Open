package com.dlh.open.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * @des: 展开的GridView，解决ScrollView内嵌套GridVie显示不全的问题
 * @time: 2019/11/11
 * @author: YJ
 */
public class UnfoldedGridView extends GridView {
	public UnfoldedGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UnfoldedGridView(Context context) {
		super(context);
	}

	public UnfoldedGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
