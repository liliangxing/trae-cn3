package com.lynx.tasm.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.base.Assertions;
import com.lynx.tasm.base.LLog;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DisplayMetricsHolder {
    public static final float DEFAULT_SCREEN_SCALE = 1.0f;
    public static final int UNDEFINE_SCREEN_SIZE_VALUE = -1;
    private static boolean hasNativeUpdateDeviceInfo = false;
    private static boolean isCacheInvalid = false;

    @Deprecated
    private static int sOrientation = -1;

    @Deprecated
    private static float sScaleDensity = -1.0f;
    private static DisplayMetrics sScreenDisplayMetrics;
    private static DisplayMetrics sWindowDisplayMetrics;

    static native void nativeUpdateDevice(int i, int i2, float f);

    private static void setWindowDisplayMetrics(DisplayMetrics displayMetrics) {
        synchronized (DisplayMetricsHolder.class) {
            if (sWindowDisplayMetrics == null) {
                sWindowDisplayMetrics = new DisplayMetrics();
            }
            sWindowDisplayMetrics.setTo(displayMetrics);
        }
    }

    public static boolean updateOrInitDisplayMetrics(Context context) {
        return updateOrInitDisplayMetrics(context, null);
    }

    public static void updateDisplayMetrics(int i, int i2) {
        synchronized (DisplayMetricsHolder.class) {
            isCacheInvalid = true;
            DisplayMetrics displayMetrics = sWindowDisplayMetrics;
            if (displayMetrics != null) {
                displayMetrics.widthPixels = i;
                sWindowDisplayMetrics.heightPixels = i2;
            }
            DisplayMetrics displayMetrics2 = sScreenDisplayMetrics;
            if (displayMetrics2 != null) {
                displayMetrics2.widthPixels = i;
                sScreenDisplayMetrics.heightPixels = i2;
            }
        }
    }

    public static boolean updateOrInitDisplayMetrics(Context context, Float f) {
        if (context == null) {
            LLog.w(LynxConstants.TAG, "updateOrInitDisplayMetrics context parameter is null, fallback to updateOrInitDisplayMetrics by ApplicationContext");
            context = LynxEnv.inst().getAppContext();
        }
        updateWindowDisplayMetrics(context, f);
        boolean shouldUpdateScreenMetrics = shouldUpdateScreenMetrics(context, f);
        if (shouldUpdateScreenMetrics || isCacheInvalid) {
            updateScreenDisplayMetrics(context, f);
            isCacheInvalid = false;
        }
        updateCurrentProps(context);
        return shouldUpdateScreenMetrics;
    }

    private static void updateWindowDisplayMetrics(Context context, Float f) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (f != null) {
            displayMetrics.density = f.floatValue();
        }
        setWindowDisplayMetrics(displayMetrics);
    }

    private static void updateScreenDisplayMetrics(Context context, Float f) {
        DisplayMetrics realScreenDisplayMetrics = getRealScreenDisplayMetrics(context);
        if (f != null) {
            realScreenDisplayMetrics.density = f.floatValue();
        }
        setScreenDisplayMetrics(realScreenDisplayMetrics);
    }

    private static boolean isScaleDensityChange(DisplayMetrics displayMetrics) {
        return sScaleDensity != displayMetrics.scaledDensity;
    }

    private static boolean isDensityChanged(Float f) {
        DisplayMetrics displayMetrics = sScreenDisplayMetrics;
        return (displayMetrics == null || f == null || displayMetrics.density == f.floatValue()) ? false : true;
    }

    private static boolean isOrientationChanged(Context context) {
        return sOrientation != context.getResources().getConfiguration().orientation;
    }

    private static void updateCurrentProps(Context context) {
        sScaleDensity = context.getResources().getDisplayMetrics().scaledDensity;
        sOrientation = context.getResources().getConfiguration().orientation;
    }

    private static boolean shouldUpdateScreenMetrics(Context context, Float f) {
        return getScreenDisplayMetrics() == null || isOrientationChanged(context) || isScaleDensityChange(context.getResources().getDisplayMetrics()) || !hasNativeUpdateDeviceInfo || isDensityChanged(f);
    }

    public static DisplayMetrics getRealScreenDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (getWindowDisplayMetrics() != null) {
            displayMetrics.setTo(getWindowDisplayMetrics());
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Assertions.assertNotNull(windowManager, "WindowManager is null!");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getRealMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    @Deprecated
    public static DisplayMetrics getWindowDisplayMetrics() {
        synchronized (DisplayMetricsHolder.class) {
            if (sWindowDisplayMetrics == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(sWindowDisplayMetrics);
            return displayMetrics;
        }
    }

    private static void setScreenDisplayMetrics(DisplayMetrics displayMetrics) {
        boolean isNativeLibraryLoaded = LynxEnv.inst().isNativeLibraryLoaded();
        synchronized (DisplayMetricsHolder.class) {
            sScreenDisplayMetrics = displayMetrics;
            if (isNativeLibraryLoaded) {
                hasNativeUpdateDeviceInfo = true;
                nativeUpdateDevice(displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.density);
            }
        }
    }

    @Deprecated
    public static DisplayMetrics getScreenDisplayMetrics() {
        synchronized (DisplayMetricsHolder.class) {
            if (sScreenDisplayMetrics == null) {
                return null;
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setTo(sScreenDisplayMetrics);
            return displayMetrics;
        }
    }
}
