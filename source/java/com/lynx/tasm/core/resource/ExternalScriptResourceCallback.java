package com.lynx.tasm.core.resource;

import com.lynx.tasm.base.LLog;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ExternalScriptResourceCallback extends GuardedResourceCallback {
    private final long mResponseHandler;
    private WeakReference<LynxResourceLoader> weakLoader;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExternalScriptResourceCallback(LynxResourceLoader lynxResourceLoader, String str, long j) {
        super(str);
        this.weakLoader = new WeakReference<>(lynxResourceLoader);
        this.mResponseHandler = j;
    }

    public void onScriptLoaded(boolean z, byte[] bArr, String str) {
        int i;
        String str2;
        String str3;
        LynxResourceLoader lynxResourceLoader;
        String str4;
        if (EnsureInvokedOnce()) {
            int i2 = 30301;
            if (z) {
                LLog.i("LynxResourceLoader", "loadExternalResourceAsync onSuccess.");
                if (bArr == null || bArr.length == 0) {
                    str4 = "get null data for provider.";
                } else {
                    i2 = 0;
                    str4 = null;
                }
                LynxResourceLoader.InvokeNativeCallbackWithBytes(this.mResponseHandler, bArr, i2, str4);
                str2 = str4;
                i = i2;
                str3 = null;
            } else {
                LynxResourceLoader.InvokeNativeCallbackWithBytes(this.mResponseHandler, null, 30301, "Error when fetch script: Error when fetch script");
                i = 30301;
                str2 = "Error when fetch script";
                str3 = str2;
            }
            if (i == 0 || (lynxResourceLoader = this.weakLoader.get()) == null) {
                return;
            }
            lynxResourceLoader.reportError("loadExternalResource", this.mUrl, i, str2, str3);
        }
    }
}
