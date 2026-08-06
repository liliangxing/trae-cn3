package com.bytedance.gkfs.storage;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: indexing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/gkfs/storage/ChunkBlockIndexingInfo;", "", "offset", "", "size", "", "(JI)V", "getOffset", "()J", "getSize", "()I", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: classes3.dex */
public final /* data */ class ChunkBlockIndexingInfo {
    private final long offset;
    private final int size;

    public ChunkBlockIndexingInfo() {
        this(0L, 0, 3, null);
    }

    public static /* synthetic */ ChunkBlockIndexingInfo copy$default(ChunkBlockIndexingInfo chunkBlockIndexingInfo, long j, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j = chunkBlockIndexingInfo.offset;
        }
        if ((i2 & 2) != 0) {
            i = chunkBlockIndexingInfo.size;
        }
        return chunkBlockIndexingInfo.copy(j, i);
    }

    /* renamed from: component1, reason: from getter */
    public final long getOffset() {
        return this.offset;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final ChunkBlockIndexingInfo copy(long offset, int size) {
        return new ChunkBlockIndexingInfo(offset, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChunkBlockIndexingInfo)) {
            return false;
        }
        ChunkBlockIndexingInfo chunkBlockIndexingInfo = (ChunkBlockIndexingInfo) other;
        return this.offset == chunkBlockIndexingInfo.offset && this.size == chunkBlockIndexingInfo.size;
    }

    public int hashCode() {
        long j = this.offset;
        return (((int) (j ^ (j >>> 32))) * 31) + this.size;
    }

    public String toString() {
        return "ChunkBlockIndexingInfo(offset=" + this.offset + ", size=" + this.size + ")";
    }

    public ChunkBlockIndexingInfo(long j, int i) {
        this.offset = j;
        this.size = i;
    }

    public final long getOffset() {
        return this.offset;
    }

    public /* synthetic */ ChunkBlockIndexingInfo(long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 0L : j, (i2 & 2) != 0 ? 0 : i);
    }

    public final int getSize() {
        return this.size;
    }
}
