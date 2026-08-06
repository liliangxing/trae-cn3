package com.bytedance.sdk.xbridge.cn.calendar.model;

import kotlin.Metadata;

/* compiled from: CalendarErrorCode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017¨\u0006\u0018"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/calendar/model/CalendarErrorCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "Failed", "UnauthorizedInvocation", "UnregisteredMethod", "InvalidParameter", "InvalidResult", "UserRejected", "UserDenied", "Success", "UnauthorizedAccess", "OperationCancelled", "OperationTimeout", "ArgumentError", "NoAccount", "NotFound", "NotImplemented", "AlreadyExists", "Unknown", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public enum CalendarErrorCode {
    Failed(0),
    UnauthorizedInvocation(-1),
    UnregisteredMethod(-2),
    InvalidParameter(-3),
    InvalidResult(-5),
    UserRejected(2),
    UserDenied(6),
    Success(1),
    UnauthorizedAccess(-6),
    OperationCancelled(-7),
    OperationTimeout(-8),
    ArgumentError(100),
    NoAccount(1000),
    NotFound(-9),
    NotImplemented(-10),
    AlreadyExists(-11),
    Unknown(-1000);

    private final int value;

    CalendarErrorCode(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
