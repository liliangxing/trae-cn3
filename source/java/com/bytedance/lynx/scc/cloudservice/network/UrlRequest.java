package com.bytedance.lynx.scc.cloudservice.network;

import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes4.dex */
public class UrlRequest {
    private static final int DEFAULT_TIMEOUT_MS = 3000;
    private String body;
    private String method;
    private Map<String, String> paramMap;
    private int timeoutMs = 3000;
    private String url;

    public UrlRequest(String aUrl) {
        this.url = aUrl;
    }

    public Map<String, String> getParamMap() {
        return this.paramMap;
    }

    public void setParamMap(Map<String, String> paramMap) {
        this.paramMap = paramMap;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getTimeoutMs() {
        return this.timeoutMs;
    }

    public void setTimeoutMs(int timeoutMs) {
        this.timeoutMs = timeoutMs;
    }

    public String toString() {
        return "UrlRequest{paramMap=" + this.paramMap + ", url='" + this.url + "', method='" + this.method + "', body='" + this.body + "', timeoutMs=" + this.timeoutMs + AbstractJsonLexerKt.END_OBJ;
    }
}
