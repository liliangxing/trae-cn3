package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/InitStatus;", "", "()V", "initLock", "Ljava/lang/Object;", "getInitLock", "()Ljava/lang/Object;", "initResult", "", "getInitResult", "()Ljava/lang/Boolean;", "setInitResult", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class InitStatus {
    private final Object initLock = new Object();
    private Boolean initResult;

    public final Boolean getInitResult() {
        return this.initResult;
    }

    public final void setInitResult(Boolean bool) {
        this.initResult = bool;
    }

    public final Object getInitLock() {
        return this.initLock;
    }
}
