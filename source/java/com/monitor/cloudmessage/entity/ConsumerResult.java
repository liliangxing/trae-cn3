package com.monitor.cloudmessage.entity;

import java.util.HashMap;

/* loaded from: classes7.dex */
public class ConsumerResult {
    private String mErrMsg;
    private boolean mIsSuccess;
    private HashMap<String, String> specificParams;

    private ConsumerResult(boolean z, String str, HashMap<String, String> hashMap) {
        this.mIsSuccess = z;
        this.mErrMsg = str;
        this.specificParams = hashMap;
    }

    public boolean isSuccess() {
        return this.mIsSuccess;
    }

    public String getErrMsg() {
        return this.mErrMsg;
    }

    public HashMap<String, String> getSpecificParams() {
        return this.specificParams;
    }

    public static ConsumerResult build(boolean z, String str, HashMap<String, String> hashMap) {
        return new ConsumerResult(z, str, hashMap);
    }
}
