package com.bytedance.bdinstall.storage;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.ExecutorUtil;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.util.StringEncryptUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class ExternalCache extends Cache {
    private static final int FILE_MAX_SIZE = 2048;
    private static final String TAG = "DirectoryCacheHelper";
    private static volatile Pair<byte[], String> sCipherTextCache;
    private static volatile Pair<String, byte[]> sClearTextCache;
    private String cacheDir;
    private String mAid;
    private volatile Map<String, String> mCachedParams;
    private final Context mContext;
    private final boolean mEnableWrite;
    private final String mFileName;
    private final String mKey;
    private AtomicBoolean mIsDelayingToWrite = new AtomicBoolean(false);
    private final String mState = Environment.getExternalStorageState();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ExternalCache(Context context, boolean z, String str, String str2, String str3, String str4) {
        this.cacheDir = str;
        this.mEnableWrite = z;
        this.mContext = context;
        this.mFileName = str2;
        this.mKey = str3;
        this.mAid = str4;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void cacheString(String str, String str2) {
        storeValue(str, str2);
    }

    private String getCachePath() {
        return this.cacheDir + "/" + this.mFileName;
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public String getCachedString(String str) {
        return getStorageValue(str);
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected String[] getCachedStringArray(String str) {
        String storageValue = getStorageValue(str);
        if (TextUtils.isEmpty(storageValue)) {
            return null;
        }
        return storageValue.split("\n");
    }

    @Override // com.bytedance.bdinstall.storage.Cache
    protected void cacheStringArray(String str, String[] strArr) {
        if (str == null || strArr == null) {
            return;
        }
        cacheString(str, TextUtils.join("\n", strArr));
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0137, code lost:
    
        if (r4 == null) goto L68;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String getStorageValue(String str) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        byte[] bArr;
        int read;
        if (!TextUtils.isEmpty(str) && this.mCachedParams != null) {
            String str2 = this.mCachedParams.get(str);
            if (DrLog.debug()) {
                DrLog.m143v("get key = " + str + " value = " + str2 + " way = memory dir = " + getCachePath());
            }
            return str2;
        }
        if (!"mounted".equals(this.mState)) {
            return null;
        }
        try {
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
            fileLock = null;
        }
        if (!new File(this.cacheDir).exists()) {
            if (this.mCachedParams == null) {
                this.mCachedParams = new ConcurrentHashMap();
            }
            return null;
        }
        File file = new File(getCachePath());
        randomAccessFile = new RandomAccessFile(file, "rwd");
        try {
            fileLock = randomAccessFile.getChannel().lock();
            try {
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!(th instanceof IOException)) {
                        th.printStackTrace();
                    }
                    if (this.mCachedParams == null) {
                        this.mCachedParams = new ConcurrentHashMap();
                    }
                    if (fileLock != null) {
                        try {
                            fileLock.release();
                        } catch (Exception unused) {
                        }
                    }
                } finally {
                }
            }
        } catch (Throwable th3) {
            th = th3;
            fileLock = null;
        }
        if (file.isFile() && (read = randomAccessFile.read((bArr = new byte[2049]), 0, 2049)) > 0 && read < 2049) {
            this.mCachedParams = json2Map(decrypt(Arrays.copyOf(bArr, read)));
            if (TextUtils.isEmpty(str)) {
                if (this.mCachedParams == null) {
                    this.mCachedParams = new ConcurrentHashMap();
                }
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception unused2) {
                    }
                }
                try {
                    randomAccessFile.close();
                } catch (Exception unused3) {
                }
                return null;
            }
            String str3 = this.mCachedParams.get(str);
            if (DrLog.debug()) {
                DrLog.m143v("get key = " + str + " value = " + str3 + " way = file dir = " + getCachePath());
            }
            if (this.mCachedParams == null) {
                this.mCachedParams = new ConcurrentHashMap();
            }
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused4) {
                }
            }
            try {
                randomAccessFile.close();
            } catch (Exception unused5) {
            }
            return str3;
        }
        if (this.mCachedParams == null) {
            this.mCachedParams = new ConcurrentHashMap();
        }
        if (fileLock != null) {
            try {
                fileLock.release();
            } catch (Exception unused6) {
            }
        }
        try {
            randomAccessFile.close();
        } catch (Exception unused7) {
            return null;
        }
    }

    private Map<String, String> json2Map(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return new ConcurrentHashMap();
        }
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            concurrentHashMap.put(next, (String) jSONObject.get(next));
        }
        return concurrentHashMap;
    }

    private void storeValue(String str, String str2) {
        if (this.mCachedParams == null) {
            getStorageValue(null);
            if (this.mCachedParams == null) {
                this.mCachedParams = new ConcurrentHashMap();
            }
        }
        if (Utils.equal(this.mCachedParams.get(str), str2)) {
            return;
        }
        if (TextUtils.isEmpty(str2) && this.mCachedParams.containsKey(str)) {
            this.mCachedParams.remove(str);
        } else if (!TextUtils.isEmpty(str2)) {
            this.mCachedParams.put(str, str2);
        }
        if (this.mEnableWrite && this.mIsDelayingToWrite.compareAndSet(false, true)) {
            ExecutorUtil.getHandler(this.mAid).postDelayed(new Runnable() { // from class: com.bytedance.bdinstall.storage.ExternalCache.1
                @Override // java.lang.Runnable
                public void run() {
                    ExecutorUtil.runOnIOExecutor(ExternalCache.this.mAid, new WriteRunnable());
                }
            }, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void write(String str) {
        RandomAccessFile randomAccessFile;
        File file;
        if (!"mounted".equals(this.mState)) {
            return;
        }
        FileLock fileLock = null;
        try {
            file = new File(this.cacheDir);
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        if (!file.exists() && !file.mkdirs()) {
            return;
        }
        randomAccessFile = new RandomAccessFile(new File(getCachePath()), "rwd");
        try {
            fileLock = randomAccessFile.getChannel().lock();
            byte[] encrypt = encrypt(str);
            randomAccessFile.setLength(0L);
            randomAccessFile.write(encrypt);
            if (fileLock != null) {
                try {
                    fileLock.release();
                } catch (Exception unused) {
                }
            }
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!(th instanceof IOException)) {
                    th.printStackTrace();
                }
                if (fileLock != null) {
                    try {
                        fileLock.release();
                    } catch (Exception unused2) {
                    }
                }
                if (randomAccessFile == null) {
                    return;
                }
                randomAccessFile.close();
            } finally {
            }
        }
        try {
            randomAccessFile.close();
        } catch (Exception unused3) {
        }
    }

    @Override // com.bytedance.bdinstall.storage.Cache, com.bytedance.bdinstall.storage.ICache
    public void clear(List<String> list) {
        if (list == null) {
            return;
        }
        for (String str : list) {
            if (this.mCachedParams != null) {
                this.mCachedParams.remove(str);
            }
            storeValue(str, null);
        }
        super.clear(list);
    }

    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    private class WriteRunnable implements Runnable {
        private WriteRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExternalCache.this.mIsDelayingToWrite.set(false);
            String str = "";
            try {
                if (ExternalCache.this.mCachedParams != null) {
                    ExternalCache externalCache = ExternalCache.this;
                    str = externalCache.map2Json(externalCache.mCachedParams);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ExternalCache.this.write(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String map2Json(Map<String, String> map) throws JSONException {
        if (map == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
        return jSONObject.toString();
    }

    private String decrypt(byte[] bArr) {
        String str;
        if (sCipherTextCache != null && Arrays.equals(bArr, (byte[]) sCipherTextCache.first)) {
            return (String) sCipherTextCache.second;
        }
        if (sClearTextCache != null && Arrays.equals(bArr, (byte[]) sClearTextCache.second)) {
            return (String) sClearTextCache.first;
        }
        try {
            str = StringEncryptUtils.decryptAES(bArr, this.mKey);
        } catch (Throwable th) {
            th.printStackTrace();
            str = null;
        }
        if (str != null) {
            sCipherTextCache = new Pair<>(bArr, str);
        }
        return str;
    }

    private byte[] encrypt(String str) {
        byte[] bArr;
        if (sClearTextCache != null && Utils.equal(str, (String) sClearTextCache.first)) {
            return (byte[]) sClearTextCache.second;
        }
        if (sCipherTextCache != null && Utils.equal(str, (String) sCipherTextCache.second)) {
            return (byte[]) sCipherTextCache.first;
        }
        try {
            bArr = StringEncryptUtils.encryptAES(str, this.mKey);
        } catch (Throwable th) {
            th.printStackTrace();
            bArr = null;
        }
        if (bArr != null) {
            sClearTextCache = new Pair<>(str, bArr);
        }
        return bArr;
    }
}
