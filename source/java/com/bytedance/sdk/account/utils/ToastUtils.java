package com.bytedance.sdk.account.utils;

import android.content.Context;
import android.widget.Toast;

/* loaded from: classes5.dex */
public class ToastUtils {
    private static final int LENGTH_WITH_ICON = 1500;

    private ToastUtils() {
    }

    public static void showToast(Context context, int i) {
        showToast(context, i, 0);
    }

    public static void showToast(Context context, String str) {
        showToast(context, str, 0);
    }

    public static void showToast(Context context, int i, int i2) {
        if (context == null) {
            return;
        }
        Toast.makeText(context.getApplicationContext(), i, i2).show();
    }

    public static void showToast(Context context, String str, int i) {
        if (context == null) {
            return;
        }
        Toast.makeText(context.getApplicationContext(), str, i).show();
    }
}
