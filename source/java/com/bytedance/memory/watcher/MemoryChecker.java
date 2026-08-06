package com.bytedance.memory.watcher;

import com.bytedance.iesgurd.exception.BytePatchException;
import com.bytedance.memory.common.IAnalyseCallBack;
import com.bytedance.memory.common.MemoryLog;
import com.bytedance.memory.common.MemoryUtils;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.bytedance.monitor.util.thread.AsyncTaskUtil;
import com.bytedance.monitor.util.thread.IAsyncTaskManager;
import com.bytedance.monitor.util.thread.TaskRunnable;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes4.dex */
public class MemoryChecker {
    private static final int DELAY_SECONDS = 30;
    private static final int DELAY_SECONDS_DEBUG = 1;
    private static volatile MemoryChecker sMemoryChecker;
    private IAnalyseCallBack mHeapAnalyse;
    private MemoryWidgetConfig mMemoryWidgetConfig;
    private volatile boolean mCanAnalyse = false;
    private volatile boolean mPause = false;
    private volatile boolean mDumpRunning = false;
    private TaskRunnable mDumpHeapTask = new TaskRunnable() { // from class: com.bytedance.memory.watcher.MemoryChecker.1
        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public String getTaskName() {
            return "mDumpHeapTask-MC";
        }

        @Override // com.bytedance.monitor.util.thread.TaskRunnable
        public AsyncTaskType getTaskType() {
            return AsyncTaskType.IO;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (MemoryChecker.this.canIgnore()) {
                return;
            }
            MemoryChecker memoryChecker = MemoryChecker.this;
            if (memoryChecker.canDump(memoryChecker.mMemoryWidgetConfig)) {
                MemoryChecker.this.mDumpRunning = true;
                MemoryChecker.this.mHeapAnalyse.dumpHeap();
                MemoryLog.m101i("begin dumpHeap", new Object[0]);
            }
        }
    };
    private IAsyncTaskManager mAsyncTaskManager = AsyncTaskUtil.getAsyncTaskManagerInstance();

    private MemoryChecker() {
    }

    public static MemoryChecker getInstance() {
        if (sMemoryChecker == null) {
            synchronized (MemoryChecker.class) {
                if (sMemoryChecker == null) {
                    sMemoryChecker = new MemoryChecker();
                }
            }
        }
        return sMemoryChecker;
    }

    public void startCheck(MemoryWidgetConfig memoryWidgetConfig, IAnalyseCallBack iAnalyseCallBack) {
        if (this.mCanAnalyse) {
            MemoryLog.m101i("startCheck canAnalyse", new Object[0]);
            return;
        }
        this.mPause = false;
        this.mMemoryWidgetConfig = memoryWidgetConfig;
        if (this.mAsyncTaskManager != null) {
            MemoryLog.m101i("enter startCheck", new Object[0]);
            this.mHeapAnalyse = iAnalyseCallBack;
            long j = (iAnalyseCallBack.debugMode() ? 1 : 30) * BytePatchException.ErrorCode.paramsError;
            this.mAsyncTaskManager.scheduleWithFixedDelay(this.mDumpHeapTask, j, j);
        }
    }

    public void setCanAnalyse(boolean z) {
        this.mCanAnalyse = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canDump(MemoryWidgetConfig memoryWidgetConfig) {
        return MemoryUtils.getMemoryRate() >= ((float) memoryWidgetConfig.getMemoryRate());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean canIgnore() {
        boolean canAnalyse = this.mHeapAnalyse.canAnalyse();
        if (canAnalyse && this.mAsyncTaskManager != null) {
            MemoryLog.m101i("canAnalyse, so cancel check", new Object[0]);
            this.mAsyncTaskManager.removeTask(this.mDumpHeapTask);
            this.mCanAnalyse = true;
        }
        return canAnalyse || this.mDumpRunning || this.mPause || this.mHeapAnalyse.lessThanThreshold();
    }

    public void stopCheck() {
        MemoryLog.m101i("stopCheck", new Object[0]);
        this.mPause = true;
        IAsyncTaskManager iAsyncTaskManager = this.mAsyncTaskManager;
        if (iAsyncTaskManager == null) {
            return;
        }
        iAsyncTaskManager.removeTask(this.mDumpHeapTask);
    }

    public void finishDump() {
        MemoryLog.m101i("finish dumpHeap", new Object[0]);
        this.mDumpRunning = false;
    }
}
