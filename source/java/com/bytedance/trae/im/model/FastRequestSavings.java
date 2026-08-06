package com.bytedance.trae.im.model;

import com.bytedance.forest.model.PreloadConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ParsedChatMessage.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/bytedance/trae/im/model/FastRequestSavings;", "", "savedTimeSec", "", "savePositions", "totalSaved", "<init>", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)V", "getSavedTimeSec", "()Ljava/lang/Long;", "setSavedTimeSec", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getSavePositions", "setSavePositions", "getTotalSaved", "setTotalSaved", "component1", "component2", "component3", "copy", "(Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;)Lcom/bytedance/trae/im/model/FastRequestSavings;", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "im_mainlandRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class FastRequestSavings {

    @SerializedName("saved_positions")
    private Long savePositions;

    @SerializedName("saved_time_sec")
    private Long savedTimeSec;

    @SerializedName("total_saved")
    private Long totalSaved;

    public FastRequestSavings() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ FastRequestSavings copy$default(FastRequestSavings fastRequestSavings, Long l, Long l2, Long l3, int i, Object obj) {
        if ((i & 1) != 0) {
            l = fastRequestSavings.savedTimeSec;
        }
        if ((i & 2) != 0) {
            l2 = fastRequestSavings.savePositions;
        }
        if ((i & 4) != 0) {
            l3 = fastRequestSavings.totalSaved;
        }
        return fastRequestSavings.copy(l, l2, l3);
    }

    /* renamed from: component1, reason: from getter */
    public final Long getSavedTimeSec() {
        return this.savedTimeSec;
    }

    /* renamed from: component2, reason: from getter */
    public final Long getSavePositions() {
        return this.savePositions;
    }

    /* renamed from: component3, reason: from getter */
    public final Long getTotalSaved() {
        return this.totalSaved;
    }

    public final FastRequestSavings copy(Long savedTimeSec, Long savePositions, Long totalSaved) {
        return new FastRequestSavings(savedTimeSec, savePositions, totalSaved);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FastRequestSavings)) {
            return false;
        }
        FastRequestSavings fastRequestSavings = (FastRequestSavings) other;
        return Intrinsics.areEqual(this.savedTimeSec, fastRequestSavings.savedTimeSec) && Intrinsics.areEqual(this.savePositions, fastRequestSavings.savePositions) && Intrinsics.areEqual(this.totalSaved, fastRequestSavings.totalSaved);
    }

    public int hashCode() {
        Long l = this.savedTimeSec;
        int hashCode = (l == null ? 0 : l.hashCode()) * 31;
        Long l2 = this.savePositions;
        int hashCode2 = (hashCode + (l2 == null ? 0 : l2.hashCode())) * 31;
        Long l3 = this.totalSaved;
        return hashCode2 + (l3 != null ? l3.hashCode() : 0);
    }

    public String toString() {
        return "FastRequestSavings(savedTimeSec=" + this.savedTimeSec + ", savePositions=" + this.savePositions + ", totalSaved=" + this.totalSaved + ')';
    }

    public FastRequestSavings(Long l, Long l2, Long l3) {
        this.savedTimeSec = l;
        this.savePositions = l2;
        this.totalSaved = l3;
    }

    public /* synthetic */ FastRequestSavings(Long l, Long l2, Long l3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : l, (i & 2) != 0 ? null : l2, (i & 4) != 0 ? null : l3);
    }

    public final Long getSavedTimeSec() {
        return this.savedTimeSec;
    }

    public final void setSavedTimeSec(Long l) {
        this.savedTimeSec = l;
    }

    public final Long getSavePositions() {
        return this.savePositions;
    }

    public final void setSavePositions(Long l) {
        this.savePositions = l;
    }

    public final Long getTotalSaved() {
        return this.totalSaved;
    }

    public final void setTotalSaved(Long l) {
        this.totalSaved = l;
    }
}
