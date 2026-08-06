package com.bytedance.trae.login.traeauth;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TraeAuthManager.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00060\u0001j\u0002`\u0002B_\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0012\"\u0004\b\u0019\u0010\u001aR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0012\"\u0004\b\u001f\u0010\u001a¨\u0006 "}, d2 = {"Lcom/bytedance/trae/login/traeauth/TraeAuthException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "isRetryable", "", "cause", "", "userFacingMessage", "step", "httpCode", "", "logId", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Throwable;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getMessage", "()Z", "getCause", "()Ljava/lang/Throwable;", "getUserFacingMessage", "getStep", "setStep", "(Ljava/lang/String;)V", "getHttpCode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLogId", "setLogId", "impl_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class TraeAuthException extends Exception {
    private final Throwable cause;
    private final String code;
    private final Integer httpCode;
    private final boolean isRetryable;
    private String logId;
    private final String message;
    private String step;
    private final String userFacingMessage;

    public final String getCode() {
        return this.code;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.message;
    }

    /* renamed from: isRetryable, reason: from getter */
    public final boolean getIsRetryable() {
        return this.isRetryable;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }

    public final String getUserFacingMessage() {
        return this.userFacingMessage;
    }

    public final String getStep() {
        return this.step;
    }

    public final void setStep(String str) {
        this.step = str;
    }

    public /* synthetic */ TraeAuthException(String str, String str2, boolean z, Throwable th, String str3, String str4, Integer num, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? false : z, (i & 8) != 0 ? null : th, (i & 16) != 0 ? null : str3, (i & 32) != 0 ? null : str4, (i & 64) != 0 ? 0 : num, (i & 128) != 0 ? null : str5);
    }

    public final Integer getHttpCode() {
        return this.httpCode;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final void setLogId(String str) {
        this.logId = str;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TraeAuthException(String str, String message, boolean z, Throwable th, String str2, String str3, Integer num, String str4) {
        super(message, th);
        Intrinsics.checkNotNullParameter(message, "message");
        this.code = str;
        this.message = message;
        this.isRetryable = z;
        this.cause = th;
        this.userFacingMessage = str2;
        this.step = str3;
        this.httpCode = num;
        this.logId = str4;
    }
}
