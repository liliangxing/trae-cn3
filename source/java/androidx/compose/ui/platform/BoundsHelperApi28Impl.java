package androidx.compose.ui.platform;

import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.view.DisplayCutout;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidWindowInfo.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0017¨\u0006\b"}, d2 = {"Landroidx/compose/ui/platform/BoundsHelperApi28Impl;", "Landroidx/compose/ui/platform/BoundsHelper;", "<init>", "()V", "currentWindowBounds", "Landroid/graphics/Rect;", "activity", "Landroid/app/Activity;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class BoundsHelperApi28Impl implements BoundsHelper {
    public static final BoundsHelperApi28Impl INSTANCE = new BoundsHelperApi28Impl();

    private BoundsHelperApi28Impl() {
    }

    @Override // androidx.compose.ui.platform.BoundsHelper
    public Rect currentWindowBounds(Activity activity) {
        DisplayCutout access$getCutoutForDisplay;
        Rect rect = new Rect();
        Configuration configuration = activity.getResources().getConfiguration();
        try {
            Field declaredField = Configuration.class.getDeclaredField("windowConfiguration");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(configuration);
            if (activity.isInMultiWindowMode()) {
                Object invoke = obj.getClass().getDeclaredMethod("getBounds", new Class[0]).invoke(obj, new Object[0]);
                Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke);
            } else {
                Object invoke2 = obj.getClass().getDeclaredMethod("getAppBounds", new Class[0]).invoke(obj, new Object[0]);
                Intrinsics.checkNotNull(invoke2, "null cannot be cast to non-null type android.graphics.Rect");
                rect.set((Rect) invoke2);
            }
        } catch (Exception e) {
            if ((e instanceof NoSuchFieldException) || (e instanceof NoSuchMethodException) || (e instanceof IllegalAccessException) || (e instanceof InvocationTargetException)) {
                AndroidWindowInfo_androidKt.access$getRectSizeFromDisplay(activity, rect);
            } else {
                throw e;
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (!activity.isInMultiWindowMode()) {
            int access$getNavigationBarHeight = AndroidWindowInfo_androidKt.access$getNavigationBarHeight(activity);
            if (rect.bottom + access$getNavigationBarHeight == point.y) {
                rect.bottom += access$getNavigationBarHeight;
            } else if (rect.right + access$getNavigationBarHeight == point.x) {
                rect.right += access$getNavigationBarHeight;
            } else if (rect.left == access$getNavigationBarHeight) {
                rect.left = 0;
            }
        }
        if ((rect.width() < point.x || rect.height() < point.y) && !activity.isInMultiWindowMode() && (access$getCutoutForDisplay = AndroidWindowInfo_androidKt.access$getCutoutForDisplay(defaultDisplay)) != null) {
            if (rect.left == access$getCutoutForDisplay.getSafeInsetLeft()) {
                rect.left = 0;
            }
            if (point.x - rect.right == access$getCutoutForDisplay.getSafeInsetRight()) {
                rect.right += access$getCutoutForDisplay.getSafeInsetRight();
            }
            if (rect.top == access$getCutoutForDisplay.getSafeInsetTop()) {
                rect.top = 0;
            }
            if (point.y - rect.bottom == access$getCutoutForDisplay.getSafeInsetBottom()) {
                rect.bottom += access$getCutoutForDisplay.getSafeInsetBottom();
            }
        }
        return rect;
    }
}
