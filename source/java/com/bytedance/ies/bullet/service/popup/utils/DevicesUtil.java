package com.bytedance.ies.bullet.service.popup.utils;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.ies.bullet.base.utils.AbiUtil;
import com.bytedance.ies.bullet.core.device.ConcaveScreenUtils;
import com.bytedance.ies.bullet.core.device.UIUtils;
import com.bytedance.trae.network.FrontierIdGenerator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DevicesUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u001f\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\"\u001a\u00020\tJ\u0010\u0010#\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018J\u000e\u0010$\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010%\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nR\u0011\u0010\u000b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007¨\u0006("}, d2 = {"Lcom/bytedance/ies/bullet/service/popup/utils/DevicesUtil;", "", "()V", "TAG", "", "brand", "getBrand", "()Ljava/lang/String;", "isHuawei", "", "()Z", "language", "getLanguage", "model", "getModel", "platform", "getPlatform", "sStatusBarHeight", "", "system", "getSystem", "getDensity", "", "context", "Landroid/content/Context;", "getDisplay", "Landroid/view/Display;", "getGLESVersion", "ctx", "getPixelRadio", "getScreenHight", "getScreenRotation", "getScreenWidth", "getStatusBarHeight", "is32", "isAccessible", "isScreenPortrait", "px2dp", "px", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class DevicesUtil {
    public static final DevicesUtil INSTANCE = new DevicesUtil();
    public static final String TAG = "DevicesUtil";
    private static int sStatusBarHeight;

    public final String getPlatform() {
        return FrontierIdGenerator.APP_RUNTIME_TYPE_ANDROID;
    }

    private DevicesUtil() {
    }

    public final String getBrand() {
        String str = Build.BRAND;
        Intrinsics.checkNotNullExpressionValue(str, "BRAND");
        return str;
    }

    public final String getModel() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    public final float getDensity(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.constructor-impl(Float.valueOf(context.getResources().getDisplayMetrics().density));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Float f = (Float) obj;
        if (f != null) {
            return f.floatValue();
        }
        return 0.0f;
    }

    public final int getGLESVersion(Context ctx) {
        Object obj;
        if (ctx == null) {
            return 0;
        }
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = ctx.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            ConfigurationInfo deviceConfigurationInfo = ((ActivityManager) systemService).getDeviceConfigurationInfo();
            Intrinsics.checkNotNull(deviceConfigurationInfo);
            obj = Result.constructor-impl(Integer.valueOf(deviceConfigurationInfo.reqGlEsVersion));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Integer num = (Integer) obj;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final boolean isAccessible(Context ctx) {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList;
        Object systemService;
        AccessibilityManager accessibilityManager = null;
        if (ctx != null && (systemService = ctx.getSystemService("accessibility")) != null && (systemService instanceof AccessibilityManager)) {
            accessibilityManager = (AccessibilityManager) systemService;
        }
        if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) != null) {
            Intrinsics.checkNotNullExpressionValue(enabledAccessibilityServiceList, "getEnabledAccessibilityS…viceInfo.FEEDBACK_SPOKEN)");
            if ((!enabledAccessibilityServiceList.isEmpty()) && accessibilityManager.isTouchExplorationEnabled()) {
                Log.d("DevicesUtil", "return isAccessable true");
                return true;
            }
            Log.d("DevicesUtil", "return isAccessable false");
            return false;
        }
        Log.d("DevicesUtil", "return isAccessable default false");
        return false;
    }

    public final boolean is32() {
        try {
            String hostAbi = AbiUtil.getHostAbi();
            Intrinsics.checkNotNullExpressionValue(hostAbi, "getHostAbi()");
            if (TextUtils.isEmpty(hostAbi)) {
                return false;
            }
            return !Intrinsics.areEqual("arm64-v8a", AbiUtil.getHostAbi());
        } catch (Exception e) {
            Log.e("DevicesUtil", "return is32 false by " + e.getMessage());
            return false;
        }
    }

    private final Display getDisplay(Context context) {
        WindowManager windowManager;
        if (context instanceof Activity) {
            windowManager = ((Activity) context).getWindowManager();
        } else {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService;
        }
        if (windowManager != null) {
            return windowManager.getDefaultDisplay();
        }
        return null;
    }

    public final int getScreenHight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Display display = getDisplay(context);
        if (display == null) {
            return 0;
        }
        try {
            Point point = new Point();
            display.getSize(point);
            return point.y;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                return 0;
            }
            Log.e("DevicesUtil", message);
            return 0;
        }
    }

    public final int getScreenWidth(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Display display = getDisplay(context);
        if (display == null) {
            return 0;
        }
        try {
            Point point = new Point();
            display.getSize(point);
            return point.x;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                return 0;
            }
            Log.e("DevicesUtil", message);
            return 0;
        }
    }

    public final int getScreenRotation(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) systemService).getDefaultDisplay().getRotation();
    }

    public final boolean isScreenPortrait(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int screenRotation = getScreenRotation(context);
        return screenRotation == 0 || screenRotation == 2;
    }

    public final float getPixelRadio(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDisplayMetrics().density;
    }

    public final boolean isHuawei() {
        if (Build.MANUFACTURER == null) {
            return false;
        }
        String str = Build.MANUFACTURER;
        Intrinsics.checkNotNullExpressionValue(str, "MANUFACTURER");
        return StringsKt.contains$default(str, "HUAWEI", false, 2, (Object) null);
    }

    public final int getStatusBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = sStatusBarHeight;
        if (i > 0) {
            return i;
        }
        if (ConcaveScreenUtils.INSTANCE.isOVConcaveScreen(context)) {
            int dpToPx$anniex_release = UIUtils.dpToPx$anniex_release(27, context);
            sStatusBarHeight = dpToPx$anniex_release;
            return dpToPx$anniex_release;
        }
        if (ConcaveScreenUtils.INSTANCE.isHWConcaveScreen(context)) {
            int hWConcaveScreenHeight = ConcaveScreenUtils.INSTANCE.getHWConcaveScreenHeight(context);
            sStatusBarHeight = hWConcaveScreenHeight;
            return hWConcaveScreenHeight;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelOffset = identifier > 0 ? context.getResources().getDimensionPixelOffset(identifier) : 0;
        if (dimensionPixelOffset == 0) {
            dimensionPixelOffset = UIUtils.dpToPx$anniex_release(25, context);
        }
        sStatusBarHeight = dimensionPixelOffset;
        return dimensionPixelOffset;
    }

    public final int px2dp(double px, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((px / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public final String getSystem() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
        return str;
    }

    public final String getLanguage() {
        Locale locale = LocaleList.getDefault().get(0);
        Intrinsics.checkNotNullExpressionValue(locale, "{\n                Locale…efault()[0]\n            }");
        return locale.getLanguage() + '-' + locale.getCountry();
    }
}
