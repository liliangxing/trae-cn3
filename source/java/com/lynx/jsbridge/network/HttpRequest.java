package com.lynx.jsbridge.network;

import com.lynx.react.bridge.JavaOnlyMap;

/* loaded from: classes6.dex */
public class HttpRequest {
    private String mHttpMethod = "";
    private String mUrl = "";
    private String mOriginUrl = "";
    private byte[] mHttpBody = null;
    private JavaOnlyMap mHttpHeaders = new JavaOnlyMap();
    private JavaOnlyMap mCustomConfig = new JavaOnlyMap();

    public static HttpRequest CreateHttpRequest(String str, String str2, String str3, byte[] bArr, JavaOnlyMap javaOnlyMap, JavaOnlyMap javaOnlyMap2) {
        HttpRequest httpRequest = new HttpRequest();
        httpRequest.mHttpMethod = str;
        httpRequest.mUrl = str2;
        httpRequest.mOriginUrl = str3;
        httpRequest.mHttpBody = bArr;
        httpRequest.mHttpHeaders = javaOnlyMap;
        httpRequest.mCustomConfig = javaOnlyMap2;
        return httpRequest;
    }

    public String getHttpMethod() {
        return this.mHttpMethod;
    }

    public void setHttpMethod(String str) {
        this.mHttpMethod = str;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
    }

    public byte[] getHttpBody() {
        return this.mHttpBody;
    }

    public void setHttpBody(byte[] bArr) {
        this.mHttpBody = bArr;
    }

    public JavaOnlyMap getHttpHeaders() {
        return this.mHttpHeaders;
    }

    public void setHttpHeaders(JavaOnlyMap javaOnlyMap) {
        this.mHttpHeaders = javaOnlyMap;
    }

    public JavaOnlyMap getCustomConfig() {
        return this.mCustomConfig;
    }

    public void setCustomConfig(JavaOnlyMap javaOnlyMap) {
        this.mCustomConfig = javaOnlyMap;
    }
}
