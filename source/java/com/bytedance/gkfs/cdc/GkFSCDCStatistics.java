package com.bytedance.gkfs.cdc;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.io.ChunkIdentifier;
import com.bytedance.gkfs.io.GkFSStatus;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: chunker.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 %2\u00020\u0001:\u0001%BY\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\u0015\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J]\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\f\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006&"}, d2 = {"Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "", "status", "Lcom/bytedance/gkfs/io/GkFSStatus;", "minSizeSuppress", "", "maxSizeSuppress", "chunkCDCTimeCost", "", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "", "chunkTimeCost", "totalTimeCost", "(Lcom/bytedance/gkfs/io/GkFSStatus;IILjava/util/Map;Ljava/util/Map;J)V", "getChunkCDCTimeCost", "()Ljava/util/Map;", "getChunkTimeCost", "getMaxSizeSuppress", "()I", "getMinSizeSuppress", "getStatus", "()Lcom/bytedance/gkfs/io/GkFSStatus;", "getTotalTimeCost", "()J", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSCDCStatistics {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final GkFSCDCStatistics EMPTY = new GkFSCDCStatistics(null, 0, 0, null, null, 0, 63, null);
    private final Map<ChunkIdentifier, Long> chunkCDCTimeCost;
    private final Map<ChunkIdentifier, Long> chunkTimeCost;
    private final int maxSizeSuppress;
    private final int minSizeSuppress;
    private final GkFSStatus status;
    private final long totalTimeCost;

    public GkFSCDCStatistics() {
        this(null, 0, 0, null, null, 0L, 63, null);
    }

    public static /* synthetic */ GkFSCDCStatistics copy$default(GkFSCDCStatistics gkFSCDCStatistics, GkFSStatus gkFSStatus, int i, int i2, Map map, Map map2, long j, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            gkFSStatus = gkFSCDCStatistics.status;
        }
        if ((i3 & 2) != 0) {
            i = gkFSCDCStatistics.minSizeSuppress;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = gkFSCDCStatistics.maxSizeSuppress;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            map = gkFSCDCStatistics.chunkCDCTimeCost;
        }
        Map map3 = map;
        if ((i3 & 16) != 0) {
            map2 = gkFSCDCStatistics.chunkTimeCost;
        }
        Map map4 = map2;
        if ((i3 & 32) != 0) {
            j = gkFSCDCStatistics.totalTimeCost;
        }
        return gkFSCDCStatistics.copy(gkFSStatus, i4, i5, map3, map4, j);
    }

    /* renamed from: component1, reason: from getter */
    public final GkFSStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final int getMinSizeSuppress() {
        return this.minSizeSuppress;
    }

    /* renamed from: component3, reason: from getter */
    public final int getMaxSizeSuppress() {
        return this.maxSizeSuppress;
    }

    public final Map<ChunkIdentifier, Long> component4() {
        return this.chunkCDCTimeCost;
    }

    public final Map<ChunkIdentifier, Long> component5() {
        return this.chunkTimeCost;
    }

    /* renamed from: component6, reason: from getter */
    public final long getTotalTimeCost() {
        return this.totalTimeCost;
    }

    public final GkFSCDCStatistics copy(GkFSStatus status, int minSizeSuppress, int maxSizeSuppress, Map<ChunkIdentifier, Long> chunkCDCTimeCost, Map<ChunkIdentifier, Long> chunkTimeCost, long totalTimeCost) {
        Intrinsics.checkParameterIsNotNull(status, "status");
        Intrinsics.checkParameterIsNotNull(chunkCDCTimeCost, "chunkCDCTimeCost");
        Intrinsics.checkParameterIsNotNull(chunkTimeCost, "chunkTimeCost");
        return new GkFSCDCStatistics(status, minSizeSuppress, maxSizeSuppress, chunkCDCTimeCost, chunkTimeCost, totalTimeCost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSCDCStatistics)) {
            return false;
        }
        GkFSCDCStatistics gkFSCDCStatistics = (GkFSCDCStatistics) other;
        return Intrinsics.areEqual(this.status, gkFSCDCStatistics.status) && this.minSizeSuppress == gkFSCDCStatistics.minSizeSuppress && this.maxSizeSuppress == gkFSCDCStatistics.maxSizeSuppress && Intrinsics.areEqual(this.chunkCDCTimeCost, gkFSCDCStatistics.chunkCDCTimeCost) && Intrinsics.areEqual(this.chunkTimeCost, gkFSCDCStatistics.chunkTimeCost) && this.totalTimeCost == gkFSCDCStatistics.totalTimeCost;
    }

    public int hashCode() {
        GkFSStatus gkFSStatus = this.status;
        int hashCode = (((((gkFSStatus != null ? gkFSStatus.hashCode() : 0) * 31) + this.minSizeSuppress) * 31) + this.maxSizeSuppress) * 31;
        Map<ChunkIdentifier, Long> map = this.chunkCDCTimeCost;
        int hashCode2 = (hashCode + (map != null ? map.hashCode() : 0)) * 31;
        Map<ChunkIdentifier, Long> map2 = this.chunkTimeCost;
        int hashCode3 = (hashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
        long j = this.totalTimeCost;
        return hashCode3 + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "GkFSCDCStatistics(status=" + this.status + ", minSizeSuppress=" + this.minSizeSuppress + ", maxSizeSuppress=" + this.maxSizeSuppress + ", chunkCDCTimeCost=" + this.chunkCDCTimeCost + ", chunkTimeCost=" + this.chunkTimeCost + ", totalTimeCost=" + this.totalTimeCost + ")";
    }

    public GkFSCDCStatistics(GkFSStatus gkFSStatus, int i, int i2, Map<ChunkIdentifier, Long> map, Map<ChunkIdentifier, Long> map2, long j) {
        Intrinsics.checkParameterIsNotNull(gkFSStatus, "status");
        Intrinsics.checkParameterIsNotNull(map, "chunkCDCTimeCost");
        Intrinsics.checkParameterIsNotNull(map2, "chunkTimeCost");
        this.status = gkFSStatus;
        this.minSizeSuppress = i;
        this.maxSizeSuppress = i2;
        this.chunkCDCTimeCost = map;
        this.chunkTimeCost = map2;
        this.totalTimeCost = j;
    }

    public /* synthetic */ GkFSCDCStatistics(GkFSStatus gkFSStatus, int i, int i2, Map map, Map map2, long j, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? GkFSStatus.INSTANCE.getSUCCESS() : gkFSStatus, (i3 & 2) != 0 ? 0 : i, (i3 & 4) == 0 ? i2 : 0, (i3 & 8) != 0 ? MapsKt.emptyMap() : map, (i3 & 16) != 0 ? MapsKt.emptyMap() : map2, (i3 & 32) != 0 ? 0L : j);
    }

    public final GkFSStatus getStatus() {
        return this.status;
    }

    public final int getMinSizeSuppress() {
        return this.minSizeSuppress;
    }

    public final int getMaxSizeSuppress() {
        return this.maxSizeSuppress;
    }

    public final Map<ChunkIdentifier, Long> getChunkCDCTimeCost() {
        return this.chunkCDCTimeCost;
    }

    public final Map<ChunkIdentifier, Long> getChunkTimeCost() {
        return this.chunkTimeCost;
    }

    public final long getTotalTimeCost() {
        return this.totalTimeCost;
    }

    /* compiled from: chunker.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics$Companion;", "", "()V", "EMPTY", "Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "getEMPTY", "()Lcom/bytedance/gkfs/cdc/GkFSCDCStatistics;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GkFSCDCStatistics getEMPTY() {
            return GkFSCDCStatistics.EMPTY;
        }
    }
}
