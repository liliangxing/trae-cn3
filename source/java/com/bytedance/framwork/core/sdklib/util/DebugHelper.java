package com.bytedance.framwork.core.sdklib.util;

import com.bytedance.framwork.core.sdklib.apm6.SDKContext;
import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.ss.android.common.util.ToolUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes2.dex */
public class DebugHelper {
    private static final String KEY_SEQ_NO = "seq_no";
    private static final String KEY_SEQ_PROCESS_NAME = "process_name";
    private static MappedByteBuffer sMappedByteBuffer;

    public static synchronized void addSeqNum(JSONObject jSONObject) {
        synchronized (DebugHelper.class) {
            try {
                synchronized (SDKMonitor.class) {
                    String curProcessName = ToolUtils.getCurProcessName(SDKContext.getContext());
                    if (sMappedByteBuffer == null) {
                        File file = new File(SDKContext.getContext().getFilesDir(), "sdk_" + curProcessName + "_seq_num.txt");
                        boolean exists = file.exists();
                        if (!exists) {
                            file.createNewFile();
                        }
                        MappedByteBuffer map = new RandomAccessFile(file, "rws").getChannel().map(FileChannel.MapMode.READ_WRITE, 0L, 8L);
                        sMappedByteBuffer = map;
                        if (!exists) {
                            map.putLong(0, 0L);
                        }
                    }
                    long j = sMappedByteBuffer.getLong(0);
                    jSONObject.put(KEY_SEQ_NO, j);
                    jSONObject.put(KEY_SEQ_PROCESS_NAME, curProcessName);
                    sMappedByteBuffer.putLong(0, j + 1);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
