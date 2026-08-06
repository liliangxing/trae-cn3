package com.bytedance.apm.impl;

import java.util.Map;

/* loaded from: classes3.dex */
public class HttpRequest {
    public byte[] data;
    public Map<String, String> headerMap;
    public String url;

    public HttpRequest(String str, Map<String, String> map) {
        this.url = str;
        this.headerMap = map;
    }

    public HttpRequest(String str, Map<String, String> map, byte[] bArr) {
        this.url = str;
        this.headerMap = map;
        this.data = bArr;
    }
}
