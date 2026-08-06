package com.bytedance.sdk.xbridge.cn.auth.bean;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: BridgeCallRecord.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/sdk/xbridge/cn/auth/bean/LimitRecord;", "", "spendTimestamp", "", "count", "", "(JI)V", "getCount", "()I", "getSpendTimestamp", "()J", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "anniex_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class LimitRecord {
    private final int count;
    private final long spendTimestamp;

    public static /* synthetic */ LimitRecord copy$default(LimitRecord limitRecord, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = limitRecord.spendTimestamp;
        }
        if ((i2 & 2) != 0) {
            i = limitRecord.count;
        }
        return limitRecord.copy(j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getSpendTimestamp() {
        return this.spendTimestamp;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final LimitRecord copy(long spendTimestamp, int count) {
        return new LimitRecord(spendTimestamp, count);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LimitRecord)) {
            return false;
        }
        LimitRecord limitRecord = (LimitRecord) other;
        return this.spendTimestamp == limitRecord.spendTimestamp && this.count == limitRecord.count;
    }

    public int hashCode() {
        return (Long.hashCode(this.spendTimestamp) * 31) + Integer.hashCode(this.count);
    }

    public String toString() {
        return "LimitRecord(spendTimestamp=" + this.spendTimestamp + ", count=" + this.count + ')';
    }

    public LimitRecord(long j, int i) {
        this.spendTimestamp = j;
        this.count = i;
    }

    public final long getSpendTimestamp() {
        return this.spendTimestamp;
    }

    public final int getCount() {
        return this.count;
    }
}
