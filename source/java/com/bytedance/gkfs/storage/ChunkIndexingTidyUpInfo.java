package com.bytedance.gkfs.storage;

import com.bytedance.forest.model.PreloadConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: indexing.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/bytedance/gkfs/storage/ChunkIndexingTidyUpInfo;", "", "indexingInfo", "Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;", "isTidyUp", "", "needDelete", "(Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;ZZ)V", "getIndexingInfo", "()Lcom/bytedance/gkfs/storage/ChunkIndexingInfo;", "()Z", "getNeedDelete", "component1", "component2", "component3", "copy", "equals", PreloadConfig.KEY_OTHER, "hashCode", "", "toString", "", "geckox_noasanRelease"}, k = 1, mv = {1, 1, 16})
/* loaded from: /data/user/work/trae_cn3_decoded/build/apk/classes3.dex */
public final /* data */ class ChunkIndexingTidyUpInfo {
    private final ChunkIndexingInfo indexingInfo;
    private final boolean isTidyUp;
    private final boolean needDelete;

    public static /* synthetic */ ChunkIndexingTidyUpInfo copy$default(ChunkIndexingTidyUpInfo chunkIndexingTidyUpInfo, ChunkIndexingInfo chunkIndexingInfo, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            chunkIndexingInfo = chunkIndexingTidyUpInfo.indexingInfo;
        }
        if ((i & 2) != 0) {
            z = chunkIndexingTidyUpInfo.isTidyUp;
        }
        if ((i & 4) != 0) {
            z2 = chunkIndexingTidyUpInfo.needDelete;
        }
        return chunkIndexingTidyUpInfo.copy(chunkIndexingInfo, z, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final ChunkIndexingInfo getIndexingInfo() {
        return this.indexingInfo;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsTidyUp() {
        return this.isTidyUp;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getNeedDelete() {
        return this.needDelete;
    }

    public final ChunkIndexingTidyUpInfo copy(ChunkIndexingInfo indexingInfo, boolean isTidyUp, boolean needDelete) {
        Intrinsics.checkParameterIsNotNull(indexingInfo, "indexingInfo");
        return new ChunkIndexingTidyUpInfo(indexingInfo, isTidyUp, needDelete);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChunkIndexingTidyUpInfo)) {
            return false;
        }
        ChunkIndexingTidyUpInfo chunkIndexingTidyUpInfo = (ChunkIndexingTidyUpInfo) other;
        return Intrinsics.areEqual(this.indexingInfo, chunkIndexingTidyUpInfo.indexingInfo) && this.isTidyUp == chunkIndexingTidyUpInfo.isTidyUp && this.needDelete == chunkIndexingTidyUpInfo.needDelete;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        ChunkIndexingInfo chunkIndexingInfo = this.indexingInfo;
        int hashCode = (chunkIndexingInfo != null ? chunkIndexingInfo.hashCode() : 0) * 31;
        boolean z = this.isTidyUp;
        int i = z;
        if (z != 0) {
            i = 1;
        }
        int i2 = (hashCode + i) * 31;
        boolean z2 = this.needDelete;
        return i2 + (z2 ? 1 : z2 ? 1 : 0);
    }

    public String toString() {
        return "ChunkIndexingTidyUpInfo(indexingInfo=" + this.indexingInfo + ", isTidyUp=" + this.isTidyUp + ", needDelete=" + this.needDelete + ")";
    }

    public ChunkIndexingTidyUpInfo(ChunkIndexingInfo chunkIndexingInfo, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(chunkIndexingInfo, "indexingInfo");
        this.indexingInfo = chunkIndexingInfo;
        this.isTidyUp = z;
        this.needDelete = z2;
    }

    public final ChunkIndexingInfo getIndexingInfo() {
        return this.indexingInfo;
    }

    public final boolean isTidyUp() {
        return this.isTidyUp;
    }

    public final boolean getNeedDelete() {
        return this.needDelete;
    }
}
