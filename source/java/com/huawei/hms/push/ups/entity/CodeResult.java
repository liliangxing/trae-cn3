package com.huawei.hms.push.ups.entity;

/* loaded from: classes6.dex */
public class CodeResult {
    private int a;
    private String b;

    public CodeResult() {
    }

    public String getReason() {
        return this.b;
    }

    public int getReturnCode() {
        return this.a;
    }

    public void setReason(String str) {
        this.b = str;
    }

    public void setReturnCode(int i) {
        this.a = i;
    }

    public CodeResult(int i) {
        this.a = i;
    }

    public CodeResult(int i, String str) {
        this.a = i;
        this.b = str;
    }
}
