package com.bytedance.trae.conversation.tracker;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DeviceEvents.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/trae/conversation/tracker/DevicePairingTerminalResult;", "", "durationMillis", "", "isSuccess", "", "resultDetail", "Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;", "<init>", "(JZLcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;)V", "getDurationMillis", "()J", "()Z", "getResultDetail", "()Lcom/bytedance/trae/conversation/tracker/DevicePairResultDetail;", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DevicePairingTerminalResult {
    private final long durationMillis;
    private final boolean isSuccess;
    private final DevicePairResultDetail resultDetail;

    public static /* synthetic */ DevicePairingTerminalResult copy$default(DevicePairingTerminalResult devicePairingTerminalResult, long j, boolean z, DevicePairResultDetail devicePairResultDetail, int i, Object obj) {
        if ((i & 1) != 0) {
            j = devicePairingTerminalResult.durationMillis;
        }
        if ((i & 2) != 0) {
            z = devicePairingTerminalResult.isSuccess;
        }
        if ((i & 4) != 0) {
            devicePairResultDetail = devicePairingTerminalResult.resultDetail;
        }
        return devicePairingTerminalResult.copy(j, z, devicePairResultDetail);
    }

    /* renamed from: component1, reason: from getter */
    public final long getDurationMillis() {
        return this.durationMillis;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsSuccess() {
        return this.isSuccess;
    }

    /* renamed from: component3, reason: from getter */
    public final DevicePairResultDetail getResultDetail() {
        return this.resultDetail;
    }

    public final DevicePairingTerminalResult copy(long durationMillis, boolean isSuccess, DevicePairResultDetail resultDetail) {
        Intrinsics.checkNotNullParameter(resultDetail, "resultDetail");
        return new DevicePairingTerminalResult(durationMillis, isSuccess, resultDetail);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DevicePairingTerminalResult)) {
            return false;
        }
        DevicePairingTerminalResult devicePairingTerminalResult = (DevicePairingTerminalResult) other;
        return this.durationMillis == devicePairingTerminalResult.durationMillis && this.isSuccess == devicePairingTerminalResult.isSuccess && this.resultDetail == devicePairingTerminalResult.resultDetail;
    }

    public int hashCode() {
        return (((Long.hashCode(this.durationMillis) * 31) + Boolean.hashCode(this.isSuccess)) * 31) + this.resultDetail.hashCode();
    }

    public String toString() {
        return "DevicePairingTerminalResult(durationMillis=" + this.durationMillis + ", isSuccess=" + this.isSuccess + ", resultDetail=" + this.resultDetail + ')';
    }

    public DevicePairingTerminalResult(long j, boolean z, DevicePairResultDetail resultDetail) {
        Intrinsics.checkNotNullParameter(resultDetail, "resultDetail");
        this.durationMillis = j;
        this.isSuccess = z;
        this.resultDetail = resultDetail;
    }

    public final long getDurationMillis() {
        return this.durationMillis;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final DevicePairResultDetail getResultDetail() {
        return this.resultDetail;
    }
}
