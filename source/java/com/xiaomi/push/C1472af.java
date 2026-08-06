package com.xiaomi.push;

import android.os.Looper;

/* renamed from: com.xiaomi.push.af */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1472af {
    /* renamed from: a */
    public static void m1472a() {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            throw new RuntimeException("can't do this on ui thread");
        }
    }
}
