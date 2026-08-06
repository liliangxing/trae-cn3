package com.bytedance.frameworks.baselib.network.http;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class RequestRetryResult {
    private Map<String, String> mAddRequestHeaders;
    private String mNextRetryUrl;
    private boolean mRemoveHitResponseHeaderIfNotRetry;
    private boolean mRequestRetryEnabled;

    public RequestRetryResult(boolean z, Map<String, String> map) {
        this.mRemoveHitResponseHeaderIfNotRetry = true;
        this.mRequestRetryEnabled = z;
        this.mAddRequestHeaders = map;
    }

    public RequestRetryResult(boolean z) {
        this.mRemoveHitResponseHeaderIfNotRetry = true;
        this.mRequestRetryEnabled = z;
    }

    public RequestRetryResult(boolean z, boolean z2, Map<String, String> map) {
        this.mRequestRetryEnabled = z;
        this.mRemoveHitResponseHeaderIfNotRetry = z2;
        this.mAddRequestHeaders = map;
    }

    public boolean isRequestRetryEnabled() {
        return this.mRequestRetryEnabled;
    }

    public void setRequestRetryEnabled(boolean z) {
        this.mRequestRetryEnabled = z;
    }

    public boolean isRemoveHitResponseHeaderIfNotRetry() {
        return this.mRemoveHitResponseHeaderIfNotRetry;
    }

    public void setRemoveHitResponseHeaderIfNotRetry(boolean z) {
        this.mRemoveHitResponseHeaderIfNotRetry = z;
    }

    public Map<String, String> getAddRequestHeaders() {
        return this.mAddRequestHeaders;
    }

    public void setAddRequestHeaders(Map<String, String> map) {
        this.mAddRequestHeaders = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNextRetryUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mNextRetryUrl = str;
    }

    public String getNextRetryUrl() {
        return this.mNextRetryUrl;
    }
}
