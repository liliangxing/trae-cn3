package com.bytedance.lynx.scc.cloudservice;

/* loaded from: classes4.dex */
public class SccUrlCheckResult {
    private String mMatchRule;
    private boolean mSuccess;

    public SccUrlCheckResult(boolean success, String matchRule) {
        this.mSuccess = success;
        this.mMatchRule = matchRule;
    }

    public boolean isSuccess() {
        return this.mSuccess;
    }

    public String getMatchRule() {
        return this.mMatchRule;
    }

    public String toString() {
        return "SccUrlCheckResult{mSuccess=" + this.mSuccess + ", mMatchRule='" + this.mMatchRule + "'}";
    }
}
