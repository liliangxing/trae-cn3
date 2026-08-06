package com.bytedance.geckox.policy.queue;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.iesgurd.core.ReqType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

/* loaded from: classes3.dex */
public class PriorityTagQueue {
    private BlockingQueue<Runnable> mQueue = new PriorityBlockingQueue();

    public BlockingQueue<Runnable> getQueue() {
        return this.mQueue;
    }

    public void cancelUpdateTask(ReqType reqType, Map<String, List<String>> map) {
        for (Runnable runnable : this.mQueue) {
            if (!(runnable instanceof PriorityTagTask)) {
                return;
            }
            PriorityTagTask priorityTagTask = (PriorityTagTask) runnable;
            String str = priorityTagTask.taskProps.accessKey;
            if (map.keySet().contains(str)) {
                String str2 = priorityTagTask.taskProps.group;
                List<String> list = map.get(str);
                if (list != null && list.contains(str2) && reqType == priorityTagTask.taskProps.reqType) {
                    GeckoLogger.d("cancel update task in queue");
                    this.mQueue.remove(priorityTagTask);
                }
            }
        }
    }
}
