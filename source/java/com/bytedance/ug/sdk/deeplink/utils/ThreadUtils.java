package com.bytedance.ug.sdk.deeplink.utils;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.ug.sdk.deeplink.ZlinkProviderManager;
import com.bytedance.ug.sdk.deeplink.interfaces.IExecutor;

/* loaded from: classes4.dex */
public class ThreadUtils {
    private static Handler mMainHandler;

    public static Handler getHandler() {
        if (mMainHandler == null) {
            mMainHandler = new Handler(Looper.getMainLooper());
        }
        return mMainHandler;
    }

    public static boolean isOnMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static void postMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        getHandler().post(runnable);
    }

    public static void runInMainThread(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (isOnMainThread()) {
            runnable.run();
        } else {
            postMainThread(runnable);
        }
    }

    public static void executeAsync(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            executeAsyncWithNewThread(runnable);
        } else {
            runnable.run();
        }
    }

    public static void executeAsyncWithNewThread(Runnable runnable) {
        IExecutor iExecutor;
        if (runnable == null || (iExecutor = (IExecutor) ZlinkProviderManager.getProvider(IExecutor.class)) == null) {
            return;
        }
        try {
            iExecutor.execute(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void executeWithSingleThread(Runnable runnable) {
        IExecutor iExecutor;
        if (runnable == null || (iExecutor = (IExecutor) ZlinkProviderManager.getProvider(IExecutor.class)) == null) {
            return;
        }
        try {
            iExecutor.executeWithSingleThread(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
