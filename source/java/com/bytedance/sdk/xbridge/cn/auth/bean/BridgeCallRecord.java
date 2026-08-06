package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J.\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeCallRecord;", "", "lastCallTimeStamp", "", "callTimes", "", "callFreqTimes", "(Ljava/lang/Long;II)V", "getCallFreqTimes", "()I", "getCallTimes", "getLastCallTimeStamp", "()Ljava/lang/Long;", "Ljava/lang/Long;", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;II)Lcom/bytedance/sdk/xbridge/cn/auth/bean/BridgeCallRecord;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BridgeCallRecord {
    private final int callFreqTimes;
    private final int callTimes;
    private final Long lastCallTimeStamp;

    public static /* synthetic */ BridgeCallRecord copy$default(BridgeCallRecord bridgeCallRecord, Long l, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            l = bridgeCallRecord.lastCallTimeStamp;
        }
        if ((i3 & 2) != 0) {
            i = bridgeCallRecord.callTimes;
        }
        if ((i3 & 4) != 0) {
            i2 = bridgeCallRecord.callFreqTimes;
        }
        return bridgeCallRecord.copy(l, i, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getLastCallTimeStamp() {
        return this.lastCallTimeStamp;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCallTimes() {
        return this.callTimes;
    }

    /* renamed from: component3, reason: from getter */
    public final int getCallFreqTimes() {
        return this.callFreqTimes;
    }

    public final BridgeCallRecord copy(Long lastCallTimeStamp, int callTimes, int callFreqTimes) {
        return new BridgeCallRecord(lastCallTimeStamp, callTimes, callFreqTimes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BridgeCallRecord)) {
            return false;
        }
        BridgeCallRecord bridgeCallRecord = (BridgeCallRecord) other;
        return Intrinsics.areEqual(this.lastCallTimeStamp, bridgeCallRecord.lastCallTimeStamp) && this.callTimes == bridgeCallRecord.callTimes && this.callFreqTimes == bridgeCallRecord.callFreqTimes;
    }

    public int hashCode() {
        Long l = this.lastCallTimeStamp;
        return ((((l == null ? 0 : l.hashCode()) * 31) + Integer.hashCode(this.callTimes)) * 31) + Integer.hashCode(this.callFreqTimes);
    }

    public String toString() {
        return "BridgeCallRecord(lastCallTimeStamp=" + this.lastCallTimeStamp + ", callTimes=" + this.callTimes + ", callFreqTimes=" + this.callFreqTimes + ')';
    }

    public BridgeCallRecord(Long l, int i, int i2) {
        this.lastCallTimeStamp = l;
        this.callTimes = i;
        this.callFreqTimes = i2;
    }

    public /* synthetic */ BridgeCallRecord(Long l, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(l, (i3 & 2) != 0 ? 1 : i, (i3 & 4) != 0 ? 1 : i2);
    }

    public final Long getLastCallTimeStamp() {
        return this.lastCallTimeStamp;
    }

    public final int getCallTimes() {
        return this.callTimes;
    }

    public final int getCallFreqTimes() {
        return this.callFreqTimes;
    }
}
