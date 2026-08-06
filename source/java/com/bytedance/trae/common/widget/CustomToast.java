package com.bytedance.trae.common.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/* loaded from: classes5.dex */
public class CustomToast {
    private static final Handler MAIN_HANDLER = new Handler(Looper.getMainLooper());
    private static volatile String sLastShownMessageForTest;
    private static Toast sToast;

    public static void showShort(Context context, String str) {
        show(context, str, 0);
    }

    public static void showShort(Context context, int i) {
        show(context, context.getString(i), 0);
    }

    public static void showLong(Context context, String str) {
        show(context, str, 1);
    }

    public static void showLong(Context context, int i) {
        show(context, context.getString(i), 1);
    }

    private static void show(Context context, final String str, final int i) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            showInternal(context.getApplicationContext(), str, i);
        } else {
            final Context applicationContext = context.getApplicationContext();
            MAIN_HANDLER.post(new Runnable() { // from class: com.bytedance.trae.common.widget.CustomToast$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    CustomToast.showInternal(applicationContext, str, i);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void showInternal(Context context, String str, int i) {
        Toast toast = sToast;
        if (toast != null) {
            toast.cancel();
        }
        sLastShownMessageForTest = str;
        Toast makeText = Toast.makeText(context, str, i);
        sToast = makeText;
        makeText.show();
    }

    public static String getLastShownMessageForTest() {
        return sLastShownMessageForTest;
    }

    public static void clearLastShownMessageForTest() {
        sLastShownMessageForTest = null;
    }

    public static void cancelLastShownMessageForTest() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            cancelInternalForTest();
        } else {
            MAIN_HANDLER.post(new Runnable() { // from class: com.bytedance.trae.common.widget.CustomToast$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    CustomToast.cancelInternalForTest();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void cancelInternalForTest() {
        Toast toast = sToast;
        if (toast != null) {
            toast.cancel();
            sToast = null;
        }
        sLastShownMessageForTest = null;
    }
}
