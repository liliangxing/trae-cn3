package com.lynx.tasm.provider;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes7.dex */
public class LynxResResponse {
    private String mEncoding;
    private InputStream mInputStream;
    private String mMimeType;
    private String mReasonPhrase = "Unknown error occurs in requesting resource.";
    private Map<String, List<String>> mResponseHeaders;
    private int mStatusCode;

    public String getMimeType() {
        return this.mMimeType;
    }

    public void setMimeType(String str) {
        this.mMimeType = str;
    }

    public String getEncoding() {
        return this.mEncoding;
    }

    public void setEncoding(String str) {
        this.mEncoding = str;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }

    public void setStatusCode(int i) {
        this.mStatusCode = i;
    }

    public String getReasonPhrase() {
        return this.mReasonPhrase;
    }

    public void setReasonPhrase(String str) {
        this.mReasonPhrase = str;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return this.mResponseHeaders;
    }

    public void setResponseHeaders(Map<String, List<String>> map) {
        this.mResponseHeaders = map;
    }

    public InputStream getInputStream() {
        return this.mInputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.mInputStream = inputStream;
    }
}
