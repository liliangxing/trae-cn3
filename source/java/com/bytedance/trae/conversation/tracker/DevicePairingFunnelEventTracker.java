package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0007R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DevicePairingFunnelEventTracker;", "", "initiallyStep1Reported", "", "initiallyStep2Reported", "onStep1Completed", "Lkotlin/Function0;", "", "onStep2Shown", "<init>", "(ZZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "step1Gate", "Lcom/bytedance/trae/conversation/tracker/DeviceEventGate;", "step2Gate", "isStep1Reported", "()Z", "isStep2Reported", "onAuthorizationStepAvailable", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DevicePairingFunnelEventTracker {
    private final Function0<Unit> onStep1Completed;
    private final Function0<Unit> onStep2Shown;
    private final DeviceEventGate step1Gate;
    private final DeviceEventGate step2Gate;

    public DevicePairingFunnelEventTracker(boolean z, boolean z2, Function0<Unit> onStep1Completed, Function0<Unit> onStep2Shown) {
        Intrinsics.checkNotNullParameter(onStep1Completed, "onStep1Completed");
        Intrinsics.checkNotNullParameter(onStep2Shown, "onStep2Shown");
        this.onStep1Completed = onStep1Completed;
        this.onStep2Shown = onStep2Shown;
        this.step1Gate = new DeviceEventGate(z);
        this.step2Gate = new DeviceEventGate(z2);
    }

    public /* synthetic */ DevicePairingFunnelEventTracker(boolean z, boolean z2, Function0 function0, Function0 function02, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, function0, function02);
    }

    public final boolean isStep1Reported() {
        return this.step1Gate.getIsConsumed();
    }

    public final boolean isStep2Reported() {
        return this.step2Gate.getIsConsumed();
    }

    public final synchronized void onAuthorizationStepAvailable() {
        if (this.step1Gate.tryConsume()) {
            this.onStep1Completed.invoke();
        }
        if (this.step2Gate.tryConsume()) {
            this.onStep2Shown.invoke();
        }
    }
}
