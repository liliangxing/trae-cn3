package com.bytedance.android.anniex.container.util;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import com.lynx.canvas.camera.CameraSize;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StatusBarUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u0006\u0010\"\u001a\u00020\u0014J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010&\u001a\u00020\u00142\b\u0010 \u001a\u0004\u0018\u00010!J\u0010\u0010'\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u0010)\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u000e\u0010)\u001a\u00020(2\u0006\u0010$\u001a\u00020%J\u0010\u0010*\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010*\u001a\u00020(2\u0006\u0010$\u001a\u00020%H\u0002J\u0010\u0010+\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0006\u0010,\u001a\u00020\fJ\u001a\u0010-\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u0018\u0010/\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0014H\u0002J\u001e\u0010/\u001a\u00020(2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!J\u000e\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u0014J\u000e\u00102\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eJ\u000e\u00102\u001a\u00020(2\u0006\u0010$\u001a\u00020%J\u001a\u00103\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u001a\u00103\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010.\u001a\u0004\u0018\u00010\u0004J\u0010\u00104\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00105\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eJ\u0010\u00106\u001a\u00020(2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0012\u00107\u001a\u00020(2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0003J\u0012\u00107\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%H\u0003R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u00068"}, d2 = {"Lcom/bytedance/android/anniex/container/util/StatusBarUtils;", "", "()V", "COLOR_BLACK", "", "COLOR_DARK", "COLOR_LIGHT", "COLOR_STRING_WHITE", "COLOR_TRANSPARENT", "COLOR_WHITE", "DARK_INDICATOR", "JUMP_FROM_LIVE_PLAY_ACTIVITY", "", "getJUMP_FROM_LIVE_PLAY_ACTIVITY", "()Z", "setJUMP_FROM_LIVE_PLAY_ACTIVITY", "(Z)V", "STATUS_BAR_ADAPT_ENABLE", "getSTATUS_BAR_ADAPT_ENABLE", "_statusBarHeight", "", "desiredTopSpaceHeight", "portraitStatusBarHeight", "getPortraitStatusBarHeight", "()I", "setPortraitStatusBarHeight", "(I)V", "createStatusBarView", "Landroid/view/View;", "activity", "Landroid/app/Activity;", "color", "context", "Landroid/content/Context;", "getDesiredTopSpaceHeight", "getStatusBarColor", "window", "Landroid/view/Window;", "getStatusBarHeight", "hideBottomNavigationBar", "", "hideStatusBar", "hideStatusBarInternal", "hideStatusBarOnLollipop", "isStatusBarTransparent", "quitTransparencyBar", "statusFontMode", "setColor", "setDesiredTopSpaceHeight", RXScreenCaptureService.KEY_INDEX, "setStatusBarColor", "setTransparencyBar", "showBottomNavigationBar", "showStatusBar", "showStatusBarInternal", "transparencyBar", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes2.dex */
public final class StatusBarUtils {
    public static final String COLOR_BLACK = "black";
    public static final String COLOR_DARK = "dark";
    public static final String COLOR_LIGHT = "light";
    public static final String COLOR_STRING_WHITE = "white";
    public static final String COLOR_TRANSPARENT = "#00000000";
    public static final String COLOR_WHITE = "white";
    public static final String DARK_INDICATOR = "dark";
    private static boolean JUMP_FROM_LIVE_PLAY_ACTIVITY;
    private static int _statusBarHeight;
    private static int desiredTopSpaceHeight;
    private static int portraitStatusBarHeight;
    public static final StatusBarUtils INSTANCE = new StatusBarUtils();
    private static final boolean STATUS_BAR_ADAPT_ENABLE = true;

    private StatusBarUtils() {
    }

    public final void quitTransparencyBar(Activity activity, String statusFontMode) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "activity.window");
        window.clearFlags(Integer.MIN_VALUE);
        window.addFlags(2048);
        window.getDecorView().setSystemUiVisibility(0);
        if (Intrinsics.areEqual("light", statusFontMode)) {
            ImmersedStatusBarUtils.setStatusBarDarkMode(activity);
        } else if (Intrinsics.areEqual("dark", statusFontMode)) {
            ImmersedStatusBarUtils.setStatusBarLightMode(activity);
        }
    }

    public final void setTransparencyBar(Activity activity, String statusFontMode) {
        transparencyBar(activity);
        if (Intrinsics.areEqual("light", statusFontMode)) {
            ImmersedStatusBarUtils.setStatusBarDarkMode(activity);
        } else if (Intrinsics.areEqual("dark", statusFontMode)) {
            ImmersedStatusBarUtils.setStatusBarLightMode(activity);
        }
    }

    public final void setTransparencyBar(Window window, String statusFontMode) {
        transparencyBar(window);
        if (Intrinsics.areEqual("light", statusFontMode)) {
            ImmersedStatusBarUtils.setStatusBarDarkMode(window);
        } else if (Intrinsics.areEqual("dark", statusFontMode)) {
            ImmersedStatusBarUtils.setStatusBarLightMode(window);
        }
    }

    private final void transparencyBar(Activity activity) {
        if (activity == null) {
            return;
        }
        Window window = activity.getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(CameraSize.highHeight);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    private final void transparencyBar(Window window) {
        if (window == null) {
            return;
        }
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(CameraSize.highHeight);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public final boolean getSTATUS_BAR_ADAPT_ENABLE() {
        return STATUS_BAR_ADAPT_ENABLE;
    }

    public final void hideStatusBarOnLollipop(Activity activity) {
        hideStatusBar(activity);
    }

    public final void hideStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        hideStatusBarInternal(activity);
    }

    public final void hideStatusBar(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        hideStatusBarInternal(window);
    }

    public final void showStatusBar(Activity activity) {
        if (activity == null) {
            return;
        }
        showStatusBarInternal(activity);
    }

    public final void showBottomNavigationBar(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(0);
    }

    public final void hideBottomNavigationBar(Activity activity) {
        if (activity == null) {
            return;
        }
        activity.getWindow().getDecorView().setSystemUiVisibility(4098);
    }

    private final void hideStatusBarInternal(Activity activity) {
        activity.getWindow().setFlags(1024, 1024);
        setStatusBarColor(activity);
    }

    private final void hideStatusBarInternal(Window window) {
        window.setFlags(1024, 1024);
        setStatusBarColor(window);
    }

    private final void showStatusBarInternal(Activity activity) {
        activity.getWindow().clearFlags(1024);
        setStatusBarColor(activity);
    }

    private final int getStatusBarColor(Activity activity) {
        return activity.getResources().getColor(R.color.transparent);
    }

    private final int getStatusBarColor(Window window) {
        return window.getContext().getResources().getColor(R.color.transparent);
    }

    public final void setStatusBarColor(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        activity.getWindow().setStatusBarColor(getStatusBarColor(activity));
    }

    public final void setStatusBarColor(Window window) {
        Intrinsics.checkNotNullParameter(window, "window");
        window.setStatusBarColor(getStatusBarColor(window));
    }

    public final int getStatusBarHeight(Context context) {
        if (context == null) {
            return 0;
        }
        int i = _statusBarHeight;
        if (i != 0) {
            return i;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
        _statusBarHeight = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public final void setDesiredTopSpaceHeight(int i) {
        desiredTopSpaceHeight = i;
    }

    public final int getDesiredTopSpaceHeight() {
        return desiredTopSpaceHeight;
    }

    private final void setColor(Activity activity, int color) {
        activity.getWindow().addFlags(67108864);
        View createStatusBarView = createStatusBarView(activity, color);
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) decorView).addView(createStatusBarView);
        View findViewById = activity.findViewById(R.id.content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) childAt;
        viewGroup2.setFitsSystemWindows(true);
        viewGroup2.setClipToPadding(true);
    }

    public final void setColor(Window window, int color, Context context) {
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(context, "context");
        window.addFlags(67108864);
        View createStatusBarView = createStatusBarView(context, color);
        View decorView = window.getDecorView();
        Intrinsics.checkNotNull(decorView, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) decorView).addView(createStatusBarView);
        View findViewById = window.getDecorView().findViewById(R.id.content);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup2 = (ViewGroup) childAt;
        viewGroup2.setFitsSystemWindows(true);
        viewGroup2.setClipToPadding(true);
    }

    private final View createStatusBarView(Activity activity, int color) {
        Activity activity2 = activity;
        View view = new View(activity2);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity2)));
        view.setBackgroundColor(color);
        return view;
    }

    private final View createStatusBarView(Context context, int color) {
        View view = new View(context);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(context)));
        view.setBackgroundColor(color);
        return view;
    }

    public final boolean isStatusBarTransparent() {
        return desiredTopSpaceHeight == 0;
    }

    public final boolean getJUMP_FROM_LIVE_PLAY_ACTIVITY() {
        return JUMP_FROM_LIVE_PLAY_ACTIVITY;
    }

    public final void setJUMP_FROM_LIVE_PLAY_ACTIVITY(boolean z) {
        JUMP_FROM_LIVE_PLAY_ACTIVITY = z;
    }

    public final int getPortraitStatusBarHeight() {
        return portraitStatusBarHeight;
    }

    public final void setPortraitStatusBarHeight(int i) {
        portraitStatusBarHeight = i;
    }
}
