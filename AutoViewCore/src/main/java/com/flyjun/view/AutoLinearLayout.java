package com.flyjun.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import com.flyjun.autoview.util.ViewHelper;

/**
 * Created by Flyjun on 2017/4/18.
 */

public class AutoLinearLayout extends LinearLayout {
    private ViewHelper viewHelper;

    public AutoLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewHelper=ViewHelper.newInstance(context,attrs,this);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        // TODO Auto-generated method stub
        viewHelper.setViewAttr(viewHelper,attrs);
        return super.generateLayoutParams(attrs);
    }

    @Override
    protected void onFinishInflate() {
        // TODO Auto-generated method stub
        super.onFinishInflate();
        int count=getChildCount();
        for (int i = 0;i<count; i++)
        {
            View view = getChildAt(i);
            viewHelper.setViews(view, viewHelper.viewAttrsList.get(i));
        }

    }
}
