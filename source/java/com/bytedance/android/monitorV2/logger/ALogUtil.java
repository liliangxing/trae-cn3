package com.bytedance.android.monitorV2.logger;

import com.bytedance.android.anniex.solutions.card.AirActionConstant;
import com.bytedance.android.monitorV2.util.ExceptionUtil;
import com.bytedance.android.monitorV2.util.ReflectUtils;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes3.dex */
class ALogUtil {
    private static final HashMap<String, Method> methodMap = new HashMap<>();
    private static boolean sAlogInitialed = false;

    ALogUtil() {
    }

    private static Method getMethod(String str) {
        HashMap<String, Method> hashMap = methodMap;
        if (hashMap.containsKey(str)) {
            return hashMap.get(str);
        }
        Method reflectMethod = getReflectMethod(str);
        hashMap.put(str, reflectMethod);
        return reflectMethod;
    }

    private static Method getReflectMethod(String str) {
        try {
            return ReflectUtils.getMethod(Class.forName("com.ss.android.agilelogger.ALog"), str, new Class[]{String.class, String.class});
        } catch (ClassNotFoundException e) {
            ExceptionUtil.handleException(e);
            return null;
        }
    }

    private static boolean checkInitial() {
        if (sAlogInitialed) {
            return true;
        }
        try {
            Method method = ReflectUtils.getMethod(Class.forName("com.ss.android.agilelogger.ALog"), "isInitSuccess", null);
            method.setAccessible(true);
            sAlogInitialed = ((Boolean) method.invoke(null, null)).booleanValue();
        } catch (ClassNotFoundException e) {
            ExceptionUtil.handleException(e);
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
        }
        return sAlogInitialed;
    }

    private static boolean invokeMethod(Method method, String str, String str2) {
        if (checkInitial() && method != null) {
            try {
                method.invoke(null, str, str2);
                return true;
            } catch (Throwable th) {
                ExceptionUtil.handleException(th);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean v(String str, String str2) {
        return invokeMethod(getMethod(BaseSwitches.V), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d(String str, String str2) {
        return invokeMethod(getMethod(AirActionConstant.ActionId.ACTION_ID_DEFAULT_VALUE), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(String str, String str2) {
        return invokeMethod(getMethod(RXScreenCaptureService.KEY_INDEX), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean w(String str, String str2) {
        return invokeMethod(getMethod("w"), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str, String str2) {
        return invokeMethod(getMethod("e"), str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(String str, String str2, Throwable th) {
        return invokeMethod(getMethod("e"), str, str2);
    }
}
