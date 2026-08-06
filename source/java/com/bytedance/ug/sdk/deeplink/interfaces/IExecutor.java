package com.bytedance.ug.sdk.deeplink.interfaces;

import com.bytedance.ug.sdk.deeplink.threadpool.TTExecutors;
import java.util.concurrent.Executor;

/* loaded from: classes4.dex */
public interface IExecutor extends Executor {
    public static final IExecutor DEFAULT = new IExecutor() { // from class: com.bytedance.ug.sdk.deeplink.interfaces.IExecutor.1
        @Override // com.bytedance.ug.sdk.deeplink.interfaces.IExecutor
        public void executeWithSingleThread(Runnable runnable) {
            TTExecutors.execute(runnable);
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (runnable != null) {
                TTExecutors.execute(runnable);
            }
        }
    };

    void executeWithSingleThread(Runnable runnable);
}
