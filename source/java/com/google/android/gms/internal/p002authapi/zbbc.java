package com.google.android.gms.internal.p002authapi;

import android.os.Build;
import com.ss.ttm.utils.AVLogger;

/* compiled from: com.google.android.gms:play-services-auth@@20.5.0 */
/* loaded from: classes6.dex */
public final class zbbc {
    public static final int zba;

    static {
        zba = Build.VERSION.SDK_INT >= 31 ? AVLogger.LEVEL_LOG_INFO : 0;
    }
}
