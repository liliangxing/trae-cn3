package com.huawei.secure.android.common.util;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.huawei.secure.android.common.util.c */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C1310c {

    /* renamed from: a */
    private static Handler f2262a = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m2510a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        f2262a.post(runnable);
    }
}
