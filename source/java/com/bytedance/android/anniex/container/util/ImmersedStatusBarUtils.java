package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.bytedance.ies.bullet.base.utils.RomUtils;
import com.bytedance.ies.bullet.ui.common.utils.BitOperationUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class ImmersedStatusBarUtils {
    public static final int STATUS_BAR_ALPHA_20 = 51;
    private static Field sMeizuDarkFlag;
    private static Field sMeizuFlags;
    private static Field sMiuiDarkMode;
    private static Method sSetExtraFlags;

    public static int calculateStatusColor(int i, int i2) {
        float f = 1.0f - (i2 / 255.0f);
        return ((int) (((i & 255) * f) + 0.5d)) | (((int) ((((i >> 16) & 255) * f) + 0.5d)) << 16) | ViewCompat.MEASURED_STATE_MASK | (((int) ((((i >> 8) & 255) * f) + 0.5d)) << 8);
    }

    public static boolean canUseTransparentStateBar() {
        return true;
    }

    private ImmersedStatusBarUtils() {
    }

    public static void disableImmersiveMode(Activity activity) {
        if (activity == null) {
            return;
        }
        disableImmersiveMode(activity.getWindow());
    }

    public static void disableImmersiveMode(Window window) {
        if (window == null) {
            return;
        }
        window.clearFlags(Integer.MIN_VALUE);
    }

    public static void enableImmersiveMode(Activity activity) {
        if (activity == null) {
            return;
        }
        enableImmersiveMode(activity.getWindow());
    }

    public static void enableImmersiveMode(Window window) {
        if (window == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
    }

    public static void enableTranslucentMode(Activity activity) {
        if (activity == null) {
            return;
        }
        enableTranslucentMode(activity.getWindow());
    }

    public static void enableTranslucentMode(Window window) {
        if (window == null) {
            return;
        }
        window.addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
    }

    private static void enableTransparentStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        enableTransparentStatusBar(activity.getWindow());
    }

    public static void enableTransparentStatusBar(Window window) {
        if (window != null) {
            window.addFlags(Integer.MIN_VALUE);
            window.clearFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            window.setStatusBarColor(0);
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | getNormalSystemUiFlags());
        }
    }

    public static void adjustEnterFullScreen(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        enterFullScreenForJellyBean(window, window.getDecorView(), 0);
    }

    private static void enterFullScreenForJellyBean(Window window, View view, int i) {
        if (window == null || view == null) {
            return;
        }
        if (hasWindowFullscreenFlag(window)) {
            window.clearFlags(1024);
        }
        int systemUiVisibility = view.getSystemUiVisibility();
        int i2 = i != 0 ? 5124 | i : 5124;
        if (systemUiVisibility != i2) {
            view.setSystemUiVisibility(i2);
        }
    }

    private static void exitFullScreenForJellyBean(Window window, View view, boolean z) {
        if (window == null || view == null) {
            return;
        }
        if (hasWindowFullscreenFlag(window)) {
            window.clearFlags(1024);
        }
        int systemUiVisibility = view.getSystemUiVisibility();
        int normalSystemUiFlags = getNormalSystemUiFlags();
        if (systemUiVisibility != normalSystemUiFlags) {
            view.setSystemUiVisibility(normalSystemUiFlags);
        }
    }

    private static int getNormalSystemUiFlags() {
        return canUseTransparentStateBar() ? 1280 : 256;
    }

    public static void enterFullScreen(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        enterFullScreenForJellyBean(window, window.getDecorView(), 0);
    }

    public static void enterFullScreen(Dialog dialog) {
        Window window;
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        enterFullScreenForJellyBean(window, window.getDecorView(), 0);
    }

    public static void enterFullScreenHideNavigation(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        enterFullScreenForJellyBean(window, window.getDecorView(), 514);
    }

    public static void exitFullScreen(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        exitFullScreenForJellyBean(window, window.getDecorView(), false);
    }

    public static boolean hasWindowFullscreenFlag(Window window) {
        return (window == null || window.getAttributes() == null || (window.getAttributes().flags & 1024) != 1024) ? false : true;
    }

    public static void adjustMaterialTheme(Activity activity) {
        if (activity == null) {
            return;
        }
        if (canUseTransparentStateBar()) {
            enableTransparentStatusBar(activity);
        } else {
            SystemUiUtils.appendSystemUiFlags(activity, 256);
        }
    }

    public static void setStatusBarLightMode(Activity activity) {
        setStatusBarLightMode(activity.getWindow(), (Boolean) true);
    }

    public static void setStatusBarLightMode(Activity activity, Boolean bool) {
        if (activity == null) {
            return;
        }
        setStatusBarLightMode(activity.getWindow(), bool);
    }

    public static void setStatusBarLightMode(Window window) {
        setStatusBarLightMode(window, (Boolean) true);
    }

    public static void setStatusBarLightMode(Window window, Boolean bool) {
        if (window == null || window.getDecorView() == null) {
            return;
        }
        if (bool.booleanValue()) {
            SystemUiUtils.appendSystemUiFlags(window, 9216);
        } else {
            SystemUiUtils.appendSystemUiFlags(window, 8192);
        }
        setMiuiStatusBarLightMode(window, true);
        setFlymeStatusBarLightMode(window, true);
    }

    public static void setStatusBarColorAdjustTextColor(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        setStatusBarColorAdjustTextColor(activity.getWindow(), i);
    }

    public static void setStatusBarColorAdjustTextColor(Window window, int i) {
        if (window != null) {
            setStatusBarColor(window, i);
            adjustStatusBarTextColorBasedOnStatusColor(window, i);
        }
    }

    public static void setStatusBarTransparentAdjustTextColor(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        setStatusBarTransparentAdjustTextColor(activity.getWindow(), i);
    }

    public static void setStatusBarTransparentAdjustTextColor(Window window, int i) {
        if (window != null) {
            setStatusBarColor(window, 0);
            adjustStatusBarTextColorBasedOnStatusColor(window, i);
        }
    }

    public static void adjustStatusBarTextColorBasedOnStatusColor(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        adjustStatusBarTextColorBasedOnStatusColor(activity.getWindow(), i);
    }

    public static void adjustStatusBarTextColorBasedOnStatusColor(Window window, int i) {
        if (window != null) {
            if (isLightColor(i)) {
                setStatusBarLightMode(window);
            } else {
                setStatusBarDarkMode(window);
            }
        }
    }

    public static boolean isLightColor(int i) {
        return 1.0d - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / 255.0d) < 0.22d;
    }

    public static void setStatusBarTransparentAdjustTextColorWithDefaultBaseColor(Activity activity) {
        if (activity == null) {
            return;
        }
        setStatusBarTransparentAdjustTextColorWithDefaultBaseColor(activity.getWindow());
    }

    public static void setStatusBarTransparentAdjustTextColorWithDefaultBaseColor(Window window) {
        if (window != null) {
            setStatusBarTransparentAdjustTextColor(window, -1);
        }
    }

    public static void setStatusBarDarkMode(Activity activity) {
        if (activity == null) {
            return;
        }
        setStatusBarDarkMode(activity.getWindow());
    }

    public static void setStatusBarDarkMode(Window window) {
        if (window == null || window.getDecorView() == null) {
            return;
        }
        SystemUiUtils.clearSystemUiFlags(window, 8192);
        setMiuiStatusBarLightMode(window, false);
        setFlymeStatusBarLightMode(window, false);
    }

    public static void disableLayoutFullscreen(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null || !isLayoutFullscreen(activity)) {
            return;
        }
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(BitOperationUtils.INSTANCE.clearFlag(decorView.getSystemUiVisibility(), 1024));
    }

    public static void disableLayoutFullscreen(Window window) {
        if (window == null || window == null || !isLayoutFullscreen(window)) {
            return;
        }
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility(BitOperationUtils.INSTANCE.clearFlag(decorView.getSystemUiVisibility(), 1024));
    }

    public static boolean isLayoutFullscreen(Window window) {
        return window != null && BitOperationUtils.INSTANCE.hasFlag(window.getDecorView().getSystemUiVisibility(), 1024);
    }

    public static boolean isLayoutFullscreen(Activity activity) {
        return activity != null && BitOperationUtils.INSTANCE.hasFlag(activity.getWindow().getDecorView().getSystemUiVisibility(), 1024);
    }

    private static boolean setFlymeStatusBarLightMode(Window window, boolean z) {
        if (window != null && RomUtils.isFlyme()) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                if (sMeizuDarkFlag == null) {
                    Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                    sMeizuDarkFlag = declaredField;
                    declaredField.setAccessible(true);
                }
                if (sMeizuFlags == null) {
                    Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                    sMeizuFlags = declaredField2;
                    declaredField2.setAccessible(true);
                }
                int i = sMeizuDarkFlag.getInt(null);
                int i2 = sMeizuFlags.getInt(attributes);
                sMeizuFlags.setInt(attributes, z ? i2 | i : (~i) & i2);
                window.setAttributes(attributes);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private static boolean setMiuiStatusBarLightMode(Window window, boolean z) {
        if (window == null) {
            return false;
        }
        try {
            if (!RomUtils.isMiui()) {
                return false;
            }
            Class<?> cls = window.getClass();
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            if (sMiuiDarkMode == null || sSetExtraFlags == null) {
                Field field = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE");
                sMiuiDarkMode = field;
                field.setAccessible(true);
                Method method = cls.getMethod("setExtraFlags", Integer.TYPE, Integer.TYPE);
                sSetExtraFlags = method;
                method.setAccessible(true);
            }
            int i = sMiuiDarkMode.getInt(cls2);
            Method method2 = sSetExtraFlags;
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(z ? i : 0);
            objArr[1] = Integer.valueOf(i);
            method2.invoke(window, objArr);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int getCurrentStatusBarColor(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return -1;
        }
        return window.getStatusBarColor();
    }

    public static void setStatusBarColor(Activity activity, int i) {
        if (activity != null) {
            setStatusBarColor(activity.getWindow(), i);
        }
    }

    public static void setStatusBarColor(Window window, int i) {
        if (window == null || window.getStatusBarColor() == i) {
            return;
        }
        window.setStatusBarColor(i);
    }

    public static void setFitsSystemWindows(View view) {
        if (view != null) {
            ViewCompat.setOnApplyWindowInsetsListener(view, new OnApplyWindowInsetsListener() { // from class: com.bytedance.android.anniex.container.util.ImmersedStatusBarUtils.1
                @Override // androidx.core.view.OnApplyWindowInsetsListener
                public WindowInsetsCompat onApplyWindowInsets(View view2, WindowInsetsCompat windowInsetsCompat) {
                    if (windowInsetsCompat.getSystemWindowInsetTop() != 0) {
                        windowInsetsCompat = windowInsetsCompat.replaceSystemWindowInsets(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                    }
                    return ViewCompat.onApplyWindowInsets(view2, windowInsetsCompat);
                }
            });
            ViewCompat.setFitsSystemWindows(view, true);
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class ImmerseStatusBarView extends View {
        public ImmerseStatusBarView(Context context) {
            super(context);
        }

        public ImmerseStatusBarView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public ImmerseStatusBarView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }
    }
}
