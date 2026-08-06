package com.bytedance.ies.bullet.p003ui.common.utils;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.anniex.container.util.ImmersedStatusBarUtils;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusBarUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0015\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013H\u0000¢\u0006\u0002\b\u0014J\u0015\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b\u0016J\u0010\u0010\u0017\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0017\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0001¢\u0006\u0002\b\u001bJ\u0018\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u001d\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010 J\u001d\u0010!\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u0004H\u0000¢\u0006\u0002\b#J\u001d\u0010!\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\u0004H\u0000¢\u0006\u0002\b#J\u0015\u0010$\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0000¢\u0006\u0002\b%J)\u0010&\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010'\u001a\u00020\nH\u0000¢\u0006\u0002\b(R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\n8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006)"}, d2 = {"Lcom/bytedance/ies/bullet/ui/common/utils/StatusBarUtil;", "", "()V", "FLAG_NOTCH_PORTRAIT", "", "getFLAG_NOTCH_PORTRAIT", "()I", "FLAG_NOTCH_SUPPORT", "getFLAG_NOTCH_SUPPORT", "isSupportImmersion", "", "isSupportImmersion$anniex_release", "()Z", "disableLayoutFullscreen", "", "activity", "Landroid/app/Activity;", "getStatusBarHeight", "context", "Landroid/content/Context;", "getStatusBarHeight$anniex_release", "hideStatusBar", "hideStatusBar$anniex_release", "isLayoutFullscreen", "setFullScreenWindowLayoutInDisplayCutout", "window", "Landroid/view/Window;", "setFullScreenWindowLayoutInDisplayCutout$anniex_release", "setMiuiStatusBarDarkMode", "darkmode", "setStatusBarBgColor", "color", "(Landroid/view/Window;Ljava/lang/Integer;)V", "setStatusBarColor", "targetColor", "setStatusBarColor$anniex_release", "showStatusBar", "showStatusBar$anniex_release", "trySetStatusBar", "useDarkMode", "trySetStatusBar$anniex_release", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public final class StatusBarUtil {
    public static final StatusBarUtil INSTANCE = new StatusBarUtil();
    private static final int FLAG_NOTCH_SUPPORT = 256;
    private static final int FLAG_NOTCH_PORTRAIT = 512;

    public final boolean isSupportImmersion$anniex_release() {
        return true;
    }

    private StatusBarUtil() {
    }

    public final int getFLAG_NOTCH_SUPPORT() {
        return FLAG_NOTCH_SUPPORT;
    }

    public final int getFLAG_NOTCH_PORTRAIT() {
        return FLAG_NOTCH_PORTRAIT;
    }

    public final void trySetStatusBar$anniex_release(Activity activity, Window window, boolean useDarkMode) {
        if (activity == null || window == null) {
            return;
        }
        try {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (!useDarkMode) {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility | 8192);
            }
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
            if (OSUtils.isMIUI6Later()) {
                setMiuiStatusBarDarkMode(useDarkMode, window);
            }
            if (OSUtils.isFlymeOS4Later()) {
                FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(activity, useDarkMode);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setMiuiStatusBarDarkMode(boolean darkmode, Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            Class<?> cls = window.getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(darkmode ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method.invoke(window, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void setStatusBarBgColor(Window window, Integer color) {
        Object obj;
        Unit unit;
        Intrinsics.checkNotNullParameter(window, "window");
        try {
            Result.Companion companion = Result.Companion;
            if (color != null) {
                color.intValue();
                ImmersedStatusBarUtils.enableTransparentStatusBar(window);
                ImmersedStatusBarUtils.disableLayoutFullscreen(window);
                ImmersedStatusBarUtils.setStatusBarColor(window, color.intValue());
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            obj = Result.constructor-impl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            HybridLogger.e$default(HybridLogger.INSTANCE, "StatusBarAndNavImp", "setStatusBarBgColor: " + th2.getMessage(), null, null, 12, null);
        }
    }

    public final void showStatusBar$anniex_release(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().clearFlags(1024);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void hideStatusBar$anniex_release(Activity activity) {
        boolean z;
        Object invoke;
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().setFlags(1024, 1024);
        try {
            Class<?> loadClass = activity.getApplicationContext().getClassLoader().loadClass("android.os.SystemProperties");
            invoke = loadClass.getMethod("getInt", String.class, Integer.TYPE).invoke(loadClass, "ro.miui.notch", 0);
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (((Integer) invoke).intValue() == 1) {
            if (Build.VERSION.SDK_INT < 28) {
                z = true;
                if (z) {
                    return;
                }
                int i = FLAG_NOTCH_SUPPORT | FLAG_NOTCH_PORTRAIT;
                try {
                    Class cls = Integer.TYPE;
                    Intrinsics.checkNotNull(cls);
                    Window.class.getMethod("addExtraFlags", cls).invoke(activity.getWindow(), Integer.valueOf(i));
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        }
        z = false;
        if (z) {
        }
    }

    public final void setStatusBarColor$anniex_release(Activity activity, int targetColor) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().setStatusBarColor(targetColor);
        View findViewById = activity.getWindow().findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "activity.window.findViewById(android.R.id.content)");
        findViewById.setForeground(null);
    }

    public final void setStatusBarColor$anniex_release(Window window, int targetColor) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(targetColor);
        View findViewById = window.findViewById(R.id.content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "window.findViewById(android.R.id.content)");
        findViewById.setForeground(null);
    }

    public final void setFullScreenWindowLayoutInDisplayCutout$anniex_release(Window window) {
        if (window == null || Build.VERSION.SDK_INT < 28) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 1;
        window.setAttributes(attributes);
    }

    public final int getStatusBarHeight$anniex_release(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return BaseStatusBarUtil.INSTANCE.getStatusBarHeight(context);
    }

    public final void disableLayoutFullscreen(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null || !INSTANCE.isLayoutFullscreen(activity)) {
            return;
        }
        View decorView = window.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
        decorView.setSystemUiVisibility(BitOperationUtils.INSTANCE.clearFlag(decorView.getSystemUiVisibility(), 1024));
    }

    public final boolean isLayoutFullscreen(Activity activity) {
        return activity != null && BitOperationUtils.INSTANCE.hasFlag(activity.getWindow().getDecorView().getSystemUiVisibility(), 1024);
    }
}
