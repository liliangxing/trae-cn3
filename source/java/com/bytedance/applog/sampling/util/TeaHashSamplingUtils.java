package com.bytedance.applog.sampling.util;

/* loaded from: classes3.dex */
public class TeaHashSamplingUtils {
    public static boolean hitSampling(String str, long j, long j2) {
        return j2 <= 0 || j2 > j || (CityHashUtils.hash64UnSign(str).longValue() >>> 32) % (j / j2) == 0;
    }
}
