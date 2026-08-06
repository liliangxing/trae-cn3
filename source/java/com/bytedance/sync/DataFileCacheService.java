package com.bytedance.sync;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.common.utility.StringEncryptUtils;
import com.bytedance.common.utility.io.IOUtils;
import com.bytedance.sync.interfaze.IFileDataCacheService;
import com.bytedance.sync.logger.LogUtils;
import com.bytedance.sync.util.JSONUtils;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSink;
import okio.GzipSource;
import okio.Okio;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public class DataFileCacheService implements IFileDataCacheService {
    private static final String TAG = "FileCache  ";
    private final Context mContext;
    private final LruCache<String, byte[]> mLruCache = new DataSizedLRUCache(10485760);
    private final Map<String, Long> mMd5ToSyncIdMap = new HashMap();

    public DataFileCacheService(Context context) {
        this.mContext = context;
    }

    @Override // com.bytedance.sync.interfaze.IFileDataCacheService
    public String readData(long j, String str) {
        LogUtils.m188v("FileCache  readCache " + str);
        File file = new File(str);
        String name = file.getName();
        byte[] bArr = this.mLruCache.get(name);
        if (bArr == null) {
            LogUtils.m188v("FileCache  real readCache " + str);
            bArr = readFile(file);
        }
        try {
            String str2 = new String(bArr, "UTF-8");
            if (name.endsWith(SyncConstants.SEPARATOR + StringEncryptUtils.encrypt(str2, "MD5"))) {
                return str2;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtils.m186e("read data throw exception: " + th);
            return null;
        }
    }

    @Override // com.bytedance.sync.interfaze.IFileDataCacheService
    public byte[] readDataV2(long j, String str) {
        LogUtils.m188v("FileCache  readCache " + str);
        File file = new File(str);
        String name = file.getName();
        byte[] bArr = this.mLruCache.get(name);
        if (bArr == null) {
            LogUtils.m188v("FileCache  real readCache " + str);
            bArr = readFile(file);
        }
        try {
            if (name.endsWith(SyncConstants.SEPARATOR + StringEncryptUtils.encrypt(new String(bArr, "UTF-8"), "MD5"))) {
                return bArr;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            LogUtils.m186e("read data throw exception: " + th);
            return null;
        }
    }

    @Override // com.bytedance.sync.interfaze.IFileDataCacheService
    public String putData(String str, long j, long j2, byte[] bArr) {
        try {
            return putData(str, j, j2, bArr, StringEncryptUtils.encrypt(new String(bArr, "UTF-8"), "MD5"));
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.bytedance.sync.interfaze.IFileDataCacheService
    public String putData(String str, long j, long j2, byte[] bArr, String str2) {
        LogUtils.m188v("FileCache  putCache " + j + str2);
        String generateKey = generateKey(str, j2, str2);
        this.mLruCache.put(generateKey, bArr);
        this.mMd5ToSyncIdMap.put(generateKey, Long.valueOf(j));
        File path = getPath(j, generateKey);
        String absolutePath = path.getAbsolutePath();
        WriteResult writeFile = writeFile(path, bArr);
        JSONObject jSONObject = new JSONObject();
        JSONUtils.safePutParam(jSONObject, "file_path", absolutePath);
        JSONObject jSONObject2 = new JSONObject();
        JSONUtils.safePutParam(jSONObject2, "success", writeFile.success);
        if (!writeFile.success) {
            JSONUtils.safePutParam(jSONObject2, "error_msg", writeFile.errMsg);
        }
        SyncMonitor.monitor("sync_sdk_save_file_monitor", jSONObject2, null, jSONObject);
        if (writeFile.success) {
            return absolutePath;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    public static class WriteResult {
        String errMsg;
        boolean success;

        public WriteResult(boolean z, String str) {
            this.success = z;
            this.errMsg = str;
        }
    }

    private String generateKey(String str, long j, String str2) {
        return str + SyncConstants.SEPARATOR + j + SyncConstants.SEPARATOR + str2;
    }

    @Override // com.bytedance.sync.interfaze.IFileDataCacheService
    public boolean deleteAllFiles(long j) {
        LogUtils.m188v("FileCache  deleteAllFiles " + j);
        Iterator<Map.Entry<String, Long>> it = this.mMd5ToSyncIdMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Long> next = it.next();
            if (next.getValue() != null && next.getValue().longValue() == j) {
                it.remove();
            }
        }
        try {
            IOUtils.deletePath(new File(this.mContext.getFileStreamPath(SyncConstants.DIR_NAME), String.valueOf(j)).getAbsolutePath());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    @Override // com.bytedance.sync.interfaze.IFileDataCacheService
    public void deleteFile(String str) {
        LogUtils.m188v("FileCache  delete " + str);
        try {
            this.mLruCache.remove(new File(str).getName());
            IOUtils.deleteFile(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.bytedance.sync.interfaze.IFileDataCacheService
    public File getCachedDir() {
        return this.mContext.getFileStreamPath(SyncConstants.DIR_NAME);
    }

    private File getPath(long j, String str) {
        return new File(this.mContext.getFileStreamPath(SyncConstants.DIR_NAME), j + File.separator + str);
    }

    private byte[] readFile(File file) {
        BufferedSource bufferedSource;
        if (!file.exists()) {
            return null;
        }
        try {
            bufferedSource = Okio.buffer(new GzipSource(Okio.source(file)));
            try {
                return bufferedSource.readByteArray();
            } catch (Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    LogUtils.m186e("read file throw exception : " + th);
                    if (bufferedSource != null) {
                        try {
                            bufferedSource.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return null;
                } finally {
                    if (bufferedSource != null) {
                        try {
                            bufferedSource.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedSource = null;
        }
    }

    private WriteResult writeFile(File file, byte[] bArr) {
        BufferedSink buffer;
        BufferedSink bufferedSink = null;
        try {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            IOUtils.deleteFile(file.getAbsolutePath());
            file.createNewFile();
            buffer = Okio.buffer(new GzipSink(Okio.sink(file)));
        } catch (Throwable th) {
            th = th;
        }
        try {
            buffer.write(bArr);
            buffer.flush();
            WriteResult writeResult = new WriteResult(true, null);
            if (buffer != null) {
                try {
                    buffer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return writeResult;
        } catch (Throwable th2) {
            bufferedSink = buffer;
            th = th2;
            try {
                th.printStackTrace();
                return new WriteResult(false, th.getClass().toString() + ": " + th.getMessage());
            } finally {
                if (bufferedSink != null) {
                    try {
                        bufferedSink.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
    private static class DataSizedLRUCache extends LruCache<String, byte[]> {
        public DataSizedLRUCache(int i) {
            super(i);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.util.LruCache
        public int sizeOf(String str, byte[] bArr) {
            return bArr.length;
        }
    }
}
