package com.bytedance.gkfs.io;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSChunkMeta;", "", "id", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "offset", "", "(Lcom/bytedance/gkfs/io/ChunkIdentifier;J)V", "getId", "()Lcom/bytedance/gkfs/io/ChunkIdentifier;", "getOffset", "()J", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSChunkMeta {
    private final ChunkIdentifier id;
    private final long offset;

    public static /* synthetic */ GkFSChunkMeta copy$default(GkFSChunkMeta gkFSChunkMeta, ChunkIdentifier chunkIdentifier, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            chunkIdentifier = gkFSChunkMeta.id;
        }
        if ((i & 2) != 0) {
            j = gkFSChunkMeta.offset;
        }
        return gkFSChunkMeta.copy(chunkIdentifier, j);
    }

    /* renamed from: component1, reason: from getter */
    public final ChunkIdentifier getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final long getOffset() {
        return this.offset;
    }

    public final GkFSChunkMeta copy(ChunkIdentifier id, long offset) {
        Intrinsics.checkParameterIsNotNull(id, "id");
        return new GkFSChunkMeta(id, offset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSChunkMeta)) {
            return false;
        }
        GkFSChunkMeta gkFSChunkMeta = (GkFSChunkMeta) other;
        return Intrinsics.areEqual(this.id, gkFSChunkMeta.id) && this.offset == gkFSChunkMeta.offset;
    }

    public int hashCode() {
        ChunkIdentifier chunkIdentifier = this.id;
        int hashCode = chunkIdentifier != null ? chunkIdentifier.hashCode() : 0;
        long j = this.offset;
        return (hashCode * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "GkFSChunkMeta(id=" + this.id + ", offset=" + this.offset + ")";
    }

    public GkFSChunkMeta(ChunkIdentifier chunkIdentifier, long j) {
        Intrinsics.checkParameterIsNotNull(chunkIdentifier, "id");
        this.id = chunkIdentifier;
        this.offset = j;
    }

    public final ChunkIdentifier getId() {
        return this.id;
    }

    public final long getOffset() {
        return this.offset;
    }
}
