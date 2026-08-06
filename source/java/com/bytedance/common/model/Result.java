package com.bytedance.common.model;

/* loaded from: classes3.dex */
public class Result {
    public static final int CODE_ALLOW_REQUEST_LOCAL_PUSH = 16;
    public static final int CODE_ALLOW_REQUEST_RED_BADGE = 1;
    public static final int CODE_FAILED = -1;
    public static final int CODE_UNKNOWN = 0;
    public static final int DETAIL_ERROR_CODE_RESPONSE_ERROR = 101;
    private int mCode = 0;
    private int mDetailCode = 0;
    private String mMessage = "";
    private long mRequestId;

    public Result withCode(int i) {
        this.mCode = i;
        return this;
    }

    public Result withDetailCode(int i) {
        this.mDetailCode = i;
        return this;
    }

    public Result withMessage(String str) {
        this.mMessage = str;
        return this;
    }

    public Result withRequestId(long j) {
        this.mRequestId = j;
        return this;
    }

    public long getRequestId() {
        return this.mRequestId;
    }

    public int getCode() {
        return this.mCode;
    }

    public int getDetailCode() {
        return this.mDetailCode;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public boolean allowRequestPull() {
        return allowRequestRedBadge() || allowRequestLocalPush();
    }

    public boolean allowRequestLocalPush() {
        int i = this.mCode;
        return (i == 0 || i == -1 || (i & 16) == 0) ? false : true;
    }

    public boolean allowRequestRedBadge() {
        int i = this.mCode;
        return (i == 0 || i == -1 || (i & 1) == 0) ? false : true;
    }

    public String toString() {
        return "Result{mCode=" + this.mCode + ", mDetailCode=" + this.mDetailCode + ", mMessage='" + this.mMessage + "'}";
    }
}
