package com.bytedance.memory.common;

import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MemoryExecutorSupplier {
    private static final int CORE_POOL_SIZE = 1;
    private static final String NAME_CHECK_TO_DUMP = "CheckToDump";

    @Deprecated
    public static final ScheduledExecutorService SCHEDULE_SERVICE = Executors.newScheduledThreadPool(1, new MemoryWidgetThreadFactory(NAME_CHECK_TO_DUMP));
    public static final IAsyncTaskWrapper NORMAL_SERVICE = new IAsyncTaskWrapper() { // from class: com.bytedance.memory.common.MemoryExecutorSupplier.1
        @Override // com.bytedance.memory.common.MemoryExecutorSupplier.IAsyncTaskWrapper
        public void execute(Runnable runnable, String str) {
            AsyncTaskUtil.getAsyncTaskManagerInstance().post(AsyncTaskUtil.wrapIOTask(str, runnable));
        }

        @Override // com.bytedance.memory.common.MemoryExecutorSupplier.IAsyncTaskWrapper
        public void execute(Runnable runnable) {
            execute(runnable, "no-name-MES");
        }
    };

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
    public interface IAsyncTaskWrapper {
        @Deprecated
        void execute(Runnable runnable);

        void execute(Runnable runnable, String str);
    }
}
