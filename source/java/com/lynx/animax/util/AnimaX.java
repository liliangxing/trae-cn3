package com.lynx.animax.util;

import android.content.Context;
import com.lynx.animax.base.INativeLibraryLoader;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes6.dex */
public class AnimaX {
    private static final String TAG = "AnimaX";
    private static volatile AnimaX sInstance;
    private Context mAppContext;
    private volatile boolean mHasLibInit = false;
    private volatile boolean mHasMarkedMainThread = false;
    private final CountDownLatch mMarkMainThreadLatch = new CountDownLatch(1);
    private INativeLibraryLoader mNativeLibraryLoader;

    private native void nativeMarkMainThread();

    private native void nativeRegisterLogger(long j);

    private AnimaX() {
    }

    public static AnimaX inst() {
        if (sInstance == null) {
            synchronized (AnimaX.class) {
                if (sInstance == null) {
                    sInstance = new AnimaX();
                }
            }
        }
        return sInstance;
    }

    public void init(Context context) {
        init(context, null);
    }

    @Deprecated
    public void init() {
        init(null, null);
    }

    public void init(Context context, INativeLibraryLoader iNativeLibraryLoader) {
        setAppContextIfUnset(context);
        init(iNativeLibraryLoader);
    }

    @Deprecated
    public void init(INativeLibraryLoader iNativeLibraryLoader) {
        if (!this.mHasLibInit) {
            initWithLock(iNativeLibraryLoader);
        }
        if (this.mHasMarkedMainThread || !this.mHasLibInit) {
            return;
        }
        markMainThread();
    }

    public void forceInit() {
        init();
        waitUntilMainThreadMarked();
    }

    public Context getAppContext() {
        return this.mAppContext;
    }

    public float getDensity() {
        Context appContext = inst().getAppContext();
        if (appContext != null) {
            return appContext.getResources().getDisplayMetrics().density;
        }
        AnimaXLog.e(TAG, "getDensity failed, context is null");
        return 1.0f;
    }

    public boolean hasInitialized() {
        return this.mHasLibInit && this.mHasMarkedMainThread;
    }

    public boolean hasLibInitialized() {
        return this.mHasLibInit;
    }

    private synchronized void initWithLock(INativeLibraryLoader iNativeLibraryLoader) {
        if (this.mHasLibInit) {
            return;
        }
        this.mNativeLibraryLoader = iNativeLibraryLoader;
        if (!loadLibrary("lynxbase")) {
            AnimaXLog.e(TAG, "AnimaX failed to load liblynxbase.so");
        } else if (!loadLibrary("animax")) {
            AnimaXLog.e(TAG, "AnimaX failed to load libanimax.so");
        } else {
            nativeRegisterLogger(getALogNativeAddress());
            this.mHasLibInit = true;
        }
    }

    private void markMainThread() {
        if (this.mHasMarkedMainThread) {
            return;
        }
        if (UIThreadUtils.isOnUiThread()) {
            markMainThreadOnMain();
        } else {
            postMarkMainThread();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void markMainThreadOnMain() {
        if (this.mHasMarkedMainThread) {
            return;
        }
        nativeMarkMainThread();
        this.mHasMarkedMainThread = true;
        this.mMarkMainThreadLatch.countDown();
        AnimaXLog.i(TAG, "Main thread marked.");
    }

    private void postMarkMainThread() {
        AnimaXLog.i(TAG, "Posting mark main thread runnable to main thread.");
        UIThreadUtils.postAtFrontOfQueueOnUiThread(new Runnable() { // from class: com.lynx.animax.util.AnimaX.1
            @Override // java.lang.Runnable
            public void run() {
                AnimaXLog.i(AnimaX.TAG, "Mark main thread runnable run on main thread.");
                AnimaX.this.markMainThreadOnMain();
            }
        });
    }

    private void waitUntilMainThreadMarked() {
        if (this.mHasMarkedMainThread || !this.mHasLibInit || UIThreadUtils.isOnUiThread()) {
            return;
        }
        try {
            if (this.mMarkMainThreadLatch.await(10000L, TimeUnit.MILLISECONDS)) {
                return;
            }
            AnimaXLog.e(TAG, "Timeout while waiting for main thread to be marked.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            AnimaXLog.e(TAG, "Interrupted while waiting for main thread to be marked: " + e.getMessage());
        }
    }

    public boolean loadLibrary(String str) {
        try {
            INativeLibraryLoader iNativeLibraryLoader = this.mNativeLibraryLoader;
            if (iNativeLibraryLoader != null) {
                iNativeLibraryLoader.loadLibrary(str);
                AnimaXLog.i(TAG, "Native library load " + str + " success with native library loader");
                return true;
            }
            System.loadLibrary(str);
            AnimaXLog.i(TAG, "Native library load " + str + " success with System.loadLibrary");
            return true;
        } catch (UnsatisfiedLinkError e) {
            if (this.mNativeLibraryLoader == null) {
                AnimaXLog.e(TAG, "Native library load " + str + " from system with error message " + e.getMessage());
                return false;
            }
            AnimaXLog.e(TAG, "Native Library load from " + this.mNativeLibraryLoader.getClass().getName() + " with error message " + e.getMessage());
            return false;
        }
    }

    public void setAppContextIfUnset(Context context) {
        if (this.mAppContext != null || context == null) {
            return;
        }
        this.mAppContext = context;
    }

    private long getALogNativeAddress() {
        try {
            return ((Long) Class.forName("com.ss.android.agilelogger.ALog").getMethod("getALogSimpleWriteFuncAddr", new Class[0]).invoke(null, new Object[0])).longValue();
        } catch (Exception e) {
            AnimaXLog.e(TAG, "No ALog found in the host [ " + e.getMessage() + " ]");
            return 0L;
        }
    }
}
