package com.bytedance.push.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.widget.TextView;
import com.bytedance.ies.bullet.service.router.RouterConstants;
import com.ss.android.message.util.ToolUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class UiAdaptationUtils {
    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static Point getDeviceTotalSize(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getRealSize(point);
        return point;
    }

    public static Map<String, String> buildUiAdaptationParams(Context context) {
        HashMap hashMap = new HashMap();
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        if (displayMetrics != null) {
            hashMap.put("density", String.valueOf(displayMetrics.density));
            hashMap.put("screen_dpi", String.valueOf(displayMetrics.densityDpi));
            hashMap.put("window_w", String.valueOf(displayMetrics.widthPixels));
            hashMap.put("window_h", String.valueOf(displayMetrics.heightPixels));
            hashMap.put("scaled_density", String.valueOf(displayMetrics.scaledDensity));
        }
        Rect realRect = getRealRect(context);
        if (realRect != null) {
            hashMap.put("real_window_w", String.valueOf(realRect.right - realRect.left));
            hashMap.put("real_window_h", String.valueOf(realRect.bottom - realRect.top));
        } else {
            hashMap.put("real_window_w", String.valueOf(-1));
            hashMap.put("real_window_h", String.valueOf(-1));
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        hashMap.put("status_bar_height_px", String.valueOf(identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0));
        hashMap.put("rom_version", RomVersionParamHelper.getParameter());
        try {
            hashMap.put("sys_permission_enable", RomVersionParamHelper.getSystemProperty("persist.sys.permission.enable"));
            Resources resources = context.createPackageContext("com.android.settings", 2).getResources();
            hashMap.put("font_scale", String.valueOf(resources.getConfiguration().fontScale));
            hashMap.put("sys_font_size", String.valueOf(resources.getConfiguration().fontScale * displayMetrics.scaledDensity));
            hashMap.put("font_height", String.valueOf(getSingleTextHeight()));
            hashMap.put("sys_font_size_by_new_obj", String.valueOf(new TextView(context).getTextSize()));
            hashMap.put("action_bar_title_size", String.valueOf(getDimen(resources, resources.getIdentifier("miuix_appcompat_title_text_size", "dimen", "com.android.settings"))));
            hashMap.put("action_bar_height", String.valueOf(getDimen(resources, resources.getIdentifier("miuix_appcompat_action_bar_default_height", "dimen", "com.android.settings"))));
            hashMap.put("is_install_cts", ToolUtils.getTargetApplicationInfo(context, "com.android.cts.verifier") != null ? RouterConstants.TRUE : "false");
        } catch (Throwable th) {
            Logger.m271e("UiAdaptationUtils", "exception when build androidSettingsContext:" + th.getLocalizedMessage());
        }
        try {
            Resources resources2 = context.createPackageContext("android", 2).getResources();
            hashMap.put("tool_bar_title_size", String.valueOf(getDimen(resources2, resources2.getIdentifier("text_size_title_material_toolbar", "dimen", "android"))));
        } catch (Throwable th2) {
            Logger.m271e("UiAdaptationUtils", "exception when build androidContext:" + th2.getLocalizedMessage());
        }
        return hashMap;
    }

    public static Map<String, Object> buildUiAdaptationParamsForPythonTest(Context context) {
        HashMap hashMap = new HashMap();
        DisplayMetrics displayMetrics = getDisplayMetrics(context);
        if (displayMetrics != null) {
            hashMap.put("density", Float.valueOf(displayMetrics.density));
            hashMap.put("screen_dpi", Integer.valueOf(displayMetrics.densityDpi));
            hashMap.put("window_w", Integer.valueOf(displayMetrics.widthPixels));
            hashMap.put("window_h", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("scaled_density", Float.valueOf(displayMetrics.scaledDensity));
        }
        Rect realRect = getRealRect(context);
        if (realRect != null) {
            hashMap.put("real_window_w", Integer.valueOf(realRect.right - realRect.left));
            hashMap.put("real_window_h", Integer.valueOf(realRect.bottom - realRect.top));
        } else {
            hashMap.put("real_window_w", -1);
            hashMap.put("real_window_h", -1);
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        hashMap.put("status_bar_height_px", Integer.valueOf(identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0));
        hashMap.put("rom_version", RomVersionParamHelper.getParameter());
        try {
            Resources resources = context.createPackageContext("com.android.settings", 2).getResources();
            hashMap.put("font_scale", Float.valueOf(resources.getConfiguration().fontScale));
            hashMap.put("sys_font_size", Float.valueOf(resources.getConfiguration().fontScale * displayMetrics.scaledDensity));
            hashMap.put("font_height", Integer.valueOf(getSingleTextHeight()));
            hashMap.put("sys_font_size_by_new_obj", Float.valueOf(new TextView(context).getTextSize()));
            hashMap.put("action_bar_title_size", Float.valueOf(getDimen(resources, resources.getIdentifier("miuix_appcompat_title_text_size", "dimen", "com.android.settings"))));
            hashMap.put("action_bar_height", Float.valueOf(getDimen(resources, resources.getIdentifier("miuix_appcompat_action_bar_default_height", "dimen", "com.android.settings"))));
            hashMap.put("is_install_cts", ToolUtils.getTargetApplicationInfo(context, "com.android.cts.verifier") != null ? RouterConstants.TRUE : "false");
        } catch (Throwable th) {
            Logger.m271e("UiAdaptationUtils", "exception when build androidSettingsContext:" + th.getLocalizedMessage());
        }
        try {
            Resources resources2 = context.createPackageContext("android", 2).getResources();
            hashMap.put("tool_bar_title_size", String.valueOf(getDimen(resources2, resources2.getIdentifier("text_size_title_material_toolbar", "dimen", "android"))));
        } catch (Throwable th2) {
            Logger.m271e("UiAdaptationUtils", "exception when build androidContext:" + th2.getLocalizedMessage());
        }
        return hashMap;
    }

    public static Rect getRealRect(Context context) {
        return SystemUtils.getDeviceRealRect(context);
    }

    private static float getDimen(Resources resources, int i) {
        try {
            return resources.getDimension(i);
        } catch (Throwable unused) {
            return -1.0f;
        }
    }

    private static int getSingleTextHeight() {
        Paint paint = new Paint();
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        paint.getTextBounds("抖", 0, 1, new Rect());
        return (int) (fontMetrics.bottom - fontMetrics.top);
    }
}
