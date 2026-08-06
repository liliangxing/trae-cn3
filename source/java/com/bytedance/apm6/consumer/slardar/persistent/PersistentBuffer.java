package com.bytedance.apm6.consumer.slardar.persistent;

import com.bytedance.apm.doctor.DoctorDataUtil;
import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.consumer.slardar.DiskEnvironmentHelper;
import com.bytedance.apm6.consumer.slardar.LogReporter;
import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.monitor.Monitor;
import com.bytedance.apm6.monitor.Monitorable;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.IOUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class PersistentBuffer {
    private static final int BUFFER_SIZE = 262162;
    private static final int HEADER_SIZE = 18;
    public static final short MAGIC_NUMBER = 2082;
    private static final int MAX_DATA_SIZE = 262144;
    private static final String SUFFIX_LOG = ".log";
    private static final String SUFFIX_TMP = ".txt";
    private static final int TOTAL_BYTES_THRESHOLD = 262134;
    private static final int TOTAL_COUNT_THRESHOLD = 256;
    private ByteBuffer byteBuffer;
    private final File flushDir;
    private final long headerId;
    private FileLock lock;

    public PersistentBuffer(long j, File file, File file2) {
        this.flushDir = file2;
        this.headerId = j;
        try {
            FileChannel channel = new RandomAccessFile(file, "rw").getChannel();
            this.lock = channel.tryLock();
            this.byteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0L, 262162L);
            flush();
        } catch (Throwable th) {
            Logger.m121e(Constants.TAG, "create MappedByteBuffer failed. will fallback into HeapByteBuffer", th);
        }
        if (this.byteBuffer == null) {
            this.byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);
        }
        reset();
    }

    private void reset() {
        this.byteBuffer.clear();
        this.byteBuffer.putShort(MAGIC_NUMBER);
        this.byteBuffer.putLong(this.headerId);
        this.byteBuffer.putInt(0);
        this.byteBuffer.putInt(0);
    }

    private short getMagicNumber() {
        return this.byteBuffer.getShort(0);
    }

    private long getHeaderId() {
        return this.byteBuffer.getLong(2);
    }

    private int getTotalCount() {
        return this.byteBuffer.getInt(10);
    }

    private void setTotalCount(int i) {
        this.byteBuffer.putInt(10, i);
    }

    private int getTotalBytes() {
        return this.byteBuffer.getInt(14);
    }

    private void setTotalBytes(int i) {
        this.byteBuffer.putInt(14, i);
    }

    public synchronized void push(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        String jSONObject2 = jSONObject.toString();
        if (ApmContext.isDebugMode()) {
            DoctorDataUtil.saveToFileEvent(jSONObject);
        }
        byte[] bytes = jSONObject2.getBytes();
        int length = bytes.length + 4;
        if (length > MAX_DATA_SIZE) {
            Monitor.record(createLargeEvent(jSONObject));
            return;
        }
        if (length > this.byteBuffer.remaining()) {
            flush();
        }
        this.byteBuffer.putInt(bytes.length);
        this.byteBuffer.put(bytes);
        setTotalCount(getTotalCount() + 1);
        setTotalBytes(getTotalBytes() + length);
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, String.format("push success: totalCount=%s, totalBytes=%s, logItem=%s", Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), jSONObject2));
        }
        if (this.byteBuffer.position() >= TOTAL_BYTES_THRESHOLD || getTotalCount() >= 256) {
            flush();
        }
    }

    public synchronized void flush() {
        short magicNumber = getMagicNumber();
        long headerId = getHeaderId();
        int totalCount = getTotalCount();
        int totalBytes = getTotalBytes();
        if (magicNumber == 2082 && totalBytes > 0 && totalCount > 0) {
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "flushing: headerId=" + headerId + " totalCount=" + totalCount + " totalBytes=" + totalBytes);
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
                    Logger.m121e(Constants.TAG, "flushDir create error.", th);
                }
                File file = new File(this.flushDir, str + SUFFIX_TMP);
                if (file.exists()) {
                    Logger.m120e(Constants.TAG, "file is exist:" + file.getName());
                }
                fileChannel = new FileOutputStream(file, false).getChannel();
                this.byteBuffer.position(totalBytes + 18);
                this.byteBuffer.flip();
                fileChannel.write(this.byteBuffer);
                if (file.renameTo(new File(this.flushDir, str + SUFFIX_LOG))) {
                    z = true;
                } else {
                    Logger.m120e(Constants.TAG, "rename error" + file.getAbsolutePath());
                }
                if (ApmContext.isDebugMode()) {
                    Logger.m119d(Constants.TAG, "flush to file success. flushFile=" + file.getAbsolutePath());
                }
            } catch (Throwable th2) {
                try {
                    Logger.m121e(Constants.TAG, this.flushDir.exists() + " flush to file failed.", th2);
                } catch (Throwable unused) {
                }
            }
            IOUtils.closeQuietly(fileChannel);
            if (!z) {
                flushToMemory();
            }
            reset();
            if (ApmContext.isDebugMode()) {
                Logger.m119d(Constants.TAG, "flush cost=" + (System.nanoTime() - nanoTime));
            }
            return;
        }
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "flushing: Skipped. no data to flush. reset buffer now.");
        }
        reset();
    }

    private void flushToMemory() {
        this.byteBuffer.position(getTotalBytes() + 18);
        this.byteBuffer.flip();
        LogFile fromMemory = LogFile.fromMemory(this.byteBuffer);
        if (ApmContext.isDebugMode()) {
            Logger.m119d(Constants.TAG, "flush to memory success. logFile=" + fromMemory);
        }
        LogReporter.getInstance().saveLogFileInMemory(fromMemory);
    }

    public synchronized String[] list() {
        File[] listFiles = DiskEnvironmentHelper.getFlushDirectory().listFiles(new FileFilter() { // from class: com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer.1
            @Override // java.io.FileFilter
            public boolean accept(File file) {
                String name = file.getName();
                if (name.endsWith(PersistentBuffer.SUFFIX_LOG)) {
                    return true;
                }
                if (name.endsWith(PersistentBuffer.SUFFIX_TMP)) {
                    return false;
                }
                FileUtils.deleteFile(file);
                return false;
            }
        });
        if (listFiles == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (File file : listFiles) {
            arrayList.add(file.getName());
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private Monitorable createLargeEvent(JSONObject jSONObject) {
        final JSONObject optJSONObject = jSONObject != null ? jSONObject.optJSONObject("service") : null;
        final JSONObject optJSONObject2 = jSONObject != null ? jSONObject.optJSONObject("log_type") : null;
        return new Monitorable() { // from class: com.bytedance.apm6.consumer.slardar.persistent.PersistentBuffer.2
            @Override // com.bytedance.apm6.monitor.Monitorable
            public String getLogType() {
                return "service_monitor";
            }

            @Override // com.bytedance.apm6.monitor.Monitorable
            public boolean isValid() {
                return true;
            }

            @Override // com.bytedance.apm6.monitor.Monitorable
            public JSONObject toJsonObject() {
                try {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("log_type", "service_monitor");
                    jSONObject2.put("service", "apm_error");
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("type", "large_data");
                    jSONObject3.put("error_service", optJSONObject);
                    jSONObject3.put("error_log_type", optJSONObject2);
                    jSONObject2.put("category", jSONObject3);
                    return jSONObject2;
                } catch (Exception unused) {
                    return null;
                }
            }
        };
    }
}
