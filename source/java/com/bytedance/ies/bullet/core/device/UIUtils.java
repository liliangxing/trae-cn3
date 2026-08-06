package com.bytedance.ies.bullet.core.device;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.ies.bullet.base.utils.RomUtils;
import com.bytedance.ies.bullet.prefetchv2.PrefetchRequestConfig;
import com.bytedance.ies.bullet.service.base.IConditionCallKt;
import com.bytedance.ies.bullet.service.base.standard.visiblestate.ViewVisibleBridge;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* compiled from: UIUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0004J\u001d\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b\u001aJ\u0015\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001dH\u0001¢\u0006\u0002\b\u001eJ\u0015\u0010\u001f\u001a\u00020 2\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b!J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010&\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010'\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u000e\u0010(\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015J\u0016\u0010)\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u0004J\u001d\u0010+\u001a\u00020\u00102\u0006\u0010*\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0001¢\u0006\u0002\b,J\u0015\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.H\u0001¢\u0006\u0002\b0R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ies/bullet/core/device/UIUtils;", "", "()V", "cacheScale", "", "getCacheScale", "()F", "setCacheScale", "(F)V", "enableCacheScale", "", "getEnableCacheScale", "()Z", "setEnableCacheScale", "(Z)V", "sHeight", "", "sScale", "sWidth", "checkDeviceHasNavigationBar", "context", "Landroid/content/Context;", "dip2Px", "dipValue", "dpToPx", "dpValue", "dpToPx$anniex_release", "getDecorViewVisibleHeight", "window", "Landroid/view/Window;", "getDecorViewVisibleHeight$anniex_release", "getDisplayMetrics", "Lcom/bytedance/ies/bullet/core/device/UIUtils$DisplayMetric;", "getDisplayMetrics$anniex_release", "getFullScreenHeight", "getRealNavigationBarHeight", "getResources", "Landroid/content/res/Resources;", "getScreenHeight", "getScreenWidth", "getStatusBarHeight", "px2dip", "pxValue", "px2dp", "px2dp$anniex_release", "rgbaToArgb", "", "rgbaColor", "rgbaToArgb$anniex_release", "DisplayMetric", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class UIUtils {
    private static float cacheScale;
    private static boolean enableCacheScale;
    public static final UIUtils INSTANCE = new UIUtils();
    private static float sScale = -1.0f;
    private static int sWidth = -1;
    private static int sHeight = -1;

    private UIUtils() {
    }

    @JvmStatic
    public static final int dpToPx$anniex_release(int dpValue, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (sScale < 0) {
            sScale = context.getResources().getDisplayMetrics().density;
        }
        if (IConditionCallKt.enableDpToPxRoundToIntFix()) {
            return (int) ((dpValue * sScale) + 0.5f);
        }
        return MathKt.roundToInt((dpValue * sScale) + 0.5f);
    }

    @JvmStatic
    public static final int px2dp$anniex_release(int pxValue, Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (sScale < 0) {
            sScale = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((pxValue / sScale) + 0.5f);
    }

    @JvmStatic
    public static final DisplayMetric getDisplayMetrics$anniex_release(Context context) {
        Display defaultDisplay;
        Point point;
        Intrinsics.checkNotNullParameter(context, "context");
        int i = sWidth;
        int i2 = sHeight;
        if (i > 0 && i2 > 0 && i2 >= i) {
            return new DisplayMetric(i, i2);
        }
        try {
            Object systemService = context.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
            point = new Point();
        } catch (Exception unused) {
        }
        if (defaultDisplay == null) {
            return new DisplayMetric(i, i2);
        }
        defaultDisplay.getRealSize(point);
        i = px2dp$anniex_release(point.x, context);
        i2 = px2dp$anniex_release(point.y, context);
        return new DisplayMetric(i, i2);
    }

    /* compiled from: UIUtils.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ies/bullet/core/device/UIUtils$DisplayMetric;", "", "width", "", "height", "(II)V", "getHeight", "()I", "getWidth", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public static final /* data */ class DisplayMetric {
        private final int height;
        private final int width;

        public static /* synthetic */ DisplayMetric copy$default(DisplayMetric displayMetric, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = displayMetric.width;
            }
            if ((i3 & 2) != 0) {
                i2 = displayMetric.height;
            }
            return displayMetric.copy(i, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component2, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        public final DisplayMetric copy(int width, int height) {
            return new DisplayMetric(width, height);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof DisplayMetric)) {
                return false;
            }
            DisplayMetric displayMetric = (DisplayMetric) other;
            return this.width == displayMetric.width && this.height == displayMetric.height;
        }

        public int hashCode() {
            return (Integer.hashCode(this.width) * 31) + Integer.hashCode(this.height);
        }

        public String toString() {
            return "DisplayMetric(width=" + this.width + ", height=" + this.height + ')';
        }

        public DisplayMetric(int i, int i2) {
            this.width = i;
            this.height = i2;
        }

        public final int getHeight() {
            return this.height;
        }

        public final int getWidth() {
            return this.width;
        }
    }

    @JvmStatic
    public static final int getDecorViewVisibleHeight$anniex_release(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        Rect rect = new Rect();
        decorView.getWindowVisibleDisplayFrame(rect);
        return rect.bottom;
    }

    @JvmStatic
    public static final String rgbaToArgb$anniex_release(String rgbaColor) {
        Intrinsics.checkNotNullParameter(rgbaColor, "rgbaColor");
        if (rgbaColor.length() != 8 && rgbaColor.length() != 9) {
            return rgbaColor.length() == 6 ? "#" + rgbaColor : rgbaColor;
        }
        if (StringsKt.startsWith$default(rgbaColor, "#", false, 2, (Object) null)) {
            rgbaColor = StringsKt.drop(rgbaColor, 1);
        }
        return "#" + (StringsKt.takeLast(rgbaColor, 2) + StringsKt.dropLast(rgbaColor, 2));
    }

    public final float dip2Px(Context context, float dipValue) {
        Intrinsics.checkNotNullParameter(context, "context");
        return (dipValue * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public final boolean getEnableCacheScale() {
        return enableCacheScale;
    }

    public final void setEnableCacheScale(boolean z) {
        enableCacheScale = z;
    }

    public final float getCacheScale() {
        return cacheScale;
    }

    public final void setCacheScale(float f) {
        cacheScale = f;
    }

    public final int px2dip(Context context, float pxValue) {
        float f;
        Intrinsics.checkNotNullParameter(context, "context");
        if (enableCacheScale) {
            f = cacheScale;
        } else {
            f = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((pxValue / f) + 0.5f);
    }

    public final int getScreenHeight(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public final int getScreenWidth(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public final int getRealNavigationBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (RomUtils.isMiui() && Settings.Global.getInt(context.getContentResolver(), "hide_gesture_line", 0) == 1) {
            return 0;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        int dimensionPixelSize = identifier > 0 ? resources.getDimensionPixelSize(identifier) : 0;
        Rect rect = new Rect();
        if (context instanceof Activity) {
            ((Activity) context).getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return RangesKt.coerceAtMost(RangesKt.coerceAtLeast((getFullScreenHeight(context) - getStatusBarHeight(context)) - rect.height(), 0), dimensionPixelSize);
        }
        if (checkDeviceHasNavigationBar(context)) {
            return dimensionPixelSize;
        }
        return 0;
    }

    public final boolean checkDeviceHasNavigationBar(Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
        boolean z = identifier > 0 ? resources.getBoolean(identifier) : false;
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getMethod(PrefetchRequestConfig.METHOD_GET, String.class).invoke(cls, "qemu.hw.mainkeys");
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.String");
            str = (String) invoke;
        } catch (Exception unused) {
        }
        if (Intrinsics.areEqual("1", str)) {
            return false;
        }
        if (Intrinsics.areEqual(ViewVisibleBridge.INVISIBLE, str)) {
            return true;
        }
        return z;
    }

    private final int getFullScreenHeight(Context context) {
        WindowManager windowManager;
        try {
            if (context instanceof Activity) {
                windowManager = ((Activity) context).getWindowManager();
            } else {
                Object systemService = context.getSystemService("window");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService;
            }
            Intrinsics.checkNotNullExpressionValue(windowManager, "{\n            if (contex…r\n            }\n        }");
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            try {
                Class<?> cls = Class.forName("android.view.Display");
                Intrinsics.checkNotNullExpressionValue(cls, "forName(\"android.view.Display\")");
                cls.getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
                return displayMetrics.heightPixels;
            } catch (Exception e) {
                int screenHeight = getScreenHeight(context);
                e.printStackTrace();
                return screenHeight;
            }
        } catch (Exception unused) {
            return getScreenHeight(context);
        }
    }

    public final int getStatusBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = getResources(context);
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final Resources getResources(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        if (resources != null) {
            return resources;
        }
        Resources system = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(system, "getSystem()");
        return system;
    }
}
