package com.bytedance.webx.seclink.request;

import android.text.TextUtils;

/* loaded from: classes6.dex */
public class CheckRecord {
    private String aid;
    private CheckUrlResponse checkResult;
    private long createTime = System.currentTimeMillis();
    private String errorMessage;
    private boolean isFinish;
    private String scene;
    private String url;

    public static String buildRecordKey(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        if (!TextUtils.isEmpty(str2)) {
            if (sb.length() > 0) {
                sb.append("_");
            }
            sb.append(str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            if (sb.length() > 0) {
                sb.append("_");
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public CheckRecord(String str, String str2, String str3) {
        this.aid = str;
        this.scene = str2;
        this.url = str3;
    }

    public String getRecordKey() {
        return buildRecordKey(this.aid, this.scene, this.url);
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(long j) {
        this.createTime = j;
    }

    public String getAid() {
        return this.aid;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public String getScene() {
        return this.scene;
    }

    public void setScene(String str) {
        this.scene = str;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setVerifyResult(CheckUrlResponse checkUrlResponse, String str) {
        this.checkResult = checkUrlResponse;
        this.errorMessage = str;
    }

    public CheckUrlResponse getCheckResult() {
        return this.checkResult;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public synchronized void setFinish(boolean z) {
        this.isFinish = z;
    }

    public synchronized boolean isFinish() {
        return this.isFinish;
    }
}
