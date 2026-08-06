package com.ss.bytertc.engine.loader;

import com.ss.bytertc.engine.utils.LogUtil;

/* loaded from: classes7.dex */
public class RTCNativeLibraryListenerImpl implements RTCNativeLibraryLoaderListener {
    private static final String TAG = "RtcNativeLibraryLoaderListener";

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderListener
    public void onLoadSuccess(String name) {
        LogUtil.i(TAG, "onLoadSuccess : " + name);
    }

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderListener
    public void onLoadError(String name) {
        LogUtil.i(TAG, "onLoadError : " + name);
    }

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoaderListener
    public void onLoadAlready(String name) {
        LogUtil.i(TAG, "onLoadAlready : " + name);
    }
}
