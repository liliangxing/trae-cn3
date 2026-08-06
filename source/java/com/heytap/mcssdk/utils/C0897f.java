package com.heytap.mcssdk.utils;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.heytap.mcssdk.utils.f */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes6.dex */
public class C0897f {

    /* renamed from: a */
    private static final ExecutorService f637a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static Handler f638b = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m690a(Runnable runnable) {
        f637a.execute(runnable);
    }

    /* renamed from: b */
    public static void m691b(Runnable runnable) {
        f638b.post(runnable);
    }
}
