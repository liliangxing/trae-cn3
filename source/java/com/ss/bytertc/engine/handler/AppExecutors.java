package com.ss.bytertc.engine.handler;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes7.dex */
public class AppExecutors {
    private static final AppExecutors INSTANCE = new AppExecutors(new MainThreadExecutor());
    private final Executor mMainThread;

    private AppExecutors(Executor mainThread) {
        this.mMainThread = mainThread;
    }

    public static AppExecutors getInstance() {
        return INSTANCE;
    }

    public Executor mainThread() {
        return this.mMainThread;
    }

    /* loaded from: classes7.dex */
    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler;

        private MainThreadExecutor() {
            this.mainThreadHandler = new Handler(Looper.getMainLooper());
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable command) {
            this.mainThreadHandler.post(command);
        }
    }
}
