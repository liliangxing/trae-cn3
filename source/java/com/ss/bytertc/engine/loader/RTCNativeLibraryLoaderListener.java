package com.ss.bytertc.engine.loader;

/* loaded from: classes7.dex */
public interface RTCNativeLibraryLoaderListener {
    void onLoadAlready(String name);

    void onLoadError(String name);

    void onLoadSuccess(String name);
}
