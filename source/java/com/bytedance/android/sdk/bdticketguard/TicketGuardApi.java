package com.bytedance.android.sdk.bdticketguard;

import com.bytedance.applog.GameReportHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TicketGuardApi.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/sdk/bdticketguard/TicketGuardApi;", "", "()V", "<set-?>", "Lcom/bytedance/android/sdk/bdticketguard/TicketGuardService;", "service", "getService", "()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardService;", GameReportHelper.REGISTER, "", "bd_ticket_guard_api_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final class TicketGuardApi {
    public static final TicketGuardApi INSTANCE = new TicketGuardApi();
    private static TicketGuardService service;

    private TicketGuardApi() {
    }

    public final TicketGuardService getService() {
        return service;
    }

    public final void register(TicketGuardService service2) {
        Intrinsics.checkParameterIsNotNull(service2, "service");
        service = service2;
    }
}
