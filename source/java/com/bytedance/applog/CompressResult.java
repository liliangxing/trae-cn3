package com.bytedance.applog;

import java.util.Map;

/* loaded from: classes3.dex */
public class CompressResult {
    private byte[] data;
    private int encodeType = -1;
    private Map<String, String> headers;

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] bArr) {
        this.data = bArr;
    }

    public int getEncodeType() {
        return this.encodeType;
    }

    public void setEncodeType(int i) {
        this.encodeType = i;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, String> map) {
        this.headers = map;
    }

    public static CompressResult origin(byte[] bArr) {
        CompressResult compressResult = new CompressResult();
        compressResult.setData(bArr);
        compressResult.setEncodeType(-1);
        return compressResult;
    }
}
