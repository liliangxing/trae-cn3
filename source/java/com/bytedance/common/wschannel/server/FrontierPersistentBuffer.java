package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.android.standard.tools.url.UrlUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.utils.DiskStorageUtils;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager;
import com.bytedance.common.wschannel.utils.WsAsyncTask;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class FrontierPersistentBuffer {
    private static final int BYTEBUFFER_CREATED_FAILED = 5;
    private static final int BYTEBUFFER_INIT_SUCCESS = 4;
    private static final int DATA_ITEM_SIZE = 40;
    public static final short FILE_VERSION = 1;
    private static final int HEADER_SIZE = 12;
    public static final short MAGIC_NUMBER = 2114;
    private static final int MAX_DATA_SIZE = 262144;
    private static final int MESSAGE_DROP_SUCCESS = 0;
    private static final int MESSAGE_ID_LENGTH = 32;
    private static final int MESSAGE_PERSISTENT_ERROR = 1;
    private static final int REMOVE_EXPIRED_CACHE = 2;
    private static final int REMOVE_EXPIRED_CACHE_INTERVAL_MS = 3600000;
    private static final int REMOVE_TOTAL_COUNT_AVAILABLE = 3;
    private static final String TAG = "FrontierPersistentBuffer";
    private static final int TIMESTAMP_LENGTH = 8;
    private static final int TOTAL_BYTES_THRESHOLD = 262104;
    private static final int TOTAL_COUNT_AVAILABLE = 1092;
    private static final int TOTAL_COUNT_THRESHOLD = 6553;
    private MappedByteBuffer mByteBuffer;
    private byte[] sNullData = new byte[40];
    private PriorityQueue<Integer> mAvailableOffsetQueue = new PriorityQueue<>();
    private ConcurrentHashMap<String, MessageContent> mMessageIdStorageMap = new ConcurrentHashMap<>();
    private final AtomicBoolean mFrontierBufferInitFailed = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static class MessageContent {
        private int mOffset;
        private long mTimeStamp;

        public MessageContent(long j, int i) {
            this.mTimeStamp = j;
            this.mOffset = i;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }

        public int getOffset() {
            return this.mOffset;
        }

        public void setOffset(int i) {
            this.mOffset = i;
        }
    }

    public FrontierPersistentBuffer(Context context) {
        FileChannel fileChannel;
        FileLock fileLock = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            fileChannel = new RandomAccessFile(DiskStorageUtils.getPersistentFile(context), "rw").getChannel();
            try {
                FileLock tryLock = fileChannel.tryLock();
                try {
                    this.mByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, 262144L);
                    if (Logger.debug()) {
                        Logger.m190d(TAG, "magic number: " + ((int) getMagicNumber()) + " file version: " + getFileVersion() + " total count: " + getTotalCount() + " total bytes: " + getTotalBytes());
                    }
                    if (getMagicNumber() == 2114 && getTotalBytes() > 0 && getTotalCount() > 0) {
                        initPersistentBuffer();
                        WsAsyncIOTaskManager.getInstance().postTask(new WsAsyncTask(3600000L, 3600000L) { // from class: com.bytedance.common.wschannel.server.FrontierPersistentBuffer.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (FrontierPersistentBuffer.this.mFrontierBufferInitFailed.get()) {
                                    return;
                                }
                                FrontierPersistentBuffer.this.removeExpiredCachedData();
                                FrontierPersistentBuffer.this.reportPersistentBufferLog(null, 2, -1L);
                            }
                        });
                        reportPersistentBufferLog(null, 4, System.currentTimeMillis() - currentTimeMillis);
                    }
                    reset();
                    WsAsyncIOTaskManager.getInstance().postTask(new WsAsyncTask(3600000L, 3600000L) { // from class: com.bytedance.common.wschannel.server.FrontierPersistentBuffer.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (FrontierPersistentBuffer.this.mFrontierBufferInitFailed.get()) {
                                return;
                            }
                            FrontierPersistentBuffer.this.removeExpiredCachedData();
                            FrontierPersistentBuffer.this.reportPersistentBufferLog(null, 2, -1L);
                        }
                    });
                    reportPersistentBufferLog(null, 4, System.currentTimeMillis() - currentTimeMillis);
                } catch (Throwable th) {
                    th = th;
                    fileLock = tryLock;
                    Logger.m194e(TAG, "create MappedByteBuffer failed: ", th);
                    this.mFrontierBufferInitFailed.set(true);
                    reportByteBufferCreatedError(5, th);
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (IOException unused) {
                            return;
                        }
                    }
                    if (fileChannel != null) {
                        fileChannel.close();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            fileChannel = null;
        }
    }

    public void initFinished() {
        FrontierMessageManager.setPersistentBufferInitFinished();
    }

    private void initPersistentBuffer() {
        this.mByteBuffer.position(12);
        long currentTimeMillis = System.currentTimeMillis();
        int totalBytes = getTotalBytes() / 40;
        boolean z = false;
        for (int i = 0; i < totalBytes; i++) {
            byte[] bArr = new byte[32];
            this.mByteBuffer.get(bArr);
            long j = this.mByteBuffer.getLong();
            if (isEmptyData(bArr)) {
                if (Logger.debug()) {
                    Logger.m190d(TAG, "Data is empty, bypass remove offset:" + i);
                }
                this.mAvailableOffsetQueue.add(Integer.valueOf(i));
            } else if (j < currentTimeMillis) {
                removeMessageFromFileByOffset(i);
                if (!z) {
                    z = true;
                }
            } else {
                String str = new String(bArr, StandardCharsets.UTF_8);
                MessageContent messageContent = new MessageContent(j, i);
                this.mMessageIdStorageMap.put(str, messageContent);
                if (Logger.debug()) {
                    Logger.m190d(TAG, "initPersistentBuffer item: " + new String(bArr) + "&" + messageContent.getTimeStamp() + "_" + messageContent.getOffset());
                }
            }
        }
        if (z) {
            flush();
        }
        if (Logger.debug()) {
            Logger.m190d(TAG, "map size:" + this.mMessageIdStorageMap.size() + " total count:" + getTotalCount() + " data size:" + totalBytes + " total bytes:" + getTotalBytes());
        }
    }

    private boolean isEmptyData(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            for (byte b : bArr) {
                if (b != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private short getMagicNumber() {
        return this.mByteBuffer.getShort(0);
    }

    private long getFileVersion() {
        return this.mByteBuffer.getShort(2);
    }

    private int getTotalCount() {
        return this.mByteBuffer.getInt(4);
    }

    private void setTotalCount(int i) {
        this.mByteBuffer.putInt(4, i);
    }

    private int getTotalBytes() {
        return this.mByteBuffer.getInt(8);
    }

    private void setTotalBytes(int i) {
        this.mByteBuffer.putInt(8, i);
    }

    private void reset() {
        Logger.m196i(TAG, "reset");
        this.mByteBuffer.clear();
        this.mByteBuffer.putShort(MAGIC_NUMBER);
        this.mByteBuffer.putShort((short) 1);
        this.mByteBuffer.putInt(0);
        this.mByteBuffer.putInt(0);
    }

    private void reportByteBufferCreatedError(int i, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", i);
            String outputThrowableStackTrace = Utils.outputThrowableStackTrace(th);
            if (!TextUtils.isEmpty(outputThrowableStackTrace) && outputThrowableStackTrace.length() > 2048) {
                outputThrowableStackTrace = outputThrowableStackTrace.substring(0, 2048);
            }
            jSONObject.put("exception", outputThrowableStackTrace);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        FrontierMessageManager.reportFrontierMessageLog(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportPersistentBufferLog(String str, int i, long j) {
        int size = this.mMessageIdStorageMap.size();
        int size2 = this.mAvailableOffsetQueue.size();
        int totalCount = getTotalCount();
        int totalBytes = getTotalBytes();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("messageId", str);
            }
            if (j >= 0) {
                jSONObject.put("duration", j);
            }
            jSONObject.put("action", i);
            jSONObject.put("mapSize", size);
            jSONObject.put("queueSize", size2);
            jSONObject.put("totalCount", totalCount);
            jSONObject.put("totalBytes", totalBytes);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        FrontierMessageManager.reportFrontierMessageLog(jSONObject);
    }

    public boolean shouldDropMessageAndUpdateFile(final String str, long j) {
        if (this.mFrontierBufferInitFailed.get()) {
            return false;
        }
        if (this.mMessageIdStorageMap.containsKey(str)) {
            Logger.m196i(TAG, "Drop existed messageId:" + str);
            WsAsyncIOTaskManager.getInstance().postTask(new WsAsyncTask() { // from class: com.bytedance.common.wschannel.server.FrontierPersistentBuffer.2
                @Override // java.lang.Runnable
                public void run() {
                    FrontierPersistentBuffer.this.reportPersistentBufferLog(str, 0, -1L);
                }
            });
            return true;
        }
        final long currentTimeMillis = System.currentTimeMillis() + j;
        this.mMessageIdStorageMap.put(str, new MessageContent(currentTimeMillis, -1));
        WsAsyncIOTaskManager.getInstance().postTask(new WsAsyncTask() { // from class: com.bytedance.common.wschannel.server.FrontierPersistentBuffer.3
            @Override // java.lang.Runnable
            public void run() {
                int mapToFile = FrontierPersistentBuffer.this.mapToFile(str, currentTimeMillis);
                if (mapToFile >= 0) {
                    MessageContent messageContent = (MessageContent) FrontierPersistentBuffer.this.mMessageIdStorageMap.get(str);
                    if (messageContent != null) {
                        messageContent.setOffset(mapToFile);
                    }
                    if (Logger.debug()) {
                        Logger.m190d(FrontierPersistentBuffer.TAG, "mapToFile success, message id:" + str + " offset:" + mapToFile);
                        return;
                    }
                    return;
                }
                FrontierPersistentBuffer.this.reportPersistentBufferLog(str, 1, -1L);
            }
        });
        return false;
    }

    public void ackMessage(String[] strArr) {
        if (Logger.debug()) {
            Logger.m190d(TAG, "ack message id: " + Arrays.toString(strArr));
        }
        if (this.mFrontierBufferInitFailed.get() || strArr == null || strArr.length == 0) {
            return;
        }
        final ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    if (str.getBytes(UrlUtils.UTF_8).length == 32) {
                        arrayList.add(str);
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        WsAsyncIOTaskManager.getInstance().postTask(new WsAsyncTask() { // from class: com.bytedance.common.wschannel.server.FrontierPersistentBuffer.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z = false;
                for (String str2 : arrayList) {
                    if (FrontierPersistentBuffer.this.mMessageIdStorageMap.containsKey(str2)) {
                        int offset = ((MessageContent) FrontierPersistentBuffer.this.mMessageIdStorageMap.get(str2)).getOffset();
                        FrontierPersistentBuffer.this.mMessageIdStorageMap.remove(str2);
                        FrontierPersistentBuffer.this.removeMessageFromFileByOffset(offset);
                        if (!z) {
                            z = true;
                        }
                    }
                }
                if (z) {
                    FrontierPersistentBuffer.this.flush();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeMessageFromFileByOffset(int i) {
        if (i < 0) {
            return;
        }
        this.mByteBuffer.position((i * 40) + 12);
        this.mByteBuffer.put(this.sNullData);
        setTotalCount(getTotalCount() - 1);
        this.mAvailableOffsetQueue.add(Integer.valueOf(i));
        if (Logger.debug()) {
            Logger.m190d(TAG, String.format("remove success: offset=%s, totalCount=%s, totalBytes=%s", Integer.valueOf(i), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes())));
        }
    }

    private int pushMessageInAvailableSlot(byte[] bArr, long j) {
        if (this.mAvailableOffsetQueue.isEmpty()) {
            return -1;
        }
        int intValue = this.mAvailableOffsetQueue.poll().intValue();
        this.mByteBuffer.position((intValue * 40) + 12);
        this.mByteBuffer.put(bArr);
        this.mByteBuffer.putLong(j);
        setTotalCount(getTotalCount() + 1);
        if (Logger.debug()) {
            Logger.m190d(TAG, String.format("push success in queue: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", Integer.valueOf(intValue), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), new String(bArr)));
        }
        return intValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mapToFile(String str, long j) {
        byte[] bytes = str.getBytes();
        if (bytes == null || bytes.length != 32) {
            return -1;
        }
        int pushMessageInAvailableSlot = pushMessageInAvailableSlot(bytes, j);
        if (pushMessageInAvailableSlot >= 0) {
            return pushMessageInAvailableSlot;
        }
        if (this.mByteBuffer.remaining() < 40 || getTotalCount() >= TOTAL_COUNT_THRESHOLD || getTotalBytes() >= TOTAL_BYTES_THRESHOLD) {
            String str2 = TAG;
            Logger.m196i(str2, "remaining:" + this.mByteBuffer.remaining() + " total count:" + getTotalCount() + " threshold:6553 total bytes:" + getTotalBytes() + " threshold:262104");
            reportPersistentBufferLog(str, 3, -1L);
            removeDataForAvailableStorage();
            int pushMessageInAvailableSlot2 = pushMessageInAvailableSlot(bytes, j);
            if (pushMessageInAvailableSlot2 >= 0) {
                return pushMessageInAvailableSlot2;
            }
            Logger.m193e(str2, "Push data failed, removeDataForAvailableStorage is not working.");
            return -1;
        }
        this.mByteBuffer.position(getTotalBytes() + 12);
        this.mByteBuffer.put(bytes);
        this.mByteBuffer.putLong(j);
        int totalCount = getTotalCount();
        setTotalCount(totalCount + 1);
        setTotalBytes(getTotalBytes() + 40);
        if (Logger.debug()) {
            Logger.m190d(TAG, String.format("push success in file: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", Integer.valueOf(totalCount), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), str));
        }
        flush();
        return totalCount;
    }

    private void removeDataForAvailableStorage() {
        Logger.m196i(TAG, "available:1092 queue:" + this.mAvailableOffsetQueue.size());
        Iterator<Map.Entry<String, MessageContent>> it = this.mMessageIdStorageMap.entrySet().iterator();
        while (it.hasNext()) {
            MessageContent value = it.next().getValue();
            if (value.getOffset() < TOTAL_COUNT_AVAILABLE) {
                removeMessageFromFileByOffset(value.getOffset());
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeExpiredCachedData() {
        if (Logger.debug()) {
            Logger.m190d(TAG, "removeExpiredCachedData");
        }
        Iterator<Map.Entry<String, MessageContent>> it = this.mMessageIdStorageMap.entrySet().iterator();
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = false;
        while (it.hasNext()) {
            MessageContent value = it.next().getValue();
            if (value.getTimeStamp() < currentTimeMillis) {
                removeMessageFromFileByOffset(value.getOffset());
                it.remove();
                if (!z) {
                    z = true;
                }
            }
        }
        if (z) {
            flush();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void flush() {
        this.mByteBuffer.force();
    }
}
