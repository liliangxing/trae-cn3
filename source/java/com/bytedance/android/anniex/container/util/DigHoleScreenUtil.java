package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DigHoleScreenUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007J\"\u0010\n\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007¨\u0006\r"}, d2 = {"Lcom/bytedance/android/anniex/container/util/DigHoleScreenUtil;", "", "()V", "isAllScreenForAndroidP", "", "activityContext", "Landroid/content/Context;", "isCutOut", "context", "isDigHole", "isNeedStatusBarAdapt", "isPortrait", "isAnchor", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class DigHoleScreenUtil {
    public static final DigHoleScreenUtil INSTANCE = new DigHoleScreenUtil();

    private DigHoleScreenUtil() {
    }

    @JvmStatic
    public static final boolean isNeedStatusBarAdapt(Context context, boolean isPortrait, boolean isAnchor) {
        if (!StatusBarUtils.INSTANCE.getSTATUS_BAR_ADAPT_ENABLE() || !StatusBarUtils.INSTANCE.getJUMP_FROM_LIVE_PLAY_ACTIVITY()) {
            return isDigHole(context);
        }
        if (!isPortrait || isAnchor) {
            return isDigHole(context);
        }
        return true;
    }

    @JvmStatic
    public static final boolean isDigHole(Context context) {
        if (context == null) {
            return false;
        }
        DigHoleScreenUtil digHoleScreenUtil = INSTANCE;
        return digHoleScreenUtil.isAllScreenForAndroidP(context) || digHoleScreenUtil.isCutOut(context);
    }

    private final boolean isAllScreenForAndroidP(Context activityContext) {
        if (!(activityContext instanceof Activity) || Build.VERSION.SDK_INT < 28) {
            return false;
        }
        View decorView = ((Activity) activityContext).getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "activityContext.window.decorView");
        try {
            Object invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
            Object invoke2 = invoke.getClass().getDeclaredMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]);
            Object invoke3 = invoke2.getClass().getMethod("getBoundingRects", new Class[0]).invoke(invoke2, new Object[0]);
            Intrinsics.checkNotNull(invoke3, "null cannot be cast to non-null type kotlin.collections.List<android.graphics.Rect>");
            return ((List) invoke3).size() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private final boolean isCutOut(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", "string", "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string != null) {
                return !TextUtils.isEmpty(string);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
