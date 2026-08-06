package com.bytedance.frameworks.baselib.network.requestaudit;

import com.bytedance.retrofit2.client.Header;
import java.util.List;

/* loaded from: classes2.dex */
public class RequestAuditParams {
    private final List<Header> requestHeaders;
    private final String requestUrl;

    public RequestAuditParams(String str, List<Header> list) {
        this.requestUrl = str;
        this.requestHeaders = list;
    }

    public String getRequestUrl() {
        return this.requestUrl;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }
}
