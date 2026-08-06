package com.bytedance.frameworks.baselib.network.log;

import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTask;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskManager;
import com.bytedance.frameworks.baselib.network.asynctask.NetworkAsyncTaskType;
import com.bytedance.retrofit2.AsyncLogReporter;

/* loaded from: classes2.dex */
public class NetworkLogReporter implements AsyncLogReporter {
    @Override // com.bytedance.retrofit2.AsyncLogReporter
    public void postDelayed(final Runnable runnable, long j) {
        NetworkAsyncTaskManager.inst(NetworkAsyncTaskType.NETWORK).postTask(new NetworkAsyncTask(j, 0L) { // from class: com.bytedance.frameworks.baselib.network.log.NetworkLogReporter.1
            @Override // java.lang.Runnable
            public void run() {
                runnable.run();
            }
        });
    }
}
