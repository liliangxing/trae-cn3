package com.bytedance.common.push;

import android.os.Looper;
import com.bytedance.common.utility.concurrent.TTExecutors;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class ThreadPlus {
    public static Future<?> submitRunnable(Runnable runnable) {
        return TTExecutors.getIOThreadPool().submit(runnable);
    }

    public static void runOnChildThread(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            submitRunnable(runnable);
        } else {
            runnable.run();
        }
    }
}
