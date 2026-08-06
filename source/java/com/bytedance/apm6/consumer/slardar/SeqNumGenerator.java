package com.bytedance.apm6.consumer.slardar;

import com.bytedance.apm6.foundation.context.ApmContext;
import com.bytedance.apm6.util.log.Logger;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class SeqNumGenerator {
    private MappedByteBuffer byteBuffer;
    private long seqNum = 0;

    public static SeqNumGenerator getInstance() {
        return InnerHolder.instance;
    }

    public long next() {
        if (this.byteBuffer == null) {
            try {
                File file = new File(DiskEnvironmentHelper.getWorkingDirectory(), ApmContext.getCurrentProcessName().replace(".", "_").replace(":", "-") + "_seq_num.txt");
                boolean exists = file.exists();
                if (!exists) {
                    file.createNewFile();
                }
                MappedByteBuffer map = new RandomAccessFile(file, "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8L);
                this.byteBuffer = map;
                if (!exists) {
                    map.putLong(0, 0L);
                    return 0L;
                }
            } catch (Throwable th) {
                Logger.m121e(Constants.TAG, "prepare seq_number fail.", th);
            }
        }
        MappedByteBuffer mappedByteBuffer = this.byteBuffer;
        if (mappedByteBuffer != null) {
            long j = mappedByteBuffer.getLong(0) + 1;
            this.seqNum = j;
            this.byteBuffer.putLong(0, j);
            return this.seqNum;
        }
        long j2 = this.seqNum;
        this.seqNum = 1 + j2;
        return j2;
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private static class InnerHolder {
        private static final SeqNumGenerator instance = new SeqNumGenerator();

        private InnerHolder() {
        }
    }
}
