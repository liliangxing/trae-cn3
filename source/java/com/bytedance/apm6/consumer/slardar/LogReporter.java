package com.bytedance.apm6.consumer.slardar;

import com.bytedance.apm.logging.ApmAlogHelper;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer;
import com.bytedance.apm6.consumer.slardar.send.LogSender;
import com.bytedance.apm6.consumer.slardar.send.NetworkSender;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.cache.LimitedQueue;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.bdinstall.GWorker;
import com.bytedance.common.utility.io.IOUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LogReporter implements WeedOutStrategy {
    private static final long LOOP_INTERVAL = 60000;
    private static final long MAX_BODY_BYTES = 1048576;
    private static final String TYPE_WEED_OUT = "first_log_dir";
    private volatile AsyncTask asyncTask;
    private volatile PersistentBuffer persistentBuffer;
    private volatile long interval = 60000;
    private volatile long onceReportMaxSizeBytes = 1048576;
    private LimitedQueue<LogFile> limitedQueue = new LimitedQueue<>(10);
    private volatile boolean isPaused = false;

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return TYPE_WEED_OUT;
    }

    public static LogReporter getInstance() {
        return InnerHolder.instance;
    }

    public void setPersistentBuffer(PersistentBuffer persistentBuffer) {
        this.persistentBuffer = persistentBuffer;
    }

    public void setOnceReportMaxSizeBytes(long j) {
        if (j <= 0) {
            return;
        }
        this.onceReportMaxSizeBytes = j;
    }

    public synchronized void setLoopInterval(long j) {
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "setLoopInterval:" + this.interval);
        }
        if (j > 0 && this.interval != j) {
            this.interval = j;
            if (this.asyncTask == null) {
                return;
            }
            AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).removeTask(this.asyncTask);
            this.asyncTask = new AsyncTask(this.interval, this.interval) { // from class: com.bytedance.apm6.consumer.slardar.LogReporter.1
                @Override // java.lang.Runnable
                public void run() {
                    LogReporter.this.report();
                }
            };
            AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(this.asyncTask);
        }
    }

    public synchronized void init() {
        this.asyncTask = new AsyncTask(0L, this.interval) { // from class: com.bytedance.apm6.consumer.slardar.LogReporter.2
            @Override // java.lang.Runnable
            public void run() {
                LogReporter.this.report();
            }
        };
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(this.asyncTask);
        if (ApmContext.isMainProcess()) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AsyncTask(GWorker.INTERVAL) { // from class: com.bytedance.apm6.consumer.slardar.LogReporter.3
                @Override // java.lang.Runnable
                public void run() {
                    LogReporter.this.moveInactiveSubProcessData();
                }
            });
        }
    }

    public synchronized void pause() {
        this.isPaused = true;
    }

    public synchronized void resume() {
        this.isPaused = false;
    }

    public synchronized void restart() {
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AsyncTask() { // from class: com.bytedance.apm6.consumer.slardar.LogReporter.4
            @Override // java.lang.Runnable
            public void run() {
                NetworkSender.restart();
            }
        });
    }

    public void uploadRemainLogs() {
        if (ApmContext.isMainProcess()) {
            AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(new AsyncTask() { // from class: com.bytedance.apm6.consumer.slardar.LogReporter.5
                @Override // java.lang.Runnable
                public void run() {
                    String[] list = LogReporter.this.persistentBuffer.list();
                    while (list != null && list.length > 0) {
                        LogReporter.this.report();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void report() {
        long currentTimeMillis = System.currentTimeMillis();
        flushBuffer();
        reportMemory();
        if (ApmContext.isMainProcess() && !this.isPaused) {
            reportFile();
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "LogReporter One Loop Cost:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    private void flushBuffer() {
        try {
            if (this.persistentBuffer != null) {
                this.persistentBuffer.flush();
            }
        } catch (Throwable th) {
            Logger.m121e(Constants.TAG, "flushBuffer", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moveInactiveSubProcessData() {
        File[] listFiles;
        File subProcessPersistentDirectory = DiskEnvironmentHelper.getSubProcessPersistentDirectory();
        if (subProcessPersistentDirectory.exists() && (listFiles = subProcessPersistentDirectory.listFiles()) != null) {
            for (File file : listFiles) {
                if (file != null && file.exists() && file.length() > 0) {
                    try {
                        if (Long.parseLong(file.getName().split("_")[0]) >= ApmContext.getInitTimeStamp()) {
                            continue;
                        } else {
                            FileChannel fileChannel = null;
                            try {
                                fileChannel = new RandomAccessFile(file, "rw").getChannel();
                                FileLock tryLock = fileChannel.tryLock(0L, Long.MAX_VALUE, false);
                                if (tryLock != null && tryLock.isValid()) {
                                    File file2 = new File(DiskEnvironmentHelper.getFlushDirectory(), DiskEnvironmentHelper.generateFlushFileName());
                                    boolean renameFile = IOUtils.renameFile(file.getAbsolutePath(), file2.getAbsolutePath());
                                    if (ApmContext.isDebugMode()) {
                                        Logger.m119d(Constants.TAG, "moveInactiveSubProcessData: src:" + file.getAbsolutePath() + " dst:" + file2.getAbsolutePath() + " isSuccess:" + renameFile);
                                    }
                                    tryLock.release();
                                } else if (ApmContext.isDebugMode()) {
                                    Logger.m119d(Constants.TAG, "moveInactiveSubProcessData isValid is not true ");
                                }
                            } finally {
                                try {
                                } finally {
                                }
                            }
                        }
                    } catch (Throwable unused) {
                        continue;
                    }
                }
            }
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
            LogFile pop = this.limitedQueue.pop();
            if (pop != null) {
                int totalBytes = pop.getTotalBytes();
                if (i == 0 || i + totalBytes < this.onceReportMaxSizeBytes) {
                    i += totalBytes;
                    arrayList.add(pop);
                } else {
                    LogSender.getInstance().sendLog(arrayList, 0);
                    arrayList.clear();
                    arrayList.add(pop);
                    i = totalBytes;
                }
            }
        }
        LogSender.getInstance().sendLog(arrayList, 0);
    }

    private void reportFile() {
        String[] strArr;
        if (this.persistentBuffer != null) {
            strArr = this.persistentBuffer.list();
        } else {
            Logger.m120e(Constants.TAG, "persistentBuffer is null");
            strArr = null;
        }
        if (strArr == null || strArr.length == 0) {
            return;
        }
        List asList = Arrays.asList(strArr);
        Collections.sort(asList, new Comparator<String>() { // from class: com.bytedance.apm6.consumer.slardar.LogReporter.6
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
            }
        });
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "reportFile: parsing " + asList.size() + " files. fileNameList" + asList);
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < asList.size(); i2++) {
            File file = new File(DiskEnvironmentHelper.getFlushDirectory(), (String) asList.get(i2));
            if (file.exists()) {
                LogFile fromFile = LogFile.fromFile(file);
                if (fromFile == null) {
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "logFile invalid. delete now.");
                    }
                    file.delete();
                } else {
                    int totalBytes = fromFile.getTotalBytes();
                    if (i == 0 || i + totalBytes < this.onceReportMaxSizeBytes) {
                        i += totalBytes;
                        arrayList.add(fromFile);
                    } else {
                        if (ApmAlogHelper.getInnerLogger() != null) {
                            ApmAlogHelper.getInnerLogger().m78d(Constants.TAG, "sendList:" + asList.toString());
                        }
                        LogSender.getInstance().sendLog(arrayList, asList.size() - arrayList.size());
                        return;
                    }
                }
            }
        }
        if (ApmAlogHelper.getInnerLogger() != null) {
            ApmAlogHelper.getInnerLogger().m78d(Constants.TAG, "sendList:" + asList.toString());
        }
        LogSender.getInstance().sendLog(arrayList, 0);
    }

    public void saveLogFileInMemory(LogFile logFile) {
        if (logFile == null) {
            return;
        }
        this.limitedQueue.push(logFile);
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long j) {
        String[] list;
        if (this.persistentBuffer == null || (list = this.persistentBuffer.list()) == null || list.length == 0) {
            return;
        }
        for (String str : list) {
            File file = new File(DiskEnvironmentHelper.getFlushDirectory(), str);
            long createTime = getCreateTime(file);
            if (createTime == -1) {
                FileUtils.deleteFile(file);
            } else if (createTime <= j) {
                FileUtils.deleteFile(file);
            }
        }
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long j) {
        String[] list;
        if (this.persistentBuffer == null || (list = this.persistentBuffer.list()) == null || list.length == 0) {
            return;
        }
        Arrays.sort(list);
        long j2 = 0;
        long j3 = 0;
        for (String str : list) {
            File file = new File(DiskEnvironmentHelper.getFlushDirectory(), str);
            if (file.exists() && file.isFile()) {
                j3 += file.length();
            }
        }
        for (String str2 : list) {
            if (j3 - j2 <= j) {
                return;
            }
            File file2 = new File(DiskEnvironmentHelper.getFlushDirectory(), str2);
            if (file2.exists() && file2.isFile()) {
                long length = file2.length();
                if (FileUtils.deleteFileWithResult(file2)) {
                    j2 += length;
                }
            }
        }
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public long getSize() {
        String[] list = this.persistentBuffer.list();
        long j = 0;
        if (list != null && list.length != 0) {
            for (String str : list) {
                j += new File(DiskEnvironmentHelper.getFlushDirectory(), str).length();
            }
        }
        return j;
    }

    private long getCreateTime(File file) {
        String name = file.getName();
        int indexOf = name.indexOf("_");
        if (indexOf == -1) {
            return -1L;
        }
        try {
            return Long.parseLong(name.substring(0, indexOf));
        } catch (Exception unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InnerHolder {
        private static final LogReporter instance = new LogReporter();

        private InnerHolder() {
        }
    }
}
