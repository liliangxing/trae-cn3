package com.bytedance.salamander.anniex;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AnniexMonitorCoreSLLynxJSExceptionParams.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/salamander/anniex/SLLynxJSExceptionParams;", "", "errorMsg", "", "errorCode", "", "(Ljava/lang/String;I)V", "getErrorCode", "()I", "setErrorCode", "(I)V", "getErrorMsg", "()Ljava/lang/String;", "setErrorMsg", "(Ljava/lang/String;)V", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public class SLLynxJSExceptionParams {
    private int errorCode;
    private String errorMsg;

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public void setErrorMsg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.errorMsg = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(int i) {
        this.errorCode = i;
    }

    public SLLynxJSExceptionParams(String errorMsg, int i) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        this.errorMsg = "";
        setErrorMsg(errorMsg);
        setErrorCode(i);
    }
}
