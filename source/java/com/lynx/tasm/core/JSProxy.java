package com.lynx.tasm.core;

import com.lynx.jsbridge.JSModule;
import com.lynx.jsbridge.RuntimeLifecycleListener;
import com.lynx.jsbridge.RuntimeLifecycleListenerDelegate;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxBackgroundRuntime;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class JSProxy {
    private static final int MAX_ARGS_COUNT = 200;
    private static final String TAG = "JSProxy";
    private boolean hasReport;
    private long mArgsId;
    private HashMap<Long, Object> mArgsMap;
    private final WeakReference<LynxContext> mContext;
    private final String mJSGroupThreadName;
    private final ReadWriteLock mLock;
    private long mNativePtr;
    private long mRuntimeId;

    private native void nativeAddLifecycleListener(long j, RuntimeLifecycleListenerDelegate runtimeLifecycleListenerDelegate);

    private native void nativeCallIntersectionObserver(long j, int i, int i2, long j2);

    private native void nativeCallJSApiCallbackWithValue(long j, int i, long j2);

    private native void nativeCallJSFunction(long j, String str, String str2, long j2);

    private native long nativeCreate(long j, String str);

    private native long nativeCreateWithRuntimeActor(long j, String str);

    private native void nativeDestroy(long j, String str);

    private static native void nativeEvaluateScript(long j, String str, byte[] bArr, int i);

    private static native void nativeRejectDynamicComponentLoad(long j, String str, int i, int i2, String str2);

    private static native void nativeRunOnJSThread(long j, Runnable runnable);

    public JSProxy(long j, WeakReference<LynxContext> weakReference, String str) {
        this.mLock = new ReentrantReadWriteLock();
        this.mArgsId = 0L;
        this.mArgsMap = new HashMap<>();
        this.hasReport = false;
        this.mContext = weakReference;
        this.mJSGroupThreadName = str;
        this.mNativePtr = nativeCreate(j, str);
    }

    public JSProxy(LynxBackgroundRuntime lynxBackgroundRuntime, String str) {
        this.mLock = new ReentrantReadWriteLock();
        this.mArgsId = 0L;
        this.mArgsMap = new HashMap<>();
        this.hasReport = false;
        this.mContext = new WeakReference<>(null);
        this.mJSGroupThreadName = str;
        this.mNativePtr = nativeCreateWithRuntimeActor(lynxBackgroundRuntime.getNativePtr(), str);
    }

    public JSModule getJSModule(String str) {
        return new JSModule(str, this);
    }

    public long getRuntimeId() {
        return this.mRuntimeId;
    }

    public void destroy() {
        this.mLock.writeLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeDestroy(j, this.mJSGroupThreadName);
            this.mNativePtr = 0L;
        }
        this.mArgsMap.clear();
        this.mLock.writeLock().unlock();
    }

    public void callFunction(String str, String str2, JavaOnlyArray javaOnlyArray) {
        this.mLock.writeLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeCallJSFunction(j, str, str2, putArgs(javaOnlyArray));
        }
        int size = this.mArgsMap.size();
        this.mLock.writeLock().unlock();
        checkArgsCount(size, "callFunction:" + str + "." + str2);
    }

    public void callIntersectionObserver(int i, int i2, JavaOnlyMap javaOnlyMap) {
        this.mLock.writeLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeCallIntersectionObserver(j, i, i2, putArgs(javaOnlyMap));
        }
        int size = this.mArgsMap.size();
        this.mLock.writeLock().unlock();
        checkArgsCount(size, "callIntersectionObserver");
    }

    public void callJSApiCallbackWithValue(int i, JavaOnlyMap javaOnlyMap) {
        this.mLock.writeLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeCallJSApiCallbackWithValue(j, i, putArgs(javaOnlyMap));
        }
        int size = this.mArgsMap.size();
        this.mLock.writeLock().unlock();
        checkArgsCount(size, "callJSApiCallbackWithValue");
    }

    public void evaluateScript(String str, byte[] bArr, int i) {
        this.mLock.readLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeEvaluateScript(j, str, bArr, i);
        }
        this.mLock.readLock().unlock();
    }

    public void rejectDynamicComponentLoad(String str, int i, int i2, String str2) {
        this.mLock.readLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeRejectDynamicComponentLoad(j, str, i, i2, str2);
        }
        this.mLock.readLock().unlock();
    }

    public void runOnJSThread(Runnable runnable) {
        this.mLock.readLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeRunOnJSThread(j, runnable);
        }
        this.mLock.readLock().unlock();
    }

    private long putArgs(Object obj) {
        HashMap<Long, Object> hashMap = this.mArgsMap;
        long j = this.mArgsId + 1;
        this.mArgsId = j;
        hashMap.put(Long.valueOf(j), obj);
        return this.mArgsId;
    }

    private void checkArgsCount(int i, String str) {
        WeakReference<LynxContext> weakReference;
        if (this.hasReport || i <= 200 || (weakReference = this.mContext) == null) {
            return;
        }
        this.hasReport = true;
        LynxContext lynxContext = weakReference.get();
        if (lynxContext != null) {
            lynxContext.handleLynxError(new LynxError(20201, "Calling [" + str + "] too frequently.This may cause OOM issues."));
        }
    }

    private Object getArgs(long j) {
        this.mLock.writeLock().lock();
        try {
            return this.mArgsMap.remove(Long.valueOf(j));
        } finally {
            this.mLock.writeLock().unlock();
        }
    }

    public void addLifecycleListener(RuntimeLifecycleListener runtimeLifecycleListener) {
        if (runtimeLifecycleListener == null) {
            LLog.w(TAG, "add a null lifecycle listener.");
            return;
        }
        RuntimeLifecycleListenerDelegate runtimeLifecycleListenerDelegate = new RuntimeLifecycleListenerDelegate(this.mContext, runtimeLifecycleListener);
        this.mLock.readLock().lock();
        long j = this.mNativePtr;
        if (j != 0) {
            nativeAddLifecycleListener(j, runtimeLifecycleListenerDelegate);
        }
        this.mLock.readLock().unlock();
    }

    private void setRuntimeId(long j) {
        this.mRuntimeId = j;
    }
}
