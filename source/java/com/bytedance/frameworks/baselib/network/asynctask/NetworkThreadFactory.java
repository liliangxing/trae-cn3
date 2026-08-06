package com.bytedance.frameworks.baselib.network.asynctask;

import android.os.Process;
import com.bytedance.common.utility.Logger;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public class NetworkThreadFactory implements ThreadFactory {
    private static final String TAG = "NetworkThreadFactory";
    private final String mThreadName;

    public NetworkThreadFactory(String str) {
        this.mThreadName = "ttnet-" + str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(final Runnable runnable) {
        return new Thread(new Runnable() { // from class: com.bytedance.frameworks.baselib.network.asynctask.NetworkThreadFactory$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                NetworkThreadFactory.this.m7691x6b2a5155(runnable);
            }
        }, this.mThreadName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$newThread$0$com-bytedance-frameworks-baselib-network-asynctask-NetworkThreadFactory, reason: not valid java name */
    public /* synthetic */ void m7691x6b2a5155(Runnable runnable) {
        Process.setThreadPriority(10);
        try {
            runnable.run();
        } catch (Throwable th) {
            Logger.e(TAG, "NetworkThreadFactory error when running in thread " + this.mThreadName, th);
        }
    }
}
