package com.bytedance.android.monitorV2.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UnifyError.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/monitorV2/entity/UnifyError;", "", "unifyErrorDomain", "", "unifyErrorMsg", "", "originCode", "(ILjava/lang/String;I)V", "unifyErrorCode", "getUnifyErrorCode", "()I", "getUnifyErrorDomain", "getUnifyErrorMsg", "()Ljava/lang/String;", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes3.dex */
public final class UnifyError {
    private final int unifyErrorCode;
    private final int unifyErrorDomain;
    private final String unifyErrorMsg;

    public UnifyError() {
        this(0, null, 0, 7, null);
    }

    public UnifyError(int i, String unifyErrorMsg, int i2) {
        Intrinsics.checkNotNullParameter(unifyErrorMsg, "unifyErrorMsg");
        this.unifyErrorDomain = i;
        this.unifyErrorMsg = unifyErrorMsg;
        this.unifyErrorCode = i + i2;
    }

    public /* synthetic */ UnifyError(int i, String str, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UnifyErrorDomain.AnnieXUnifyErrorDomainReserved.getErrorDomain() : i, (i3 & 2) != 0 ? "" : str, (i3 & 4) != 0 ? 0 : i2);
    }

    public final int getUnifyErrorDomain() {
        return this.unifyErrorDomain;
    }

    public final String getUnifyErrorMsg() {
        return this.unifyErrorMsg;
    }

    public final int getUnifyErrorCode() {
        return this.unifyErrorCode;
    }
}
