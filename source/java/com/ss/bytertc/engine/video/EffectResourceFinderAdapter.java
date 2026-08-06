package com.ss.bytertc.engine.video;

/* loaded from: classes7.dex */
public class EffectResourceFinderAdapter {
    public static IRtcResourceFinder sFinder;

    public static long CreateNativeResourceFinder(long nativeEffectHandler) {
        IRtcResourceFinder iRtcResourceFinder;
        if (nativeEffectHandler == 0 || (iRtcResourceFinder = sFinder) == null) {
            return 0L;
        }
        return iRtcResourceFinder.createNativeResourceFinder(nativeEffectHandler);
    }

    public static void ReleaseNativeResourceFinder(long nativeEffectHandler) {
        sFinder.release(nativeEffectHandler);
    }
}
