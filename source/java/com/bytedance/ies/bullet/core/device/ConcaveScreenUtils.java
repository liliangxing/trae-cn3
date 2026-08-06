package com.bytedance.ies.bullet.core.device;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.bytedance.ies.bullet.service.base.ResourceInfo;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConcaveScreenUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0015\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fJ\u0018\u0010\u0016\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u0007J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ies/bullet/core/device/ConcaveScreenUtils;", "", "()V", "HW_TOP_MARGIN", "", "OV_TOP_MARGIN", "isVivoConcaveScreen", "", "()Z", "sHWConcaveScreenHeight", "sIsHwConcaveScreen", "sIsOppoConcaveScreen", "sIsVivoConcaveScreen", "getHWConcaveScreenHeight", "context", "Landroid/content/Context;", "getHWConcaveScreenWidht", "getNotchSize", "", "getRealHeight", "isHWConcaveScreen", "isOVConcaveScreen", "isOppoConcaveScreen", "isVertical", ResourceInfo.RESOURCE_FROM_PRELOAD, "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ConcaveScreenUtils {
    private static final int HW_TOP_MARGIN = 28;
    public static final int OV_TOP_MARGIN = 27;
    public static final ConcaveScreenUtils INSTANCE = new ConcaveScreenUtils();
    private static int sIsVivoConcaveScreen = -1;
    private static int sIsOppoConcaveScreen = -1;
    private static int sIsHwConcaveScreen = -1;
    private static int sHWConcaveScreenHeight = -1;

    private ConcaveScreenUtils() {
    }

    public final void preload(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        isVivoConcaveScreen();
        isOppoConcaveScreen(context);
        isHWConcaveScreen(context);
        getHWConcaveScreenHeight(context);
    }

    public final boolean isOVConcaveScreen(Context context) {
        return isVivoConcaveScreen() || isOppoConcaveScreen(context);
    }

    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r3v3, types: [boolean] */
    public final boolean isVivoConcaveScreen() {
        int i = sIsVivoConcaveScreen;
        ?? r3 = 0;
        if (i != -1) {
            return i == 1;
        }
        try {
            Class<?> cls = Class.forName("android.util.FtFeature");
            Object invoke = cls.getDeclaredMethod("isFeatureSupport", Integer.TYPE).invoke(cls, 32);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            r3 = ((Boolean) invoke).booleanValue();
        } catch (Exception unused) {
        }
        sIsVivoConcaveScreen = r3;
        return r3;
    }

    public final boolean isOppoConcaveScreen(Context context) {
        int i = sIsOppoConcaveScreen;
        if (i != -1) {
            return i == 1;
        }
        boolean isOppoConcaveScreen = isOppoConcaveScreen(context, true);
        sIsOppoConcaveScreen = isOppoConcaveScreen ? 1 : 0;
        return isOppoConcaveScreen;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean isOppoConcaveScreen(Context context, boolean isVertical) {
        boolean z;
        String lowerCase;
        try {
            String str = Build.BRAND;
            Intrinsics.checkNotNullExpressionValue(str, "BRAND");
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
            lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        } catch (Throwable unused) {
        }
        if (TextUtils.equals("oppo", lowerCase) && context != null) {
            z = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
            if (z) {
                return false;
            }
            return isVertical ? getRealHeight(context) >= 2280 : z;
        }
        z = false;
        if (z) {
        }
    }

    private final int getRealHeight(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean] */
    public final boolean isHWConcaveScreen(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = sIsHwConcaveScreen;
        ?? r2 = 0;
        if (i != -1) {
            return i == 1;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Object invoke = loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Boolean");
            r2 = ((Boolean) invoke).booleanValue();
        } catch (Exception unused) {
        }
        sIsHwConcaveScreen = r2;
        return r2;
    }

    public final int getHWConcaveScreenHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i = sHWConcaveScreenHeight;
        if (i != -1) {
            return i;
        }
        int i2 = getNotchSize(context)[1];
        if (i2 <= 0) {
            i2 = (int) UIUtils.INSTANCE.dip2Px(context, 28);
        }
        sHWConcaveScreenHeight = i2;
        return i2;
    }

    public final int getHWConcaveScreenWidht(Context context) {
        return getNotchSize(context)[0];
    }

    private final int[] getNotchSize(Context context) {
        int[] iArr = {0, 0};
        if (context == null) {
            return iArr;
        }
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            Object invoke = loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.IntArray");
            return (int[]) invoke;
        } catch (Exception unused) {
            return iArr;
        }
    }
}
