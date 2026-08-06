package com.bytedance.android.monitorV2.entity;

/* loaded from: classes3.dex */
public class JSBError {
    public String bridgeName;
    public String errorActivity;
    public int errorCode;
    public String errorMessage;
    public String errorUrl;
    public String eventType;
    public int isSync;

    public JSBError() {
    }

    public JSBError(int i, int i2, String str, String str2, String str3, String str4, String str5) {
        this.isSync = i;
        this.errorCode = i2;
        this.eventType = str;
        this.errorMessage = str2;
        this.bridgeName = str3;
        this.errorUrl = str4;
        this.errorActivity = str5;
    }

    public String toString() {
        return "JSBError{isSync=" + this.isSync + ", errorCode=" + this.errorCode + ", eventType='" + this.eventType + "', errorMessage='" + this.errorMessage + "', bridgeName='" + this.bridgeName + "', errorUrl='" + this.errorUrl + "', errorActivity='" + this.errorActivity + "'}";
    }
}
