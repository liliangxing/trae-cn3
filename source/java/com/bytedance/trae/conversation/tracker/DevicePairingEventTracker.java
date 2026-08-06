package com.bytedance.trae.conversation.tracker;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0011\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000bJ\u0018\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DevicePairingEventTracker;", "", "startedAtMillis", "", "elapsedRealtime", "Lkotlin/Function0;", "onResult", "Lkotlin/Function1;", "Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;", "", "initiallyReported", "", "<init>", "(JLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Z)V", "value", "isReported", "()Z", "onPairingSucceeded", "onPairingExited", "step1Completed", "report", "isSuccess", "resultDetail", "Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes5.dex */
public final class DevicePairingEventTracker {
    private final Function0<Long> elapsedRealtime;
    private boolean isReported;
    private final Function1<DevicePairingTerminalResult, Unit> onResult;
    private final long startedAtMillis;

    /* JADX WARN: Multi-variable type inference failed */
    public DevicePairingEventTracker(long j, Function0<Long> function0, Function1<? super DevicePairingTerminalResult, Unit> function1, boolean z) {
        Intrinsics.checkNotNullParameter(function0, "elapsedRealtime");
        Intrinsics.checkNotNullParameter(function1, "onResult");
        this.startedAtMillis = j;
        this.elapsedRealtime = function0;
        this.onResult = function1;
        this.isReported = z;
    }

    public /* synthetic */ DevicePairingEventTracker(long j, Function0 function0, Function1 function1, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, function0, function1, (i & 8) != 0 ? false : z);
    }

    /* renamed from: isReported, reason: from getter */
    public final boolean getIsReported() {
        return this.isReported;
    }

    public final synchronized void onPairingSucceeded() {
        report(true, DevicePairResultDetail.STEP2_COMPLETE);
    }

    public final synchronized void onPairingExited(boolean step1Completed) {
        DevicePairResultDetail devicePairResultDetail;
        if (step1Completed) {
            devicePairResultDetail = DevicePairResultDetail.STEP1_COMPLETE;
        } else {
            devicePairResultDetail = DevicePairResultDetail.STEP1_INCOMPLETE;
        }
        report(false, devicePairResultDetail);
    }

    private final void report(boolean isSuccess, DevicePairResultDetail resultDetail) {
        if (this.isReported) {
            return;
        }
        this.isReported = true;
        this.onResult.invoke(new DevicePairingTerminalResult(RangesKt.coerceAtLeast(((Number) this.elapsedRealtime.invoke()).longValue() - this.startedAtMillis, 0L), isSuccess, resultDetail));
    }
}
