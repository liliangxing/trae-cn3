package com.bytedance.trae.conversation;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;

/* compiled from: DeviceCountEventTracker.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/bytedance/trae/conversation/DeviceCountSnapshot;", "", "legacyTotal", "", "workCount", "ideCount", "<init>", "(III)V", "getLegacyTotal", "()I", "getWorkCount", "getIdeCount", "component1", "component2", "component3", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "conversation_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class DeviceCountSnapshot {
    private final int ideCount;
    private final int legacyTotal;
    private final int workCount;

    public static /* synthetic */ DeviceCountSnapshot copy$default(DeviceCountSnapshot deviceCountSnapshot, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = deviceCountSnapshot.legacyTotal;
        }
        if ((i4 & 2) != 0) {
            i2 = deviceCountSnapshot.workCount;
        }
        if ((i4 & 4) != 0) {
            i3 = deviceCountSnapshot.ideCount;
        }
        return deviceCountSnapshot.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getLegacyTotal() {
        return this.legacyTotal;
    }

    /* renamed from: component2, reason: from getter */
    public final int getWorkCount() {
        return this.workCount;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIdeCount() {
        return this.ideCount;
    }

    public final DeviceCountSnapshot copy(int legacyTotal, int workCount, int ideCount) {
        return new DeviceCountSnapshot(legacyTotal, workCount, ideCount);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceCountSnapshot)) {
            return false;
        }
        DeviceCountSnapshot deviceCountSnapshot = (DeviceCountSnapshot) other;
        return this.legacyTotal == deviceCountSnapshot.legacyTotal && this.workCount == deviceCountSnapshot.workCount && this.ideCount == deviceCountSnapshot.ideCount;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.legacyTotal) * 31) + Integer.hashCode(this.workCount)) * 31) + Integer.hashCode(this.ideCount);
    }

    public String toString() {
        return "DeviceCountSnapshot(legacyTotal=" + this.legacyTotal + ", workCount=" + this.workCount + ", ideCount=" + this.ideCount + ')';
    }

    public DeviceCountSnapshot(int i, int i2, int i3) {
        this.legacyTotal = i;
        this.workCount = i2;
        this.ideCount = i3;
    }

    public final int getLegacyTotal() {
        return this.legacyTotal;
    }

    public final int getWorkCount() {
        return this.workCount;
    }

    public final int getIdeCount() {
        return this.ideCount;
    }
}
