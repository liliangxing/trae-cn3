package com.bytedance.ies.bullet.p003ui.common.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import com.bytedance.ies.bullet.base.utils.RomUtils;
import com.bytedance.ies.bullet.core.util.ContextUtil;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ViewUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/ViewUtil;", "", "()V", "getScreenInfo", "Lcom/bytedance/ies/bullet/ui/common/utils/ScreenInfo;", "context", "Landroid/content/Context;", "isInMultiWindowMode", "", "isInMultiWindowModeCheckOppo", "isPortrait", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class ViewUtil {
    public static final ViewUtil INSTANCE = new ViewUtil();

    private ViewUtil() {
    }

    public final ScreenInfo getScreenInfo(Context context) {
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
                    return new ScreenInfo(point.x, point.y);
                }
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            return new ScreenInfo(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Object obj = Result.constructor-impl(ResultKt.createFailure(th));
            return (ScreenInfo) (Result.isFailure-impl(obj) ? null : obj);
        }
    }

    public final boolean isPortrait(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getConfiguration().orientation == 1;
    }

    public final boolean isInMultiWindowMode(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (RomUtils.isOppo()) {
            return isInMultiWindowModeCheckOppo(context);
        }
        if (context instanceof Activity) {
            return ((Activity) context).isInMultiWindowMode();
        }
        return false;
    }

    private final boolean isInMultiWindowModeCheckOppo(Context context) {
        if (Build.VERSION.SDK_INT < 30) {
            return false;
        }
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowMetrics currentWindowMetrics = ((WindowManager) systemService).getCurrentWindowMetrics();
        Intrinsics.checkNotNullExpressionValue(currentWindowMetrics, "localWindowManager.currentWindowMetrics");
        int height = currentWindowMetrics.getBounds().height();
        int width = currentWindowMetrics.getBounds().width();
        Activity ownerActivity = ContextUtil.INSTANCE.getOwnerActivity(context);
        Display display = ownerActivity != null ? ownerActivity.getDisplay() : null;
        if (display != null) {
            return (width == display.getMode().getPhysicalWidth() && height == display.getMode().getPhysicalHeight()) ? false : true;
        }
        return false;
    }
}
