package com.bytedance.frameworks.baselib.network.http.retrofit;

import com.bytedance.frameworks.baselib.network.dispatcher.ApiTask;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequest;
import com.bytedance.frameworks.baselib.network.dispatcher.IRequestQueue;
import com.bytedance.frameworks.baselib.network.dispatcher.RequestQueue;
import com.bytedance.frameworks.baselib.network.dispatcher.ThreadPoolConfig;
import com.bytedance.retrofit2.SsRunnable;
import java.util.concurrent.Executor;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class SsHttpExecutor implements Executor {
    private static volatile IRequestQueue sRequestQueue;

    public static void setRequestQueue(RequestQueue requestQueue) {
        sRequestQueue = requestQueue;
    }

    public static void setThreadPoolConfig(ThreadPoolConfig threadPoolConfig) {
        RequestQueue.setThreadPoolConfig(threadPoolConfig);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        boolean z;
        IRequest.Priority priority;
        int i;
        IRequest.Priority priority2;
        if (runnable != null) {
            IRequest.Priority priority3 = IRequest.Priority.NORMAL;
            if (runnable instanceof SsRunnable) {
                SsRunnable ssRunnable = (SsRunnable) runnable;
                int priority4 = ssRunnable.priority();
                if (priority4 == 0) {
                    priority2 = IRequest.Priority.LOW;
                } else if (1 == priority4) {
                    priority2 = IRequest.Priority.NORMAL;
                } else if (2 == priority4) {
                    priority2 = IRequest.Priority.HIGH;
                } else if (3 == priority4) {
                    priority2 = IRequest.Priority.IMMEDIATE;
                } else if (-1 == priority4) {
                    priority2 = IRequest.Priority.LOWEST;
                } else {
                    priority2 = IRequest.Priority.NORMAL;
                }
                z = ssRunnable.isStreaming();
                i = ssRunnable.getRequestDelayTime();
                priority = priority2;
            } else {
                z = false;
                priority = priority3;
                i = 0;
            }
            if (sRequestQueue == null) {
                sRequestQueue = RequestQueue.getDefaultRequestQueue();
            }
            ApiTask apiTask = new ApiTask("NetExecutor", priority, i, runnable, z);
            if (z) {
                sRequestQueue.addDownload(apiTask);
            } else {
                sRequestQueue.add(apiTask);
            }
        }
    }
}
