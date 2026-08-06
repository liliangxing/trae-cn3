package com.bytedance.webx.seclink.base;

import com.bytedance.webx.seclink.request.CheckUrlResponse;

/* loaded from: classes6.dex */
public class CheckRecord {
    private CheckUrlResponse checkResult;
    private String url;

    public void setUrl(String str) {
        this.url = str;
    }

    public void setCheckResult(CheckUrlResponse checkUrlResponse) {
        this.checkResult = checkUrlResponse;
    }

    public String getUrl() {
        return this.url;
    }

    public CheckUrlResponse getCheckResult() {
        return this.checkResult;
    }
}
