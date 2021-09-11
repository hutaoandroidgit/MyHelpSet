package com.hutao.myhelpset.tool.annotation;

import android.view.View;

import com.hutao.helplibrary.log.OsduiLog;
import com.hutao.helplibrary.toolutils.ArrayUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 注册事件管理公共类{@link RegisterEvent}
 *
 * @author kangdi
 */
public class RegisterEventManager {

    public static final String TAG = RegisterEventManager.class.getSimpleName();

    /**
     * 注册事件
     *
     * @param map
     * @param cla
     */
    public static void registerEvent(Map<String, String> map, Class<?>... cla) {
        if (map == null || cla == null) {
            OsduiLog.mtuiErrorLog(TAG, ":::registerEnumEvent:::map==" + map + " cla==" + cla);
            return;
        }
        for (Class<?> c : cla) {
            Method[] methods = c.getDeclaredMethods();
            for (Method method : methods) {
                method.setAccessible(true);
                RegisterEvent annotation = method.getAnnotation(RegisterEvent.class);
                if (annotation != null) {
                    String value = method.getName();
                    putEvent(map, annotation, value);
                }
            }
        }
    }

    private static void putEvent(Map<String, String> map, RegisterEvent annotation, String value) {
        try {
            Method[] declaredMethods = annotation.getClass().getDeclaredMethods();
            for (Method method : declaredMethods) {
                method.setAccessible(true);
                Class<?> returnType = method.getReturnType();
                if (returnType.isArray()) {
                    putMap(map, (Object[]) method.invoke(annotation), value);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void putMap(Map<String, String> map, Object[] keys, String value) {
        if (!ArrayUtils.isEmpty(keys)) {
            for (Object key : keys) {
                String keyStr = key.toString();
                if (!map.containsKey(keyStr)) {
                    OsduiLog.mtuiDebugLog(TAG, ":::putMap:::Object[] keys key==" + keyStr + " value==" + value);
                    map.put(keyStr, value);
                }
            }
        }
    }

    /**
     * 初始化目标对象内部的View对象{@link RegisterView}
     *
     * @param v
     * @param target
     */
    public static void findViewsById(View v, Object target) {
        try {
            Field[] fields = target.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                RegisterView annotation = field.getAnnotation(RegisterView.class);
                if (annotation != null) {
                    int viewId = annotation.id();
                    if (viewId != -1) {
                        field.set(target, v.findViewById(viewId));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化目标对象内部的View对象{@link RegisterView}
     *
     * @param v
     * @param target
     */
    public static void findViewsById(View v, Object target, Class<?>... targetClass) {
        try {
            for (Class<?> tClass : targetClass) {
                Field[] fields = tClass.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    RegisterView annotation = field.getAnnotation(RegisterView.class);
                    if (annotation != null) {
                        int viewId = annotation.id();
                        if (viewId != -1) {
                            field.set(target, v.findViewById(viewId));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化目标对象内部的View对象{@link RegisterView}
     *
     * @param v
     * @param target
     */
    public static void findViewsByTag(View v, Object target) {
        try {
            Field[] fields = target.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                RegisterView annotation = field.getAnnotation(RegisterView.class);
                if (annotation != null) {
                    String viewTag = annotation.tag();
                    if (viewTag != null && !viewTag.isEmpty()) {
                        field.set(target, v.findViewWithTag(viewTag));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化目标对象内部的View对象{@link RegisterView}
     *
     * @param v
     * @param target
     */
    public static void findViewsByTag(View v, Object target, Class<?>... targetClass) {
        try {
            for (Class<?> tClass : targetClass) {
                Field[] fields = tClass.getDeclaredFields();
                for (Field field : fields) {
                    field.setAccessible(true);
                    RegisterView annotation = field.getAnnotation(RegisterView.class);
                    if (annotation != null) {
                        String viewTag = annotation.tag();
                        if (viewTag != null && !viewTag.isEmpty()) {
                            field.set(target, v.findViewWithTag(viewTag));
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
