package com.bytedance.ug.sdk.share.impl.ui.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.bytedance.ug.sdk.share.impl.utils.Logger;

/* loaded from: classes4.dex */
public class UIUtils {
    private static boolean visibilityValid(int i) {
        return i == 0 || i == 8 || i == 4;
    }

    public static final void setViewVisibility(View view, int i) {
        if (view == null || view.getVisibility() == i || !visibilityValid(i)) {
            return;
        }
        view.setVisibility(i);
    }

    public static void setViewBackgroundWithPadding(View view, Drawable drawable) {
        if (view == null) {
            return;
        }
        int paddingLeft = view.getPaddingLeft();
        int paddingRight = view.getPaddingRight();
        int paddingTop = view.getPaddingTop();
        int paddingBottom = view.getPaddingBottom();
        view.setBackgroundDrawable(drawable);
        view.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public static void displayToastWithIcon(Context context, int i, int i2) {
        displayToast(context, i, context.getString(i2));
    }

    private static void displayToast(Context context, int i, String str) {
        displayToastInternal(context, i, str, 0, 17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void displayToastInternal(final Context context, final int i, final String str, final int i2, final int i3) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!isInUIThread()) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.ug.sdk.share.impl.ui.utils.UIUtils.1
                @Override // java.lang.Runnable
                public void run() {
                    UIUtils.displayToastInternal(context, i, str, i2, i3);
                }
            });
            return;
        }
        try {
            Toast makeText = Toast.makeText(context, str, i2);
            if (makeText != null) {
                makeText.setGravity(i3, 0, 0);
                makeText.show();
            }
        } catch (Exception e) {
            Logger.e(e.toString());
        }
    }

    private static boolean isInUIThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static float dip2Px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }
}
