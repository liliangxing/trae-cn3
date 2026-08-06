package com.bytedance.push.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.bytedance.common.utility.DeviceUtils;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import com.bytedance.ug.sdk.deeplink.CommonConstants;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class SystemUtils {
    public static boolean isDebugabbleOS() {
        return ViewVisibleBridge.INVISIBLE.equals(SystemProperties.get("ro.adb.secure")) || "1".equals(SystemProperties.get("ro.debuggable"));
    }

    public static boolean isAdbConnected(Context context) {
        return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
    }

    public static boolean isDarkMode(Context context) {
        try {
            return (Resources.getSystem().getConfiguration().uiMode & 48) == 32;
        } catch (Exception e) {
            Logger.m271e("SystemUtils", "isDarkModeEnabled: " + e);
            return false;
        }
    }

    public static Rect getDeviceRealRect(Context context) {
        try {
            Object invoke = DoubleReflectUtils.getAccessibleMethod(Class.forName("android.app.WindowConfiguration"), "getBounds", new Class[0]).invoke(DoubleReflectUtils.getAccessibleField(Class.forName("android.content.res.Configuration"), "windowConfiguration").get(context.getResources().getConfiguration()), new Object[0]);
            if (invoke instanceof Rect) {
                return (Rect) invoke;
            }
            return null;
        } catch (Throwable th) {
            Logger.m271e("SystemUtils", "[getRealRect]:" + th.getLocalizedMessage());
            return null;
        }
    }

    public static int getBottomNavigationBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static boolean isBottomNavigationBarShowing(Context context) {
        Logger.m274i("SystemUtils", "[isBottomNavigationBarShowing]");
        if (DeviceUtils.getNavigationBarHeight(context) == 0) {
            Logger.m274i("SystemUtils", "[isBottomNavigationBarShowing]return false because navigation bar height is 0");
            return false;
        }
        if (TextUtils.equals(Build.MANUFACTURER.toLowerCase(), CommonConstants.HW_AD_PLATFORM) || TextUtils.equals(Build.MANUFACTURER.toLowerCase(), "honor")) {
            return Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0) == 0;
        }
        if (TextUtils.equals(Build.MANUFACTURER.toLowerCase(), "xiaomi")) {
            return Settings.Global.getInt(context.getContentResolver(), "force_fsg_nav_bar", 0) == 0;
        }
        if (TextUtils.equals(Build.MANUFACTURER.toLowerCase(), "vivo")) {
            return Settings.Secure.getInt(context.getContentResolver(), "navigation_gesture_on", 0) != 0;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        int i4 = displayMetrics2.widthPixels;
        if (i3 > i4) {
            if (DeviceUtils.getNavigationBarHeight(context) + i3 > i) {
                return false;
            }
        } else if (DeviceUtils.getNavigationBarHeight(context) + i4 > i2) {
            return false;
        }
        return i2 - i4 > 0 || i - i3 > 0;
    }
}
