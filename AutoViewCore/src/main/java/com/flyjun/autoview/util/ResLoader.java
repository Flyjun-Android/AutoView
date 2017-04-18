package com.flyjun.autoview.util;

import android.content.Context;

import java.lang.reflect.Field;

/**
 * Created by Flyjun on 2017/4/18.
 */

public class ResLoader {

    public static Integer getStyleable(Context context, String name) {
        Integer id= (Integer) getResourceId(context, name,"styleable");
        return id;

    }

    public static int[] getstyleableArray(Context context, String name){
        return (int[])getResourceId(context, name,"styleable");
    }

    /**
     * @author Flyjun
     * 对于context.getResources().getIdentifier无法获取的数据,或者数组
     * 资源反射值
     * @paramcontext
     * @param name
     * @param type
     * @return
     */

    private static Object getResourceId(Context context, String name, String type) {

        String className = context.getPackageName() +".R";
        try {
            Class cls = Class.forName(className);
            for (Class childClass : cls.getClasses()) {
                String simple = childClass.getSimpleName();
                if (simple.equals(type)) {
                    for (Field field : childClass.getFields()) {
                        String fieldName = field.getName();
                        if (fieldName.equals(name)) {
//							System.out.println(fieldName);
                            return field.get(null);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
