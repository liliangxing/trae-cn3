package com.lynx.tasm.core.resource;

import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class GenericResourceCallback extends GuardedResourceCallback {
    private final long mResponseHandler;
    private WeakReference<LynxResourceLoader> weakLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GenericResourceCallback(LynxResourceLoader lynxResourceLoader, String str, long j) {
        super(str);
        this.weakLoader = new WeakReference<>(lynxResourceLoader);
        this.mResponseHandler = j;
    }

    public void onResourceLoaded(boolean z, byte[] bArr, String str) {
        if (EnsureInvokedOnce()) {
            int i = 30301;
            if (z) {
                LLog.i("LynxResourceLoader", "load resource success with url: " + this.mUrl);
                if (bArr == null || bArr.length == 0) {
                    str = "get null data for provider.";
                } else {
                    i = 0;
                }
                LynxResourceLoader.InvokeNativeCallbackWithBytes(this.mResponseHandler, bArr, i, str);
                return;
            }
            LLog.i("LynxResourceLoader", "load resource failed with url: " + this.mUrl + " error message: " + str);
            LynxResourceLoader.InvokeNativeCallbackWithBytes(this.mResponseHandler, null, 30301, str + ": " + str);
        }
    }
}
