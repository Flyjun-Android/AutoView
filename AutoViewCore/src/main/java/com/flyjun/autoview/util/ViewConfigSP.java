package com.flyjun.autoview.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Flyjun on 16/8/4.
 */
public class ViewConfigSP {
    private SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor editor;

    private String FILE_NAME="ViewConfigSP";


    public static final String VIEWCONFIG="view_config";


    public ViewConfigSP(Context c) {
        mSharedPreferences= c.getSharedPreferences(FILE_NAME,
                Activity.MODE_PRIVATE);

        editor = mSharedPreferences.edit();
    }

    public void setViewConfig(String value) {
        editor.putString(VIEWCONFIG,value);
        editor.commit();
    }

    public String getViewConfig() {
        return mSharedPreferences.getString(VIEWCONFIG,null);
    }
}
