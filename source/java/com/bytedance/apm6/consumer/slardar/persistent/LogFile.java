package com.bytedance.apm6.consumer.slardar.persistent;

import com.bytedance.apm6.consumer.slardar.Constants;
import com.bytedance.apm6.util.FileUtils;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class LogFile {
    private List<LogItem> logList;
    private File source;
    private long startID;
    private int totalBytes;
    private int totalCount;

    public LogFile(long j, int i, int i2, List<LogItem> list) {
        this.startID = j;
        this.totalCount = i;
        this.totalBytes = i2;
        this.logList = list;
    }

    public long getStartID() {
        return this.startID;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public int getTotalBytes() {
        return this.totalBytes;
    }

    public List<LogItem> getLogList() {
        return this.logList;
    }

    public File getSource() {
        return this.source;
    }

    public static LogFile fromMemory(ByteBuffer byteBuffer) {
        try {
            if (byteBuffer.getShort() != 2082) {
                return null;
            }
            long j = byteBuffer.getLong();
            int i = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = byteBuffer.getInt();
                i3 += i5;
                if (i3 > i2) {
                    return null;
                }
                byte[] bArr = new byte[i5];
                byteBuffer.get(bArr);
                arrayList.add(new LogItem(bArr));
            }
            return new LogFile(j, i, i2, arrayList);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static LogFile fromFile(File file) {
        try {
            byte[] readFileToByteArray = FileUtils.readFileToByteArray(file);
            if (readFileToByteArray != null) {
                LogFile fromMemory = fromMemory(ByteBuffer.wrap(readFileToByteArray));
                if (fromMemory != null) {
                    fromMemory.source = file;
                } else {
                    Logger.e(Constants.TAG, "fromMemory bytes is null");
                }
                return fromMemory;
            }
            Logger.e(Constants.TAG, "fromFile bytes is null");
            return null;
        } catch (Throwable th) {
            Logger.e(Constants.TAG, "fromFile", th);
            return null;
        }
    }

    public String toString() {
        return "LogFile{startID=" + this.startID + ", totalCount=" + this.totalCount + ", totalBytes=" + this.totalBytes + ", source=" + this.source + ", logList=" + this.logList + AbstractJsonLexerKt.END_OBJ;
    }
}
