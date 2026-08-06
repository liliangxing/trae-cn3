package com.bytedance.android.livesdk.pannel.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
public class UIUtils {
    private static Field mAttachInfoField;
    private static Field mStableInsetsField;

    public static boolean isAboveLollipop() {
        return true;
    }

    public static void startAnimation(final View view, int i, boolean z) {
        if (view == null || i <= 0) {
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), i);
        view.setVisibility(z ? 0 : 8);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.android.livesdk.pannel.utils.UIUtils.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                View view2 = view;
                if (view2 == null) {
                    return;
                }
                view2.clearAnimation();
                view.setEnabled(true);
            }
        });
        loadAnimation.setFillAfter(true);
        loadAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setEnabled(false);
        view.startAnimation(loadAnimation);
    }

    public static int[] getScreenSize(Context context) {
        WindowManager windowManager;
        int[] iArr = {0, 0};
        if (context != null && (windowManager = (WindowManager) context.getApplicationContext().getSystemService("window")) != null && windowManager.getDefaultDisplay() != null) {
            Point point = new Point();
            windowManager.getDefaultDisplay().getSize(point);
            iArr[0] = point.x;
            iArr[1] = point.y;
        }
        return iArr;
    }

    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int identifier;
        if (context == null || context.getResources() == null || (identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android")) <= 0) {
            return 0;
        }
        return context.getResources().getDimensionPixelSize(identifier);
    }

    @Deprecated
    public static float sp2px(Context context, int i) {
        return TypedValue.applyDimension(2, i, context.getResources().getDisplayMetrics());
    }

    public static float dip2Px(Context context, int i) {
        return (i * context.getResources().getDisplayMetrics().density) + 0.5f;
    }

    public static int px2dip(Context context, int i) {
        return (int) ((i / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int getViewInset(View view) {
        if (view != null) {
            try {
                if (mAttachInfoField == null) {
                    Field declaredField = View.class.getDeclaredField("mAttachInfo");
                    mAttachInfoField = declaredField;
                    declaredField.setAccessible(true);
                }
                Object obj = mAttachInfoField.get(view);
                if (obj != null) {
                    if (mStableInsetsField == null) {
                        Field declaredField2 = obj.getClass().getDeclaredField("mStableInsets");
                        mStableInsetsField = declaredField2;
                        declaredField2.setAccessible(true);
                    }
                    return ((Rect) mStableInsetsField.get(obj)).bottom;
                }
            } catch (Exception unused) {
            }
        }
        return 0;
    }
}
