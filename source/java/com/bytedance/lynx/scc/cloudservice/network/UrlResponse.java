package com.bytedance.lynx.scc.cloudservice.network;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class UrlResponse {
    private String errorMsg;
    private Map<String, List<String>> headers;
    private byte[] originalData;
    private int statusCode;

    public int getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public byte[] getOriginalData() {
        return this.originalData;
    }

    public void setOriginalData(byte[] originalData) {
        this.originalData = originalData;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Map<String, List<String>> getHeaders() {
        return this.headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public String toString() {
        return "UrlResponse{statusCode=" + this.statusCode + ", originalData=" + Arrays.toString(this.originalData) + ", errorMsg='" + this.errorMsg + "', headers=" + this.headers + AbstractJsonLexerKt.END_OBJ;
    }
}
