package com.ttnet.org.chromium.base;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.MainDex;
import java.lang.Thread;

@JNINamespace("base::android")
@MainDex
/* loaded from: classes7.dex */
public class JavaHandlerThread {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final HandlerThread mThread;
    private Throwable mUnhandledException;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public interface Natives {
        void initializeThread(long j, long j2);

        void onLooperStopped(long j);
    }

    public JavaHandlerThread(String str, int i) {
        this.mThread = new HandlerThread(str, i);
    }

    private static JavaHandlerThread create(String str, int i) {
        return new JavaHandlerThread(str, i);
    }

    public Looper getLooper() {
        return this.mThread.getLooper();
    }

    public void maybeStart() {
        if (hasStarted()) {
            return;
        }
        this.mThread.start();
    }

    private void startAndInitialize(final long j, final long j2) {
        maybeStart();
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: com.ttnet.org.chromium.base.JavaHandlerThread.1
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThreadJni.get().initializeThread(j, j2);
            }
        });
    }

    private void quitThreadSafely(final long j) {
        new Handler(this.mThread.getLooper()).post(new Runnable() { // from class: com.ttnet.org.chromium.base.JavaHandlerThread.2
            @Override // java.lang.Runnable
            public void run() {
                JavaHandlerThread.this.mThread.quit();
                JavaHandlerThreadJni.get().onLooperStopped(j);
            }
        });
        this.mThread.getLooper().quitSafely();
    }

    private void joinThread() {
        boolean z = false;
        while (!z) {
            try {
                this.mThread.join();
                z = true;
            } catch (InterruptedException unused) {
            }
        }
    }

    private boolean hasStarted() {
        return this.mThread.getState() != Thread.State.NEW;
    }

    private boolean isAlive() {
        return this.mThread.isAlive();
    }

    private void listenForUncaughtExceptionsForTesting() {
        this.mThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.ttnet.org.chromium.base.JavaHandlerThread.3
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                JavaHandlerThread.this.mUnhandledException = th;
            }
        });
    }

    private Throwable getUncaughtExceptionIfAny() {
        return this.mUnhandledException;
    }
}
