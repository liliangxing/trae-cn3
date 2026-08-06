package com.lynx.tasm.fluency;

import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxEnvKey;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class FluencySample {
    private static final AtomicBoolean sCheckUpdate = new AtomicBoolean(true);
    private static boolean sEnable = false;
    private static boolean sForceEnable = false;

    private static native void nativeNeedCheckFluencyEnable();

    private static native void nativeSetFluencySample(boolean z);

    public static boolean isEnable() {
        if (sForceEnable) {
            return true;
        }
        if (sCheckUpdate.compareAndSet(true, false)) {
            sEnable = LynxEnv.getBooleanFromExternalEnv(LynxEnvKey.ENABLE_FLUENCY_TRACE, false);
        }
        return sEnable;
    }

    public static void setEnable(boolean z) {
        sForceEnable = z;
        nativeSetFluencySample(z);
    }

    public static void needCheckUpdate() {
        sCheckUpdate.set(true);
        nativeNeedCheckFluencyEnable();
    }
}
