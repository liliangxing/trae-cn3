package com.lynx.tasm.service;

import com.lynx.tasm.base.LLog;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.utils.RunOnceRunnable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes7.dex */
public abstract class LynxLazyInitializer {
    private static final String TAG = "LynxLazyInitializer";
    private static final long TIMEOUT = 3;
    private final RunOnceRunnable runnable = new RunOnceRunnable(new Runnable() { // from class: com.lynx.tasm.service.LynxLazyInitializer$$ExternalSyntheticLambda0
        @Override // java.lang.Runnable
        public final void run() {
            LynxLazyInitializer.this.runCatching();
        }
    });
    private final AtomicBoolean initialized = new AtomicBoolean(false);

    protected abstract boolean doInitialize();

    /* JADX INFO: Access modifiers changed from: private */
    public void runCatching() {
        try {
            this.initialized.set(doInitialize());
        } catch (Exception e) {
            LLog.e(TAG, "initialize failed: " + e);
        }
    }

    public void initialize() {
        if (this.runnable.getStatus() == RunOnceRunnable.STATUS_IDLE) {
            LynxThreadPool.getAsyncServiceExecutor().execute(this.runnable);
        }
    }

    public boolean ensureInitialized(boolean z) {
        if (this.runnable.getStatus() == RunOnceRunnable.STATUS_FINISHED) {
            return true;
        }
        if (!z) {
            initialize();
        } else {
            this.runnable.run();
        }
        if (!this.runnable.waitForComplete(3L, TimeUnit.SECONDS)) {
            LLog.e(TAG, "ensureInitialized timeout");
            return false;
        }
        return this.initialized.get();
    }

    public boolean ensureInitialized() {
        return ensureInitialized(true);
    }
}
