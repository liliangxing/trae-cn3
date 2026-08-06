package com.vivo.push.util;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import java.lang.reflect.Method;

/* compiled from: MultiWindowUtils.java */
/* renamed from: com.vivo.push.util.w */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public final class C1396w {
    /* renamed from: a */
    public static boolean m1054a(Activity activity) {
        if (activity == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 34) {
            return activity.isInMultiWindowMode() || m1055b(activity);
        }
        return activity.isInMultiWindowMode();
    }

    /* renamed from: b */
    private static boolean m1055b(Activity activity) {
        Window window = activity.getWindow();
        try {
            Class<?> cls = window.getClass();
            Method method = null;
            if (cls != null && cls.getSuperclass() != null) {
                for (Method method2 : cls.getSuperclass().getDeclaredMethods()) {
                    if (method2 != null && "getWindowControllerCallback".equals(method2.getName())) {
                        method = method2;
                    }
                }
            }
            if (method != null) {
                Object invoke = method.invoke(window, new Object[0]);
                if (invoke == null) {
                    return false;
                }
                for (Method method3 : invoke.getClass().getDeclaredMethods()) {
                    if (method3 != null && "isInVivoFreeformMode".equals(method3.getName())) {
                        method = method3;
                    }
                }
                return ((Boolean) method.invoke(invoke, new Object[0])).booleanValue();
            }
            C1393t.m1034a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver not implement in IActivityManager");
            return false;
        } catch (Exception e) {
            C1393t.m1035a("MultiWindowUtils", "<isWindowModeFreeForm> registerActivityObserver-e = ", e);
            return false;
        }
    }
}
