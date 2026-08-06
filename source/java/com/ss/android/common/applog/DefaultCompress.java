package com.ss.android.common.applog;

import android.content.Context;
import com.bytedance.applog.CompressResult;
import com.bytedance.applog.ILogCompressor;
import com.bytedance.applog.compress.CompressManager;
import com.bytedance.applog.compress.CompressRecord;
import com.bytedance.applog.compress.ICompressReporter;
import com.bytedance.applog.log.IAppLogLogger;
import com.ss.android.common.lib.AppLogNewUtils;
import com.ss.android.common.util.TLog;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import java.util.HashMap;
import org.json.JSONObject;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes7.dex */
public class DefaultCompress implements ILogCompressor {
    private final CompressManager manager;

    public DefaultCompress(Context context) {
        this.manager = new CompressManager(context, (String) null, new ICompressReporter() { // from class: com.ss.android.common.applog.DefaultCompress.1
            public void reportEvent(String str, JSONObject jSONObject) {
                AppLogNewUtils.onEventV3(str, jSONObject);
            }
        }, (IAppLogLogger) null);
    }

    public CompressResult compress(byte[] bArr) {
        CompressResult compressResult = new CompressResult();
        CompressRecord compressRecord = new CompressRecord();
        try {
            compressResult.setData(this.manager.compress(bArr, AppLog.getEncodeType(), compressRecord));
        } catch (Throwable th) {
            TLog.m76e("Compress do compress failed", th);
        }
        compressResult.setEncodeType(compressRecord.encodeType);
        HashMap hashMap = new HashMap(4);
        if (compressRecord.encodeType == 0) {
            hashMap.put("log-encode-type", DownloadHelper.GZIP);
            hashMap.put("Content-Encoding", DownloadHelper.GZIP);
            hashMap.put("Content-Type", "application/octet-stream;tt-data=b");
        } else if (compressRecord.encodeType == 1 || compressRecord.encodeType == 2) {
            hashMap.put("log-encode-type", "zstd");
            hashMap.put("log-encode-token", String.valueOf(0));
            hashMap.put("Content-Type", "application/octet-stream;tt-data=b");
        } else if (compressRecord.encodeType == -1) {
            hashMap.put("Content-Type", "application/json;charset=utf-8");
        }
        compressResult.setHeaders(hashMap);
        return compressResult;
    }
}
