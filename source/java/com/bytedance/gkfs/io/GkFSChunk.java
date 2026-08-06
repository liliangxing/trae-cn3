package com.bytedance.gkfs.io;

import com.bytedance.forest.model.PreloadConfig;
import com.bytedance.gkfs.storage.GkFSChunkStorageInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: meta.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/bytedance/gkfs/io/GkFSChunk;", "", "meta", "Lcom/bytedance/gkfs/io/GkFSChunkMeta;", "storageInfo", "Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "(Lcom/bytedance/gkfs/io/GkFSChunkMeta;Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;)V", "id", "Lcom/bytedance/gkfs/io/ChunkIdentifier;", "getId", "()Lcom/bytedance/gkfs/io/ChunkIdentifier;", "getMeta", "()Lcom/bytedance/gkfs/io/GkFSChunkMeta;", "getStorageInfo", "()Lcom/bytedance/gkfs/storage/GkFSChunkStorageInfo;", "component1", "component2", "copy", "equals", "", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class GkFSChunk {
    private final ChunkIdentifier id;
    private final GkFSChunkMeta meta;
    private final GkFSChunkStorageInfo storageInfo;

    public static /* synthetic */ GkFSChunk copy$default(GkFSChunk gkFSChunk, GkFSChunkMeta gkFSChunkMeta, GkFSChunkStorageInfo gkFSChunkStorageInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            gkFSChunkMeta = gkFSChunk.meta;
        }
        if ((i & 2) != 0) {
            gkFSChunkStorageInfo = gkFSChunk.storageInfo;
        }
        return gkFSChunk.copy(gkFSChunkMeta, gkFSChunkStorageInfo);
    }

    /* renamed from: component1, reason: from getter */
    public final GkFSChunkMeta getMeta() {
        return this.meta;
    }

    /* renamed from: component2, reason: from getter */
    public final GkFSChunkStorageInfo getStorageInfo() {
        return this.storageInfo;
    }

    public final GkFSChunk copy(GkFSChunkMeta meta, GkFSChunkStorageInfo storageInfo) {
        Intrinsics.checkParameterIsNotNull(meta, "meta");
        Intrinsics.checkParameterIsNotNull(storageInfo, "storageInfo");
        return new GkFSChunk(meta, storageInfo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GkFSChunk)) {
            return false;
        }
        GkFSChunk gkFSChunk = (GkFSChunk) other;
        return Intrinsics.areEqual(this.meta, gkFSChunk.meta) && Intrinsics.areEqual(this.storageInfo, gkFSChunk.storageInfo);
    }

    public int hashCode() {
        GkFSChunkMeta gkFSChunkMeta = this.meta;
        int hashCode = (gkFSChunkMeta != null ? gkFSChunkMeta.hashCode() : 0) * 31;
        GkFSChunkStorageInfo gkFSChunkStorageInfo = this.storageInfo;
        return hashCode + (gkFSChunkStorageInfo != null ? gkFSChunkStorageInfo.hashCode() : 0);
    }

    public String toString() {
        return "GkFSChunk(meta=" + this.meta + ", storageInfo=" + this.storageInfo + ")";
    }

    public GkFSChunk(GkFSChunkMeta gkFSChunkMeta, GkFSChunkStorageInfo gkFSChunkStorageInfo) {
        Intrinsics.checkParameterIsNotNull(gkFSChunkMeta, "meta");
        Intrinsics.checkParameterIsNotNull(gkFSChunkStorageInfo, "storageInfo");
        this.meta = gkFSChunkMeta;
        this.storageInfo = gkFSChunkStorageInfo;
        this.id = gkFSChunkMeta.getId();
    }

    public final GkFSChunkMeta getMeta() {
        return this.meta;
    }

    public final GkFSChunkStorageInfo getStorageInfo() {
        return this.storageInfo;
    }

    public final ChunkIdentifier getId() {
        return this.id;
    }
}
