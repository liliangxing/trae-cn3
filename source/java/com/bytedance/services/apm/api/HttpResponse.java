package com.bytedance.services.apm.api;

import java.util.Map;

/* loaded from: classes5.dex */
public class HttpResponse {
    private Map<String, String> headers;
    private byte[] responseBytes;
    private int statusCode;

    public HttpResponse(int i, byte[] bArr) {
        this.statusCode = i;
        this.responseBytes = bArr;
    }

    public HttpResponse(int i, Map<String, String> map, byte[] bArr) {
        this.statusCode = i;
        this.headers = map;
        this.responseBytes = bArr;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public byte[] getResponseBytes() {
        return this.responseBytes;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }
}
