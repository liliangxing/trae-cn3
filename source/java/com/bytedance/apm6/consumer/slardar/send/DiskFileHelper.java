package com.bytedance.apm6.consumer.slardar.send;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.ListUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
class DiskFileHelper {
    private static final String DOT = ".";
    private static final String JOINER = "_";
    private static final String LOG = "log";
    private static final long MAX_SIZE = 5000;
    private static final String REPORT_MESSAGE = "log_report_message";
    private File directory;
    private ArrayList<String> failedFiles;
    private volatile boolean failedFilesInited;
    private volatile boolean inited;
    private long remainSize;
    private ConcurrentHashMap<String, RetryMessage> retryMessages;
    private SharedPreferences sharedPreferences;

    private DiskFileHelper() {
        this.retryMessages = new ConcurrentHashMap<>();
        this.remainSize = 0L;
        this.failedFilesInited = false;
        this.failedFiles = new ArrayList<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DiskFileHelper getInstance() {
        return InnerHolder.instance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean saveFile(byte[] bArr, String str, int i, long j) {
        ensureInit();
        if (this.directory == null) {
            return false;
        }
        String format = String.format("%d%s%s%s%s", Long.valueOf(System.currentTimeMillis()), "_", UUID.randomUUID().toString(), DOT, str);
        File file = new File(this.directory, format);
        FileChannel fileChannel = null;
        try {
            updateRetryMessage(file, i, j);
            fileChannel = new FileOutputStream(file).getChannel();
            fileChannel.write(ByteBuffer.wrap(bArr));
            if (!this.failedFiles.contains(format)) {
                add(format);
            }
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "saveFile:" + file.getName());
            }
            return true;
        } catch (Throwable th) {
            try {
                Logger.m121e(Constants.TAG, "saveFile", th);
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
        this.failedFiles.remove(file.getName());
        ensureInit();
        FileUtils.deleteFile(file);
        this.retryMessages.remove(file.getName());
        SharedPreferences.Editor edit = this.sharedPreferences.edit();
        edit.remove(file.getName());
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized File getSendFile(String str) {
        String str2 = DOT + str;
        initFailedFiles();
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "failedFiles:" + this.failedFiles + " " + str2);
        }
        File file = null;
        if (this.failedFiles.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.failedFiles.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.endsWith(str2)) {
                arrayList.add(next);
            }
        }
        if (ListUtils.isEmpty(arrayList)) {
            return null;
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.bytedance.apm6.consumer.slardar.send.DiskFileHelper.1
            @Override // java.util.Comparator
            public int compare(String str3, String str4) {
                return String.CASE_INSENSITIVE_ORDER.compare(str3, str4);
            }
        });
        Iterator it2 = arrayList.iterator();
        RetryMessage retryMessage = null;
        while (it2.hasNext()) {
            File file2 = new File(getInstance().getDirectory(), (String) it2.next());
            RetryMessage reportMessage = getReportMessage(file2);
            if (reportMessage != null) {
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "list send file:" + file2.getName() + " " + reportMessage.retryCount + " " + reportMessage.nextSendTime + " " + System.currentTimeMillis());
                }
                if (reportMessage.retryCount != 0 && reportMessage.nextSendTime >= System.currentTimeMillis()) {
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public File getDirectory() {
        ensureInit();
        return this.directory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public File[] listFiles() {
        ensureInit();
        File file = this.directory;
        if (file == null) {
            return null;
        }
        return file.listFiles();
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
        try {
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
        } catch (Throwable th) {
            Logger.m121e(Constants.TAG, "updateRetryMessage", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getCreateTime(File file) {
        try {
            String[] split = file.getName().split("_");
            if (split.length != 2) {
                return -1L;
            }
            return Long.parseLong(split[0]);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private synchronized void ensureInit() {
        if (this.inited) {
            return;
        }
        File file = new File(DiskEnvironmentHelper.getWorkingDirectory(), LOG);
        if (!file.exists()) {
            file.mkdirs();
        }
        this.directory = file;
        this.sharedPreferences = ApmContext.getContext().getSharedPreferences(REPORT_MESSAGE, 0);
        this.inited = true;
    }

    private synchronized void initFailedFiles() {
        int i = 0;
        if (!this.failedFilesInited) {
            String[] list = getInstance().getDirectory().list();
            int length = list.length;
            while (i < length) {
                String str = list[i];
                if (!this.failedFiles.contains(str)) {
                    add(str);
                }
                i++;
            }
            this.failedFilesInited = true;
        } else if (this.remainSize > 0 && this.failedFiles.size() == 0) {
            String[] list2 = getInstance().getDirectory().list();
            int length2 = list2.length;
            while (i < length2) {
                String str2 = list2[i];
                if (!this.failedFiles.contains(str2)) {
                    add(str2);
                }
                i++;
            }
            this.remainSize -= this.failedFiles.size();
        }
    }

    private void add(String str) {
        if (this.failedFiles.size() > 5000) {
            this.remainSize++;
        } else {
            this.failedFiles.add(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class InnerHolder {
        private static DiskFileHelper instance = new DiskFileHelper();

        private InnerHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
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
                String[] split = str.split("_");
                return new RetryMessage(Integer.parseInt(split[0]), Long.parseLong(split[1]));
            } catch (Exception unused) {
                return null;
            }
        }

        public int getRetryCount() {
            return this.retryCount;
        }

        public String getString() {
            return this.retryCount + "_" + this.nextSendTime;
        }
    }
}
