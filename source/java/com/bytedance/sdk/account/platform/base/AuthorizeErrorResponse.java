package com.bytedance.sdk.account.platform.base;

import android.os.Bundle;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* loaded from: classes5.dex */
public class AuthorizeErrorResponse {
    public Bundle extras;
    public boolean isCancel;
    public String logid = "";
    public String platformErrorCode;
    public String platformErrorDetail;
    public String platformErrorMsg;

    public AuthorizeErrorResponse(String str, String str2) {
        this.platformErrorMsg = str2;
        this.platformErrorCode = str;
    }

    public AuthorizeErrorResponse() {
    }

    public AuthorizeErrorResponse(int i, String str) {
        this.platformErrorCode = String.valueOf(i);
        this.platformErrorMsg = str;
    }

    public AuthorizeErrorResponse(String str) {
        this.platformErrorMsg = str;
    }

    public AuthorizeErrorResponse(int i, String str, String str2) {
        this.platformErrorCode = String.valueOf(i);
        this.platformErrorMsg = str;
        this.platformErrorDetail = str2;
    }

    public AuthorizeErrorResponse(boolean z) {
        this.isCancel = z;
    }

    public String toString() {
        return "AuthorizeErrorResponse{logid='" + this.logid + "', isCancel=" + this.isCancel + ", platformErrorCode='" + this.platformErrorCode + "', platformErrorMsg='" + this.platformErrorMsg + "', platformErrorDetail='" + this.platformErrorDetail + "', extras=" + this.extras + AbstractJsonLexerKt.END_OBJ;
    }
}
