package com.bytedance.apm6.consumer.slardar.send;

import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.persistent.LogFile;
import com.bytedance.apm6.consumer.slardar.send.DiskFileHelper;
import com.bytedance.apm6.consumer.slardar.send.DropDataMonitor;
import com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import com.bytedance.apm6.util.timetask.AsyncTask;
import com.bytedance.apm6.util.timetask.AsyncTaskManager;
import com.bytedance.apm6.util.timetask.AsyncTaskManagerType;
import com.bytedance.common.utility.NetworkUtils;
import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class LogSender implements WeedOutStrategy {
    private static final int DEFAULT_SEND_LOG_INTERVAL = 30000;
    private static final int MAX_COUNT = 10;
    private static final long MAX_SEND_LOG_INTERVAL = 120000;
    private static final String TYPE_WEED_OUT = "second_log_dir";
    private AsyncTask asyncTask;
    private LinkedHashMap<UploadLogInfo, ConcurrentLinkedQueue<LogModel>> cacheLog;
    private volatile boolean isPaused;
    private long lastSendTime;
    private long retryCount;
    private long retryPollingInterval;

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public String getName() {
        return TYPE_WEED_OUT;
    }

    private LogSender() {
        this.cacheLog = new LinkedHashMap<>();
        this.retryPollingInterval = 30000L;
        this.lastSendTime = 0L;
        this.retryCount = 1L;
        this.isPaused = false;
    }

    public static LogSender getInstance() {
        return InnerHolder.instance;
    }

    public void init() {
        this.asyncTask = new AsyncTask(0L, 30000L) { // from class: com.bytedance.apm6.consumer.slardar.send.LogSender.1
            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - LogSender.this.lastSendTime >= LogSender.this.retryPollingInterval) {
                    try {
                        if (!LogSender.this.isPaused) {
                            LogSender.this.send();
                        }
                    } catch (Throwable th) {
                        Logger.m121e(Constants.TAG, CommonKey.KEY_SEND, th);
                    }
                    LogSender.this.lastSendTime = System.currentTimeMillis();
                }
            }
        };
        AsyncTaskManager.getInstance(AsyncTaskManagerType.IO).sendTask(this.asyncTask);
    }

    public void sendLog(List<LogFile> list, int i) {
        boolean z;
        int i2;
        boolean z2;
        long j;
        long j2;
        ConcurrentLinkedQueue<LogModel> concurrentLinkedQueue;
        try {
            if (LogReportController.getInstance().isStopCollect()) {
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "stop collect log");
                }
                long j3 = 0;
                long j4 = 0;
                for (LogFile logFile : list) {
                    j3 += logFile.getTotalCount();
                    j4 += logFile.getTotalBytes();
                }
                DropDataMonitor.getInstance().monitorDropLog(j3, j4, System.currentTimeMillis(), DropDataMonitor.Reason.SERVER_DROP);
                deleteFiles(list);
                return;
            }
            Map<UploadLogInfo, byte[]> serialize = UploadLogManager.serialize(list, i);
            if (serialize == null) {
                deleteFiles(list);
                return;
            }
            boolean isNetworkAvailable = NetworkUtils.isNetworkAvailable(ApmContext.getContext());
            boolean z3 = false;
            for (UploadLogInfo uploadLogInfo : serialize.keySet()) {
                byte[] bArr = serialize.get(uploadLogInfo);
                if (bArr != null) {
                    if (LogReportController.getInstance().isReportLogEnable() && isNetworkAvailable) {
                        if (ApmContext.isDebugMode()) {
                            DoctorDataUtil.sendBeginEvent(bArr);
                        }
                        z = NetworkSender.getInstance(uploadLogInfo).sendLog(bArr);
                        if (ApmContext.isDebugMode()) {
                            if (z) {
                                DoctorDataUtil.sendSuccessEvent(bArr);
                            } else {
                                DoctorDataUtil.sendFailEvent(bArr);
                            }
                        }
                        this.lastSendTime = System.currentTimeMillis();
                        z3 |= z;
                        i2 = 1;
                    } else {
                        z = false;
                        i2 = 0;
                    }
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "sendDirect:isReportLogEnable " + LogReportController.getInstance().isReportLogEnable() + " :sendResult " + z);
                    }
                    if (z) {
                        z2 = z3;
                    } else {
                        long retryInterval = LogReportController.getInstance().getRetryInterval(i2);
                        long currentTimeMillis = System.currentTimeMillis() + retryInterval;
                        if (ApmContext.isMainProcess()) {
                            j = currentTimeMillis;
                            z2 = z3;
                            j2 = retryInterval;
                            z = DiskFileHelper.getInstance().saveFile(bArr, uploadLogInfo.getName(), i2, j);
                        } else {
                            z2 = z3;
                            j = currentTimeMillis;
                            j2 = retryInterval;
                        }
                        if (ApmContext.isDebugMode()) {
                            Logger.m119d(Constants.TAG, "saveFile:Result:" + z + ":isMaiProcess:" + ApmContext.isMainProcess() + " :" + i2 + " " + j2);
                        }
                        if (!z) {
                            if (this.cacheLog.containsKey(uploadLogInfo)) {
                                concurrentLinkedQueue = this.cacheLog.get(uploadLogInfo);
                            } else {
                                concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                                concurrentLinkedQueue.add(new LogModel(bArr, i2, j));
                            }
                            if (concurrentLinkedQueue.size() > 10) {
                                concurrentLinkedQueue.poll();
                            }
                        }
                    }
                    z3 = z2;
                }
            }
            if (z3) {
                reset();
            }
            deleteFiles(list);
        } catch (Throwable th) {
            Logger.m121e(Constants.TAG, "sendLog", th);
        }
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOut(long j) {
        File[] listFiles = DiskFileHelper.getInstance().listFiles();
        if (listFiles == null) {
            return;
        }
        for (File file : listFiles) {
            if (DiskFileHelper.getCreateTime(file) <= j) {
                FileUtils.deleteFile(file);
            }
        }
    }

    @Override // com.bytedance.apm6.consumer.slardar.weedout.WeedOutStrategy
    public void doWeedOutSize(long j) {
        File[] listFiles = DiskFileHelper.getInstance().listFiles();
        if (listFiles == null) {
            return;
        }
        Arrays.sort(listFiles, new Comparator<File>() { // from class: com.bytedance.apm6.consumer.slardar.send.LogSender.2
            @Override // java.util.Comparator
            public int compare(File file, File file2) {
                return file.compareTo(file2);
            }
        });
        long j2 = 0;
        long j3 = 0;
        for (File file : listFiles) {
            if (file.exists() && file.isFile()) {
                j3 += file.length();
            }
        }
        for (File file2 : listFiles) {
            if (j3 - j2 <= j) {
                return;
            }
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
        File[] listFiles = DiskFileHelper.getInstance().listFiles();
        long j = 0;
        if (listFiles == null) {
            return 0L;
        }
        for (File file : listFiles) {
            j += file.length();
        }
        return j;
    }

    public void pause() {
        this.isPaused = true;
    }

    public void resume() {
        this.isPaused = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void send() {
        if (NetworkUtils.isNetworkAvailable(ApmContext.getContext())) {
            if (LogReportController.getInstance().isReportLogEnable()) {
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "trigger send.");
                }
                boolean sendMemory = sendMemory();
                if (ApmContext.isMainProcess()) {
                    sendMemory = sendFile();
                }
                if (sendMemory) {
                    reset();
                } else {
                    if (this.retryPollingInterval < 120000) {
                        long j = this.retryCount;
                        this.retryPollingInterval = (j + 1) * 30000;
                        this.retryCount = j + 1;
                    }
                    if (this.retryPollingInterval > 120000) {
                        this.retryPollingInterval = 120000L;
                    }
                }
            }
            if (!ApmContext.isDebugMode() || LogReportController.getInstance().isReportLogEnable()) {
                return;
            }
            Logger.m119d(Constants.TAG, "report log disable");
        }
    }

    private boolean sendMemory() {
        LogModel logModel;
        if (this.cacheLog.isEmpty()) {
            return true;
        }
        boolean z = true;
        for (UploadLogInfo uploadLogInfo : this.cacheLog.keySet()) {
            ConcurrentLinkedQueue<LogModel> concurrentLinkedQueue = this.cacheLog.get(uploadLogInfo);
            if (concurrentLinkedQueue != null) {
                LogModel[] logModelArr = (LogModel[]) concurrentLinkedQueue.toArray(new LogModel[0]);
                int length = logModelArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        logModel = null;
                        break;
                    }
                    logModel = logModelArr[i];
                    if (logModel.retryCount <= 0 || System.currentTimeMillis() - logModel.nextSendTime > 0) {
                        break;
                    }
                    i++;
                }
                if (logModel == null && concurrentLinkedQueue.size() > 0) {
                    logModel = concurrentLinkedQueue.peek();
                }
                if (logModel != null) {
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "sendMemory");
                    }
                    boolean sendLog = NetworkSender.getInstance(uploadLogInfo).sendLog(logModel.bytes);
                    if (sendLog) {
                        concurrentLinkedQueue.remove(logModel);
                    } else {
                        logModel.retryCount++;
                        logModel.nextSendTime = LogReportController.getInstance().getRetryInterval(logModel.retryCount) + System.currentTimeMillis();
                    }
                    if (!sendLog) {
                        z = false;
                    }
                }
            }
        }
        return z;
    }

    private boolean sendFile() {
        boolean z = true;
        for (UploadLogInfo uploadLogInfo : UploadLogManager.getUploadType()) {
            File sendFile = DiskFileHelper.getInstance().getSendFile(uploadLogInfo.getName());
            if (sendFile != null && sendFile.exists()) {
                if (NetworkSender.getInstance(uploadLogInfo).sendLog(FileUtils.readFileToByteArray(sendFile))) {
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "sendFile: success");
                    }
                    DiskFileHelper.getInstance().deleteLog(sendFile);
                } else {
                    DiskFileHelper.RetryMessage reportMessage = DiskFileHelper.getInstance().getReportMessage(sendFile);
                    int retryCount = reportMessage != null ? reportMessage.getRetryCount() + 1 : 0;
                    long retryInterval = LogReportController.getInstance().getRetryInterval(retryCount) + System.currentTimeMillis();
                    DiskFileHelper.getInstance().updateRetryMessage(sendFile, retryCount, retryInterval);
                    if (ApmContext.isDebugMode()) {
                        Logger.m119d(Constants.TAG, "sendfile error retry count:" + sendFile.getName() + "  " + retryCount + " nextRetryTime:" + retryInterval);
                    }
                    z = false;
                }
            }
        }
        return z;
    }

    private void reset() {
        this.retryCount = 1L;
        this.retryPollingInterval = 30000L;
    }

    private void deleteFiles(List<LogFile> list) {
        for (LogFile logFile : list) {
            try {
                if (logFile.getSource() != null) {
                    FileUtils.deleteFile(logFile.getSource());
                }
            } catch (Exception unused) {
                Logger.m124w(Constants.TAG, "delete LogFile's source File failed. logFile=" + logFile.getSource());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class LogModel {
        byte[] bytes;
        long nextSendTime;
        int retryCount;

        LogModel(byte[] bArr, int i, long j) {
            this.bytes = bArr;
            this.retryCount = i;
            this.nextSendTime = j;
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class InnerHolder {
        private static final LogSender instance = new LogSender();

        private InnerHolder() {
        }
    }
}
