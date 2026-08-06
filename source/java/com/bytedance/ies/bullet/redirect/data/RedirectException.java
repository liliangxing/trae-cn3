package com.bytedance.ies.bullet.redirect.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RedirectException.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000fB'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0019\u0010\u0007\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ies/bullet/redirect/data/RedirectException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "msg", "", "exception", "(ILjava/lang/String;Ljava/lang/Exception;)V", "getCode", "()I", "getException", "()Ljava/lang/Exception;", "getMsg", "()Ljava/lang/String;", "Companion", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public final class RedirectException extends Exception {
    public static final int FORMAT_SCHEMA_ERROR = 5;
    public static final int NO_ENTRY = 1;
    public static final int NO_ENTRY_CONFIG = 3;
    public static final int NO_ERROR = 0;
    public static final int NO_MATCH_RULE = 4;
    public static final int NO_SOURCE_CONFIG = 2;
    public static final int UNKNOWN = -1;
    private final int code;
    private final Exception exception;
    private final String msg;

    public /* synthetic */ RedirectException(int i, String str, Exception exc, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : exc);
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final Exception getException() {
        return this.exception;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RedirectException(int i, String msg, Exception exc) {
        super(msg, exc);
        Intrinsics.checkNotNullParameter(msg, "msg");
        this.code = i;
        this.msg = msg;
        this.exception = exc;
    }
}
