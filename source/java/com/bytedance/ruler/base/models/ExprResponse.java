package com.bytedance.ruler.base.models;

import com.bytedance.forest.model.PreloadConfig;
import com.lynx.tasm.LynxError;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExprResponse.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0004HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, d2 = {"Lcom/bytedance/ruler/base/models/ExprResponse;", "", "result", "code", "", "msg", "", LynxError.LYNX_THROWABLE, "", "(Ljava/lang/Object;ILjava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()I", "setCode", "(I)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "getThrowable", "()Ljava/lang/Throwable;", "setThrowable", "(Ljava/lang/Throwable;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "ruler-base_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes4.dex */
public final /* data */ class ExprResponse {
    private int code;
    private String msg;
    private Object result;
    private Throwable throwable;

    public ExprResponse() {
        this(null, 0, null, null, 15, null);
    }

    public static /* synthetic */ ExprResponse copy$default(ExprResponse exprResponse, Object obj, int i, String str, Throwable th, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = exprResponse.result;
        }
        if ((i2 & 2) != 0) {
            i = exprResponse.code;
        }
        if ((i2 & 4) != 0) {
            str = exprResponse.msg;
        }
        if ((i2 & 8) != 0) {
            th = exprResponse.throwable;
        }
        return exprResponse.copy(obj, i, str, th);
    }

    /* renamed from: component1, reason: from getter */
    public final Object getResult() {
        return this.result;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMsg() {
        return this.msg;
    }

    /* renamed from: component4, reason: from getter */
    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final ExprResponse copy(Object result, int code, String msg, Throwable throwable) {
        return new ExprResponse(result, code, msg, throwable);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ExprResponse)) {
            return false;
        }
        ExprResponse exprResponse = (ExprResponse) other;
        return Intrinsics.areEqual(this.result, exprResponse.result) && this.code == exprResponse.code && Intrinsics.areEqual(this.msg, exprResponse.msg) && Intrinsics.areEqual(this.throwable, exprResponse.throwable);
    }

    public int hashCode() {
        Object obj = this.result;
        int hashCode = (((obj != null ? obj.hashCode() : 0) * 31) + Integer.hashCode(this.code)) * 31;
        String str = this.msg;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        Throwable th = this.throwable;
        return hashCode2 + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        return "ExprResponse(result=" + this.result + ", code=" + this.code + ", msg=" + this.msg + ", throwable=" + this.throwable + ")";
    }

    public ExprResponse(Object obj, int i, String str, Throwable th) {
        this.result = obj;
        this.code = i;
        this.msg = str;
        this.throwable = th;
    }

    public final Object getResult() {
        return this.result;
    }

    public final void setResult(Object obj) {
        this.result = obj;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ExprResponse(Object obj, int i, String str, Throwable th, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, i, str, th);
        obj = (i2 & 1) != 0 ? null : obj;
        i = (i2 & 2) != 0 ? 0 : i;
        if ((i2 & 4) != 0) {
            str = null;
        }
        if ((i2 & 8) != 0) {
            th = null;
        }
    }

    public final String getMsg() {
        return this.msg;
    }

    public final void setMsg(String str) {
        this.msg = str;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public final void setThrowable(Throwable th) {
        this.throwable = th;
    }
}
