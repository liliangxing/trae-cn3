package com.bytedance.sync.interfaze;

import com.ss.android.ug.bus.IUgBusService;
import java.io.File;

/* loaded from: classes5.dex */
public interface IFileDataCacheService extends IUgBusService {
    public static final String TYPE_HISTORY_SYNC_LOG = "historySyncLog";
    public static final String TYPE_SNAPSHOT = "snapshot";
    public static final String TYPE_SYNC_LOG = "synclog";

    boolean deleteAllFiles(long j);

    void deleteFile(String str);

    File getCachedDir();

    String putData(String str, long j, long j2, byte[] bArr);

    String putData(String str, long j, long j2, byte[] bArr, String str2);

    String readData(long j, String str);

    byte[] readDataV2(long j, String str);
}
