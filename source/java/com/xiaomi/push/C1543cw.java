package com.xiaomi.push;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.cw */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class C1543cw {

    /* renamed from: a */
    private static ThreadPoolExecutor f1276a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static void m1989a(Context context) {
    }
}
