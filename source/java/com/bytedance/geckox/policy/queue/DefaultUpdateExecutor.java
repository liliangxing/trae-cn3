package com.bytedance.geckox.policy.queue;

import com.bytedance.iesgurd.core.ReqType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class DefaultUpdateExecutor implements Executor {
    private PriorityTagQueue mQueue = new PriorityTagQueue();
    private ExecutorService mExecutor = new ThreadPoolExecutor(1, 1, 30, TimeUnit.SECONDS, this.mQueue.getQueue(), new ThreadFactory() { // from class: com.bytedance.geckox.policy.queue.DefaultUpdateExecutor.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("gecko-update-thread");
            thread.setPriority(3);
            return thread;
        }
    });

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.mExecutor.execute(runnable);
    }

    public void cancelUpdateTask(ReqType reqType, Map<String, List<String>> map) {
        this.mQueue.cancelUpdateTask(reqType, map);
    }
}
