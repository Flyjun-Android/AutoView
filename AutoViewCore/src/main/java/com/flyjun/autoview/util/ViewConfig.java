package com.flyjun.autoview.util;

/**
 * Created by Flyjun on 2017/4/18.
 */

public class ViewConfig {

    private int screenWidth;
    private int screenHeight;

    private int screenSize;

    private float designSize=1080.0f;

    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    public float getDesignSize() {
        return designSize;
    }

    public void setDesignSize(float designSize) {
        this.designSize = designSize;
    }

    @Override
    public String toString() {
        return "ViewConfig{" +
                "screenWidth=" + screenWidth +
                ", screenHeight=" + screenHeight +
                ", screenSize=" + screenSize +
                ", designSize=" + designSize +
                '}';
    }
}
