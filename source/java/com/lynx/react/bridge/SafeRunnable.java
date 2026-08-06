package com.lynx.react.bridge;

import com.lynx.tasm.behavior.ExceptionHandler;

/* loaded from: classes6.dex */
public abstract class SafeRunnable implements Runnable {
    private final ExceptionHandler mExceptionHandler;

    public abstract void unsafeRun();

    public SafeRunnable(ExceptionHandler exceptionHandler) {
        this.mExceptionHandler = exceptionHandler;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            unsafeRun();
        } catch (RuntimeException e) {
            this.mExceptionHandler.handleException(e);
        }
    }
}
