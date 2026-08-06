package com.bytedance.trae.login.enterprise;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EnterpriseAuthManager.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00060\u0001j\u0002`\u0002B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/bytedance/trae/login/enterprise/EnterpriseAuthException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "userMessage", "errorCode", "", "failedStep", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getUserMessage", "getErrorCode", "()I", "getFailedStep", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class EnterpriseAuthException extends Exception {
    private final int errorCode;
    private final String failedStep;
    private final String message;
    private final String userMessage;

    public /* synthetic */ EnterpriseAuthException(String str, String str2, int i, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i2 & 4) != 0 ? 0 : i, (i2 & 8) != 0 ? null : str3);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    public final String getUserMessage() {
        return this.userMessage;
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getFailedStep() {
        return this.failedStep;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EnterpriseAuthException(String message, String userMessage, int i, String str) {
        super(message);
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(userMessage, "userMessage");
        this.message = message;
        this.userMessage = userMessage;
        this.errorCode = i;
        this.failedStep = str;
    }
}
