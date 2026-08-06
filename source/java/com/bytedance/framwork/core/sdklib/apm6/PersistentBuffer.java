package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class PersistentBuffer {
    private static final int BUFFER_SIZE = 262160;
    private static final int HEADER_SIZE = 16;
    public static final int MAGIC_NUMBER = 1095781686;
    private static final int MAX_DATA_SIZE = 262144;
    private static final long MAX_EXPIRE_TIME = 604800000;
    private static final String SUFFIX_LOG = ".log";
    private static final String SUFFIX_TMP = ".tmp";
    private static final int TOTAL_BYTES_THRESHOLD = 131072;
    private static final int TOTAL_COUNT_THRESHOLD = 100;
    public static final int VERSION = 1;
    private ByteBuffer byteBuffer;
    private final File flushDir;

    public PersistentBuffer(File file, File file2) {
        this.flushDir = file2;
        try {
            this.byteBuffer = new RandomAccessFile(file, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 262160L);
            flush();
        } catch (Throwable th) {
            Logger.m1307e(Constants.TAG, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        }
        if (this.byteBuffer == null) {
            this.byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        }
        reset();
    }

    private void reset() {
        this.byteBuffer.clear();
        this.byteBuffer.putInt(MAGIC_NUMBER);
        this.byteBuffer.putInt(1);
        this.byteBuffer.putInt(0);
        this.byteBuffer.putInt(0);
    }

    private int getMagicNumber() {
        return this.byteBuffer.getInt(0);
    }

    private int getVersion() {
        return this.byteBuffer.getInt(4);
    }

    private int getTotalCount() {
        return this.byteBuffer.getInt(8);
    }

    private void setTotalCount(int i) {
        this.byteBuffer.putInt(8, i);
    }

    private int getTotalBytes() {
        return this.byteBuffer.getInt(12);
    }

    private void setTotalBytes(int i) {
        this.byteBuffer.putInt(12, i);
    }

    public synchronized void push(long j, long j2, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String jSONObject2 = jSONObject.toString();
        byte[] bytes = jSONObject2.getBytes();
        int length = bytes.length + 4 + 16;
        if (length > 262144) {
            Logger.m1310w(Constants.TAG, "LogItem " + jSONObject2 + " is too large. please check it.");
            if (SDKContext.isDebugMode()) {
                throw new RuntimeException("LogItem is too large. please check it.");
            }
            return;
        }
        if (length > this.byteBuffer.remaining()) {
            flush();
        }
        this.byteBuffer.putInt(bytes.length);
        this.byteBuffer.putLong(j);
        this.byteBuffer.putLong(j2);
        this.byteBuffer.put(bytes);
        setTotalCount(getTotalCount() + 1);
        setTotalBytes(getTotalBytes() + length);
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s,", Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), jSONObject2));
        }
        if (this.byteBuffer.position() >= 131072 || getTotalCount() >= 100) {
            flush();
        }
    }

    public synchronized void flush() {
        int magicNumber = getMagicNumber();
        int version = getVersion();
        int totalCount = getTotalCount();
        int totalBytes = getTotalBytes();
        if (magicNumber == 1095781686 && totalBytes > 0 && totalCount > 0) {
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "flushing: magicNumber=" + magicNumber + " version=" + version + " totalCount=" + totalCount + " totalBytes=" + totalBytes);
            }
            long nanoTime = System.nanoTime();
            boolean z = false;
            FileChannel fileChannel = null;
            try {
                String str = System.currentTimeMillis() + "_" + UUID.randomUUID().toString();
                try {
                    if (!this.flushDir.exists()) {
                        File parentFile = this.flushDir.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        this.flushDir.mkdirs();
                    }
                } catch (Throwable th) {
                    Logger.m1307e(Constants.TAG, "flushDir create error.", th);
                }
                File file = new File(this.flushDir, str + SUFFIX_TMP);
                if (file.exists()) {
                    Logger.m1306e(Constants.TAG, "file is exist:" + file.getName());
                }
                fileChannel = new FileOutputStream(file, false).getChannel();
                this.byteBuffer.position(totalBytes + 16);
                this.byteBuffer.flip();
                fileChannel.write(this.byteBuffer);
                File file2 = new File(this.flushDir, str + SUFFIX_LOG);
                if (file.renameTo(file2)) {
                    z = true;
                } else {
                    Logger.m1306e(Constants.TAG, "rename error" + file.getAbsolutePath());
                }
                if (SDKContext.isDebugMode()) {
                    Logger.m1305d(Constants.TAG, "flush to file success. flushFile=" + file2.getAbsolutePath());
                }
            } catch (Throwable th2) {
                try {
                    Logger.m1307e(Constants.TAG, this.flushDir.exists() + " flush to file failed.", th2);
                } catch (Throwable unused) {
                }
            }
            IOUtils.closeQuietly(fileChannel);
            if (!z) {
                flushToMemory();
            }
            reset();
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "flush cost=" + (System.nanoTime() - nanoTime));
            }
            return;
        }
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "flushing: Skipped. no data to flush. reset buffer now.");
        }
        reset();
    }

    private void flushToMemory() {
        this.byteBuffer.position(getTotalBytes() + 16);
        this.byteBuffer.flip();
        LogFile fromMemory = LogFile.fromMemory(this.byteBuffer);
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "flush to memory success. logFile=" + fromMemory);
        }
        LogReporter.getInstance().saveLogFileInMemory(fromMemory);
    }

    public synchronized List<File> listReportFiles() {
        File file = this.flushDir;
        if (file == null) {
            return null;
        }
        File[] listFiles = file.listFiles(new FileFilter() { // from class: com.bytedance.framwork.core.sdklib.apm6.PersistentBuffer.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                String name = file2.getName();
                if (PersistentBuffer.this.isCanDelete(file2)) {
                    FileUtils.deleteFile(file2);
                    return false;
                }
                if (name.endsWith(PersistentBuffer.SUFFIX_LOG)) {
                    return true;
                }
                name.endsWith(PersistentBuffer.SUFFIX_TMP);
                return false;
            }
        });
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file2 : listFiles) {
            arrayList.add(file2.getName());
        }
        Collections.sort(arrayList, new Comparator<String>() { // from class: com.bytedance.framwork.core.sdklib.apm6.PersistentBuffer.2
            @Override // java.util.Comparator
            public int compare(String str, String str2) {
                return String.CASE_INSENSITIVE_ORDER.compare(str, str2);
            }
        });
        if (SDKContext.isDebugMode()) {
            Logger.m1305d(Constants.TAG, "reportFile: parsing " + arrayList.size() + " files. fileNameList" + arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(new File(this.flushDir, (String) arrayList.get(i)));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isCanDelete(File file) {
        String name = file.getName();
        boolean z = false;
        try {
            int indexOf = name.indexOf("_");
            if (indexOf != -1 && System.currentTimeMillis() - Long.parseLong(name.substring(0, indexOf)) >= MAX_EXPIRE_TIME) {
                z = true;
            }
            if (SDKContext.isDebugMode()) {
                Logger.m1305d(Constants.TAG, "fileName:" + name + " " + z);
            }
        } catch (Exception unused) {
        }
        return z;
    }
}
