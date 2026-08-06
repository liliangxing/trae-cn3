package com.bytedance.applog.monitor.p006v3;

import java.security.SecureRandom;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class RandomUtils {
    public static boolean randomSamplingHit(int i, int i2) {
        if (i <= 0) {
            return false;
        }
        return i >= i2 || ((long) new SecureRandom().nextInt(i2)) < ((long) i);
    }
}
