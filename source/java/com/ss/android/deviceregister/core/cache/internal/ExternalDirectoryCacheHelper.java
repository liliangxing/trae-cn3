package com.ss.android.deviceregister.core.cache.internal;

import android.content.Context;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.common.utility.concurrent.ThreadPlus;
import com.ss.android.common.util.TLog;
import com.ss.android.deviceregister.I18nController;
import com.ss.android.deviceregister.LogUtils;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class ExternalDirectoryCacheHelper extends CacheHelper {
    private static final int FILE_MAX_SIZE = 2048;
    private static final String TAG = "DirectoryCacheHelper";
    private static volatile Pair<byte[], String> sCipherTextCache;
    private static volatile Pair<String, byte[]> sClearTextCache;
    private String cacheDir;
    private final String fileName;
    private volatile Map<String, String> mCachedParams;
    private final Context mContext;
    private final boolean mEnableWrite;
    private final String mKey;
    private AtomicBoolean mIsDelayingToWrite = new AtomicBoolean(false);
    private final String mState = Environment.getExternalStorageState();

    public ExternalDirectoryCacheHelper(Context context, boolean z, String str, String str2, String str3) {
        this.cacheDir = str;
        this.mEnableWrite = z;
        this.mContext = context;
        this.fileName = str2;
        this.mKey = str3;
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    protected void cacheString(String str, String str2) {
        if (Logger.debug()) {
            TLog.m79v("DirectoryCacheHelper set key = " + str + " value = " + str2 + " dir = " + getCachePath());
        }
        storeValue(str, str2, false);
    }

    private String getCachePath() {
        return this.cacheDir + "/" + this.fileName;
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    protected String getCachedString(String str) {
        return getStorageValue(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:96:0x016d, code lost:
    
        if (r3 == null) goto L78;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private synchronized String getStorageValue(String str) {
        RandomAccessFile randomAccessFile;
        FileLock fileLock;
        byte[] bArr;
        int read;
        if (!StringUtils.isEmpty(str) && this.mCachedParams != null) {
            String str2 = this.mCachedParams.get(str);
            if (Logger.debug()) {
                TLog.m79v("DirectoryCacheHelper get key = " + str + " value = " + str2 + " way = memory dir = " + getCachePath());
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
            TLog.m79v("DirectoryCacheHelper dir : " + this.cacheDir + " not exist, read failed");
            if (this.mCachedParams == null) {
                this.mCachedParams = new ConcurrentHashMap();
            }
            return null;
        }
        File file = new File(getCachePath());
        randomAccessFile = new RandomAccessFile(file, "rwd");
        try {
            fileLock = randomAccessFile.getChannel().lock();
        } catch (Throwable th2) {
            th = th2;
            fileLock = null;
        }
        try {
        } catch (Throwable th3) {
            th = th3;
            try {
                if (!(th instanceof IOException)) {
                    th.printStackTrace();
                }
                TLog.m73d("DirectoryCacheHelper load openudid exception " + th);
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
        if (file.isFile() && (read = randomAccessFile.read((bArr = new byte[2049]), 0, 2049)) > 0 && read < 2049) {
            this.mCachedParams = json2Map(decrypt(Arrays.copyOf(bArr, read)));
            if (StringUtils.isEmpty(str)) {
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
            if (Logger.debug()) {
                TLog.m79v("DirectoryCacheHelper get key = " + str + " value = " + str3 + " way = disk dir = " + getCachePath());
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
        if (StringUtils.isEmpty(str)) {
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

    private void storeValue(String str, String str2, boolean z) {
        if (this.mCachedParams == null) {
            getStorageValue(null);
            if (this.mCachedParams == null) {
                this.mCachedParams = new ConcurrentHashMap();
            }
        }
        if (StringUtils.equal(this.mCachedParams.get(str), str2)) {
            return;
        }
        if (TextUtils.isEmpty(str2) && this.mCachedParams.containsKey(str)) {
            this.mCachedParams.remove(str);
        } else if (!TextUtils.isEmpty(str2)) {
            this.mCachedParams.put(str, str2);
        }
        if (z) {
            new WriteThread().run();
        } else if (this.mEnableWrite && this.mIsDelayingToWrite.compareAndSet(false, true)) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.ss.android.deviceregister.core.cache.internal.ExternalDirectoryCacheHelper.1
                @Override // java.lang.Runnable
                public void run() {
                    ThreadPlus.submitRunnable(new WriteThread());
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
                    TLog.m76e("DirectoryCacheHelper load exception ", th);
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
            randomAccessFile.close();
        } catch (Exception unused3) {
        }
    }

    @Override // com.ss.android.deviceregister.core.cache.internal.CacheHelper
    public void clear(String str) {
        storeValue(str, null, true);
        LogUtils.m88d(LogUtils.TAG, "ExternalDirectoryCacheHelper#clear key=" + str + " path=" + getCachePath() + " getCachedString(key)=" + getCachedString(str));
        super.clear(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
    public class WriteThread implements Runnable {
        private WriteThread() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExternalDirectoryCacheHelper.this.mIsDelayingToWrite.set(false);
            String str = "";
            try {
                if (ExternalDirectoryCacheHelper.this.mCachedParams != null) {
                    ExternalDirectoryCacheHelper externalDirectoryCacheHelper = ExternalDirectoryCacheHelper.this;
                    str = externalDirectoryCacheHelper.map2Json(externalDirectoryCacheHelper.mCachedParams);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            ExternalDirectoryCacheHelper.this.write(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String map2Json(Map<String, String> map) throws JSONException {
        if (map == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!I18nController.isI18n() || TextUtils.equals(entry.getKey(), "device_id")) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
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
            str = EncryptUtils.decrypt(bArr, this.mKey);
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
        if (sClearTextCache != null && StringUtils.equal(str, (String) sClearTextCache.first)) {
            return (byte[]) sClearTextCache.second;
        }
        if (sCipherTextCache != null && StringUtils.equal(str, (String) sCipherTextCache.second)) {
            return (byte[]) sCipherTextCache.first;
        }
        try {
            bArr = EncryptUtils.encrypt(str, this.mKey);
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
