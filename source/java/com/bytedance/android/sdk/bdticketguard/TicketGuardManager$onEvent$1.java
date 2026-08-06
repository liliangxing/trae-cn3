package com.bytedance.android.sdk.bdticketguard;

import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;

/* compiled from: TicketGuardManager.kt */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
final /* synthetic */ class TicketGuardManager$onEvent$1 extends PropertyReference0 {
    TicketGuardManager$onEvent$1(TicketGuardManager ticketGuardManager) {
        super(ticketGuardManager);
    }

    public String getName() {
        return "ticketGuardInitParam";
    }

    public KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(TicketGuardManager.class);
    }

    public String getSignature() {
        return "getTicketGuardInitParam()Lcom/bytedance/android/sdk/bdticketguard/TicketGuardInitParam;";
    }

    public Object get() {
        return ((TicketGuardManager) this.receiver).getTicketGuardInitParam();
    }
}
