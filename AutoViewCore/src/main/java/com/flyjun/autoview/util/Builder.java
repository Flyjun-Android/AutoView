package com.flyjun.autoview.util;

import android.view.View;

/**
 * Created by Flyjun on 2017/4/18.
 */

public class Builder{

    private View view;
    private ViewAttributeSet viewAttrs;

    public Builder(View view) {
        // TODO Auto-generated constructor stub
        this.viewAttrs=new ViewAttributeSet();
        this.view=view;
    }
    public Builder setWidth(float width) {
        this.viewAttrs.setWidth(width);
        return this;
    }
    public Builder setHeight(float height) {
        this.viewAttrs.setHeight(height);
        return this;
    }
    public Builder setTextSize(float textSize) {
        this.viewAttrs.setTextSize(textSize);
        return this;
    }
    public Builder setMargin(float margin) {
        this.viewAttrs.setMargin(margin);
        return this;
    }
    public Builder setMarginLeft(float marginLeft) {
        this.viewAttrs.setMarginLeft(marginLeft);
        return this;
    }
    public Builder setMarginRight(float marginRight) {
        this.viewAttrs.setMarginRight(marginRight);
        return this;
    }
    public Builder setMarginTop(float marginTop) {
        this.viewAttrs.setMarginTop(marginTop);
        return this;
    }
    public Builder setMarginBottom(float marginBottom) {
        this.viewAttrs.setMarginBottom(marginBottom);
        return this;
    }
    public Builder setPadding(float padding) {
        this.viewAttrs.setPadding(padding);
        return this;
    }
    public Builder setPaddingLeft(float paddingLeft) {
        this.viewAttrs.setPaddingLeft(paddingLeft);
        return this;
    }
    public Builder setPaddingRight(float paddingRight) {
        this.viewAttrs.setPaddingRight(paddingRight);
        return this;
    }
    public Builder setPaddingTop(float paddingTop) {
        this.viewAttrs.setPaddingTop(paddingTop);
        return this;
    }
    public Builder setPaddingBottom(float paddingBottom) {
        this.viewAttrs.setPaddingBottom(paddingBottom);
        return this;
    }
    public Builder setDrawablePadding(float drawablePadding) {
        this.viewAttrs.setDrawablePadding(drawablePadding);
        return this;
    }

    public void builder(){
        ViewHelper viewHelper=new ViewHelper(view.getContext());
        viewHelper.setViews(view,viewAttrs);
    }
}
