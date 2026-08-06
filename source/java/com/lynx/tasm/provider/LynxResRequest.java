package com.lynx.tasm.provider;

import java.util.Map;

@Deprecated
/* loaded from: classes7.dex */
public class LynxResRequest {
    public static final String METHOD_GET = "GET";
    public static final String METHOD_POST = "POST";
    private String mExtraData;
    private Map<String, String> mHeaders;
    private Object mLynxExtraData;
    private String mMethod = "GET";
    private String mMimeType;
    private String mResponseType;
    private String mUrl;

    public LynxResRequest(String str, Object obj) {
        this.mUrl = str;
        this.mLynxExtraData = obj;
    }

    public String getUrl() {
        return this.mUrl;
    }

    public void setUrl(String str) {
        this.mUrl = str;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public void setMethod(String str) {
        this.mMethod = str;
    }

    public Map<String, String> getHeaders() {
        return this.mHeaders;
    }

    public void setHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public String getMineType() {
        return this.mMimeType;
    }

    public void setMineType(String str) {
        this.mMimeType = str;
    }

    public String getResponseType() {
        return this.mResponseType;
    }

    public void setResponseType(String str) {
        this.mResponseType = str;
    }

    public String getExtraData() {
        return this.mExtraData;
    }

    public void setExtraData(String str) {
        this.mExtraData = str;
    }

    public Object getLynxExtraData() {
        return this.mLynxExtraData;
    }
}
