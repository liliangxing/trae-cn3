package com.bytedance.ug.sdk.share.impl.utils;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes4.dex */
public class UiThreadHelper {
    private static UiThreadHelper sInstance;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    private UiThreadHelper() {
    }

    public static UiThreadHelper getInstance() {
        if (sInstance == null) {
            sInstance = new UiThreadHelper();
        }
        return sInstance;
    }

    public void execute(Runnable runnable) {
        if (isHandlerThread()) {
            runnable.run();
        } else {
            this.mHandler.post(runnable);
        }
    }

    public boolean isHandlerThread() {
        return Thread.currentThread() == this.mHandler.getLooper().getThread();
    }
}
