package com.lynx.tasm.base;

import android.util.Log;

/* loaded from: classes6.dex */
public class LynxTraceEnv {
    private static LynxTraceEnv sInstance;
    private volatile boolean mIsNativeLibraryLoaded = false;

    public static LynxTraceEnv inst() {
        if (sInstance == null) {
            synchronized (LynxTraceEnv.class) {
                if (sInstance == null) {
                    sInstance = new LynxTraceEnv();
                }
            }
        }
        return sInstance;
    }

    private LynxTraceEnv() {
    }

    public boolean isNativeLibraryLoaded() {
        return this.mIsNativeLibraryLoaded;
    }

    public void markNativeLibraryLoaded(boolean z) {
        this.mIsNativeLibraryLoaded = z;
        TraceEvent.markTraceEnvInited(z);
    }

    public boolean init() {
        if (this.mIsNativeLibraryLoaded) {
            return this.mIsNativeLibraryLoaded;
        }
        this.mIsNativeLibraryLoaded = loadNativeTraceLibrary();
        TraceEvent.markTraceEnvInited(this.mIsNativeLibraryLoaded);
        return this.mIsNativeLibraryLoaded;
    }

    public boolean loadNativeTraceLibrary() {
        if (this.mIsNativeLibraryLoaded) {
            return this.mIsNativeLibraryLoaded;
        }
        try {
            System.loadLibrary("lynxtrace");
            return true;
        } catch (Exception unused) {
            Log.e("trace env init", "failed to load liblynxtrace.so");
            return false;
        }
    }
}
