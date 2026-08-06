package com.bytedance.sdk.open.aweme.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.open.aweme.R;
import com.lynx.canvas.camera.CameraSize;
import com.ss.mediakit.medialoader.AVMDLDataLoader;

/* loaded from: classes5.dex */
public final class ViewUtils {
    public static final int STATUS_BAR_VIEW_ID = R.id.statusbar_status_bar_view;
    public static final int IMAGE_VIEW_OFFSET = R.id.statusbar_image_view_offset;

    private ViewUtils() {
        throw new IllegalStateException("no instance.");
    }

    private static void addTranslucentView(Activity activity, int i) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        View findViewById = viewGroup.findViewById(STATUS_BAR_VIEW_ID);
        if (findViewById == null) {
            viewGroup.addView(createStatusBarView(activity, Color.argb(i, 0, 0, 0)));
            return;
        }
        if (findViewById.getVisibility() == 8) {
            findViewById.setVisibility(0);
        }
        findViewById.setBackgroundColor(Color.argb(i, 0, 0, 0));
    }

    private static View createStatusBarView(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new ViewGroup.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(i);
        view.setId(STATUS_BAR_VIEW_ID);
        return view;
    }

    public static int getStatusBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    private static void setRootView(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(true);
                ((ViewGroup) childAt).setClipToPadding(true);
            }
        }
    }

    public static void setStatusBarColor(Activity activity, int i) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().setStatusBarColor(i);
    }

    public static void setStatusBarDarkMode(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(1024);
    }

    public static void setStatusBarLightMode(Activity activity) {
        activity.getWindow().getDecorView().setSystemUiVisibility(AVMDLDataLoader.KeyIsLoaderCacheSize);
    }

    public static void setStatusBarTranslucentForImageView(Activity activity, int i, View view) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().getDecorView().setSystemUiVisibility(CameraSize.highHeight);
        activity.getWindow().setStatusBarColor(0);
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof ViewGroup) {
                childAt.setFitsSystemWindows(false);
            }
        }
        addTranslucentView(activity, i);
        if (view != null) {
            int i3 = IMAGE_VIEW_OFFSET;
            Object tag = view.getTag(i3);
            if (tag == null || !((Boolean) tag).booleanValue()) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin + getStatusBarHeight(activity), marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
                view.setTag(i3, Boolean.TRUE);
            }
        }
    }

    public static void setTranslucentStatusBar(Activity activity, int i) {
        setTransparent(activity);
        addTranslucentView(activity, i);
    }

    public static void setTransparent(Activity activity) {
        activity.getWindow().addFlags(Integer.MIN_VALUE);
        activity.getWindow().clearFlags(67108864);
        activity.getWindow().setStatusBarColor(0);
        setRootView(activity);
    }
}
