package com.bytedance.ies.bullet.service.base.lynx;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ILynxClientDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\n\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\n\"\u0004\b\u0011\u0010\u000e¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ies/bullet/service/base/lynx/LynxError;", "", "msg", "", "code", "", "(Ljava/lang/String;I)V", "getCode", "()I", "getMsg", "()Ljava/lang/String;", "templateFilePath", "getTemplateFilePath", "setTemplateFilePath", "(Ljava/lang/String;)V", "templateLoadFrom", "getTemplateLoadFrom", "setTemplateLoadFrom", "toString", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class LynxError {
    private final int code;
    private final String msg;
    private String templateFilePath;
    private String templateLoadFrom = "unknown";

    public LynxError(String str, int i) {
        this.msg = str;
        this.code = i;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getTemplateLoadFrom() {
        return this.templateLoadFrom;
    }

    public final void setTemplateLoadFrom(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.templateLoadFrom = str;
    }

    public final String getTemplateFilePath() {
        return this.templateFilePath;
    }

    public final void setTemplateFilePath(String str) {
        this.templateFilePath = str;
    }

    public String toString() {
        StringBuilder append = new StringBuilder("{\"code\": ").append(this.code).append(",\"msg\": ");
        String str = this.msg;
        if (str == null) {
            str = "";
        }
        StringBuilder append2 = append.append(str).append(", \"templateLoadFrom\": ").append(this.templateLoadFrom).append(", \"templateFilePath\":");
        String str2 = this.templateFilePath;
        return append2.append(str2 != null ? str2 : "").append(' ').toString();
    }
}
