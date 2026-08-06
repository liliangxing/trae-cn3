package com.bytedance.gkfs.io;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B1\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\u0002\u0010\bJ\u0015\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u0015\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0003J5\u0010\u0010\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSChunkIOStatistics;", "", "timeCost", "", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "", "storageCost", "Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "(Ljava/util/Map;Ljava/util/Map;)V", "indexTimeCost", "getIndexTimeCost", "()Ljava/util/Map;", "getStorageCost", "getTimeCost", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "Companion", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSChunkIOStatistics {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static final GkFSChunkIOStatistics EMPTY;
    private final Map<ChunkIdentifier, Long> indexTimeCost;
    private final Map<ChunkIdentifier, GkFSChunkStorageInfo> storageCost;
    private final Map<ChunkIdentifier, Long> timeCost;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public GkFSChunkIOStatistics() {
        this(r0, r0, 3, r0);
        Map map = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GkFSChunkIOStatistics copy$default(GkFSChunkIOStatistics gkFSChunkIOStatistics, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            map = gkFSChunkIOStatistics.timeCost;
        }
        if ((i & 2) != 0) {
            map2 = gkFSChunkIOStatistics.storageCost;
        }
        return gkFSChunkIOStatistics.copy(map, map2);
    }

    public final Map<ChunkIdentifier, Long> component1() {
        return this.timeCost;
    }

    public final Map<ChunkIdentifier, GkFSChunkStorageInfo> component2() {
        return this.storageCost;
    }

    public final GkFSChunkIOStatistics copy(Map<ChunkIdentifier, Long> timeCost, Map<ChunkIdentifier, GkFSChunkStorageInfo> storageCost) {
        Intrinsics.checkParameterIsNotNull(timeCost, "timeCost");
        Intrinsics.checkParameterIsNotNull(storageCost, "storageCost");
        return new GkFSChunkIOStatistics(timeCost, storageCost);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSChunkIOStatistics)) {
            return false;
        }
        GkFSChunkIOStatistics gkFSChunkIOStatistics = (GkFSChunkIOStatistics) other;
        return Intrinsics.areEqual(this.timeCost, gkFSChunkIOStatistics.timeCost) && Intrinsics.areEqual(this.storageCost, gkFSChunkIOStatistics.storageCost);
    }

    public int hashCode() {
        Map<ChunkIdentifier, Long> map = this.timeCost;
        int hashCode = (map != null ? map.hashCode() : 0) * 31;
        Map<ChunkIdentifier, GkFSChunkStorageInfo> map2 = this.storageCost;
        return hashCode + (map2 != null ? map2.hashCode() : 0);
    }

    public GkFSChunkIOStatistics(Map<ChunkIdentifier, Long> map, Map<ChunkIdentifier, GkFSChunkStorageInfo> map2) {
        Intrinsics.checkParameterIsNotNull(map, "timeCost");
        Intrinsics.checkParameterIsNotNull(map2, "storageCost");
        this.timeCost = map;
        this.storageCost = map2;
        Set<Map.Entry<ChunkIdentifier, GkFSChunkStorageInfo>> entrySet = map2.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(entry.getKey(), Long.valueOf(((GkFSChunkStorageInfo) entry.getValue()).getIndexing().getTimeCost()));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        this.indexTimeCost = linkedHashMap;
    }

    public /* synthetic */ GkFSChunkIOStatistics(Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt.emptyMap() : map, (i & 2) != 0 ? MapsKt.emptyMap() : map2);
    }

    public final Map<ChunkIdentifier, Long> getTimeCost() {
        return this.timeCost;
    }

    public final Map<ChunkIdentifier, GkFSChunkStorageInfo> getStorageCost() {
        return this.storageCost;
    }

    /* compiled from: meta.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSChunkIOStatistics$Companion;", "", "()V", "EMPTY", "Lcom/bytedance/gkfs/io/GkFSChunkIOStatistics;", "getEMPTY", "()Lcom/bytedance/gkfs/io/GkFSChunkIOStatistics;", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final GkFSChunkIOStatistics getEMPTY() {
            return GkFSChunkIOStatistics.EMPTY;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        INSTANCE = new Companion(defaultConstructorMarker);
        EMPTY = new GkFSChunkIOStatistics(defaultConstructorMarker, defaultConstructorMarker, 3, defaultConstructorMarker);
    }

    public final Map<ChunkIdentifier, Long> getIndexTimeCost() {
        return this.indexTimeCost;
    }

    public String toString() {
        return "GkFSChunkIOStatistics(timeCost=" + this.timeCost + ", storageCost=" + this.storageCost + ", indexTimeCost=" + this.indexTimeCost + ')';
    }
}
