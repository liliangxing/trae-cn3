package com.bytedance.salamander.anniex;

import com.bytedance.sdk.xbridge.cn.storage.utils.UserDomainStorageConstants;
import kotlin.Metadata;

/* compiled from: AnniexMonitorEventTypingsInfoJsbErrorEvent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lcom/bytedance/salamander/anniex/JSBErrorCode;", "", "value", "", "(Ljava/lang/String;IJ)V", "getValue", "()J", "SUCCESS", "FAIL", "UNAUTHORIZED", "UNREGISTERED", UserDomainStorageConstants.INVALID_PARAM, "UNKNOWN_HOST", "INVALID_RESULT", "UNAUTHORIZED_ACCESS", "CANCELLED", "OPERATION_TIMEOUT", "NOT_FOUND", "IDL_ERROR", "HANDLE_ERROR", "EXCEPTION_THROWN", "UNKNOWN_ERROR", "NETWORK_UNREACHABLE", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes4.dex */
public enum JSBErrorCode {
    SUCCESS(1),
    FAIL(0),
    UNAUTHORIZED(-1),
    UNREGISTERED(-2),
    INVALID_PARAM(-3),
    UNKNOWN_HOST(-4),
    INVALID_RESULT(-5),
    UNAUTHORIZED_ACCESS(-6),
    CANCELLED(-7),
    OPERATION_TIMEOUT(-8),
    NOT_FOUND(-9),
    IDL_ERROR(-10),
    HANDLE_ERROR(-11),
    EXCEPTION_THROWN(-999),
    UNKNOWN_ERROR(-1000),
    NETWORK_UNREACHABLE(-1001);

    private final long value;

    JSBErrorCode(long j) {
        this.value = j;
    }

    public final long getValue() {
        return this.value;
    }
}
