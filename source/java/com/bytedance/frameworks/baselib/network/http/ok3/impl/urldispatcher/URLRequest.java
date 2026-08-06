package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import com.bytedance.retrofit2.client.Header;
import java.util.List;

/* loaded from: classes2.dex */
public class URLRequest {
    private int mDispatchPriority;
    private final List<Header> mHeaders;
    private String mMethod;
    private String mOriginUrl;

    public URLRequest(String str, String str2) {
        this.mOriginUrl = str;
        this.mMethod = str2;
        this.mDispatchPriority = 0;
        this.mHeaders = null;
    }

    public URLRequest(String str, String str2, List<Header> list) {
        this.mOriginUrl = str;
        this.mMethod = str2;
        this.mDispatchPriority = 0;
        this.mHeaders = list;
    }

    public void setMethod(String str) {
        this.mMethod = str;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public void setOriginUrl(String str) {
        this.mOriginUrl = str;
    }

    public String getOriginUrl() {
        return this.mOriginUrl;
    }

    public void setDispatchPriority(int i) {
        this.mDispatchPriority = i;
    }

    public int getDispatchPriority() {
        return this.mDispatchPriority;
    }

    public List<Header> getHeaders() {
        return this.mHeaders;
    }
}
