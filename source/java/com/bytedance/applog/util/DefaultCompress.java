package com.bytedance.applog.util;

import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.AppLogInstance;
import com.bytedance.applog.CompressResult;
import com.bytedance.applog.ILogCompressor;
import com.bytedance.applog.compress.CompressManager;
import com.bytedance.applog.compress.CompressRecord;
import com.bytedance.applog.manager.ConfigManager;
import java.util.HashMap;

/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public class DefaultCompress implements ILogCompressor {
    private final CompressManager manager;
    private final ConfigManager sConfig;

    public DefaultCompress(AppLogInstance appLogInstance, ConfigManager configManager) {
        this.sConfig = configManager;
        this.manager = new CompressManager(appLogInstance.getContext(), appLogInstance.getLogger());
    }

    @Override // com.bytedance.applog.ILogCompressor
    public CompressResult compress(byte[] bArr) {
        CompressResult compressResult = new CompressResult();
        CompressRecord compressRecord = new CompressRecord();
        compressResult.setData(this.manager.compress(bArr, this.sConfig.getEncodeType(), compressRecord));
        compressResult.setEncodeType(compressRecord.encodeType);
        HashMap hashMap = new HashMap(4);
        if (compressRecord.encodeType == 0) {
            hashMap.put("log-encode-type", "gzip");
            hashMap.put("Content-Encoding", "gzip");
            hashMap.put("Content-Type", "application/octet-stream;tt-data=b");
        } else if (compressRecord.encodeType == 1 || compressRecord.encodeType == 2) {
            hashMap.put("log-encode-type", NetConst.TYPE_ZSTD);
            hashMap.put("log-encode-token", String.valueOf(0));
            hashMap.put("Content-Type", "application/octet-stream;tt-data=b");
        } else if (compressRecord.encodeType == -1) {
            hashMap.put("Content-Type", "application/json;charset=utf-8");
        }
        compressResult.setHeaders(hashMap);
        return compressResult;
    }
}
