package com.google.android.gms.internal.base;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import com.ss.ttm.utils.AVLogger;

/* compiled from: com.google.android.gms:play-services-base@@18.0.1 */
/* loaded from: classes6.dex */
public final class zal {
    public static final int zaa;

    static {
        int i = Build.VERSION.SDK_INT;
        int i2 = AVLogger.LEVEL_LOG_INFO;
        if (i < 31 && (Build.VERSION.SDK_INT < 30 || Build.VERSION.CODENAME.length() != 1 || Build.VERSION.CODENAME.charAt(0) < 'S' || Build.VERSION.CODENAME.charAt(0) > 'Z')) {
            i2 = 0;
        }
        zaa = i2;
    }

    public static PendingIntent zaa(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getActivity(context, i, intent, i2);
    }
}
