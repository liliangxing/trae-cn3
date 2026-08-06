package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import com.bytedance.framwork.core.sdklib.thread.AsyncEventManager;
import com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class LogReporter implements IMonitorTimeTask {
    private static final long MAX_BODY_BYTES = 1048576;
    private boolean isInited;
    private long lastFlushTime;
    private volatile PersistentBuffer persistentBuffer;
    private volatile long interval = 60000;
    private volatile long onceReportMaxSizeBytes = MAX_BODY_BYTES;
    private LimitedQueue<LogFile> limitedQueue = new LimitedQueue<>(10);

    public static LogReporter getInstance() {
        return InnerHolder.instance;
    }

    public void setOnceReportMaxSizeBytes(long j) {
        if (j <= 0) {
            return;
        }
        this.onceReportMaxSizeBytes = j;
    }

    public long getOnceReportMaxSizeBytes() {
        return this.onceReportMaxSizeBytes;
    }

    public synchronized void setLoopInterval(long j) {
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "setLoopInterval:" + j);
        }
        if (j > 0 && this.interval != j) {
            this.interval = Math.min(j, this.interval);
        }
    }

    public synchronized void init() {
        if (this.isInited) {
            return;
        }
        this.isInited = true;
        AsyncEventManager.getInstance().addTimeTask(this);
    }

    @Override // com.bytedance.framwork.core.sdklib.thread.IMonitorTimeTask
    public void onTimeEvent(long j) {
        if (j - this.lastFlushTime >= this.interval) {
            report();
            this.lastFlushTime = System.currentTimeMillis();
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "onTimeEvent");
            }
        }
    }

    public void setPersistentBuffer(PersistentBuffer persistentBuffer) {
        this.persistentBuffer = persistentBuffer;
    }

    private void report() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            flushBuffer();
            reportMemory();
            if (SDKContext.isReportEnableInCurProcess()) {
                reportFile();
            }
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "LogReporter One Loop Cost:" + (System.currentTimeMillis() - currentTimeMillis));
            }
        } catch (Throwable th) {
            Logger.m1307e(Constants.TAG, "report", th);
        }
    }

    private void flushBuffer() {
        try {
            if (this.persistentBuffer != null) {
                this.persistentBuffer.flush();
            }
        } catch (Throwable th) {
            Logger.m1307e(Constants.TAG, "flushBuffer", th);
        }
    }

    public synchronized void forceReport() {
        try {
            reportFile();
        } catch (Throwable th) {
            Logger.m1307e(Constants.TAG, "forceReport", th);
        }
    }

    private void reportMemory() {
        if (this.limitedQueue.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (!this.limitedQueue.isEmpty()) {
            arrayList.add(this.limitedQueue.pop());
            LogFile logFile = (LogFile) this.limitedQueue.pop();
            if (logFile != null) {
                int totalBytes = logFile.getTotalBytes();
                if (i == 0 || i + totalBytes < this.onceReportMaxSizeBytes) {
                    i += totalBytes;
                    arrayList.add(logFile);
                } else {
                    LogSender.getInstance().sendLog(arrayList);
                    arrayList.clear();
                    arrayList.add(logFile);
                    i = totalBytes;
                }
            }
        }
        LogSender.getInstance().sendLog(arrayList);
    }

    private void reportFile() {
        ArrayList arrayList = new ArrayList();
        if (this.persistentBuffer != null) {
            List<File> listReportFiles = this.persistentBuffer.listReportFiles();
            if (!ListUtils.isEmpty(listReportFiles)) {
                arrayList.addAll(listReportFiles);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            File file = (File) arrayList.get(i2);
            if (!file.exists()) {
                Logger.m1306e(Constants.TAG, "reportFile file is not exist:" + file.getAbsolutePath());
            } else {
                LogFile fromFile = LogFile.fromFile(file);
                if (fromFile == null) {
                    if (SDKContext.isDebugMode()) {
                        Logger.m1305d(Constants.TAG, "logFile invalid. delete now.");
                    }
                    file.delete();
                } else {
                    int totalBytes = fromFile.getTotalBytes();
                    if (i == 0 || i + totalBytes < this.onceReportMaxSizeBytes) {
                        i += totalBytes;
                        arrayList2.add(fromFile);
                    } else {
                        LogSender.getInstance().sendLog(arrayList2);
                        return;
                    }
                }
            }
        }
        if (ListUtils.isEmpty(arrayList2)) {
            return;
        }
        LogSender.getInstance().sendLog(arrayList2);
    }

    public void saveLogFileInMemory(LogFile logFile) {
        if (logFile == null) {
            return;
        }
        this.limitedQueue.push(logFile);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class InnerHolder {
        private static final LogReporter instance = new LogReporter();

        private InnerHolder() {
        }
    }
}
