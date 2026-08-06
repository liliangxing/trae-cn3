package com.ss.bytertc.engine.loader;

import android.util.Log;

/* loaded from: classes7.dex */
public class RTCNativeLibraryLoaderImpl implements RTCNativeLibraryLoader {
    private static final String TAG = "RtcNativeLibraryLoaderImpl";

    @Override // com.ss.bytertc.engine.loader.RTCNativeLibraryLoader
    public boolean load(final String libraryName) {
        Log.i(TAG, "Loading library: " + libraryName);
        try {
            System.loadLibrary(libraryName);
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Failed to load native library: " + libraryName, e);
            return false;
        }
    }
}
