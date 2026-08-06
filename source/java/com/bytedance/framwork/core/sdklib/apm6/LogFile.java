package com.bytedance.framwork.core.sdklib.apm6;

import com.bytedance.apm6.util.FileUtils;
import com.bytedance.framwork.core.sdklib.apm6.safety.Logger;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes2.dex */
public class LogFile {
    private List<LogItem> logList;
    private File source;
    private int totalBytes;
    private int totalCount;

    public LogFile(int i, int i2, List<LogItem> list) {
        this.totalCount = i;
        this.totalBytes = i2;
        this.logList = list;
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
            if (byteBuffer.getInt() != 1095781686) {
                return null;
            }
            byteBuffer.getInt();
            int i = byteBuffer.getInt();
            int i2 = byteBuffer.getInt();
            ArrayList arrayList = new ArrayList();
            int i3 = 0;
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = byteBuffer.getInt();
                i3 += i5;
                if (i3 > i2) {
                    Logger.e(Constants.TAG, "construct LogFile failed.");
                    return null;
                }
                long j = byteBuffer.getLong();
                long j2 = byteBuffer.getLong();
                byte[] bArr = new byte[i5];
                byteBuffer.get(bArr);
                arrayList.add(new LogItem(bArr, j, j2));
            }
            return new LogFile(i, i2, arrayList);
        } catch (Throwable th) {
            Logger.e(Constants.TAG, "construct LogFile failed.", th);
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
        return "LogFile{totalCount=" + this.totalCount + ", totalBytes=" + this.totalBytes + ", source=" + this.source + ", logList=" + this.logList + AbstractJsonLexerKt.END_OBJ;
    }
}
