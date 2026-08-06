package com.bytedance.platform.godzilla.utils;

import com.bytedance.platform.godzilla.common.IReflectHackHelper;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public final class HackHelper {
    private static IReflectHackHelper sInstance;

    private HackHelper() {
    }

    public static void init(IReflectHackHelper iReflectHackHelper) {
        sInstance = iReflectHackHelper;
    }

    public static IReflectHackHelper getInstance() {
        return sInstance;
    }

    public static Field getField(Class<?> cls, String str) {
        checkInit();
        return sInstance.getField(cls, str);
    }

    public static Method getMethod(Class<?> cls, String str, Class... clsArr) {
        checkInit();
        return sInstance.getMethod(cls, str, clsArr);
    }

    private static void checkInit() {
        if (sInstance == null) {
            throw new NullPointerException("please call Godzilla.init method pass in a IReflectHackHelper instance");
        }
    }
}
