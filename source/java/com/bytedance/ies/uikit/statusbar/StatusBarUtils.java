package com.bytedance.ies.uikit.statusbar;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.drawerlayout.widget.DrawerLayout;
import com.lynx.canvas.camera.CameraSize;

/* loaded from: classes4.dex */
public class StatusBarUtils {
    public static void setColor(Activity activity, int i) {
        activity.getWindow().addFlags(67108864);
        ((ViewGroup) activity.getWindow().getDecorView()).addView(createStatusBarView(activity, i));
        ViewGroup viewGroup = (ViewGroup) activity.findViewById(R.id.content);
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.getChildAt(viewGroup.getChildCount() - 1);
        viewGroup2.setFitsSystemWindows(true);
        viewGroup2.setClipToPadding(true);
    }

    public static void setTranslucent(Activity activity) {
        activity.getWindow().addFlags(67108864);
    }

    public static void setColorForDrawerLayout(Activity activity, DrawerLayout drawerLayout, int i) {
        activity.getWindow().addFlags(67108864);
        View createStatusBarView = createStatusBarView(activity, i);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        viewGroup.addView(createStatusBarView, 0);
        if (!(viewGroup instanceof LinearLayout) && viewGroup.getChildAt(1) != null) {
            viewGroup.getChildAt(1).setPadding(0, getStatusBarHeight(activity), 0, 0);
        }
        ViewGroup viewGroup2 = (ViewGroup) drawerLayout.getChildAt(1);
        drawerLayout.setFitsSystemWindows(false);
        viewGroup.setFitsSystemWindows(false);
        viewGroup.setClipToPadding(true);
        viewGroup2.setFitsSystemWindows(false);
    }

    public static void setTranslucentForDrawerLayout(Activity activity, DrawerLayout drawerLayout) {
        activity.getWindow().addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) drawerLayout.getChildAt(0);
        viewGroup.setFitsSystemWindows(true);
        viewGroup.setClipToPadding(true);
        ((ViewGroup) drawerLayout.getChildAt(1)).setFitsSystemWindows(false);
        drawerLayout.setFitsSystemWindows(false);
    }

    private static View createStatusBarView(Activity activity, int i) {
        View view = new View(activity);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, getStatusBarHeight(activity)));
        view.setBackgroundColor(i);
        return view;
    }

    public static int getStatusBarHeight(Context context) {
        return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
    }

    @Deprecated
    public static void setTransparent(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(CameraSize.highHeight);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    public static void setTransparentSystemUI(Activity activity) {
        Window window = activity.getWindow();
        window.clearFlags(201326592);
        window.getDecorView().setSystemUiVisibility(window.getDecorView().getSystemUiVisibility() | 1024 | 256);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }
}
