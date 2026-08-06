package com.lynx.tasm.component;

@Deprecated
/* loaded from: classes7.dex */
public interface DynamicComponentFetcher {

    /* loaded from: classes7.dex */
    public interface LoadedHandler {
        void onComponentLoaded(byte[] bArr, Throwable th);
    }

    void loadDynamicComponent(String str, LoadedHandler loadedHandler);
}
