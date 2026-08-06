package com.apm.lite.p023k;

import android.os.Process;
import java.io.File;

/* renamed from: com.apm.lite.k.h */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public final class C0785h {
    /* renamed from: a */
    public static int m778a() {
        try {
            return new File("/proc/" + Process.myPid() + "/fd").listFiles().length;
        } catch (Throwable unused) {
            return -1;
        }
    }
}
