package com.bytedance.applog.compress;

import android.content.Context;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class CompressManager {
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static byte[] mDictionary;
    private final Context mContext;
    private final IAppLogLogger mLogger;

    @Deprecated
    public static void setReportStatsEnabled(boolean z) {
    }

    public static void setZstdDict(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        mDictionary = Arrays.copyOf(bArr, bArr.length);
    }

    @Deprecated
    public CompressManager(Context context, String str, ICompressReporter iCompressReporter, IAppLogLogger iAppLogLogger) {
        this(context, iAppLogLogger);
    }

    public CompressManager(Context context, IAppLogLogger iAppLogLogger) {
        this.mContext = context;
        this.mLogger = iAppLogLogger == null ? LoggerImpl.global() : iAppLogLogger;
    }

    private int getEncodeType(int i) {
        if (i == 2 && mDictionary == null) {
            return 1;
        }
        return i;
    }

    public byte[] compress(byte[] bArr, int i, CompressRecord compressRecord) {
        int encodeType = getEncodeType(i);
        if (encodeType == 0) {
            bArr = compressUsingGzip(bArr, compressRecord);
        } else if (encodeType == 1 || encodeType == 2) {
            bArr = compressUsingZstd(bArr, compressRecord, i);
        }
        return (bArr == null || bArr.length == 0) ? compressUsingGzip(bArr, compressRecord) : bArr;
    }

    public byte[] compressUsingGzip(byte[] bArr, CompressRecord compressRecord) {
        compressRecord.dataSize = bArr == null ? 0 : bArr.length;
        compressRecord.encodeType = 0;
        long currentTimeMillis = System.currentTimeMillis();
        byte[] compress = Gzip.compress(bArr);
        long currentTimeMillis2 = System.currentTimeMillis();
        compressRecord.result = 0;
        compressRecord.compressTime = currentTimeMillis2 - currentTimeMillis;
        compressRecord.compressSize = compress.length;
        return compress;
    }

    public byte[] compressUsingZstd(byte[] bArr, CompressRecord compressRecord, int i) {
        byte[] compress;
        compressRecord.dataSize = bArr.length;
        compressRecord.encodeType = i;
        compressRecord.token = 0;
        byte[] bArr2 = null;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (i == 2 && mDictionary != null) {
                compress = ZstdCompress.compress(bArr, new ZstdDictCompress(mDictionary, 15));
            } else {
                compress = ZstdCompress.compress(bArr, 15);
            }
            bArr2 = compress;
            compressRecord.compressTime = System.currentTimeMillis() - currentTimeMillis;
            compressRecord.compressSize = bArr2.length;
            compressRecord.result = 0;
            return bArr2;
        } catch (Throwable th) {
            this.mLogger.error(14, "compress with zstd failed", th, new Object[0]);
            compressRecord.result = 1;
            return bArr2;
        }
    }
}
