package com.bytedance.security.android.aopcheck.utils;

import com.bytedance.crash.Ensure;
import com.bytedance.keva.Keva;
import com.bytedance.security.android.aopcheck.reporter.Constant;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class KevaUtil {
    private static Keva keva;

    public static Keva get() {
        if (keva == null) {
            try {
                keva = Keva.getRepo(Constant.SP_REPO, 1);
            } catch (Exception e) {
                Ensure.ensureNotReachHere(e, "init_keva_exception");
            }
        }
        return keva;
    }
}
