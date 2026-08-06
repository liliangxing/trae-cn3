package com.bytedance.sysoptimizer;

import android.content.Context;

/* loaded from: classes5.dex */
public class JNIEnvExceptionOpt {
    private static volatile boolean sInit;
    private static IThrowableConsumer sThrowableConsumer;

    /* loaded from: classes5.dex */
    public interface IThrowableConsumer {
        boolean consume(Thread thread, Throwable th);
    }

    private static native int nStart();

    public static int start(Context context, IThrowableConsumer iThrowableConsumer) {
        if (sInit) {
            return 1;
        }
        if (!SysOptimizer.loadOptimizerLibrary(context) || sInit) {
            return -1;
        }
        sThrowableConsumer = iThrowableConsumer;
        int nStart = nStart();
        sInit = true;
        return nStart;
    }

    private static boolean consume(Throwable th) {
        IThrowableConsumer iThrowableConsumer = sThrowableConsumer;
        if (iThrowableConsumer == null) {
            return false;
        }
        return iThrowableConsumer.consume(Thread.currentThread(), th);
    }
}
