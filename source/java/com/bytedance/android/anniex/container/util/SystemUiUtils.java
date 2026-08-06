package com.bytedance.android.anniex.container.util;

import android.app.Activity;
import android.view.View;
import android.view.Window;

/* loaded from: classes2.dex */
final class SystemUiUtils {
    private SystemUiUtils() {
    }

    public static boolean hasSystemUiFlags(Window window, int i) {
        View decorView;
        return (window == null || (decorView = window.getDecorView()) == null || (decorView.getSystemUiVisibility() & i) != i) ? false : true;
    }

    public static void appendSystemUiFlags(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        appendSystemUiFlags(activity.getWindow(), i);
    }

    public static void appendSystemUiFlags(Window window, int i) {
        View decorView;
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if ((systemUiVisibility & i) == i) {
            return;
        }
        decorView.setSystemUiVisibility(i | systemUiVisibility);
    }

    public static void clearSystemUiFlags(Activity activity, int i) {
        if (activity == null) {
            return;
        }
        clearSystemUiFlags(activity.getWindow(), i);
    }

    public static void clearSystemUiFlags(Window window, int i) {
        View decorView;
        if (window == null || (decorView = window.getDecorView()) == null) {
            return;
        }
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if ((systemUiVisibility & i) == 0) {
            return;
        }
        decorView.setSystemUiVisibility((~i) & systemUiVisibility);
    }
}
