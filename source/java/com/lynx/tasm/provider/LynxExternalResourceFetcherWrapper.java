package com.lynx.tasm.provider;

import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.component.DynamicComponentFetcher;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class LynxExternalResourceFetcherWrapper {
    private static final String TAG = "LynxExternalResourceFetcherWrapper";
    private DynamicComponentFetcher mDynamicComponentFetcher;
    private LynxResourceServiceProvider mLynxServiceProvider = null;

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public interface LoadedHandler {
        void onLoaded(byte[] bArr, Throwable th);
    }

    public LynxExternalResourceFetcherWrapper(DynamicComponentFetcher dynamicComponentFetcher) {
        this.mDynamicComponentFetcher = dynamicComponentFetcher;
    }

    public boolean fetchResourceWithDynamicComponentFetcher(String str, final LoadedHandler loadedHandler) {
        if (this.mDynamicComponentFetcher == null) {
            return false;
        }
        TraceEvent.beginSection("Using DynamicComponentFetcher");
        this.mDynamicComponentFetcher.loadDynamicComponent(str, new DynamicComponentFetcher.LoadedHandler() { // from class: com.lynx.tasm.provider.LynxExternalResourceFetcherWrapper.1
            @Override // com.lynx.tasm.component.DynamicComponentFetcher.LoadedHandler
            public void onComponentLoaded(byte[] bArr, Throwable th) {
                loadedHandler.onLoaded(bArr, th);
            }
        });
        TraceEvent.endSection("Using DynamicComponentFetcher");
        return true;
    }
}
