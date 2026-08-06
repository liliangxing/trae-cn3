package com.bytedance.timon.clipboard.suite.checker;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: CheckResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\b\u0010\u0019\u001a\u00020\u0005H\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001a"}, d2 = {"Lcom/bytedance/timon/clipboard/suite/checker/CheckResult;", "", "intercept", "", "message", "", "certToken", "code", "", "(ZLjava/lang/String;Ljava/lang/String;I)V", "getCertToken", "()Ljava/lang/String;", "getCode", "()I", "getIntercept", "()Z", "getMessage", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "clipboard-suite_release"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final /* data */ class CheckResult {
    private final String certToken;
    private final int code;
    private final boolean intercept;
    private final String message;

    public static /* synthetic */ CheckResult copy$default(CheckResult checkResult, boolean z, String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = checkResult.intercept;
        }
        if ((i2 & 2) != 0) {
            str = checkResult.message;
        }
        if ((i2 & 4) != 0) {
            str2 = checkResult.certToken;
        }
        if ((i2 & 8) != 0) {
            i = checkResult.code;
        }
        return checkResult.copy(z, str, str2, i);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getIntercept() {
        return this.intercept;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCertToken() {
        return this.certToken;
    }

    /* renamed from: component4, reason: from getter */
    public final int getCode() {
        return this.code;
    }

    public final CheckResult copy(boolean intercept, String message, String certToken, int code) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        Intrinsics.checkParameterIsNotNull(certToken, "certToken");
        return new CheckResult(intercept, message, certToken, code);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckResult)) {
            return false;
        }
        CheckResult checkResult = (CheckResult) other;
        return this.intercept == checkResult.intercept && Intrinsics.areEqual(this.message, checkResult.message) && Intrinsics.areEqual(this.certToken, checkResult.certToken) && this.code == checkResult.code;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        boolean z = this.intercept;
        ?? r0 = z;
        if (z) {
            r0 = 1;
        }
        int i = r0 * 31;
        String str = this.message;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.certToken;
        return ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Integer.hashCode(this.code);
    }

    public CheckResult(boolean z, String str, String str2, int i) {
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(str2, "certToken");
        this.intercept = z;
        this.message = str;
        this.certToken = str2;
        this.code = i;
    }

    public final boolean getIntercept() {
        return this.intercept;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getCertToken() {
        return this.certToken;
    }

    public /* synthetic */ CheckResult(boolean z, String str, String str2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, str, str2, (i2 & 8) != 0 ? 0 : i);
    }

    public final int getCode() {
        return this.code;
    }

    public String toString() {
        return StringsKt.trimMargin$default("{\n            |intercept=" + this.intercept + ",\n            |message=" + this.message + ",\n            |certToken=" + this.certToken + ",\n            |code=" + this.code + ",\n            |}", (String) null, 1, (Object) null);
    }
}
