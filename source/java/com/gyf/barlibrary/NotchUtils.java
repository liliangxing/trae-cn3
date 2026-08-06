package com.gyf.barlibrary;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes6.dex */
public class NotchUtils {
    private static final String NOTCH_HUA_WEI = "com.huawei.android.util.HwNotchSizeUtil";
    private static final String NOTCH_OPPO = "com.oppo.feature.screen.heteromorphism";
    private static final String NOTCH_VIVO = "android.util.FtFeature";
    private static final String NOTCH_XIAO_MI = "ro.miui.notch";
    private static final String SYSTEM_PROPERTIES = "android.os.SystemProperties";
    private static boolean isNotchResultInitialized;
    private static boolean sNotchResult;

    public static boolean hasNotchScreen(Activity activity) {
        if (isNotchResultInitialized) {
            return sNotchResult;
        }
        if (activity == null) {
            return false;
        }
        boolean z = hasNotchAtXiaoMi(activity) || hasNotchAtHuaWei(activity) || hasNotchAtOPPO(activity) || hasNotchAtVIVO(activity) || hasNotchAtAndroidP(activity);
        sNotchResult = z;
        isNotchResultInitialized = true;
        return z;
    }

    public static boolean hasNotchScreen(View view) {
        if (isNotchResultInitialized) {
            return sNotchResult;
        }
        if (view == null) {
            return false;
        }
        boolean z = hasNotchAtXiaoMi(view.getContext()) || hasNotchAtHuaWei(view.getContext()) || hasNotchAtOPPO(view.getContext()) || hasNotchAtVIVO(view.getContext()) || hasNotchAtAndroidP(view);
        sNotchResult = z;
        isNotchResultInitialized = true;
        return z;
    }

    private static boolean hasNotchAtAndroidP(View view) {
        return getDisplayCutout(view) != null;
    }

    private static boolean hasNotchAtAndroidP(Activity activity) {
        return getDisplayCutout(activity) != null;
    }

    private static DisplayCutout getDisplayCutout(Activity activity) {
        Window window;
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || activity == null || (window = activity.getWindow()) == null || (rootWindowInsets = window.getDecorView().getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    private static DisplayCutout getDisplayCutout(View view) {
        WindowInsets rootWindowInsets;
        if (Build.VERSION.SDK_INT < 28 || view == null || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return null;
        }
        return rootWindowInsets.getDisplayCutout();
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0042  */
    /* JADX WARN: Removed duplicated region for block: B:8:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean hasNotchAtXiaoMi(Context context) {
        int intValue;
        if ("Xiaomi".equals(Build.MANUFACTURER)) {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass(SYSTEM_PROPERTIES);
                intValue = ((Integer) loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, NOTCH_XIAO_MI, 0)).intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            }
            return intValue != 1;
        }
        intValue = 0;
        if (intValue != 1) {
        }
    }

    private static boolean hasNotchAtHuaWei(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_HUA_WEI);
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchAtVIVO(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(NOTCH_VIVO);
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (ClassNotFoundException | NoSuchMethodException | Exception unused) {
            return false;
        }
    }

    private static boolean hasNotchAtOPPO(Context context) {
        try {
            return context.getPackageManager().hasSystemFeature(NOTCH_OPPO);
        } catch (Exception unused) {
            return false;
        }
    }
}
