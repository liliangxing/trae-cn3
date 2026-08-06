package com.bytedance.sysoptimizer.javahook;

/* loaded from: classes5.dex */
public class ProxyFrameData {
    private static final String TAG = "ProxyFrameData";

    public Object update(long j, Object obj) throws Throwable {
        String str = "update() called with: frameTimeNanos = [" + j + "], vsyncEventData = [" + obj + "]";
        Object callOrigin = AHook.callOrigin(OriginMethodKey.KEY_FRAMEDATA_UPDATE, this, Long.valueOf(j), obj);
        AHook.getCallback().e(TAG, str + ", o = [" + callOrigin + "]", new Throwable());
        return callOrigin;
    }
}
