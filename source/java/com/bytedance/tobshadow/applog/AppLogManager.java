package com.bytedance.tobshadow.applog;

import com.bytedance.tobshadow.bdtracker.C0411e;
import com.bytedance.tobshadow.bdtracker.C0453k;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class AppLogManager {
    public static IAppLogInstance getInstance(String str) {
        if (C0411e.m376c(str)) {
            return null;
        }
        return C0453k.m491a(str);
    }
}
