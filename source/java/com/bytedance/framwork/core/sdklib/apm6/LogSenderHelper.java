package com.bytedance.framwork.core.sdklib.apm6;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
class LogSenderHelper {
    private static final String JOINER = "_";
    private static final long MAX_EXPIRE_TIME = 604800000;
    private static final String REPORT_MESSAGE = "sdk_log_report_message";
    private static final String SUFFIX = ".log";
    private volatile boolean inited;
    private long lastCleanUpTime;
    private ConcurrentHashMap<String, RetryMessage> retryMessages;
    private SharedPreferences sharedPreferences;

    private LogSenderHelper() {
        this.retryMessages = new ConcurrentHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static LogSenderHelper getInstance() {
        return InnerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean saveFile(byte[] bArr, int i, long j) {
        ensureInit();
        if (DiskEnvironmentHelper.getLogDirectory() == null) {
            return false;
        }
        File file = new File(DiskEnvironmentHelper.getLogDirectory(), String.format("%d%s%s%s", Long.valueOf(System.currentTimeMillis()), JOINER, UUID.randomUUID().toString(), SUFFIX));
        FileChannel fileChannel = null;
        try {
            updateRetryMessage(file, i, j);
            fileChannel = new FileOutputStream(file).getChannel();
            fileChannel.write(ByteBuffer.wrap(bArr));
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "saveFile:" + file.getName());
            }
            return true;
        } catch (Throwable th) {
            try {
                Logger.m1307e(Constants.TAG, "saveFile:" + file.getName(), th);
                return false;
            } finally {
                IOUtils.closeQuietly(fileChannel);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void deleteLog(File file) {
        if (file == null) {
            return;
        }
        ensureInit();
        FileUtils.deleteFile(file);
        this.retryMessages.remove(file.getName());
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.remove(file.getName());
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized File getSendFile() {
        File logDirectory = DiskEnvironmentHelper.getLogDirectory();
        File file = null;
        if (logDirectory == null) {
            return null;
        }
        String[] list = logDirectory.list();
        if (list != null && list.length != 0) {
            List asList = Arrays.asList(list);
            Collections.sort(asList, new Comparator<String>() { // from class: com.bytedance.framwork.core.sdklib.apm6.LogSenderHelper.1
                @Override // java.util.Comparator
                public int compare(String str, String str2) {
                    return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
                }
            });
            Iterator it = asList.iterator();
            RetryMessage retryMessage = null;
            while (it.hasNext()) {
                File file2 = new File(logDirectory, (String) it.next());
                RetryMessage reportMessage = getReportMessage(file2);
                if (reportMessage != null) {
                    if (SDKContext.isDebugMode()) {
                        Logger.m1305d(Constants.TAG, "list send file:" + file2.getName() + " " + reportMessage.retryCount + " " + reportMessage.nextSendTime + " " + System.currentTimeMillis());
                    }
                    if (reportMessage.retryCount > LogReportController.getInstance().getMaxRetryCount()) {
                        deleteLog(file2);
                        Logger.m1306e(Constants.TAG, "retry count reached top");
                    } else if (reportMessage.retryCount != 0 && reportMessage.nextSendTime >= System.currentTimeMillis()) {
                        if (retryMessage == null || retryMessage.nextSendTime > reportMessage.nextSendTime) {
                            retryMessage = reportMessage;
                            file = file2;
                        }
                    }
                }
                file = file2;
            }
            return file;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RetryMessage getReportMessage(File file) {
        if (file == null) {
            return null;
        }
        ensureInit();
        String name = file.getName();
        if (this.retryMessages.containsKey(name)) {
            return this.retryMessages.get(name);
        }
        if (this.sharedPreferences.contains(name)) {
            String string = this.sharedPreferences.getString(name, "");
            r0 = TextUtils.isEmpty(string) ? null : RetryMessage.parse(string);
            if (r0 != null) {
                this.retryMessages.put(name, r0);
            }
        }
        return r0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateRetryMessage(File file, int i, long j) {
        RetryMessage retryMessage;
        if (file == null) {
            return;
        }
        ensureInit();
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        String name = file.getName();
        if (this.retryMessages.containsKey(name)) {
            retryMessage = this.retryMessages.get(name);
        } else {
            retryMessage = new RetryMessage(i, j);
            this.retryMessages.put(name, retryMessage);
        }
        retryMessage.update(i, j);
        edit.putString(name, retryMessage.getString());
        edit.commit();
    }

    synchronized void cleanExpireLog() {
        if (System.currentTimeMillis() - this.lastCleanUpTime < MAX_EXPIRE_TIME) {
            return;
        }
        this.lastCleanUpTime = System.currentTimeMillis();
        ensureInit();
        File logDirectory = DiskEnvironmentHelper.getLogDirectory();
        if (logDirectory == null) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        logDirectory.listFiles(new FileFilter() { // from class: com.bytedance.framwork.core.sdklib.apm6.LogSenderHelper.2
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                String name = file.getName();
                String string = LogSenderHelper.this.sharedPreferences.getString(name, "");
                boolean z = true;
                if (((!TextUtils.isEmpty(string) ? RetryMessage.parse(string) : null) != null ? r1.retryCount : 0) > LogReportController.getInstance().getMaxRetryCount()) {
                    arrayList.add(file.getName());
                } else {
                    try {
                        String[] split = name.split(LogSenderHelper.JOINER);
                        if (name.endsWith(LogSenderHelper.SUFFIX) && split.length == 2) {
                            if (System.currentTimeMillis() - Long.parseLong(split[0]) < LogSenderHelper.MAX_EXPIRE_TIME) {
                                z = false;
                            }
                        }
                    } catch (Throwable unused) {
                    }
                }
                if (z) {
                    if (SDKContext.isDebugMode()) {
                        Logger.m1305d(Constants.TAG, "cleanExpireLog:" + file.getName());
                    }
                    arrayList.add(file.getName());
                    FileUtils.deleteFile(file);
                }
                return false;
            }
        });
        if (arrayList.size() > 0) {
            Logger.m1306e(Constants.TAG, "cleanExpireLog:" + arrayList);
        }
    }

    private synchronized void ensureInit() {
        if (this.inited) {
            return;
        }
        this.sharedPreferences = SDKContext.getContext().getSharedPreferences(REPORT_MESSAGE, 0);
        this.inited = true;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    private static class InnerHolder {
        private static final LogSenderHelper instance = new LogSenderHelper();

        private InnerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
    public static class RetryMessage {
        private static final String SPLIT = "_";
        private long nextSendTime;
        private int retryCount;

        public RetryMessage(int i, long j) {
            this.retryCount = i;
            this.nextSendTime = j;
        }

        void update(int i, long j) {
            this.retryCount = i;
            this.nextSendTime = j;
        }

        public static RetryMessage parse(String str) {
            try {
                String[] split = str.split(SPLIT);
                if (split.length == 2) {
                    return new RetryMessage(Integer.parseInt(split[0]), Long.parseLong(split[1]));
                }
                return new RetryMessage(0, 0L);
            } catch (Exception e) {
                Logger.m1307e(Constants.TAG, "parseRetryMessage " + str, e);
                return null;
            }
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public String getString() {
            return this.retryCount + SPLIT + this.nextSendTime;
        }
    }
}
