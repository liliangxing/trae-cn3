package com.bytedance.sdk.xbridge.cn.p003ui.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ies.bullet.service.popup.ui.AbsPopupFragment;
import com.bytedance.sdk.xbridge.cn.media.utils.FConstants;
import com.bytedance.sdk.xbridge.cn.registry.core.exception.IllegalInputParamException;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: StatusBarUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0004H\u0002J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0004J\u001e\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\u0004J\u001a\u0010\u0019\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007J\"\u0010\u0019\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007J\u0016\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0010\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u000e\u0010 \u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010!\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010!\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\"\u0010\"\u001a\u00020\u00112\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020$J\u0018\u0010\"\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010#\u001a\u00020$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/ui/utils/StatusBarUtils;", "", "()V", "FLAG_NOTCH_PORTRAIT", "", "FLAG_NOTCH_SUPPORT", "convertColor", "", "color", "createStatusBarView", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "getStatusBarHeight", "context", "Landroid/content/Context;", "hideStatusBar", "", "parseColor", "setColor", "window", "Landroid/view/Window;", "setColorForDrawerLayout", "drawerLayout", "Landroidx/drawerlayout/widget/DrawerLayout;", "setStatusBarBgColor", "bgColor", "setStatusBarColor", "targetColor", "setTranslucent", "setTranslucentForDrawerLayout", "setTransparent", "setTransparentSystemUI", "showStatusBar", "trySetStatusBar", "useDarkMode", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class StatusBarUtils {
    public static final int FLAG_NOTCH_PORTRAIT = 512;
    public static final int FLAG_NOTCH_SUPPORT = 256;
    public static final StatusBarUtils INSTANCE = new StatusBarUtils();

    private StatusBarUtils() {
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0059 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void hideStatusBar(Activity activity) {
        boolean z;
        Object invoke;
        if (activity == null) {
            return;
        }
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
                try {
                    Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 768);
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

    public final void trySetStatusBar(Activity activity, Window window, boolean useDarkMode) {
        View decorView;
        Dialog dialog;
        Window window2;
        FragmentManager supportFragmentManager;
        if (activity == null || window == null) {
            return;
        }
        try {
            FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
            Fragment findFragmentByTag = (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag("BulletPopUp");
            AbsPopupFragment absPopupFragment = findFragmentByTag instanceof AbsPopupFragment ? (AbsPopupFragment) findFragmentByTag : null;
            if (absPopupFragment == null || (dialog = absPopupFragment.getDialog()) == null || (window2 = dialog.getWindow()) == null || (decorView = window2.getDecorView()) == null) {
                decorView = window.getDecorView();
            }
            Intrinsics.checkNotNullExpressionValue(decorView, "((activity as? FragmentA…      ?: window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (!useDarkMode) {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility | FConstants.DOWNLOAD_BUFFER_SIZE);
            }
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void trySetStatusBar(Window window, boolean useDarkMode) {
        if (window == null) {
            return;
        }
        try {
            View decorView = window.getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "window.decorView");
            int systemUiVisibility = decorView.getSystemUiVisibility();
            if (!useDarkMode) {
                decorView.setSystemUiVisibility(systemUiVisibility & (-8193));
            } else {
                decorView.setSystemUiVisibility(systemUiVisibility | FConstants.DOWNLOAD_BUFFER_SIZE);
            }
            window.clearFlags(67108864);
            window.addFlags(Integer.MIN_VALUE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void showStatusBar(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(1024);
    }

    public final void showStatusBar(Window window) {
        if (window != null) {
            window.clearFlags(1024);
        }
    }

    public final void setStatusBarColor(Activity activity, int targetColor) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().setStatusBarColor(targetColor);
    }

    public final void setColor(Window window, Context context, int color) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(context, "context");
        window.addFlags(67108864);
        View createStatusBarView = createStatusBarView((Activity) context, color);
        View decorView = window.getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) decorView).addView(createStatusBarView);
        View findViewById = window.getDecorView().findViewById(R.id.content);
        ViewGroup viewGroup = findViewById instanceof ViewGroup ? (ViewGroup) findViewById : null;
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                viewGroup2.setFitsSystemWindows(true);
            }
            if (viewGroup2 == null) {
                return;
            }
            viewGroup2.setClipToPadding(true);
        }
    }

    public final void setColor(Activity activity, int color) {
        Window window;
        Dialog dialog;
        FragmentManager supportFragmentManager;
        Intrinsics.checkNotNullParameter(activity, "activity");
        FragmentActivity fragmentActivity = activity instanceof FragmentActivity ? (FragmentActivity) activity : null;
        Fragment findFragmentByTag = (fragmentActivity == null || (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) == null) ? null : supportFragmentManager.findFragmentByTag("BulletPopUp");
        AbsPopupFragment absPopupFragment = findFragmentByTag instanceof AbsPopupFragment ? (AbsPopupFragment) findFragmentByTag : null;
        if (absPopupFragment == null || (dialog = absPopupFragment.getDialog()) == null || (window = dialog.getWindow()) == null) {
            window = activity.getWindow();
        }
        window.addFlags(67108864);
        View createStatusBarView = createStatusBarView(activity, color);
        View decorView = window.getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) decorView).addView(createStatusBarView);
        View findViewById = activity.findViewById(R.id.content);
        ViewGroup viewGroup = findViewById instanceof ViewGroup ? (ViewGroup) findViewById : null;
        if (viewGroup != null) {
            View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
            ViewGroup viewGroup2 = childAt instanceof ViewGroup ? (ViewGroup) childAt : null;
            if (viewGroup2 != null) {
                viewGroup2.setFitsSystemWindows(true);
            }
            if (viewGroup2 == null) {
                return;
            }
            viewGroup2.setClipToPadding(true);
        }
    }

    public final void setTranslucent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().addFlags(67108864);
    }

    public final void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int color) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(drawerLayout, "drawerLayout");
        activity.getWindow().addFlags(67108864);
        View createStatusBarView = createStatusBarView(activity, color);
        View childAt = drawerLayout.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) childAt;
        viewGroup.addView(createStatusBarView, 0);
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
        }
        View childAt2 = drawerLayout.getChildAt(1);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) childAt2).setFitsSystemWindows(false);
    }

    public final void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(drawerLayout, "drawerLayout");
        activity.getWindow().addFlags(67108864);
        View childAt = drawerLayout.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) childAt;
        viewGroup.setFitsSystemWindows(true);
        viewGroup.setClipToPadding(true);
        View childAt2 = drawerLayout.getChildAt(1);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) childAt2).setFitsSystemWindows(false);
        drawerLayout.setFitsSystemWindows(false);
    }

    private final View createStatusBarView(Activity activity, int color) {
        Activity activity2 = activity;
        View view = new View(activity2);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity2)));
        view.setBackgroundColor(color);
        return view;
    }

    public final int getStatusBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    @Deprecated(message = "")
    public final void setTransparent(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(1280);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public final void setTransparentSystemUI(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Window window = activity.getWindow();
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | FLAG_NOTCH_SUPPORT);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public final void setStatusBarBgColor(Activity activity, String bgColor) {
        if (activity != null) {
            String str = bgColor;
            if (str == null || str.length() == 0) {
                return;
            }
            setColor(activity, Color.parseColor(parseColor(bgColor)));
        }
    }

    public final void setStatusBarBgColor(Window window, Context context, String bgColor) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (window != null) {
            String str = bgColor;
            if (str == null || str.length() == 0) {
                return;
            }
            setColor(window, context, Color.parseColor(parseColor(bgColor)));
        }
    }

    public final String parseColor(String color) {
        if (color == null) {
            return null;
        }
        int length = color.length();
        if (StringsKt.startsWith$default(color, '#', false, 2, (Object) null)) {
            if (length == 7) {
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                String upperCase = color.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
                return upperCase;
            }
            if (length == 9) {
                String substring = color.substring(1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return String.valueOf('#') + convertColor(substring);
            }
        }
        if (length != 6) {
            if (length == 8) {
                return String.valueOf('#') + convertColor(color);
            }
            throw new IllegalInputParamException("color:" + color + " is illegal，please use supported formats: #RRGGBB,#RRGGBBAA,RRGGBB,RRGGBBAA");
        }
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
        String upperCase2 = color.toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
        return String.valueOf('#') + upperCase2;
    }

    private final String convertColor(String color) {
        if (color.length() != 8) {
            return color;
        }
        StringBuilder sb = new StringBuilder();
        if (color == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring = color.substring(6, 8);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
        if (substring == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase = substring.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        StringBuilder append = sb.append(upperCase);
        if (color == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String substring2 = color.substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Locale locale2 = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale2, "ROOT");
        if (substring2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String upperCase2 = substring2.toUpperCase(locale2);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "(this as java.lang.String).toUpperCase(locale)");
        return append.append(upperCase2).toString();
    }
}
