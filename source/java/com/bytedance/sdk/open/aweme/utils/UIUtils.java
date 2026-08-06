package com.bytedance.sdk.open.aweme.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: classes5.dex */
public class UIUtils {
    public static void detachFromParent(View view) {
        if (view == null || view.getParent() == null) {
            return;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            try {
                ((ViewGroup) parent).removeView(view);
            } catch (Exception unused) {
            }
        }
    }

    public static float dip2Px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static void removeParentView(View view) {
        if (view == null) {
            return;
        }
        try {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean setViewVisibility(View view, int i) {
        if (view == null || view.getVisibility() == i || !visibilityValid(i)) {
            return false;
        }
        view.setVisibility(i);
        return true;
    }

    public static float sp2px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f;
    }

    private static boolean visibilityValid(int i) {
        return i == 0 || i == 8 || i == 4;
    }
}
