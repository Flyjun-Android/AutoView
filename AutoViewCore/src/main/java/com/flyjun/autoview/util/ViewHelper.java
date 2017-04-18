package com.flyjun.autoview.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.flyjun.autoviewcore.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Flyjun on 2017/4/18.
 */

public class ViewHelper {

    private Context context;

    private int screenSize;
    private float designSize=1080.0f;


    private AttributeSet parentsAttrs;
    private View parentsView;


    public List<ViewAttributeSet> viewAttrsList;

    /**
     * 适配支持的属性
     */
    private static final int[] designAttrs = new int[] {

            android.R.attr.textSize,// 0

            android.R.attr.padding,// 1
            android.R.attr.paddingLeft,// 2
            android.R.attr.paddingTop,// 3
            android.R.attr.paddingRight,// 4
            android.R.attr.paddingBottom,// 5

            android.R.attr.layout_width,// 6
            android.R.attr.layout_height,// 7

            android.R.attr.layout_margin,// 8
            android.R.attr.layout_marginLeft,// 9
            android.R.attr.layout_marginTop,// 10
            android.R.attr.layout_marginRight,// 11
            android.R.attr.layout_marginBottom,// 12

            android.R.attr.drawablePadding //13

    };

    private static final String WRAP_CONTENT = "-2";
    private static final String MATCH_PARENT = "-1";

    private static final int TEXT_SIZE = 0;

    private static final int PADDING = 1;
    private static final int PADDING_LEFT = 2;
    private static final int PADDING_TOP = 3;
    private static final int PADDING_RIGHT = 4;
    private static final int PADDING_BOTTOM = 5;

    private static final int WIDTH = 6;
    private static final int HEIGHT = 7;

    private static final int MARGIN = 8;
    private static final int MARGIN_LEFT = 9;
    private static final int MARGIN_TOP = 10;
    private static final int MARGIN_RIGHT = 11;
    private static final int MARGIN_BOTTOM = 12;

    private static final int DRAWABLE_PADDING = 13;

    public static ViewHelper newInstance(Context context,AttributeSet parentAttrs,View parentsView){
        ViewHelper viewHelper=new ViewHelper(context,parentAttrs,parentsView);
        viewHelper.initAttrsList();
        if (parentAttrs != null && parentsView != null) {
            viewHelper.autoParentView(parentAttrs, parentsView);
        }
        return viewHelper;
    }

    public ViewHelper(Context context,AttributeSet parentAttrs,View parentsView) {
        this.context = context;
        this.parentsAttrs=parentAttrs;
        this.parentsView=parentsView;
        this.init();
    }

    public ViewHelper(Context context) {
        this.context = context;
        init();
    }

    private void init(){

        ViewConfig viewConfig= JSON.parseObject(new ViewConfigSP(context).getViewConfig(),ViewConfig.class);

        if (null == viewConfig){
            throw new AndroidRuntimeException("not AutoView init");
        }

        designSize=viewConfig.getDesignSize();
        screenSize=viewConfig.getScreenSize();


    }

    private void initAttrsList(){
        viewAttrsList=new ArrayList<ViewAttributeSet>();
    }

    /**
     * 设置view的参数
     * @param view
     * @param attrs
     */
    public void setViews(View view,ViewAttributeSet attrs){
        setAttrs(view,attrs);
    }

    /**
     * 获取view的AttributeSet
     * @param viewHelper
     * @param attrs
     */
    public void setViewAttr(ViewHelper viewHelper,AttributeSet attrs){
        if(null != attrs){
            viewHelper.getAttrs(attrs);
        }
    }

    private void autoParentView(AttributeSet attrs,View parentsView){

        TypedArray tArray=context.obtainStyledAttributes(attrs, R.styleable.viewAttrs);
        boolean autoParents=tArray.getBoolean(R.styleable.viewAttrs_autoParents,false);

        if(!autoParents){
            return;
        }

        TypedArray typedArray = context.obtainStyledAttributes(attrs, designAttrs);

        ViewAttributeSet viewAttrs=new ViewAttributeSet();

        for (int i = 0; i < typedArray.getIndexCount(); i++) {

            int index=typedArray.getIndex(i);

            /**
             * 判断是不是px为单位的值
             */
            if (!isPxVal(typedArray.peekValue(index))){
                continue;
            }

            switch (index) {

                case TEXT_SIZE:
                    viewAttrs.setTextSize(typedArray.getDimension(index, 0));
                    break;

                case PADDING:
                    viewAttrs.setPadding(typedArray.getDimension(index, 0));
                    break;

                case PADDING_TOP:
                    viewAttrs.setPaddingTop(typedArray.getDimension(index, 0));
                    break;

                case PADDING_RIGHT:
                    viewAttrs.setPaddingRight(typedArray.getDimension(index, 0));
                    break;

                case PADDING_LEFT:
                    viewAttrs.setPaddingLeft(typedArray.getDimension(index, 0));
                    break;

                case PADDING_BOTTOM:
                    viewAttrs.setPaddingBottom(typedArray.getDimension(index, 0));
                    break;

                case WIDTH:
                    viewAttrs.setWidth(typedArray.getDimension(index, 0));
                    break;

                case HEIGHT:
                    viewAttrs.setHeight(typedArray.getDimension(index, 0));
                    break;

                case MARGIN:
                    viewAttrs.setMargin(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_TOP:
                    viewAttrs.setMarginTop(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_RIGHT:
                    viewAttrs.setMarginRight(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_LEFT:
                    viewAttrs.setMarginLeft(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_BOTTOM:
                    viewAttrs.setMarginBottom(typedArray.getDimension(index, 0));
                    break;

                case DRAWABLE_PADDING:
                    viewAttrs.setDrawablePadding(typedArray.getDimension(index, 0));
                    break;
            }
        }

        typedArray.recycle();

        setAttrs(parentsView,viewAttrs);

    }

    /**
     * 获取AttributeSet的值
     * @param attrs
     */
    public void getAttrs(AttributeSet attrs){

        TypedArray typedArray = context.obtainStyledAttributes(attrs, designAttrs);

        ViewAttributeSet viewAttrs=new ViewAttributeSet();

        for (int i = 0; i < typedArray.getIndexCount(); i++) {

            int index=typedArray.getIndex(i);

            /**
             * 判断是不是px为单位的值
             */
            if (!isPxVal(typedArray.peekValue(index))){
                continue;
            }

            switch (index) {

                case TEXT_SIZE:
                    viewAttrs.setTextSize(typedArray.getDimension(index, 0));
                    break;

                case PADDING:
                    viewAttrs.setPadding(typedArray.getDimension(index, 0));
                    break;

                case PADDING_TOP:
                    viewAttrs.setPaddingTop(typedArray.getDimension(index, 0));
                    break;

                case PADDING_RIGHT:
                    viewAttrs.setPaddingRight(typedArray.getDimension(index, 0));
                    break;

                case PADDING_LEFT:
                    viewAttrs.setPaddingLeft(typedArray.getDimension(index, 0));
                    break;

                case PADDING_BOTTOM:
                    viewAttrs.setPaddingBottom(typedArray.getDimension(index, 0));
                    break;

                case WIDTH:
                    viewAttrs.setWidth(typedArray.getDimension(index, 0));
                    break;

                case HEIGHT:
                    viewAttrs.setHeight(typedArray.getDimension(index, 0));
                    break;

                case MARGIN:
                    viewAttrs.setMargin(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_TOP:
                    viewAttrs.setMarginTop(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_RIGHT:
                    viewAttrs.setMarginRight(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_LEFT:
                    viewAttrs.setMarginLeft(typedArray.getDimension(index, 0));
                    break;

                case MARGIN_BOTTOM:
                    viewAttrs.setMarginBottom(typedArray.getDimension(index, 0));
                    break;

                case DRAWABLE_PADDING:
                    viewAttrs.setDrawablePadding(typedArray.getDimension(index, 0));
                    break;
            }
        }

        viewAttrsList.add(viewAttrs);

        typedArray.recycle();

    }

    /**
     * 设置view参数
     * @param viewAttrs
     */
    private void setAttrs(final View view,final ViewAttributeSet viewAttrs){

        view.post(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                setTextSize(view,viewAttrs);
                setViewParams(view,viewAttrs);
                setViewPadding(view,viewAttrs);
                setViewDrawablePadding(view,viewAttrs);
            }
        });


    }

    /**
     * 设置view的大小、margin值
     * @param view
     * @param viewAttrs
     */
    private void setViewParams(View view,ViewAttributeSet viewAttrs){
        //是否设置view的params值
        boolean isParams=false;
        /**
         * 设置宽度和高度
         */
        ViewGroup.LayoutParams params=view.getLayoutParams();

        if(viewAttrs.getWidth() != 0){
            isParams=true;
            params.width=(int) getAutoSize(viewAttrs.getWidth());

        }

        if(viewAttrs.getHeight() != 0){
            isParams=true;
            params.height=(int) getAutoSize(viewAttrs.getHeight());
        }

        /**
         * 设置margin值
         */
        if (params instanceof ViewGroup.MarginLayoutParams)
        {
            ViewGroup.MarginLayoutParams marginParams=(ViewGroup.MarginLayoutParams) params;
//			 marginParams.setMargins((int)getWidthSize(viewAttrs.getMargin()), (int)getHeightSize(viewAttrs.getMargin()), (int)getWidthSize(viewAttrs.getMargin()), (int)getHeightSize(viewAttrs.getMargin()));

            if(viewAttrs.getMargin() != 0){
                isParams=true;
                marginParams.leftMargin=marginParams.rightMargin=(int)getAutoSize(viewAttrs.getMargin());
                marginParams.topMargin=marginParams.bottomMargin=(int)getAutoSize(viewAttrs.getMargin());
            }

            if(viewAttrs.getMarginLeft() != 0){
                isParams=true;
                marginParams.leftMargin=(int) getAutoSize(viewAttrs.getMarginLeft());

            }

            if(viewAttrs.getMarginTop() != 0){
                isParams=true;
                marginParams.topMargin=(int) getAutoSize(viewAttrs.getMarginTop());
            }

            if(viewAttrs.getMarginRight() != 0){
                isParams=true;
                marginParams.rightMargin=(int) getAutoSize(viewAttrs.getMarginRight());
            }

            if(viewAttrs.getMarginBottom() != 0){
                isParams=true;
                marginParams.bottomMargin=(int) getAutoSize(viewAttrs.getMarginBottom());
            }
        }

        if(isParams){
            view.setLayoutParams(params);
        }
    }

    /**
     * 设置字体的大小
     */
    private void setTextSize(View view,ViewAttributeSet viewAttrs){
        if(view instanceof TextView && viewAttrs != null){
            float size=getAutoSize(viewAttrs.getTextSize());
            if(size != 0){
                ((TextView) view).setTextSize(TypedValue.COMPLEX_UNIT_PX, size);
            }
        }
    }

    /**
     * 设置padding值
     */
    private void setViewPadding(View view,ViewAttributeSet viewAttrs){

        int left = view.getPaddingLeft();
        int right = view.getPaddingRight();
        int top = view.getPaddingTop();
        int bottom = view.getPaddingBottom();

        //标志是否设置padding值
        boolean isPadding=false;

        if(viewAttrs.getPadding() != 0){
            isPadding=true;
            left=right=(int) getAutoSize(viewAttrs.getPadding());
            top=bottom= (int) getAutoSize(viewAttrs.getPadding());
        }

        if(viewAttrs.getPaddingLeft() != 0){
            isPadding=true;
            left=(int) getAutoSize(viewAttrs.getPaddingLeft());
        }

        if(viewAttrs.getPaddingTop() != 0){
            isPadding=true;
            top=(int) getAutoSize(viewAttrs.getPaddingTop());
        }

        if(viewAttrs.getPaddingRight() != 0){
            isPadding=true;
            right=(int) getAutoSize(viewAttrs.getPaddingRight());
        }

        if(viewAttrs.getPaddingBottom() != 0){
            isPadding=true;
            bottom=(int) getAutoSize(viewAttrs.getPaddingBottom());
        }

        if(isPadding){
            view.setPadding(left, top, right, bottom);
        }

    }

    /**
     * 设置drawablepadding
     * @param view
     * @param viewAttrs
     */
    public void setViewDrawablePadding(View view, ViewAttributeSet viewAttrs){

        if(view instanceof TextView && viewAttrs.getDrawablePadding() != 0 ){
            ((TextView)view).setCompoundDrawablePadding((int) getAutoSize(viewAttrs.getDrawablePadding()));
        }
    }

    private  int getComplexUnit(int data)
    {
        return TypedValue.COMPLEX_UNIT_MASK & (data >> TypedValue.COMPLEX_UNIT_SHIFT);
    }

    public  boolean isPxVal(TypedValue val)
    {
        if (val != null && val.type == TypedValue.TYPE_DIMENSION &&
                getComplexUnit(val.data) == TypedValue.COMPLEX_UNIT_PX)
        {
            return true;
        }
        return false;
    }

    public float getAutoSize(float size){
        return size / designSize * screenSize;
    }
}
