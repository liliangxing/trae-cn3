package com.bytedance.android.sdk.bdticketguard.util;

import com.bytedance.android.sdk.bdticketguard.TicketGuardInnerFrameWork;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"log", "", "msg", "", "bd_ticket_guard_core_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes3.dex */
public final class TicketGuardUtilsKt {
    public static final void log(String msg) {
        Intrinsics.checkParameterIsNotNull(msg, "msg");
        TicketGuardInnerFrameWork.log(msg);
    }
}
