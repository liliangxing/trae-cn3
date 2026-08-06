package com.ss.bduploader;

import org.json.JSONObject;

/* loaded from: classes7.dex */
public class BDExternResponseInfo {
    public byte[] responseBody;
    public JSONObject responseHeader;
    public String responseHeaderStr;
    public int statusCode;
    public String url;

    public JSONObject getResponseHeader() {
        return this.responseHeader;
    }

    public void setResponseHeader(JSONObject jSONObject) {
        this.responseHeader = jSONObject;
        if (jSONObject != null) {
            this.responseHeaderStr = jSONObject.toString();
        }
    }

    public byte[] getResponseBody() {
        return this.responseBody;
    }

    public void setResponseBody(byte[] bArr) {
        this.responseBody = bArr;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int i) {
        this.statusCode = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }
}
