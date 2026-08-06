package com.ss.ttm.vcshared;

@Deprecated
/* loaded from: classes7.dex */
public class VCBaseKitLoader {
    private VCBaseKitLoader() {
    }

    @Deprecated
    public static synchronized boolean loadLibrary() {
        boolean loadLibrary;
        synchronized (VCBaseKitLoader.class) {
            loadLibrary = com.ss.vcbkit.VCBaseKitLoader.loadLibrary();
        }
        return loadLibrary;
    }
}
