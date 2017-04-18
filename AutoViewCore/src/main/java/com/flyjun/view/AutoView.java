package com.flyjun.view;

import android.app.Activity;
import android.content.Context;
import android.util.AndroidRuntimeException;
import android.util.DisplayMetrics;
import android.view.View;

import com.alibaba.fastjson.JSON;
import com.flyjun.autoview.util.Builder;
import com.flyjun.autoview.util.ViewConfig;
import com.flyjun.autoview.util.ViewConfigSP;

/**
 * Created by Flyjun on 2017/4/18.
 */

public class AutoView {

    public static AutoView instance;

    private ViewConfig viewConfig;

    private AutoView() {
    }

    public static AutoView getInstance(){
        if (instance == null){
            instance=new AutoView();
        }
        return instance;
    }

    public static void init(Activity activity){
        getInstance().initConfig(activity);
    }

    public static void init(Activity activity,float designSize){
        getInstance().initConfig(activity,designSize);
    }

    public static float getAutoSize(Context context,float size){
        return getInstance().autoSize(context,size);
    }

    public static Builder autoBuilder(View view){
        return new Builder(view);
    }

    private void initConfig(Activity activity){

        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;

        viewConfig=new ViewConfig();

        viewConfig.setScreenWidth(screenWidth);
        viewConfig.setScreenHeight(screenHeight);

        if (screenWidth > screenHeight) {
            viewConfig.setScreenSize(screenHeight);
        } else {
            viewConfig.setScreenSize(screenWidth);
        }

        ViewConfigSP viewConfigSP=new ViewConfigSP(activity);
        viewConfigSP.setViewConfig(JSON.toJSON(viewConfig).toString());

    }

    public void initConfig(Activity activity,float designSize){

        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenWidth = dm.widthPixels;
        int screenHeight = dm.heightPixels;

        viewConfig=new ViewConfig();
        viewConfig.setDesignSize(designSize);
        viewConfig.setScreenWidth(screenWidth);
        viewConfig.setScreenHeight(screenHeight);

        if (screenWidth > screenHeight) {
            viewConfig.setScreenSize(screenHeight);
        } else {
            viewConfig.setScreenSize(screenWidth);
        }

        ViewConfigSP viewConfigSP=new ViewConfigSP(activity);
        viewConfigSP.setViewConfig(JSON.toJSON(viewConfig).toString());

    }

    private float autoSize(Context context,float size){

        if (viewConfig == null){
            ViewConfig viewConfig= JSON.parseObject(new ViewConfigSP(context).getViewConfig(),ViewConfig.class);
        }

        if (null == viewConfig){
            throw new AndroidRuntimeException("not AutoView init");
        }

        return size / viewConfig.getDesignSize() * viewConfig.getScreenSize();
    }
}
