package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;

/* loaded from: classes6.dex */
public class HttpResponse {
    private int mStatusCode = 200;
    private String mStatusText = "OK";
    private String mUrl = "";
    private JavaOnlyMap mHttpHeaders = new JavaOnlyMap();
    private byte[] mHttpBody = new byte[0];
    private JavaOnlyMap mCustomInfo = new JavaOnlyMap();

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusText() {
        return this.mStatusText;
    }

    public JavaOnlyMap getHttpHeaders() {
        return this.mHttpHeaders;
    }

    public byte[] getHttpBody() {
        return this.mHttpBody;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public JavaOnlyMap getCustomInfo() {
        return this.mCustomInfo;
    }

    public void setCustomInfo(JavaOnlyMap javaOnlyMap) {
        this.mCustomInfo = javaOnlyMap;
    }

    public void setHttpBody(byte[] bArr) {
        this.mHttpBody = bArr;
    }

    public void setHttpHeaders(JavaOnlyMap javaOnlyMap) {
        this.mHttpHeaders = javaOnlyMap;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public void setStatusText(String str) {
        this.mStatusText = str;
    }

    public void setStatusCode(int i) {
        this.mStatusCode = i;
    }
}
