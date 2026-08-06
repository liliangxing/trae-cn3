package com.bytedance.crash;

import com.bytedance.crash.diagnose.NpthMonitor;

@Deprecated
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class EnsureImpl {
    public void ensureNotReachHereForce(String str, Throwable th) {
        NpthMonitor.reportInnerException(str, th);
    }
}
