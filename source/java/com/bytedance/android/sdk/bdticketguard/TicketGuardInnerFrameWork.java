package com.bytedance.android.sdk.bdticketguard;

import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardInnerFrameWork;", "", "()V", "manager", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardManager;", "getManager", "()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardManager;", "setManager", "(Lcom/bytedance/android/sdk/bdticketguard/TicketGuardManager;)V", "log", "", "msg", "", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class TicketGuardInnerFrameWork {
    public static final TicketGuardInnerFrameWork INSTANCE = new TicketGuardInnerFrameWork();
    private static TicketGuardManager manager;

    private TicketGuardInnerFrameWork() {
    }

    public final TicketGuardManager getManager() {
        return manager;
    }

    public final void setManager(TicketGuardManager ticketGuardManager) {
        manager = ticketGuardManager;
    }

    @JvmStatic
    public static final void log(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        TicketGuardManager ticketGuardManager = manager;
        if (ticketGuardManager != null) {
            ticketGuardManager.log(msg);
        } else {
            Log.d(TicketGuardManager.LOG_TAG, msg);
        }
    }
}
