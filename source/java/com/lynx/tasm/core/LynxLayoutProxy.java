package com.lynx.tasm.core;

import com.lynx.tasm.base.LLog;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: classes7.dex */
public class LynxLayoutProxy {
    private static final String TAG = "LynxLayoutProxy";
    private final ReadWriteLock mLock = new ReentrantReadWriteLock();
    private long mNativePtr;

    private native long nativeCreate(long j);

    private native void nativeRelease(long j);

    private native void nativeRunOnLayoutThread(long j, Runnable runnable);

    public LynxLayoutProxy(long j) {
        initNative(j);
        LLog.i(TAG, "LynxLayoutProxy is created");
    }

    protected void initNative(long j) {
        this.mNativePtr = nativeCreate(j);
    }

    public void runOnLayoutThread(Runnable runnable) {
        this.mLock.readLock().lock();
        if (this.mNativePtr != 0) {
            LLog.i(TAG, "runOnLayoutThread is invoked");
            nativeRunOnLayoutThread(this.mNativePtr, runnable);
        }
        this.mLock.readLock().unlock();
    }

    public void destroy() {
        this.mLock.writeLock().lock();
        if (this.mNativePtr != 0) {
            LLog.i(TAG, "LynxLayoutProxy will be destroyed");
            nativeRelease(this.mNativePtr);
            this.mNativePtr = 0L;
        }
        this.mLock.writeLock().unlock();
    }
}
