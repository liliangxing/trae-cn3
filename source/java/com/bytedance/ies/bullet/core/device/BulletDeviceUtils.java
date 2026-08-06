package com.bytedance.ies.bullet.core.device;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.bytedance.android.anniex.base.depend.AnnieXRuntime;
import com.bytedance.ies.bullet.base.constants.GlobalPropertiesConstants;
import com.bytedance.ies.bullet.base.utils.AbiUtil;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.settings.CommonConfig;
import com.bytedance.ies.bullet.service.base.settings.IBulletSettingsService;
import com.bytedance.ies.bullet.service.base.standard.StandardServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: BulletDeviceUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\rJ\u000e\u0010&\u001a\u00020\r2\u0006\u0010#\u001a\u00020$J\u0010\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010#\u001a\u00020$J\u0010\u0010)\u001a\u00020\u001f2\b\u0010*\u001a\u0004\u0018\u00010$J\u000e\u0010+\u001a\u00020\r2\u0006\u0010#\u001a\u00020$J\u000e\u0010,\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010.2\u0006\u0010#\u001a\u00020$J$\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f0.2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010/\u001a\u00020\u0013J&\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u0001012\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u00102\u001a\u00020\u001fJ\u000e\u00103\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u000e\u00104\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u000e\u00105\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u000e\u00106\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u000e\u00107\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020$J\u0006\u00108\u001a\u00020\u0013J\u0010\u00109\u001a\u00020\u00132\b\u0010*\u001a\u0004\u0018\u00010$J\u000e\u0010:\u001a\u00020\u00132\u0006\u0010#\u001a\u00020$J\u0016\u0010;\u001a\u00020\u001f2\u0006\u0010<\u001a\u00020=2\u0006\u0010#\u001a\u00020$R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0019\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u000bR\u0011\u0010\u001b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000bR\u000e\u0010\u001d\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010 \u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b!\u0010\u000b¨\u0006>"}, d2 = {"Lcom/bytedance/ies/bullet/core/device/BulletDeviceUtils;", "", "()V", "BLOCK_LIST_OF_CONCAVE_SCREEN", "", "", "getBLOCK_LIST_OF_CONCAVE_SCREEN", "()Ljava/util/List;", "TAG", "brand", "getBrand", "()Ljava/lang/String;", "cacheDensity", "", "getCacheDensity", "()F", "setCacheDensity", "(F)V", "enableCacheDensity", "", "getEnableCacheDensity", "()Z", "setEnableCacheDensity", "(Z)V", "isHuawei", "language", "getLanguage", "model", "getModel", "platform", "sStatusBarHeight", "", "system", "getSystem", "dip2Px", "context", "Landroid/content/Context;", "dipValue", "getDensity", "getDisplay", "Landroid/view/Display;", "getGLESVersion", "ctx", "getPixelRadio", "getScreenHeight", "getScreenInfo", "Lkotlin/Pair;", "isDp", "getScreenProps", "", "orientation", "getScreenRotation", "getScreenWidth", "getStatusBarHeight", "getWindowHeight", "getWindowWidth", "is32", "isAccessible", "isScreenPortrait", "px2dp", "px", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class BulletDeviceUtils {
    public static final String TAG = "DevicesUtil";
    private static float cacheDensity = 0.0f;
    private static boolean enableCacheDensity = false;
    public static final String platform = "android";
    private static int sStatusBarHeight;
    public static final BulletDeviceUtils INSTANCE = new BulletDeviceUtils();
    private static final List<String> BLOCK_LIST_OF_CONCAVE_SCREEN = CollectionsKt.listOf("PFJM10");

    private BulletDeviceUtils() {
    }

    public final List<String> getBLOCK_LIST_OF_CONCAVE_SCREEN() {
        return BLOCK_LIST_OF_CONCAVE_SCREEN;
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

    public final boolean getEnableCacheDensity() {
        return enableCacheDensity;
    }

    public final void setEnableCacheDensity(boolean z) {
        enableCacheDensity = z;
    }

    public final float getCacheDensity() {
        return cacheDensity;
    }

    public final void setCacheDensity(float f) {
        cacheDensity = f;
    }

    public final float getDensity(Context context) {
        Object obj;
        float f;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            if (enableCacheDensity) {
                f = cacheDensity;
            } else {
                f = context.getResources().getDisplayMetrics().density;
            }
            obj = Result.constructor-impl(Float.valueOf(f));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        Float f2 = (Float) obj;
        if (f2 != null) {
            return f2.floatValue();
        }
        return 0.0f;
    }

    public final int getGLESVersion(Context ctx) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Intrinsics.checkNotNull(ctx);
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
        if (AnnieXRuntime.INSTANCE.getApplicationDepend().isBaseMode()) {
            return false;
        }
        AccessibilityManager accessibilityManager = null;
        if (ctx != null && (systemService = ctx.getSystemService("accessibility")) != null && (systemService instanceof AccessibilityManager)) {
            accessibilityManager = (AccessibilityManager) systemService;
        }
        if (accessibilityManager != null && (enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(1)) != null) {
            Intrinsics.checkNotNullExpressionValue(enabledAccessibilityServiceList, "getEnabledAccessibilityS…viceInfo.FEEDBACK_SPOKEN)");
            if ((!enabledAccessibilityServiceList.isEmpty()) && accessibilityManager.isTouchExplorationEnabled()) {
                Log.d("DevicesUtil", "return isAccessible true");
                return true;
            }
            Log.d("DevicesUtil", "return isAccessible false");
            return false;
        }
        Log.d("DevicesUtil", "return isAccessible default false");
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

    public final Display getDisplay(Context context) {
        WindowManager windowManager;
        Intrinsics.checkNotNullParameter(context, "context");
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

    public final int getScreenHeight(Context context) {
        CommonConfig commonConfig;
        Intrinsics.checkNotNullParameter(context, "context");
        Display display = getDisplay(context);
        if (display == null) {
            return 0;
        }
        try {
            Point point = new Point();
            IBulletSettingsService iBulletSettingsService = (IBulletSettingsService) StandardServiceManager.INSTANCE.get(IBulletSettingsService.class);
            if ((iBulletSettingsService == null || (commonConfig = (CommonConfig) iBulletSettingsService.obtainSettings(CommonConfig.class)) == null) ? false : Intrinsics.areEqual(commonConfig.getUseRealSizeForScreenSizeInGlobalProps(), true)) {
                display.getRealSize(point);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "use real size for screenHeight in global props", null, null, 6, null);
            } else {
                display.getSize(point);
                BulletLogger.printLog$default(BulletLogger.INSTANCE, "use size for screenHeight in global props", null, null, 6, null);
            }
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

    public final int getWindowHeight(Context context) {
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

    public final int getWindowWidth(Context context) {
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
        return getDensity(context);
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
        if (ConcaveScreenUtils.INSTANCE.isOVConcaveScreen(context) && !BLOCK_LIST_OF_CONCAVE_SCREEN.contains(getModel())) {
            int dip2Px = (int) UIUtils.INSTANCE.dip2Px(context, 27);
            sStatusBarHeight = dip2Px;
            return dip2Px;
        }
        if (ConcaveScreenUtils.INSTANCE.isHWConcaveScreen(context) && !BLOCK_LIST_OF_CONCAVE_SCREEN.contains(getModel())) {
            int hWConcaveScreenHeight = ConcaveScreenUtils.INSTANCE.getHWConcaveScreenHeight(context);
            sStatusBarHeight = hWConcaveScreenHeight;
            return hWConcaveScreenHeight;
        }
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        int dimensionPixelOffset = identifier > 0 ? context.getResources().getDimensionPixelOffset(identifier) : 0;
        if (dimensionPixelOffset == 0) {
            dimensionPixelOffset = (int) UIUtils.INSTANCE.dip2Px(context, 25.0f);
        }
        sStatusBarHeight = dimensionPixelOffset;
        return dimensionPixelOffset;
    }

    public final int px2dp(double px, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (int) ((px / getDensity(context)) + 0.5f);
    }

    public final String getSystem() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
        return str;
    }

    public final String getLanguage() {
        Locale locale = LocaleList.getDefault().get(0);
        return locale.getLanguage() + '-' + locale.getCountry();
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032 A[Catch: all -> 0x0069, TryCatch #2 {all -> 0x0069, blocks: (B:15:0x0026, B:17:0x0032, B:20:0x0056, B:21:0x0057, B:22:0x0063), top: B:14:0x0026 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Pair<Integer, Integer> getScreenInfo(Context context, boolean isDp) {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        if (context != null) {
            try {
                Result.Companion companion = Result.Companion;
                BulletDeviceUtils bulletDeviceUtils = INSTANCE;
                i2 = bulletDeviceUtils.getScreenHeight(context);
                try {
                    i = bulletDeviceUtils.getScreenWidth(context);
                    try {
                        Result.constructor-impl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        th = th;
                        Result.Companion companion2 = Result.Companion;
                        Result.constructor-impl(ResultKt.createFailure(th));
                        Result.Companion companion3 = Result.Companion;
                        int statusBarHeight = INSTANCE.getStatusBarHeight(context);
                        if (context instanceof Activity) {
                        }
                        Result.constructor-impl(Unit.INSTANCE);
                        if (isDp) {
                        }
                        int i5 = i4;
                        i4 = !isDp ? INSTANCE.px2dp(i, context) : i;
                        i3 = i5;
                        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i3));
                    }
                } catch (Throwable th2) {
                    th = th2;
                    i = 0;
                }
            } catch (Throwable th3) {
                th = th3;
                i = 0;
                i2 = 0;
            }
            try {
                Result.Companion companion32 = Result.Companion;
                int statusBarHeight2 = INSTANCE.getStatusBarHeight(context);
                if (context instanceof Activity) {
                    Rect rect = new Rect();
                    View decorView = ((Activity) context).getWindow().getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "it.window.decorView");
                    decorView.getWindowVisibleDisplayFrame(rect);
                    int height = decorView.getHeight();
                    int i6 = rect.top;
                    int i7 = rect.bottom;
                    if (height == 0 && i6 == 0) {
                        i7 += statusBarHeight2;
                    }
                    i4 = Math.max((i2 - Math.max(i2 - i7, 0)) - statusBarHeight2, 0);
                }
                Result.constructor-impl(Unit.INSTANCE);
            } catch (Throwable th4) {
                Result.Companion companion4 = Result.Companion;
                Result.constructor-impl(ResultKt.createFailure(th4));
            }
            if (isDp) {
                i4 = INSTANCE.px2dp(i4, context);
            }
            int i52 = i4;
            i4 = !isDp ? INSTANCE.px2dp(i, context) : i;
            i3 = i52;
        } else {
            i3 = 0;
        }
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i3));
    }

    public final float dip2Px(Context context, float dipValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (dipValue * getDensity(context)) + 0.5f;
    }

    public final Pair<Integer, Integer> getScreenInfo(Context context) {
        Display defaultDisplay;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            Object systemService = context.getSystemService("window");
            if (systemService != null) {
                WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
                if (windowManager != null && (defaultDisplay = windowManager.getDefaultDisplay()) != null) {
                    Point point = new Point();
                    defaultDisplay.getRealSize(point);
                    return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
                }
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Object obj = Result.constructor-impl(ResultKt.createFailure(th));
            return (Pair) (Result.isFailure-impl(obj) ? null : obj);
        }
    }

    public final Map<String, Object> getScreenProps(Context context, int orientation) {
        Object obj;
        if (context == null) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("screenOrientation", orientation == 2 ? "landscape" : "portrait");
        if (AnnieXRuntime.INSTANCE.getDeviceDepend().isFold()) {
            String foldStatus = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldStatus();
            if (!(foldStatus.length() > 0)) {
                foldStatus = null;
            }
            if (foldStatus != null) {
                linkedHashMap.put("screenFoldState", foldStatus);
            }
            String foldType = AnnieXRuntime.INSTANCE.getDeviceDepend().getFoldType();
            String str = foldType.length() > 0 ? foldType : null;
            if (str != null) {
                linkedHashMap.put("screenFoldType", str);
            }
        }
        BulletDeviceUtils bulletDeviceUtils = INSTANCE;
        if (bulletDeviceUtils.getScreenInfo(context) != null) {
            linkedHashMap.put("screenWidth", Integer.valueOf(bulletDeviceUtils.px2dp(((Number) r0.getFirst()).intValue(), context)));
            linkedHashMap.put("screenHeight", Integer.valueOf(bulletDeviceUtils.px2dp(((Number) r0.getSecond()).intValue(), context)));
        }
        Map<String, Object> containerProps = PropsUtilsKt.getContainerProps(context);
        if (containerProps != null) {
            linkedHashMap.putAll(containerProps);
        }
        Map<String, Object> pageCommonProps = PropsUtilsKt.getPageCommonProps(context);
        Object obj2 = pageCommonProps.get(GlobalPropertiesConstants.CONTENT_WIDTH);
        if (obj2 != null) {
            linkedHashMap.put(GlobalPropertiesConstants.CONTENT_WIDTH, obj2);
        }
        Object obj3 = pageCommonProps.get(GlobalPropertiesConstants.CONTENT_HEIGHT);
        if (obj3 != null) {
            linkedHashMap.put(GlobalPropertiesConstants.CONTENT_HEIGHT, obj3);
        }
        if (AnnieXRuntime.INSTANCE.getDeviceDepend().enableBreakPoint()) {
            if ((AnnieXRuntime.INSTANCE.getDeviceDepend().getBreakPointKey().length() > 0) && (obj = pageCommonProps.get(AnnieXRuntime.INSTANCE.getDeviceDepend().getBreakPointKey())) != null) {
                linkedHashMap.put(AnnieXRuntime.INSTANCE.getDeviceDepend().getBreakPointKey(), obj);
            }
        }
        return linkedHashMap;
    }
}
