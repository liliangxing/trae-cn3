package com.bytedance.android.monitor.entity;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes3.dex */
public class JSBInfo {
    public static final int STATUS_CODE_BUSINESS_ERROR = 4;
    public static final int STATUS_CODE_FAIL = 3;
    public static final int STATUS_CODE_NOT_FOUND = 2;
    public static final int STATUS_CODE_NO_LIMIT = 1;
    public static final int STATUS_CODE_SUCCESS = 0;
    public String bridgeName;
    public long callbackTime;
    public long costTime;
    public long fireEventTime;
    public long invokeTime;
    public String protocolVersion;
    public int statusCode;
    public String statusDescription;

    public String toString() {
        return "JSBInfo{bridgeName='" + this.bridgeName + "', statusCode=" + this.statusCode + ", statusDescription='" + this.statusDescription + "', protocolVersion='" + this.protocolVersion + "', costTime=" + this.costTime + ", invokeTime=" + this.invokeTime + ", callbackTime=" + this.callbackTime + ", fireEventTime=" + this.fireEventTime + AbstractJsonLexerKt.END_OBJ;
    }
}
