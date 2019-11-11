package com.dlh.open.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * @des: 展开的ListView，解决ScrollView内嵌套ListView显示不全的问题
 * @time: 2019/11/11 
 * @author: YJ
 */
public class UnfoldedListView extends ListView {

	public UnfoldedListView(Context context) {
		super(context);
	}

	public UnfoldedListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UnfoldedListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	/**
	 * 重写该方法，达到使ListView适应ScrollView的效果
	 */
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}
}